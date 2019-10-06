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

-- the table to store GlobalSession data
drop table if exists `global_table`;
create table `global_table` (
  `xid` varchar(128)  not null,
  `transaction_id` bigint,
  `status` tinyint not null,
  `application_id` varchar(32),
  `transaction_service_group` varchar(32),
  `transaction_name` varchar(64),
  `timeout` int,
  `begin_time` bigint,
  `application_data` varchar(2000),
  `gmt_create` datetime,
  `gmt_modified` datetime,
  primary key (`xid`),
  key `idx_gmt_modified_status` (`gmt_modified`, `status`),
  key `idx_transaction_id` (`transaction_id`)
);

-- the table to store BranchSession data
drop table if exists `branch_table`;
create table `branch_table` (
  `branch_id` bigint not null,
  `xid` varchar(128) not null,
  `transaction_id` bigint ,
  `resource_group_id` varchar(32),
  `resource_id` varchar(256) ,
  `lock_key` varchar(128) ,
  `branch_type` varchar(8) ,
  `status` tinyint,
  `client_id` varchar(64),
  `application_data` varchar(2000),
  `gmt_create` datetime,
  `gmt_modified` datetime,
  primary key (`branch_id`),
  key `idx_xid` (`xid`)
);

-- the table to store lock data
drop table if exists `lock_table`;
create table `lock_table` (
  `row_key` varchar(128) not null,
  `xid` varchar(96),
  `transaction_id` long ,
  `branch_id` long,
  `resource_id` varchar(256) ,
  `table_name` varchar(32) ,
  `pk` varchar(32) ,
  `gmt_create` datetime ,
  `gmt_modified` datetime,
  primary key(`row_key`)
);

drop table `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;