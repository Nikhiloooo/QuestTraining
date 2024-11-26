package com.quest.java8.bookstore;

public class BookstoreInventoryManagement {
    private static final double DISCOUNT_PERCENTAGE = 25.0;

    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("Book A", "Author 1", 300.00, 15);
        books[1] = new SpecialEditionBook("Book B", "Author 2", 500.00, 10, "Special Cover");
        books[2] = new Book("Book C", "Author 3", 400.00, 8);
        books[3] = new SpecialEditionBook("Book D", "Author 4", 700.00, 5, "Limited Edition");
        books[4] = new Book("Book E", "Author 5", 600.00, 6);


        System.out.println("displaying all books:");
        for (Book book : books) {
            System.out.println(book);
        }


        System.out.println("\n purchasing books: :");
        try {
            books[0].purchase(5);
            books[2].purchase(9);
            books[3].purchase(5);
            books[4].purchase(8);
            books[5].purchase(3);

        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }

        double givenValue = 500.0;
        BookFilter filter = book -> book.getPrice() > givenValue;

        System.out.println("\nBooks priced above " + givenValue + ":");
        for (Book book : books) {
            if (filter.test(book)) {
                System.out.println(book.getTitle());
            }
        }


        System.out.println("\nDiscount Percentage: " + DISCOUNT_PERCENTAGE + "%");






    }

}



