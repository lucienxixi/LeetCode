SELECT*
FROM Product

UPDATE Product SET ProductStandardPrice = 200
WHERE ProductID = 1

SELECT*
FROM Product

CREATE TABLE Customer1
(
CustomerID int not null IDENTITY(1,1), /* ? IDENTITY */ 
CustomerName nvarchar(25),
CustomerAddress varchar(20),
CustomerCity varchar(20),
CustomerState char(2),
CustomerPostalCode varchar(9)
CONSTRAINT Customer_PK11 primary key (CustomerID)
);

INSERT INTO Customer1 VALUES
('Contemporary Casuals', '1355 S. Himes Blvd.', 'Gainesville', 'FL', 32601)

INSERT INTO Customer1 VALUES
('ABC Inc', '11 Main ST', 'Boston', 'MA', 02771);

SELECT*
FROM Customer1

CREATE INDEX NAME_IDS ON Customer(CustomerName)



SELECT*
FROM Product
WHERE ProductStandardPrice < 275

-- use alias
SELECT CUST.[CustomerName] AS Name, CUST.[CustomerAddress] AS Address
FROM [Customer] CUST
WHERE CustomerName = 'Contemporary Casuals'

SELECT CUST.CustomerName AS Name, CUST.CustomerAddress AS Address
FROM Customer CUST
WHERE CustomerName = 'Contemporary Casuals'

-- don't use alisa
SELECT CustomerName AS Name, CustomerAddress AS Address
FROM Customer
WHERE CustomerName = 'Contemporary Casuals'


-- boolean 
SELECT *
FROM Customer
WHERE CustomerCity='Boston' AND CustomerState='MA'

SELECT *
FROM dbo.Customer
WHERE CustomerCity='Boston' OR CustomerState='MA'

SELECT *
FROM Customer
WHERE CustomerState='FL' OR CustomerState='MA'

SELECT *
FROM Customer
WHERE CustomerState IN ('MA', 'FL')

SELECT ProductDescription, ProductFinish, ProductStandardPrice
FROM Product
WHERE ProductDescription like '%table%' /* %table, table%*, %table% */

SELECT ProductDescription, ProductFinish, ProductStandardPrice
FROM Product
WHERE ProductDescription like '%desk%' 
    OR ProductDescription like '%table%'
    AND ProductStandardPrice>300


-- ORDER BY
-- First way
SELECT ProductDescription, ProductFinish, ProductStandardPrice
FROM Product
ORDER BY ProductFinish ASC, ProductStandardPrice DESC

--second way (index)
SELECT ProductDescription, ProductFinish, ProductStandardPrice
FROM Product
ORDER BY 2 ASC, 3 DESC

-- aggregate functions
SELECT COUNT(*) FROM Product

SELECT SUM(ProductStandardPrice) FROM Product

SELECT CustomerState, COUNT(*)
FROM Customer
GROUP BY CustomerState

SELECT CustomerState, COUNT(*)
FROM Customer
GROUP BY CustomerState
HAVING COUNT(*)>1