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
