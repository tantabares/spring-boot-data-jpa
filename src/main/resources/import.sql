/*Populate Tables*/
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Jhony', 'Rodriguez', 'brakwill@mail.com', '2017-08-28', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Juan', 'Tabares', 'jutagers@mail.com', '2017-06-16', '');
INSERT INTO clientes(nombre, apellido, email, created_at, foto) VALUES('Maria', 'Perez', 'omaripe@mail.com', '2018-01-01', '');

/* Populate tabla productos */
INSERT INTO productos(nombre, precio, created_at) VALUES('PANASONIC Pantalla LCD','299.99', now());
INSERT INTO productos(nombre, precio, created_at) VALUES('SONY Camara Digital','1200.00', now();
INSERT INTO productos(nombre, precio, created_at) VALUES('APPLE iPod Shuffle','124.99', now());
INSERT INTO productos(nombre, precio, created_at) VALUES('SONY Notebook z110','300.00', now());
INSERT INTO productos(nombre, precio, created_at) VALUES('HP Multifuncional F2280','699.99', now());
INSERT INTO productos(nombre, precio, created_at) VALUES('RALI bicicleta 29"','600', now());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, created_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 6);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

INSERT INTO facturas (descripcion, observacion, cliente_id, created_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
