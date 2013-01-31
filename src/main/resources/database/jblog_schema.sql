create table jb_sys(
	optionkey varchar(50) not null,
	optionvalue varchar(1000)
);
create table message(
	id varchar(36) primary key,
	title varchar(50),
	content varchar(500)
);
create table role(
	id int primary key,
	rolename varchar(30) not null,
	roledescrition varchar(50)
)
create table authority(
	id int primary key,
	authorityname varchar(30) not null
)
create table role_auth(
	roleid int,
	authid int
)
create table userinfo(
	id int primary key,
	username varchar(60) unique,
	password varchar(32) not null,
	nickname varchar(50),
	email varchar(100),
	url varchar(100),
	registered date,
	roleid int,
	isaccountnonexpired int,
	isaccountnonlocked int,
	iscredentialsNonExpired int,
	isenabled int
)