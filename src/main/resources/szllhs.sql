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

 Date: 19/04/2019 19:04:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
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
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1107540585947914301, 'zhangsan', '$2a$10$RpFJjxYiXdEsAGnWp/8fsOetMuOON96Ntk/Ym2M/RKRyU0GZseaDC', '张三', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-18 15:15:55');
INSERT INTO `user` VALUES (1111555940863119362, 'szsetyy1', '$2a$10$e2U.4xHXgGhQYP8sbzOllucN0fGiWGLl8lSHcjLTq3ERSypDY/EuK', '深圳市儿童医院', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');
INSERT INTO `user` VALUES (1111555941588733954, 'szsfybjy', '$2a$10$QF7lVDBAOevp/ypeS5DuYu0Tydp19msWLNOWBX1UySnCQ7cHr2k3.', '深圳市妇幼保健院', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');
INSERT INTO `user` VALUES (1111555941987192833, 'szsfybjyek', '$2a$10$5ipP8m9lOmLIa74p1cNasexKjTPvtbRXAWGXj4iyaeMMjzorLwa/G', '儿科', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');
INSERT INTO `user` VALUES (1111555942343708674, 'szsfybjyck', '$2a$10$FZHYQ3.tzBitMVAFexUiW.Pdx4B3H.BltXlSkTQIMl8uaoim8vjei', '产科', NULL, NULL, NULL, 1, NULL, NULL, '2019-03-29 04:09:23');

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
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_temp` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (0, 0);

SET FOREIGN_KEY_CHECKS = 1;
