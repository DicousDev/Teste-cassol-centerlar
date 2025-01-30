CREATE TABLE CURSO(
  id BIGINT AUTO_INCREMENT,
  nome VARCHAR(255),
  descricao VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE ALUNO(
  id BIGINT AUTO_INCREMENT,
  nome VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE MATRICULA(
  id BIGINT AUTO_INCREMENT,
  aluno_id BIGINT,
  curso_id BIGINT,
  nota DOUBLE,
  PRIMARY KEY(id),
  FOREIGN KEY (aluno_id) REFERENCES ALUNO(id),
  FOREIGN KEY (curso_id) REFERENCES CURSO(id)
);

INSERT INTO CURSO(nome, descricao) VALUES ('Ciência da computação', 'Área que estuda o funcionamento dos computadores e o desenvolvimento de soluções de processamento de dados');
INSERT INTO CURSO(nome, descricao) VALUES ('Psicologia', 'Ciência que estuda o comportamento e os processos mentais dos seres humanos');
INSERT INTO ALUNO(nome) VALUES ('João Victor');
INSERT INTO ALUNO(nome) VALUES ('Kalina');
INSERT INTO MATRICULA(aluno_id, curso_id) VALUES (1, 1);
INSERT INTO MATRICULA(aluno_id, curso_id) VALUES (1, 2);
INSERT INTO MATRICULA(aluno_id, curso_id) VALUES (2, 2);

