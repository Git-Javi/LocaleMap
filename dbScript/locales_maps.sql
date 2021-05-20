CREATE DATABASE IF NOT EXISTS locales_map;

GRANT ALL PRIVILEGES ON locales_map.* TO DAW WITH GRANT OPTION;

USE locales_map;

CREATE TABLE IF NOT EXISTS local (
		id INT PRIMARY KEY,
        nombre VARCHAR(100),
        categoria VARCHAR(50),
        coordenadas VARCHAR(100)
);

INSERT INTO local VALUES(1,'1589','Bares','{ "lat": 43.37084698098432, "lng": -8.395186629097935 }');
INSERT INTO local VALUES(2,'Old School','Bares','{ "lat": 43.36024073498093, "lng": -8.407795055832091 }');
INSERT INTO local VALUES(3,'El Pato Mareado','Bares','{ "lat": 43.36519363706854, "lng": -8.406146462125987 }');
INSERT INTO local VALUES(4,'La Pelicano','Discotecas','{ "lat": 43.36838796543832, "lng": -8.399788101905386 }');
INSERT INTO local VALUES(5,'Artabria','Restaurantes','{ "lat": 43.36657457056799, "lng": -8.413211544235057 }');
INSERT INTO local VALUES(6,'El De Alberto','Restaurantes','{ "lat": 43.37014655962615, "lng": -8.404776217246098 }');