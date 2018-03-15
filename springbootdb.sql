/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springbootdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-15 15:39:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('29', '程程', '543221', '1', '程程');
INSERT INTO `users` VALUES ('30', '建华', '435234', '0', '华仔');
INSERT INTO `users` VALUES ('31', '辟邪剑谱', '345234', '0', '岳不群');
INSERT INTO `users` VALUES ('32', '独孤九剑', '134124', '1', '令狐冲');
INSERT INTO `users` VALUES ('33', '吸星大法', '134124', '1', '任我行');
INSERT INTO `users` VALUES ('34', '葵花宝典', '134124', '0', '东方不败');
INSERT INTO `users` VALUES ('35', '测试', '134124', '1', null);
INSERT INTO `users` VALUES ('36', '测试', '134124', '1', '测试');
