-- DDL

CREATE DATABASE INFO6210new
-- If want drop database, do it in the master window, do not in current database window
DROP DATABASE INFO6210new 
GO
USE INFO6210new
GO

CREATE TABLE Customer
(
CustomerID int not null,
CustomerName nvarchar(25),
CustomerAddress varchar(20),
CustomerCity varchar(20),
CustomerState char(2),
CustomerPostalCode varchar(9)
CONSTRAINT Customer_PK primary key (CustomerID)
);

CREATE TABLE [Order]
(
OrderID INT NOT NULL,
OrderDate DATETIME DEFAULT(GETDATE()),
CustomerID INT NOT NULL
CONSTRAINT Order_PK PRIMARY KEY (OrderID)
CONSTRAINT Order_FK FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID)
);

CREATE TABLE Product
(
ProductID INT NOT NULL,
ProductDescription VARCHAR(50),
ProductFinish VARCHAR(20) CONSTRAINT ProductFinish_CHK CHECK(ProductFinish IN ('Cherry', 'Natural Ash', 'White Ash', 'Red Oak', 'Natural Oak', 'Walnut')),
ProductStandardPrice DECIMAL(6,2),
ProductLineID INT
CONSTRAINT Product_PK PRIMARY KEY(ProductID)
);

CREATE TABLE OrderLine
(
OrderID INT NOT NULL,
ProductID INT NOT NULL,  
OrderQuantity SMALLINT
CONSTRAINT OrderLine_PK PRIMARY KEY(OrderID, ProductID)
CONSTRAINT OrderLine_FK1 FOREIGN KEY(OrderID) REFERENCES [ORDER] (OrderID),
CONSTRAINT OrderLine_FK2 FOREIGN KEY(ProductID) REFERENCES Product (ProductID)
);

-- add new column
ALTER TABLE Customer ADD CustomerType VARCHAR(2)

-- change datatype of a column
ALTER TABLE Customer ALTER COLUMN CustomerType VARCHAR(20)

-- one way to change datatype to default for a column: drop column first and re-add new column(this method also do well in rename a column)
ALTER TABLE Customer DROP COLUMN CustomerType

ALTER TABLE Customer ADD CustomerType VARCHAR(20) DEFAULT('Commercial')




DROP TABLE OrderLine
DROP TABLE Product
DROP TABLE [Order]
DROP TABLE Customer


