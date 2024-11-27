package com.quest.java8.librarymanagement;


    public class Book implements Cloneable{

        private String bookId;
        private String author;
        private String title;
        private boolean isAvailable;

        public Book(String bookId, String author, String title, boolean isAvailable) {
            this.bookId = bookId;
            this.author = author;
            this.title = title;
            this.isAvailable = isAvailable;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        public String getBookId() {
            return bookId;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public boolean isValid() {
            if(this.getBookId() != null && this.getTitle() != null && this.isAvailable()) {
                return true;
            }
            return false;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Object object = super.clone(); //getting the cloned object
            Book clonedBook = (Book)object ;// typecasting the cloned object to Book

            String originalAuthor = this.getAuthor(); //getting the original author here
            String clonedAuthor = new String(originalAuthor); //creating a new string with same value as original author
            clonedBook.setAuthor(clonedAuthor); //setting the new string in the cloned book's author

            clonedBook.setAvailable(this.isAvailable());
            return clonedBook;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId='" + bookId + '\'' +
                    ", author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", isAvailable=" + isAvailable +
                    '}';
        }
    }


