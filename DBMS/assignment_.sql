
--1)library management

CREATE TABLE Authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author_id INT,
    publication_year YEAR,
    price DECIMAL(10, 2),
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);

CREATE TABLE Borrowers (
    borrower_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    dob DATE
);

CREATE TABLE Loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    borrower_id INT,
    book_id INT,
    loan_date DATE,
    return_date DATE,
    FOREIGN KEY (borrower_id) REFERENCES Borrowers(borrower_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

INSERT INTO Authors (first_name, last_name) VALUES
('Leo', 'Tolstoy'),
('Virginia', 'Woolf'),
('Mark', 'Twain'),
('Mary', 'Shelley'),
('Charles', 'Dickens');


INSERT INTO Books (title, author_id, publication_year, price) VALUES
('The Great Gatsby', 1, 1925, 20.00),
('Moby Dick', 2, 1901, 15.00),
('Harry Potter and the Sorcerer''s Stone', 3, 1997, 30.00),
('1984', 4, 1949, 18.00),
('Pride and Prejudice', 5, 1902, 22.00);


INSERT INTO Borrowers (first_name, last_name, email, dob) VALUES
('Nikhil', 'Mohan', 'nikhil@gmail.com', '1985-07-14'),
('Bibin', 'Mohan', 'bibin@gmail.com', '1990-04-23'),
('Sanjay', 'sanju', 'sanju@gmail.com', '2002-10-12'),
('Aswin', 'Kumar', 'aswin@gmail.com', '1992-03-05'),
('Athul', 'Krishna', 'athul@gmail.com', '1980-11-29');


INSERT INTO Loans (borrower_id, book_id, loan_date, return_date) VALUES
(1, 1, '2024-01-10', '2024-02-10'),
(2, 3, '2024-01-15', '2024-02-15'),
(3, 4, '2023-12-20', '2024-01-20'),
(4, 5, '2024-02-05', '2024-03-05'),
(5, 2, '2024-02-20', '2024-03-20');


SELECT * from Books;

SELECT title, price, publication_year FROM Books WHERE price > 20;

SELECT first_name, last_name, email
FROM Borrowers
WHERE borrower_id IN (
    SELECT borrower_id
    FROM Loans
    WHERE loan_date > '2024-01-01'
);


UPDATE Books SET price = 25.00 WHERE title = 'The Great Gatsby';

DELETE FROM Loans WHERE book_id = (SELECT book_id FROM Books WHERE title = "moby dick");

DELETE FROM Books WHERE title = 'Moby Dick';

ALTER TABLE Books ADD COLUMN genre VARCHAR(50);


SELECT COUNT(1)  FROM Borrowers;

SELECT SUM(price)  FROM Books;

SELECT AVG(price)  FROM Books;


SELECT title FROM Books 
WHERE book_id IN (
                 SELECT book_id 
                  FROM Loans 
                   WHERE borrower_id IN (
                               SELECT borrower_id 
                                FROM Borrowers 
                                WHERE TIMESTAMPDIFF(YEAR, dob, CURDATE()) > 30
                                        )
				);


SELECT * from Books;






--2)Hotel management

use hotel_reservation_system;

CREATE TABLE Customers(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(100) UNIQUE,
phone_number VARCHAR(15),
address VARCHAR(100));

CREATE TABLE Rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_type VARCHAR(10) CHECK (room_type IN ('single', 'double', 'suite')),
    price_per_night DECIMAL(10, 2),
    status VARCHAR(20) CHECK (status IN ('available', 'occupied', 'under maintenance')),
    floor_number INT
);


CREATE TABLE Reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    room_id INT,
    reservation_date DATE,
    check_in_date DATE,
    check_out_date DATE,
    status VARCHAR(20) CHECK (status IN ('confirmed', 'cancelled', 'completed')),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id) ON DELETE SET NULL
);

