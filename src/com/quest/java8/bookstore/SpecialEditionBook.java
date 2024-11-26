package com.quest.java8.bookstore;

public class SpecialEditionBook extends Book {
    private String specialFeature;

    public SpecialEditionBook(String title, String author, double price, int stock, String specialFeature) {
        super(title, author, price, stock);
        this.specialFeature = specialFeature;
    }

    public String getSpecialFeature() {
        return specialFeature;
    }

    public void setSpecialFeature(String specialFeature) {
        this.specialFeature = specialFeature;
    }

    @Override
    public String toString() {
        return super.toString() + ", Special Feature=" + specialFeature;
    }

}
