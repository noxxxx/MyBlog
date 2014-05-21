# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  content                   varchar(255),
  last_edit_time            datetime,
  constraint pk_blog primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table blog;

SET FOREIGN_KEY_CHECKS=1;

