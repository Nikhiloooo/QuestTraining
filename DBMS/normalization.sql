
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
