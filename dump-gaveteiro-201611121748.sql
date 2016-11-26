-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: gaveteiro
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(30) DEFAULT NULL,
  `razaoSocial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'54.528.454/0001-69','Empresa teste'),(2,'32.704.318/-40','Tirny Toon'),(3,'32.704.318/-40','Gaveteiro');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pagamento`
--

DROP TABLE IF EXISTS `forma_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_pagamento` (
  `id_pagamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pagamento`
--

LOCK TABLES `forma_pagamento` WRITE;
/*!40000 ALTER TABLE `forma_pagamento` DISABLE KEYS */;
INSERT INTO `forma_pagamento` VALUES (1,'Débito'),(2,'Boleto'),(3,'Transferência Bancária'),(4,'Parcelado (Cartão)');
/*!40000 ALTER TABLE `forma_pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_pedido` (
  `id_item_pedido` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidade` bigint(20) DEFAULT NULL,
  `servico_frete` varchar(255) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `valor_frete` float DEFAULT NULL,
  `valor_subtotal` float DEFAULT NULL,
  `valor_unitario` float DEFAULT NULL,
  `id_pedido` bigint(20) DEFAULT NULL,
  `id_produto` bigint(20) DEFAULT NULL,
  `ultimaAtualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id_item_pedido`),
  KEY `FKnjghutiejefh2auj9bnpf9sp7` (`id_pedido`),
  KEY `FKnqncqw8pnv54kv0dct6mo2iei` (`id_produto`),
  CONSTRAINT `FKnjghutiejefh2auj9bnpf9sp7` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  CONSTRAINT `FKnqncqw8pnv54kv0dct6mo2iei` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
INSERT INTO `item_pedido` VALUES (3,5,'Transportadora',29.94,4.99,24.95,4.99,3,2,NULL),(4,1,'Transportadora',14.95,4.99,9.99,9.99,3,1,NULL),(5,1,'Transportadora',154.98,4.99,149.99,149.99,4,5,NULL);
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mudanca_status`
--

DROP TABLE IF EXISTS `mudanca_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mudanca_status` (
  `id_mudanca` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_alteracao` date DEFAULT NULL,
  `id_pedido` bigint(20) DEFAULT NULL,
  `id_status` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_mudanca`),
  KEY `FKnttjwkemx8py2v0tcfluoxgp2` (`id_pedido`),
  KEY `FK44rsqfvidiepod1852nqu76aa` (`id_status`),
  KEY `FK35intmkt8shfe35hvcgi8fqjs` (`id_usuario`),
  CONSTRAINT `FK35intmkt8shfe35hvcgi8fqjs` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK44rsqfvidiepod1852nqu76aa` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  CONSTRAINT `FKnttjwkemx8py2v0tcfluoxgp2` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mudanca_status`
--

LOCK TABLES `mudanca_status` WRITE;
/*!40000 ALTER TABLE `mudanca_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `mudanca_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id_pedido` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_pedido` date DEFAULT NULL,
  `id_empresa` bigint(20) DEFAULT NULL,
  `id_pagamento` bigint(20) DEFAULT NULL,
  `id_status` bigint(20) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `servico_frete` varchar(255) DEFAULT NULL,
  `frete` float DEFAULT NULL,
  `subtotal` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `FK5vdgv51dbwnfce3ba3v557u70` (`id_empresa`),
  KEY `FKspv9k2al746dy6kcom4ubrx24` (`id_pagamento`),
  KEY `FKg2dvjgbo0g532frhsj6vc04du` (`id_status`),
  CONSTRAINT `FK5vdgv51dbwnfce3ba3v557u70` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`idEmpresa`),
  CONSTRAINT `FKg2dvjgbo0g532frhsj6vc04du` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  CONSTRAINT `FKspv9k2al746dy6kcom4ubrx24` FOREIGN KEY (`id_pagamento`) REFERENCES `forma_pagamento` (`id_pagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (3,'2016-10-12',1,1,4,'Rua Teste 123','Transportadora',19.99,34.94,54.93),(4,'2016-11-05',1,1,1,'Rua Teste 123','Transportadora',19.99,149.99,169.97);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissao` (
  `id_permissao` bigint(20) NOT NULL AUTO_INCREMENT,
  `action` varchar(255) DEFAULT NULL,
  `controller` varchar(255) DEFAULT NULL,
  `id_tipo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_permissao`),
  KEY `FKbeg0n7gkr4r0qy0m0fpgsnlb4` (`id_tipo`),
  CONSTRAINT `FKbeg0n7gkr4r0qy0m0fpgsnlb4` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'status','',2),(2,'empresa',NULL,2),(3,'produto',NULL,2),(4,'listarPorEmpresa','UsuarioRestController',2),(5,'listarPorEmpresa','PedidoRestController',2),(6,'pedido',NULL,1),(7,'status',NULL,1),(8,'usuario',NULL,2),(9,'listarPorEmpresa','PedidoRestController',1),(10,'listar','PedidoRestController',2),(11,NULL,NULL,2);
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id_produto` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `preco_unitario` double DEFAULT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'acessorio','Mascara do Stifler',9.99),(2,'Consumivéis','Café do Portuga Vral',4.99),(3,'Consumivéis','Café 2 corações',7.99),(4,'Consumivéis','Café Pelão',9.99),(5,'Informática','Tonner de Impressora Genérica',149.99),(6,'Informática','Caneta Paper Matte',149.99),(7,'Informática','Mouse Multlaser Básico',9.99),(8,'Escritório','Bloco de Papel Chamecã0',20.99),(9,NULL,'Débito',NULL);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id_status` bigint(20) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Solicitado'),(2,'Aprovado'),(3,'Em Transporte'),(4,'Entregue');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `id_tipo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Solicitador'),(2,'Administrador'),(3,'Aprovador');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `id_empresa` bigint(20) DEFAULT NULL,
  `id_tipo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKi6afn0oum3c6ejol9ahlluox2` (`id_empresa`),
  KEY `FKd1bqjmpmojrwbrnt7fefaqe74` (`id_tipo`),
  CONSTRAINT `FKd1bqjmpmojrwbrnt7fefaqe74` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id_tipo`),
  CONSTRAINT `FKi6afn0oum3c6ejol9ahlluox2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'080.356.318-37','oliveira.dev1997@gmail.com','oliveira','Leandro Oliveira','123.125.765-1','900150983cd24fb0d6963f7d28e17f72','M','4002-8922',1,2),(2,'999.343.565/32','anofre@teste.com','anofre','Jorge','123.543.234-09','ba8471e91cee56995e9507d80ff42103','M','(11)9-0000-1111',1,3),(3,'803.763.101-03','senaigaveteiros@gmail.com','senai','Senai Gaveteiro','343.654.121-1','900150983cd24fb0d6963f7d28e17f72','F','4002-8922',1,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gaveteiro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-12 17:48:18
