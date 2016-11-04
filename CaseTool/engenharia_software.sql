-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 04/11/2016 às 02:53
-- Versão do servidor: 10.1.16-MariaDB
-- Versão do PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `engenharia_software`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `equipe`
--

CREATE TABLE `equipe` (
  `idequipe` int(11) NOT NULL,
  `data_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nome_equipe` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcao`
--

CREATE TABLE `funcao` (
  `idfuncao` int(11) NOT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `log`
--

CREATE TABLE `log` (
  `idlog` int(11) NOT NULL,
  `idrequisito` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `versao` int(9) NOT NULL,
  `alteracoes` text NOT NULL,
  `data_modificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `login`
--

CREATE TABLE `login` (
  `idlogin` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `niveis_acesso`
--

CREATE TABLE `niveis_acesso` (
  `nivel` int(10) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `niveis_acesso`
--

INSERT INTO `niveis_acesso` (`nivel`, `descricao`) VALUES
(1, 'Gerente projetos'),
(2, 'Gerente equipes');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `nivel_acesso` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `projeto`
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

-- --------------------------------------------------------

--
-- Estrutura para tabela `rastreamento_requisitos`
--

CREATE TABLE `rastreamento_requisitos` (
  `idtupla` int(11) NOT NULL,
  `idprojeto` int(11) NOT NULL,
  `idrequisito` int(11) NOT NULL,
  `id_dep_req` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `rel_pessoa_equipe`
--

CREATE TABLE `rel_pessoa_equipe` (
  `id_rel_pes_eqp` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `idequipe` int(11) NOT NULL,
  `idfuncao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `rel_pessoa_requisito`
--

CREATE TABLE `rel_pessoa_requisito` (
  `id_rel_pes_req` int(11) NOT NULL,
  `idrequisito` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `descricao_atividade` text NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `tempo` time DEFAULT NULL,
  `custo` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `requisito`
--

CREATE TABLE `requisito` (
  `idrequisito` int(11) NOT NULL,
  `concluido` tinyint(1) DEFAULT '0',
  `tempo_estimado` int(11) DEFAULT NULL,
  `descricao` text NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_termino` date DEFAULT NULL,
  `idprojeto` int(11) NOT NULL,
  `cod_req` int(11) NOT NULL,
  `tipo_requisito` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`idequipe`);

--
-- Índices de tabela `funcao`
--
ALTER TABLE `funcao`
  ADD PRIMARY KEY (`idfuncao`);

--
-- Índices de tabela `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`idlog`),
  ADD UNIQUE KEY `idlog` (`idlog`),
  ADD KEY `fk_log_pessoa1_idx` (`idpessoa`),
  ADD KEY `fk_log_requisito1` (`idrequisito`);

--
-- Índices de tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idlogin`),
  ADD UNIQUE KEY `idlogin` (`idlogin`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_login_pessoa1_idx` (`idpessoa`);

--
-- Índices de tabela `niveis_acesso`
--
ALTER TABLE `niveis_acesso`
  ADD PRIMARY KEY (`nivel`),
  ADD UNIQUE KEY `nivel` (`nivel`);

--
-- Índices de tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idpessoa`),
  ADD KEY `nivel_acesso` (`nivel_acesso`),
  ADD KEY `idpessoa` (`idpessoa`);

--
-- Índices de tabela `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`idprojeto`),
  ADD UNIQUE KEY `nome` (`nome`),
  ADD KEY `fk_projeto_equipe1_idx` (`idequipe`);

--
-- Índices de tabela `rastreamento_requisitos`
--
ALTER TABLE `rastreamento_requisitos`
  ADD PRIMARY KEY (`idtupla`),
  ADD KEY `idprojeto` (`idprojeto`),
  ADD KEY `idrequisito` (`idrequisito`),
  ADD KEY `id_dep_req` (`id_dep_req`);

--
-- Índices de tabela `rel_pessoa_equipe`
--
ALTER TABLE `rel_pessoa_equipe`
  ADD PRIMARY KEY (`id_rel_pes_eqp`),
  ADD UNIQUE KEY `id_rel_pes_eqp` (`id_rel_pes_eqp`),
  ADD KEY `fk_rel_pessoa_equipe_pessoa1_idx` (`idpessoa`),
  ADD KEY `fk_rel_pessoa_equipe_equipe1_idx` (`idequipe`),
  ADD KEY `fk_rel_pessoa_equipe_funcao1_idx` (`idfuncao`);

--
-- Índices de tabela `rel_pessoa_requisito`
--
ALTER TABLE `rel_pessoa_requisito`
  ADD PRIMARY KEY (`id_rel_pes_req`),
  ADD UNIQUE KEY `id_rel_pes_req` (`id_rel_pes_req`),
  ADD KEY `fk_rel_pessoa_requisito_requisito_idx` (`idrequisito`),
  ADD KEY `fk_rel_pessoa_requisito_pessoa1_idx` (`idpessoa`);

--
-- Índices de tabela `requisito`
--
ALTER TABLE `requisito`
  ADD PRIMARY KEY (`idrequisito`),
  ADD KEY `fk_requisito_projeto1_idx` (`idprojeto`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `equipe`
--
ALTER TABLE `equipe`
  MODIFY `idequipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `funcao`
--
ALTER TABLE `funcao`
  MODIFY `idfuncao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `log`
--
ALTER TABLE `log`
  MODIFY `idlog` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `idlogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `niveis_acesso`
--
ALTER TABLE `niveis_acesso`
  MODIFY `nivel` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idpessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `projeto`
--
ALTER TABLE `projeto`
  MODIFY `idprojeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `rastreamento_requisitos`
--
ALTER TABLE `rastreamento_requisitos`
  MODIFY `idtupla` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de tabela `rel_pessoa_equipe`
--
ALTER TABLE `rel_pessoa_equipe`
  MODIFY `id_rel_pes_eqp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `rel_pessoa_requisito`
--
ALTER TABLE `rel_pessoa_requisito`
  MODIFY `id_rel_pes_req` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de tabela `requisito`
--
ALTER TABLE `requisito`
  MODIFY `idrequisito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `fk_log_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_log_requisito1` FOREIGN KEY (`idrequisito`) REFERENCES `requisito` (`idrequisito`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_login_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `fk_nivel` FOREIGN KEY (`nivel_acesso`) REFERENCES `niveis_acesso` (`nivel`);

--
-- Restrições para tabelas `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `fk_projeto_equipe1` FOREIGN KEY (`idequipe`) REFERENCES `equipe` (`idequipe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `rastreamento_requisitos`
--
ALTER TABLE `rastreamento_requisitos`
  ADD CONSTRAINT `rastreamento_requisitos_ibfk_1` FOREIGN KEY (`idprojeto`) REFERENCES `projeto` (`idprojeto`),
  ADD CONSTRAINT `rastreamento_requisitos_ibfk_2` FOREIGN KEY (`idrequisito`) REFERENCES `requisito` (`idrequisito`),
  ADD CONSTRAINT `rastreamento_requisitos_ibfk_3` FOREIGN KEY (`id_dep_req`) REFERENCES `requisito` (`idrequisito`);

--
-- Restrições para tabelas `rel_pessoa_equipe`
--
ALTER TABLE `rel_pessoa_equipe`
  ADD CONSTRAINT `fk_rel_pessoa_equipe_equipe1` FOREIGN KEY (`idequipe`) REFERENCES `equipe` (`idequipe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rel_pessoa_equipe_funcao1` FOREIGN KEY (`idfuncao`) REFERENCES `funcao` (`idfuncao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rel_pessoa_equipe_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `rel_pessoa_requisito`
--
ALTER TABLE `rel_pessoa_requisito`
  ADD CONSTRAINT `fk_rel_pessoa_requisito_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rel_pessoa_requisito_requisito` FOREIGN KEY (`idrequisito`) REFERENCES `requisito` (`idrequisito`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `requisito`
--
ALTER TABLE `requisito`
  ADD CONSTRAINT `fk_requisito_projeto1` FOREIGN KEY (`idprojeto`) REFERENCES `projeto` (`idprojeto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
