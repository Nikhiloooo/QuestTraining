package com.quest.oops.library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Display Available Books");
            System.out.println("7. Display All Members");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Publication Year: ");
                    int year = scanner.nextInt();
                    Book newBook = new Book();
                    newBook.setIsbn(isbn);
                    newBook.setTitle(title);
                    newBook.setAuthor(author);
                    newBook.setPublicationYear(year);
                    newBook.setAvailabilityStatus(true);
                    if (library.addBook(newBook)) {
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Library is full, can't add more books.");
                    }
                    break;


                case 2:
                    System.out.print("Enter Member ID: ");
                     String memberId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Info: ");
                    String contactInfo = scanner.nextLine();
                    LibraryMember newMember = new LibraryMember();
                    newMember.setMemberId(memberId);
                    newMember.setName(name);
                    newMember.setContactInfo(contactInfo);
                    if (library.addMember(newMember)) {
                        System.out.println("Member added successfully!");
                    } else {
                        System.out.println("Library is full, can't add more members.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                     memberId = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    library.borrowBook(memberId, isbn);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    library.returnBook(memberId, isbn);
                    break;

                case 5:
                    System.out.print("Enter ISBN to search: ");
                    isbn = scanner.nextLine();
                    if (library.searchBook(isbn)) {
                        System.out.println("Book found.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    library.displayAvailableBooks();
                    break;

                case 7:
                    library.displayAllMembers();
                    break;



                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
