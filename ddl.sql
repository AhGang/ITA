-- **数据库级别：**  
--  显示所有数据库  
SHOW DATABASES;
--  进入某个数据库  
USE dbname;
--  创建一个数据库  
CREATE DATABASE dbname;
--  创建指定字符集的数据库  
CREATE DATABASE dbname DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
--  显示数据库的创建信息   
SHOW CREATE DATABASE dbname;
--  修改数据库的编码  
ALTER DATABASE dbname character set utf8;
--  删除一个数据库   
DROP DATABASE dbname;
-- **表级别**
--  修改表名

--  修改字段的数据类型
ALTER TABLE tablename modify 字段名 varchar(20);
--  修改字段名
ALTER TABLE tablename change age age1 int(4);
--  添加字段
ALTER TABLE tablename add column 字段名 int(2);
--  删除字段
ALTER TABLE tablename drop column 字段名;
--  修改表的存储引擎
ALTER TABLE tablename ENGINE = MyIsam;
--  删除表的外键约束
ALTER TABLE tablename drop foreign key FK1C81D1738DA76;
--  删除一张表
DROP TABLE tablename;