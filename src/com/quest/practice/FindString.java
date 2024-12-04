package com.quest.practice;

import java.io.*;

public class FindString {
    public static void main(String[] args) {

        String searchString = "welcome";
        try{
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("FindString.txt")) ;
            int searchIndex = 0;
            int data;

            while ((data = bis.read()) != -1) {
                if ((char) data == searchString.charAt(searchIndex)) {
                    searchIndex++;
                    if (searchIndex == searchString.length()-1) {
                        System.out.println("String \"" + searchString + "\" found in the file.");
                        return;
                    }
                } else {
                    searchIndex = 0;
                }
            }

            System.out.println("String \"" + searchString + "\" not found in the file.");
        }
        catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

