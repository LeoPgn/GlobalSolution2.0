 -- Tabela Cliente 
 (
 cliente_id     number(5)    constraint cliente_id_pk primary key not null,  
 cliente_nome   varchar(200)                                      not null,
 email          varchar(100)                                      not null, 
 cpf            number(11)                                        not null, 
 cnpj           number(14),
 senha          varchar(50)                                       not null,
 data_nasc      date                                              not null, 
 contato        number(11)                                        not null,
 cep            number(8)                                         not null
 );


 -- Tabela Tópico 
 (
 topico_id      number(5)    constraint cliente_id_pk primary key        not null,
 titulo         varchar(100)                                             not null, 
 cliente_id_fk  number(5)    constraint cliente_id_fk references Cliente,
 data_post      date                                                     not null
 );
 

 -- Tabela Pergunta
 (
 pergunta_id    number(5)   constraint pergunta_id_pk primary key       not null,
 pergunta_texto clob                                                    not null, 
 topico_id_fk   number(5)   constraint topico_id_fk   references Topico,
 cliente_id_fk  number(5)   constraint cliente_id_fk  references Cliente,
 data_post      date                                                    not null
 );
 
 
 -- Tabela Resposta 
 (
 resposta_id     number(5)   constraint resposta_id_pk primary key         not null,
 resposta_texto  clob                                                      not null,
 pergunta_id_fk  number(5)   constraint pergunta_id_fk references Resposta,
 cliente_id_fk   number(5)   constraint cliente_id_fk  references Cliente,
 data_post       date                                                       not null
 );


 -- Tabela Notícias 
 --(
 --noticias_id       number(4)    constraint noticias_id_pk primary key   not null,
 --noticias_titulo   varchar(100)                                         not null,
 --noticias_conteudo clob                                                 not null,
 --data_post         date 
 --);
