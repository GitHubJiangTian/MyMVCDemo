create table t_login(
userid int primary key auto_increment comment'主键id',
username varchar(20) not null unique comment'用户名',
userpwd varchar(20) not null comment'密码' 
);

create table t_detail(
userid int primary key auto_increment comment'主键id依赖t_login.userid',
realname varchar(20) not null comment'真实姓名',
balance double comment'账户余额'
);

CREATE TABLE t_order(
oid INT PRIMARY KEY AUTO_INCREMENT COMMENT'订单主键',
orderNum VARCHAR(20) NOT NULL UNIQUE COMMENT'订单号',
orderTime DATE COMMENT'时间',
userid INT REFERENCES t_login(userid)COMMENT'订单所属用户'
);

CREATE TABLE t_product(
pid INT PRIMARY KEY AUTO_INCREMENT COMMENT'产品主键',
pname VARCHAR(30) NOT NULL COMMENT'产品名称',
ean VARCHAR(20) UNIQUE COMMENT'国际标准商品号'
price DOUBLE NOT NULL COMMENT'价格',
-- img varchar(30) comment'图片服务器地址'
);

CREATE TABLE t_item(
itemid INT PRIMARY KEY AUTO_INCREMENT COMMENT'itemzhujian',
oid INT REFERENCES t_order(oid) COMMENT'关联订单表oid',
pid INT REFERENCES t_product(pid) COMMENT'关联商品表pid',
pnum INT NOT NULL COMMENT'商品数量'
);