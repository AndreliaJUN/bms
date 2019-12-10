/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-07-06 13:55:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` varchar(500) DEFAULT NULL,
  `book_name` varchar(20) NOT NULL,
  `book_author` varchar(30) NOT NULL,
  `book_ISBN` varchar(15) NOT NULL,
  `book_price` varchar(20) NOT NULL,
  `book_state` varchar(50) NOT NULL,
  PRIMARY KEY (`book_ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (null, '简爱', '夏洛蒂 勃朗特', '1', '43', '可借');
INSERT INTO `book` VALUES (null, '世说新语', '刘义庆', '10', '26.3', '可借');
INSERT INTO `book` VALUES (null, '老人与海', '海明威', '11', '42.7', '可借');
INSERT INTO `book` VALUES (null, '挪威的森林', '村上春树', '12', '36.5', '可借');
INSERT INTO `book` VALUES (null, '威尼斯商人', '莎士比亚', '13', '24', '可借');
INSERT INTO `book` VALUES (null, '伪君子', '莫里哀', '14', '59', '已借出');
INSERT INTO `book` VALUES (null, '樱桃园', '契科夫', '15', '37', '可借');
INSERT INTO `book` VALUES (null, '底层', '高尔基', '16', '23', '可借');
INSERT INTO `book` VALUES (null, '琵琶行', '白居易', '17', '32', '可借');
INSERT INTO `book` VALUES (null, '时间简史', '史蒂芬 霍金', '18', '114', '已借出且已被预约');
INSERT INTO `book` VALUES (null, '我的时尚风格', '尼娜 加西亚', '19', '23', '已借出');
INSERT INTO `book` VALUES (null, '史记', '司马迁', '2', '89', '可借');
INSERT INTO `book` VALUES (null, '神经科学', 'MarkF.Bear', '20', '102', '已借出');
INSERT INTO `book` VALUES (null, '钢铁侠', '斯坦 李', '21', '74.0', '已借出且已被预约');
INSERT INTO `book` VALUES (null, 'Java编程思想', 'Bruce Eckel ', '22', '111', '已借出');
INSERT INTO `book` VALUES (null, '算法导论（原书第2版）', ' Thomas H.Cormen', '23', '155', '已借出');
INSERT INTO `book` VALUES (null, '计算机网络（自顶向下方法）', ' James F. Kurose', '24', '78', '已借出');
INSERT INTO `book` VALUES (null, '深入理解计算机系统（原书第2版）', 'Randal E.Bryant', '25', '120', '已借出');
INSERT INTO `book` VALUES (null, '骆驼祥子', '老舍', '3', '59', '可借');
INSERT INTO `book` VALUES (null, '京华烟云', '林语堂', '4', '60', '可借');
INSERT INTO `book` VALUES (null, '西游记', '吴承恩', '5', '100', '可借');
INSERT INTO `book` VALUES (null, '哈利波特', '罗琳', '6', '99.99', '可借');
INSERT INTO `book` VALUES (null, '红楼梦', '曹雪芹', '7', '120', '可借');
INSERT INTO `book` VALUES (null, '楚辞', '屈原', '8', '62', '可借');
INSERT INTO `book` VALUES (null, '汉书', '班固', '9', '55.9', '可借');

-- ----------------------------
-- Table structure for `borrow_message`
-- ----------------------------
DROP TABLE IF EXISTS `borrow_message`;
CREATE TABLE `borrow_message` (
  `message_id` varchar(20) DEFAULT NULL,
  `book_name` varchar(20) NOT NULL,
  `book_ISBN` varchar(20) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `borrow_date` varchar(20) NOT NULL,
  `return_date` varchar(20) NOT NULL,
  `huan` varchar(20) NOT NULL DEFAULT '0',
  `yuyue` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_message
-- ----------------------------
INSERT INTO `borrow_message` VALUES (null, '简爱', '1', 'Andrelia', '2019-07-04 23:03:46', '2019-07-04 23:04:50', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '京华烟云', '4', 'Andrelia', '2019-07-04 23:04:30', '2019-11-04 23:05:44', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '哈利波特', '6', 'Andrelia', '2019-07-04 23:04:38', '2019-07-05 09:09:21', '已还', '已预约');
INSERT INTO `borrow_message` VALUES (null, '红楼梦', '7', 'Andrelia', '2019-07-04 23:25:14', '2019-07-04 23:26:05', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '时间简史', '18', '谢尔顿', '2019-07-05 08:41:32', '2019-09-05 08:41:32', '未还', '已预约');
INSERT INTO `borrow_message` VALUES (null, '我的时尚风格', '19', '佩妮', '2019-07-05 08:42:33', '2019-09-05 08:42:33', '未还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '钢铁侠', '21', '霍华德', '2019-07-05 08:45:25', '2019-09-05 08:45:25', '未还', '已预约');
INSERT INTO `borrow_message` VALUES (null, '神经科学', '20', '艾米', '2019-07-05 08:51:28', '2019-09-05 08:51:28', '未还', '不预约');
INSERT INTO `borrow_message` VALUES (null, 'Java编程思想', '22', '王睿君', '2019-07-05 09:10:24', '2019-11-05 09:11:05', '未还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '算法导论（原书第2版）', '23', '王睿君', '2019-07-05 09:10:29', '2019-11-05 09:54:32', '未还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '计算机网络（自顶向下方法）', '24', '王睿君', '2019-07-05 09:10:36', '2019-09-05 09:10:36', '未还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '深入理解计算机系统（原书第2版）', '25', '王睿君', '2019-07-05 09:10:41', '2019-09-05 09:10:41', '未还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '简爱', '1', 'Andrelia', '2019-07-05 15:41:39', '2019-07-05 15:41:57', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '挪威的森林', '12', 'Andrelia', '2019-07-05 15:41:46', '2019-07-05 20:55:02', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '威尼斯商人', '13', 'Andrelia', '2019-07-05 20:55:59', '2019-07-05 20:56:12', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '史记', '2', 'Andrelia', '2019-07-05 21:16:28', '2019-07-05 21:16:37', '已还', '不预约');
INSERT INTO `borrow_message` VALUES (null, '伪君子', '14', 'Andrelia', '2019-07-05 21:17:01', '2019-11-05 21:17:19', '未还', '不预约');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` varchar(10) DEFAULT NULL,
  `manager_name` varchar(20) NOT NULL,
  `manager_password` varchar(20) NOT NULL,
  PRIMARY KEY (`manager_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('4', 'LiHua', '4');
INSERT INTO `manager` VALUES ('1', '张三', '1');
INSERT INTO `manager` VALUES ('2', '李四', '2');
INSERT INTO `manager` VALUES ('3', '王五', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(10) DEFAULT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Andrelia', '19990204');
INSERT INTO `user` VALUES ('9', '伯纳黛特', '666');
INSERT INTO `user` VALUES ('7', '佩妮', '444');
INSERT INTO `user` VALUES ('11', '拉杰', '888');
INSERT INTO `user` VALUES ('3', '王睿君', '20171760');
INSERT INTO `user` VALUES ('2', '艾米', '777');
INSERT INTO `user` VALUES ('6', '莱纳德', '333');
INSERT INTO `user` VALUES ('5', '谢尔顿', '222');
INSERT INTO `user` VALUES ('8', '霍华德', '555');
