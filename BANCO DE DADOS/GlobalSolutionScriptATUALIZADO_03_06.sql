-- Tabela Cliente
 create table Cliente 
 (
 cliente_id     number GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
 email          varchar(100)                                      not null, 
 senha          varchar(50)                                       not null,
 cep            number(8)                                         not null
 );
 
 -- Tabela Pessoa F�sica 
 (
 cliente_nome   varchar(200)                                      not null,
 data_nasc      date                                              not null,
 cpf            number(11)                                        not null, 
 -- N�o sei o que fazer messe caso para puxar a fk
 -- pq s� da pra puxar a pk @Regina 
 email          varchar(100)                                      not null, 
 senha          varchar(50)                                       not null,
 contato        number(11)                                        not null,
 cep            number(8)                                         not null
 );

 -- Tabela Pergunta
 (
 pergunta_id      number GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 pergunta_titulo  varchar(100)                                            not null,
 pergunta_texto   clob                                                    not null, 
 cliente_id_fk    number(5)   constraint cliente_id_fk  references Cliente,
 data_post        date                                                    not null
 );
 
 
 -- Tabela Resposta 
 (
 resposta_id     number GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 resposta_texto  clob                                                      not null,
 pergunta_id_fk  number(5)   constraint pergunta_id_fk references Resposta,
 cliente_id_fk   number(5)   constraint cliente_id_fk  references Cliente,
 data_post       date                                                       not null
 );


  -- Tabela Not�cias 
 (
 noticias_id       number(4)    constraint noticias_id_pk primary key   not null,
 noticias_titulo   varchar(100)                                         not null,
 noticias_conteudo clob                                                 not null,
 data_post         date 
 );
 
 -- ESBO�OS  DAQUI PRA BAIXO 
 -- Tabela suporte
 (
 nome_completo 
 email
 texto
 
 );
 
 
 -- Tabela login (EM ABERTO)
 (
 email
 senha
 );
 
 -- Tabela Doa��es 
 fk id_cliente 
 data 
 quantidade
 tipo_alimento 1
 
 -- imagem 
 tamanho 
 data 
 
 select * from cliente
 
 
 