alter table users
drop primary key,
-- add constraint primary key pk_users(id),
add constraint pk_users
primary key users(id),
change column username
username varchar(30) unique;