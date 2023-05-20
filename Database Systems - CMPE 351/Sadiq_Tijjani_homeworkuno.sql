CREATE DATABASE mall;

CREATE TABLE customer(
    customer_id INT NOT NULL,
    customer_name VARCHAR(15),
    customer_lastname VARCHAR(15),
    customer_registration_date DATE,
    PRIMARY KEY (customer_id)
);

--I choose customer_id as Primary Key therefore it will be represented in a child column in purchase table.

CREATE TABLE inventory(
    item_id INT NOT NULL,
    item_name VARCHAR(20),
    item_cost INT,
    PRIMARY KEY (item_id)
);

--I choose item_id as Primary Key therefore it will be represented in a child column in purchase table.

CREATE TABLE purchase(
    customer_id INT,
    item_id INT,
    purchase_cost INT,--Purchase Cost because it only makes sense to pair item and price.
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY(item_id) REFERENCES inventory(item_id)
);




INSERT INTO customer VALUE(1330, "Oluwa", "Shola", "2020-07-08");
INSERT INTO customer VALUE(1331, "Sadiq", "Tijjani", "2020-06-17");
INSERT INTO customer VALUE(1332, "James", "Bethesda", "20120-08-22");
INSERT INTO customer VALUE(1333, "Emmanuel", "Macron", "2020-10-20");
INSERT INTO customer VALUE(1334, "Don", "Corleone", "2020-01-19");

INSERT INTO inventory VALUE(1000, "T-shirt", 30);
INSERT INTO inventory VALUE(2000, "Lollipop", 10);
INSERT INTO inventory VALUE(3000, "Juice", 16);
INSERT INTO inventory VALUE(4000, "Cap", 20);
INSERT INTO inventory VALUE(5000, "Perfume", 100);

INSERT INTO purchase VALUE(1330, 1000, 30);
INSERT INTO purchase VALUE(1331, 2000, 10);
INSERT INTO purchase VALUE(1332, 3000, 16);
INSERT INTO purchase VALUE(1333, 2000, 20);
INSERT INTO purchase VALUE(1334, 5000, 100);

--Fucntion that shows the id of customers who bought second item in inventory
SELECT customer_id FROM purchase WHERE item_id=3000;

--Fuction that does the adding of score attribute to Customer table
ALTER TABLE
 customer add score INT;

--Updating the score attribute of Customer table
UPDATE customer SET score = (2020 - SUBSTRING(customer_registration_date,1,5)) * 10;

--Function calculating time lapsed from registration as demonstrated in the HW question
SELECT 2 - SUBSTRING(customer_registration_date,9,2) + 30 * (11 - (SUBSTRING(customer_registration_date,6,2)))
FROM customer 
WHERE SUBSTRING(customer_registration_date,1,5) = 2020;