/*
 Navicat Premium Dump SQL

 Source Server         : swpu
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : hotel_db

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 29/07/2024 09:54:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `id_num` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户身份证号码',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of client
-- ----------------------------

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `id_num` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `position` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职位',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像路径',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '小明', '123456789123456789', 'admin', '123456', 25, '男', '14725836987', '老板', 'http://localhost:8088/view/1.png', '2024-07-24 10:24:58', '2024-07-24 10:25:24', '', '');
INSERT INTO `emp` VALUES (2, '李浩楠', '051602080005', '李', '1365465', 23, '男', '103', '员工', 'http://localhost:8088/view/QQ图片20230918203227.png', '2024-07-25 09:48:35', '2024-07-26 15:05:00', NULL, NULL);
INSERT INTO `emp` VALUES (3, '小兰', '203065145641', '李兰', '10364', NULL, '女', NULL, '员工', 'http://localhost:8088/view/QQ图片20230918193331.jpg', '2024-07-25 09:49:49', '2024-07-25 10:14:31', NULL, NULL);
INSERT INTO `emp` VALUES (4, '董成阳', '156106051845', '天', '123456', 21, '男', '1305165612651', '经理', 'http://localhost:8088/view/QQ图片20240322223030.jpg', '2024-07-25 16:04:51', '2024-07-26 15:02:30', NULL, NULL);
INSERT INTO `emp` VALUES (5, '魏成瑞', '132516015020', 'li兰', '123456', 21, '男', '123548', '清洁', 'http://localhost:8088/view/QQ图片20240710155609.jpg', '2024-07-25 16:10:51', '2024-07-27 11:36:35', NULL, NULL);
INSERT INTO `emp` VALUES (6, '张三', '233161056230', '兰天', '1354864', 14, '女', '1325461', '员工', 'http://localhost:8088/view/QQ图片20240322223021.jpg', '2024-07-25 16:15:13', NULL, NULL, NULL);
INSERT INTO `emp` VALUES (7, '李四', '321651621350', 'aw', '123456', 20, '女', '123456789', '员工', 'http://localhost:8088/view/QQ图片20230918200530.jpg', '2024-07-25 16:22:18', '2024-07-26 15:02:47', NULL, NULL);
INSERT INTO `emp` VALUES (8, '王五', '685966205551', 'awsed', '1565552', 21, NULL, NULL, '员工', 'http://localhost:8088/view/QQ图片20240322223021.jpg', NULL, '2024-07-26 15:02:57', NULL, NULL);
INSERT INTO `emp` VALUES (9, '1', NULL, '1', '1', NULL, NULL, NULL, '清洁', '', '2024-07-26 11:08:34', '2024-07-27 11:43:24', NULL, NULL);

-- ----------------------------
-- Table structure for emp_role
-- ----------------------------
DROP TABLE IF EXISTS `emp_role`;
CREATE TABLE `emp_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emp_role
-- ----------------------------
INSERT INTO `emp_role` VALUES (1, 1, 1);
INSERT INTO `emp_role` VALUES (2, 2, 3);
INSERT INTO `emp_role` VALUES (3, 3, 3);
INSERT INTO `emp_role` VALUES (4, 4, 2);
INSERT INTO `emp_role` VALUES (5, 5, 3);
INSERT INTO `emp_role` VALUES (6, 6, 3);
INSERT INTO `emp_role` VALUES (7, 7, 3);
INSERT INTO `emp_role` VALUES (8, 8, 3);
INSERT INTO `emp_role` VALUES (9, 9, 4);

-- ----------------------------
-- Table structure for form
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `room_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入住房间号',
  `start_time` datetime NULL DEFAULT NULL COMMENT '入住时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '退房时间',
  `client1_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入住人员1',
  `client2_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入住人员2',
  `client3_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入住人员3',
  `client4_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入住人员4',
  `status` int NULL DEFAULT NULL COMMENT '是否退房0未退1退',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of form
-- ----------------------------

-- ----------------------------
-- Table structure for order_form
-- ----------------------------
DROP TABLE IF EXISTS `order_form`;
CREATE TABLE `order_form`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `room_num` int NULL DEFAULT NULL COMMENT '房间id',
  `client_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户名',
  `order_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_form
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `perm_type` int NOT NULL COMMENT '1有员工管理2没有员工管理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `operator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '老板', 1, '2024-07-15 15:20:04', 'admin', NULL, NULL);
INSERT INTO `role` VALUES (2, '经理', 1, '2024-07-26 15:51:17', 'admin', NULL, NULL);
INSERT INTO `role` VALUES (3, '员工', 2, '2024-07-23 15:10:45', 'admin', '2024-07-27 09:52:37', NULL);
INSERT INTO `role` VALUES (4, '清洁', 2, '2024-07-27 09:52:47', NULL, '2024-07-27 16:00:11', NULL);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `room_num` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房间号：类似321',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房间类型：单人间，双人间等',
  `price` int NULL DEFAULT NULL COMMENT '价格',
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房间描述',
  `status` int NULL DEFAULT NULL COMMENT '1空闲2使用-1清扫',
  PRIMARY KEY (`id` DESC) USING BTREE,
  UNIQUE INDEX `room_num`(`room_num` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