CREATE TABLE Payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    reservation_id INT,
    payment_date DATE,
    amount_paid DECIMAL(10, 2),
    payment_method VARCHAR(20) CHECK (payment_method IN ('credit card', 'cash')),
    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id) ON DELETE CASCADE
);

CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    role VARCHAR(20) CHECK (role IN ('receptionist', 'manager', 'housekeeper')),
    hire_date DATE
);

CREATE TABLE Room_Assignments (
    assignment_id INT PRIMARY KEY AUTO_INCREMENT,
    staff_id INT,
    room_id INT,
    assignment_date DATE,
    task_description VARCHAR(50),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);



INSERT INTO Customers (first_name, last_name, email, phone_number, address) VALUES
('Amit', 'Sharma', 'amit.sharma@gmail.com', '9876543210', 'MG Road, Bangalore'),
('Priya', 'Singh', 'priya.singh@gmail.com', '9123456789', 'Sector 18, Noida'),
('Rahul', 'Patel', 'rahul.patel@gmail.com', '9988776655', 'Park Street, Kolkata'),
('Sneha', 'Reddy', 'sneha.reddy@gmail.com', '9876512340', 'Banjara Hills, Hyderabad'),
('Anil', 'Kumar', 'anil.kumar@gmail.com', '9765432109', 'Anna Salai, Chennai');

INSERT INTO Rooms (room_type, price_per_night, status, floor_number) VALUES
('single', 2000.00, 'available', 1),
('double', 3000.00, 'occupied', 2),
('suite', 5000.00, 'available', 3),
('single', 1800.00, 'under maintenance', 1),
('double', 3500.00, 'available', 2);


INSERT INTO Reservations (customer_id, room_id, reservation_date, check_in_date, check_out_date, status) VALUES
(1, 2, '2024-11-10', '2024-11-15', '2024-11-20', 'confirmed'),
(2, 3, '2024-11-12', '2024-11-18', '2024-11-22', 'completed'),
(3, 1, '2024-11-14', '2024-11-16', '2024-11-18', 'cancelled'),
(4, 5, '2024-11-16', '2024-11-20', '2024-11-25', 'confirmed'),
(5, 4, '2024-11-18', '2024-11-21', '2024-11-26', 'confirmed');


INSERT INTO Payments (reservation_id, payment_date, amount_paid, payment_method) VALUES
(1, '2024-11-10', 10000.00, 'credit card'),
(2, '2024-11-12', 15000.00, 'cash'),
(3, '2024-11-14', 5000.00, 'credit card'),
(4, '2024-11-16', 12000.00, 'cash'),
(5, '2024-11-18', 14000.00, 'credit card');

INSERT INTO Staff (first_name, last_name, role, hire_date) VALUES
('Ravi', 'Kumar', 'receptionist', '2023-02-15'),
('Meera', 'Patel', 'manager', '2022-08-01'),
('Sunil', 'Verma', 'housekeeper', '2021-12-10'),
('Anita', 'Sharma', 'housekeeper', '2023-05-23'),
('Vikram', 'Singh', 'receptionist', '2023-09-15');

INSERT INTO Room_Assignments (staff_id, room_id, assignment_date, task_description) VALUES
(1, 2, '2024-11-10', 'Front desk assistance for check-in'),
(3, 1, '2024-11-11', 'Room cleaning'),
(4, 5, '2024-11-12', 'Room maintenance check'),
(2, 3, '2024-11-13', 'Manager supervision for VIP guest'),
(5, 4, '2024-11-14', 'Front desk check-out assistance');

-- 1 . Retrieve all information about rooms available on a specific floor.

SELECT 
    Rooms.*
FROM Rooms
LEFT JOIN Reservations ON Rooms.room_id = Reservations.room_id
WHERE 
    Rooms.status = 'available'
    AND Rooms.floor_number = 2
    AND (Reservations.room_id IS NULL OR Reservations.status != 'confirmed');
    
    

-- 2. List all reservations with customer details (first name, last name, email) sorted by check-in date (earliest first).

