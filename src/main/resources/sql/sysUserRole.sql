DROP TABLE IF EXISTS `sysUserRole`;

CREATE TABLE `sysUserRole` (
  `UserRoleID` int(4) NOT NULL AUTO_INCREMENT,
  `CompanyID`  int(4) NOT NULL,
  `UserID`     int(4) NOT NULL,
  `RoleID`     int(4) NOT NULL,
  
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
