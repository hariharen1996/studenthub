create table if not exists student(
    id int primary key auto_increment,
    name varchar(200),
    address varchar(200),
    cgpa Decimal(3,2),
    rollno int,
    department varchar(100)
)