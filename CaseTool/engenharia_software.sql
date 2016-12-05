-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 05-Dez-2016 às 20:33
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `engenharia_software`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipe`
--

CREATE TABLE `equipe` (
  `idequipe` int(11) NOT NULL,
  `data_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nome_equipe` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `equipe`
--

INSERT INTO `equipe` (`idequipe`, `data_criacao`, `nome_equipe`) VALUES
(1, '2016-11-29 22:49:17', 'EquipeTeste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao`
--

CREATE TABLE `funcao` (
  `idfuncao` int(11) NOT NULL,
  `descricao` text NOT NULL,
  `custo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcao`
--

INSERT INTO `funcao` (`idfuncao`, `descricao`, `custo`) VALUES
(1, 'programador', 50),
(2, 'Engenheiro de teste', 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `log`
--

CREATE TABLE `log` (
  `idlog` int(11) NOT NULL,
  `idrequisito` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `versao` int(9) NOT NULL,
  `alteracoes` text NOT NULL,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `log`
--

INSERT INTO `log` (`idlog`, `idrequisito`, `idpessoa`, `versao`, `alteracoes`, `data_modificacao`) VALUES
(1, 1, 1, 1, 'Requisito criado', '2016-11-29 22:53:56'),
(2, 2, 1, 1, 'Requisito criado', '2016-11-29 22:54:30'),
(3, 3, 1, 1, 'Requisito criado', '2016-11-29 22:55:02'),
(4, 4, 1, 1, 'Requisito criado', '2016-11-29 22:57:10'),
(5, 5, 1, 1, 'Requisito criado', '2016-11-29 22:58:49'),
(6, 6, 1, 1, 'Requisito criado', '2016-11-29 23:01:22'),
(7, 7, 1, 1, 'Requisito criado', '2016-11-29 23:03:18'),
(8, 8, 1, 1, 'Requisito criado', '2016-11-29 23:04:12'),
(9, 9, 1, 1, 'Requisito criado', '2016-11-29 23:05:02'),
(10, 10, 1, 1, 'Requisito criado', '2016-11-29 23:05:40'),
(11, 11, 1, 1, 'Requisito criado', '2016-11-29 23:06:26'),
(12, 12, 1, 1, 'Requisito criado', '2016-11-29 23:07:09'),
(13, 13, 1, 1, 'Requisito criado', '2016-11-29 23:08:02'),
(14, 14, 1, 1, 'Requisito criado', '2016-11-29 23:10:00'),
(15, 15, 1, 1, 'Requisito criado', '2016-11-29 23:11:40'),
(16, 16, 1, 1, 'Requisito criado', '2016-11-29 23:13:53');

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `idlogin` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`idlogin`, `idpessoa`, `email`, `senha`) VALUES
(1, 1, 'jonata', '1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `niveis_acesso`
--

CREATE TABLE `niveis_acesso` (
  `nivel` int(10) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `niveis_acesso`
--

INSERT INTO `niveis_acesso` (`nivel`, `descricao`) VALUES
(1, 'Gerente projetos'),
(2, 'Gerente equipes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `nivel_acesso` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`idpessoa`, `nome`, `sexo`, `nivel_acesso`) VALUES
(1, 'jonata', 0, 1),
(2, 'Igor', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `idprojeto` int(11) NOT NULL,
  `data_entrada` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_prazo` date NOT NULL,
  `descricao` text NOT NULL,
  `concluido` tinyint(1) DEFAULT '0',
  `data_inicio` date DEFAULT NULL,
  `data_termino` varchar(45) DEFAULT NULL,
  `idequipe` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `projeto`
--

INSERT INTO `projeto` (`idprojeto`, `data_entrada`, `data_prazo`, `descricao`, `concluido`, `data_inicio`, `data_termino`, `idequipe`, `nome`) VALUES
(1, '2016-11-29 22:49:30', '2016-11-10', 'teste', 0, NULL, NULL, 1, 'ProjetoTeste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `rastreamento_requisitos`
--

CREATE TABLE `rastreamento_requisitos` (
  `idtupla` int(11) NOT NULL,
  `idprojeto` int(11) NOT NULL,
  `idrequisito` int(11) NOT NULL,
  `id_dep_req` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rel_pessoa_equipe`
--

CREATE TABLE `rel_pessoa_equipe` (
  `id_rel_pes_eqp` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `idequipe` int(11) NOT NULL,
  `idfuncao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `rel_pessoa_equipe`
--

INSERT INTO `rel_pessoa_equipe` (`id_rel_pes_eqp`, `idpessoa`, `idequipe`, `idfuncao`) VALUES
(1, 1, 1, 2),
(2, 2, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `rel_pessoa_requisito`
--

CREATE TABLE `rel_pessoa_requisito` (
  `id_rel_pes_req` int(11) NOT NULL,
  `idrequisito` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `descricao_atividade` text NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_termino` datetime DEFAULT NULL,
  `tempo` time DEFAULT NULL,
  `custo` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `requisito`
--

CREATE TABLE `requisito` (
  `idrequisito` int(11) NOT NULL,
  `concluido` tinyint(1) DEFAULT '0',
  `tempo_estimado` int(11) DEFAULT NULL,
  `descricao` text NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `idprojeto` int(11) NOT NULL,
  `tipo_requisito` varchar(3) NOT NULL,
  `cod_req` int(11) NOT NULL,
  `expectativas` text NOT NULL,
  `restricoes` text NOT NULL,
  `prioridade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `requisito`
--

INSERT INTO `requisito` (`idrequisito`, `concluido`, `tempo_estimado`, `descricao`, `data_inicio`, `data_termino`, `idprojeto`, `tipo_requisito`, `cod_req`, `expectativas`, `restricoes`, `prioridade`) VALUES
(1, 0, 300, 'Requisito que permite o gerente do produto efetuar seu login de acesso para a elaboração do cadastro do projeto e funcionários.', NULL, NULL, 1, 'RF', 1, 'jkljdfasd', 'jklhj', 3),
(2, 0, 300, 'Aba do programa destinada a elaboração de um novo projeto ou alterações (gerenciamento) do mesmo. Dentro deste encontramos as opções de “novo projeto” e “gerenciar”.\r\n', NULL, NULL, 1, 'RF', 2, '		', '		', 3),
(3, 0, 300, 'NOVO PROJETO - Neste, podemos elaborar um novo projeto, colocando o nome, equipe, descrição e prazo (tempo do projeto).\r\n', NULL, NULL, 1, 'RF', 3, '		', 'KJLK	', 3),
(4, 0, 300, 'Gerenciar Projeto - O sistema deve conter uma tela para gerenciamento de projetos, na qual seja possível selecionar um dentre os projetos, ', NULL, NULL, 1, 'RF', 4, '		', '		', 3),
(5, 0, 300, 'GERENCIAR EQUIPES - O Sistema deve fornecer uma tela para gerenciamento de equipes permitindo a criação de novas equipes e relacionar pessoas/funções nas equipes.', NULL, NULL, 1, 'RF', 5, '		', '		', 3),
(6, 0, 300, 'O sistema deve conter uma tela de gerenciamento de funções onde o usuário possa especificar novas funções e custos;', NULL, NULL, 1, 'RF', 6, '		', '		', 3),
(7, 0, 300, 'Gerenciar Pessoas - O sistema deve fornecer tela para cadastro de pessoas que serão envolvidas em projetos posteriormente.', NULL, NULL, 1, 'RF', 7, '<Cadastro de Pessoas>\r\nNesta opção, podemos realizar o cadastro de pessoas incluindo o nome, sexo (masculino ou feminino) e o nível de acesso ao projeto.\r\n<Gerenciar Pessoas>\r\nAba destinada para realizar o gerenciamento dos funcionários já cadastrados.', '		', 3),
(8, 0, 300, 'PADRÃO - Todo o projeto deverá ser feito utilizando uma arquitetura separada em camadas (abas), onde cada uma dessas conterá apenas os algoritmos relacionados à sua responsabilidade.', NULL, NULL, 1, 'RFN', 1, '		', '		', 3),
(9, 0, 300, 'LOGIN - O usuário autorizado deverá efetuar login no sistema para poder realizar as operações de manutenção de cadastros de usuários autorizados e documentos.', NULL, NULL, 1, 'RF', 8, '		', '		', 3),
(10, 0, 300, 'INTERFACE - O sistema deve ter uma interface de fácil utilização.', NULL, NULL, 1, 'RF', 9, '		', '		', 3),
(11, 0, 0, 'Linguagem de programação - O sistema deve ser desenvolvido em java.', NULL, NULL, 1, 'RF', 10, '		', '		', 2),
(12, 0, 0, 'O sistema deve ser desenvolvido em uma arquitetura em camadas.', NULL, NULL, 1, 'RO', 1, '		', '		', 3),
(13, 0, 0, 'Compatibilidade - A camada de aplicação compatível com desktop de mercado.', NULL, NULL, 1, 'RO', 2, '		', '		', 2),
(14, 0, 0, 'Estimativa de Custo -  O sistema deve fornecer estimativa de custo de acordo com que foi especificado no cadastro de funções de pessoas.', NULL, NULL, 1, 'RF', 11, 'Impresso em relatório', '		', 2),
(15, 0, 300, 'Relatório - O sistema deve imprimir relatório contendo informações importantes sobre cada requisito', NULL, NULL, 1, 'RF', 12, '		', '		', 3),
(16, 0, 0, 'Requisitos - O sistema deve permitir o cadastro de requisitos espeficicando o tipo de requisito, restrições, expectativas, tempo estimado e prioridade.', NULL, NULL, 1, 'RF', 13, '		', '				', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`idequipe`);

--
-- Indexes for table `funcao`
--
ALTER TABLE `funcao`
  ADD PRIMARY KEY (`idfuncao`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`idlog`),
  ADD UNIQUE KEY `idlog` (`idlog`),
  ADD KEY `fk_log_pessoa1_idx` (`idpessoa`),
  ADD KEY `fk_log_requisito1` (`idrequisito`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idlogin`),
  ADD UNIQUE KEY `idlogin` (`idlogin`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_login_pessoa1_idx` (`idpessoa`);

--
-- Indexes for table `niveis_acesso`
--
ALTER TABLE `niveis_acesso`
  ADD PRIMARY KEY (`nivel`),
  ADD UNIQUE KEY `nivel` (`nivel`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idpessoa`),
  ADD KEY `nivel_acesso` (`nivel_acesso`),
  ADD KEY `idpessoa` (`idpessoa`);

--
-- Indexes for table `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`idprojeto`),
  ADD UNIQUE KEY `nome` (`nome`),
  ADD KEY `fk_projeto_equipe1_idx` (`idequipe`);

--
-- Indexes for table `rastreamento_requisitos`
--
ALTER TABLE `rastreamento_requisitos`
  ADD PRIMARY KEY (`idtupla`),
  ADD KEY `idprojeto` (`idprojeto`),
  ADD KEY `idrequisito` (`idrequisito`),
  ADD KEY `id_dep_req` (`id_dep_req`);

--
-- Indexes for table `rel_pessoa_equipe`
--
ALTER TABLE `rel_pessoa_equipe`
  ADD PRIMARY KEY (`id_rel_pes_eqp`),
  ADD UNIQUE KEY `id_rel_pes_eqp` (`id_rel_pes_eqp`),
  ADD KEY `fk_rel_pessoa_equipe_pessoa1_idx` (`idpessoa`),
  ADD KEY `fk_rel_pessoa_equipe_equipe1_idx` (`idequipe`),
  ADD KEY `fk_rel_pessoa_equipe_funcao1_idx` (`idfuncao`);

--
-- Indexes for table `rel_pessoa_requisito`
--
ALTER TABLE `rel_pessoa_requisito`
  ADD PRIMARY KEY (`id_rel_pes_req`),
  ADD UNIQUE KEY `id_rel_pes_req` (`id_rel_pes_req`),
  ADD KEY `fk_rel_pessoa_requisito_requisito_idx` (`idrequisito`),
  ADD KEY `fk_rel_pessoa_requisito_pessoa1_idx` (`idpessoa`);

--
-- Indexes for table `requisito`
--
ALTER TABLE `requisito`
  ADD PRIMARY KEY (`idrequisito`),
  ADD KEY `fk_requisito_projeto1_idx` (`idprojeto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `idequipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcao`
--
ALTER TABLE `funcao`
  MODIFY `idfuncao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `idlog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `idlogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `niveis_acesso`
--
ALTER TABLE `niveis_acesso`
  MODIFY `nivel` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idpessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `projeto`
--
ALTER TABLE `projeto`
  MODIFY `idprojeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `rastreamento_requisitos`
--
ALTER TABLE `rastreamento_requisitos`
  MODIFY `idtupla` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rel_pessoa_equipe`
--
ALTER TABLE `rel_pessoa_equipe`
  MODIFY `id_rel_pes_eqp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `rel_pessoa_requisito`
--
ALTER TABLE `rel_pessoa_requisito`
  MODIFY `id_rel_pes_req` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `requisito`
--
ALTER TABLE `requisito`
  MODIFY `idrequisito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `fk_log_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_log_requisito1` FOREIGN KEY (`idrequisito`) REFERENCES `requisito` (`idrequisito`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_login_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `fk_nivel` FOREIGN KEY (`nivel_acesso`) REFERENCES `niveis_acesso` (`nivel`);

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `fk_projeto_equipe1` FOREIGN KEY (`idequipe`) REFERENCES `equipe` (`idequipe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rastreamento_requisitos`
--
ALTER TABLE `rastreamento_requisitos`
  ADD CONSTRAINT `rastreamento_requisitos_ibfk_1` FOREIGN KEY (`idprojeto`) REFERENCES `projeto` (`idprojeto`),
  ADD CONSTRAINT `rastreamento_requisitos_ibfk_2` FOREIGN KEY (`idrequisito`) REFERENCES `requisito` (`idrequisito`),
  ADD CONSTRAINT `rastreamento_requisitos_ibfk_3` FOREIGN KEY (`id_dep_req`) REFERENCES `requisito` (`idrequisito`);

--
-- Limitadores para a tabela `rel_pessoa_equipe`
--
ALTER TABLE `rel_pessoa_equipe`
  ADD CONSTRAINT `fk_rel_pessoa_equipe_equipe1` FOREIGN KEY (`idequipe`) REFERENCES `equipe` (`idequipe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rel_pessoa_equipe_funcao1` FOREIGN KEY (`idfuncao`) REFERENCES `funcao` (`idfuncao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rel_pessoa_equipe_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rel_pessoa_requisito`
--
ALTER TABLE `rel_pessoa_requisito`
  ADD CONSTRAINT `fk_rel_pessoa_requisito_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rel_pessoa_requisito_requisito` FOREIGN KEY (`idrequisito`) REFERENCES `requisito` (`idrequisito`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `requisito`
--
ALTER TABLE `requisito`
  ADD CONSTRAINT `fk_requisito_projeto1` FOREIGN KEY (`idprojeto`) REFERENCES `projeto` (`idprojeto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
