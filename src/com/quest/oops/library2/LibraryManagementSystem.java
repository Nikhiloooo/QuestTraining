package com.quest.oops.library2;
import java.util.Scanner;
public class LibraryManagementSystem {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Book[] books = new Book[10];
            Member[] members = new Member[10];
            int bookCount = 0;
            int memberCount = 0;

            while (true) {
                System.out.println("\nLibrary Management System:");
                System.out.println("1. Add a Book");
                System.out.println("2. Add a Member");
                System.out.println("3. Borrow a Book");
                System.out.println("4. Return a Book");
                System.out.println("5. Print Book Details");
                System.out.println("6. Print Member Details");
                System.out.println("7. Calculate Late Fees");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        if (bookCount < books.length) {
                            System.out.print("Enter Book Title: ");
                            String title = scanner.next();
                            System.out.print("Enter Book Author: ");
                            String author = scanner.next();
                            System.out.print("Enter Book ISBN: ");
                            String isbn = scanner.next();
                            books[bookCount++] = new Book(title, author, isbn);
                            System.out.println("Book added successfully!");
                        } else {
                            System.out.println("Library is full, cannot add more books.");
                        }
                        break;

                    case 2:
                        if (memberCount < members.length) {
                            System.out.print("Enter Member Name: ");
                            String name = scanner.next();
                            System.out.print("Enter Member ID: ");
                            int memberId = scanner.nextInt();
                            System.out.print("Enter Membership Type (Standard/Premium): ");
                            String membershipType = scanner.next();
                            if (membershipType.equalsIgnoreCase("Premium")) {
                                members[memberCount++] = new PremiumMember(name, memberId);
                            } else {
                                members[memberCount++] = new Member(name, memberId, "Standard");
                            }
                            System.out.println("Member added successfully!");
                        } else {
                            System.out.println("Cannot add more members.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Member ID: ");
                        int borrowerId = scanner.nextInt();
                        System.out.print("Enter Book Title: ");
                        String borrowTitle = scanner.next();
                        Member borrower = findMemberById(members, borrowerId, memberCount);
                        Book bookToBorrow = findBookByTitle(books, borrowTitle, bookCount);
                        if (borrower != null && bookToBorrow != null) {
                            borrower.borrowBook(bookToBorrow);
                        } else {
                            System.out.println("Invalid member ID or book title.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Member ID: ");
                        int returnerId = scanner.nextInt();
                        System.out.print("Enter Book Title: ");
                        String returnTitle = scanner.next();
                        Member returner = findMemberById(members, returnerId, memberCount);
                        if (returner != null) {
                            returner.returnBook(returnTitle);
                        } else {
                            System.out.println("Invalid member ID.");
                        }
                        break;

                    case 5:
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println(books[i]);
                        }
                        break;

                    case 6:
                        for (int i = 0; i < memberCount; i++) {
                            System.out.println(members[i].toString());
                        }
                        break;

                    case 7:
                        System.out.print("Enter Member ID: ");
                        int feeMemberId = scanner.nextInt();
                        System.out.print("Enter Days Late: ");
                        int daysLate = scanner.nextInt();
                        Member feeMember = findMemberById(members, feeMemberId, memberCount);
                        if (feeMember != null) {
                            System.out.println("Late Fees: $" + feeMember.calculateLateFees(daysLate));
                        } else {
                            System.out.println("Invalid member ID.");
                        }
                        break;

                    case 8:
                        System.out.println("Exiting system.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option, please try again.");
                }
            }
        }

        private static Member findMemberById(Member[] members, int id, int count) {
            for (int i = 0; i < count; i++) {
                if (members[i].getMemberId() == id) {
                    return members[i];
                }
            }
            return null;
        }

        private static Book findBookByTitle(Book[] books, String title, int count) {
            for (int i = 0; i < count; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title)) {
                    return books[i];
                }
            }
            return null;
        }
    }


