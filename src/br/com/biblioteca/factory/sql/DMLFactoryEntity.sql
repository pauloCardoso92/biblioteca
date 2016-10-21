-- INSERT usuario
INSERT INTO usuario(data_cadastro, email, login, nivel_acesso, senha, situacao) VALUES(CURRENT_TIMESTAMP, 'admin@admin.com', 'admin', 'ROLE_ADM', 'admin', 'A');
-- INSERT pessoa
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (1, 'admin', UPPER(MD5('admin')), '615.133.438-82','1992-10-21','Ana Amelia Silva Sauro','2.977.269','F','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (2, 'admin', UPPER(MD5('admin')), '623.353.256-63','1950-06-12','João Franciso de Lima','41.875.789-6','M','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (3, 'admin', UPPER(MD5('admin')), '401.459.797-09','1981-02-10','Maria Raimunda dos Santos','2.977.269','F','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (4, 'admin', UPPER(MD5('admin')), '314.778.285-91','1968-05-16','Lucas Oliveira de Souza','42.943.412-1','M','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (5, 'admin', UPPER(MD5('admin')), '658.633.027-04','1992-10-21','Nicinha Castro Frazão','91.122.534-1','F','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (6, 'admin', UPPER(MD5('admin')), '047.863.230-47','1990-12-16','Antonio Marcos Rodrigues','42.943.412-1','M','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (7, 'admin', UPPER(MD5('admin')), '066.574.114-64','1945-03-15','Marco Aurelio Cunha','41.875.789-6','M','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (8, 'admin', UPPER(MD5('admin')), '235.828.713-04','1992-11-21','Brenda Neves','4.032.894-40','F','I');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (9, 'admin', UPPER(MD5('admin')), '831.536.263-16','1994-09-20','Rosilda Melo de Lima','41.875.789-6','F','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (10, 'admin', UPPER(MD5('admin')),  '167.487.672-61','1990-11-12','Ana Maria Braga','42.943.412-1','F','I');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (11, 'admin', UPPER(MD5('admin')),  '141.137.886-50','1912-12-22','Annita Levendouver Halen','2.977.269','F','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (12, 'admin', UPPER(MD5('admin')),  '458.876.680-59','1992-02-13','Claudia Joselita Alvez','41.875.789-6','F','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (13, 'admin', UPPER(MD5('admin')),  '405.437.582-06','1993-10-23','Jos[e Cirqueira Gomes','2.977.269','M','A');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (14, 'admin', UPPER(MD5('admin')),  '328.111.886-06','1978-12-31','Joselia Fagundes Silva','41.875.789-6','F','I');
INSERT INTO pessoa(id_pessoa, conta, senha, cpf_cnpj, data_nascimento, nome, rg, sexo, situacao) VALUES (15, 'admin', UPPER(MD5('admin')),  '663.079.254-85','1956-12-27','Mauro Betting Smith','4.032.894-40','M','A');
-- INSERT editora
INSERT INTO editora(id_editora, nome, observacao, situacao) VALUES (1, 'Novo Conceito','','A'),(2, 'Foco','','A'),(3, 'Abril','','A'),(4, 'Saraiva','','A'),(5, 'Nova Terra','','A');
-- INSERT categoria
INSERT INTO categoria(id_categoria, nome, observacao, situacao) VALUES (1, 'Programação','','A'),(2, 'Tecnologia','','A'),(3, 'Banco de Dados','','A'),(4, 'Gestão de TI','','A'),(5, 'Hacker','','A'),(6, 'Infraestrutura','','A');
-- INSERT colaborador
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(1,'Analista de Sistemas - Junior','1010001',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(2,'Analista de Sistemas - Junior','1010002',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(3,'Analista de Sistemas - Junior','1010003',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(4,'Analista de Sistemas - Pleno','1010004',5000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(5,'Analista de Sistemas - Junior','1010005',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(6,'Analista de Sistemas - Sênior','1010006',8000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(7,'Analista de Sistemas - Junior','1010007',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(8,'Desenvolvedor','1010008',1000,'estagiario');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(9,'Analista de Sistemas - Pleno','1010009',5000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(10,'Analista de Sistemas - Junior','1010010',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(11,'Analista de Sistemas - Junior','1010011',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(12,'Analista de Sistemas - Junior','1010012',3000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(13,'Analista de Sistemas - Pleno','1010013',5000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(14,'Analista de Sistemas - Pleno','1010014',5000,'efetivo');
INSERT INTO colaborador(id_pessoa, cargo_funcao, matricula, salario, tipo_contrato) VALUES(15,'Desenvolvedor','1010015',1000,'estagiario');
-- INSERT LIVRO
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(1, 2005, 'Use a cabeça - Java', null, 'A', 1, 1);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(2, 2001, 'Use a cabeça - SQL', null, 'A', 1, 2);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(3, 2002, 'A arte de invadir', null, 'A', 5, 3);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(4, 2003, 'Java em 21 dias', null, 'A', 1, 4);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(5, 2005, 'DBA Oracle 11g', null, 'A', 3, 5);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(6, 2010, 'DotNet Framework 4.5', null, 'A', 1, 1);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(7, 2012, 'PMBOK', null, 'A', 4, 1);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(8, 2013, 'Dominando C#', null, 'A', 1, 2);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(9, 2000, 'Desenvolvimento ágil', null, 'A', 1, 2);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(10, 2005, 'Lógica de Programação', null, 'A' ,1, 5);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(11, 2006, 'JQuery', null, 'A', 1, 4);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(12, 1998, 'Delphi 5', null, 'A', 1, 1);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(13, 2000, 'Cobit fundamentos', null, 'A', 4, 5);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(14, 2001, 'HTML 5', null, 'A', 1, 3);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(15, 2012, 'ITIL', null, 'A', 4, 2);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(16, 2010, 'Redes de Computadores', null, 'A', 6, 5);
INSERT INTO livro(id_livro, ano_lancamento, nome, observacao, situacao, id_categoria, id_editora) VALUES(17, 2011, 'Como programar em Java', null, 'A', 1, 5);