package com.quest.file_handiling;

import java.io.*;

public class Stream2 {
    public static void main(String[] args) {

        File file=new File("file2.txt");
        try{
            if(file.createNewFile()){
                System.out.println("File created");
            }
            FileInputStream fis = new FileInputStream("file2.txt");
            int c;
            String str="\n hello1"
                    + "\nhello2"
                    + "\nhello3"
                    + "\nhello4"
                    + "\nhello5";
            FileOutputStream fos = new FileOutputStream(file,true);
            fos.write("program 1 ".getBytes());
            fos.write("\nprogram 2 ".getBytes());
            fos.write("\nprogram 3 ".getBytes());
            fos.write("\nprogram 4 ".getBytes());
            fos.write("\nprogram 5 ".getBytes());
            fos.write(str.getBytes());
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }
            fos.close();
            fis.close();
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
