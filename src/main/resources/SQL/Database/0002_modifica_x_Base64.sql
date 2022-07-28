ALTER TABLE `gestech2`.`hy_dettaglio_risorsa` 
CHANGE COLUMN `file_base64` `file_base64` MEDIUMTEXT NULL DEFAULT NULL ;

ALTER TABLE `gestech2`.`sy_risorse` 
CHANGE COLUMN `nome_cognome` `nome_cognome` VARCHAR(60) NULL DEFAULT NULL ;
