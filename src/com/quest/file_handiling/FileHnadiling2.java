package com.quest.file_handiling;

import java.io.FileWriter;
import java.io.IOException;

public class FileHnadiling2 {
    public static void main(String[] args) {
        try {
            FileWriter fw=new FileWriter("filewriter1.txt");
            fw.write("Hello World  file writer 1");
            fw.append("hellooooo",2,10);
            fw.close();
            System.out.println("file sucessfully written");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
