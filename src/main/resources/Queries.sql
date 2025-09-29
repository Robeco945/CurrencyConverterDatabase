USE currencyconverter;
SELECT abreviation, name FROM currencyconverter.currency;

SELECT * FROM currencyconverter.currency WHERE abreviation = 'EUR';

SELECT COUNT(*) as id FROM currencyconverter.currency;

SELECT abreviation, tousd FROM currencyconverter.currency ORDER BY tousd DESC LIMIT 1;