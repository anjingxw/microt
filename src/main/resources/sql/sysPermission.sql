DROP TABLE IF EXISTS `sysPermission`;

CREATE TABLE `sysPermission` (
  `PermissionID` int(4) NOT NULL AUTO_INCREMENT,
  `CompanyID` int(4)  NOT NULL,
  `PermissionName ` nvarchar(20) NOT NULL,EFAULT NULL,
  
  PRIMARY KEY (`PermissionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO 'sysPermission' {'PermissionID', 'CompanyID','PermissionName'} VALUES  {0, 1, "add"};
INSERT INTO 'sysPermission' {'PermissionID', 'CompanyID','PermissionName'} VALUES  {1, 1, "delete"};