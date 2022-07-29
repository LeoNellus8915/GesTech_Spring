CREATE TABLE `gestech2`.`hy_richieste` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_risorsa` INT NULL DEFAULT NULL,
  `data` DATE NULL DEFAULT NULL,
  `id_skill` INT NULL DEFAULT NULL,
  `id_profilo` INT NULL DEFAULT NULL,
  `id_seniority` INT NULL DEFAULT NULL,
  `cliente` VARCHAR(45) NULL DEFAULT NULL,
  `citta` VARCHAR(60) NULL DEFAULT NULL,
  `costo` DOUBLE NULL DEFAULT NULL,
  `note` TEXT NULL DEFAULT NULL,
  `recruiter` VARCHAR(100) NULL DEFAULT NULL,
  `id_stato` INT NULL DEFAULT 1,
  `id_commenti_richiesta` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



ALTER TABLE `gestech2`.`hy_commenti_avvisi` 
RENAME TO  `gestech2`.`hy_commenti_risorse` ;


CREATE TABLE `gestech2`.`hy_commenti_richieste` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_risorsa` INT NULL,
  `note` TEXT NULL,
  `data` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE `gestech2`.`ty_stati_richiesta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


INSERT INTO `gestech2`.`ty_stati_richiesta` (`nome`) VALUES ('In Corso');
INSERT INTO `gestech2`.`ty_stati_richiesta` (`nome`) VALUES ('In Lavorazione');
INSERT INTO `gestech2`.`ty_stati_richiesta` (`nome`) VALUES ('Sospesa');
INSERT INTO `gestech2`.`ty_stati_richiesta` (`nome`) VALUES ('Chiusa');
