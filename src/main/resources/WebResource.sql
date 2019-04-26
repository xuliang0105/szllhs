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

 Date: 26/04/2019 18:32:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
