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
