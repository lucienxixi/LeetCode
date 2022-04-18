-- DML
-- the first way to insert value in column (every column)
INSERT INTO Customer VALUES
(1, 'Contemporary Casuals', '1355 S. Himes Blvd.', 'Gainesville', 'FL', '32601', 'Commerical')
INSERT INTO Customer VALUES
(2, 'ABC Inc', '11 Main ST', 'Boston', 'MA', '02771', 'Commercial');

-- view result 
SELECT *
FROM Customer

-- the second way to insert value in column (specific column)
INSERT INTO Product (ProductID, ProductDescription, ProductFinish, ProductStandardPrice, ProductLineID) VALUES (1, 'End Tabe', 'Cherry', 175, 8);

SELECT *
FROM Product

-- the third way to insert value in column(copy value from one table to anothers)
-- all rows
INSERT INTO [dbo].[CustomerMA]
SELECT *
FROM Customer
-- certain rows
INSERT INTO [dbo].[CustomerMA]
SELECT *
FROM Customer
WHERE CustomerState='MA'

--remove records(values) of all rows in the table
-- DML
DELETE FROM CustomerMA 
-- DDL
TRUNCATE TABLE Customer

--remove records(values) of specific rows in the table
DELETE FROM CustomerMA
WHERE CustomerState='MA' 




DELETE FROM Customer
DELETE FROM CustomerMA
DELETE FROM Product