-- lecture 11/16
-- stored procedures
-- change dept_no
CREATE PROCEDURE ChangeEmployeeDeptNo @emp_no INT, @new_dept_no VARCHAR(5) AS
BEGIN
    UPDATE employee SET dept_no = @new_dept_no  /* UPDATE */
    WHERE emp_no = @emp_no
END

EXEC ChangeEmployeeDeptNo 15000, 'D2'

SELECT * FROM employee

-- max emp_no
CREATE PROCEDURE GetLastEmployeeNo AS
DECLARE @Max_emp_no INT
BEGIN
    SELECT @Max_emp_no = max(emp_no) FROM employee

    SELECT e.emp_fname, e.emp_lname, e.dept_no
    FROM employee e
    WHERE emp_no = @Max_emp_no
END

EXEC GetLastEmployeeNo


-- lecture 11/23 review procedure and function

ALTER PROCEDURE GetLastEmployeeNo @LargestEmpNo int OUTPUT AS
DECLARE @MaxEmpNo int
BEGIN 
 
  SELECT @MaxEmpNo = MAX(emp_no) FROM employee;
 
  SELECT emp_fname, emp_lname, dept_no 
  FROM employee
  WHERE emp_no =@MaxEmpNo

 SET @LargestEmpNo = @MaxEmpNo
END


declare @LastEmployee int
EXEC GetLastEmployeeNo  @LargestEmpNo=@LastEmployee  OUTPUT
SELECT @LastEmployee
PRINT 'The largest emp_no is ' + cast(@LastEmployee as varchar)







ALTER PROCEDURE GetLastEmployee @LargestEmpNo int OUTPUT, @SmallestEmpNo int OUTPUT  AS
DECLARE @MaxEmpNo int, @MinEmpNo int
BEGIN 
 
  SELECT @MaxEmpNo = MAX(emp_no), @MinEmpNo = min(emp_no) FROM employee;
 
  SELECT emp_fname, emp_lname, dept_no , 'Largest Emp No' as Employee_Status
  FROM employee
  WHERE emp_no =@MaxEmpNo

   SELECT emp_fname, emp_lname, dept_no , 'Smallest Emp No' as Employee_Status
  FROM employee
  WHERE emp_no =@MinEmpNo

 SET @LargestEmpNo = @MaxEmpNo
 SET @SmallestEmpNo = @MinEmpNo
END;
 

declare @LastEmployee int, @FirstEmployee INT

EXEC GetLastEmployee  @LargestEmpNo=@LastEmployee  OUTPUT,  @SmallestEmpNo=@FirstEmployee OUTPUT

SELECT @LastEmployee AS LargestEmployee, @FirstEmployee AS SmallestEmployee
PRINT 'The largest emp_no is ' + cast(@LastEmployee as varchar)






CREATE FUNCTION AmazingSum  ( @a int, @b int) RETURNS int AS
begin
declare @c int

    SET @c = @a+ @b

	RETURN @c
end

select dbo.AmazingSum (9,3)






CREATE FUNCTION GetEmployeeName ( @emp_no int ) RETURNS varchar(200)
AS
BEGIN

DECLARE @emp_name varchar(200)

SELECT @emp_name = e.emp_fname + ' ' + e.emp_lname FROM dbo.employee e
WHERE e.emp_no =@emp_no

	RETURN @emp_name
END;


SELECT dbo.GetEmployeeName(e.emp_no) as FullName,e.emp_no
from employee e

SELECT dbo.GetEmployeeName(15000)


