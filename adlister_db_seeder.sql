USE adlister_db;

INSERT INTO categories(name) VALUES ('electronics');
INSERT INTO categories(name) VALUES ('animals');
INSERT INTO categories(name) VALUES ('food');
INSERT INTO categories(name) VALUES ('events');

SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));