SELECT Reservations.reservation_id, Customers.first_name, Customers.last_name, Customers.email, Reservations.check_in_date
FROM Reservations
JOIN Customers ON Reservations.customer_id = Customers.customer_id
ORDER BY Reservations.check_in_date ASC;


--  3.Find all customers who have reserved rooms for more than 5 nights.

SELECT Customers.first_name, Customers.last_name, Reservations.check_in_date, Reservations.check_out_date
FROM Reservations
JOIN Customers ON Reservations.customer_id = Customers.customer_id
WHERE DATEDIFF(Reservations.check_out_date, Reservations.check_in_date) > 5;



-- 4. Get the total amount paid for each reservation

SELECT reservation_id, SUM(amount_paid) AS total_amount
FROM Payments
GROUP BY reservation_id;



-- 5.Find the average room price for each room type.

SELECT room_type, AVG(price_per_night) AS avg_price
FROM Rooms
GROUP BY room_type;


-- 6.Display the total revenue generated from all reservations in the last month. 

SELECT 
    SUM(Payments .amount_paid) AS total_revenue
FROM 
    Payments 
JOIN 
    Reservations ON Payments .reservation_id = Reservations.reservation_id
WHERE 
    Reservations.reservation_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);


-- 7.Find the staff members who have been assigned the most rooms for cleaning or maintenance in the last month. 

SELECT Staff.first_name,Staff.last_name,COUNT( Room_Assignments.assignment_id) AS assignment_count
FROM    Staff
JOIN     Room_Assignments  
ON Staff.staff_id=rRom_Assignments.staff_id
WHERE  Room_Assignments.assignment_date>= DATE_SUB(CURDATE(),INTERVAL 1 MONTH)
GROUP BY  Staff.staff_id
ORDER BY assignment_count DESC;


-- 8.Retrieve the most recent reservation for each customer.

SELECT Customers.first_name,Customers.last_name,MAX(Reservations.reservation_date) AS recent_reservation
FROM Reservations
JOIN Customers
ON Reservations.customer_id=Customers.customer_id
GROUP BY Customers.customer_id;

-- 9. .Delete a reservation and all corresponding payment records.
DELETE FROM Reservations
WHERE reservation_id=1;


-- 10. Room Availability Check: Create a query that checks which rooms are available for a given date range (i.e., not reserved for those dates).

SELECT r.*
FROM Rooms r
LEFT JOIN Reservations res ON r.room_id = res.room_id 
    AND (res.check_in_date <= '2024-12-05' AND res.check_out_date >= '2024-12-01')
WHERE r.status = 'available'
  AND res.reservation_id IS NULL;


--3)student_management_system

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



--4)schema- quest_schema 

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100),
    Phone VARCHAR(15),
    Address VARCHAR(255)
);
 
CREATE TABLE Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Price DECIMAL(10, 2),
    StockQuantity INT
);
 
CREATE TABLE Customer_Order (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);
 
