/*
Navicat MySQL Data Transfer

Source Server         : bigger-fish
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : big_fish

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-10-16 22:53:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat_t
-- ----------------------------
DROP TABLE IF EXISTS `chat_t`;
CREATE TABLE `chat_t` (
  `id` int(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `from` varchar(32) DEFAULT NULL COMMENT '消息发送者',
  `to` varchar(32) DEFAULT NULL COMMENT '消息接收者',
  `date` varchar(32) DEFAULT NULL COMMENT '发送时间',
  `msg` varchar(256) DEFAULT NULL COMMENT '消息主体',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户发送消息表';

-- ----------------------------
-- Records of chat_t
-- ----------------------------
