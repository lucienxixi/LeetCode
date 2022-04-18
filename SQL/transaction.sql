-- 11/30 lecture 

transaction

BEGIN TRANSACTION 
	insert into department ( dept_no, dept_name)
	values ( 'D6', 'Support')

	SAVE TRANSACTION a
	insert into department ( dept_no, dept_name)
	values ( 'D7', 'Research')
	SAVE TRANSACTION b
	insert into department ( dept_no, dept_name)
	values ( 'D8', 'Management')
	ROLLBACK TRANSACTION b
	insert into department ( dept_no, dept_name)
	values ( 'D8', 'Sales')
	ROLLBACK TRANSACTION a

COMMIT TRANSACTION;

select * from department



use sample;
go
--Example showing implementation of transaction
-- both update statements are committed or rolled back together as a single unit
begin transaction 
	update employee
		SET dept_no ='D1'
	WHERE emp_no = 15000;

	update works_on
	SET project_no ='p3'
	Where emp_no =15000
	and project_no ='p1'

if @@ERROR <> 0 
	begin
		print 'Aborted, there is an error'
		ROLLBACK
	end 
	else
		commit; 