CREATE TABLE Order_Item (
    OrderItemID INT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    PriceAtPurchase DECIMAL(10, 2),
    FOREIGN KEY (OrderID) REFERENCES Customer_Order(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

insert into Product(ProductID,ProductName,Price,StockQuantity) values(1,"Bag",200,5),(2,"Book",50,25),(3,"Mat",100,12),(4,"Ball",1500,8),(5,"Bag",200,5),(6,"Umbrella",250,30);
select * from product where(select ProductId from Order_Item where Quantity>10);




--5)C2514_DB


CREATE TABLE Customers (
    customer_id INT PRIMARY KEY  AUTO_INCREMENT,
   first_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR(10),
    phone_number VARCHAR(15)
);

CREATE TABLE Products(
   product_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
price DECIMAL(10, 2),
coffee_origin VARCHAR(50));


CREATE TABLE Orders(
order_id INT PRIMARY KEY AUTO_INCREMENT,
   product_id INT  ,
   customer_id INT,
   order_time DATETIME,
   FOREIGN KEY (customer_id ) REFERENCES Customers(customer_id),
   FOREIGN KEY (product_id) REFERENCES Products(product_id)
 );
drop table Orders;
INSERT INTO customers (first_name, last_name, gender, phone_number) VALUES ('Chris','Martin','M','01123147789'),
('Emma','Law','F','01123439899'),('Mark','Watkins','M','01174592013'),('Daniel','Williams','M',NULL),
('Sarah','Taylor','F','01176348290'),('Katie','Armstrong','F','01145787353'),('Michael','Bluth','M','01980289282'),
('Kat','Nash','F','01176987789'),('Buster','Bluth','M','01173456782'),('Charlie',NULL,'F','01139287883'),
('Lindsay','Bluth','F','01176923804'),('Harry','Johnson','M',NULL),('John','Smith','M','01174987221'),
('John','Taylor','M',NULL),('Emma','Smith','F','01176984116'),('Gob','Bluth','M','01176985498'),
('George','Bluth','M','01176984303'),('Lucille','Bluth','F','01198773214'),('George','Evans','M','01174502933'),
('Emily','Simmonds','F','01899284352'),('John','Smith','M','01144473330'),('Jennifer',NULL,'F',NULL),
('Toby','West','M','01176009822'),('Paul','Edmonds','M','01966947113');


INSERT INTO Products(name, price, coffee_origin)
VALUES 
    ('espresso', 2.50, 'brazil'), 
    ('macchiatto', 3.00, 'brazil'),
    ('cappuccino', 3.50, 'costa rica'),
    ('latte', 3.50, 'indonesia'),
    ('americano', 3.00, 'brazil'),
    ('flatwhite', 3.50, 'indonesia'),
    ('filter', 3.00, 'india'),
    ('affogato', 2.70, 'Italy'), 
    ('Frappe', 3.50, 'Greece');


INSERT INTO Orders (product_id,customer_id,order_time) VALUES (1,1,'2017-01-01 08-02-11'),(1,2,'2017-01-01 08-05-16'),
(5,12,'2017-01-01 08-44-34'),(3,4,'2017-01-01 09-20-02'),
(1,9,'2017-01-01 11-51-56'),(6,22,'2017-01-01 13-07-10'),(1,1,'2017-01-02 08-03-41'),
(3,10,'2017-01-02 09-15-22'),(2,2,'2017-01-02 10-10-10'),(3,13,'2017-01-02 12-07-23'),(1,1,'2017-01-03 08-13-50'),
(7,16,'2017-01-03 08-47-09'),(6,21,'2017-01-03 09-12-11'),(5,22,'2017-01-03 11-05-33'),(4,3,'2017-01-03 11-08-55'),
(3,11,'2017-01-03 12-02-14'),(2,23,'2017-01-03 13-41-22'),(1,1,'2017-01-04 08-08-56'),(3,10,'2017-01-04 11-23-43'),
(4,12,'2017-01-05 08-30-09'),(7,1,'2017-01-06 09-02-47'),(3,18,'2017-01-06 13-23-34'),(2,16,'2017-01-07 09-12-39'),
(2,14,'2017-01-07 11-24-15'),(4,5,'2017-01-08 08-54-11'),(1,1,'2017-01-09 08-03-11'),(6,20,'2017-01-10 10-34-12'),
(3,3,'2017-01-10 11-02-11'),(4,24,'2017-01-11 08-39-11'),(4,8,'2017-01-12 13-20-13'),(1,1,'2017-01-14 08-27-10'),
(4,15,'2017-01-15 08-30-56'),(1,7,'2017-01-16 10-02-11'),(2,10,'2017-01-17 09-50-05'),(1,1,'2017-01-18 08-22-55'),
(3,9,'2017-01-19 09-00-19'),(7,11,'2017-01-19 11-33-00'),(6,12,'2017-01-20 08-02-21'),(3,14,'2017-01-21 09-45-50'),
(5,2,'2017-01-22 10-10-34'),(6,24,'2017-01-23 08-32-19'),(6,22,'2017-01-23 08-45-12'),(6,17,'2017-01-23 12-45-30'),
(2,11,'2017-01-24 08-01-27'),(1,1,'2017-01-25 08-05-13'),(6,11,'2017-01-26 10-49-10'),(7,3,'2017-01-27 09-23-57'),
(7,1,'2017-01-27 10-08-16'),(3,18,'2017-01-27 10-13-09'),(4,19,'2017-01-27 11-02-40'),(3,10,'2017-01-28 08-03-21'),
(1,2,'2017-01-28 08-33-28'),(1,12,'2017-01-28 11-55-33'),(1,13,'2017-01-29 09-10-17'),(6,6,'2017-01-30 10-07-13'),
(1,1,'2017-02-01 08-10-14'),(2,14,'2017-02-02 10-02-11'),(7,10,'2017-02-02 09-43-17'),(7,20,'2017-02-03 08-33-49'),
(4,21,'2017-02-04 09-31-01'),(5,22,'2017-02-05 09-07-10'),(3,23,'2017-02-06 08-15-10'),(2,24,'2017-02-07 08-27-26'),
(1,1,'2017-02-07 08-45-10'),(6,11,'2017-02-08 10-37-10'),(3,13,'2017-02-09 08-58-18'),(3,14,'2017-02-10 09-12-40'),
(5,4,'2017-02-10 11-05-34'),(1,2,'2017-02-11 08-00-38'),(3,8,'2017-02-12 08-08-08'),(7,20,'2017-02-12 09-22-10'),
(1,1,'2017-02-13 08-37-45'),(5,2,'2017-02-13 12-34-56'),(4,3,'2017-02-14 08-22-43'),(5,4,'2017-02-14 09-12-56'),
(3,5,'2017-02-15 08-09-10'),(6,7,'2017-02-15 09-05-12'),(1,8,'2017-02-15 09-27-50'),(2,9,'2017-02-16 08-51-12'),
(3,10,'2017-02-16 13-07-46'),(4,11,'2017-02-17 08-03-55'),(4,12,'2017-02-17 09-12-11'),(5,10,'2017-02-17 11-41-17'),
(6,18,'2017-02-17 13-05-56'),(7,19,'2017-02-18 08-33-27'),(1,17,'2017-02-19 08-12-31'),(1,1,'2017-02-20 09-50-17'),
(3,5,'2017-02-20 09-51-29'),(4,6,'2017-02-20 10-43-39'),(3,1,'2017-02-21 08-32-17'),(1,1,'2017-02-21 10-30-11'),
(3,2,'2017-02-21 11-08-45'),(4,3,'2017-02-22 11-46-32'),(2,15,'2017-02-22 13-35-16'),(6,13,'2017-02-23 08-34-48'),
(4,24,'2017-02-24 08-32-03'),(2,13,'2017-02-25 08-03-12'),(7,17,'2017-02-25 09-34-23'),(7,23,'2017-02-25 11-32-54'),
(5,12,'2017-02-26 11-47-34'),(6,4,'2017-02-27 12-12-34'),(1,1,'2017-02-28 08-59-22');



select * from Orders;

select * from  Customers;

select * from Products;


-- 4. From the customers table, select the first name and phone number of all the females who have a last name of Bluth.
SELECT first_name,phone_number 
FROM Customers
WHERE   gender='F' and  last_name='Bluth';

-- 5. How many male customers don't have a phone number entered into the customers table?
SELECT COUNT(*)
 FROM Customers
 WHERE    gender='M'  AND  phone_number IS NULL;
 
 
-- 8. From the products table, display the names of the products having origin from ‘India’ or ‘indonesia’.
   SELECT name 
   FROM  Products
   WHERE  coffee_origin ='India'  OR coffee_origin= 'indonesia';
   
   
-- 9. Display names and order time of the customers who have ordered ‘cappucino’.
 SELECT c.first_name, c.last_name, o.order_time 
FROM Customers c 
JOIN Orders o ON c.customer_id = o.customer_id
JOIN Products p ON p.product_id = o.product_id
WHERE p.name = 'cappuccino';


-- 10. Display names of all the customers with the names of the products they have ordered.
SELECT c.first_name, c.last_name, p.name AS product_name
FROM Customers c
JOIN Orders o ON o.customer_id = c.customer_id
JOIN Products p ON p.product_id = o.product_id;








--6)Normalization

 -- 1. Convert the following table into 1NF:
     --  - Table: Orders
      --    - Columns: `OrderID`, `CustomerName`, `ProductNames` (where `ProductNames` might contain multiple product names separated by commas).

