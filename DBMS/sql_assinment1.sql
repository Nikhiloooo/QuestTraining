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