alter table users
drop primary key,
add constraint pk_users2
primary key users(id, username);