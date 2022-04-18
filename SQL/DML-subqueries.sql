-- lecture 11/16 subqueries

-- uncorrelated 
ppt

-- correlated  /* subquery has relationship to outer query that means subquery uses the table from outer query*/
ppt

-- q1
-- using subquery to return the employee fname and lname with at least one project
-- first way (non-correlated)
SELECT e.emp_fname, e.emp_lname
FROM employee e
WHERE e.emp_no IN (SELECT w.emp_no FROM works_on w )
-- second way (correlated)
SELECT e.emp_fname, e.emp_lname
FROM employee e
WHERE EXISTS (SELECT w.emp_no FROM works_on w WHERE w.emp_no = e.emp_no)

-- q2
-- using subquery to return the employee fname and lname with at least two project

INSERT INTO works_on VALUES (15000, 'p2', 'SQL_Developer', '2019-02-01')
-- first way (non-correlated)
SELECT e.emp_fname, e.emp_lname
FROM employee e
WHERE e.emp_no IN (SELECT w.emp_no FROM works_on w GROUP BY w.emp_no HAVING COUNT(*)>=2)
-- second way (correlated)
SELECT e.emp_fname, e.emp_lname
FROM employee e
WHERE EXISTS (SELECT 1 FROM works_on w WHERE e.emp_no = w.emp_no GROUP BY w.emp_no HAVING COUNT(*)>=2) /* anything can follow select because it just return true or false*/

-- q3
--  using subquery to return the employee fname and lname with no project
-- first way (non-correlated)
SELECT e.emp_fname, e.emp_lname
FROM employee e
WHERE e.emp_no NOT IN (SELECT w.emp_no FROM works_on w )
-- second way (correlated)
SELECT e.emp_fname, e.emp_lname
FROM employee e
WHERE NOT EXISTS (SELECT w.emp_no FROM works_on w WHERE w.emp_no = e.emp_no)

-- union 
-- q1
SELECT e.emp_fname, e.emp_lname, 'no works' AS status
FROM employee e
WHERE e.emp_no NOT IN (SELECT w.emp_no FROM works_on w )
UNION
SELECT e.emp_fname, e.emp_lname, 'more than 2 works' AS XXXX /* the column name is from first query, so the alias can be anything even empty in the second*/
FROM employee e
WHERE e.emp_no IN (SELECT w.emp_no FROM works_on w GROUP BY w.emp_no HAVING COUNT(*)>=2)

-- condition
-- example
picture


