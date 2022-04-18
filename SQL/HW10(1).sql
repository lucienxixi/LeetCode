CREATE PROCEDURE GetEmployeeInfo @dept_no CHAR(4) AS
BEGIN
    SELECT e.emp_no, e.emp_fname + ' ' + e.emp_lname AS employee_full_name, dept_name AS department_name
    FROM employee e
	JOIN department d ON e.dept_no = d.dept_no
	WHERE d.dept_no = @dept_no 
END

declare @dept_no CHAR(4)
EXEC GetEmployeeInfo 'D1'


