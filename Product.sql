CREATE DATABASE Product
USE Product
CREATE TABLE Shoes(
	shoe_id INT IDENTITY(1,1) PRIMARY KEY,
	brand VARCHAR(50),
	model VARCHAR(50),
	color VARCHAR(50),
	price DECIMAL(10,2),
  inventory INT
);
-- 插入鞋子資料
INSERT INTO Shoes (brand, model, color, price, inventory) VALUES ('Nike', 'Air Max', 'Black', 129.99, 50);
INSERT INTO Shoes (brand, model, color, price, inventory) VALUES ('Adidas', 'Ultra Boost', 'White', 149.99, 30);
INSERT INTO Shoes (brand, model, color, price, inventory) VALUES ('Puma', 'RS-X', 'Red', 89.99, 20);
INSERT INTO Shoes (brand, model, color, price, inventory) VALUES ('Reebok', 'Classic Leather', 'Blue', 79.99, 40);
