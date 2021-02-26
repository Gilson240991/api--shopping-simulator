
INSERT INTO Card (id, card_type, card_name, card_description) VALUES (1,'001', 'Clásica', 'Tipo de tarjeta clasica');
INSERT INTO Card (id, card_type, card_name, card_description) VALUES (2,'002', 'Oro', 'Tipo de tarjeta de oro');
INSERT INTO Card (id, card_type, card_name, card_description) VALUES (3,'003', 'Black', 'Tipo de tarjeta black');
INSERT INTO Card (id, card_type, card_name, card_description) VALUES (4,'004', 'Platinium', 'Tipo de tarjeta Platinium');

INSERT INTO Product (id,product_code, product_name) VALUES (1,'P0001', 'Este es un comentario');
INSERT INTO Product (id,product_code, product_name) VALUES (2,'P0002', 'Este es un comentario');
INSERT INTO Product (id,product_code, product_name) VALUES (3,'P0003', 'Este es un comentario');

INSERT INTO product_card (id_product,id_card) VALUES (1,1);
INSERT INTO product_card (id_product,id_card) VALUES (1,2);
INSERT INTO product_card (id_product,id_card) VALUES (1,3);
INSERT INTO product_card (id_product,id_card) VALUES (2,2);
INSERT INTO product_card (id_product,id_card) VALUES (2,2);
INSERT INTO product_card (id_product,id_card) VALUES (3,4);


INSERT INTO client (names, father_Last_Name, mother_Last_Name,document_number) VALUES ('Gilson Jair', 'Aguilar','Carbajal','47384650');
INSERT INTO client (names, father_Last_Name, mother_Last_Name,document_number) VALUES ('Jose Manuel', 'Huayhua','Huaraca','47384651');
INSERT INTO client (names, father_Last_Name, mother_Last_Name,document_number) VALUES ('Dina Betsabe', 'Calderon','Collazos','47259808');
INSERT INTO client (names, father_Last_Name, mother_Last_Name,document_number) VALUES ('Jesus ', 'Cochachi','Gamarra','47259800');

INSERT INTO client_product (id_client,id_product) VALUES (1,1);
INSERT INTO client_product (id_client,id_product) VALUES (2,2);
INSERT INTO client_product (id_client,id_product) VALUES (4,3);
