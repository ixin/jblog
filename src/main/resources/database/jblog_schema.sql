create table jb_sys(
	optionkey varchar(50) not null,
	optionvalue varchar(1000)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table message(
	id varchar(36) primary key,
	title varchar(50),
	content varchar(500)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table role(
	id int primary key,
	rolename varchar(30) not null,
	roledescrition varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authority(
	id int primary key,
	authorityname varchar(30) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table role_auth(
	roleid int,
	authid int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table post(
	id bigint primary key auto_increment,
	postuser varchar(60),
	title varchar(200),
	content text,
	summary varchar(1000),
	postTime timestamp,
	postStage varchar(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table terms(
	terms_id bigint primary key auto_increment,
	terms_name varchar(100),
	terms_summary varchar(200),
	terms_parent_id bigint,
	terms_type varchar(32)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