CREATE TABLE Orders (
    OrderID INT,
    CustomerName VARCHAR(50),
    ProductNames VARCHAR(100)  -- Multiple products in one column
);

INSERT INTO Orders (OrderID, CustomerName, ProductNames) VALUES 
    (1, 'John Doe', 'Coffee,Tea,Pastry'),
    (2, 'Jane Smith', 'Sandwich,Juice');
    
    select * from Orders;

CREATE TABLE Orders_1NF (
    OrderID INT,
    CustomerName VARCHAR(50),
    ProductName VARCHAR(50)
);

INSERT INTO Orders_1NF (OrderID, CustomerName, ProductName) VALUES 
    (1, 'John Doe', 'Coffee'),
    (1, 'John Doe', 'Tea'),
    (1, 'John Doe', 'Pastry'),
    (2, 'Jane Smith', 'Sandwich'),
    (2, 'Jane Smith', 'Juice');


 select * from Orders_1NF;


--  2. Normalize the following table to 2NF:
      -- - Table: Student_Courses
         -- - Columns: `StudentID`, `StudentName`, `CourseID`, `CourseName`, `InstructorID`, `InstructorName`


CREATE TABLE Student_Courses (
    StudentID INT,
    StudentName VARCHAR(50),
    CourseID INT,
    CourseName VARCHAR(50),
    InstructorID INT,
    InstructorName VARCHAR(50)
);



