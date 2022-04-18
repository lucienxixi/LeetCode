CREATE PROCEDURE IncreaseBudgetAmount @project_no CHAR(4), @new_budget FLOAT, @message VARCHAR(50) OUTPUT AS
BEGIN
IF NOT EXISTS 
(
    SELECT 1 
    FROM project p 
    WHERE p.project_no = @project_no 
)
	SET @message ='Invalid Project Number'
ELSE IF EXISTS (
	SELECT 1 
    FROM project p 
    WHERE p.project_no = @project_no AND @new_budget> p.budget
)
	BEGIN
		 UPDATE project SET budget = @new_budget 
         WHERE project_no = @project_no;   
		 SET @message ='budget amount increased'
	END
ELSE IF EXISTS (
	SELECT 1 
    FROM project p 
    WHERE p.project_no = @project_no AND @new_budget<= p.budget
)
	BEGIN
		 SET @message ='New budget must be greater than the current budget'
	END
END


 



DROP PROCEDURE IncreaseBudgetAmount


declare @message varchar(100), @projec_no varchar(4), @new_budget float

set @projec_no ='p2'
set @new_budget =10
exec IncreaseBudgetAmount @projec_no, @new_budget, @message output
print @message

set @projec_no ='p1'
set @new_budget =10
exec IncreaseBudgetAmount @projec_no, @new_budget, @message output
print @message

set @projec_no ='p1'
set @new_budget =40000000
exec IncreaseBudgetAmount @projec_no, @new_budget, @message output
print @message