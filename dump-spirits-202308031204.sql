-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: spirits.cmdeab77miub.ap-northeast-2.rds.amazonaws.com    Database: spirits
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abvrange`
--

DROP TABLE IF EXISTS `abvrange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abvrange` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abv_range` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abvrange`
--

LOCK TABLES `abvrange` WRITE;
/*!40000 ALTER TABLE `abvrange` DISABLE KEYS */;
INSERT INTO `abvrange` VALUES (1,'무알콜'),(2,'1~9'),(3,'10~39'),(4,'40~49'),(5,'50~59'),(6,'60~69'),(7,'70~');
/*!40000 ALTER TABLE `abvrange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cask`
--

DROP TABLE IF EXISTS `cask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cask` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cask`
--

LOCK TABLES `cask` WRITE;
/*!40000 ALTER TABLE `cask` DISABLE KEYS */;
INSERT INTO `cask` VALUES (1,'버진캐스크'),(2,'버번캐스크'),(3,'쉐리캐스크(P.X.)'),(4,'쉐리캐스크(OLOROSO)'),(5,'포트캐스크'),(6,'와인캐스크'),(7,'꼬냑캐스크'),(8,'소테른캐스크'),(9,'아마로네캐스크'),(10,'블렌디드캐스크');
/*!40000 ALTER TABLE `cask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost_range`
--

DROP TABLE IF EXISTS `cost_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cost_range` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cost_range` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost_range`
--

LOCK TABLES `cost_range` WRITE;
/*!40000 ALTER TABLE `cost_range` DISABLE KEYS */;
INSERT INTO `cost_range` VALUES (1,'0~19,999'),(2,'20,000~49,999'),(3,'50,000~99,999'),(4,'100,000~149,999'),(5,'150,000~199,999'),(6,'200,000~299,999'),(7,'300,000~');
/*!40000 ALTER TABLE `cost_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_category`
--

DROP TABLE IF EXISTS `main_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_category` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_category`
--

LOCK TABLES `main_category` WRITE;
/*!40000 ALTER TABLE `main_category` DISABLE KEYS */;
INSERT INTO `main_category` VALUES (1,'whiskey'),(2,'vodka'),(3,'tequila'),(4,'gin'),(5,'rum'),(6,'brandy'),(7,'beer');
/*!40000 ALTER TABLE `main_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nation`
--

DROP TABLE IF EXISTS `nation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nation` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nation`
--

LOCK TABLES `nation` WRITE;
/*!40000 ALTER TABLE `nation` DISABLE KEYS */;
INSERT INTO `nation` VALUES (1,'미국'),(2,'스코틀랜드'),(3,'아일랜드'),(4,'아일라'),(5,'베네수엘라'),(6,'대만'),(7,'인도'),(8,'호주'),(9,'프랑스'),(10,'포르투갈'),(11,'러시아'),(12,'덴마크'),(13,'네덜란드'),(14,'폴란드'),(15,'맥시코'),(16,'이탈리아'),(17,'필리핀');
/*!40000 ALTER TABLE `nation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `net_weight`
--

DROP TABLE IF EXISTS `net_weight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `net_weight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `net_weight` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `net_weight`
--

LOCK TABLES `net_weight` WRITE;
/*!40000 ALTER TABLE `net_weight` DISABLE KEYS */;
INSERT INTO `net_weight` VALUES (1,'300'),(2,'473'),(3,'500'),(4,'700'),(5,'750'),(6,'1000'),(7,'5000');
/*!40000 ALTER TABLE `net_weight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pairing`
--

DROP TABLE IF EXISTS `pairing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pairing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pairing` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pairing`
--

LOCK TABLES `pairing` WRITE;
/*!40000 ALTER TABLE `pairing` DISABLE KEYS */;
INSERT INTO `pairing` VALUES (1,'치즈'),(2,'초콜릿'),(3,'견과류'),(4,'고기'),(5,'해산물'),(6,'시가'),(7,'튀김'),(8,'크래커');
/*!40000 ALTER TABLE `pairing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abv` double DEFAULT NULL,
  `aroma` text DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `filename1` varchar(255) DEFAULT NULL,
  `filename2` varchar(255) DEFAULT NULL,
  `filepath1` varchar(255) DEFAULT NULL,
  `filepath2` varchar(255) DEFAULT NULL,
  `flavor` text DEFAULT NULL,
  `info` text DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `subject` text DEFAULT NULL,
  `views` int(11) NOT NULL DEFAULT 0,
  `abv_range_id` int(11) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `cost_range_id` int(11) DEFAULT NULL,
  `main_category_id` int(11) DEFAULT NULL,
  `nation_id` int(11) DEFAULT NULL,
  `net_weight_id` int(11) DEFAULT NULL,
  `sub_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhyhxnp43td30w6x3eemnlj3sb` (`abv_range_id`),
  KEY `FK987e8p3ix7q37fy15ity5ng1g` (`author_id`),
  KEY `FK9vw6u2ju8wyw636dbbj28e67k` (`cost_range_id`),
  KEY `FK67ojnhu6ncge802gfsd7h4go7` (`main_category_id`),
  KEY `FK16mloafqimyh62hr56x5r624q` (`nation_id`),
  KEY `FKn8ju40jpj117it4ofnxh30tln` (`net_weight_id`),
  KEY `FKd9gfnsjgfwjtaxl57udrbocsp` (`sub_category_id`),
  CONSTRAINT `FK16mloafqimyh62hr56x5r624q` FOREIGN KEY (`nation_id`) REFERENCES `nation` (`id`),
  CONSTRAINT `FK67ojnhu6ncge802gfsd7h4go7` FOREIGN KEY (`main_category_id`) REFERENCES `main_category` (`id`),
  CONSTRAINT `FK987e8p3ix7q37fy15ity5ng1g` FOREIGN KEY (`author_id`) REFERENCES `site_user` (`id`),
  CONSTRAINT `FK9vw6u2ju8wyw636dbbj28e67k` FOREIGN KEY (`cost_range_id`) REFERENCES `cost_range` (`id`),
  CONSTRAINT `FKd9gfnsjgfwjtaxl57udrbocsp` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`id`),
  CONSTRAINT `FKhyhxnp43td30w6x3eemnlj3sb` FOREIGN KEY (`abv_range_id`) REFERENCES `abvrange` (`id`),
  CONSTRAINT `FKn8ju40jpj117it4ofnxh30tln` FOREIGN KEY (`net_weight_id`) REFERENCES `net_weight` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,40,'오렌지, 스파이스, 건포도, 강렬하고 달콤한 바닐라 향',38000,'247eb790-7e1c-43ad-8c09-954729a3c9c1_file1_temp1501966185846048645조니블랙 썸넬.jpg','247eb790-7e1c-43ad-8c09-954729a3c9c1_file2_temp210683727038833390331조니블랙 인포.jpg','/files/247eb790-7e1c-43ad-8c09-954729a3c9c1_file1_temp1501966185846048645조니블랙 썸넬.jpg','/files/247eb790-7e1c-43ad-8c09-954729a3c9c1_file2_temp210683727038833390331조니블랙 인포.jpg','충만한 다크 프루트, 달콤한 바닐라, 시그니처 스모크가 풍부한 복합성의 매우 균형 잡힌 풍미를 제공합니다.','조니 워커 블랙 라벨은 조니 워커의 전통적인 양식의 블렌드로\r\n\r\n다른 모든 디럭스 블렌드의 기준으로 인식되고 있습니다.\r\n\r\n1909년 Extra Special Old Highland Whisky에서 Johnnie Walker Black Label로 새로이 이름지어진 이 제품은\r\n\r\n오직 최소 12년 이상 숙성된 40여종의 스코틀랜드 스카치 위스키들만을 사용하여 명백하게 부드럽고 진하며 복합적인 캐릭터를 자랑합니다.\r\n\r\n2016 위스키 바이블의 짐 머레이가 95.5점이란 높은 점수를 주며 세계에서 가장 훌륭한 위스키들 중의 하나라 극찬한 바 있습니다.\r\n\r\n톡쏘는 오렌지, 스파이스, 건포도, 강렬하고 달콤한 바닐라 향과 다크 프루트, 달콤한 바닐라, 시그니처 스모크의 \r\n\r\n풍부하고 복잡한 매우 균형잡힌 풍미가 스모크, 피트, 몰트로 층을 이루며 입안 가득 매우 부드러운 여운을 선사합니다.','조니 워커 블랙 라벨','조니 워커 블랙 라벨 (Johnnie Walker Black Label)',42,4,1,2,1,2,4,4),(2,40,'달콤한 바닐라와 스파이스의 신선하고 강렬한 향',23000,'c077581c-54fb-473a-af23-4c685cb2cd79_file1_temp15983497187071633530조니레드 썸넬.jpg','c077581c-54fb-473a-af23-4c685cb2cd79_file2_temp214762155144569982233조니레드 인포.jpg','/files/c077581c-54fb-473a-af23-4c685cb2cd79_file1_temp15983497187071633530조니레드 썸넬.jpg','/files/c077581c-54fb-473a-af23-4c685cb2cd79_file2_temp214762155144569982233조니레드 인포.jpg','스모키한 몰트가 한층 풍부하게 미각을 자극하는 맛','조니 워커 레드 라벨은 1909년 조지&알렉산더 워커 형제에 의해 출시된 제품 입니다.\r\n\r\n이 클래식한 블렌디드 위스키는 스트레이트는 물론 유명한 Mixer로 바에서 인기가 높은 제품 입니다.\r\n\r\n이것은 Heavier하거나 Old-Fashioned 위스키 대신 소다와 믹싱하기에 알맞은 타입의 위스키들을 알렉산더가 블렌드한 결과입니다.\r\n\r\n오늘날 세계에서 가장 인기있는 위스키이자 전 세계 200개 이상의 마켓에서 판매되고 있는 조니 워커 레드 라벨은\r\n\r\n매우 다재다능한 만능의 매력과 격렬함이 특징적인 풍미로 단독은 물론 혼합하여 드실 경우에도 빛을 발하는 제품입니다.\r\n\r\n조니 워커 레드 라벨은 전 세계 베스트 셀러 스카치 위스키로 파티나 모임을 위한 완벽한 선택이 되어 줄 것입니다.','조니 워커 레드 라벨','조니 워커 레드 라벨 700ml (Johnnie Walker Red Label 700ml)',16,4,1,2,1,2,4,4),(3,40,'달콤한 스모크와 정향의 맛깔스러운 아로마',58000,'86388df1-9d45-49e4-9710-b30bab84d70d_file1_temp117624433399769371187조니떱블 썸넬.jpg','86388df1-9d45-49e4-9710-b30bab84d70d_file2_temp211564662727327746891조니떱블 인포.jpg','/files/86388df1-9d45-49e4-9710-b30bab84d70d_file1_temp117624433399769371187조니떱블 썸넬.jpg','/files/86388df1-9d45-49e4-9710-b30bab84d70d_file2_temp211564662727327746891조니떱블 인포.jpg','건포도, 신선한 사과, 열대 오렌지, 크리미 바닐라가 결합된 풍부하고 명백한 피트의 풍미','1820년 조니 워커를 설립한 창업주 존 워커는 차(tea) 블렌딩 기술을 위스키 제조에 접목해 균일한 맛의 위스키 제조에 성공합니다.\r\n\r\n1870년 아들인 알렉산더가 사업을 물려받으며 조니 워커는 사각의 병디자인과 기울어진 제품 라벨과 같은 지금의 특징적인 체계를 갖추기 시작합니다.\r\n\r\n1908년 조니 워커로 브랜드명을 바꾸고 1909년 \'Keep Walking\' 이라는 슬로건과 유명 만화가 톰 브라운이 그린 스트라이딩 맨 로고를 \r\n\r\n브랜드 상징으로 내새우며  본격적인 마케팅에 나섭니다.\r\n\r\n조니 워커 블랙 라벨의 흥미로운 트위스트인 더블 블랙은 리미티드 릴리스로서 성공적인 런칭 이후 2011년 정규 라인업에 합류한 제품입니다.\r\n\r\n조니 워커 더블 블랙은 마스터 블렌더 Jim Beveridge가 세계적으로 유명한 조니 워커 블랙 라벨을 더 다크하고 더 스모키하게 해석하여 완성한 제품으로\r\n\r\n정교한 조니 워커 스타일을 유지하면서 표준적인 블랙 라벨 프로필에 스모크를 크게 강조하면서 보다 강렬한 맛을 더 추가하였습니다.\r\n\r\n강렬한 스모키 캐릭터와 다층적인 스파이스의 풀바디 위스키로 자연스러운 스모키 캐릭터와 풍미의 깊이를 위해\r\n\r\nHeavily Charred Casks에서 숙성하여 주정과 우드 사이의 여러 가지 상호작용을 유도, 독특한 아로마를 형성하였으며,\r\n\r\n특징적인 Heavily Peated West Coast 및 Island 위스키를 많은 비율로 사용하여 강렬함의 새로운 수준까지 기존 시그니쳐 풍미를 향상,\r\n\r\n피트한 뉘앙스를 통해 진정한 더블 블랙으로 거듭난 제품입니다.','조니 워커 더블 블랙','조니 워커 더블 블랙 (Johnnie Walker Double Black)',8,4,1,3,1,2,4,4),(4,40,'다크 초콜릿과 커피의 풍미',56000,'32741879-614b-4491-9d0d-482194d23046_file1_temp17031093412631008419조니블랙 쉐리 썸넬.jpg','32741879-614b-4491-9d0d-482194d23046_file2_temp2327373876349607936조니블랙 쉐리 인포.jpg','/files/32741879-614b-4491-9d0d-482194d23046_file1_temp17031093412631008419조니블랙 쉐리 썸넬.jpg','/files/32741879-614b-4491-9d0d-482194d23046_file2_temp2327373876349607936조니블랙 쉐리 인포.jpg','SHERRY SEASONED CASKS에서 나오는 스모크에 싸인 무화과와 자두의 달콤함','Black Lable의 새로운 에디션인 Johnnie Walker Black Label Sherry Finish는 \r\n\r\nSherry Seasoned Casks에서 최소 12년 이상 숙성된 다이내믹하고 실키하며 매끄러운 스카치 위스키입니다.\r\n\r\n스페이사이드, 하이랜드, 로우랜드, 아일라 위스키 블렌드의 풍미를 제공,\r\n\r\nHighlands의 Clynelish와 Speyside의 Cardhu와 같은 증류소의 달콤한 과일 및 스파이스,\r\n\r\nCameronbridge, Glenkinchie와 같은 Lowland 증류소의 크리미 토피, 꿀 같은 단맛 및 바닐라가\r\n\r\nIslands 증류소인 Caol ila의 스모크에 싸여 있습니다.\r\n\r\nJohnnie Walker Black Lable이 자랑하는 대담하고 역동적인 풍미를 층에서 영감을 받은 리미티드 에디션 위스키로\r\n\r\n셰리 캐스크에서 보낸 시간으로부터 부여받은 무화과와 자두의 감미로운 다롬함이 더해져 Johnnie Walker Black Label의 친숙한 맛을 전달,\r\n\r\nBlack Label의 명백한 특성과 뛰어난 맛의 깊이에 취하여\r\n\r\nSherry Finish의 그윽하고 달콤한 매끄러움으로 함께 완성한 생동감 넘치는 풍미의 실크처럼 부드러운 스카치입니다.','조니 워커 블랙 라벨 셰리 피니시 700ml','조니 워커 블랙 라벨 셰리 피니시 700ml (Johnnie Walker Black Label Sherry Finish 700ml)',4,4,1,3,1,2,4,4),(5,43,'신선한 풀, 과일, 페퍼, 풍부한 바닐라, 샌달우드의 깨끗하고 강렬한 아로마',97000,'52cd0a09-2546-4978-9cd3-59a02a870861_file1_temp118353701621638371118조니그린 썸넬.jpg','52cd0a09-2546-4978-9cd3-59a02a870861_file2_temp214954084279106432249조니그린 인포.jpg','/files/52cd0a09-2546-4978-9cd3-59a02a870861_file1_temp118353701621638371118조니그린 썸넬.jpg','/files/52cd0a09-2546-4978-9cd3-59a02a870861_file2_temp214954084279106432249조니그린 인포.jpg','참나무 및 삼나무의 싱싱한 우드, 가벼운 정원 과일, 열대의 향기로운 플로럴의 능숙하게 결합된 풍미','조니 워커 그린 라벨은 American & European Oak Casks에서 최소 15년간 숙성된 Speyside, Highland, Lowland, Scottich Islands\r\n\r\n몰트 위스키들의 독특한 조합으로 싱글 몰트 위스키의 모든 특성을 제공하는 동시에 더 거대한 깊이와 더 폭넓은 맛의 경험을 선사합니다.\r\n\r\n2016년에 재런칭된 그린 라벨은 대담한 풍미와 특유의 스모키함이 돋보이는 시그니처 조니 워커 스타일의 블렌드로\r\n\r\n조니 워커 정규 라인업 중에서도 가장 풍부한 풍미를 자랑합니다.\r\n\r\n스코틀랜드의 네 귀퉁이에서 뽑아낸 몰트만을 사용, 각각의 몰트는 Master Blender가 위스키에서 완벽한 균형을 이루도록 특별히 선별한 것으로\r\n\r\n블렌딩의 거장, Johnnie Walker는 그린 라벨의 독특한 풍미를 내기 위해 이러한 키노트 풍미에 집중하였습니다.\r\n\r\nTalisker, Linkwood, Cragganmore 및 Caol ila로 대표되는 네 가지 핵심 시그니쳐 스타일을 세심하게 밸런싱한 결과,\r\n\r\nIsley of Skye의 Talisker가 우드, 스모크, 페퍼, 오크, 풍부한 과일과 함께 블렌드의 지배력과 캐릭터의 깊이를 부여하고\r\n\r\n톡특한 Speyside 몰트인 Linkwood가 가벼운 정원 과일과 꽃, 삼나무 목재로 기교를 더하였으며\r\n\r\n달콤하고 향긋한 Speyside 몰트인 Cragganmore가 이 블렌드에 뛰어난 몰트의 본질과 달콤한 우드 스모크, 샌달우드의 힌트를 추가합니다.','조니 워커 그린 라벨 신형 700ml','조니 워커그린 라벨 700ml (Johnnie Walker Green Label 700ml)',11,4,1,3,1,2,4,3),(6,43,'신선한 건초, 맥아 가루, 로즈힙, 시트러스 및 말린 과일',130000,'4207cd03-1eb8-4240-8cf5-18eb84c6ea75_file1_temp11693677294587888206글렌고인 15 썸넬.jpg','4207cd03-1eb8-4240-8cf5-18eb84c6ea75_file2_temp212875926599531214257글렌고인15 인포.jpg','/files/4207cd03-1eb8-4240-8cf5-18eb84c6ea75_file1_temp11693677294587888206글렌고인 15 썸넬.jpg','/files/4207cd03-1eb8-4240-8cf5-18eb84c6ea75_file2_temp212875926599531214257글렌고인15 인포.jpg','부드러운 단맛, 열대 과일 힌트, 설탕에 절인 레몬, 시나몬, 바닐라, 사과 파이의 상쾌한 풍미','글렌고인 증류소는 다른 위스키보다 3배 더 오랜 시간이 걸리는 스코틀랜드에서 가장 느린 증류를 자랑하는데,\r\n\r\n이는 증류기에서 나오는 액체가 풍부하고 점성이 높으며 맛이 풍부하다는 것을 의미합니다.\r\n\r\n또한 킬닝(Kilning)과정에서 공기 건조된 보리를 사용하여 이탄(Peat)의 흔적이 전혀 없는 것이 특징적으로\r\n\r\n그 중에서도 Glengoyne 15년은 Glengoyne의 시그니처 프루티 스타일을 유지하면서\r\n\r\n달콤한 버번 캐스크 캐릭터와 풍부하고 프루티한 셰리 노트 사이의 완벽한 밸런스를 보여주는 Highland 싱글 몰트 스카치 위스키입니다.\r\n\r\n20% First Fill Bourbon,. 25% First Fill Sherry,\r\n\r\n55% Refill Casks에서 숙성,\r\n\r\nBourbon & Sherry Casks에서 완전히 숙성된 위스키를 함께 결합하여 셰리 숙성에 의해 부여받은 수지질의 \r\n\r\n달콤하게 진한 과수원 과일 노트와 버번 우드의 바닐라 플레이버 사이 매혹적인 상호 작용을 완성,\r\n\r\n43% ABV로 병입된 밝은 호박색 주정이 신선한 건초, 맥아 가루, 로즈힙, 시트러스, 및 말린 과일의 아로마와\r\n\r\n부드러운 단맛, 열대 과일 힌트, 설탕에 절인 레몬, 시나몬, 바닐라, 사과 파이의 상쾌한 풍미에 이은\r\n\r\n우아한 스파이스, 입안을 맴도는 오크의 기분 좋은 드라이 피니시를 선사합니다.','글렌고인 15년 700ml','글렌고인 15년 700ml (Glengoyne 15 Years old 700ml)',18,4,1,4,1,2,4,1),(7,46,'시트러스 껍질, 진저 스냅 비스킷, 구운 과일의 아로마',163000,'18b32912-f745-4916-91c2-e6d866ff5d1a_file1_temp117020600791081370297글렌스코시아 15년 썸넬.jpg','18b32912-f745-4916-91c2-e6d866ff5d1a_file2_temp27125629812305052188글렌스코시아 15년 인포1.jpg','/files/18b32912-f745-4916-91c2-e6d866ff5d1a_file1_temp117020600791081370297글렌스코시아 15년 썸넬.jpg','/files/18b32912-f745-4916-91c2-e6d866ff5d1a_file2_temp27125629812305052188글렌스코시아 15년 인포1.jpg','속이 가득 찬 과일, 살구, 과일 샐러드, 캐러멜 설탕과 오크의 풍미','Glen Scotia는 19세기 한때 \'세계의 위스키 수도\'로 유명세를 떨쳤던\r\n\r\nCampbeltown 지역에 남아있는 3대 증류소 중 하나로\r\n\r\n1832년 Galbraith 패밀리에 의해 설립된 이래\r\n\r\n12,000L와 16,000L의 스틸 두대로 매우 소규모로 운영되오며\r\n\r\n쇼트 스틸과 다양한 발효로 인한 과일의 아로마와 플레이버를 통해\r\n\r\n더욱 풍성해진 플레이버 프로필을 자랑하는 한편,\r\n\r\n스코틀랜드 동부에서 공급되는 맥아와\r\n\r\n1830년대의 오리지널 장비 디자인의 많은 부분을\r\n\r\n아직도 유지하고 있는 스몰 배치 증류 공정으로\r\n\r\nPeated Non-Peated 위스키로 생산되는\r\n\r\nCampbeltown 특유의 두가지 스타일 라인업으로\r\n\r\n다재다능함을 보여주고 있습니다.\r\n\r\n그중 Glen Scotia 15년 Campbeltown 싱글 몰트 스카치 위스키는\r\n\r\n가장 아름다운 단순함 속에서 Campbeltown의 진정한 풍미를 전달하는\r\n\r\n특별한 싱글 몰트 위스키입니다.\r\n\r\n풍부하고 매끄러운 캐릭터로 Bourbon & American Oak Casks와\r\n\r\n오랫동안 매우 특별하고 오랜 관계를 유지,\r\n\r\n이 전통적인 목재 선택이 Glen Scotia의 느린 발효 및\r\n\r\n스몰 배치 공정을 보완하여\r\n\r\n기본적으로 균형 잡힌 과일 캐릭터와 달콤한 토피 및\r\n\r\nGlen Scotia 위스키를 정의하는 백그라운드 스파이스를 부여합니다.\r\n\r\n이후 Oloroso Casks에서 매우 짧은 피니시를 거쳐\r\n\r\n46% ABV로 병입된 마호가니색 주정이\r\n\r\n시트러스 껍질, 진저 스냅 비스킷, 구운 과일의 아로마와\r\n\r\n놀랍도록 건조하게 마무리되는 속이 가득 찬 과일, 살구, 과일 샐러드,\r\n\r\n캐러멜 설탕과 오크의 풍미에 이은\r\n\r\n따뜻한 스파이스, 매끄러운 꿀, 오크의 드라이 피니시를 선사,','글렌 스코시아 15년 700ml','글렌 스코티아(글렌 스코시아) 15년 700ml (Glen Scotia 15 Years Old 700ml)',25,4,1,5,1,2,4,1),(8,46,'아삭아삭한 소금기와 향긋한 플로럴 노트, 달콤한 꿀, 솔티드 카라멜이 어우러진 우아한 아로마',330000,'e62e7a78-9a75-47bc-9b58-047b0d5b2eeb_file1_temp117078497449237450376글렌스코 18년 썸넬.jpg','e62e7a78-9a75-47bc-9b58-047b0d5b2eeb_file2_temp29895461336406167632글렌스코 18년 인포1.jpg','/files/e62e7a78-9a75-47bc-9b58-047b0d5b2eeb_file1_temp117078497449237450376글렌스코 18년 썸넬.jpg','/files/e62e7a78-9a75-47bc-9b58-047b0d5b2eeb_file2_temp29895461336406167632글렌스코 18년 인포1.jpg','프루티 플레이버와 진하고 달콤한 토피, 살구, 파인애플, 속이 가득 찬 솔타나 노트','Glen Scotia 18년은 Oloroso Sherry Casks에서의 피니시를 통해\r\n\r\n과일의 달콤함과 클래식 Campbeltown 짠맛 사이의 밸런스를 자랑,\r\n\r\n파도의 비밀과 스파이스 힌트가 가미된\r\n\r\n증류소 고유의 프루티 캐릭터를 유지하면서도\r\n\r\n향긋한 플로럴 플레이버를 보완합니다.\r\n\r\nNon Chill-Filtered, 내츄럴 컬러, 46% ABV로 병입된\r\n\r\n반짝이는 황금색 주정이\r\n\r\n아삭아삭한 소금기와 향긋한 플로럴 노트, 달콤한 꿀, 솔티드 카라멜이\r\n\r\n어우러진 우아한 아로마와\r\n\r\n프루티 플레이버와 진하고 달콤한 토피, 살구, 파인애플, 속이 가득 찬\r\n\r\n술타나 노트의 믿을 수 없을 정도로 매끄럽고 풍부한 풍미에 이은\r\n\r\n전체적으로 부드럽고 따뜻한 스파이스로\r\n\r\n길고 드라이한 피니시를 선사,\r\n\r\n2022 San Francisco World Spirits Competition -Double Gold,\r\n\r\n2020 San Francisco World Spirits Competition - Gold\r\n\r\n2020 International Spirits Challenge-Gold에 빛나는\r\n\r\n향기로운 스파이시 캐릭터의\r\n\r\n우아하고 플로럴한 언피티드 싱글 몰트 위스키입니다.\r\n\r\n2022년 새롭게 고안된 주정빛과 잘 어울리는\r\n\r\n사랑스러운 골드 컬러의 패키지 디자인으로 제공,\r\n\r\nCampbeltown 몰트 위스키의 진정한 특성을 전달하는\r\n\r\n탁월한 몰트 위스키입니다.','글렌 스코시아 18년 700ml','글렌 스코티아(글렌 스코시아) 18년 700ml (Glen Scotia 18Years Old 700ml)',8,4,1,7,1,2,4,1),(9,45,'말린 무화과, 달콤한 경화 고기, 시나몬 스파이스, 퍼지, 밀크 초콜릿 향, 풍부한 스모크의 아로마',298000,'59833b91-ca16-4546-9812-863cdf8b9767_file1_temp13242582468664711372G&M 카너수어 초이스 쿠일라 썸넬.jpg','59833b91-ca16-4546-9812-863cdf8b9767_file2_temp216346845019808890052G&M 카너수어 초이스 쿠일라 인포1.jpg','/files/59833b91-ca16-4546-9812-863cdf8b9767_file1_temp13242582468664711372G&M 카너수어 초이스 쿠일라 썸넬.jpg','/files/59833b91-ca16-4546-9812-863cdf8b9767_file2_temp216346845019808890052G&M 카너수어 초이스 쿠일라 인포1.jpg','레드커런트, 블랙 페퍼, 레몬 껍질, 숲 과일의 노트로 가득 차며 복잡한 풍미','1968년 George Urquhart가 만든 Connoisseur\'s Choice 라인업은\r\n\r\n덜 알려진 증류소가 싱글 몰트를 선보일 수 있는 플랫폼을 제공해 왔습니다.\r\n\r\n당시 대부분의 증류주는 블렌디드 위스키에 사용되었으므로\r\n\r\n독특하고 선구적이며 끊임없이 변화해온 이 시리즈를 통해\r\n\r\n지금까지 거의 100개의 스코틀랜드 증류소에서\r\n\r\n2,000개 이상의 병입이 이루어 졌습니다.\r\n\r\n그 중에서도 유니크한 숙성 과정으로 유명한\r\n\r\n2009 빈티지 Caol ila 싱글 몰트는\r\n\r\nIslay 섬에 있는 상당한 규모의 Caol ila 증류소에서 생산된\r\n\r\n새로운 Heavily Peated Spirit을\r\n\r\n인디 보틀러인 Gordon & MacPhail이 2009년에 위탁하여\r\n\r\nRefill Ex-Bourbon Barrels에서 초기 11년 동안 숙성한 후\r\n\r\n감칠맛 있고 대담한 맛으로 유명한 Super Tuscan,\r\n\r\nSassicaia Red Wine을 이전에 보관했던 5개의 캐스크로 옮겨\r\n\r\n2년 동안 마무리하여 레드 베리 및 다크 스파이스 노트를 추출,\r\n\r\nCaol ila의 시트러스 및 스모키 플레이버와 함께\r\n\r\n많은 추가적인 레드 베리, 타바코 플레이버를 기대할 수 있는\r\n\r\nIslay Single Malt Scotch Whisky입니다.\r\n\r\n2022년 11월 Non Chill Filtered, 45% ABV로 병입된\r\n\r\n다크 골드색 주정이\r\n\r\n말린 무화과, 달콤한 경화 고기, 시나몬 스파이스,\r\n\r\n퍼지, 밀크 초콜릿 노트, 풍부한 스모크의 아로마와\r\n\r\n레드커런트, 블랙 페퍼, 레몬 껍질, 숲 과일의 노트로 가득찬\r\n\r\n복잡한 미각에 이은\r\n\r\n미디엄 바디로 입안을 맴도는 은은한 스모키 피니시를 선사,\r\n\r\nBatch 22/029에서 단 3,550병만이 생산되었으며\r\n\r\n이밖에도 캐스크 유형, 병입 날짜, 도수, 빈티지, 테이스팅 노트 등\r\n\r\n위스키의 스토리가 라벨에 자세히 설명되어 있습니다.\r\n\r\n블랙 포레스트 가토를 태운 것처럼 뚜렷한 숲 과일 톤과 함께\r\n\r\nCaol ila의 강렬한 스모키함을 유지하는 믿을 수 없을 정도로\r\n\r\n복합적인 따뜻함과 충만함을 지닌 훌륭한 위스키로\r\n\r\n숙성 과정에서 Gordon & MacPhail의 기술을 잘 보여주는 수작입니다.','G&M 카너수어 초이스 쿠일라 2009 13년 700ml','G&M 카너수어 초이스 쿠일라 2009 13년 700ml',7,4,1,6,1,2,4,1),(10,48,'흰 꽃, 커스터드, 꿀, 블랙 커런트 및 잘 익은 포도',230000,'b54831ea-8df8-454f-a5f7-2417d626de94_file1_temp1821605844155342436알프레드 지로 보야지 700ml 썸넬.jpg','b54831ea-8df8-454f-a5f7-2417d626de94_file2_temp23962925978368446672알프레드 지로 보야지 700ml 인포2.jpg','/files/b54831ea-8df8-454f-a5f7-2417d626de94_file1_temp1821605844155342436알프레드 지로 보야지 700ml 썸넬.jpg','/files/b54831ea-8df8-454f-a5f7-2417d626de94_file2_temp23962925978368446672알프레드 지로 보야지 700ml 인포2.jpg','숙성된 달콤한 포도, 신선한 꽃, 아카시아 꿀이 대담한 구조로 균형을 이루는 세련된 달콤함의 감미롭고 원숙한 플레이버','숙성과 마무리를 위해 독특한 캐스크를 사용,\r\n\r\n다양한 레드 와인과 화이트 와인 캐스크를 사용한 일련의 실험인\r\n\r\nThe Giraud Exploratory Range의 일부이자 최초의 릴리스인\r\n\r\nAlfred Giraud Voyage는\r\n\r\n유니크한 블렌드와 틀에 얽매이지 않는 캐스크의 결과물로서\r\n\r\n대담한 플레이버 프로필을 자랑하는 프렌치 몰트 위스키입니다.\r\n\r\nSauternes Wine Casks에서 숙성된 것과\r\n\r\nFrench Robinia Casks에서 숙성된\r\n\r\n두 가지 고급 싱글 몰트를 블렌딩하여 결합한 다음\r\n\r\n병입 하기 전에 Cognac Casks에서 다시 숙성,\r\n\r\n프랑스의 유명한 스위트 와인으로 달콤하고 원숙한 포도 노트의\r\n\r\nSauternes Wine Casks가 때때로 위스키 숙성에 사용되었던 반면\r\n\r\n강한 흰색 꽃 노트의 강력하고 진귀한 나무인 French Robinia는\r\n\r\n위스키 숙성에 사용된 적이 없는 프랑스산 목재로\r\n\r\n각각 대담한 특성을 지닌 배럴이\r\n\r\n프루티 노트와 곡물의 힌트를 주정에 주입하여\r\n\r\n대담하면서도 균형 잡힌 캐릭터로 프랑스 고유의 풍미를 풀어내고\r\n\r\nAlfred Giraud 프렌치 몰트 위스키의 대담한 스피릿을 보여줍니다.\r\n\r\nNon Chill-Filtered, 48% ABV, 내츄럴 컬러의 주정이\r\n\r\n흰 꽃, 커스터드, 꿀, 블랙 커런트 및 잘 익은 포도로 균형잡힌 아로마와\r\n\r\n숙성된 달콤한 포도, 신선한 꽃, 아카시아 꿀이\r\n\r\n대담한 구조로 균형을 이루는\r\n\r\n세련된 달콤함의 감미롭고 원숙한 플레이버에 이은\r\n\r\n달콤한 꽃의 복합성, 약간의 목재 힌트가 느껴지는\r\n\r\n고급스러운 식감의 피니시를 선사,\r\n\r\n전세계적으로 연간 5 캐스크만이 한정 출시되는\r\n\r\nDouble Malt & Triple Wood 블렌드로\r\n\r\n위스키 고유의 자연스러운 색감을 살린\r\n\r\n매끄럽고 정교하며 스타일리시한 디켄터가\r\n\r\n각각 개별적으로 번호가 매겨져 프렌치 시크를 구현합니다.\r\n\r\nCellar Masters Georges Clot과 Gaetan Mariolle에 의해\r\n\r\n두 가지 최고의 프랑스 싱글 몰트를 결합하여 완벽한 균형에 도달,\r\n\r\n진정한 풍미 탐구로서 본연의 풍미를 유지하면서\r\n\r\n창의적이고 균형 잡힌 플레이버를 만들고자 하는 열망에 의해\r\n\r\n전에 없던 위스키로 완성된\r\n\r\nGiraud 블렌딩 철학의 대담한 측면을 보여주는 수작입니다.','알프레드 지로 보야지 700ml','알프레드 지로 보야지 700ml (Alfred Giraud Voyage 700ml)',9,4,1,6,1,9,4,3),(11,55.8,'배, 청사과, 혼합된 복숭아',125000,'06d22a27-df5f-4474-aefb-6285f2831ac9_file1_temp116491140695139886237대디 랙 싱글 배럴 700ml 썸넬.jpg','06d22a27-df5f-4474-aefb-6285f2831ac9_file2_temp212638499864787466861대디 랙 싱글 배럴 700ml 인포3.jpg','/files/06d22a27-df5f-4474-aefb-6285f2831ac9_file1_temp116491140695139886237대디 랙 싱글 배럴 700ml 썸넬.jpg','/files/06d22a27-df5f-4474-aefb-6285f2831ac9_file2_temp212638499864787466861대디 랙 싱글 배럴 700ml 인포3.jpg','풍부한 퍼지, 다크 코코아, 바닐라, 호두','Daddy Rack American Whisky\r\n\r\n1등급 현지 재배 옥수수, 호밀 및 맥아 보리로 시작됩니다.\r\n\r\n옥수수 80%, 호밀 10%, 맥아 보리 10%의 Mashbill\r\n\r\n사용되는 모든 옥수수를 테네시 주 컬럼비아에 있는\r\n\r\n증류소 반경 50마일 이내의 농부들로부터 조달,\r\n\r\n제분하고 효모를 첨가한 곡물의 Sour Mash는 72시간 동안 발효되어\r\n\r\nCopper Column Still에서 1차,\r\n\r\nTraditional Pot Doubler Still에서 2차 증류를 거치게 됩니다.\r\n\r\n이후 메이플 나무 숯의 조밀한 층을 통해\r\n\r\n첫번째 Lincoln Country 프로세스 여과를 거친 증류액을\r\n\r\nCharred Level 3 New American Oak Barrels에서 숙성,\r\n\r\n싱글 배럴 병입을 위한 각 캐스크는\r\n\r\nJames Arthur Rackham이 직접 선택하여\r\n\r\n착색제, 카라멜, 설탕 또는 기타 첨가물 없이\r\n\r\n병입 전에 가벼운 2차 메이플 숯 여과를 거친 후\r\n\r\n배럴 번호와 출시 연도가 표시된 개별적으로 번호가 매겨진 병에 담겨\r\n\r\n최종 릴리스됩니다.\r\n\r\n수상 경력에 빛나는 이 강력한 위스키 셀렉션의\r\n\r\nDaddy Rack Single Barrel Cask Strength는 한정판으로 증류되어\r\n\r\n각 배럴의 고유한 풍미가 특징적인 Tennessee Straight Whisky로\r\n\r\nJ.Arthur Rackham (일명 Daddy Rack)이\r\n\r\n엄선한 10개의 싱글 배럴에서 최소 3년 8개월 이상의 숙성을 거쳐\r\n\r\n높은 ABV의 캐스크 스트렝스로 병입,\r\n\r\n2022년 11월 출시된 최신 리미티드 릴리스입니다.\r\n\r\n배, 청사과가 혼합된 복숭아 노트의 지배적인 아로마와\r\n\r\n풍부한 퍼지, 다크 코코아, 바닐라, 호두의 힌트에 이은\r\n\r\n헤비 피니시를 선사,\r\n\r\n부드럽지만 풍미 가득한 마무리를 통해\r\n\r\n순도와 플레이버의 미묘한 뉘앙스를 완성합니다.','대디 랙 싱글 배럴 700ml','대디 랙 싱글 배럴 700ml (Daddy Rack Single Barrel Cask Strength 700ml)',9,5,1,4,1,1,4,6),(12,59.9,'마지판과 바닐라 터치가 가미된 여러 겹의 말린 과일, 견과류, 스파이스한 아로마',320000,'76bf049f-9943-4b7f-ab98-e7d5b66281fe_file1_temp11254945034472068546카발란 솔리스트 올로로소 셰리 700ml 썸넬.jpg','76bf049f-9943-4b7f-ab98-e7d5b66281fe_file2_temp28510297633397886950카발란 솔리스트 올로로소 셰리 700ml 인포.jpg','/files/76bf049f-9943-4b7f-ab98-e7d5b66281fe_file1_temp11254945034472068546카발란 솔리스트 올로로소 셰리 700ml 썸넬.jpg','/files/76bf049f-9943-4b7f-ab98-e7d5b66281fe_file2_temp28510297633397886950카발란 솔리스트 올로로소 셰리 700ml 인포.jpg','기분 좋은 말린 과일 및 스파이스의 풍부하고 오일리한 맛','고대 Kavalan 일족의 원주민들이 단독으로 살았던\r\n\r\n대만 이란 현 주변의 신비로운 땅을 카발란(Kavalan)이라 불러왔는데\r\n\r\n이 이름은 원래의 도시가 같은 이름으로 지어졌던 1809년\r\n\r\n진나라 황제에 의해 마침내 공식적으로 인정됩니다.\r\n\r\n이러한 대만 토착민 무리의 이름을 따서 명명,\r\n\r\n평지 사람들(Flatland People)이란 뜻의 Kavalan 증류소는\r\n\r\n항상 원시적으로 유지되며 산맥의 깊은 곳으로부터 오는\r\n\r\n고품질의 천연수가 풍부한 설산(Syue Shan) 산맥에 의해\r\n\r\n외부 세계로부터 보호되어 온 Kavalan에서\r\n\r\n숙성의 재정의(Maturity Redefined)라 부르는\r\n\r\n아열대 온도와 높은 습도를 통해 가속화된 숙성으로\r\n\r\n풍부하고 복잡한 위스키로 널리 알려져 왔습니다.\r\n\r\n특히 밀도가 높고 풍미가 풍부한 위스키로 유명한 Kalavan의\r\n\r\n스페셜 에디션과 싱글 캐스크로 구성된 대규모 포트폴리오 중에서도\r\n\r\n제품의 상위 계층을 구성하는 Solist 라인은\r\n\r\n마스터 블렌더가 특별히 선별한\r\n\r\n개별적인 특성과 우수한 품질의 배럴이 특징적입니다.\r\n\r\n최고 품질의 스페셜 에디션으로\r\n\r\n단일 Oloroso Sherry Casks에서 완전히 숙성된\r\n\r\nKavalan Solist Oloroso Sherry Single Cask Strength=\r\n\r\n복잡한 캐릭터의 타고나기를 매끄럽고 풍부한 위스키로\r\n\r\n증류소에서 수제로 Non Chill-Filtered, 내츄럴 컬러,\r\n\r\n50-59.9% ABV로 병입되어\r\n\r\n어둡고 군침이 도는 건포도 컬러로\r\n\r\n마지판과 바닐라 터치가 가미된 여러 겹의 말린 과일, 견과류,\r\n\r\n스파이스의 깨끗하고 복합적인 아로마와\r\n\r\n기분 좋은 말린 과일 및 스파이스의 풍부하고 오일리한 플레이버에 이은\r\n\r\n고급 커피의 힌트가 더해진 입안을 맴도는 피니시를 선사합니다.\r\n\r\n2021 International Spirits Competition\r\n\r\n- Distillery of the Year / Distillery Visitor Centre Trophy,\r\n\r\n2021 International Wine & Spirits Competition\r\n\r\n- Worldwide Whiskey Trophy,\r\n\r\n2021 San Francisco World Spirits Competition\r\n\r\n- DOUBLE GOLD,\r\n\r\n2020 Australia International Spirits Competition - GOLD 등\r\n\r\n수많은 국제 대회에서의 수상 내력을 자랑하는\r\n\r\n실제로 매우 인기 있는 릴리스로\r\n\r\n특별히 스트레이트로 서브하는 것을 추천하는\r\n\r\nCask Strength 제품입니다.','카발란 솔리스트 올로로소 셰리 700ml','카발란 솔리스트 올로로소 셰리 700ml (Kavalan Solist Oloroso Sherry Single Cask Strength 700ml)',19,5,1,7,1,6,4,1),(13,40,'무취',13000,'bfbb1058-b2fe-4c36-baba-53e3f29f19e4_file1_temp115542908059825366693오션 오가닉 보드카 300ml.jpg','bfbb1058-b2fe-4c36-baba-53e3f29f19e4_file2_temp213954442277220900287오션 오가닉 보드카 300ml 인포1.jpg','/files/bfbb1058-b2fe-4c36-baba-53e3f29f19e4_file1_temp115542908059825366693오션 오가닉 보드카 300ml.jpg','/files/bfbb1058-b2fe-4c36-baba-53e3f29f19e4_file2_temp213954442277220900287오션 오가닉 보드카 300ml 인포1.jpg','독특한 맛과 입안 가득 번지는 부드러운 끝맛','Hawaii Sea Spirits의 첫번째 제품인\r\n\r\n오션 오가닉 보드카(Ocean Organic Vodka)는\r\n\r\n지구에서 생명이 살아갈 수 있도록 지탱해주는\r\n\r\n바다에 대한 헌사를 담아 완성된 세계 최고의 보드카 중 하나입니다.\r\n\r\n하와이는 이런 오션 오가닉 보드카를 제조하기에 최적의 환경을 갖추어\r\n\r\n세계에서 유일하게 유기농 재료를 직접 경작하여 보드카를 생산,\r\n\r\n마우이 섬에 위치한 80 에이커에 달하는 유기농 농장 및 증류소는\r\n\r\nHawaii Sea Spirits의 자급 자족적이고\r\n\r\n꾸준히 생산을 가능하게 하는 훌륭한 요소입니다.\r\n\r\n100% USDA 유기농 인증의 유기농 사탕수수를 사용하고\r\n\r\n태양에 의해 동력을 얻어 100% 해양 광천수와 블렌드,\r\n\r\n80 프루프의 보드카는 모두 60%의 물로 구성되어 있기 때문에\r\n\r\n수원의 품질은 보드카의 품질에 큰 영향을 미치게 됩니다.\r\n\r\n하와이의 빅 아일랜드 하와이 코나 해안 아래\r\n\r\n3,000 피트(915m)에서 공급되는 물은\r\n\r\n얼음처럼 차갑고 자연적으로 생성된 미네랄이 풍부한데\r\n\r\n높은 미네랄 함량은 보드카에 독특한 특성을 부여하고\r\n\r\n전통적인 보드카 칵테일에 깊은 맛을 더하며\r\n\r\n칼륨, 칼슘 및 마그네슘과 같은 풍부한 미네랄을 유지하면서\r\n\r\n나트륨을 제거하는 독점적인 자연 여과 공정을 통해\r\n\r\n유기적으로 정제 및 탈염되어\r\n\r\n결과적으로 글루텐 프리 및 GMO(유전자 변형 유기체),\r\n\r\n제초제 또는 살충제가 전혀 포함되어 있지 않은\r\n\r\n가장 깨끗하고 순수하며 상쾌한 풍미를 보장합니다.\r\n\r\n정밀 제어한 60 피트 높이 Column의 연속 증류 방식을 통해\r\n\r\n독특한 맛과 입안 가득 번지는 부드러운 끝맛을 선사,\r\n\r\n맛은 물론이고 패키지의 예술성을 인정받아\r\n\r\n매년 세계 유수의 대회에서 수상을 거둔 울트라 프리미엄 보드카입니다.\r\n\r\n드넓은 바다를 형상화한 아름다운 곡선의 매력적인 보틀 디자인은\r\n\r\n고대 유리로 된 그물 플로트에서 영감을 받았으며\r\n\r\n기울어진 부분은 지구의 축을 의미합니다.','오션 오가닉 보드카 300ml','오션 오가닉 보드카 300ml (Ocean Organic Vodka 300ml)',13,4,1,1,2,1,1,8),(17,37.5,'무취',21000,'cd8228c1-a341-423e-80b8-928546cdcda9_file1_temp111784900841791002713Smirnoff Vodka 700ml.jpg','cd8228c1-a341-423e-80b8-928546cdcda9_file2_temp27309250363032075347Smirnoff Vodka 700ml info.jpg','/files/cd8228c1-a341-423e-80b8-928546cdcda9_file1_temp111784900841791002713Smirnoff Vodka 700ml.jpg','/files/cd8228c1-a341-423e-80b8-928546cdcda9_file2_temp27309250363032075347Smirnoff Vodka 700ml info.jpg','매우 부드러운 풍미','세계 넘버 1보드카 스미노프는 세계방방곡곡에 걸쳐\r\n\r\n다른 품종에 영감을 얻은 클래식한 풍미를 자랑합니다.\r\n\r\n9리터 제품이 매해 25백만개 이상 팔리는 스미노프는\r\n\r\n세계에서 가장 잘 팔리는 보드카입니다.\r\n\r\n스미노프는 보드카를 위한 여과 장치로 숯을 사용한 최초의 회사입니다.\r\n\r\n스미노프 보드카는 옥수수에서 증류하여 Gluten-Free로 제조되며\r\n\r\n세번 증류하여 매우 부드러운 풍미를 특징으로 합니다.\r\n\r\n최종의 투명함을 위해 독특한 과정에서 10번 필터링되어\r\n\r\n스트레이트로 드시거나\r\n\r\n클럽 소다 또는 토닉 워터를 첨가한 소프트 드링크\r\n\r\n혹은 칵테일의 믹서로 사용하셔도 매우 훌륭한 제품입니다.\r\n\r\n특히 앱솔루트와 함께 보드카의 양대산맥으로\r\n\r\n러시아산 보드카의 독특한 맛과 향을 제공하는 몇 안되는 보드카입니다.','스미노프 보드카 700ml','스미노프 보드카 700ml (Smirnoff Vodka 700ml)',4,4,1,2,2,11,4,8),(18,40,'머랭, 누가, 페퍼의 아로',30000,'4836d1e3-10c6-46f7-93a7-3b3861abdad0_file1_temp117913033314187046209프라브다 보드카 700ml.jpg','4836d1e3-10c6-46f7-93a7-3b3861abdad0_file2_temp210605977698303166381프라브다 보드카 700ml info.jpg','/files/4836d1e3-10c6-46f7-93a7-3b3861abdad0_file1_temp117913033314187046209프라브다 보드카 700ml.jpg','/files/4836d1e3-10c6-46f7-93a7-3b3861abdad0_file2_temp210605977698303166381프라브다 보드카 700ml info.jpg','미디엄 바디로 미네랄, 크리미 바닐라가 보드랍고 드라이하며 오일리한 풍미','Pravda 보드카는 Bielskobiala의 청정 Carpathian 산악지대의\r\n\r\n깊숙한 곳에 위치, 폴란드 남부의 세계적으로 유명한\r\n\r\n보드카 생산 지역의 중심부에서\r\n\r\n6세대에 걸친 마스터 디스틸러의 엄격한 지침에 따라\r\n\r\n깨끗한 샘물과 호밀을 사용하여 스몰 배치로 만들어지고 있습니다.\r\n\r\nPravda는 폴란드 남부의 수제 프리미엄 보드카로\r\n\r\n매우 부드러운 프리미엄급 보드카입니다.\r\n\r\n세계에서 가장 우수하다고 자부할만한 원료를 가진 Bielskobiala의\r\n\r\nCarpathian 산맥은 가장 순수한 샘물을 생산,\r\n\r\n얼음처럼 차가우면서 부드러운 결정을 가진\r\n\r\n자연 그대로의 순수한 샘물을 바탕으로 제품을 생산합니다.\r\n\r\n여기에 Wielkopolska의 늦게 수확한 달콤한 호밀 밭이\r\n\r\n자연 그대로의 천연의 감미로운 맛을 내어\r\n\r\n프라브다 보드카는 1743년 한때 폴란드 귀족들에 의해\r\n\r\n가장 특별한 행사만을 위해서 준비되었습니다.\r\n\r\n5회 증류를 통한 고도의 매끄럽고 순수한 프리미엄 보드카로\r\n\r\n머랭, 누가, 페퍼의 아로마와\r\n\r\n미네랄, 크리미 바닐라의\r\n\r\n보드랍고 드라이하며 오일리한 미디엄 바디를 통해\r\n\r\n가루 설탕, 활석 및 미묘한 화이트 페퍼가\r\n\r\n입안을 맴도는 오랜 여운의 피니쉬를 선사합니다.\r\n\r\n2004년 샌프란시스코에서 열린 World Beverage Championships의\r\n\r\n전문가 시식회에서 여타 훌륭한 브랜드를 제치고\r\n\r\n최고의 럭셔리 보드카로 선정된 바 있습니다.','프라브다 보드카 700ml','프라브다 보드카 700ml (Pravda Vodka 40% 700ml)',4,4,1,2,2,14,4,8),(19,40,'무취',38000,'a0249f31-7818-4718-80d8-834a6bbdda57_file1_temp117795111464525998175소욤보 보드카 750ml.jpg','a0249f31-7818-4718-80d8-834a6bbdda57_file2_temp2870153535652371613Soyombo-Vodka-750ml info1.jpg','/files/a0249f31-7818-4718-80d8-834a6bbdda57_file1_temp117795111464525998175소욤보 보드카 750ml.jpg','/files/a0249f31-7818-4718-80d8-834a6bbdda57_file2_temp2870153535652371613Soyombo-Vodka-750ml info1.jpg','미묘한 달콤함과 그 어떤 보드카보다 부드러운 목넘김','APU의 보드카들 중에서도 소욤보는 수퍼 프리미엄 등급의 제품으로\r\n\r\n오직 몽골 셀렝게 지역의 최상급 유기농밀과\r\n\r\n신성한 보그드칸(Bogd Khan) 산맥의 80만년설이 흘러내려 만들어지는\r\n\r\n순수한 샘물만을 사용하여 제조된 제품입니다.\r\n\r\n가장 우수한 알파 그레이드 등급의 증류 과정을 6차례 거치고\r\n\r\nAPU의 첨단 공법인 숯, 석영, 다이아몬드&실버 필터링 과정을\r\n\r\n5일 이상 거친 수퍼 프리미엄 보드카입니다.\r\n\r\n소욤보 프리미엄 수퍼 보드카는 맛과 품질뿐만 아니라\r\n\r\n독특한 캐릭터로 꾸준한 상들을 받으며\r\n\r\n전세계적으로 그 권위를 인정받은 제품입니다.','소욤보 보드카 750ml','소욤보 보드카 750ml (Soyombo Vodka 750ml)',4,4,1,2,2,12,5,8),(20,40,'신선하고 매력적인 아로마',78000,'c7cd74a0-e2dd-4a5a-90e6-8e2703657165_file1_temp117191035827797940777엘릿 보드카 700ml.jpg','c7cd74a0-e2dd-4a5a-90e6-8e2703657165_file2_temp217688411794922056908엘릿 보드카 700ml info1.jpg','/files/c7cd74a0-e2dd-4a5a-90e6-8e2703657165_file1_temp117191035827797940777엘릿 보드카 700ml.jpg','/files/c7cd74a0-e2dd-4a5a-90e6-8e2703657165_file2_temp217688411794922056908엘릿 보드카 700ml info1.jpg','균형잡힌 매끄럽고 조화로운 풍미','특허받은 Freeze-Filtration 기술을 사용하여 탄생된\r\n\r\n유례 없는 순도의 놀라운 보드카로 2003년 런칭된 Elit은\r\n\r\nStoli 증류 기술의 정점을 상징합니다.\r\n\r\n수세기에 걸친 러시아 전통 레시피와\r\n\r\n-18°C의 저온에서 여과 과정을 거쳐\r\n\r\n최고 수준의 순도를 허용하는 혁신적인 Freeze-Filtration을 통해\r\n\r\n소비자를 위한 새로운 기준을 설정하고\r\n\r\n완전히 새로운 범주의 울트라 럭셔리 카테고리를 개척,\r\n\r\n최고 품질의 재료로 Kerschinskoye Estate에서 수확한\r\n\r\n겨울 밀을 세번 증류하여\r\n\r\n우아한 병 디자인부터 훌륭한 입맛에 이르기까지\r\n\r\n럭셔리함의 새로운 한계를 설정합니다.\r\n\r\n스톨리치나야 전 제품 중 최고급 제품이며\r\n\r\nUltra-Luxury 보드카 중에서도 손꼽을 수 있는 최고급 보드카로서\r\n\r\nBeverage Testing Institute에서\r\n\r\n역사상 가장 최고 점수인 97점을 받으며\r\n\r\n무려 9회의 플래티넘 메달을 획득,\r\n\r\n세계에서 가장 높은 등급의 White Spirits 중 하나로\r\n\r\n타의 추종을 불허하는 전설로 남아있습니다.\r\n\r\n40% ABV의 투명한 주정이 신선하고 매력적인 아로마와\r\n\r\n균형잡힌 매끄럽고 조화로운 풍미를 통해\r\n\r\n순수한 보드카의 특징적인 매우 세련되고 부드러운 피니쉬를 제공,\r\n\r\n두드러지는 광채와 입안 가득 맴도는 중량감과 어울리는\r\n\r\n긴 성상 모양(Iconic)의 보틀이\r\n\r\n러시아 정교회의 건축물에서 영감을 받은 마감으로 매력을 더하고\r\n\r\n제조 과정을 투영하는 불과 얼음으로 병의 전면을 장식합니다.\r\n\r\n탁월한 부드러움, 완벽한 우아함의 진정한 월드 클래스 보드카로\r\n\r\n러시아에서 보드카 생산 500주년을 기념하는 Elit 보드카는\r\n\r\n그 자체의 PURE CLASS입니다.','엘릿 보드카 700ml','엘릿 보드카 700ml (Elite Vodka 40% 700ml)',5,4,1,3,2,11,4,8),(21,40,'드라이한 과일, 그레인',38000,'39c4508f-2294-4e88-bbb3-03036bbe2cf1_file1_temp18107689623627157915앱솔루트 보드카l.jpg','39c4508f-2294-4e88-bbb3-03036bbe2cf1_file2_temp28100020110314327256앱솔루트 보드카l info1.jpg','/files/39c4508f-2294-4e88-bbb3-03036bbe2cf1_file1_temp18107689623627157915앱솔루트 보드카l.jpg','/files/39c4508f-2294-4e88-bbb3-03036bbe2cf1_file2_temp28100020110314327256앱솔루트 보드카l info1.jpg','보드카가 지닐 수 있는 최상의 순도와 풍부한 풀바디','앱솔루트 보드카는 1979년 뉴욕에서 처음 런칭되었습니다.\r\n\r\n출시와 함께 미국을 넘어 전세계적인 화제로 떠오른\r\n\r\n앱솔루트 보드카의 주요 구성 성분은\r\n\r\n불순물이 없는 Ahus 의 우물 물과 비료의 사용을 최소화한 겨울 밀로\r\n\r\n오직 이러한 천연 재료들만을 사용,\r\n\r\n다른 보드카와 달리 인공적인 감미료를 전혀 첨가하지 않은 제품입니다.\r\n\r\n1879년 Lars Olsson Smith에 의해 도입된 연속 증류법을\r\n\r\n100년 후 앱솔루트에 재도입하여\r\n\r\n지금까지 변함없는 보드카의 진정한 맛을 제공,\r\n\r\n보드카가 지닐수 있는 최상의 순도와 풍부한 풀바디로\r\n\r\n복합성, 드라이한 과일의 힌트와 그레인의 독특한 캐릭터가 느껴지는\r\n\r\n부드럽고 달콤한 시그니쳐를 선사합니다.\r\n\r\n이러한 앱솔루트 보드카의 깨끗한 천연의 풍미를 담은 레시피는\r\n\r\n실제 30년 이상된 것이며\r\n\r\n지금의 상징적인 앱솔루트 보드카 보틀은\r\n\r\n스웨덴 스톡홀름의 골동품 가게에서 발견한\r\n\r\n18세기 Medicine Bottle에서 영감을 얻은 것입니다.\r\n\r\n현재 골드 컴퍼니 매장에는 700ml와 1L가 각각 구비되어 있습니다.\r\n\r\n현재 국내에서 판매 1위의 기본 보드카 제품으로\r\n\r\n매년 별도로 한정판이 출시될 정도로 대인기 제품입니다.','앱솔루트 보드카 700ml','앱솔루트 보드카 700ml (Absolut Vodka 700ml)',7,4,1,2,2,12,4,8),(23,40,'아가베, 구운 후추, 스파이스, 블랙 페퍼콘의 아로마',58000,'aa095601-19d5-464f-980b-31391f92472a_file1_temp198114801107031301171800 실버 750ml.jpg','aa095601-19d5-464f-980b-31391f92472a_file2_temp234646200553427617411800 실버 750ml info1.jpg','/files/aa095601-19d5-464f-980b-31391f92472a_file1_temp198114801107031301171800 실버 750ml.jpg','/files/aa095601-19d5-464f-980b-31391f92472a_file2_temp234646200553427617411800 실버 750ml info1.jpg','달콤한 서양자두, 구운 후추의 세련된 미디엄 바디','오리지날 슈퍼 프리미엄 100% 아가베 테킬라,\r\n\r\n1800 테킬라는 증류 및 숙성을 거쳐 전문적으로 테킬라를 제작,\r\n\r\n최초로 릴리스한 해를 기념하고자 1800으로 이름을 명명하고\r\n\r\n1800년에 만들어진 오리지날 공식 표준을 준수하여 생산되고 있습니다.\r\n\r\n멕시코 할리스코에 있는 가족 소유 대농장의\r\n\r\n높은 해발의 고원 지대의 미네랄이 풍부한 토양에서 자라\r\n\r\n원숙해지기까지 8년~12년이 걸리는 블루 아가베는 오직 한번 수확되는데\r\n\r\n1800 실버 테킬라는 이러한 100% 웨버 블루 아가베로 만들어져\r\n\r\n두번의 증류를 거치고 특별히 선별된 화이트 테킬라를 함께 블렌드하여\r\n\r\n주정에 복잡성과 캐릭터를 추가하였습니다.\r\n\r\n그 결과 그 어떤 타사 제품보다도\r\n\r\n매끄럽고 놀라운 풍미의 프리미엄 테킬라로 탄생,\r\n\r\n병입 전 Ex-American Whiskey Barrels에서 숙성되어\r\n\r\n아가베, 구운 후추, 스파이스, 블랙 페퍼콘의 아로마와\r\n\r\n달콤한 서양자두, 구운 후추의 세련된 미디엄 바디로\r\n\r\n매끄럽고 순한 풍미 및 길고 달콤한 프루티 페퍼의 피니쉬를 선사합니다.\r\n\r\n멕시코에서 발견된 마야 피라미드를 연상시키는\r\n\r\n삼각형 모양의 시그니쳐 보틀 속 문양은\r\n\r\n마야 피라미드의 실루엣을 특징으로 하는 상단과\r\n\r\n그 아래 중앙의 1800 로고, 로고 아래에 위치한 십자가 및\r\n\r\n1800의 설립자, Juan Domingo Beckmann의 머리 글자인\r\n\r\nJ와 B로 이루어져 있으며\r\n\r\n문장의 가장 아래에 위치한 리본에 새겨진 단어들인\r\n\r\nTrabajo, Pasion, Honestidad는 Work, Passion, Honesty로\r\n\r\n1800 데킬라의 모든 병은 설립자 Juan Domingo Beckmann과\r\n\r\n데킬라 마에스트로 Rafael Ayala M. 의 서명으로 검증됩니다.\r\n\r\n달콤한 과일, 페퍼의 힌트로 깨끗하고 균형잡힌 풍미는\r\n\r\n스트레이트, 언더락은 물론 칵테일로도 완벽합니다.','1800 실버 750ml','1800 실버 750ml (1800 Silver 40% 750ml)',3,4,1,3,3,15,5,12),(24,40,'과일과 시트러스 향이 섞인 싱싱한 아가베 향',97000,'487f95b4-15c2-4067-9645-74050e20aeb0_file1_temp11611182829075988478Patron Silver 750ml.jpg','487f95b4-15c2-4067-9645-74050e20aeb0_file2_temp210933692514492491634Patron Silver 750ml info.jpg','/files/487f95b4-15c2-4067-9645-74050e20aeb0_file1_temp11611182829075988478Patron Silver 750ml.jpg','/files/487f95b4-15c2-4067-9645-74050e20aeb0_file2_temp210933692514492491634Patron Silver 750ml info.jpg','부드럽고 달콤한 맛으로 상큼한 시트러스와 조화를 이루는 싱싱한 아가베의 맛','페트론 실버는 오직 최상급의 웨버 블루 아가베만을 사용하여 만듭니다.\r\n\r\n이 제품은 부드럽고 순하며 쉽게 믹스할 수 있도록\r\n\r\n스몰 배치로 만들어지는 핸드메이드 제품입니다.\r\n\r\n세계의 데킬라 전문가들이 가장 좋아하는 제품 중의 하나로\r\n\r\n각각의 병은 유리 공예가에 의해 독자적인 방법으로 정교하게 만들어지며\r\n\r\n정품 인증을 위한 넘버링을 하는 것으로 유명합니다.','페트론 실버 750ml','페트론 실버 750ml (Patron Silver 750ml)',5,4,1,4,3,15,5,12),(25,40,'스모키한 향',67000,'12de6933-0fe5-4cd5-8cde-5a0c2575ce61_file1_temp17776465714212123411800 레포사도 750ml.jpg','12de6933-0fe5-4cd5-8cde-5a0c2575ce61_file2_temp279945331046320369361800 레포사도 750ml info1.jpg','/files/12de6933-0fe5-4cd5-8cde-5a0c2575ce61_file1_temp17776465714212123411800 레포사도 750ml.jpg','/files/12de6933-0fe5-4cd5-8cde-5a0c2575ce61_file2_temp279945331046320369361800 레포사도 750ml info1.jpg','버터 카라멜, 부드러운 향신료 맛','전문적으로 제작된 데킬라가 최초로 발표된 해를 기념하고자\r\n\r\n1800 데킬라는 1800년에 만들어진 오리지날 공식의 표준을\r\n\r\n여전히 지키고 있습니다.\r\n\r\n미국에서 가장 빠른 판매율을 자랑하는 1800 데킬라는\r\n\r\n100% 아가베 슈퍼 프리미엄 데킬라로\r\n\r\n특히 정교한 숙성과 지속적인 부드러움으로 유명합니다.\r\n\r\n그 중에서도 1800 레포사도는 미국에 수출된\r\n\r\n최초의 슈퍼 프리미엄 100% 아가베 데킬라로\r\n\r\n8~12 년급의 100% 블루 아가베로 제조,\r\n\r\n이중 증류한 주정을 American & French Oak Barrels에서\r\n\r\n최소 6개월 이상 숙성한 제품입니다.\r\n\r\n멕시코 할리스코에 있는 가족 소유 대농장에서\r\n\r\n직접 골라낸 100% 블루 아가베는\r\n\r\n높은 해발의 고원 지대의 미네랄이 풍부한 토양에서 자라며\r\n\r\n원숙해지기까지 8년이 걸리고 오직 한번 수확되고 있습니다.\r\n\r\n숙성 과정을 통해 밝은 꿀빛을 자랑하는 풍부한 주정이\r\n\r\n무화과, 젖은 돌, 말린 잔디 향과\r\n\r\n풀바디의 강렬하고 깔끔한 텍스쳐로\r\n\r\n깊은 맛을 가진 매끄럽고 폭넓은 풍미와 풍부한 피니쉬를 선사합니다.\r\n\r\n정교한 과정을 통해 탁월한 맛과 부드러움으로 완성,\r\n\r\n스트레이트, 언더락은 물론\r\n\r\n마가리타와 같은 칵테일 믹서로도 완벽한 제품입니다.\r\n\r\n삼각형 모양의 보틀이 멕시코에서 발견된 마야 피라미드를 연상케 하며\r\n\r\n보틀에 새겨진 1800 로고에 있는 문장은\r\n\r\n마야 피라미드의 실루엣을 특징으로 하는 상단과\r\n\r\n그 아래 중앙의 1800 로고, 그리고 로고 아래에 있는 십자가 및\r\n\r\n1800의 설립자, Juan Domingo Beckmann의 머리 글자인\r\n\r\nJ와 B로 이루어져 있습니다.\r\n\r\n문장의 가장 아래에 위치한 리본에 새겨진 단어들인\r\n\r\n“Trabajo, Pasion, Honestidad,\"는\r\n\r\n“Work, Passion, Honesty.”뜻으로\r\n\r\n1800 데킬라의 모든 병은\r\n\r\n1800의 설립자 Juan Domingo Beckmann과\r\n\r\n데킬라 마에스트로 Rafael Ayala M.의 서명으로 검증됩니다.','1800 레포사도 750ml','1800 레포사도 750ml (1800 Reposado 750ml)',3,4,1,3,3,15,5,13),(26,43.8,'뚜렷한 셰리 아로마',95000,'4f87b9d2-b715-4ba0-a810-686ff5518d73_file1_temp16593468165966246551포 필라스 셰리 캐스크 진 500ml.jpg','4f87b9d2-b715-4ba0-a810-686ff5518d73_file2_temp25644296772686542809포 필라스 셰리 캐스크 진 500ml info1.jpg','/files/4f87b9d2-b715-4ba0-a810-686ff5518d73_file1_temp16593468165966246551포 필라스 셰리 캐스크 진 500ml.jpg','/files/4f87b9d2-b715-4ba0-a810-686ff5518d73_file2_temp25644296772686542809포 필라스 셰리 캐스크 진 500ml info1.jpg','스타아니스, 말린과일, 견과류의 힌트가 추가되어 한층 길어지고 달콤해진 셰리의 풍미','Four Pillars 증류소의 모든 제품은 4개의 기둥을 바탕으로 제작됩니다.\r\n\r\n첫번째는 독일의 CARL에서 만들어진 아름다운 구리 포트 스틸,\r\n\r\nWilma, Jude & Eileen이며\r\n\r\n두번째는 세계 최고를 자랑하는 Yarra Valley의 물,\r\n\r\n세번째는 일부는 건조되고 일부는 신선한\r\n\r\n전세계와 호주 현지에서 공급되는 식물들,\r\n\r\n마지막은 이 모든 단계에 세심한 기술과 주의를 기울이는\r\n\r\nFour Pillars의 헌신입니다.\r\n\r\n2013년 말 Yarra Valley에서 증류를 시작한 이래\r\n\r\n모던한 호주 스타일의 인상적인 드라이 진을 생산,\r\n\r\n배치 당 450병의 스몰 배치로 증류되는 Four Pillars 진은\r\n\r\n호주산 밀 주정을 베이스로 사용하여 순도를 유지하고\r\n\r\n여러 스파이스를 첨가하여 베이스 주정의 강화 및\r\n\r\n뚜렷한 개성을 부여하고 있습니다.\r\n\r\n그 중에서도 풍부하고 겹겹이 쌓인 과일 및 견과류 플레이버의\r\n\r\n강렬하고 풍부한 에디션인 Four Pillars Sherry Cask Gin은\r\n\r\n훈훈한 오크, 미각의 부드러움,\r\n\r\n이전 Gin에서 본 적이 없는 풍미가 특징적인\r\n\r\n미국의 Old Tom Style Gin에서 영감을 얻은 Barrel-Aged Gin입니다.\r\n\r\n2013년 말 Old Chardonnay Barrels에\r\n\r\nRare Dry Gin을 넣어 숙성한 것을 시작으로\r\n\r\n2017년부터 더 많은 과일 및 견과류 캐릭터의\r\n\r\nSherry Cask Gin을 숙성,\r\n\r\n2018년의 첫번째 솔레라(Solera) 릴리스 이후\r\n\r\nSherry & Apera Casks에서 Rare Dry Gin을 숙성하여\r\n\r\n식물성 스파이스에 단맛을 더하고 있습니다.\r\n\r\n42개의 캐스크로 구성된 15년에서 35년까지 다양한\r\n\r\nSpanish Sherry Casks 2\r\n\r\nApera(Fortified Wine) Barrelsol\r\n\r\n솔레라(Solera) 시스템으로 배열되어\r\n\r\n캐스크가 숙성됨에 따라 더 짙어진 색상과\r\n\r\n소나무 오일 노트를 배경으로 잔존하는 셰리 캐릭터를 완성하며\r\n\r\nMacedonia Juniper를 증류하여 솔잎 노트와 함께\r\n\r\n약용의 플레이버를 더합니다.\r\n\r\n강렬한 향을 위해 South Australia 현지에서 조달한\r\n\r\nCoriander의 건조한 씨앗을 분쇄하고 증류하여\r\n\r\n놀라운 레몬 시트러스 노트를 생성하고\r\n\r\n세계에서 가장 비싼 스파이스 중 하나인\r\n\r\nGuatemala Green Cardamom을 증류하여\r\n\r\n강렬한 플레이버에 달콤한 향과 생강의 특성이 나타나도록 하였습니다.\r\n\r\nSri Lanka Cassia가 주정에 뚜렷한 풍부함을 더하여\r\n\r\n다른 모든 스파이스를 한데 모으고\r\n\r\nVietnam에서 공급된 Star Anise가 증류소 전체를\r\n\r\n신선한 감초, 사르사파릴라, 파스티스의 향기로 가득 차게 만드는\r\n\r\n놀라운 발향력을 발휘,\r\n\r\n다른 아로마를 끌어올리는 Yarra Valley Lavender,\r\n\r\n매우 미묘한 쓴맛과 함께 최종 진의 부드러운 텍스쳐를 더하는\r\n\r\nNetherlands Angelica와 함께\r\n\r\nTasmania Pepperberry 잎이 미각에 따뜻함과 길이를 추가합니다.','포 필라스 셰리 캐스크 진 500ml','포 필라스 셰리 캐스크 진 500ml (Four Pillars Sherry Cask Gin 43.8% 500ml)',6,4,1,3,4,8,3,22),(27,40,'다량의 생강, 따뜻한 유자의 기분 좋은 아로마',40000,'461ba0ab-47a8-4384-b2c4-e37d7272e03b_file1_temp11598812013626783099산토리 수이 진 700ml.jpg','461ba0ab-47a8-4384-b2c4-e37d7272e03b_file2_temp213607870896648394420산토리 수이 진 700ml info1.jpg','/files/461ba0ab-47a8-4384-b2c4-e37d7272e03b_file1_temp11598812013626783099산토리 수이 진 700ml.jpg','/files/461ba0ab-47a8-4384-b2c4-e37d7272e03b_file2_temp213607870896648394420산토리 수이 진 700ml info1.jpg','오렌지, 약간의 스파이스에 이어 거친 옥수수 낱알의 베이스로 ','음식 페어링에 진(Gin)을 사용하기 위해 Suntory에서 출시된\r\n\r\nSuntory Sui Gin은 100년 이상의 Suntory 장인 정신과\r\n\r\n위스키 및 증류주에 대한 전문 지식을 바탕으로\r\n\r\n엄선된 독특한 재료들의 조화로운 블렌드를 구현,\r\n\r\n디테일에 세심한 주의를 기울여 일본 장인이 만들고\r\n\r\n세 가지 일본 전통 식물의 최상의 균형을 포착한 결과,\r\n\r\n일본 문화의 풍부함으로 요리를 보완하고 어떤 식사든 돋보이게 합니다.\r\n\r\n일본 고유의 식물을 더한 드라이 진 타입의 재패니즈 크래프트 진으로\r\n\r\n서양을 중심으로 해외에서 인기를 끌고 있는\r\n\r\n경쾌한 그레인 맛과 시트러스의 상쾌함이 특징적인\r\n\r\n새로운 프리미엄 진(Gin)으로\r\n\r\n일상적인 식사에도 맛있게 즐길 수 있는 엄선한 조건의\r\n\r\n유자, 녹차, 생강의 3가지 일본 소재 및\r\n\r\n주니퍼 베리, 고수 씨, 안젤리카 뿌리, 안젤리카 씨, 카다멈 씨, 계피,\r\n\r\n비터 오렌지 껍질 및 레몬 껍질 등 8가지 전통적인 진 식물이 사용됩니다.\r\n\r\n유자향이 상쾌하게 느껴지며, 녹차의 부드러움과\r\n\r\n생강의 깔끔한 뒷맛이, 산뜻하고 가볍게 즐길 수 있는\r\n\r\n식사에 어울리는 새로운 진(Gin)으로\r\n\r\n일본 진(Gin)의 새로운 카테고리를 완성,\r\n\r\n40% ABV로 병입된 주정이\r\n\r\n다량의 생강, 따뜻한 유자의 기분 좋은 아로마와\r\n\r\n오렌지, 약간의 스파이스에 이어\r\n\r\n거친 옥수수 낱알의 베이스로 강조된 녹차의 풍미에 이어\r\n\r\n녹차, 생강, 주니퍼 순으로 입안을 맴도는 피니시를 선사,\r\n\r\n처음에는 유자가 지배적이며 뒤따르는 생강과 차의 신맛으로\r\n\r\n온더락, 토닉 워터 또는 칵테일로도 완벽한\r\n\r\n상쾌하고 유니크하며 모든 면에서 맛있는 음주 경험을 선물합니다.\r\n\r\n일본어로 옥을 의미하는 Sui()를 청록색을 통해 보틀에 반영,\r\n\r\n아름다운 육각형의 투명한 보틀이 깨끗함과 경쾌함을 나타내며\r\n\r\n레이블의 예술 작업은 Hibiki 및 Hakushu와 같은\r\n\r\nSuntory 위스키 레이블의 서예를 담당했던\r\n\r\n서예가 Tanyuki Ogino가 맡아\r\n\r\n물총새(Kingfisher)의 이미지에 \'옥\'을 의미하는 한자 翡翠로\r\n\r\nSui가 일본 진(Gin) 시장에서 날개를 펼치길 바라는\r\n\r\nSuntory의 희망을 담아냈습니다.\r\n\r\n전설적인 Premium Roku Gin에 이은\r\n\r\n새로운 버전의 Standard Japanese Gin으로\r\n\r\n모든 진 애호가를 위한 World Class Gin입니다.','산토리 수이 진 700ml','산토리 수이 진 700ml (Suntory Sui Gin 40% 700ml)',7,4,1,2,4,7,4,16),(28,47.2,'플로럴, 주니퍼, 시트러스, 오이 향',52000,'f0c16e35-755e-4c83-9120-7897855967de_file1_temp114309094182903931035헨드릭스 진 700ml.jpg','f0c16e35-755e-4c83-9120-7897855967de_file2_temp23950429231392957393헨드릭스 진 700ml info1.jpg','/files/f0c16e35-755e-4c83-9120-7897855967de_file1_temp114309094182903931035헨드릭스 진 700ml.jpg','/files/f0c16e35-755e-4c83-9120-7897855967de_file2_temp23950429231392957393헨드릭스 진 700ml info1.jpg','달콤하고 부드러운 풍미','스몰 배치는 일반적으로 1,000리터 이하를 의미합니다.\r\n\r\n헨드릭스 진은 마스터 디스틸러의 정교한 예술적 기교를 통해\r\n\r\n500리터의 소규모 배치들로 증류됩니다.\r\n\r\n헨드릭스 진은 세계 각국의 꽃, 뿌리, 과일, 씨앗으로 구성된\r\n\r\n놀라운 식물의 시그니쳐입니다.\r\n\r\n장미 꽃잎과 오이의 맛깔스러운 이중주의 인퓨전을 한층 보완,\r\n\r\n헨드릭스 진은 두가지 희귀하고 특별한 스틸들인\r\n\r\nBennet 스틸과 Carter-Head 스틸에서 생산된\r\n\r\n두가지 다른 주정들의 결합입니다.\r\n\r\n두 주정의 조합을 통해 필수적인 캐릭터와\r\n\r\n미묘한 풍미들의 균형이 돋보이는 매우 부드러운 진이 완성되었습니다.\r\n\r\n유례없는 독특한 풍미는 다른 진에서는 찾아볼수 없는\r\n\r\n특별한 생산 과정에서 기인한 것으로\r\n\r\n진과 함께 두드러지는 Bulgarian Rosa Damascena와\r\n\r\n특별하게 선별된 최상급 오이를 인퓨즈한 주정이\r\n\r\n입안 가득 프리미엄 진의 위엄을 선사합니다.','헨드릭스 진 700ml','헨드릭스 진 700ml (Hendrick\'s Gin 700ml)',4,4,1,3,4,2,4,18),(29,40,'소나무 향',28000,'a4342d39-31e2-4285-a095-6f4d76005fee_file1_temp15290757829505767328봄베이 사파이어 런던 드라이 진.jpg','a4342d39-31e2-4285-a095-6f4d76005fee_file2_temp29586958913735420243봄베이 사파이어 런던 드라이 진 info1.jpg','/files/a4342d39-31e2-4285-a095-6f4d76005fee_file1_temp15290757829505767328봄베이 사파이어 런던 드라이 진.jpg','/files/a4342d39-31e2-4285-a095-6f4d76005fee_file2_temp29586958913735420243봄베이 사파이어 런던 드라이 진 info1.jpg','선명한 레몬 껍질과 시트러스와 함께 허브, 쥬니퍼의 복합적인 조합','봄베이 사파이어(Bombay Sapphire)는\r\n\r\n세계에서 가장 빠르게 성장하고 있는 프리미엄 진입니다.\r\n\r\n봄베이 사파이어는 진을 생산하는 과정부터 영감을 주는 블루 보틀까지\r\n\r\n창의적인 사고의 역사를 담고 있습니다.\r\n\r\n120개 이상의 국가에 수출되고 있는 봄베이 사파이어 진의\r\n\r\n기대를 돋우는 부드러운 복합성이 느껴지는 풍미는\r\n\r\n식물학의 대가, Ivano Tonutti에 의해 전세계에서 손수 선별된\r\n\r\n10가지 이국적인 식물들의 독특한 조합의 완벽한 균형으로\r\n\r\n최상급 원료 성분의 숙달된 블렌드의 산물입니다.\r\n\r\n봄베이 사파이어 진은 전체의 풍미가\r\n\r\n완벽한 밸런스를 갖춘 특별한 부드러움을 제공,\r\n\r\n전세계 바텐더들의 상상력을 자극하는 향기로운 풍미와\r\n\r\n선명하면서도 섬세한 피니쉬로\r\n\r\n롱 드링크 또는 완벽한 균형의 마티니와 같은\r\n\r\n클래식 또는 현대적인 칵테일에 다재다능한 풍미를 선사합니다.\r\n\r\n선구자로 불리는 잉글랜드인 디스틸러 Thomas Dakin이\r\n\r\n1761년 완성한 레시피에 기반을 두고 있는 봄베이 사파이어 진은\r\n\r\n혁신에 뿌리는 둔 유산을 자랑합니다.\r\n\r\n현재까지 봄베이 사파이어는 1836년 이래로\r\n\r\n장인의 증기 주입 증류 공정을 사용하여 제조되고 있으며\r\n\r\n인상적인 반투명의 푸른색 유리 병은\r\n\r\n세련된 모던 디자인과 빅토리아 여왕 시대 식민지풍의 심상을 조합한\r\n\r\n매력적인 디자인의 완성작입니다.\r\n\r\n국내에 출시되고 있는 수많은 진중에서\r\n\r\n단연 독보적인 판매량의 제품으로\r\n\r\n한동안은 쉽게 그 적수가 없을 정도입니다.','봄베이 사파이어 런던 드라이 진','봄베이 사파이어 런던 드라이 진 (Bombay Sapphire Distilled London Dry Gin)',6,4,1,2,4,2,4,18);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_casks`
--

DROP TABLE IF EXISTS `product_casks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_casks` (
  `product_id` int(11) DEFAULT NULL,
  `cask_id` int(11) DEFAULT NULL,
  KEY `FKla84k0bmfgli8col9jqg53bih` (`cask_id`),
  KEY `FKq4i63a1mxr0hcvwa0m52dxxs2` (`product_id`),
  CONSTRAINT `FKla84k0bmfgli8col9jqg53bih` FOREIGN KEY (`cask_id`) REFERENCES `cask` (`id`),
  CONSTRAINT `FKq4i63a1mxr0hcvwa0m52dxxs2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_casks`
--

LOCK TABLES `product_casks` WRITE;
/*!40000 ALTER TABLE `product_casks` DISABLE KEYS */;
INSERT INTO `product_casks` VALUES (1,10),(2,10),(3,10),(4,3),(4,4),(4,10),(5,10),(6,2),(6,3),(6,4),(7,1),(7,2),(8,1),(8,2),(8,4),(9,2),(9,6),(10,6),(10,7),(10,8),(10,10),(11,1),(12,4),(25,1),(26,3),(26,4);
/*!40000 ALTER TABLE `product_casks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_file`
--

DROP TABLE IF EXISTS `product_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(200) DEFAULT NULL,
  `path` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_file`
--

LOCK TABLES `product_file` WRITE;
/*!40000 ALTER TABLE `product_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_pairings`
--

DROP TABLE IF EXISTS `product_pairings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_pairings` (
  `product_id` int(11) NOT NULL,
  `pairing_id` int(11) NOT NULL,
  KEY `FKblhpob01pc1aj0xqud4fisrrk` (`pairing_id`),
  KEY `FKteqobd16o6tj6n49rui4ea2xn` (`product_id`),
  CONSTRAINT `FKblhpob01pc1aj0xqud4fisrrk` FOREIGN KEY (`pairing_id`) REFERENCES `pairing` (`id`),
  CONSTRAINT `FKteqobd16o6tj6n49rui4ea2xn` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_pairings`
--

LOCK TABLES `product_pairings` WRITE;
/*!40000 ALTER TABLE `product_pairings` DISABLE KEYS */;
INSERT INTO `product_pairings` VALUES (1,2),(1,3),(1,4),(2,4),(2,5),(2,8),(3,5),(3,8),(4,1),(4,2),(4,3),(5,3),(5,4),(5,5),(6,1),(6,3),(6,6),(7,1),(7,2),(7,3),(8,3),(8,4),(8,5),(9,2),(9,3),(9,5),(10,2),(10,5),(10,8),(11,4),(11,5),(11,6),(12,2),(12,3),(12,5),(13,8),(17,8),(18,3),(18,8),(19,8),(20,2),(20,3),(20,8),(21,7),(21,8),(23,3),(23,8),(24,4),(24,5),(25,3),(25,7),(26,3),(26,7),(26,8),(27,3),(27,7),(27,8),(28,3),(28,8),(29,3),(29,8);
/*!40000 ALTER TABLE `product_pairings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_voter`
--

DROP TABLE IF EXISTS `product_voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_voter` (
  `product_id` int(11) NOT NULL,
  `voter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`product_id`,`voter_id`),
  KEY `FKsn2oq9m7uyss9acoa42o73gg4` (`voter_id`),
  CONSTRAINT `FKdlrg2wal4euk3jewxcu7h395d` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKsn2oq9m7uyss9acoa42o73gg4` FOREIGN KEY (`voter_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_voter`
--

LOCK TABLES `product_voter` WRITE;
/*!40000 ALTER TABLE `product_voter` DISABLE KEYS */;
INSERT INTO `product_voter` VALUES (1,1),(1,18),(5,1),(6,1),(7,1),(7,3),(12,1),(12,11);
/*!40000 ALTER TABLE `product_voter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_wish`
--

DROP TABLE IF EXISTS `product_wish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_wish` (
  `product_id` int(11) NOT NULL,
  `wish_id` bigint(20) NOT NULL,
  PRIMARY KEY (`product_id`,`wish_id`),
  KEY `FKlr3ut8tyiyq2mhm5f91ufdjot` (`wish_id`),
  CONSTRAINT `FK7h090ge9pl4r1wmje5292cp1j` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKlr3ut8tyiyq2mhm5f91ufdjot` FOREIGN KEY (`wish_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_wish`
--

LOCK TABLES `product_wish` WRITE;
/*!40000 ALTER TABLE `product_wish` DISABLE KEYS */;
INSERT INTO `product_wish` VALUES (1,18),(6,1),(6,3),(7,1),(7,3),(11,18),(12,1),(12,11);
/*!40000 ALTER TABLE `product_wish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `edit_mode` bit(1) NOT NULL,
  `modify_date` datetime(6) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3ga817bd8jyr5k5jocywwqtqb` (`author_id`),
  KEY `FKiyof1sindb9qiqr9o8npj8klt` (`product_id`),
  CONSTRAINT `FK3ga817bd8jyr5k5jocywwqtqb` FOREIGN KEY (`author_id`) REFERENCES `site_user` (`id`),
  CONSTRAINT `FKiyof1sindb9qiqr9o8npj8klt` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'리뷰리뷰리뷰q','2023-06-30 12:10:34.637739',_binary '\0','2023-08-03 09:35:56.909666',1,1),(2,'리뷰리뷰리뷰루','2023-06-30 12:10:42.568030',_binary '\0',NULL,1,2),(3,'리뷰뷰뷰뷰ㅠ븁뷰ㅠ븁','2023-06-30 12:10:56.208514',_binary '\0',NULL,1,7),(4,'리뷰뷰뷰뷰ㅠ뷰뷰뷰뷰ㅠ뷰뷰뷰','2023-06-30 12:11:15.945258',_binary '\0',NULL,3,7),(5,'리뷰뷰뷰뷰ㅠ뷰ㅠ뷰뷰ㅠ뷰븁','2023-06-30 12:11:21.428127',_binary '\0',NULL,3,7),(6,'리뷰뷰뷰뷰ㅠ븁뷰ㅠ뷰뷰ㅠㅂ','2023-06-30 12:11:30.429564',_binary '\0',NULL,3,1),(7,'리리뷰뷰릴뷰리뷰리뷰리뷸비류비ㅠㅂ','2023-06-30 12:11:36.922980',_binary '\0',NULL,3,1),(8,'리뷰리뷰리뷰ㅣㅠ비류비류비류ㅣ뷰리뷰리뷰립','2023-06-30 12:11:48.191165',_binary '\0',NULL,3,2),(13,'맛도 제취향이고 맛있어용!','2023-07-04 19:02:25.312012',_binary '\0','2023-07-04 19:03:13.146911',18,11),(14,'ㅇㅇ','2023-07-04 19:04:50.913873',_binary '\0',NULL,18,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_voter`
--

DROP TABLE IF EXISTS `review_voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_voter` (
  `review_id` bigint(20) NOT NULL,
  `voter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`review_id`,`voter_id`),
  KEY `FKdwyfgyy3mhjag10bhexe24cn8` (`voter_id`),
  CONSTRAINT `FK8m9va349w9mt3ctcjjx459stc` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`),
  CONSTRAINT `FKdwyfgyy3mhjag10bhexe24cn8` FOREIGN KEY (`voter_id`) REFERENCES `site_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_voter`
--

LOCK TABLES `review_voter` WRITE;
/*!40000 ALTER TABLE `review_voter` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_voter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_user`
--

DROP TABLE IF EXISTS `site_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date DEFAULT NULL,
  `mail_auth` bit(1) NOT NULL,
  `mail_key` int(11) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile_filename` varchar(255) DEFAULT NULL,
  `profile_filepath` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8907494besqu376vcikc4w9kf` (`nickname`),
  UNIQUE KEY `UK_jerlw3g2urnh55wcrm2b5kqnj` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_user`
--

LOCK TABLES `site_user` WRITE;
/*!40000 ALTER TABLE `site_user` DISABLE KEYS */;
INSERT INTO `site_user` VALUES (1,'1993-11-03',_binary '',15094,'관리자','$2a$10$E6ANEC0zfEfbUkglKh0XbOIdJRSsXbUZ0Ul.qv6PLSvQOKw6XROFS','66b5af82-923d-4efb-98a9-0a67cc9fd921_temp10654551469310579356호섭이.jpg','/files/66b5af82-923d-4efb-98a9-0a67cc9fd921_temp10654551469310579356호섭이.jpg','ADMIN','admin@gmail.com'),(3,'1993-11-03',_binary '',27164,'황인성','$2a$10$lHJqbY4A8wx3gMn2TSyLqeNo/i.k1cAHb6q/a1uS7vux..azS1OS.',NULL,NULL,'USER','insung5189@gmail.com'),(7,'1993-11-03',_binary '',65245,'샘플계정1','$2a$10$AXrn.UPbRSAmbkcYJBUnfu50OhsvrgoujFMgMGKhOPpP7JmIdscz6',NULL,NULL,'USER','sample1@gmail.com'),(11,'1993-11-03',_binary '',15322,'김호현관리자','$2a$10$CrD3Gl4ss9m00D0ZEZYPhuB.3ZYlqk.bEgop5/LJhjKcsIyKQ2.zu','d59ac77a-aff9-44b5-bfc9-ac5de516d956_temp1280063400581244001366b5af82-923d-4efb-98a9-0a67cc9fd921_temp10654551469310579356호섭이.jpg','/files/d59ac77a-aff9-44b5-bfc9-ac5de516d956_temp1280063400581244001366b5af82-923d-4efb-98a9-0a67cc9fd921_temp10654551469310579356호섭이.jpg','USER','pintor.dev@gmail.com'),(12,'1998-08-24',_binary '',80994,'hfdjdjtr','$2a$10$ImaznUE8j2nekc4mFI49xugSa6a8wn94swcxARwEH.6ojPgdftiAy','b269b0af-639c-427c-8cca-8e6e9db08a71_temp970918175210674541866b5af82-923d-4efb-98a9-0a67cc9fd921_temp10654551469310579356호섭이.jpg','/files/b269b0af-639c-427c-8cca-8e6e9db08a71_temp970918175210674541866b5af82-923d-4efb-98a9-0a67cc9fd921_temp10654551469310579356호섭이.jpg','USER','ghkdthdud824@naver.com'),(14,'1993-11-03',_binary '',43283,'인성이스','$2a$10$6ur./lTqB8Kp96wLs.F75.kLDzJBORVv7m6QrX3ScEs0jsW3fahrK',NULL,NULL,'USER','insung5189youpri@gmail.com'),(15,'1998-09-29',_binary '',70055,'tjqls','$2a$10$UO56pt.Kd.yo15k/0mT.B.5YJfWmswnJLCompVI9sl5Y7suvJLjCW',NULL,NULL,'USER','tjqls2013@gmail.com'),(18,'2001-01-28',_binary '',36789,'채롱잉','$2a$10$aWCMrjfS42JRuhTgg7QUdui0C4mBk/oKYeZxTNMzdFgQ0QaadjW7S','dd08c425-7c9b-4fb2-9796-6ddcb928e898_temp8883424466318717919다운로드 (3).png','/files/dd08c425-7c9b-4fb2-9796-6ddcb928e898_temp8883424466318717919다운로드 (3).png','USER','thdcodud01@gmail.com'),(19,'1993-11-03',_binary '',19178,'황인성관리자','$2a$10$t2t1ileM9pXKGETFcjujIus1w1/FbZzvF.bgU7ULn3L6Izda1MjNW',NULL,NULL,'USER','insung1234@gmail.com'),(21,'1993-11-03',_binary '',51554,'sdf','$2a$10$uytirsYhmQVBQD.VONQfG.0CzuXcvahz0HnA2kuUxxtTWPlS37S6i','c72f60eb-1171-4750-8994-5d9309a89e47_temp12914357626664070969images.jpg','/files/c72f60eb-1171-4750-8994-5d9309a89e47_temp12914357626664070969images.jpg','USER','asdf@gmail.com');
/*!40000 ALTER TABLE `site_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_category` varchar(200) DEFAULT NULL,
  `main_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK753xnmtixdl7hf7c7h3hsjuam` (`main_category_id`),
  CONSTRAINT `FK753xnmtixdl7hf7c7h3hsjuam` FOREIGN KEY (`main_category_id`) REFERENCES `main_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,'싱글몰트 위스키',1),(2,'싱글그레인 위스키',1),(3,'블렌디드몰트 위스키',1),(4,'블렌디드 위스키',1),(5,'버번 위스키',1),(6,'테네시 위스키',1),(7,'기타 위스키',1),(8,'일반 보드카',2),(9,'플레이버드 보드카',2),(10,'기타 보드카',2),(11,'메즈칼',3),(12,'블랑코 데킬라',3),(13,'레포사도 데킬라',3),(14,'아네호 데킬라',3),(15,'기타 데킬라',3),(16,'주니퍼 진',4),(17,'올드 톰 진',4),(18,'런던 드라이 진',4),(19,'네이비 스트렝스 진',4),(20,'슬로 진',4),(21,'크래프트 진',4),(22,'기타 진',4),(23,'화이트 럼',5),(24,'골드 럼',5),(25,'다크 럼',5),(26,'오버프루프 럼',5),(27,'기타 럼',5),(28,'꼬냑',6),(29,'아르마냑',6),(30,'깔바도스',6),(31,'기타 브랜디',6),(32,'라거 맥주',7),(33,'에일 맥주',7),(34,'밀 맥주',7),(35,'흑 맥주',7),(36,'기타 맥주',7);
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'spirits'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-03 12:04:31
