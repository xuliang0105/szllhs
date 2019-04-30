package com.yzjk.system.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yzjk.common.conf.FileUploadPath;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/file")
public class DownController {
	 @Autowired  FileUploadPath fileUploadPath;

	 /**
	  * 文件列表
	  * @param model
	  * @return
	  */
	 @RequestMapping("/downFilelist")
	 public String filelist(Model model) {
		 List<File> files = getFileList(fileUploadPath.getLocationfileDir());
		 List<String> list = new ArrayList<String>();
		 
		 for(File f : files) {
			list.add(f.getName());
		 }
		 model.addAttribute("files",list);
		 return "file/filelist";
	 }
	
	 
	 public  List<File> getFileList(String strPath) {
		 	List<File> filelist = new ArrayList<File>();
	        File dir = new File(strPath);
	        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
	        if (files != null) {
	            for (int i = 0; i < files.length; i++) {
	                String fileName = files[i].getName();
	                if (files[i].isDirectory()) { // 判断是文件还是文件夹
	                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
	                } else if (fileName.endsWith("avi")) { // 判断文件名是否以.avi结尾
	                    continue;
	                } else {
	                	String strFileName = files[i].getAbsolutePath();
	                    System.out.println("---" + strFileName);
	                    filelist.add(files[i]);
	                }
	            }

	        }
	        return filelist;
	    }


	@RequestMapping("/downZip")
	public String down(HttpServletResponse response) throws Exception {

		List files = new ArrayList();
		File file1 = new File("C:\\Users\\Liang Qizhao\\Desktop\\劳动合同.doc");
		File file2 = new File("C:\\Users\\Liang Qizhao\\Desktop\\数据库设计.doc");

		files.add(file1);
		files.add(file2);
		downLoadFiles(files, response);

		return "成功";
	}

	public static HttpServletResponse downLoadFiles(List<File> files, HttpServletResponse response) throws Exception {

		try {
			// List<File> 作为参数传进来，就是把多个文件的路径放到一个list里面
			// 创建一个临时压缩文件

			// 临时文件可以放在CDEF盘中，但不建议这么做，因为需要先设置磁盘的访问权限，最好是放在服务器上，方法最后有删除临时文件的步骤

			String zipFilename = "D:/tempFile.zip";
			File file = new File(zipFilename);
			file.createNewFile();
			if (!file.exists()) {
				file.createNewFile();
			}
			response.reset();
			// response.getWriter()
			// 创建文件输出流
			FileOutputStream fous = new FileOutputStream(file);
			ZipOutputStream zipOut = new ZipOutputStream(fous);
			zipFile(files, zipOut);
			zipOut.close();
			fous.close();
			return downloadZip(file, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 把接受的全部文件打成压缩包
	 * 
	 * @param List<File>;
	 * @param org.apache.tools.zip.ZipOutputStream
	 */
	public static void zipFile(List files, ZipOutputStream outputStream) {
		int size = files.size();
		for (int i = 0; i < size; i++) {
			File file = (File) files.get(i);
			zipFile(file, outputStream);
		}
	}

	/**
	 * 根据输入的文件与输出流对文件进行打包
	 * 
	 * @param File
	 * @param org.apache.tools.zip.ZipOutputStream
	 */
	public static void zipFile(File inputFile, ZipOutputStream ouputStream) {
		try {
			if (inputFile.exists()) {
				if (inputFile.isFile()) {
					FileInputStream IN = new FileInputStream(inputFile);
					BufferedInputStream bins = new BufferedInputStream(IN, 512);
					ZipEntry entry = new ZipEntry(inputFile.getName());
					ouputStream.putNextEntry(entry);
					// 向压缩文件中输出数据
					int nNumber;
					byte[] buffer = new byte[512];
					while ((nNumber = bins.read(buffer)) != -1) {
						ouputStream.write(buffer, 0, nNumber);
					}
					// 关闭创建的流对象
					bins.close();
					IN.close();
				} else {
					try {
						File[] files = inputFile.listFiles();
						for (int i = 0; i < files.length; i++) {
							zipFile(files[i], ouputStream);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HttpServletResponse downloadZip(File file, HttpServletResponse response) {
		if (file.exists() == false) {
			System.out.println("待压缩的文件目录：" + file + "不存在.");
		} else {
			try {
				// 以流的形式下载文件。
				InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
				// 清空response
				response.reset();

				OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");

				// 如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String(file.getName().getBytes("GB2312"), "ISO8859-1"));
				toClient.write(buffer);
				toClient.flush();
				toClient.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					File f = new File(file.getPath());
					f.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return response;
	}


	@RequestMapping("/downfile")
	@ResponseBody
	public void downLoad(HttpServletResponse response,String filename,String filePath){
	    //String filename="劳动合同.doc";
	    //String filePath = "C:\\Users\\Liang Qizhao\\Desktop\\" ;
		//filePath/uploaded
		filePath = fileUploadPath.getLocationfileDir()+File.separator+"uploaded";
		
		if(StringUtils.isNotEmpty(filename) && StringUtils.isNotEmpty(filePath)) {
			 System.out.println("----------filedown  文件名和地址不能为空");
		}
		
	    File file = new File(filePath + "/" + filename);
	    if(file.exists()){ //判断文件父目录是否存在
	    	try {
			filename = java.net.URLEncoder.encode(filename, "UTF-8");
			filename = new String(filename.getBytes(), "iso-8859-1");
	        response.setContentType("application/force-download");
	        response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
	        
	        byte[] buffer = new byte[1024];
	        FileInputStream fis = null; //文件输入流
	        BufferedInputStream bis = null;
	        
	        OutputStream os = null; //输出流
	       
	            os = response.getOutputStream();
	            fis = new FileInputStream(file); 
	            bis = new BufferedInputStream(fis);
	            int i = bis.read(buffer);
	            while(i != -1){
	                os.write(buffer);
	                i = bis.read(buffer);
	            }
	            bis.close();
	            fis.close();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println("----------file download" + filename);
	    }
	}


}
