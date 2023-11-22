create table respostas(
    id bigint not null auto_increment,
    titulo varchar(255),
    mensagem text,
    data_de_criacao datetime not null,
    status varchar(15),
    usuario_id bigint not null,
    topico_id bigint not null,
    solucao tinyint not null,

    primary key (id),
    constraint fk_respostas_usuario_id foreign key (usuario_id) references usuarios(id),
    constraint fk_respostas_topico_id foreign key (topico_id) references topicos(id)
);