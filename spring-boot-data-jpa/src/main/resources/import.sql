/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Hector', 'Huaman Flores', 'hector.10.fisi@gmail.com', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Tatiana', 'Huaman Flores', 'tatiana@gmail.com', '2017-08-02', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Angely', 'Huaman Flores', 'angely@gmail.com', '2017-08-03', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05', '');


/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/* Creamos algunos usuarios con sus roles*/
INSERT INTO users (username,password,enabled) VALUES ('andres','$2a$10$pN5tnPLNnrwtaMtQIW5UbOPo4oACX5Awgu21SKBx40m79Lz9mEgaO',1);
INSERT INTO users (username,password,enabled) VALUES ('admin','$2a$10$mbDW3By5KzgddUABp9O/p.mIyi1OK/TwiELPsxZ0Gokya9KyBl9MK',1);

INSERT INTO authorities (user_id,authority) VALUE (1,'ROLE_USER');
INSERT INTO authorities (user_id,authority) VALUE (2,'ROLE_ADMIN');
INSERT INTO authorities (user_id,authority) VALUE (2,'ROLE_USER');
