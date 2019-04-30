/*
 Navicat Premium Data Transfer

 Source Server         : jlmysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : 192.168.2.180:3306
 Source Schema         : llhs

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 30/04/2019 17:38:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for disease_info
-- ----------------------------
DROP TABLE IF EXISTS `disease_info`;
CREATE TABLE `disease_info`  (
  `disease_id` bigint(20) NOT NULL,
  `disease_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '疾病名称',
  `disease_other_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '疾病其它名称',
  `diseaseLogo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '疾病图片',
  `spell` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `infectiousness` int(11) NULL DEFAULT NULL COMMENT '传染性',
  `prone_population` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '倾向人群',
  `diseased_part` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '病态部分',
  `disease_summary` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '疾病摘要',
  `disease_cause` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '疾病原因',
  `symptom_description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '症状描述',
  `food_safe` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '食品安全',
  `prevention` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '预防',
  `treatment` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '治疗',
  `examination_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '检查说明',
  `differential_diagosis` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '鉴别诊断',
  `complication` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '并发症',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`disease_id`) USING BTREE,
  INDEX `fk_disease_info_disease_id`(`disease_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of disease_info
-- ----------------------------
INSERT INTO `disease_info` VALUES (1, '疾病名称', '疾病其它名称', '疾病图片', NULL, 1, '倾向人群', '病态部分', '疾病摘要', '疾病原因', '症状描述', '食品安全', '预防', '治疗', '检查说明', '鉴别诊断', '并发症', '2019-04-23 11:04:07');
INSERT INTO `disease_info` VALUES (2, '哮喘', '支气管哮喘', NULL, NULL, 0, NULL, '在易感者中此种炎症可引起反复发作的喘息、气促、胸闷和(或)咳嗽等症状', '支气管哮喘(bronchial asthma，哮喘)是由多种细胞特别是肥大细胞、嗜酸性粒细胞和T淋巴细胞参与的慢性气道炎症', '　本病的病因较复杂，大多认为是一种多基因遗传病，受遗传因素和环境因素的双重影响。', '(一)遗传因素　哮喘与遗传的关系已日益引起重视。根据家系资料，早期的研究大多认为哮喘是单基因遗传病，有学者认为是常染色体显性遗传(autosomal dominant inheritance)的疾病，也有认为是常染色体隐性遗传(autosomal recessive inheritance)的疾病', NULL, '　1、在明确过敏原后应避免与其再接触。例如：如是由于室内尘埃或螨诱发哮喘的发作，就应保持室内的清洁，勤晒被褥，而且应常开窗户通风，保持室内空气的清新。\r\n\r\n　　2、不宜在室内饲养猫、犬等小动物。', '一、消除病因。\r\n\r\n　　应避免或消除引起哮喘发作的变应原和其他非特异性刺激，去除各种诱发因素。\r\n\r\n　　二、控制急性发作。\r\n\r\n　　哮喘发作时应兼顾解痉、抗炎、去除气道粘液栓，保持呼吸道通畅，防止继发感染。一般可单用或联用下列药物。', '　一、血液常规检查。\r\n\r\n　　可有嗜酸粒细胞增高。如并发感染可有白细胞总数增高，分类中性粒细胞比例增高。\r\n\r\n　　二、痰液检查。\r\n\r\n　　如合并呼吸道细菌感染，痰涂片、细菌培养及药物敏感试验有助于病原菌诊断及指导治疗。\r\n\r\n　　三、呼吸功能检查。', '　支气管哮喘应注意与喘息性支气管炎、左心衰竭产生的心源性哮喘、由于大气道肿瘤产生气道梗阻的呼吸困难、肺嗜酸粒细胞浸润症以及小儿细支气管炎引起的喘鸣相鉴别。', '急性并发症\r\n\r\n　　1、 猝死 猝死是支气管哮喘最严重的并发症，因其常常无明显先兆症状，一旦突然发生，往往来不及抢救而死亡。', '2019-04-22 11:11:46');
INSERT INTO `disease_info` VALUES (3, '糖尿病', '糖尿病', NULL, NULL, 0, '无', '糖尿病是由遗传和环境因素相互作用而引起的常见病，临床以高血糖为主要标志，常见症状有多饮、多尿、多食以及消瘦等', '糖尿病若得不到有效的治疗，可引起身体多系统的损害。引起胰岛素绝对或相对分泌不足以及靶组织细胞对胰岛素敏感性降低，引起蛋白质、脂肪、水和电解质等一系列代谢紊乱综合征，其中一高血糖为主要标志。临床典型病例可出现多尿、多饮、多食、消瘦等表现，即“三多一少”症状', '根据病因可分原发和继发性两大类：原发性者占绝大多数，病因和发病机理不明。继发性者占少数，如肢端肥大症中垂体性糖尿病、柯兴综合征中类固醇性糖尿病等。', '典型病例有三多症群提示本病。轻症无症状者诊断完全依靠化验，常在健康检查或因其他疾病而偶然发现。不少病者首先发现并发症，然后追溯及本病。但不论有无症状或并发症，关键在于首先考虑到本病的可能性而进行尿、血糖检查，方可确诊。', NULL, '糖尿病的预防，应构筑三道“防线”，在医学上称之为三级预防。如果“防线”布设、构筑得及时、合理和牢固，大部分糖尿病是有可能预防或控制的。', '近年来虽对遗传问题、病毒感染、自身免疫和拮抗胰岛素的激素等许多病因学上问题进行研究，但至今尚乏病因治疗措施，环孢霉素A（cyclosporin A）仅对少数早期Ⅰ型病例有效，胰岛移植及胰腺移植仅初见成效，人工胰脏（胰岛素泵），虽能较好控制代谢，但对长期防治慢性并发症尚乏可靠数据', '(一)尿\r\n\r\n　　1.糖尿　重症病例治前经常有糖尿，但早期轻症仅见于餐后或有感染等应激情况下，不少久病者由于肾糖阈升高，虽有高血糖而无糖尿。尿糖可自微量至10g%以上，一般在0.5%～5g%左右，偶可达15g%以上，每日失糖可自微量至数百克。', '鉴别诊断方面须除外下列几种情况：\r\n\r\n　　1.非葡萄糖尿　如乳糖尿见于哺乳或孕妇及幼婴。果糖及戊糖尿偶见于进食大量水果后，为非常罕见的先天性疾患。发现糖尿阳性时，应联系临床情况分析判断，不宜立即肯定为糖尿病。鉴别方法有生化及发酵试验等。', '　(一)糖尿病酮症酸中毒及昏迷\r\n\r\n　　(二)糖尿病非酮症性高渗性昏迷\r\n\r\n　　(三)糖尿病乳酸性酸中毒', '2019-04-21 11:20:44');
INSERT INTO `disease_info` VALUES (6368050780832768, '动脉硬化', '动脉粥样硬化', NULL, NULL, 1, 'ewewfrw', '本病发病机理未完全阐明，近年研究虽有进展，但目前仍然是以多种学说或假说从不同角度来阐述', '动脉硬化是随着人年龄增长而出现的血管疾病，其规律通常是在青少年时期发生，至中老年时期加重、发病。男性较女性多，近年来本病在我国逐渐增多，成为老年人死亡主要原因之一', '动脉硬化的原因中最重要的是高血压、高血脂症、抽烟三大危险因子。其他肥胖、糖尿病、运动不足、紧张状态、高龄、家族病史、脾气暴躁等都有关系。', '抽烟：香烟中的尼古丁、一氧化碳等会损伤动脉内壁，受伤的动脉内壁会卡住胆固醇，引起血小板堆积形成脂肪斑块。同时，抽烟也会引起冠状动脉收缩痉挛，减少血流量。', NULL, '减少对脂肪的摄取：应少食\"饱和脂肪酸\"占有量较多的煎炸食物及含\"高胆固醇\"食物的虾、肝、肾和其他内脏，蛋黄等', '已发生并发症者，及时治疗，防止其恶化，延长病人寿命', '本病尚缺乏敏感而又特异性的早期实验室诊断方法', '.缺血期　症状由于血管狭窄、器官缺血而产生', ')冠状动脉粥样硬化者，若管径狭窄达75%以上,则可发生心绞痛、心肌梗塞、心律失常，甚至猝死', '2019-04-24 02:33:49');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `order_detail_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NULL DEFAULT NULL,
  `biz_id` bigint(20) NULL DEFAULT NULL,
  `biz_type` tinyint(4) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `discount_price` decimal(10, 2) NULL DEFAULT NULL,
  `qty` int(11) NULL DEFAULT NULL,
  `item_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `item_pic` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`) USING BTREE,
  INDEX `IXFK_order_detail_order_info`(`order_id`) USING BTREE,
  CONSTRAINT `FK_order_detail_order_info` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (1116183197203382274, 1116183196460990466, 1, 2, 10.00, 8.00, 1, '视频套餐', 'http://www.google.com');
INSERT INTO `order_detail` VALUES (1116243845631193090, 1116243845266288642, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.baidu.com');
INSERT INTO `order_detail` VALUES (1116258396099657730, 1116258395403403265, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.baidu.com');
INSERT INTO `order_detail` VALUES (1116260378352885761, 1116260377727934465, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.baidu.com');
INSERT INTO `order_detail` VALUES (1116261100331016194, 1116261099781562369, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.baidu.com');
INSERT INTO `order_detail` VALUES (1116264288757071874, 1116264288014680065, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.baidu.com');
INSERT INTO `order_detail` VALUES (1116266595750051842, 1116266595200598018, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.baidu.com');
INSERT INTO `order_detail` VALUES (1116267263441338369, 1116267262585700353, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.ifeng.com');
INSERT INTO `order_detail` VALUES (1116268960909692929, 1116268960251187201, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.ifeng.com');
INSERT INTO `order_detail` VALUES (1116269245786853377, 1116269245338062849, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.ifeng.com');
INSERT INTO `order_detail` VALUES (1116269545335558146, 1116269544450560001, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.ifeng.com');
INSERT INTO `order_detail` VALUES (1116281781705859074, 1116281781215125506, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.ifeng.com');
INSERT INTO `order_detail` VALUES (1116283841742483458, 1116283841180446722, 1, 2, 12.00, 8.00, 1, '咨询套餐', 'http://www.ifeng.com');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `order_id` bigint(20) NOT NULL,
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `order_type` tinyint(4) NULL DEFAULT NULL,
  `buyer_id` bigint(20) NULL DEFAULT NULL,
  `buyer_type` tinyint(4) NULL DEFAULT NULL,
  `buyer_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `seller_id` bigint(20) NULL DEFAULT NULL,
  `seller_type` tinyint(4) NULL DEFAULT NULL,
  `seller_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `order_amount` decimal(10, 2) NULL DEFAULT NULL,
  `order_actual_amount` decimal(10, 2) NULL DEFAULT NULL,
  `order_status` tinyint(4) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `is_del` tinyint(4) NULL DEFAULT NULL,
  `del_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1116183196460990466, 'NO_554953786375989', 1, 1115906143522230300, 1, '张三', 1115906143522230300, 2, '李四', 55.00, 54.00, 0, '2019-04-11 11:36:26', 0, NULL);
INSERT INTO `order_info` VALUES (1116243845266288642, 'NO_554968246177078', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 15:37:26', 0, NULL);
INSERT INTO `order_info` VALUES (1116258395403403265, 'NO_554971715200411', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 16:35:15', 0, NULL);
INSERT INTO `order_info` VALUES (1116260377727934465, 'NO_554972187823712', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 16:43:08', 0, NULL);
INSERT INTO `order_info` VALUES (1116261099781562369, 'NO_554972359974887', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 16:46:00', 0, NULL);
INSERT INTO `order_info` VALUES (1116264288014680065, 'NO_554973120108313', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 16:58:40', 0, NULL);
INSERT INTO `order_info` VALUES (1116266595200598018, 'NO_554973670183812', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 17:07:50', 0, NULL);
INSERT INTO `order_info` VALUES (1116267262585700353, 'NO_554973829301509', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 17:10:29', 0, NULL);
INSERT INTO `order_info` VALUES (1116268960251187201, 'NO_554974234056080', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 17:17:14', 0, NULL);
INSERT INTO `order_info` VALUES (1116269245338062849, 'NO_554974302026059', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 17:18:22', 0, NULL);
INSERT INTO `order_info` VALUES (1116269544450560001, 'NO_554974373340520', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 3, '2019-04-11 17:19:33', 0, NULL);
INSERT INTO `order_info` VALUES (1116281781215125506, 'NO_554977290812633', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 0, '2019-04-11 18:08:11', 0, NULL);
INSERT INTO `order_info` VALUES (1116283841180446722, 'NO_554977781946047', 1, 1115906143522230277, 1, '王二', 1115906143522230276, 2, '赵六', 22.00, 21.00, 3, '2019-04-11 18:16:22', 0, NULL);

-- ----------------------------
-- Table structure for order_pay
-- ----------------------------
DROP TABLE IF EXISTS `order_pay`;
CREATE TABLE `order_pay`  (
  `pay_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NULL DEFAULT NULL,
  `pay_type` tinyint(4) NULL DEFAULT NULL,
  `pay_biz_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `pay_account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `collect_account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `pay_money` decimal(10, 2) NULL DEFAULT NULL,
  `pay_order_create_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `pay_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pay_id`) USING BTREE,
  INDEX `IXFK_order_pay_order_info`(`order_id`) USING BTREE,
  CONSTRAINT `FK_order_pay_order_info` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint(36) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `seq` int(11) NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pid` bigint(36) NULL DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_sogl6f9lioeptbf7s105wbx82`(`pid`) USING BTREE,
  INDEX `fk_bjlrqegc9iu81src5vlta7p00`(`type`) USING BTREE,
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (0, '系统管理', NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `resource` VALUES (1, '角色管理', '角色列表', 2, '../rolelist/rolelist.html', NULL, 0, 0);
INSERT INTO `resource` VALUES (2, '用户管理', '用户列表', 3, '../userlist/userlist.html', NULL, 0, 0);
INSERT INTO `resource` VALUES (3, '资源管理', '管理系统中所有的菜单或功能', 1, '../menu/menu.html', NULL, 0, 0);
INSERT INTO `resource` VALUES (4, '添加角色', NULL, 3, '/role', 'post', 1, 1);
INSERT INTO `resource` VALUES (5, '删除角色', NULL, 6, '/role/*', 'delete', 1, 1);
INSERT INTO `resource` VALUES (6, '编辑角色', NULL, 5, '/role', 'put', 1, 1);
INSERT INTO `resource` VALUES (7, '角色授权', NULL, 8, '/role/grant', 'post', 1, 1);
INSERT INTO `resource` VALUES (9, '添加用户', NULL, 3, '/user', 'post', 2, 1);
INSERT INTO `resource` VALUES (12, '删除用户', NULL, 6, '/user/*', 'delete', 2, 1);
INSERT INTO `resource` VALUES (13, '编辑用户', NULL, 5, '/user', 'put', 2, 1);
INSERT INTO `resource` VALUES (14, '用户修改密码', NULL, 11, '/user/editpwd', 'post', 2, 1);
INSERT INTO `resource` VALUES (15, '用户授权', NULL, 9, '/user/grant', 'post', 2, 1);
INSERT INTO `resource` VALUES (16, '添加资源', NULL, 4, '/resource', 'post', 3, 1);
INSERT INTO `resource` VALUES (17, '删除资源', NULL, 7, '/resource/*', 'delete', 3, 1);
INSERT INTO `resource` VALUES (18, '编辑资源', NULL, 6, '/resource', 'put', 3, 1);
INSERT INTO `resource` VALUES (19, '资源树列表', NULL, 2, '/resource/tree', 'post', 3, 1);
INSERT INTO `resource` VALUES (3907913782690816, '角色详情', NULL, NULL, '/role/*', 'get', 1, 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(36) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `seq` int(11) NULL DEFAULT NULL,
  `pid` bigint(36) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_tealaj0x99w9xj8on8ax0jgjb`(`pid`) USING BTREE,
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, '超管', '超级管理员角色，拥有系统中所有的资源访问权限', 0, NULL);

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_id` bigint(36) NOT NULL,
  `resource_id` bigint(36) NOT NULL,
  PRIMARY KEY (`resource_id`, `role_id`) USING BTREE,
  INDEX `resource_id`(`resource_id`) USING BTREE,
  INDEX `role_resource_ibfk_1`(`role_id`) USING BTREE,
  CONSTRAINT `role_resource_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `role_resource_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES (0, 0);
INSERT INTO `role_resource` VALUES (0, 1);
INSERT INTO `role_resource` VALUES (0, 2);
INSERT INTO `role_resource` VALUES (0, 3);
INSERT INTO `role_resource` VALUES (0, 4);
INSERT INTO `role_resource` VALUES (0, 5);
INSERT INTO `role_resource` VALUES (0, 6);
INSERT INTO `role_resource` VALUES (0, 7);
INSERT INTO `role_resource` VALUES (0, 9);
INSERT INTO `role_resource` VALUES (0, 12);
INSERT INTO `role_resource` VALUES (0, 13);
INSERT INTO `role_resource` VALUES (0, 14);
INSERT INTO `role_resource` VALUES (0, 15);
INSERT INTO `role_resource` VALUES (0, 16);
INSERT INTO `role_resource` VALUES (0, 17);
INSERT INTO `role_resource` VALUES (0, 18);
INSERT INTO `role_resource` VALUES (0, 19);
INSERT INTO `role_resource` VALUES (0, 3907913782690816);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `idcard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `mobile_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `user_status` tinyint(4) NOT NULL DEFAULT 1,
  `last_login_studio_id` bigint(20) NULL DEFAULT NULL,
  `last_login_org_id` bigint(20) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `idx_su_idcard`(`idcard`) USING BTREE,
  INDEX `idx_su_mobilephone`(`mobile_phone`) USING BTREE,
  INDEX `idx_su_email`(`email`) USING BTREE,
  INDEX `idx_su_username`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1107540585947914301, 'zhangsan', '$2a$10$ChwQjf/5/j/Z9Sj6mwQ.z.3wtkd2OkoYXaYgZv7P7WtC6JNlH6Py6', '张三', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-18 15:15:55');
INSERT INTO `sys_user` VALUES (1111555940863119362, 'szsetyy1', '$2a$10$e2U.4xHXgGhQYP8sbzOllucN0fGiWGLl8lSHcjLTq3ERSypDY/EuK', '深圳市儿童医院', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');
INSERT INTO `sys_user` VALUES (1111555941588733954, 'szsfybjy', '$2a$10$QF7lVDBAOevp/ypeS5DuYu0Tydp19msWLNOWBX1UySnCQ7cHr2k3.', '深圳市妇幼保健院', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');
INSERT INTO `sys_user` VALUES (1111555941987192833, 'szsfybjyek', '$2a$10$5ipP8m9lOmLIa74p1cNasexKjTPvtbRXAWGXj4iyaeMMjzorLwa/G', '儿科', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');
INSERT INTO `sys_user` VALUES (1111555942343708674, 'szsfybjyck', '$2a$10$FZHYQ3.tzBitMVAFexUiW.Pdx4B3H.BltXlSkTQIMl8uaoim8vjei', '产科', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `role_id_2`(`role_id`) USING BTREE,
  INDEX `role_id_3`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1107540585947914301, 0);

-- ----------------------------
-- Table structure for user_temp
-- ----------------------------
DROP TABLE IF EXISTS `user_temp`;
CREATE TABLE `user_temp`  (
  `id` bigint(36) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_o3uyea7py4jnln0qxrtg1qqhq`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_temp
-- ----------------------------
INSERT INTO `user_temp` VALUES (0, '2015-05-02 17:50:05', '2016-12-27 21:58:01', '管理员', 'e10adc3949ba59abbe56e057f20f883e', 'admin');
INSERT INTO `user_temp` VALUES (1, '2015-05-02 17:50:06', '2016-12-27 18:34:10', 'admin1', 'e10adc3949ba59abbe56e057f20f883e', 'admin1');
INSERT INTO `user_temp` VALUES (6347667535561728, '2019-04-17 10:47:18', '2019-04-17 10:47:18', 'test1', 'e10adc3949ba59abbe56e057f20f883e', 'test1');
INSERT INTO `user_temp` VALUES (6347668089930752, '2019-04-17 10:47:35', '2019-04-17 10:47:35', 'test2', 'e10adc3949ba59abbe56e057f20f883e', 'test2');
INSERT INTO `user_temp` VALUES (6347668434387968, '2019-04-17 10:47:46', '2019-04-17 10:47:46', 'test3', 'e10adc3949ba59abbe56e057f20f883e', 'test3');
INSERT INTO `user_temp` VALUES (6347668822590464, '2019-04-17 10:47:57', '2019-04-17 10:47:57', 'test4', 'e10adc3949ba59abbe56e057f20f883e', 'test4');
INSERT INTO `user_temp` VALUES (6347668822590467, '2019-04-17 10:47:57', '2019-04-17 10:47:57', 'test7', 'e10adc3949ba59abbe56e057f20f883e', 'test7');
INSERT INTO `user_temp` VALUES (6347668822590469, '2019-04-17 10:47:57', '2019-04-17 10:47:57', 'test5', 'e10adc3949ba59abbe56e057f20f883e', 'test5');
INSERT INTO `user_temp` VALUES (6347668822590480, '2019-04-17 10:47:57', '2019-04-17 10:47:57', 'test8', 'e10adc3949ba59abbe56e057f20f883e', 'test8');
INSERT INTO `user_temp` VALUES (6347668822590481, '2019-04-17 10:47:57', '2019-04-17 10:47:57', 'test81', 'e10adc3949ba59abbe56e057f20f883e', 'test81');
INSERT INTO `user_temp` VALUES (6347668822590482, '2019-04-17 10:47:57', '2019-04-17 10:47:57', 'test82', 'e10adc3949ba59abbe56e057f20f883e', 'test82');

-- ----------------------------
-- Table structure for WebResource
-- ----------------------------
DROP TABLE IF EXISTS `WebResource`;
CREATE TABLE `WebResource`  (
  `id` int(50) NOT NULL,
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `methodType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `optType` int(255) NULL DEFAULT NULL,
  `sysName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `clsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `methodName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addTime` bigint(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for WebRole
-- ----------------------------
DROP TABLE IF EXISTS `WebRole`;
CREATE TABLE `WebRole`  (
  `id` int(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for WebRoleOwnResource
-- ----------------------------
DROP TABLE IF EXISTS `WebRoleOwnResource`;
CREATE TABLE `WebRoleOwnResource`  (
  `id` int(11) NOT NULL,
  `roleId` int(11) NULL DEFAULT NULL,
  `resourceId` int(11) NULL DEFAULT NULL,
  `addTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for WebUser
-- ----------------------------
DROP TABLE IF EXISTS `WebUser`;
CREATE TABLE `WebUser`  (
  `id` int(20) NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `addTime` bigint(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of WebUser
-- ----------------------------
INSERT INTO `WebUser` VALUES (1, 'aa-a', 'aa', 1, 1, '123456', 20190501151302);

-- ----------------------------
-- Table structure for WebUserOwnRole
-- ----------------------------
DROP TABLE IF EXISTS `WebUserOwnRole`;
CREATE TABLE `WebUserOwnRole`  (
  `id` int(30) NOT NULL,
  `userId` int(30) NULL DEFAULT NULL,
  `roleId` int(30) NULL DEFAULT NULL,
  `addTime` bigint(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
