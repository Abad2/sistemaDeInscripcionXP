/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     19/11/2018 13:22:22                          */
/*==============================================================*/


drop index RELATIONSHIP_5_FK;

drop index ARCHIVO_PK;

drop table ARCHIVO;

drop index ASIGNA_FK;

drop index TIENE2_FK;

drop index CONFERENCISTA_PK;

drop table CONFERENCISTA;

drop index TIENE_FK;

drop index CURSO_PK;

drop table CURSO;

drop index INSCRIBE_FK;

drop index TIENE__FK;

drop index ESTUDIANTE_PK;

drop table ESTUDIANTE;

drop index ORGANIZADOR_PK;

drop table ORGANIZADOR;

drop index SECRETARIO_PK;

drop table SECRETARIO;

/*==============================================================*/
/* Table: ARCHIVO                                               */
/*==============================================================*/
create table ARCHIVO (
   IDARCHIVO            SERIAL               not null,
   IDSECRE              INT4                 null,
   EXTENSION            VARCHAR(5)           null,
   NOMBREARCH           VARCHAR(20)          null,
   VIGENCIAARCH         DATE                 null,
   FECHACREACION        DATE                 null,
   FORMATO              VARCHAR(6)           null,
   VIGENCIA             DATE                 null,
   constraint PK_ARCHIVO primary key (IDARCHIVO)
);

