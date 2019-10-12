dev modify
-- the table to store lock data
DROP TABLE IF EXISTS `lock_table`;
CREATE TABLE `lock_table` (
  `row_key` VARCHAR(128) NOT NULL,
  `xid` VARCHAR(96),
  `transaction_id` LONG ,
  `branch_id` LONG,
  `resource_id` VARCHAR(256) ,
  `table_name` VARCHAR(32) ,
  `pk` VARCHAR(32) ,
  `gmt_create` DATETIME ,
  `gmt_modified` DATETIME,
  PRIMARY KEY(`row_key`)
);

DROP TABLE `undo_log`;
CREATE TABLE `undo_log` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `branch_id` BIGINT(20) NOT NULL,
  `xid` VARCHAR(100) NOT NULL,
  `context` VARCHAR(128) NOT NULL,
  `rollback_info` LONGBLOB NOT NULL,
  `log_status` INT(11) NOT NULL,
  `log_created` DATETIME NOT NULL,
  `log_modified` DATETIME NOT NULL,
  `ext` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;