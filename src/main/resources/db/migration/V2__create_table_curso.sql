create table cursos(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    categoria varchar(120) not null,

    primary key (id)
);

alter table usuario alter column email add constrain unique(email);