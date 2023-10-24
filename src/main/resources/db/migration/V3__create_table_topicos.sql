create table topicos(
    id bigint not null auto_increment,
    titulo varchar(255);
    mensagem text,
    data_de_criacao datetime not null,
    status varchar(15),
    usuario_id bigint not null,
    curso_id bigint not null,

    primary key (id),
    constraint fk_topicos_usuario_id foreign key (usuario_id) references usuarios(id)
    constraint fk_topicos_curso_id foreign key (usuario_id) references cursos(id)
);