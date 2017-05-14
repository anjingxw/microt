DROP TABLE IF EXISTS `sysCompany`;

CREATE TABLE `sysCompany` (
  `CompanyID` int(4) NOT NULL AUTO_INCREMENT,
  `CompanyName` nvarchar(20) NOT NULL unique,
  `CompanyType` int(1) NOT NULL,
  `CreateTime` datetime  NOT NULL,
  `State` nvarchar(10) DEFAULT NULL,
  PRIMARY KEY (`CompanyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sysCompany` WRITE;

INSERT INTO `sysCompany` (`CompanyID`, `CompanyName`, `CompanyType`, `CreateTime`)
VALUES (1,'企业名称', 0, now());

UNLOCK TABLES;
