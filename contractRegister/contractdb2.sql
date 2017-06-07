/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/5 22:42:04                            */
/*==============================================================*/


drop table if exists t_contract;

drop table if exists t_contract_attachment;

drop table if exists t_contract_process;

drop table if exists t_contract_state;

drop table if exists t_customer;

drop table if exists t_function;

drop table if exists t_log;

drop table if exists t_right;

drop table if exists t_role;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_contract                                            */
/*==============================================================*/
create table t_contract
(
   id                   integer not null,
   num                  varchar(20) not null,
   name                 varchar(40) not null,
   user_id              int,
   customer             varchar(40),
   content              text not null,
   beginTime            date not null,
   endTime              date not null,
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_contract_attachment                                 */
/*==============================================================*/
create table t_contract_attachment
(
   id                   int not null,
   con_id               int,
   fileName             varchar(40),
   path                 varchar(100),
   type                 varchar(10),
   uploadTime           timestamp,
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_contract_process                                    */
/*==============================================================*/
create table t_contract_process
(
   id                   int not null,
   con_id               int,
   user_id              int,
   type                 int,
   state                int,
   content              text,
   time                 timestamp,
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_contract_state                                      */
/*==============================================================*/
create table t_contract_state
(
   id                   int not null,
   con_id               int,
   type                 int,
   time                 timestamp,
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_customer                                            */
/*==============================================================*/
create table t_customer
(
   id                   int not null,
   num                  varchar(20),
   name                 varchar(40),
   address              varchar(200),
   tel                  varchar(20),
   fax                  varchar(20),
   code                 varchar(10),
   bank                 varchar(50),
   account              varchar(50),
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_function                                            */
/*==============================================================*/
create table t_function
(
   id                   int not null,
   num                  varchar(10),
   name                 varchar(40),
   URL                  varchar(200),
   description          varchar(200),
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_log                                                 */
/*==============================================================*/
create table t_log
(
   id                   int not null,
   user_id              int,
   time                 timestamp,
   content              text,
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_right                                               */
/*==============================================================*/
create table t_right
(
   id                   int not null,
   user_id              int,
   role_id              int,
   description          varchar(200),
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   id                   int not null,
   name                 varchar(40),
   function_ids         varchar(500),
   description          varchar(200),
   del                  int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null,
   name                 varchar(40),
   password             varchar(20),
   del                  int not null,
   primary key (id)
);

alter table t_contract_process add constraint FK_Reference_1 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_contract_process add constraint FK_Reference_2 foreign key (con_id)
      references t_contract (id) on delete restrict on update restrict;

alter table t_contract_state add constraint FK_Reference_3 foreign key (con_id)
      references t_contract (id) on delete restrict on update restrict;

alter table t_right add constraint FK_Reference_4 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_right add constraint FK_Reference_5 foreign key (role_id)
      references t_role (id) on delete restrict on update restrict;

