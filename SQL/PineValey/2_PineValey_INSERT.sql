
INSERT INTO CUSTOMER VALUES
(1, 'Contemporary Casuals', '1355 S. Himes Blvd.', 'Gainesville', 'FL', '32601');

/* Error Msg 213, Level 16, State 1, Line 1
Column name or number of supplied values does not match table definition.

*/
INSERT INTO CUSTOMER VALUES
(1, 'Contemporary Casuals', '1355 S. Himes Blvd.', 'Gainesville', 'FL', '32601', 'Commercial');

INSERT INTO CUSTOMER VALUES
(2, 'ABC Inc', '11 Main ST', 'Boston', 'MA', '02771', 'Commercial');

INSERT INTO CUSTOMER VALUES
(3, 'XYZ Inc', '16 John Ave', 'Boston', 'MA', '02771', 'Commercial');



INSERT INTO [Product] ([ProductID]
           ,[ProductDescription]
           ,[ProductFinish]
           ,[ProductStandardPrice]
           ,[ProductLineID])
     VALUES
           ( 1, 'End Table','Cherry', 175,8 );
-------------------------------------
 INSERT INTO [Product] ([ProductID]
           ,[ProductDescription]
           ,[ProductFinish]
           ,[ProductStandardPrice]
           ,[ProductLineID])
     VALUES
           ( 2, 'King Chair', 'Natural Oak', 400, 8 );

INSERT INTO [Product] 
     VALUES
           ( 3, 'Big Table', 'Natural Oak', 330, 8 );

		  
		  

-- Identity columns
--Show createion of table with identity 

-- show select and other clauses with data from the class.

--Show them how to attach

SELECT*
FROM Product
