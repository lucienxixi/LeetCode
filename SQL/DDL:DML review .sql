-- additional objects for DDL

ppt

-- lectrue 11/9 DML review question

--q1
SELECT *
FROM employee
WHERE dept_no = 'D1'

SELECT e.emp_fname, emp_lname
FROM employee e /* or  FROM employee AS e*/
WHERE dept_no = 'D1'

--q2
SELECT *
FROM employee
WHERE dept_no = 'D1' 
    OR dept_no = 'D2'
-- second method 
SELECT *
FROM employee
WHERE dept_no IN ('D1','D2') 
    
--q3
SELECT *
FROM employee
WHERE (dept_no = 'D1' 
    OR dept_no = 'D2')
    AND emp_no < 15002 /* AND execute first than OR*/

--q4
SELECT *
FROM project
WHERE budget >= 100000

--q4
SELECT *
FROM project
WHERE budget >= 90000 AND budget <= 303750
-- second method
SELECT *
FROM project
WHERE budget BETWEEN 90000 AND 303750  /* inclusive */

--q5
SELECT project_name
FROM project
WHERE budget < 100000 OR budget > 150000
-- second method
SELECT project_name
FROM project
WHERE budget NOT BETWEEN 100000 AND 150000 

--q6
SELECT MIN(budget) AS smallest_b, AVG(budget) AS average_b, MAX(budget) AS largest_b
FROM project 

--q7
SELECT DISTINCT emp_lname  /*show unique records*/
From employee

--q8
SELECT dept_no, COUNT(*) AS count_of_employee
FROM employee
GROUP BY dept_no

--q9
SELECT dept_no, COUNT(*) AS count_of_employee
FROM employee
GROUP BY dept_no
HAVING COUNT(*) >= 3

--q10
SELECT emp_no, project_no
FROM works_on
WHERE project_no = 'p2' AND job IS NULL

--q11
SELECT emp_fname, emp_lname, emp_no
FROM employee
WHERE emp_fname LIKE '_a%' AND emp_lname LIKE '[^KT]%' /* [^A-C]%,[^FG]$ equals to  NOT LIKE */
-- second method
SELECT emp_fname, emp_lname, emp_no
FROM employee
WHERE emp_fname LIKE '_a%' AND emp_lname NOT LIKE '[KT]%'

--q12
SELECT*
FROM department
WHERE [location] LIKE '[C-F]%' 

--q13
SELECT DISTINCT emp_fname, emp_lname
FROM employee
ORDER BY emp_fname ASC, emp_lname DESC

--14
SELECT project_name, budget*6
FROM project
WHERE budget*0.5 > 6000

--15
SELECT emp_fname, DISTINCT emp_no  /* illegal statement! DISTINCT must be first after SELECT*/
FROM employee
WHERE emp_lname= 'Moser'