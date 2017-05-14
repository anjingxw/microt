DROP TABLE IF EXISTS `sysUser`;

CREATE TABLE `sysUser` (
  `UserID` int(4) NOT NULL AUTO_INCREMENT,
  `LoginName` datetime NOT NULL unique,
  `Password` nvarchar(40) NOT NULL,
  `DisplayName` nvarchar(50) DEFAULT NULL,
  `CompanyID` int(4) NOT NULL ,
  `LastLoginTime` nvarchar(4) NOT NULL,
  `LastLoginIp` nvarchar(32) NOT NULL,
  `ErrorLogin` int(1) NOT NULL DEFAULT 0,
  `LoginCnt` int(1) NOT NULL DEFAULT 0,
  `CreateTime` datetime NOT NULL,
  `ExpiryDate` date NOT NULL default '2050-1-1',
  `FingerprintVerification` int(4)  DEFAULT NULL,
  `AppLoginToken` nvarchar(100)
  `State` nvarchar(10)  DEFAULT NULL,
  
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

