-- Tabela de Usuarios

    CREATE TABLE usuarios(
        id BIGINT AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        senha VARCHAR(255) NOT NULL,
        PRIMARY KEY(id)
    );
-- Tabela Quadros
    CREATE TABLE quadros(
        id BIGINT AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        PRIMARY KEY(id)
    );
-- Tabela Colunas
    CREATE TABLE colunas(
        id BIGINT AUTO_INCREMENT,
        nome VARCHAR(255) NOT NULL,
        quadro_id BIGINT NOT NULL,
        PRIMARY KEY(id),

        FOREIGN KEY (quadro_id) REFERENCES quadros(id)
    );
-- Tabela Cartões
    CREATE TABLE cartoes(
        id BIGINT AUTO_INCREMENT,
        titulo VARCHAR(255) NOT NULL,
        descricao VARCHAR(255) NOT NULL,
        coluna_id BIGINT NOT NULL,
        usuario_id BIGINT,
        PRIMARY KEY(id),

        FOREIGN KEY (coluna_id) REFERENCES colunas(id),
        FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
    );