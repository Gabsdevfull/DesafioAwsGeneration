CREATE TABLE tb_estudante (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    primeiro_semestre FLOAT,
    segundo_semestre FLOAT,
    professores_name VARCHAR(255),
    numero_sala VARCHAR(255)
);