/*==============================================================*/
/* Index: ARCHIVO_PK                                            */
/*==============================================================*/
create unique index ARCHIVO_PK on ARCHIVO (
IDARCHIVO
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on ARCHIVO (
IDSECRE
);

/*==============================================================*/
/* Table: CONFERENCISTA                                         */
/*==============================================================*/
create table CONFERENCISTA (
   IDCONFERENCISTA      SERIAL               not null,
   IDCURSO              INT4                 null,
   IDORGANIZADOR        INT4                 null,
   NOMBRECONFE          VARCHAR(50)          not null,
   APPATCONFE           VARCHAR(50)          not null,
   APMATCONFE           VARCHAR(50)          not null,
   CORREOCONFE          VARCHAR(100)         not null,
   ESPECIALIDADCONFE    VARCHAR(60)          not null,
   TELEFONOCONFE        INT4                 not null,
   DIRECCIONRCONFE      VARCHAR(100)         not null,
   constraint PK_CONFERENCISTA primary key (IDCONFERENCISTA)
);

/*==============================================================*/
/* Index: CONFERENCISTA_PK                                      */
/*==============================================================*/
create unique index CONFERENCISTA_PK on CONFERENCISTA (
IDCONFERENCISTA
);

/*==============================================================*/
/* Index: TIENE2_FK                                             */
/*==============================================================*/
create  index TIENE2_FK on CONFERENCISTA (
IDCURSO
);

/*==============================================================*/
/* Index: ASIGNA_FK                                             */
/*==============================================================*/
create  index ASIGNA_FK on CONFERENCISTA (
IDORGANIZADOR
);

/*==============================================================*/
/* Table: CURSO                                                 */
/*==============================================================*/
create table CURSO (
   IDCURSO              SERIAL               not null,
   IDCONFERENCISTA      INT4                 null,
   FECHAINICIO          DATE                 not null,
   FECHAFIN             DATE                 not null,
   HORARIOCURSO         TIME                 not null,
   constraint PK_CURSO primary key (IDCURSO)
);

/*==============================================================*/
/* Index: CURSO_PK                                              */
/*==============================================================*/
create unique index CURSO_PK on CURSO (
IDCURSO
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create  index TIENE_FK on CURSO (
IDCONFERENCISTA
);

/*==============================================================*/
/* Table: ESTUDIANTE                                            */
/*==============================================================*/
create table ESTUDIANTE (
   IDESTUDIANTE         SERIAL               not null,
   IDCURSO              INT4                 null,
   IDSECRE              INT4                 null,
   NOMBREESTUD          VARCHAR(50)          not null,
   APPATESTUD           VARCHAR(50)          not null,
   APMATESTUD           VARCHAR(50)          not null,
   CORREOESTUD          VARCHAR(100)         not null,
   DIRECCESTUD          VARCHAR(100)         not null,
   TELEFESTUD           INT4                 not null,
   constraint PK_ESTUDIANTE primary key (IDESTUDIANTE)
);

/*==============================================================*/
/* Index: ESTUDIANTE_PK                                         */
/*==============================================================*/
create unique index ESTUDIANTE_PK on ESTUDIANTE (
IDESTUDIANTE
);

/*==============================================================*/
/* Index: TIENE__FK                                             */
/*==============================================================*/
create  index TIENE__FK on ESTUDIANTE (
IDCURSO
);

/*==============================================================*/
/* Index: INSCRIBE_FK                                           */
/*==============================================================*/
create  index INSCRIBE_FK on ESTUDIANTE (
IDSECRE
);

/*==============================================================*/
/* Table: ORGANIZADOR                                           */
/*==============================================================*/
create table ORGANIZADOR (
   IDORGANIZADOR        SERIAL               not null,
   NOMBREORGANI         VARCHAR(50)          not null,
   APPATORGANI          VARCHAR(50)          not null,
   APMATORGANI          VARCHAR(50)          not null,
   TELEFONOORGANI       INT4                 not null,
   CORREOORGANI         VARCHAR(100)         not null,
   DIRECCORGANI         VARCHAR(100)         not null,
   constraint PK_ORGANIZADOR primary key (IDORGANIZADOR)
);

/*==============================================================*/
/* Index: ORGANIZADOR_PK                                        */
/*==============================================================*/
create unique index ORGANIZADOR_PK on ORGANIZADOR (
IDORGANIZADOR
);

/*==============================================================*/
/* Table: SECRETARIO                                            */
/*==============================================================*/
create table SECRETARIO (
   IDSECRE              SERIAL               not null,
   NOMBRESECRE          VARCHAR(30)          not null,
   APPATSECRE           VARCHAR(30)          not null,
   APMATSECRE           VARCHAR(30)          not null,
   DIRECCSECRE          VARCHAR(50)          not null,
   TELEFSECRE           INT4                 not null,
   constraint PK_SECRETARIO primary key (IDSECRE)
);

/*==============================================================*/
/* Index: SECRETARIO_PK                                         */
/*==============================================================*/
create unique index SECRETARIO_PK on SECRETARIO (
IDSECRE
);

alter table ARCHIVO
   add constraint FK_ARCHIVO_RELATIONS_SECRETAR foreign key (IDSECRE)
      references SECRETARIO (IDSECRE)
      on delete restrict on update restrict;

alter table CONFERENCISTA
   add constraint FK_CONFEREN_ASIGNA_ORGANIZA foreign key (IDORGANIZADOR)
      references ORGANIZADOR (IDORGANIZADOR)
      on delete restrict on update restrict;

alter table CONFERENCISTA
   add constraint FK_CONFEREN_TIENE2_CURSO foreign key (IDCURSO)
      references CURSO (IDCURSO)
      on delete restrict on update restrict;

alter table CURSO
   add constraint FK_CURSO_TIENE_CONFEREN foreign key (IDCONFERENCISTA)
      references CONFERENCISTA (IDCONFERENCISTA)
      on delete restrict on update restrict;

alter table ESTUDIANTE
   add constraint FK_ESTUDIAN_INSCRIBE_SECRETAR foreign key (IDSECRE)
      references SECRETARIO (IDSECRE)
      on delete restrict on update restrict;

alter table ESTUDIANTE
   add constraint FK_ESTUDIAN_TIENE__CURSO foreign key (IDCURSO)
      references CURSO (IDCURSO)
      on delete restrict on update restrict;

