use otel;

DELIMITER $$
CREATE PROCEDURE gosterOdaDolu()
BEGIN
SELECT * FROM OdaBilgileri WHERE OdaDurumu = "1";
END $$ 
DELIMITER ;

DELIMITER //
CREATE PROCEDURE rezervasyonSayisi()
BEGIN
SELECT COUNT(RezervasyonDurum) FROM rezervasyonbilgileri WHERE RezervasyonDurum=1;
END // 
DELIMITER ;

CALL rezervasyonSayisi();


DELIMITER $$
CREATE PROCEDURE gosterOda()
BEGIN
SELECT * FROM OdaBilgileri WHERE OdaDurumu = "0";
END $$ 
DELIMITER ;

CALL gosterOda();

DELIMITER $$
CREATE PROCEDURE gosterMusteri()
BEGIN
SELECT * FROM MusteriBilgileri;
END $$ 
DELIMITER ;

CALL gosterMusteri();

DELIMITER $$
CREATE PROCEDURE gosterOda()
BEGIN
SELECT * FROM OdaBilgileri;
END $$ 
DELIMITER ;

CALL gosterOda();

DELIMITER $$
CREATE PROCEDURE gosterOdaTip()
BEGIN
SELECT * FROM OdaTipleri;
END $$ 
DELIMITER ;

CALL gosterOdaTip();

DELIMITER $$
CREATE PROCEDURE gosterRezervasyon()
BEGIN
SELECT * FROM RezervasyonBilgileri;
END $$ 
DELIMITER ;

CALL gosterRezervasyon();

DELIMITER //
CREATE PROCEDURE rezervasyonSayisi()
BEGIN
SELECT COUNT(RezervasyonDurum) FROM rezervasyonbilgileri WHERE RezervasyonDurum=1;
END // 
DELIMITER ;

CALL rezervasyonSayisi();

use otel;

DELIMITER //
create trigger kayitlimusteri after insert
on musteribilgileri for each row
BEGIN
UPDATE sayac SET sayac= sayac+1; 
end //
DELIMITER ;


DELIMITER //
create trigger RezDurSayi after insert
on rezervasyonbilgileri for each row
BEGIN
UPDATE rds SET rds= rds+1; 
end //
DELIMITER ;

DELIMITER $$
CREATE TRIGGER  odaGuncelle AFTER UPDATE
ON OdaTipleri for each row
BEGIN
IF NEW.OdaDurumu != OLD.OdaDurumu THEN
    INSERT INTO  musaitGuncelle(
        OdaID,
        OdaNumarasi,
        OdaTipID,
        OdaDurumu)
    VALUES(OLD.OdaID,OLD.OdaNumarasi,OLD.OdaTipID,NEW.OdaDurumu);
END IF
END $$ 
DELIMITER ;


create database otel;

use otel;

create table MusteriBilgileri (
MusteriID INTEGER PRIMARY KEY AUTO_INCREMENT,
MusteriTC VARCHAR(20) not null UNIQUE,
MusteriAdi VARCHAR(20) NOT NULL,
MusteriSoyadi VARCHAR(20) NOT NULL,
MusteriTel INTEGER NOT NULL,
MusteriParola VARCHAR(20),
MusteriMail VARCHAR(50) NOT NULL
);
ALTER TABLE MusteriBilgileri MODIFY COLUMN MusteriTel VARCHAR(15);
ALTER TABLE MusteriBilgileri MODIFY COLUMN MusteriTC VARCHAR(11);
ALTER TABLE MusteriBilgileri MODIFY COLUMN MusteriMail VARCHAR(70) UNIQUE;

create table OdaTipleri (
OdaTipID INTEGER PRIMARY KEY AUTO_INCREMENT,
OdaTipAdi VARCHAR(30) NOT NULL,
OdaKisiSayisi INTEGER NOT NULL
);
ALTER TABLE OdaTipleri ADD COLUMN Fiyat Double;

create table OdaBilgileri (
OdaID INTEGER PRIMARY KEY AUTO_INCREMENT,
OdaNumarasi VARCHAR(20) NOT NULL,
OdaTipID INTEGER NOT NULL,
OdaDurumu INTEGER NOT NULL DEFAULT "0",
FOREIGN KEY(OdaTipID) REFERENCES OdaTipleri(OdaTipID)
);

create table RezervasyonBilgileri(
RezervasyonID INTEGER PRIMARY KEY AUTO_INCREMENT,
RezervasyonBaslangicTarihi DATE NOT NULL,
RezervasyonBitisTarihi DATE NOT NULL,
OdaID INTEGER NOT NULL,
RezervasyonDurum INTEGER NOT NULL DEFAULT "1",
FOREIGN KEY (OdaID) REFERENCES OdaBilgileri(OdaID)
);

create table RezervasyonKayitBilgileri (
KayitID INTEGER PRIMARY KEY AUTO_INCREMENT,
RezervasyonID INTEGER NOT NULL,
MusteriID INTEGER NOT NULL,
FOREIGN KEY (MusteriID) REFERENCES MusteriBilgileri(MusteriID),
FOREIGN KEY (RezervasyonID) REFERENCES RezervasyonBilgileri(RezervasyonID)
);

ALTER TABLE RezervasyonBilgileri ADD COLUMN ToplamFiyat Double;
ALTER TABLE RezervasyonBilgileri ADD COLUMN MusteriID Integer;

INSERT INTO OdaBilgileri VALUES(NULL, 1, 1, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 2, 1, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 3, 2, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 4, 2, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 5, 3, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 6, 3, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 7, 4, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 8, 4, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 9, 5, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 10, 5, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 11, 6, 0);
INSERT INTO OdaBilgileri VALUES(NULL, 12, 6, 0);

INSERT INTO otel.rezervasyonbilgileri VALUES(NULL, "2021-12-31", "2022-01-05", 1, 1);
INSERT INTO otel.rezervasyonbilgileri VALUES(NULL, "2021-12-31", "2022-01-05", 2, 1);

UPDATE rezervasyonBilgileri SET RezervasyonDurum = 1 WHERE RezervasyonID = 2;







