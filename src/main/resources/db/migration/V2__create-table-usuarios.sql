create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(150) not null,
    contrasena varchar(255) not null,
    perfil_id bigint not null,

    primary key(id),
    constraint fk_usuario_perfil_id foreign key (perfil_id) references perfiles(id)
)