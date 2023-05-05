/*
Navicat MySQL Data Transfer

Source Server         : 5.7
Source Server Version : 50734
Source Host           : localhost:13306
Source Database       : bookmanagement

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2022-07-10 14:54:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `account` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('666', '666');
INSERT INTO `admin` VALUES ('888', '888');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` varchar(255) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL,
  `remark` varchar(255) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('3', '西游记', '吴承恩', '36.00', '无', '7');
INSERT INTO `book` VALUES ('4', '水浒传', '施耐庵', '38.00', '无', '18');
INSERT INTO `book` VALUES ('5', '三国演义', '罗贯中', '40.00', '无', '21');
INSERT INTO `book` VALUES ('6', '红楼梦', '曹雪芹', '45.00', '无', '29');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `sid` varchar(11) NOT NULL,
  `bookid` varchar(11) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `bookstate` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('1', '5', '三国演义', '借书', '20220420');
INSERT INTO `borrow` VALUES ('1', '6', '红楼梦', '借书', '20220704');
INSERT INTO `borrow` VALUES ('1', '6', '红楼梦', '还书', '20220704');
INSERT INTO `borrow` VALUES ('1', '5', '三国演义', '续借', '20220710');
INSERT INTO `borrow` VALUES ('1', '5', '三国演义', '还书', '20220710');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `sid` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `lend` int(8) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`account`,`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '男', '计算机科学与技术', '0', '1', '1');
INSERT INTO `user` VALUES ('2', '李四', '女', '网络工程', '0', '2', '2');
INSERT INTO `user` VALUES ('3', '王五', '男', '物联网工程', '0', '3', '3');
INSERT INTO `user` VALUES ('4', '赵六', '女', '大数据', '0', '4', '4');
