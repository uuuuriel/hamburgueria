-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hamburgueriabd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hamburgueriabd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hamburgueriabd` DEFAULT CHARACTER SET utf8 ;
USE `hamburgueriabd` ;

-- -----------------------------------------------------
-- Table `hamburgueriabd`.`bairros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`bairros` (
  `id` INT(11) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cidade` VARCHAR(50) NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`cidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`cidades` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cep2` VARCHAR(15) NOT NULL,
  `estado_cod` INT(255) NOT NULL,
  `cep` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`cliente` (
  `codcliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nomecliente` VARCHAR(45) NOT NULL,
  `telefone` DOUBLE NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `cidade` INT(3) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT(6) NOT NULL,
  `complemento` VARCHAR(70) NOT NULL,
  `cep` INT(9) NULL DEFAULT NULL,
  `data_cadastro` DATE NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`codcliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`estagio_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`estagio_pedido` (
  `codestagio_pedido` INT(11) NOT NULL AUTO_INCREMENT,
  `estagio` VARCHAR(45) NULL DEFAULT NULL,
  `descricao_estagio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`codestagio_pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`funcionario` (
  `codfuncionario` INT(11) NOT NULL AUTO_INCREMENT,
  `nomefuncionario` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `rg` VARCHAR(11) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `fone` DOUBLE NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `funcao` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` INT(7) NOT NULL,
  `bairro` INT(7) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT(6) NULL DEFAULT NULL,
  `complemento` VARCHAR(100) NULL DEFAULT NULL,
  `administrador` VARCHAR(1) NULL DEFAULT NULL,
  `cep` INT(8) NULL DEFAULT NULL,
  PRIMARY KEY (`codfuncionario`, `fone`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`historico_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`historico_funcionario` (
  `pedido_codpedido` INT(11) NOT NULL,
  `funcionario_codfuncionario` INT(11) NOT NULL,
  INDEX `fk_pedido_has_funcionario_funcionario1_idx` (`funcionario_codfuncionario` ASC),
  INDEX `fk_pedido_has_funcionario_pedido1_idx` (`pedido_codpedido` ASC),
  CONSTRAINT `fk_pedido_has_funcionario_funcionario1`
    FOREIGN KEY (`funcionario_codfuncionario`)
    REFERENCES `hamburgueriabd`.`funcionario` (`codfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`taxas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`taxas` (
  `codtaxas` INT(6) NOT NULL,
  `nometaxa` VARCHAR(45) NULL DEFAULT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  `valor` INT(7) NULL DEFAULT NULL,
  PRIMARY KEY (`codtaxas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`pedido` (
  `codpedido` INT(11) NOT NULL AUTO_INCREMENT,
  `estagio_pedido` VARCHAR(45) NULL DEFAULT NULL,
  `estagio_pedido_codestagio_pedido` INT(11) NOT NULL,
  `cliente_codcliente` INT(11) NOT NULL,
  `taxas_codtaxas` INT(6) NOT NULL,
  `data` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`codpedido`, `cliente_codcliente`, `taxas_codtaxas`),
  INDEX `fk_pedido_estagio_pedido1_idx` (`estagio_pedido_codestagio_pedido` ASC),
  INDEX `fk_pedido_taxas1_idx` (`taxas_codtaxas` ASC),
  CONSTRAINT `fk_pedido_estagio_pedido1`
    FOREIGN KEY (`estagio_pedido_codestagio_pedido`)
    REFERENCES `hamburgueriabd`.`estagio_pedido` (`codestagio_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_taxas1`
    FOREIGN KEY (`taxas_codtaxas`)
    REFERENCES `hamburgueriabd`.`taxas` (`codtaxas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`produto` (
  `codproduto` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeproduto` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `anexo` BLOB NULL DEFAULT NULL,
  `cancelamento` VARCHAR(155) NULL DEFAULT NULL,
  `observacao` VARCHAR(155) NULL DEFAULT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codproduto`, `categoria`),
  INDEX `fk_produto_categoria1_idx` (`categoria` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`pedido_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`pedido_produto` (
  `pedido_codpedido` INT(11) NOT NULL,
  `produto_codproduto` INT(11) NOT NULL,
  INDEX `fk_pedido_has_produto_produto1_idx` (`produto_codproduto` ASC),
  INDEX `fk_pedido_has_produto_pedido1_idx` (`pedido_codpedido` ASC),
  CONSTRAINT `fk_pedido_has_produto_produto1`
    FOREIGN KEY (`produto_codproduto`)
    REFERENCES `hamburgueriabd`.`produto` (`codproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hamburgueriabd`.`sugestoes_criticas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hamburgueriabd`.`sugestoes_criticas` (
  `codsugestoes_criticas` INT(11) NOT NULL AUTO_INCREMENT,
  `mensagem` TEXT NULL DEFAULT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`codsugestoes_criticas`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
