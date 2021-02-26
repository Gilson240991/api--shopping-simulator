CREATE TABLE Card(
  id INTEGER IDENTITY PRIMARY KEY,
  card_type VARCHAR(30) NOT NULL,
  card_name VARCHAR(30) NOT NULL,
  card_description VARCHAR(28) DEFAULT NULL
);

CREATE TABLE product(
  id INTEGER IDENTITY PRIMARY KEY,
  product_code VARCHAR(30) NOT NULL,
  product_name VARCHAR(100) NOT NULL
);

CREATE TABLE product_card(
  id_product INTEGER NOT NULL,
  id_card INTEGER  NOT NULL
);

CREATE TABLE client(
id INTEGER IDENTITY PRIMARY KEY,
names VARCHAR(50) NOT NULL,
Father_Last_Name VARCHAR(50) NOT NULL,
Mother_Last_Name VARCHAR(50) NOT NULL,
document_number VARCHAR(15) NOT NULL
);

CREATE TABLE client_product(
  id_client INTEGER NOT NULL,
  id_product INTEGER  NOT NULL
);





