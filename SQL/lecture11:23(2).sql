/*lecture 11/23 triger */

create trigger deptHistory ON DBO.department
FOR UPDATE
AS
begin
declare @action char(1)
SET @action ='U' -- this means update

INSERT INTO [dbo].[departmentAudit]
           ([dept_no]
           ,[dept_name]
           ,[location]
           ,[Action]
           ,[ActionDate])
   select [dept_no]
           ,[dept_name]
           ,[location]
           ,@action
           ,getdate()
		   FROM deleted
END;

SELECT * FROM department WHERE dept_no ='d2'
UPDATE department SET [location] ='Seattle 3' where  dept_no ='d2'

select * from [dbo].[departmentAudit]




/* TDE Column Level encryption in SQL Server
	Similar to other Database vendors */

Hierarchy
MASTER KEY
	CERTIFICATE
		ENCRYPTION KEYS (SYMMETRIC/ASYMEMETRIC)

use sample
go
--Modify the employee table by adding two columns username and Password columns

alter table employee add Username varchar(50), [Password]  varbinary(400)
/* variable binary  allow use of characters set outside your current character set
   data will be in hexadecimal format
   real security comes from the encryption algorithm used*/

go

--Create a master key for the database. 
create MASTER KEY
ENCRYPTION BY PASSWORD = 'info6210';
-- drop master key 

-- very that master key exists
SELECT name KeyName,
  symmetric_key_id KeyID,
  key_length KeyLength,
  algorithm_desc KeyAlgorithm
FROM sys.symmetric_keys;

go
--Create a self signed certificate and name it EmpPass
CREATE CERTIFICATE EmpPass  
   WITH SUBJECT = 'Employee Sample Password';  
GO  

-- drop CERTIFICATE EmpPass  

--Create a symmetric key  with AES 256 algorithm using the ce





BEGIN transaction t1

INSERT INTO department values ('D6' , 'Marketing', 'San Francisco' )
INSERT INTO department values ('D7' , 'Customer Serv', 'Chicago' ) 

SELECT * FROM department ORDER BY dept_no
ROLLBACK;

SELECT *
FROM department