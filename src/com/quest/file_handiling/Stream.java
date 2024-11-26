package com.quest.file_handiling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file1.txt");
            System.out.println("file is created successfully");
            int c;
            String str="Input as streams";
            FileOutputStream fos = new FileOutputStream("file1.txt");
//            fos.write(fis.read());
//            System.out.println(fis.read());
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }
//            fis.read();
            fis.close();
            fos.close();
            System.out.println("\nfile stream is closed  successfully");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
