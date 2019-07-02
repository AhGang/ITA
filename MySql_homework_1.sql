Create database student_examination_sys;
use student_examination_sys;
Create Table student (
id int primary key,
name varchar(20),
age int,
sex varchar(10)
);
insert into student
(id,name,age,sex)
values
(001,"张三",18,"男"),
(002,"李四",20,"女");
select * from student;

Create Table subject (

id int primary key,
subject varchar(20),
teacher varchar(20),
description varchar(20)
);
insert into subject
(id,subject,teacher,description)
values
(1001,"语文","王老师","本次考试比较简单"),
(1002,"数学","刘老师","本次考试比较难");
select * from subject;

Create Table score (

id int primary key,
student_id int,
subject_id int,
score double
);
insert into score
(id,student_id,subject_id,score)
values
(1,001,1001,80),
(2,002,1002,60),
(3,001,1001,70),
(4,002,1002,60.5);
select * from score;

