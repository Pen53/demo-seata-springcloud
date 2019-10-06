CREATE TABLE `BUSINESS_ACCOUNT` (
  `accountId` VARCHAR(32) NOT NULL COMMENT '主键uuid',
  `amount` DECIMAL(18,6) DEFAULT NULL COMMENT '金额',
  `accountName` VARCHAR(32) DEFAULT NULL COMMENT '账户名称',
  `logicDel` CHAR(1) DEFAULT NULL COMMENT '逻辑删除 Y:删除 N:未删除',
  `remark` VARCHAR(240) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`accountId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE `BUSINESS_ORDER` (
  `orderId` VARCHAR(32) NOT NULL COMMENT '主键uuid',
  `orderNo` VARCHAR(32) DEFAULT NULL COMMENT '订单号',
  `orderDetail` VARCHAR(240) DEFAULT NULL COMMENT '订单详情',
  `createTime` VARCHAR(24) DEFAULT NULL COMMENT '创建时间',
  `logicDel` CHAR(1) DEFAULT NULL COMMENT '逻辑删除 Y:删除 N:未删除',
  `remark` VARCHAR(240) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `orderNo` (`orderNo`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE `BUSINESS_STORAGE` (
  `storageId` VARCHAR(32) NOT NULL COMMENT '主键uuid',
  `storageName` VARCHAR(32) DEFAULT NULL COMMENT '仓储名称',
  `storageCount` INT(11) DEFAULT NULL COMMENT '数量',
  `logicDel` CHAR(1) DEFAULT NULL COMMENT '逻辑删除 Y:删除 N:未删除',
  `remark` VARCHAR(240) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`storageId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `BUSINESS_STORAGE2` (
  `storage2Id` VARCHAR(32) NOT NULL COMMENT '主键uuid',
  `storage2Name` VARCHAR(32) DEFAULT NULL COMMENT '仓储名称',
  `storage2Count` INT(11) DEFAULT NULL COMMENT '数量',
  `logic2Del` CHAR(1) DEFAULT NULL COMMENT '逻辑删除 Y:删除 N:未删除',
  `remark2` VARCHAR(240) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`storage2Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

#这个表是seata在at模式下需要的表
CREATE TABLE `undo_log` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `branch_id` BIGINT(20) NOT NULL,
  `xid` VARCHAR(100) NOT NULL,
  `rollback_info` LONGBLOB NOT NULL,
  `log_status` INT(11) NOT NULL,
  `log_created` DATETIME NOT NULL,
  `log_modified` DATETIME NOT NULL,
  `ext` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_unionkey` (`xid`,`branch_id`)
) ENGINE=INNODB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;
