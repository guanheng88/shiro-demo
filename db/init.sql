drop database if exists shiro_demo;

create database shiro_demo character set utf8;

use shiro_demo;

create table user (
	id char(32) not null,
    username varchar(30) not null,
    password varchar(20) not null
);

create table role (
	id char(32) not null,
    name varchar(20) not null
);

create table permission (
	id char(32) not null,
    name varchar(20) not null
);

create table user_role (
	user_id char(32) not null,
    role_id char(32) not null
);

create table role_permission (
	role_id char(32) not null,
    permission_id char(32) not null
);

alter table user add constraint pk_user_id primary key(id);
alter table role add constraint pk_role_id primary key(id);
alter table permission add constraint pk_permission_id primary key(id);
alter table user_role add constraint pk_user_role_id primary key(user_id, role_id);
alter table role_permission add constraint pk_role_permission_id primary key(role_id, permission_id);

insert into user values('000001a50f514365b345d71820e967da', 'test1', '123456');
insert into user values('000002a50f514365b345d71820e967da', 'test2', '123456');

insert into role values('000011a50f514365b345d71820e967da', 'role1');
insert into role values('000012a50f514365b345d71820e967da', 'role2');
insert into role values('000013a50f514365b345d71820e967da', 'role3');

insert into permission values('000021a50f514365b345d71820e967da', 'permission1');
insert into permission values('000022a50f514365b345d71820e967da', 'permission2');
insert into permission values('000023a50f514365b345d71820e967da', 'permission3');
insert into permission values('000024a50f514365b345d71820e967da', 'permission4');
insert into permission values('000025a50f514365b345d71820e967da', 'permission5');

insert into user_role values('000001a50f514365b345d71820e967da', '000011a50f514365b345d71820e967da');
insert into user_role values('000001a50f514365b345d71820e967da', '000012a50f514365b345d71820e967da');
insert into user_role values('000002a50f514365b345d71820e967da', '000012a50f514365b345d71820e967da');
insert into user_role values('000002a50f514365b345d71820e967da', '000013a50f514365b345d71820e967da');

insert into role_permission values('000011a50f514365b345d71820e967da', '000021a50f514365b345d71820e967da');
insert into role_permission values('000011a50f514365b345d71820e967da', '000022a50f514365b345d71820e967da');
insert into role_permission values('000011a50f514365b345d71820e967da', '000023a50f514365b345d71820e967da');
insert into role_permission values('000012a50f514365b345d71820e967da', '000023a50f514365b345d71820e967da');
insert into role_permission values('000013a50f514365b345d71820e967da', '000024a50f514365b345d71820e967da');
insert into role_permission values('000013a50f514365b345d71820e967da', '000025a50f514365b345d71820e967da');