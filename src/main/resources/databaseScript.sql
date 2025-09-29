DROP DATABASE IF EXISTS currencyconverter;
CREATE DATABASE currencyconverter;
USE currencyconverter;

DROP TABLE if EXISTS currency;
CREATE TABLE currency(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
abreviation VARCHAR(50) NOT NULL,
toUSD DECIMAL(10,6) NOT NULL,
PRIMARY KEY (id)
);
USE currencyconverter;
INSERT INTO currency (name, abreviation, toUSD) VALUES
('United States Dollars','USD',1),
('Euro','EUR',1.2),
('Australian Dollars','AUD',0.653),
('Vietnam Dong','VND',0.00004),
('Swiss Francs','CHF',1.08),
('Japanese Yen','JPY',0.0067),
('Great British Pounds','GPD',1.34),
('Chinese Yuan','CNY', 0.1405);
USE currency;
DROP USER if EXISTS appuser;
CREATE USER 'appuser';
GRANT SELECT ON currencyconverter.currency TO 'appuser'@'localhost';
USE currencyconverter;
SELECT * FROM currency;
