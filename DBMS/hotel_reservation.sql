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
LEFT JOIN Reservations res
    ON r.room_id = res.room_id
    AND (res.check_in_date <= '2024-12-05' AND res.check_out_date >= '2024-12-01')
WHERE r.status = 'available'
  AND res.reservation_id IS NULL;