INSERT INTO Student_Courses (StudentID, StudentName, CourseID, CourseName, InstructorID, InstructorName) VALUES
    (1, 'Alice', 101, 'Math', 201, 'Mr. Smith'),
    (2, 'Bob', 102, 'Science', 202, 'Ms. Johnson');

select * from Student_Courses;

CREATE TABLE Students_2NF (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50)
);

CREATE TABLE Courses_2NF (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(50),
     InstructorID INT,
     FOREIGN KEY ( InstructorID)  REFERENCES  Instructors_2NF( InstructorID));


CREATE TABLE Instructors_2NF (
    InstructorID INT PRIMARY KEY,
    InstructorName VARCHAR(50)
);

CREATE TABLE Student_Courses_2NF (
    StudentID INT,
    CourseID INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Students_2NF(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses_2NF(CourseID)
   
);

-- Insert data
INSERT INTO Students_2NF (StudentID, StudentName) VALUES (1, 'Alice'), (2, 'Bob');
INSERT INTO Instructors_2NF(InstructorID, InstructorName) VALUES (201, 'Mr. Smith'), (202, 'Ms. Johnson');
INSERT INTO Courses_2NF (CourseID, CourseName,InstructorID) VALUES (101, 'Math',201), (102, 'Science',202);
INSERT INTO Student_Courses_2NF (StudentID, CourseID)
 VALUES (1, 101), (2, 102);


select * from Students_2NF;
SELECT * FROM Instructors_2NF;
SELECT * FROM Courses_2NF;
select * from Student_Courses_2NF;



--  3. Normalize the following table to 3NF:
      -- - Table: Sales
         -- - Columns: `SalesID`, `ProductID`, `ProductName`, `CategoryID`, `CategoryName`, `SaleDate`

CREATE TABLE Sales_Unnormalized (
    SalesID INT,
    ProductID INT,
    ProductName VARCHAR(50),
    CategoryID INT,
    CategoryName VARCHAR(50),
    SaleDate DATE
);

-- Inserting Unnormalized Data
INSERT INTO Sales_Unnormalized (SalesID, ProductID, ProductName, CategoryID, CategoryName, SaleDate) VALUES
    (1, 1, 'Coffee', 10, 'Beverages', '2024-01-01'),
    (2, 2, 'Sandwich', 20, 'Food', '2024-01-02');
    
    select * from Sales_Unnormalized ;


-- Category Table
CREATE TABLE Categories_3NF (
    CategoryID INT PRIMARY KEY,
    CategoryName VARCHAR(50)
);

-- Product Table
CREATE TABLE Products_3NF (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(50),
    CategoryID INT,
    FOREIGN KEY (CategoryID) REFERENCES Categories_3NF(CategoryID)
);

-- Sales Table
CREATE TABLE Sales_3NF (
    SalesID INT PRIMARY KEY,
    ProductID INT,
    SaleDate DATE,
    FOREIGN KEY (ProductID) REFERENCES Products_3NF(ProductID)
);

-- Inserting Data into Normalized Tables
-- Categories
INSERT INTO Categories_3NF (CategoryID, CategoryName) VALUES (10, 'Beverages'), (20, 'Food');

-- Products
INSERT INTO Products_3NF (ProductID, ProductName, CategoryID) VALUES 
    (1, 'Coffee', 10), 
    (2, 'Sandwich', 20);

-- Sales
INSERT INTO Sales_3NF (SalesID, ProductID, SaleDate) VALUES 
    (1, 1, '2024-01-01'), 
    (2, 2, '2024-01-02');
    
    select * from Categories_3NF ;
    select * from Products_3NF;
    select * from Sales_3NF ;


--7)case_study


