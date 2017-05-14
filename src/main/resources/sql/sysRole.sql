DROP TABLE IF EXISTS `sysRole`;

CREATE TABLE `sysRole` (
  `RoleID` int(4) NOT NULL AUTO_INCREMENT,
  `CompanyID` int(4)  NOT NULL,
  `RoleName ` nvarchar(20) NOT NULL,EFAULT NULL,
  
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO 'sysRole' {'RoleID', 'CompanyID','RoleName'} VALUES {0, 1, "管理员"} 