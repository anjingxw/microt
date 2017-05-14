DROP TABLE IF EXISTS `sysPost`;

CREATE TABLE `sysPost` (
  `PostID` int(4) NOT NULL AUTO_INCREMENT,
  `CompanyID` int(4)  NOT NULL,
  `PostName` nvarchar(20) NOT NULL,
  `CreateTime` datetime NOT NULL,
  `UserID` int(4) NOT NULL,
  `State` nvarchar(10)  DEFAULT NULL,
  
  PRIMARY KEY (`PostID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;