DROP TABLE IF EXISTS `sysDepartment`;

CREATE TABLE `sysDepartment` (
  `DepartmentID` int(4) NOT NULL AUTO_INCREMENT,
  `CompanyID` int(4)  NOT NULL,
  `DepartmentName` nvarchar(20) NOT NULL,
  `DepartmentType` int(1) NOT NULL DEFAULT 0,
  `CreateTime` datetime NOT NULL,
  `UserID` int(4) NOT NULL,
  `State` nvarchar(10)  DEFAULT NULL,
  
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

