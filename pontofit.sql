-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 30-Nov-2019 às 16:09
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pontofit`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `estabelecimento`
--

CREATE TABLE `estabelecimento` (
  `codEstabelecimento` int(11) NOT NULL,
  `razaoSocial` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estabelecimento`
--

INSERT INTO `estabelecimento` (`codEstabelecimento`, `razaoSocial`, `cnpj`, `endereco`, `cidade`, `telefone`) VALUES
(4, 'Razao Social LTDA                            ', '80.603.738/0001-82', 'Rua 1 Conjunto 2', 'Brasilia', '(61) 40028-922');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ferias`
--

CREATE TABLE `ferias` (
  `codFerias` int(11) NOT NULL,
  `dataInicio` varchar(45) DEFAULT NULL,
  `dataFim` varchar(45) DEFAULT NULL,
  `dataPagamento` varchar(45) DEFAULT NULL,
  `mes` varchar(45) DEFAULT NULL,
  `Funcionario_codFuncionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `codFuncionario` int(11) NOT NULL,
  `matricula` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `uf` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `tipoFunc` varchar(45) DEFAULT NULL,
  `Login_codLogin` int(11) NOT NULL,
  `Estabelecimento_codEstabelecimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`codFuncionario`, `matricula`, `nome`, `cpf`, `telefone`, `sexo`, `endereco`, `cidade`, `uf`, `cep`, `tipoFunc`, `Login_codLogin`, `Estabelecimento_codEstabelecimento`) VALUES
(3, '123', 'Kassio Bruno Alves Borges', '051.329.621-22', '(61) 99575-3964', 'Masculino', 'CNR 01 CONJ F, Casa 7', 'Brasilia', 'DF', '72.275-162', 'Gerente', 11, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `codLogin` int(11) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`codLogin`, `usuario`, `senha`, `tipo`) VALUES
(8, 'admin', 'admin', 'admin'),
(11, 'kassio', '123', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `registroponto`
--

CREATE TABLE `registroponto` (
  `codRegistroPonto` int(11) NOT NULL,
  `entrada` varchar(45) DEFAULT NULL,
  `saida` varchar(45) DEFAULT NULL,
  `data` varchar(45) DEFAULT NULL,
  `intervalo` varchar(45) DEFAULT NULL,
  `horasTrab` varchar(45) DEFAULT NULL,
  `horaExtra` varchar(45) DEFAULT NULL,
  `Funcionario_codFuncionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  ADD PRIMARY KEY (`codEstabelecimento`),
  ADD UNIQUE KEY `codEstabelecimento_UNIQUE` (`codEstabelecimento`);

--
-- Índices para tabela `ferias`
--
ALTER TABLE `ferias`
  ADD PRIMARY KEY (`codFerias`),
  ADD UNIQUE KEY `codFerias_UNIQUE` (`codFerias`),
  ADD KEY `fk_Ferias_Funcionario1_idx` (`Funcionario_codFuncionario`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`codFuncionario`),
  ADD UNIQUE KEY `codFuncionario_UNIQUE` (`codFuncionario`),
  ADD KEY `fk_Funcionario_Usuario1_idx` (`Login_codLogin`),
  ADD KEY `fk_Funcionario_Estabelecimento1_idx` (`Estabelecimento_codEstabelecimento`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`codLogin`),
  ADD UNIQUE KEY `codUsuario_UNIQUE` (`codLogin`),
  ADD UNIQUE KEY `login_UNIQUE` (`usuario`);

--
-- Índices para tabela `registroponto`
--
ALTER TABLE `registroponto`
  ADD PRIMARY KEY (`codRegistroPonto`),
  ADD UNIQUE KEY `codRegistroPonto_UNIQUE` (`codRegistroPonto`),
  ADD KEY `fk_RegistroPonto_Funcionario_idx` (`Funcionario_codFuncionario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `estabelecimento`
--
ALTER TABLE `estabelecimento`
  MODIFY `codEstabelecimento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `ferias`
--
ALTER TABLE `ferias`
  MODIFY `codFerias` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `codFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `codLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `registroponto`
--
ALTER TABLE `registroponto`
  MODIFY `codRegistroPonto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `ferias`
--
ALTER TABLE `ferias`
  ADD CONSTRAINT `fk_Ferias_Funcionario1` FOREIGN KEY (`Funcionario_codFuncionario`) REFERENCES `funcionario` (`codFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_Funcionario_Estabelecimento1` FOREIGN KEY (`Estabelecimento_codEstabelecimento`) REFERENCES `estabelecimento` (`codEstabelecimento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Funcionario_Usuario1` FOREIGN KEY (`Login_codLogin`) REFERENCES `login` (`codLogin`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `registroponto`
--
ALTER TABLE `registroponto`
  ADD CONSTRAINT `fk_RegistroPonto_Funcionario` FOREIGN KEY (`Funcionario_codFuncionario`) REFERENCES `funcionario` (`codFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
