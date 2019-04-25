package com.yzjk.system.fileupload.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yzjk.common.conf.FileUploadPath;

@Controller
@RequestMapping("/file")
public class UploadController {
	   @Autowired  FileUploadPath fileUploadPath;
	
	@GetMapping("")
	public String uploladPage() {
		return "fileupload/upload";
	}

	@PostMapping("/upload")
	public String fileUpload(HttpServletRequest req, Model model) {
		MultipartFile file = null;
		Map<String, List<MultipartFile>> map =null;
		Map<String,String> fileName = new HashMap<String,String>();
		if (req instanceof MultipartHttpServletRequest) {
			map = ((MultipartHttpServletRequest) req).getMultiFileMap();
			for (String key : map.keySet()) {
				List<MultipartFile> list = map.get(key);
				for (MultipartFile f : list) {
					upload(f, fileName);
				}
			}
		}
		model.addAttribute("fileNames", fileName);
		return "fileupload/ok";
	}
	
	private void upload(MultipartFile file, Map<String, String> map) {
		String msg = "success";
		try {
			String fileName = System.currentTimeMillis() + file.getOriginalFilename();
			// String destFileName = req.getServletContext().getRealPath("") + "uploaded" +
			// File.separator + fileName;
			String destFileName = fileUploadPath.getLocationfileDir() + File.separator + "uploaded"
					+ File.separator + fileName;
			File destFile = new File(destFileName);
			destFile.getParentFile().mkdirs();
			System.out.println(destFile);
			file.transferTo(destFile);
			
			//model.addAttribute("fileName", fileName);
			//model.addAttribute("path", destFile);
			map.put(fileName, destFileName);
		} catch (Exception e) {
			throw new RuntimeException("上传失败," + e.getMessage());
		}
	}
}