create database db_construcao;

use db_construcao;

create table categoria(
	id int not null auto_increment primary key,
    nome varchar(150) not null unique,
    descricao varchar(500) default null
);

create table departamento(
	id int not null auto_increment primary key,
    nome varchar(150) not null unique,
    descricao varchar(500) default null
);

create table especialidade(
	id int not null auto_increment primary key,
    nome varchar(150) not null unique,
    descricao varchar(500) default null,
    area varchar(9) not null
);

create table servico(
	id int auto_increment primary key,
    nome varchar(150) not null unique,
    descricao varchar(500) default null,
    area varchar(9) not null,
    prioridade varchar(7) not null,
    fk_id_categoria int not null,
    foreign key(fk_id_categoria) references categoria(id)
);

create table usuario(
	id int auto_increment primary key,
    nome varchar(150) not null unique,
    telefone varchar(15) not null,
    cpf varchar(14) not null unique,
    email varchar(40) not null unique,
    senha varchar(20) not null,
    fk_id_departamento int not null,
    isTecnico bit not null,
    fk_id_especialidade int,
    constraint foreign key(fk_id_departamento) references departamento(id),
    constraint foreign key(fk_id_especialidade) references especialidade(id)
);

create table chamado(
	id int auto_increment primary key,
    fk_id_usuario int not null,
    fk_id_servico int not null,
    status varchar(12) not null,
    mensagem varchar(300) not null,
    dataAbertura date not null,
    prazoSolucao date not null,
    dataSolucao date, 
    constraint foreign key(fk_id_usuario) references usuario(id),
    constraint foreign key(fk_id_servico) references servico(id)
);

create table avaliacao(
	id int auto_increment primary key,
    qntEstrelas int not null,
    comentario varchar(200) default null,
    dataAvaliacao date not null
);

create table acompanhamento(
	id int auto_increment primary key,
	fk_id_chamado int not null,
	fk_id_usuario_tecnico int not null,
    solucionadoTecnico bit not null,
    solucionadoUsuario bit not null,
    fk_id_avaliacao int,
    constraint foreign key(fk_id_chamado) references chamado(id),
    constraint foreign key(fk_id_usuario_tecnico) references usuario(id),
    constraint foreign key(fk_id_avaliacao) references avaliacao(id)
);




insert into categoria(nome, descricao)
values('Redes', 'Faucibus malesuada duis varius sodales maecenas aliquet  leo etiam, litora taciti turpis morbi ligula ullamcorper sollicitudin quis, suscipit curae litora posuere sem sed per posuere.');

insert into departamento(nome, descricao)
values('Técnicos', 'Nullam fusce purus donec enim velit posuere, quisque ante molestie himenaeos cras.');

insert into departamento(nome, descricao)
values('Financeiro', 'Lorem ipsum commodo pharetra tincidunt imperdiet dui etiam rutrum vel, iaculis viverra tellus mattis ornare eu sem sed.');

insert into especialidade(nome, descricao, area) 
values('Técnico em manutenção de computadores', 'In lectus adipiscing et ligula lacus, rutrum erat suspendisse viverra fermentum, quis quisque conubia metus. ', 'Hardware');

insert into servico(nome, descricao, area, prioridade, fk_id_categoria)
values('Manutenção', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas volutpat ligula vehicula.', 'Hardware', 'Média', 1);

insert into usuario(nome, telefone, cpf, email, senha, fk_id_departamento, isTecnico, fk_id_especialidade)
values('José da Silva', '62999999999', '11111111111', 'emailbanco@teste.com', 'SenhaBanco123', 2, 1, 1);

insert into chamado(fk_id_usuario, fk_id_servico, status, mensagem, dataAbertura, prazoSolucao, dataSolucao)
values(1, 1, 'Em aberto', 'Mensagem Banco', '2021-05-16', '2021-05-25', '2021-05-21');

insert into avaliacao(qntEstrelas, comentario, dataAvaliacao) 
values('5', 'Ótimo serviço', '2021-05-21');

insert into acompanhamento(fk_id_chamado, fk_id_usuario_tecnico, solucionadoTecnico, solucionadoUsuario, fk_id_avaliacao) 
values(1, 1, 0, 0, null);