-- 1. Write an SQL statement to create a table in 1NF with the following information:
--       - Columns: `BookID`, `Title`, `Authors` (where each book can have multiple authors).

CREATE TABLE Books (
    BookID INT,
    Title VARCHAR(100),
    Authors VARCHAR(255)  -- Multiple authors stored as comma-separated values
);

INSERT INTO Books (BookID, Title, Authors) VALUES
    (1, 'Database Systems', 'John Smith, Alice Johnson'),
    (2, 'Introduction to SQL', 'James Brown');

select * from Books;

CREATE TABLE Books_1NF (
    BookID INT,
    Title VARCHAR(100),
    Author VARCHAR(100)  -- Each row now contains only one author
);

INSERT INTO Books_1NF (BookID, Title, Author) VALUES
    (1, 'Database Systems', 'John Smith'),
    (1, 'Database Systems', 'Alice Johnson'),
    (2, 'Introduction to SQL', 'James Brown');

select * from Books_1NF;

 -- 2. Given a 2NF table with columns `OrderID`, `ProductID`, `ProductName`, and `SupplierName`, write the SQL commands to normalize this table to 3NF.

CREATE TABLE Orders (
    OrderID INT,
    ProductID INT,
    ProductName VARCHAR(100),
    SupplierName VARCHAR(100)
);

INSERT INTO Orders(OrderID, ProductID, ProductName, SupplierName) VALUES
    (1, 101, 'Laptop', 'TechSupplier'),
    (2, 102, 'Keyboard', 'KeyCo'),
    (3, 101, 'Laptop', 'TechSupplier');
    
    select* from Orders;
    
    CREATE TABLE Products_3NF (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    SupplierName VARCHAR(100)
);

CREATE TABLE Orders_3NF (
    OrderID INT PRIMARY KEY,
    ProductID INT,
    FOREIGN KEY (ProductID) REFERENCES Products_3NF(ProductID)
);


INSERT INTO Products_3NF (ProductID, ProductName, SupplierName) VALUES
    (101, 'Laptop', 'TechSupplier'),
    (102, 'Keyboard', 'KeyCo');


INSERT INTO Orders_3NF (OrderID, ProductID) VALUES
    (1, 101),
    (2, 102),
    (3, 101);

select * from  Products_3NF;






