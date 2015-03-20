create database curso;
use curso;
drop database curso;


create table aluno (
nome_aluno varchar(50) not null,
matricula_aluno int not null ,
cpf_aluno varchar (14) not null,
rg_aluno varchar (9),
primary key (matricula_aluno)
);


create table turma(
codigo_turma int not null primary key,
descricao_turma varchar(50) not null
);


drop table sala;
create table sala (
codigo_sala int not null primary key auto_increment,
matricula_aluno int, 
codigo_turma int,
nota_sala numeric(3,1), 
faltas_sala int ,
foreign key (matricula_aluno) references aluno (matricula_aluno),
foreign key (codigo_turma) references turma (codigo_turma)
);

select * from aluno;
select * from turma;
select * from sala;


insert into aluno values ('Júlio C. L. Amorim',1,'09815196448','8650180');
insert into aluno values ('Danilo Medeiros',2,'11111111111','1111111');
insert into aluno values ('Frederico Ernandes',3,'22222222222','2222222');


insert into turma values (1,'Programação Orientada a Objetos');
insert into turma values (2,'Gerência de Configuração');
insert into turma values (3,'Redes e Ambientes Operacionais');
insert into turma values (4,'Metodologia de Desensevolvimento de Software');
insert into turma values (5,'Direito e Ética Profissional');
insert into turma values (6,'Fundamentos de Programação');



 








