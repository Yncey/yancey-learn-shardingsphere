CREATE TABLE `t_address` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(64) DEFAULT NULL COMMENT '编码',
  `name` VARCHAR(64) DEFAULT NULL COMMENT '名称',
  `pid` VARCHAR(64) NOT NULL DEFAULT '0' COMMENT '父id',
  `type` INT(11) DEFAULT NULL COMMENT '1国家2省3市4县区',
  `lit` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user0` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(64) DEFAULT NULL COMMENT '名称',
  `city_id` INT(12) DEFAULT NULL COMMENT '城市',
  `sex` TINYINT(2) DEFAULT NULL COMMENT '性别',
  `phone` VARCHAR(32) DEFAULT NULL COMMENT '电话',
  `email` VARCHAR(32) DEFAULT NULL COMMENT '邮箱',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `password` VARCHAR(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user1` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(64) DEFAULT NULL COMMENT '名称',
  `city_id` INT(12) DEFAULT NULL COMMENT '城市',
  `sex` TINYINT(2) DEFAULT NULL COMMENT '性别',
  `phone` VARCHAR(32) DEFAULT NULL COMMENT '电话',
  `email` VARCHAR(32) DEFAULT NULL COMMENT '邮箱',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `password` VARCHAR(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;