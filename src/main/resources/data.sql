-- inserindo comentarios.
INSERT INTO comentarios (comentario, autor, nota) VALUES
('Primeiro comentário', 'Autor1', 4),
('Segundo comentário', 'Autor2', 5),
('Terceiro comentário', 'Autor3', 5),
('Quarto comentário', 'Autor4', 4),
('Quinto comentário', 'Autor5', 5);

-- inserindo usuarios
INSERT INTO usuarios (nome, email, data_nascimento, telefone, cpf, logradouro, numero, bairro, cep, complemento, estado, cidade)
VALUES
('João Silva', 'joao@email.com', '1990-01-15', '1122334455', '710.436.810-86', 'Rua A', 123, 'Centro', '12345-678', 'Apto 101', 'SP', 'São Paulo'),
('Maria Oliveira', 'maria@email.com', '1985-05-20', '9988776655', '219.831.220-41', 'Avenida B', 456, 'Bela Vista', '54321-876', 'Casa 2', 'RJ', 'Rio de Janeiro'),
('Carlos Pereira', 'carlos@email.com', '1992-09-10', '6655443322', '978.378.560-58', 'Rua C', 789, 'Vila Nova', '98765-432', 'Andar 3', 'MG', 'Belo Horizonte'),
('Ana Souza', 'ana@email.com', '1988-03-25', '4455667788', '449.233.420-30', 'Avenida D', 1011, 'Jardins', '87654-321', 'Sala 5', 'RS', 'Porto Alegre'),
('Fernanda Lima', 'fernanda@email.com', '1980-11-08', '9988776655', '811.526.250-12', 'Av. F', 567, 'Centro', '87654-321', 'Apto 501', 'SP', 'São Paulo'),
('Roberto Silva', 'roberto@email.com', '1975-02-18', '6655443322', '805.194.710-08', 'Rua G', 910, 'Bela Vista', '54321-876', 'Casa 3', 'RJ', 'Rio de Janeiro'),
('Mariana Costa', 'mariana@email.com', '1989-07-30', '4455667788', '629.011.160-43', 'Rua H', 1122, 'Vila Nova', '98765-432', 'Andar 5', 'MG', 'Belo Horizonte'),
('Lucas Oliveira', 'lucas@email.com', '1986-05-15', '2233445566', '271.273.670-27', 'Av. I', 1314, 'Jardins', '87654-321', 'Sala 8', 'RS', 'Porto Alegre'),
('Isabela Pereira', 'isabela@email.com', '1993-09-21', '1122334455', '274.701.420-70', 'Rua J', 1516, 'Copacabana', '23456-789', 'Bloco 10', 'RJ', 'Rio de Janeiro'),
('Ricardo Santos', 'ricardo@email.com', '1982-04-05', '9988776655', '403.045.770-30', 'Av. K', 1819, 'Centro', '12345-678', 'Apto 202', 'SP', 'São Paulo'),
('Camila Souza', 'camila@email.com', '1997-01-22', '6655443322', '024.691.190-57', 'Rua L', 2021, 'Bela Vista', '54321-876', 'Casa 4', 'RJ', 'Rio de Janeiro'),
('Antonio Lima', 'antonio@email.com', '1984-08-14', '4455667788', '226.383.620-93', 'Rua M', 2323, 'Vila Nova', '98765-432', 'Andar 7', 'MG', 'Belo Horizonte'),
('Juliana Costa', 'juliana.c@email.com', '1990-03-28', '2233445566', '513.386.970-30', 'Av. N', 2525, 'Jardins', '87654-321', 'Sala 12', 'RS', 'Porto Alegre'),
('Marcos Oliveira', 'marcos.o@email.com', '1987-06-10', '1122334455', '558.504.260-27', 'Rua O', 2828, 'Copacabana', '23456-789', 'Bloco 15', 'RJ', 'Rio de Janeiro'),
('Pedro Santos', 'pedro.s@email.com', '1995-07-12', '2233445566', '382.083.090-10', 'Rua E', 1314, 'Copacabana', '23456-789', 'Bloco 7', 'RJ', 'Rio de Janeiro');


-- inserindo prestadores
INSERT INTO prestador (contato, especialidades, usuario_id) VALUES
('12345678901', 'Especialidade 1, Especialidade 2', 1),
('98765432109', 'Especialidade 3, Especialidade 4', 2),
('11122334455', 'Especialidade 5, Especialidade 1', 3),
('55544433322', 'Especialidade 2, Especialidade 3', 4),
('99988877766', 'Especialidade 4, Especialidade 5', 5);



-- insert de categorias

INSERT INTO categorias (nome, descricao)
VALUES
('Limpeza Residencial', 'Serviços de limpeza para residências, incluindo faxina e organização'),
('Manutenção Elétrica', 'Reparos e instalações elétricas em residências e estabelecimentos comerciais'),
('Design de Interiores', 'Planejamento e decoração de ambientes internos'),
('Jardinagem', 'Cuidados com jardins, poda de plantas e paisagismo'),
('Reformas e Construções', 'Serviços de construção civil, reformas e ampliações'),
('Consultoria Financeira', 'Orientação e planejamento financeiro pessoal e empresarial'),
('Assistência Técnica de Informática', 'Manutenção e suporte técnico para computadores e dispositivos eletrônicos'),
('Serviços de Contabilidade', 'Assessoria contábil para empresas e profissionais autônomos'),
('Aulas Particulares', 'Instrução particular em diversas disciplinas e habilidades'),
('Personal Training', 'Treinamento físico personalizado e acompanhamento esportivo');



-- insert de serviços

INSERT INTO servicos (nome, descricao, id_categoria)
VALUES
('Faxina Completa', 'Limpeza profunda de toda a residência', 1),
('Instalação Elétrica Residencial', 'Serviço de instalação e reparo elétrico', 2),
('Projeto de Decoração', 'Planejamento e criação de projeto de decoração', 3),
('Manutenção de Jardim', 'Cuidados regulares com jardins e plantas', 4),
('Reforma de Banheiro', 'Reforma completa do banheiro', 5),
('Consultoria Financeira Pessoal', 'Orientação financeira pessoal', 6),
('Assistência Técnica em Computadores', 'Manutenção e reparo de computadores', 7),
('Contabilidade para Pequenas Empresas', 'Serviços contábeis para pequenos negócios', 8),
('Aulas de Matemática', 'Instruções particulares em matemática', 9),
('Treinamento Personalizado', 'Treinamento físico personalizado', 10),
('Limpeza Express', 'Faxina rápida para ambientes menores', 1),
('Reparo de Tomadas', 'Conserto e substituição de tomadas', 2),
('Decoração de Quarto', 'Decoração específica para quartos', 3),
('Podas de Árvores', 'Corte e modelagem de árvores no jardim', 4),
('Construção de Varanda', 'Construção de uma varanda ao ar livre', 5),
('Planejamento Financeiro Empresarial', 'Orientação financeira para empresas', 6),
('Suporte Técnico Remoto', 'Assistência técnica online para computadores', 7),
('Contabilidade para Profissionais Liberais', 'Serviços contábeis para profissionais autônomos', 8),
('Aulas de Inglês', 'Instruções particulares em inglês', 9),
('Treinamento de Corrida', 'Treinamento específico para corrida', 10);
