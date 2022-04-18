CREATE TABLE employee1
(
    emp_no  int IDENTITY(2,1),
    emp_sa  INT,
    dept_no char(2),
    dep_lo char(5)
    CONSTRAINT em_pk PRIMARY KEY (emp_no) 
);

DROP TABLE employee1
TRUNCATE COLUMNS TABLE employee1

INSERT INTO employee1 VALUES 
(999, 'd2', '102'),
(1099, 'd3', '103'),
(1100, 'd4', '105'),
(1005, 'd2', '103'),
(1800, 'd3', '102'),
(900, 'd4', '103'),
(960, 'd2', '102'),
(950, 'd3', '104')

SELECT * FROM employee1

SELECT e.dept_no AS deptNO, AVG(e.emp_sa)AS AVGSA, Count(*) as empcount, e.dep_lo




FROM employee1 e


WHERE e.dep_lo IN ('102','103','105') 
--ORDER BY e.dep_lo DESC

--WHERE e.dept_no IN ('d2','d3')

GROUP BY e.dept_no, e.dep_lo
HAVING avg(e.emp_sa) > 500

ORDER BY avg(e.emp_sa) DESC,  e.dep_lo DESC


CREATE TABLE Person(
[PersonID] [int] NOT NULL,
[FirstName] [varchar](50) NULL,
[LastName] [nchar](50) NULL,
[Height] [decimal](6, 2) NULL,
[Weight] [decimal](6, 2) NULL);
drop table Person
INSERT INTO Person
([PersonID]
,[FirstName]
,[LastName]
,[Height]
,[Weight])
VALUES
(33
,'Krishna'
,'Yashw'
,5.11
,185
)

INSERT INTO Person
([PersonID]
,[FirstName]
,[LastName]
,[Height]
,[Weight])
VALUES
(34
,'Krishna'
,'Yashw'
,5.11
,185
)
SELECT * FROM Person
SELECT sum([Height]) AS TotalHeight
,avg([Weight])
FROM Person
WHERE [Weight] IN 
(SELECT MAX(PersonID) FROM Person )

SELECT FirstName from Person
WHERE Person.FirstName = null
DROP [dbo].[Person] WHERE [Weight]= 33;