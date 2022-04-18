-- lecture 11/9 mutiple table SQL - join

-- inner join
SELECT e.emp_fname, e.emp_lname, d.[location]
FROM department d JOIN employee e ON d.dept_no = e.dept_no

SELECT e.emp_fname, e.emp_lname, d.[location]
FROM employee e JOIN department d ON d.dept_no = e.dept_no

/* although the result is same, don't use this way*/
SELECT e.emp_fname, e.emp_lname, d.[location]
FROM employee e, department d
WHERE e.dept_no = d.dept_no 

-- out join
SELECT e.emp_fname, e.emp_lname, w.job, w.project_no
FROM employee e LEFT JOIN works_on w ON e.emp_no = w.emp_no

SELECT e.emp_fname, e.emp_lname, w.job, w.project_no
FROM works_on w RIGHT JOIN employee e ON e.emp_no = w.emp_no /* the same result as left join*/

-- full join 
SELECT e.emp_fname, e.emp_lname, w.job, w.project_no
FROM employee e FULL JOIN works_on w ON e.emp_no = w.emp_no

-- self join for unary relationship


-- lecture 11/16 - review question
--q1
SELECT e.emp_fname, e.emp_lname, p.project_name, p.budget
FROM project p INNER JOIN works_on w ON p.project_no = w.project_no
    INNER JOIN  employee e ON  w.emp_no = e.emp_no
WHERE p.budget > 140000  /* 'inner' is optional */

--q2    
SELECT e.emp_fname, e.emp_lname, p.project_name, p.budget, d.dept_no
FROM project p  RIGHT JOIN works_on w ON p.project_no = w.project_no
    RIGHT JOIN  employee e ON  w.emp_no = e.emp_no /* left join can also do this, juest exchnge the table */
    LEFT JOIN department d ON d.dept_no = e.dept_no 
WHERE e.dept_no = 'D2'

--q3
SELECT e.emp_fname, e.emp_lname, sum(p.budget) AS total_budget
FROM project p  RIGHT JOIN works_on w ON p.project_no = w.project_no
    RIGHT JOIN  employee e ON  w.emp_no = e.emp_no
GROUP BY e.emp_fname, e.emp_lname

--q3
SELECT e.emp_fname, e.emp_lname, sum(p.budget) AS total_budget /* if implement GROUP BY, all the select column should be aggregated: from GROUP BY or from Math function */
FROM project p  RIGHT JOIN works_on w ON p.project_no = w.project_no
    RIGHT JOIN  employee e ON  w.emp_no = e.emp_no
GROUP BY e.emp_fname, e.emp_lname  

SELECT e.emp_fname, e.emp_lname, sum(p.budget) AS individual_total_budget,
(SELECT sum(p.budget)
    FROM project p  RIGHT JOIN works_on w ON p.project_no = w.project_no
        RIGHT JOIN  employee e ON  w.emp_no = e.emp_no) AS total_budget  /* subquery*/
FROM project p  RIGHT JOIN works_on w ON p.project_no = w.project_no
    RIGHT JOIN  employee e ON  w.emp_no = e.emp_no
GROUP BY e.emp_fname, e.emp_lname  