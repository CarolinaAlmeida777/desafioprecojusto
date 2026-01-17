create table cliente (
    id serial primary key,
    nome varchar(100),
    possui_desconto boolean
);

create table vendedor (
    id serial primary key,
    nome varchar(100),
    cpf varchar(20) unique,
    matricula varchar(20) unique
);

create table pato (
    id serial primary key,
    nome varchar(100),
    quantidade_filhos integer,
    preco numeric,
    vendido boolean,
    mae_id bigint references pato(id)
);

create table venda (
    id serial primary key,
    data_venda timestamp,
    valor_total numeric,
    cliente_id bigint references cliente(id),
    vendedor_id bigint references vendedor(id)
);

create table item_venda (
    id serial primary key,
    venda_id bigint references venda(id),
    pato_id bigint references pato(id),
    valor numeric
);
