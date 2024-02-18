mysql -uroot -pjbdl@gfg


CREATE USER 'user1'@'localhost' IDENTIFIED BY 'Pass@123';
SHOW GRANTS FOR 'user1'@'localhost';

GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'user1'@'localhost' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'user1'@'localhost' WITH GRANT OPTION;

SHOW PROCESSLIST;

show status like '%onn%';

create database demo_system

use demo_system;

show tables;

create table person( id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
phone VARCHAR(50),
PRIMARY KEY ( id ) );

create table product (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50) NOT NULL, cost DOUBLE NOT NULL, PRIMARY KEY ( id ) );

show create table person;

insert into person values(null, 'Ravi', 'ravi@yopmail.com', '999999999');

insert into person values(9, 'Lucky', 'ravi@yopmail.com', '999999999');

insert into person values(null, 'Shubham', 'ravi@yopmail.com', '999999999');

select * from person where id=9;

select * from person where name='Lucky';

CREATE TABLE address (     id int NOT NULL,
line1 VARCHAR(100),
line2 VARCHAR(100),
city VARCHAR(100),     state VARCHAR(100),
country VARCHAR(100),
pincode VARCHAR(10),
PRIMARY KEY (id) );

desc address;

insert into address values (1,'H No 002','Sector 40','Noida','UP','INDIA','221001');


insert into address values (2,'H No 002','Sector 40','Delhi','UP','INDIA','221001');

desc person;

ALTER TABLE person add addressId INT ;

ALTER TABLE person add FOREIGN KEY (addressId) REFERENCES address(id);

update person set addressId=2 where id=1;

select p.name, email, A.city from person p INNER JOIN Address A on p.addressId = A.id;

select name, email, A.city from person p LEFT JOIN Address A on p.addressId = A.id;

select name, email, A.city from person p RIGHT JOIN Address A on p.addressId = A.id;

select name, email from person p;

delete from person where id=10;

CREATE TABLE Address (     id int NOT NULL,     line1 VARCHAR(100),     line2 VARCHAR(100),     city VARCHAR(100),     state VARCHAR(100),     country VARCHAR(100),     pincode VARCHAR(10),     PRIMARY KEY (id) );

CREATE TABLE IF NOT EXISTS address (     id int NOT NULL,     line1 VARCHAR(100),     line2 VARCHAR(100),     city VARCHAR(100),     state VARCHAR(100),     country VARCHAR(100),     pincode VARCHAR(10),     PRIMARY KEY (id) );

ALTER TABLE person add lastLoginTime DATETIME ;

update person set lastLoginTime=now();

CREATE INDEX idx_email ON person (email);

Select name from person where email='ravi@yopmail.com';



