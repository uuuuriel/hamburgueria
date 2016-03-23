CREATE DATABASE  IF NOT EXISTS `hamburgueriabd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hamburgueriabd`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hamburgueriabd
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `bairros`
--

DROP TABLE IF EXISTS `bairros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairros` (
  `id` int(11) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairros`
--

LOCK TABLES `bairros` WRITE;
/*!40000 ALTER TABLE `bairros` DISABLE KEYS */;
INSERT INTO `bairros` VALUES (13787,'SC','8377','Asilo'),(13788,'SC','8377','Badenfurt'),(13789,'SC','8377','Boa Vista'),(13790,'SC','8377','Bom Retiro'),(13791,'SC','8377','Centro'),(13792,'SC','8377','Fidélis'),(13793,'SC','8377','Fortaleza'),(13794,'SC','8377','Garcia'),(13795,'SC','8377','Glória'),(13796,'SC','8377','Vila Itoupava'),(13797,'SC','8377','Itoupava Central'),(13798,'SC','8377','Itoupava Norte'),(13799,'SC','8377','Itoupava Seca'),(13800,'SC','8377','Itoupavazinha'),(13801,'SC','8377','Jardim Blumenau'),(13802,'SC','8377','Passo Manso'),(13804,'SC','8377','Ponta Aguda'),(13805,'SC','8377','Progresso'),(13806,'SC','8377','Ribeirão Fresco'),(13807,'SC','8377','Salto'),(13808,'SC','8377','Salto Norte'),(13809,'SC','8377','Salto Weissbach'),(13810,'SC','8377','Testo Salto'),(13811,'SC','8377','Valparaiso'),(13812,'SC','8377','Velha'),(13813,'SC','8377','Victor Konder'),(13814,'SC','8377','Vila Formosa'),(13815,'SC','8377','Vila Nova'),(13816,'SC','8377','Vorstadt'),(13817,'SC','8390','Águas Claras'),(13818,'SC','8390','Azambuja'),(13819,'SC','8390','Bateas'),(13820,'SC','8390','Cedrinho'),(13821,'SC','8390','Centro'),(13822,'SC','8390','Dom Joaquim'),(13823,'SC','8390','Guarani'),(13824,'SC','8390','Limeira'),(13825,'SC','8390','Limoeiro'),(13826,'SC','8390','Jardim Maluche'),(13827,'SC','8390','Nova Brasília'),(13828,'SC','8390','Poço Fundo'),(13830,'SC','8390','Primeiro de Maio'),(13831,'SC','8390','Rio Branco'),(13832,'SC','8390','Santa Luzia'),(13833,'SC','8390','Santa Rita'),(13834,'SC','8390','Santa Terezinha'),(13835,'SC','8390','São Luiz'),(13836,'SC','8390','São Pedro'),(13837,'SC','8390','Souza Cruz'),(13838,'SC','8390','Steffen'),(13839,'SC','8390','Tomás Coelho'),(13840,'SC','8419','Bela Vista'),(13841,'SC','8419','Belvedere'),(13842,'SC','8419','Boa Vista'),(13843,'SC','8419','Centro'),(13844,'SC','8419','Cristo Rei'),(13845,'SC','8419','Efapi'),(13846,'SC','8419','Eldorado'),(13847,'SC','8419','Esplanada'),(13848,'SC','8419','Jardim América'),(13849,'SC','8419','Jardim Itália'),(13850,'SC','8419','Líder'),(13851,'SC','8419','Maria Goretti'),(13852,'SC','8419','Palmital'),(13853,'SC','8419','Passo dos Fortes'),(13854,'SC','8419','Presidente Médici'),(13855,'SC','8419','Quedas do Palmital'),(13856,'SC','8419','SAIC'),(13857,'SC','8419','Santa Maria'),(13858,'SC','8419','Santo Antônio'),(13859,'SC','8419','São Cristóvão'),(13860,'SC','8419','São Pedro'),(13861,'SC','8419','Seminário'),(13862,'SC','8419','Universitário'),(13863,'SC','8419','Vila Real'),(13864,'SC','8430','Ana Maria'),(13865,'SC','8430','Argentina'),(13866,'SC','8430','Arquimedes Naspolini'),(13867,'SC','8430','Boa Vista'),(13868,'SC','8430','Brasília'),(13869,'SC','8430','Ceará'),(13870,'SC','8430','Centro'),(13871,'SC','8430','Colonial'),(13872,'SC','8430','Coloninha Zilli'),(13873,'SC','8430','Comerciário'),(13874,'SC','8430','Vila Nova Esperança'),(13875,'SC','8430','Cruzeiro do Sul'),(13876,'SC','8430','Imigrantes'),(13877,'SC','8430','Jardim Angélica'),(13878,'SC','8430','Jardim Maristela'),(13879,'SC','8430','Jardim União'),(13880,'SC','8430','Laranjinha'),(13881,'SC','8430','Lote Seis'),(13882,'SC','8430','Maria Céu'),(13883,'SC','8430','Metropol'),(13884,'SC','8430','Michel'),(13885,'SC','8430','Mina Brasil'),(13886,'SC','8430','Mina do Mato'),(13888,'SC','8430','Mina União'),(13889,'SC','8430','Mineira Nova'),(13890,'SC','8430','Mineira Velha'),(13891,'SC','8430','Nossa Senhora da Salete'),(13892,'SC','8430','Operária Nova'),(13893,'SC','8430','Paraíso'),(13895,'SC','8430','Pinheirinho'),(13896,'SC','8430','Pio Corrêa'),(13898,'SC','8430','Próspera'),(13899,'SC','8430','Quarta Linha'),(13900,'SC','8430','Rio Maina'),(13901,'SC','8430','Sangão'),(13902,'SC','8430','Santa Augusta'),(13903,'SC','8430','Santa Bárbara'),(13904,'SC','8430','Santa Catarina'),(13905,'SC','8430','Santa Luzia'),(13906,'SC','8430','Santo Antônio'),(13908,'SC','8430','São Cristóvão'),(13909,'SC','8430','São Defende'),(13910,'SC','8430','São Francisco'),(13911,'SC','8430','São João'),(13912,'SC','8430','São Luiz'),(13913,'SC','8430','São Simão'),(13914,'SC','8430','Universitário'),(13915,'SC','8430','Vera Cruz'),(13916,'SC','8430','Recanto Verde'),(13917,'SC','8430','Vila Macarini'),(13918,'SC','8430','Vila São José'),(13919,'SC','8430','Vila Visconde'),(13920,'SC','8430','Vila Zuleima'),(13921,'SC','8452','Abraão'),(13922,'SC','8452','Agronômica'),(13923,'SC','8452','Armação do Pântano do Sul'),(13924,'SC','8452','Balneário'),(13925,'SC','8452','Barra da Lagoa'),(13926,'SC','8452','Bom Abrigo'),(13927,'SC','8452','Cachoeira do Bom Jesus'),(13928,'SC','8452','Cacupé'),(13931,'SC','8452','Campeche'),(13932,'SC','8452','Canasvieiras'),(13933,'SC','8452','Capoeiras'),(13934,'SC','8452','Carianos'),(13936,'SC','8452','Centro'),(13937,'SC','8452','Coloninha'),(13938,'SC','8452','Coqueiros'),(13939,'SC','8452','Córrego Grande'),(13940,'SC','8452','Costeira do Pirajubaé'),(13941,'SC','8452','Daniela'),(13942,'SC','8452','Estreito'),(13944,'SC','8452','Ingleses do Rio Vermelho'),(13945,'SC','8452','Itacorubi'),(13946,'SC','8452','Itaguaçu'),(13947,'SC','8452','Jardim Atlântico'),(13948,'SC','8452','José Mendes'),(13949,'SC','8452','Jurerê'),(13950,'SC','8452','Lagoa da Conceição'),(13952,'SC','8452','Pantanal'),(13953,'SC','8452','Pântano do Sul'),(13956,'SC','8452','Ratones'),(13957,'SC','8452','Ribeirão da Ilha'),(13958,'SC','8452','Rio Tavares'),(13959,'SC','8452','São João do Rio Vermelho'),(13960,'SC','8452','Saco dos Limões'),(13961,'SC','8452','Saco Grande'),(13962,'SC','8452','Sambaqui'),(13963,'SC','8452','Santa Mônica'),(13964,'SC','8452','Santo Antônio de Lisboa'),(13965,'SC','8452','Tapera'),(13966,'SC','8452','Trindade'),(13967,'SC','8452','Vargem Grande'),(13968,'SC','8452','Vargem Pequena'),(13969,'SC','8507','Barra do Rio'),(13970,'SC','8507','Cabeçudas'),(13972,'SC','8507','Centro'),(13973,'SC','8507','Cordeiros'),(13975,'SC','8507','Dom Bosco'),(13976,'SC','8507','Fazenda'),(13981,'SC','8507','Itaipava'),(13982,'SC','8507','Ressacada'),(13983,'SC','8507','Salseiros'),(13984,'SC','8507','Praia Brava'),(13985,'SC','8507','São João'),(13986,'SC','8507','São Judas'),(13987,'SC','8507','São Vicente'),(13988,'SC','8507','Vila Operária'),(13989,'SC','8518','Água Verde'),(13990,'SC','8518','Amizade'),(13991,'SC','8518','Baependi'),(13992,'SC','8518','Barra do Rio Cerro'),(13993,'SC','8518','Barra do Rio Molha'),(13994,'SC','8518','Centenário'),(13995,'SC','8518','Centro'),(13996,'SC','8518','Chico de Paula'),(13997,'SC','8518','Czerniewicz'),(13998,'SC','8518','Estrada Nova'),(13999,'SC','8518','Ilha da Figueira'),(14000,'SC','8518','Jaraguá Esquerdo'),(14001,'SC','8518','Jaraguá 99'),(14002,'SC','8518','João Pessoa'),(14003,'SC','8518','Nereu Ramos'),(14004,'SC','8518','Nova Brasília'),(14005,'SC','8518','Parque Malwee'),(14006,'SC','8518','Rau'),(14008,'SC','8518','Rio Cerro I'),(14009,'SC','8518','Rio Cerro II'),(14010,'SC','8518','Rio da Luz'),(14011,'SC','8518','Santa Luzia'),(14012,'SC','8518','Santo Antônio'),(14013,'SC','8518','São Luís'),(14014,'SC','8518','Tifa Martins'),(14015,'SC','8518','Tifa Monos'),(14016,'SC','8518','Três Rios do Norte'),(14017,'SC','8518','Três Rios do Sul'),(14018,'SC','8518','Vieira'),(14019,'SC','8518','Vila Lalau'),(14020,'SC','8518','Vila Lenzi'),(14021,'SC','8518','Vila Nova'),(14022,'SC','8521','Adhemar Garcia'),(14023,'SC','8521','América'),(14024,'SC','8521','Anita Garibaldi'),(14025,'SC','8521','Atiradores'),(14026,'SC','8521','Aventureiro'),(14027,'SC','8521','Boa Vista'),(14028,'SC','8521','Boehmerwald'),(14029,'SC','8521','Bom Retiro'),(14030,'SC','8521','Bucarein'),(14031,'SC','8521','Centro'),(14032,'SC','8521','Comasa'),(14033,'SC','8521','Costa e Silva'),(14034,'SC','8521','Zona Industrial Norte'),(14035,'SC','8521','Vila Cubatão'),(14036,'SC','8521','Fátima'),(14037,'SC','8521','Floresta'),(14038,'SC','8521','Glória'),(14039,'SC','8521','Guanabara'),(14040,'SC','8521','Iririú'),(14041,'SC','8521','Itaum'),(14042,'SC','8521','Itinga'),(14043,'SC','8521','Jardim Iririú'),(14044,'SC','8521','Jardim Paraíso'),(14045,'SC','8521','Jardim Sofia'),(14046,'SC','8521','Jarivatuba'),(14047,'SC','8521','João Costa'),(14048,'SC','8521','Morro do Meio'),(14049,'SC','8521','Nova Brasília'),(14050,'SC','8521','Paranaguamirim'),(14051,'SC','8521','Petrópolis'),(14052,'SC','8521','Centro (Pirabeiraba)'),(14053,'SC','8521','Saguaçu'),(14054,'SC','8521','Santa Catarina'),(14055,'SC','8521','Santo Antônio'),(14056,'SC','8521','São Marcos'),(14057,'SC','8521','Vila Nova'),(14058,'SC','8525','Área Industrial'),(14059,'SC','8525','Araucária'),(14060,'SC','8525','Bates'),(14061,'SC','8525','Beatriz'),(14062,'SC','8525','Bela Vista'),(14063,'SC','8525','Boqueirão'),(14064,'SC','8525','Brusque'),(14065,'SC','8525','Caça e Tiro'),(14066,'SC','8525','Caravágio'),(14067,'SC','8525','Caroba'),(14068,'SC','8525','CDL'),(14069,'SC','8525','Centenário'),(14070,'SC','8525','Centro'),(14071,'SC','8525','Cidade Alta'),(14072,'SC','8525','Conta Dinheiro'),(14073,'SC','8525','Copacabana'),(14074,'SC','8525','Coral'),(14075,'SC','8525','Cristal'),(14076,'SC','8525','Dom Daniel'),(14077,'SC','8525','Ferrovia'),(14078,'SC','8525','Frei Rogério'),(14079,'SC','8525','Gethal'),(14081,'SC','8525','Guarujá'),(14082,'SC','8525','Habitação'),(14083,'SC','8525','Ipiranga'),(14084,'SC','8525','Jardim Celina'),(14085,'SC','8525','Jardim Cepar'),(14086,'SC','8525','Jardim das Camélias'),(14087,'SC','8525','Jardim Panorâmico'),(14088,'SC','8525','Maria Luiza'),(14089,'SC','8525','Morro do Posto'),(14090,'SC','8525','Morro Grande'),(14091,'SC','8525','Nossa Senhora Aparecida'),(14092,'SC','8525','Nova Petrópolis'),(14093,'SC','8525','Passo Fundo'),(14094,'SC','8525','Penha'),(14095,'SC','8525','Petrópolis'),(14096,'SC','8525','Pisani'),(14097,'SC','8525','Ponte Grande'),(14098,'SC','8525','Popular'),(14099,'SC','8525','Promorar'),(14100,'SC','8525','Restinga Seca'),(14101,'SC','8525','Sagrado Coração de Jesus'),(14102,'SC','8525','Santa Cândida'),(14103,'SC','8525','Santa Catarina'),(14104,'SC','8525','Santa Clara'),(14105,'SC','8525','Santa Helena'),(14106,'SC','8525','Santa Maria'),(14107,'SC','8525','Santa Mônica'),(14108,'SC','8525','Santa Rita'),(14109,'SC','8525','Santo Antônio'),(14110,'SC','8525','São Carlos'),(14111,'SC','8525','São Cristóvão'),(14112,'SC','8525','São Francisco'),(14113,'SC','8525','São Luiz'),(14114,'SC','8525','São Miguel'),(14115,'SC','8525','São Paulo'),(14116,'SC','8525','São Sebastião'),(14118,'SC','8525','Triângulo'),(14119,'SC','8525','Tributo'),(14120,'SC','8525','Universitário'),(14121,'SC','8525','Várzea'),(14122,'SC','8525','Vila Comboni'),(14123,'SC','8525','Vila Maria'),(14124,'SC','8525','Vila Mariza'),(14125,'SC','8525','Vila Nova'),(14126,'SC','8589','Alto Aririu'),(14127,'SC','8589','Aririu'),(14128,'SC','8589','Aririú da Formiga'),(14129,'SC','8589','Barra do Aririú'),(14130,'SC','8589','Bela Vista'),(14131,'SC','8589','Brejarú'),(14132,'SC','8589','Caminho Novo'),(14133,'SC','8589','Centro'),(14134,'SC','8589','Guarda do Cubatão'),(14135,'SC','8589','Pacheco'),(14136,'SC','8589','Passa Vinte'),(14137,'SC','8589','Ponte do Imaruim'),(14138,'SC','8589','Praia de Fora'),(14139,'SC','8589','Rio Grande'),(14140,'SC','8589','São Sebastião'),(14141,'SC','8589','Terra Fraca'),(14142,'SC','8700','Areias'),(14143,'SC','8700','Barreiros'),(14144,'SC','8700','Bela Vista'),(14145,'SC','8700','Campinas'),(14146,'SC','8700','Centro'),(14147,'SC','8700','Jardim Cidade de Florianópolis'),(14148,'SC','8700','Fazenda Santo Antônio'),(14149,'SC','8700','Forquilhas'),(14150,'SC','8700','Ipiranga'),(14151,'SC','8700','Kobrasol'),(14152,'SC','8700','São Luiz'),(14153,'SC','8700','Nossa Senhora do Rosário'),(14155,'SC','8700','Picadas do Sul'),(14156,'SC','8700','Ponta de Baixo'),(14157,'SC','8700','Praia Comprida'),(14158,'SC','8700','Real Parque'),(14159,'SC','8700','Roçado'),(14162,'SC','8700','Serraria'),(14163,'SC','8742','Aeroporto'),(14164,'SC','8742','Campestre'),(14165,'SC','8742','Centro'),(14166,'SC','8742','Comasa'),(14167,'SC','8742','Congonhas'),(14168,'SC','8742','Dehon'),(14169,'SC','8742','Fábio Silva'),(14170,'SC','8742','Guarda'),(14171,'SC','8742','Humaitá'),(14172,'SC','8742','Humaitá de Cima'),(14173,'SC','8742','Madre'),(14174,'SC','8742','Monte Castelo'),(14175,'SC','8742','Morrotes'),(14176,'SC','8742','Oficinas'),(14177,'SC','8742','Passagem'),(14178,'SC','8742','Passo do Gado'),(14179,'SC','8742','Recife'),(14180,'SC','8742','Revoredo'),(14181,'SC','8742','Santo Antônio de Pádua'),(14182,'SC','8742','São Bernardo'),(14183,'SC','8742','São Clemente'),(14184,'SC','8742','São Cristóvão'),(14185,'SC','8742','São João (Margem Esquerda)'),(14186,'SC','8742','São João (Margem Direita)'),(14187,'SC','8742','São Martinho'),(14188,'SC','8742','Sertão dos Correias'),(14189,'SC','8742','Vila Esperança'),(14190,'SC','8742','Vila Moema'),(29952,'SC','8430','Mãe Luzia'),(29965,'SC','8430','São Marcos'),(29991,'SC','8419','Pinheirinho'),(30009,'SC','8419','Engenho Braun'),(30014,'SC','8419','Alvorada'),(30369,'SC','8419','Vila Rica'),(30370,'SC','8419','Trevo'),(30392,'SC','8589','Cidade Universitária Pedra Branca'),(30593,'SC','8700','Sertão do Maruim'),(30594,'SC','8700','Colônia Santana'),(30624,'SC','8742','Kilômetro 60'),(30785,'SC','8521','Espinheiros'),(30957,'SC','8525','Cruz de Malta'),(33047,'SC','8400','Bateias de Baixo'),(33471,'SC','8711','Centro'),(33511,'SC','8465','Centro'),(33943,'SC','8612','Pinheiros'),(34326,'SC','8700','Santos Saraiva'),(34359,'SC','8528','Cabeçudas'),(34360,'SC','8528','Povoado de Barreiros'),(34361,'SC','8528','Povoado de Passagem da Barra'),(34362,'SC','8528','Povoado de Laranjeiras'),(34365,'SC','8605','Pescaria Brava'),(34366,'SC','8640','Ribeirão Pequeno'),(34583,'SC','8528','Pescaria Brava'),(34584,'SC','8407','Pinheiros'),(34585,'SC','8528','Ribeirão Pequeno'),(34816,'SC','8327','Centro'),(34821,'SC','8333','Centro'),(34822,'SC','8342','Centro'),(34824,'SC','8348','Centro'),(34827,'SC','8360','Centro'),(34831,'SC','8433','Centro'),(34834,'SC','8361','Centro'),(34835,'SC','8374','Centro'),(34836,'SC','8381','Centro'),(34837,'SC','8382','Centro'),(34838,'SC','8389','Centro'),(34840,'SC','8729','Taquara Verde'),(34841,'SC','8425','Centro'),(34842,'SC','8427','Centro'),(34843,'SC','8432','Centro'),(34844,'SC','8442','Centro'),(34845,'SC','8451','Centro'),(34848,'SC','8453','Centro'),(34849,'SC','8458','Centro'),(34850,'SC','8475','Centro'),(34851,'SC','8479','Centro'),(34852,'SC','8492','Centro'),(34853,'SC','8496','Centro'),(34854,'SC','8502','Centro'),(34855,'SC','8519','Centro'),(34857,'SC','8670','Santa Helena'),(34858,'SC','8523','Centro'),(34859,'SC','8529','Centro'),(34860,'SC','8542','Centro'),(34861,'SC','8565','Centro'),(34863,'SC','8576','Centro'),(34865,'SC','8581','Centro'),(34867,'SC','8587','Centro'),(34876,'SC','8595','Centro'),(34877,'SC','8598','Centro'),(34878,'SC','8616','Centro'),(34879,'SC','8620','Centro'),(34880,'SC','8632','Centro'),(34881,'SC','8658','Centro'),(34882,'SC','8663','Centro'),(34883,'SC','8669','Centro'),(34884,'SC','8678','Centro'),(34885,'SC','8685','Centro'),(34886,'SC','8696','Centro'),(34887,'SC','8726','Centro'),(34888,'SC','8732','Centro'),(34889,'SC','8752','Centro'),(34890,'SC','8753','Centro'),(34891,'SC','8766','Centro'),(34997,'SC','8336','Betania'),(35220,'SC','8388','Centro'),(35221,'SC','8463','Povoado de Barracão'),(35222,'SC','8463','Povoado de Belchior Alto'),(35225,'SC','8435','Distrito de Dalbérgia'),(35226,'SC','8674','Distrito de Santa Maria'),(35238,'SC','8561','Centro'),(35240,'SC','8677','Centro'),(35241,'SC','8597','Distrito de Passo Manso'),(35242,'SC','8351','Distrito de Aterrado Torto'),(35307,'SC','8463','Centro'),(35308,'SC','8463','Bela Vista'),(35309,'SC','8341','Centro'),(35310,'SC','8349','Centro'),(35311,'SC','8352','Centro'),(35312,'SC','8375','Centro'),(35313,'SC','8438','Centro'),(35314,'SC','8439','Centro'),(35315,'SC','8482','Centro'),(35316,'SC','8488','Centro'),(35317,'SC','8522','Centro'),(35318,'SC','8530','Centro'),(35319,'SC','8537','Centro'),(35320,'SC','8618','Centro'),(35321,'SC','8624','Centro'),(35322,'SC','8628','Centro'),(35323,'SC','8559','Centro'),(35324,'SC','8631','Centro'),(35325,'SC','8649','Centro'),(35326,'SC','8650','Centro'),(35327,'SC','8652','Centro'),(35328,'SC','8659','Centro'),(35329,'SC','8662','Centro'),(35330,'SC','8727','Centro'),(35331,'SC','8735','Centro'),(35332,'SC','8741','Centro'),(35333,'SC','8761','Centro'),(35334,'SC','8762','Centro'),(35393,'SC','8355','Arroio do Silva'),(35394,'SC','8378','Centro'),(35395,'SC','8417','Centro'),(35396,'SC','8418','Centro'),(35397,'SC','8443','Centro'),(35402,'SC','8330','Centro'),(35405,'SC','8483','Balneário Rincão'),(35407,'SC','8486','Araçatuba'),(35408,'SC','8486','Povoado de Nova Brasília'),(35409,'SC','8560','Centro'),(35410,'SC','8760','Distrito de Vila Nova'),(35411,'SC','8369','Barro Branco'),(35412,'SC','8474','Guatá'),(35413,'SC','8531','Povoado de Itanema'),(35414,'SC','8446','Distrito Estação Cocal'),(35415,'SC','8570','Centro'),(35416,'SC','8572','Centro'),(35417,'SC','8683','São Bento Baixo'),(35418,'SC','8608','Pindotiba'),(35419,'SC','8588','Centro'),(35420,'SC','8591','Centro'),(35421,'SC','8596','Centro'),(35422,'SC','8625','Cachoeira de Fátima'),(35423,'SC','8666','Morro Grande'),(35425,'SC','8575','Nova Guarita'),(35426,'SC','8738','Centro'),(35427,'SC','8693','Distrito de São Gabriel'),(35428,'SC','8750','Centro'),(35429,'SC','8750','Povoado de Santana'),(35430,'SC','8489','Centro'),(35923,'SC','8336','Centro'),(35925,'SC','8346','Rio Engano'),(35926,'SC','8362','Centro'),(35927,'SC','8460','Centro'),(35950,'SC','8617','Poço Preto'),(35956,'SC','8319','Centro'),(35957,'SC','8320','Centro'),(35986,'SC','8344','Centro'),(35987,'SC','8476','Hercílio Luz'),(36078,'SC','8385','Distrito de Canto Grande'),(36079,'SC','8323','Centro'),(36080,'SC','8326','Centro'),(36087,'SC','8725','Sorocaba do Sul'),(36088,'SC','8376','Centro'),(36090,'SC','8731','Distrito de Tigipió'),(36091,'SC','8610','Distrito de Pinheiral'),(36092,'SC','8420','Distrito de Claraiba'),(36093,'SC','8329','Distrito de Aguti'),(36095,'SC','8484','Centro'),(36096,'SC','8730','Distrito de Taquaras'),(36097,'SC','8335','Centro'),(36098,'SC','8347','Centro'),(36099,'SC','8391','Centro'),(36100,'SC','8394','Centro'),(36101,'SC','8402','Centro'),(36102,'SC','8403','Centro'),(36103,'SC','8409','Centro'),(36104,'SC','8412','Centro'),(36105,'SC','8414','Centro'),(36106,'SC','8424','Centro'),(36107,'SC','8426','Centro'),(36108,'SC','8431','Centro'),(36109,'SC','8436','Cento'),(36110,'SC','8437','Centro'),(36111,'SC','8444','Centro'),(36112,'SC','8447','Centro'),(36113,'SC','8456','Centro'),(36114,'SC','8459','Centro'),(36115,'SC','8471','Centro'),(36116,'SC','8473','Centro'),(36117,'SC','8478','Centro'),(36118,'SC','8480','Centro'),(36119,'SC','8493','Centro'),(36120,'SC','8495','Centro'),(36121,'SC','8681','Centro'),(36122,'SC','8497','Centro'),(36123,'SC','8498','Centro'),(36124,'SC','8500','Centro'),(36125,'SC','8504','Centro'),(36126,'SC','8510','Centro'),(36127,'SC','8515','Centro'),(36128,'SC','8520','Centro'),(36129,'SC','8524','Centro'),(36130,'SC','8533','Centro'),(36131,'SC','8535','Centro'),(36132,'SC','8540','Centro'),(36133,'SC','8549','Centro'),(36134,'SC','8562','Centro'),(36135,'SC','8563','Centro'),(36136,'SC','8574','Centro'),(36137,'SC','8328','Centro'),(36138,'SC','8584','Centro'),(36139,'SC','8590','Centro'),(36140,'SC','8592','Centro'),(36141,'SC','8604','Centro'),(36142,'SC','8609','Centro'),(36143,'SC','8611','Centro'),(36144,'SC','8614','Centro'),(36145,'SC','8621','Centro'),(36146,'SC','8627','Centro'),(36147,'SC','8634','Centro'),(36148,'SC','8646','Centro'),(36149,'SC','8660','Centro'),(36150,'SC','8664','Centro'),(36151,'SC','8667','Centro'),(36152,'SC','8687','Centro'),(36153,'SC','8689','Centro'),(36154,'SC','8691','Centro'),(36155,'SC','8701','Padre Reus'),(36156,'SC','8705','Centro'),(36157,'SC','8708','Centro'),(36158,'SC','8717','Centro'),(36159,'SC','8719','Centro'),(36160,'SC','8721','Centro'),(36161,'SC','8728','Centro'),(36162,'SC','8736','Centro'),(36163,'SC','8740','Centro'),(36164,'SC','8743','Centro'),(36165,'SC','8746','Centro'),(36166,'SC','8751','Centro'),(36167,'SC','8756','Centro'),(36168,'SC','8763','Centro'),(36169,'SC','8764','Centro'),(36170,'SC','8765','Centro'),(36171,'SC','8340','Centro'),(36172,'SC','8733','Centro'),(36173,'SC','8622','Centro'),(36174,'SC','8385','Centro'),(36175,'SC','8509','Centro'),(36176,'SC','8405','Centro'),(36177,'SC','8694','Centro'),(36178,'SC','8544','Centro'),(36179,'SC','8579','Centro'),(36180,'SC','8357','Centro'),(36181,'SC','8396','Centro'),(36182,'SC','8469','Centro'),(36185,'SC','8386','Centro'),(36186,'SC','8571','Centro'),(36187,'SC','8607','Centro'),(36189,'SC','8602','Centro'),(36190,'SC','8367','Centro'),(36191,'SC','8514','Centro'),(36192,'SC','8350','Centro'),(36193,'SC','8321','Centro'),(36195,'SC','8606','Centro'),(36196,'SC','8487','Centro'),(36197,'SC','8755','Centro'),(36198,'SC','8534','Centro'),(36200,'SC','8331','Centro'),(36201,'SC','8636','Centro'),(36203,'SC','8338','Centro'),(36206,'SC','8686','Centro'),(36207,'SC','8600','Centro'),(36209,'SC','8461','Centro'),(36210,'SC','8461','Povoado de Campo D\'una'),(36211,'SC','8428','Centro'),(36212,'SC','8583','Pinheiros'),(36213,'SC','8408','Centro'),(36214,'SC','8619','Centro'),(36215,'SC','8702','Centro'),(36216,'SC','8401','Centro'),(36217,'SC','8337','Centro'),(36218,'SC','8416','Centro'),(36219,'SC','8699','Centro'),(36220,'SC','8749','Centro'),(36221,'SC','8380','Centro'),(36222,'SC','8747','Centro'),(36224,'SC','8657','Centro'),(36226,'SC','8383','Centro'),(36228,'SC','8739','Centro'),(36229,'SC','8517','Centro'),(36230,'SC','8666','Distrito de Morro Grande'),(36231,'SC','8601','Centro'),(36233,'SC','8706','Centro'),(36235,'SC','8468','Centro'),(36236,'SC','8468','Povoado Termas do Gravatal'),(36238,'SC','8666','Centro'),(36241,'SC','8345','Centro'),(36242,'SC','8387','Centro'),(36243,'SC','8653','Centro'),(36244,'SC','8675','Centro'),(36245,'SC','8707','Centro'),(36246,'SC','8754','Distrito de Vargem do Cedro'),(36247,'SC','8485','Centro'),(36248,'SC','8485','Povoado Sítio Novo'),(36250,'SC','8486','Centro'),(36256,'SC','8528','Centro'),(36259,'SC','8483','Centro'),(36261,'SC','8568','Centro'),(36263,'SC','8750','Povoado Rio América'),(36265,'SC','8421','Centro'),(36266,'SC','8454','Centro'),(36267,'SC','8723','Centro'),(36269,'SC','8580','Centro'),(36271,'SC','8582','Centro'),(36272,'SC','8531','Centro'),(36273,'SC','8466','Centro'),(36277,'SC','8516','Centro'),(36278,'SC','8625','Centro'),(36285,'SC','8724','Centro'),(36286,'SC','8358','Centro'),(36287,'SC','8546','Centro'),(36290,'SC','8558','Centro'),(36292,'SC','8745','Centro'),(36297,'SC','8734','Centro'),(36298,'SC','8676','Centro'),(36299,'SC','8698','Centro'),(36301,'SC','8392','Cachoeira de Fátima'),(36302,'SC','8556','Centro'),(36303,'SC','8539','Centro'),(36314,'SC','8463','Gasparinho'),(36378,'SC','8452','Monte Verde'),(36379,'SC','8452','João Paulo'),(36463,'SC','8452','Ponta das  Canas'),(36464,'SC','8452','Praia Brava'),(36486,'SC','8452','Jurerê Internacional'),(37025,'SC','8452','Monte Cristo'),(37129,'SC','8452','Canto'),(38025,'SC','8364','Distrito de Barra da Prata'),(38054,'SC','8379','Distrito de Boiteuxburgo'),(38055,'SC','8672','Distrito de Santa Lúcia'),(38056,'SC','8322','Centro'),(38057,'SC','8343','Centro'),(38058,'SC','8356','Centro'),(38059,'SC','8400','Centro'),(38060,'SC','8407','Centro'),(38061,'SC','8429','Centro'),(38062,'SC','8462','Centro'),(38063,'SC','8472','Centro'),(38064,'SC','8503','Centro'),(38065,'SC','8506','Centro'),(38066,'SC','8511','Itapema do Norte'),(38067,'SC','8543','Centro'),(38068,'SC','8545','Centro'),(38069,'SC','8552','Centro'),(38070,'SC','8557','Centro'),(38071,'SC','8566','Centro'),(38072,'SC','8594','Centro'),(38073,'SC','8623','Centro'),(38074,'SC','8648','Centro'),(38075,'SC','8655','Centro'),(38076,'SC','8684','Centro'),(38077,'SC','8692','Centro'),(38078,'SC','8718','Centro'),(38079,'SC','8737','Centro'),(38080,'SC','8410','Centro'),(38081,'SC','8344','Cidade Alta'),(38082,'SC','8409','Alto Alegre'),(38083,'SC','8365','Distrito de Barra Fria'),(38084,'SC','8370','Distrito de Bateias de Baixo'),(38085,'SC','8371','Distrito de Bela Vista'),(38086,'SC','8372','Distrito de Bela Vista do Sul'),(38087,'SC','8373','Centro'),(38088,'SC','8395','Centro'),(38089,'SC','8449','Distrito de Felipe Schmidt'),(38090,'SC','8455','Povoado de Fragosos'),(38091,'SC','8477','Distrito de Herciliópolis'),(38092,'SC','8494','Distrito de Ipoméia'),(38093,'SC','8501','Distrito de Iraputã'),(38094,'SC','8505','Distrito de Itaió'),(38095,'SC','8550','Distrito de Marcílio Dias'),(38096,'SC','8559','Distrito de Mirador'),(38097,'SC','8577','Distrito de Nova Petrópolis'),(38098,'SC','8599','Distrito de Paula Pereira'),(38099,'SC','8638','Distrito de Residência Fuck'),(38100,'SC','8656','Distrito de Rio Preto do Sul'),(38101,'SC','8661','Distrito de Sai'),(38102,'SC','8668','Centro'),(38103,'SC','8688','Distrito de São Cristóvão'),(38104,'SC','8676','Vila São João'),(38105,'SC','8695','Centro'),(38106,'SC','8703','Distrito de São José do Laranjal'),(38107,'SC','8710','Distrito de São Miguel da Serra'),(38108,'SC','8758','Distrito de Vila de Volta Grande'),(38110,'SC','8488','Nações'),(38111,'SC','8332','Distrito de Alto Alegre'),(38112,'SC','8460','Distrito de Garcia'),(38114,'SC','8560','Distrito de Mirim'),(39298,'SC','8748','Distrito de Uruguai'),(39299,'SC','8567','Distrito de Morro Chato'),(39483,'SC','8507','Espinheiros'),(39653,'SC','8684','Oxford'),(39654,'SC','8528','Mar Grosso'),(40348,'SC','8509','Meia Praia'),(40654,'SC','8406','Centro'),(40655,'SC','8642','Centro'),(40656,'SC','8342','Nova Estrela'),(41739,'SC','8419','Parque das Palmeiras'),(43012,'SC','8334','Centro'),(43057,'SC','8521','Dona Francisca (Piraberaba)'),(43058,'SC','8521','Rio Bonito (Piraberaba)'),(43127,'SC','8700','Forquilhinha'),(43128,'SC','8700','Flor de Nápolis'),(43146,'SC','8433','São José'),(43147,'SC','8463','Gasparino'),(43165,'SC','8481','Centro'),(43166,'SC','8470','Centro'),(43536,'SC','8488','Carijós'),(43691,'SC','8711','Santa Teresa'),(43720,'SC','8357','Pioneiros'),(43721,'SC','8357','Praia dos Amores'),(43722,'SC','8357','Barra'),(43723,'SC','8357','São Judas Tadeu'),(43725,'SC','8357','Nova Esperança'),(43726,'SC','8357','Vila Real'),(43727,'SC','8357','Jardim Iate Clube'),(43728,'SC','8357','Municípios'),(43729,'SC','8357','Nações'),(43730,'SC','8357','Ariribá'),(43731,'SC','8357','Estados'),(43732,'SC','8357','Várzea do Ranchinho'),(44069,'SC','8525','Bom Jesus'),(44070,'SC','8525','Guadalupe'),(44071,'SC','8525','Chapada'),(44072,'SC','8525','São Pedro'),(44076,'SC','8742','Praia Redonda'),(44077,'SC','8742','Santa Luzia'),(44195,'SC','8354','Centro'),(44196,'SC','8527','Centro'),(44197,'SC','8573','Centro'),(44199,'SC','8716','Centro'),(44200,'SC','8508','Centro'),(44201,'SC','8602','Itapocoroi'),(44202,'SC','8328','Santa Cruz da Figueira'),(44203,'SC','8757','Centro'),(44204,'SC','8692','Ubatuba'),(44205,'SC','8366','Centro'),(44206,'SC','8450','Centro'),(44207,'SC','8464','Centro'),(44208,'SC','10752','Centro'),(44209,'SC','10751','Centro'),(44211,'SC','8712','Centro'),(44224,'SC','8486','Ibiraquera'),(45007,'SC','8700','Bosque das Mansões'),(45958,'SC','8589','Enseada do Brito (Ens Brito)'),(48109,'SC','8709','Centro'),(48110,'SC','8452','Vargem do Bom Jesus'),(48448,'SC','8357','Praia das Taquaras'),(48449,'SC','8357','Praia do Estaleiro'),(48450,'SC','8357','Praia do Estaleirinho'),(48495,'SC','8603','Centro'),(48496,'SC','8585','Centro'),(48497,'SC','8512','Distrito de Itapocu'),(48498,'SC','8528','Santiago'),(48501,'SC','8390','São João'),(48534,'SC','8324','Centro'),(48720,'SC','8375','Barra São João'),(48721,'SC','8353','Centro'),(48736,'SC','8554','Marombas'),(48737,'SC','8532','Leão'),(48738,'SC','8677','Craveiro'),(48739,'SC','8644','Rio da Anta'),(48753,'SC','8517','Camacho'),(48754,'SC','8517','Campo Bom'),(48755,'SC','8517','Olho D\'Água'),(48765,'SC','8539','Vila do Salto'),(48766,'SC','8602','Armação'),(48767,'SC','8546','Vila Beatriz'),(48804,'SC','8700','Distrito Industrial'),(48809,'SC','8700','Potecas'),(48819,'SC','8700','Jardim Santiago'),(48847,'SC','8700','Pedregal'),(48863,'SC','8507','Canhanduba'),(48864,'SC','8507','Cidade Nova'),(48865,'SC','8452','Morro das Pedras'),(48953,'SC','8323','Três Pinheiros'),(48979,'SC','8430','Vila Manaus'),(49054,'SC','8486','Itapiruba'),(49058,'SC','8486','Roca Grande'),(49059,'SC','8486','Guaiuba'),(49183,'SC','8464','Goio-En'),(49184,'SC','8692','Forte'),(49380,'SC','8692','Balneário Enseada'),(49381,'SC','8411','Centro'),(49382,'SC','8578','Centro'),(49475,'SC','8430','Cristo Redentor'),(49512,'SC','8536','Centro'),(49513,'SC','8665','Centro'),(49515,'SC','8641','Centro'),(49574,'SC','8641','Rio Antinha'),(49733,'SC','8699','São Sebastião'),(49734,'SC','8699','Santa Izabel'),(49742,'SC','8715','Centro'),(49743,'SC','8671','Centro'),(49773,'SC','8491','Centro'),(49778,'SC','8699','São Sebastião do Arvoredo'),(49904,'SC','8407','Campo da Agua Verde'),(50020,'SC','8714','Centro'),(50106,'SC','8553','Centro'),(50219,'SC','8471','Ouro Verde'),(50265,'SC','8434','Centro'),(50361,'SC','8586','Centro'),(50478,'SC','8390','Cedro Alto'),(50535,'SC','8359','Centro'),(50536,'SC','8652','Centro (Rio Rosinha)'),(50537,'SC','8643','Centro'),(50549,'SC','8415','Centro'),(50746,'SC','8430','Fábio Silva'),(50805,'SC','8507','Quilometro 12'),(50806,'SC','8507','Baia'),(50807,'SC','8507','Arraial dos Cunhas'),(50808,'SC','8507','Paciência'),(50809,'SC','8507','Brilhante I'),(50810,'SC','8507','Brilhante II'),(50811,'SC','8507','Campeche'),(50812,'SC','8507','Limoeiro'),(50841,'SC','8521','Parque Guarani'),(50842,'SC','8521','Ulisses Guimarães'),(50843,'SC','8521','Profipo'),(50844,'SC','8521','Brasília'),(50913,'SC','8430','Vila Floresta'),(50914,'SC','8430','Progresso'),(50915,'SC','8430','Morro Estevão'),(50916,'SC','8430','Jardim Montevidéu'),(50917,'SC','8430','Imperatriz'),(50918,'SC','8430','Promorar Vila Vitória'),(50919,'SC','8430','São Roque'),(50920,'SC','8430','Vila São Sebastião'),(50921,'SC','8430','Vila Rica'),(50922,'SC','8430','Renascer'),(50923,'SC','8430','Vila Floresta II'),(50924,'SC','8430','Vila Francesa'),(50925,'SC','8430','Monte Castelo'),(50926,'SC','8430','Liberdade'),(50927,'SC','8430','Vila Isabel'),(50928,'SC','8430','Distrito Industrial'),(50929,'SC','8430','Catarinense'),(50930,'SC','8430','Wosocris'),(50931,'SC','8430','Vila Miguel'),(50932,'SC','8430','Estaçãozinha'),(50933,'SC','8430','Poço Um'),(50934,'SC','8430','Milanese'),(50935,'SC','8430','Bosque do Repouso'),(50936,'SC','8430','Tereza Cristina'),(51235,'SC','8723','Vila São Jorge'),(51372,'SC','8389','Marombas'),(51481,'SC','8430','Jardim das Paineiras'),(51482,'SC','8430','Primeira Linha'),(51483,'SC','8430','Pedro Zanivan'),(51484,'SC','8430','Verdinho'),(51485,'SC','8430','Dagostin'),(51486,'SC','8430','São Domingos'),(51487,'SC','8430','Demboski'),(51536,'SC','8430','Nossa Senhora do Carmo'),(51538,'SC','8430','Mina do Toco'),(51855,'SC','8589','Pinheira (Ens Brito)'),(51870,'SC','8589','Maciambú (Ens Brito)'),(51871,'SC','8589','Praia do Sonho (Ens Brito)'),(51872,'SC','8589','Mar Azul (Ens Brito)'),(51873,'SC','8589','Praia do Meio (Ens Brito)'),(51874,'SC','8589','Balneário Ponta do Papagaio (Ens Brito)'),(51875,'SC','8589','Guarda do Embaú (Ens Brito)'),(51876,'SC','8589','Morretes (Ens Brito)'),(51882,'SC','8419','Bom Pastor'),(51883,'SC','8419','Distrito Industrial Flávio Baldissera'),(51940,'SC','8419','Centro (Marechal Bormann)'),(52598,'SC','8589','Jardim das Palmeiras'),(52599,'SC','8589','Jardim Aquarius'),(52600,'SC','8589','Jardim Coqueiros'),(52601,'SC','8589','Jardim Eldorado'),(52619,'SC','8430','Linha Anta'),(52623,'SC','8680','Centro'),(52810,'SC','8766','Imigrantes'),(52827,'SC','8525','Vista Alegre'),(52933,'SC','8684','Schramm'),(52934,'SC','8684','Progresso'),(52935,'SC','8684','Brasília'),(52936,'SC','8684','Centenário'),(52937,'SC','8684','Bela Aliança'),(52938,'SC','8684','Dona Francisca'),(52939,'SC','8684','Mato Preto'),(52940,'SC','8684','Cruzeiro'),(52941,'SC','8684','Rio Negro'),(52942,'SC','8684','Boehmerwald'),(52943,'SC','8684','Colonial'),(52944,'SC','8684','Lençol'),(52945,'SC','8684','Industrial Sudoeste'),(52946,'SC','8684','25 de Julho'),(52947,'SC','8684','Serra Alta'),(52948,'SC','8684','Rio Vermelho Estação'),(52949,'SC','8684','Rio Vermelho Povoado'),(52950,'SC','8684','Alpino'),(53030,'SC','8355','Centro'),(53193,'SC','8520','Frei Bruno'),(53214,'SC','8377','Escola Agrícola'),(53304,'SC','8377','Água Verde'),(53310,'SC','8377','Velha Central'),(53330,'SC','8377','Velha Grande'),(53355,'SC','8377','Tribess'),(53357,'SC','8377','Fortaleza Alta'),(53358,'SC','8377','Nova Esperança'),(53512,'SC','8507','São Roque'),(53930,'SC','8742','Cruzeiro'),(54017,'SC','8430','Linha Batista'),(54029,'SC','8430','Buenos Aires'),(54033,'SC','8430','Capão Bonito'),(54036,'SC','8430','Vila Belmiro'),(54048,'SC','8518','Jaraguá 84'),(54052,'SC','8518','Rio Molha'),(54157,'SC','8357','Praia das Laranjeiras'),(54189,'SC','8596','Balneário Rosa do Mar'),(54225,'SC','8701','Centro'),(54248,'SC','8390','Ponta Russa'),(54249,'SC','8390','Zantão'),(54828,'SC','8633','Distrito de Quarta Linha'),(54829,'SC','8406','Distrito de Canoas'),(54830,'SC','8415','Distrito de Cedro Alto'),(54943,'SC','8696','Distrito de Cristo Rei'),(54944,'SC','8324','Distrito de Águas Brancas'),(55205,'SC','8629','Distrito de Presidente Juscelino'),(55206,'SC','8713','Distrito de São Roque'),(55266,'SC','8457','Centro'),(55278,'SC','8753','Campina da Alegria'),(55364,'SC','8599','Centro'),(55517,'SC','8518','Ribeirão Cavalo'),(55518,'SC','8518','Braço do Ribeirão Cavalo'),(55522,'SC','8518','Águas Claras'),(55523,'SC','8518','Boa Vista');
/*!40000 ALTER TABLE `bairros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidades` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cep2` varchar(15) NOT NULL,
  `estado_cod` int(255) NOT NULL,
  `cep` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (8319,'Abdon Batista','SC','4200051',24,'89636-000'),(8320,'Abelardo Luz','SC','4200101',24,'89830-000'),(8321,'Agrolândia','SC','4200200',24,'88420-000'),(8322,'Agronômica','SC','4200309',24,'89188-000'),(8323,'Água Doce','SC','4200408',24,'89654-000'),(8326,'Águas de Chapecó','SC','4200507',24,'89883-000'),(8327,'Águas Frias','SC','4200556',24,'89843-000'),(8328,'Águas Mornas','SC','4200606',24,'88150-000'),(8331,'Alfredo Wagner','SC','4200705',24,'88450-000'),(8333,'Alto Bela Vista','SC','4200754',24,'89730-000'),(8335,'Anchieta','SC','4200804',24,'89970-000'),(8336,'Angelina','SC','4200903',24,'88460-000'),(8337,'Anita Garibaldi','SC','4201000',24,'88590-000'),(8338,'Anitápolis','SC','4201109',24,'88475-000'),(8340,'Antônio Carlos','SC','4201208',24,'88180-000'),(8341,'Apiúna','SC','4201257',24,'89135-000'),(8342,'Arabutã','SC','4201273',24,'89740-000'),(8343,'Araquari','SC','4201307',24,'89245-000'),(8344,'Araranguá','SC','4201406',24,'88900-000'),(8345,'Armazém','SC','4201505',24,'88740-000'),(8347,'Arroio Trinta','SC','4201604',24,'89590-000'),(8348,'Arvoredo','SC','4201653',24,'89778-000'),(8349,'Ascurra','SC','4201703',24,'89138-000'),(8350,'Atalanta','SC','4201802',24,'88410-000'),(8352,'Aurora','SC','4201901',24,'89186-000'),(8355,'Balneário Arroio do Silva','SC','4201950',24,'88914-000'),(8356,'Balneário Barra do Sul','SC','4202057',24,'89247-000'),(8357,'Balneário Camboriú','SC','4202008',24,'LOC'),(8358,'Balneário Gaivota','SC','4202073',24,'88955-000'),(8360,'Bandeirante','SC','4202081',24,'89905-000'),(8361,'Barra Bonita','SC','4202099',24,'89909-000'),(8367,'Barra Velha','SC','4202107',24,'88390-000'),(8373,'Bela Vista do Toldo','SC','4202131',24,'89478-000'),(8374,'Belmonte','SC','4202156',24,'89925-000'),(8375,'Benedito Novo','SC','4202206',24,'89124-000'),(8376,'Biguaçu','SC','4202305',24,'88160-000'),(8377,'Blumenau','SC','4202404',24,'LOC'),(8378,'Bocaína do Sul','SC','',24,'88538-000'),(8380,'Bom Jardim da Serra','SC','4202503',24,'88640-000'),(8381,'Bom Jesus','SC','4202537',24,'89824-000'),(8382,'Bom Jesus do Oeste','SC','4202578',24,'89873-000'),(8383,'Bom Retiro','SC','4202602',24,'88680-000'),(8385,'Bombinhas','SC','4202453',24,'88215-000'),(8386,'Botuverá','SC','4202701',24,'88370-000'),(8387,'Braço do Norte','SC','4202800',24,'88750-000'),(8388,'Braço do Trombudo','SC','4202859',24,'89178-000'),(8389,'Brunópolis','SC','4202875',24,'89634-000'),(8390,'Brusque','SC','4202909',24,'LOC'),(8391,'Caçador','SC','4203006',24,'89500-000'),(8394,'Caibi','SC','4203105',24,'89888-000'),(8395,'Calmon','SC','4203154',24,'89430-000'),(8396,'Camboriú','SC','4203204',24,'88340-000'),(8400,'Campo Alegre','SC','4203303',24,'89294-000'),(8401,'Campo Belo do Sul','SC','4203402',24,'88580-000'),(8402,'Campo Erê','SC','4203501',24,'89980-000'),(8403,'Campos Novos','SC','4203600',24,'89620-000'),(8405,'Canelinha','SC','4203709',24,'88230-000'),(8407,'Canoinhas','SC','4203808',24,'89460-000'),(8408,'Capão Alto','SC','4203253',24,'88548-000'),(8409,'Capinzal','SC','4203907',24,'89665-000'),(8410,'Capivari de Baixo','SC','4203956',24,'88745-000'),(8412,'Catanduvas','SC','4204004',24,'89670-000'),(8414,'Caxambu do Sul','SC','4204103',24,'89880-000'),(8416,'Celso Ramos','SC','4204152',24,'88598-000'),(8417,'Cerro Negro','SC','4204178',24,'88585-000'),(8418,'Chapadão do Lageado','SC','4204194',24,'88407-000'),(8419,'Chapecó','SC','4204202',24,'LOC'),(8421,'Cocal do Sul','SC','4204251',24,'88845-000'),(8424,'Concórdia','SC','4204301',24,'89700-000'),(8425,'Cordilheira Alta','SC','4204350',24,'89819-000'),(8426,'Coronel Freitas','SC','4204400',24,'89840-000'),(8427,'Coronel Martins','SC','4204459',24,'89837-000'),(8428,'Correia Pinto','SC','4204558',24,'88535-000'),(8429,'Corupá','SC','4204509',24,'89278-000'),(8430,'Criciúma','SC','4204608',24,'LOC'),(8431,'Cunha Porã','SC','4204707',24,'89890-000'),(8432,'Cunhataí','SC','4204756',24,'89886-000'),(8433,'Curitibanos','SC','4204806',24,'89520-000'),(8436,'Descanso','SC','4204905',24,'89910-000'),(8437,'Dionísio Cerqueira','SC','4205001',24,'89950-000'),(8438,'Dona Emma','SC','4205100',24,'89155-000'),(8439,'Doutor Pedrinho','SC','4205159',24,'89126-000'),(8442,'Entre Rios','SC','4205175',24,'89862-000'),(8443,'Ermo','SC','4205191',24,'88935-000'),(8444,'Erval Velho','SC','4205209',24,'89613-000'),(8447,'Faxinal dos Guedes','SC','4205308',24,'89694-000'),(8451,'Flor do Sertão','SC','4205357',24,'89878-000'),(8452,'Florianópolis','SC','4205407',24,'LOC'),(8453,'Formosa do Sul','SC','4205431',24,'89859-000'),(8454,'Forquilhinha','SC','4205456',24,'88850-000'),(8456,'Fraiburgo','SC','4205506',24,'89580-000'),(8458,'Frei Rogério','SC','4205555',24,'89530-000'),(8459,'Galvão','SC','4205605',24,'89838-000'),(8461,'Garopaba','SC','4205704',24,'88495-000'),(8462,'Garuva','SC','4205803',24,'89248-000'),(8463,'Gaspar','SC','4205902',24,'89110-000'),(8465,'Governador Celso Ramos','SC','4206009',24,'88190-000'),(8466,'Grão Pará','SC','4206108',24,'88890-000'),(8468,'Gravatal','SC','4206207',24,'88735-000'),(8469,'Guabiruba','SC','4206306',24,'88360-000'),(8471,'Guaraciaba','SC','4206405',24,'89920-000'),(8472,'Guaramirim','SC','4206504',24,'89270-000'),(8473,'Guarujá do Sul','SC','4206603',24,'89940-000'),(8475,'Guatambú','SC','',24,'89817-000'),(8478,'Herval D\'Oeste','SC','4206702',24,'89610-000'),(8479,'Ibiam','SC','4206751',24,'89652-000'),(8480,'Ibicaré','SC','4206801',24,'89640-000'),(8482,'Ibirama','SC','4206900',24,'89140-000'),(8483,'Içara','SC','4207007',24,'88820-000'),(8484,'Ilhota','SC','4207106',24,'88320-000'),(8485,'Imaruí','SC','4207205',24,'88770-000'),(8486,'Imbituba','SC','4207304',24,'88780-000'),(8487,'Imbuia','SC','4207403',24,'88440-000'),(8488,'Indaial','SC','4207502',24,'89130-000'),(8492,'Iomerê','SC','4207577',24,'89558-000'),(8493,'Ipira','SC','4207601',24,'89669-000'),(8495,'Iporã do Oeste','SC','4207650',24,'89899-000'),(8496,'Ipuaçu','SC','4207684',24,'89832-000'),(8497,'Ipumirim','SC','4207700',24,'89790-000'),(8498,'Iraceminha','SC','4207759',24,'89891-000'),(8500,'Irani','SC','4207809',24,'89680-000'),(8502,'Irati','SC','4207858',24,'89856-000'),(8503,'Irineópolis','SC','4207908',24,'89440-000'),(8504,'Itá','SC','4208005',24,'89760-000'),(8506,'Itaiópolis','SC','4208104',24,'89340-000'),(8507,'Itajaí','SC','4208203',24,'LOC'),(8509,'Itapema','SC','4208302',24,'88220-000'),(8510,'Itapiranga','SC','4208401',24,'89896-000'),(8511,'Itapoá','SC','4208450',24,'89249-000'),(8514,'Ituporanga','SC','4208500',24,'88400-000'),(8515,'Jaborá','SC','4208609',24,'89677-000'),(8516,'Jacinto Machado','SC','4208708',24,'88950-000'),(8517,'Jaguaruna','SC','4208807',24,'88715-000'),(8518,'Jaraguá do Sul','SC','4208906',24,'LOC'),(8519,'Jardinópolis','SC','4208955',24,'89848-000'),(8520,'Joaçaba','SC','4209003',24,'89600-000'),(8521,'Joinville','SC','4209102',24,'LOC'),(8522,'José Boiteux','SC','4209151',24,'89145-000'),(8523,'Jupiá','SC','4209177',24,'89839-000'),(8524,'Lacerdópolis','SC','4209201',24,'89660-000'),(8525,'Lages','SC','4209300',24,'LOC'),(8528,'Laguna','SC','4209409',24,'88790-000'),(8529,'Lajeado Grande','SC','4209458',24,'89828-000'),(8530,'Laurentino','SC','4209508',24,'89170-000'),(8531,'Lauro Müller','SC','4209607',24,'88880-000'),(8533,'Lebon Régis','SC','4209706',24,'89515-000'),(8534,'Leoberto Leal','SC','4209805',24,'88445-000'),(8535,'Lindóia do Sul','SC','4209854',24,'89735-000'),(8537,'Lontras','SC','4209904',24,'89182-000'),(8539,'Luiz Alves','SC','4210001',24,'89115-000'),(8540,'Luzerna','SC','4210035',24,'89609-000'),(8542,'Macieira','SC','4210050',24,'89518-000'),(8543,'Mafra','SC','4210100',24,'89300-000'),(8544,'Major Gercino','SC','4210209',24,'88260-000'),(8545,'Major Vieira','SC','4210308',24,'89480-000'),(8546,'Maracajá','SC','4210407',24,'88915-000'),(8549,'Maravilha','SC','4210506',24,'89874-000'),(8552,'Marema','SC','4210555',24,'89860-000'),(8556,'Massaranduba','SC','4210605',24,'89108-000'),(8557,'Matos Costa','SC','4210704',24,'89420-000'),(8558,'Meleiro','SC','4210803',24,'88920-000'),(8561,'Mirim Doce','SC','4210852',24,'89194-000'),(8562,'Modelo','SC','4210902',24,'89872-000'),(8563,'Mondaí','SC','4211009',24,'89893-000'),(8565,'Monte Carlo','SC','4211058',24,'89618-000'),(8566,'Monte Castelo','SC','4211108',24,'89380-000'),(8568,'Morro da Fumaça','SC','4211207',24,'88830-000'),(8570,'Morro Grande','SC','4211256',24,'88925-000'),(8571,'Navegantes','SC','4211306',24,'88375-000'),(8574,'Nova Erechim','SC','4211405',24,'89865-000'),(8576,'Nova Itaberaba','SC','4211454',24,'89818-000'),(8579,'Nova Trento','SC','4211504',24,'88270-000'),(8580,'Nova Veneza','SC','4211603',24,'88865-000'),(8581,'Novo Horizonte','SC','4211652',24,'89998-000'),(8582,'Orleans','SC','4211702',24,'88870-000'),(8583,'Otacílio Costa','SC','4211751',24,'88540-000'),(8584,'Ouro','SC','4211801',24,'89663-000'),(8585,'Ouro Verde','SC','4211850',24,'89834-000'),(8587,'Paial','SC','4211876',24,'89765-000'),(8588,'Painel','SC','4211892',24,'88543-000'),(8589,'Palhoça','SC','4211900',24,'LOC'),(8590,'Palma Sola','SC','4212007',24,'89985-000'),(8591,'Palmeira','SC','4212056',24,'88545-000'),(8592,'Palmitos','SC','4212106',24,'89887-000'),(8594,'Papanduva','SC','4212205',24,'89370-000'),(8595,'Paraíso','SC','4212239',24,'89906-000'),(8596,'Passo de Torres','SC','4212254',24,'88980-000'),(8598,'Passos Maia','SC','4212270',24,'89687-000'),(8600,'Paulo Lopes','SC','4212304',24,'88490-000'),(8601,'Pedras Grandes','SC','4212403',24,'88720-000'),(8602,'Penha','SC','4212502',24,'88385-000'),(8604,'Peritiba','SC','4212601',24,'89750-000'),(8606,'Petrolândia','SC','4212700',24,'88430-000'),(8607,'Balneário Piçarras','SC','',24,'88380-000'),(8609,'Pinhalzinho','SC','4212908',24,'89870-000'),(8611,'Pinheiro Preto','SC','4213005',24,'89570-000'),(8614,'Piratuba','SC','4213104',24,'89667-000'),(8616,'Planalto Alegre','SC','4213153',24,'89882-000'),(8618,'Pomerode','SC','4213203',24,'89107-000'),(8619,'Ponte Alta','SC','4213302',24,'88550-000'),(8620,'Ponte Alta do Norte','SC','4213351',24,'89535-000'),(8621,'Ponte Serrada','SC','4213401',24,'89683-000'),(8622,'Porto Belo','SC','4213500',24,'88210-000'),(8623,'Porto União','SC','4213609',24,'89400-000'),(8624,'Pouso Redondo','SC','4213708',24,'89172-000'),(8625,'Praia Grande','SC','4213807',24,'88990-000'),(8627,'Presidente Castelo Branco','SC','4213906',24,'89745-000'),(8628,'Presidente Getúlio','SC','4214003',24,'89150-000'),(8631,'Presidente Nereu','SC','4214102',24,'89184-000'),(8632,'Princesa','SC','4214151',24,'89935-000'),(8634,'Quilombo','SC','4214201',24,'89850-000'),(8636,'Rancho Queimado','SC','4214300',24,'88470-000'),(8646,'Rio das Antas','SC','4214409',24,'89550-000'),(8648,'Rio do Campo','SC','4214508',24,'89198-000'),(8649,'Rio do Oeste','SC','4214607',24,'89180-000'),(8650,'Rio do Sul','SC','4214805',24,'89160-000'),(8652,'Rio dos Cedros','SC','4214706',24,'89121-000'),(8653,'Rio Fortuna','SC','4214904',24,'88760-000'),(8655,'Rio Negrinho','SC','4215000',24,'89295-000'),(8657,'Rio Rufino','SC','4215059',24,'88658-000'),(8658,'Riqueza','SC','4215075',24,'89895-000'),(8659,'Rodeio','SC','4215109',24,'89136-000'),(8660,'Romelândia','SC','4215208',24,'89908-000'),(8662,'Salete','SC','4215307',24,'89196-000'),(8663,'Saltinho','SC','4215356',24,'89981-000'),(8664,'Salto Veloso','SC','4215406',24,'89595-000'),(8666,'Sangão','SC','4215455',24,'88717-000'),(8667,'Santa Cecília','SC','4215505',24,'89540-000'),(8669,'Santa Helena','SC','4215554',24,'89915-000'),(8675,'Santa Rosa de Lima','SC','4215604',24,'88763-000'),(8676,'Santa Rosa do Sul','SC','4215653',24,'88965-000'),(8677,'Santa Terezinha','SC','4215679',24,'89199-000'),(8678,'Santa Terezinha do Progresso','SC','4215687',24,'89983-000'),(8680,'Santiago do Sul','SC','4215695',24,'89854-000'),(8681,'Santo Amaro da Imperatriz','SC','4215703',24,'88140-000'),(8684,'São Bento do Sul','SC','4215802',24,'LOC'),(8685,'São Bernardino','SC','4215752',24,'89982-000'),(8686,'São Bonifácio','SC','4215901',24,'88485-000'),(8687,'São Carlos','SC','4216008',24,'89885-000'),(8689,'São Cristóvão do Sul','SC','4216057',24,'89533-000'),(8691,'São Domingos','SC','4216107',24,'89835-000'),(8692,'São Francisco do Sul','SC','4216206',24,'89240-000'),(8694,'São João Batista','SC','4216305',24,'88240-000'),(8695,'São João do Itaperiú','SC','4216354',24,'88395-000'),(8696,'São João do Oeste','SC','4216255',24,'89897-000'),(8698,'São João do Sul','SC','4216404',24,'88970-000'),(8699,'São Joaquim','SC','4216503',24,'88600-000'),(8700,'São José','SC','4216602',24,'LOC'),(8701,'São José do Cedro','SC','4216701',24,'89930-000'),(8702,'São José do Cerrito','SC','4216800',24,'88570-000'),(8705,'São Lourenço do Oeste','SC','4216909',24,'89990-000'),(8706,'São Ludgero','SC','4217006',24,'88730-000'),(8707,'São Martinho','SC','4217105',24,'88765-000'),(8708,'São Miguel do Oeste','SC','',24,'89900-000'),(8709,'São Miguel da Boa Vista','SC','4217154',24,'89879-000'),(8711,'São Pedro de Alcântara','SC','4217253',24,'88125-000'),(8717,'Saudades','SC','4217303',24,'89868-000'),(8718,'Schroeder','SC','4217402',24,'89275-000'),(8719,'Seara','SC','4217501',24,'89770-000'),(8721,'Serra Alta','SC','4217550',24,'89871-000'),(8723,'Siderópolis','SC','4217600',24,'88860-000'),(8724,'Sombrio','SC','4217709',24,'88960-000'),(8726,'Sul Brasil','SC','4217758',24,'89855-000'),(8727,'Taió','SC','4217808',24,'89190-000'),(8728,'Tangará','SC','4217907',24,'89642-000'),(8732,'Tigrinhos','SC','4217956',24,'89875-000'),(8733,'Tijucas','SC','4218004',24,'88200-000'),(8734,'Timbé do Sul','SC','4218103',24,'88940-000'),(8735,'Timbó','SC','4218202',24,'89120-000'),(8736,'Timbó Grande','SC','4218251',24,'89545-000'),(8737,'Três Barras','SC','4218301',24,'89490-000'),(8738,'Treviso','SC','4218350',24,'88862-000'),(8739,'Treze de Maio','SC','4218400',24,'88710-000'),(8740,'Treze Tílias','SC','4218509',24,'89650-000'),(8741,'Trombudo Central','SC','4218608',24,'89176-000'),(8742,'Tubarão','SC','4218707',24,'LOC'),(8743,'Tunápolis','SC','4218756',24,'89898-000'),(8745,'Turvo','SC','4218806',24,'88930-000'),(8746,'União do Oeste','SC','4218855',24,'89845-000'),(8747,'Urubici','SC','4218905',24,'88650-000'),(8749,'Urupema','SC','4218954',24,'88625-000'),(8750,'Urussanga','SC','4219002',24,'88840-000'),(8751,'Vargeão','SC','4219101',24,'89690-000'),(8752,'Vargem','SC','4219150',24,'89638-000'),(8753,'Vargem Bonita','SC','4219176',24,'89675-000'),(8755,'Vidal Ramos','SC','4219200',24,'88443-000'),(8756,'Videira','SC','4219309',24,'89560-000'),(8761,'Vítor Meireles','SC','4219358',24,'89148-000'),(8762,'Witmarsum','SC','4219408',24,'89157-000'),(8763,'Xanxerê','SC','4219507',24,'89820-000'),(8764,'Xavantina','SC','4219606',24,'89780-000'),(8765,'Xaxim','SC','4219705',24,'89825-000'),(8766,'Zortéa','SC','4219853',24,'89633-000');
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomecliente` varchar(45) NOT NULL,
  `telefone` double NOT NULL,
  `data_nascimento` date NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `cidade` int(3) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` int(6) NOT NULL,
  `complemento` varchar(70) NOT NULL,
  `cep` int(9) DEFAULT NULL,
  `data_cadastro` date NOT NULL,
  `email` varchar(70) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `ativo` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'123',123,'1969-12-31','123','123.0',8321,'36193','123',123,'123123',123,'2016-02-16','123@123.com','d41d8cd98f00b204e9800998ecf8427e',1),(2,'123123123',123,'1969-12-31','123','123.0',8320,'35957','123',123,'123',123,'2016-02-16','123@94898.cm','d41d8cd98f00b204e9800998ecf8427e',1),(3,'Uriel Hass123111111',123456,'1969-12-31','123456','123456.0',8382,'34837','123456',123456,'123',123456,'2016-02-16','uriel@cliente.com','d41d8cd98f00b204e9800998ecf8427e',0),(6,'asdf',8919819819,'1969-12-31','1231561','1981819',8322,'38056','13251',1321,'4151',1651651,'2016-03-10','uriel@urei.com','e10adc3949ba59abbe56e057f20f883e',0),(7,'asdf',8919819819,'1969-12-31','1231561','1981819',8322,'38056','13251',1321,'4151',1651651,'2016-03-10','uriel@urei.com','d41d8cd98f00b204e9800998ecf8427e',0),(12,'Guilherme Stegmann',9498498489,'1969-12-31','4974282','274.262.651-98',8333,'34821','asdfasdfasdf',123,'132132',89227100,'2016-03-22','uriel@usuario.com','e10adc3949ba59abbe56e057f20f883e',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estagio_pedido`
--

DROP TABLE IF EXISTS `estagio_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estagio_pedido` (
  `codestagio_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `estagio` varchar(45) DEFAULT NULL,
  `descricao_estagio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codestagio_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estagio_pedido`
--

LOCK TABLES `estagio_pedido` WRITE;
/*!40000 ALTER TABLE `estagio_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `estagio_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `codfuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomefuncionario` varchar(45) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `fone` double NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `funcao` varchar(45) DEFAULT NULL,
  `cidade` int(7) NOT NULL,
  `bairro` int(7) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` int(6) DEFAULT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `administrador` varchar(1) DEFAULT NULL,
  `cep` int(8) DEFAULT NULL,
  `funcionario` int(1) NOT NULL DEFAULT '0',
  `ativo` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codfuncionario`,`fone`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (4,'Uriel Hass12354','08984452454','4875215','2015-12-10',4788252700,'uriel@funcionario.com','e10adc3949ba59abbe56e057f20f883e','Gerente',4356,0,'papa joao 23',654,'Proximo ao colegio','1',89228352,0,1),(10,'Uriel Hass','08981981981','1234564','2015-12-10',4754545454,'uriel@uriel.com.br','123456','qualquer coisa',4356,0,'Aventureiro',5156,'Sem complemento','0',89255480,0,1),(11,'Uriel Hass','089.819.819-81','1.234.564','2015-12-11',4754545454,'uriel@uriel.com.br','123456','qualquer coisa',4492,0,'Aventureiro',5156,'Sem complemento','0',89255480,0,0),(20,'Eduardo Pacheco','08684452909','1234561','1969-12-31',4981981819,'tinho@gmail.com','e10adc3949ba59abbe56e057f20f883e','Não faz nada da vida',8528,34359,'Não tem',123,'Sem comprementu','1',89227100,1,0),(21,'Eduardo Pacheco','08684452909','1234561','1969-12-31',4981981819,'tinho@gmail.com','e10adc3949ba59abbe56e057f20f883e','Não faz nada da vida',8528,34359,'Não tem',123,'Sem comprementu','1',89227100,1,0),(22,'Uriel Hass','08684452909','1198198','1969-12-31',9158119819,'1151@uiorej.com','e10adc3949ba59abbe56e057f20f883e','Sem função',8322,38056,'hahaasdf',123,'12313','1',89227100,1,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_funcionario`
--

DROP TABLE IF EXISTS `historico_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico_funcionario` (
  `pedido_codpedido` int(11) NOT NULL,
  `funcionario_codfuncionario` int(11) NOT NULL,
  PRIMARY KEY (`pedido_codpedido`,`funcionario_codfuncionario`),
  KEY `fk_pedido_has_funcionario_funcionario1_idx` (`funcionario_codfuncionario`),
  KEY `fk_pedido_has_funcionario_pedido1_idx` (`pedido_codpedido`),
  CONSTRAINT `fk_pedido_has_funcionario_funcionario1` FOREIGN KEY (`funcionario_codfuncionario`) REFERENCES `funcionario` (`codfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_funcionario_pedido1` FOREIGN KEY (`pedido_codpedido`) REFERENCES `pedido` (`codpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_funcionario`
--

LOCK TABLES `historico_funcionario` WRITE;
/*!40000 ALTER TABLE `historico_funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `codpedido` int(11) NOT NULL,
  `estagio_pedido` varchar(45) DEFAULT NULL,
  `estagio_pedido_codestagio_pedido` int(11) NOT NULL,
  `cliente_codcliente` int(11) NOT NULL,
  `taxas_codtaxas` int(6) NOT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`codpedido`,`cliente_codcliente`,`taxas_codtaxas`),
  KEY `fk_pedido_estagio_pedido1_idx` (`estagio_pedido_codestagio_pedido`),
  KEY `fk_pedido_cliente1_idx` (`cliente_codcliente`),
  KEY `fk_pedido_taxas1_idx` (`taxas_codtaxas`),
  CONSTRAINT `fk_pedido_cliente1` FOREIGN KEY (`cliente_codcliente`) REFERENCES `cliente` (`codcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_estagio_pedido1` FOREIGN KEY (`estagio_pedido_codestagio_pedido`) REFERENCES `estagio_pedido` (`codestagio_pedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_produto`
--

DROP TABLE IF EXISTS `pedido_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_produto` (
  `pedido_codpedido` int(11) NOT NULL,
  `produto_codproduto` int(11) NOT NULL,
  PRIMARY KEY (`pedido_codpedido`,`produto_codproduto`),
  KEY `fk_pedido_has_produto_produto1_idx` (`produto_codproduto`),
  KEY `fk_pedido_has_produto_pedido1_idx` (`pedido_codpedido`),
  CONSTRAINT `fk_pedido_has_produto_pedido1` FOREIGN KEY (`pedido_codpedido`) REFERENCES `pedido` (`codpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_produto_produto1` FOREIGN KEY (`produto_codproduto`) REFERENCES `produto` (`codproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_produto`
--

LOCK TABLES `pedido_produto` WRITE;
/*!40000 ALTER TABLE `pedido_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `codproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeproduto` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `anexo` blob,
  `cancelamento` varchar(155) DEFAULT NULL,
  `observacao` varchar(155) DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`codproduto`,`categoria`),
  KEY `fk_produto_categoria1_idx` (`categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (2,'123','123',NULL,NULL,NULL,123123.00,'Lanche'),(4,'suco','123',NULL,NULL,NULL,123.48,'Lanche');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sugestoes_criticas`
--

DROP TABLE IF EXISTS `sugestoes_criticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sugestoes_criticas` (
  `codsugestoes_criticas` int(11) NOT NULL AUTO_INCREMENT,
  `mensagem` text,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codsugestoes_criticas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sugestoes_criticas`
--

LOCK TABLES `sugestoes_criticas` WRITE;
/*!40000 ALTER TABLE `sugestoes_criticas` DISABLE KEYS */;
INSERT INTO `sugestoes_criticas` VALUES (1,'sdasf','','hass.uriel','0');
/*!40000 ALTER TABLE `sugestoes_criticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxas`
--

DROP TABLE IF EXISTS `taxas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxas` (
  `codtaxas` int(6) NOT NULL,
  `nometaxa` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `valor` int(7) DEFAULT NULL,
  PRIMARY KEY (`codtaxas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxas`
--

LOCK TABLES `taxas` WRITE;
/*!40000 ALTER TABLE `taxas` DISABLE KEYS */;
INSERT INTO `taxas` VALUES (0,'Entrega','Taxa de entrega',150),(1,'Taxa mínima','Haverá um valor mínimo para compra delivery',15000),(2,'Retirada balcão','Sem nenhum custo adicional',0);
/*!40000 ALTER TABLE `taxas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-22 21:32:16
