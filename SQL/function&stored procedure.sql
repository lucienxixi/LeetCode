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
