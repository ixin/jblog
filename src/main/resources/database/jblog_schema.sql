create table jb_sys(
	optionkey varchar(50) not null,
	optionvalue varchar(1000)
);
create table message(
	id varchar(36) primary key,
	title varchar(50),
	content varchar(500)
);
