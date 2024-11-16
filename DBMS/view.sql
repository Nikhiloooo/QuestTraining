create table Student(
StudentID int primary key,
FirstName varchar(50),
LastName varchar(50),
StudentClass varchar(50),
PhoneNumber varchar(50),
StudentAddress varchar(50));

insert into student(StudentID,FirstName,LastName,StudentClass,PhoneNumber,StudentAddress) values(1,"Anu","Sid","12th","7878656908","Kerala"),
(2,"Manu","Krish","12th","7878966908","Chennai"),
(3,"Eva","Roy","10th","2445756908","US"),
(4,"Mike","George","UG","9999999999","UK"),
(5,"Trisha","David","12th","9887865690","Kerala");

select * from student;

delete from student
where StudentID=2;

delete from student
where LastName="Roy";

update student
set LastName="Dravid",PhoneNumber="9999999999"
where FirstName="Trisha";

create database db1;
use db1;

start transaction;
update student set FirstName="varun" where LastName="Sid";
savepoint s1;
update student set StudentClass="PG" where LastName="Sid";
commit;
rollback to s1;
select * from student;

create view student_view as 
select StudentID,FirstName,LastName 
from Student;

update student_view set FirstName="Robert" where LastName="George";
