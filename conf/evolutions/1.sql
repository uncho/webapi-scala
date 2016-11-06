# --- !Ups
create table user_data (
  user_id int not null auto_increment,
  name varchar(255) not null,
  primary key (user_id)
);

# --- !Downs
drop table user_data;