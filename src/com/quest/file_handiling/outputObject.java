package com.quest.file_handiling;

import java.io.*;

public class outputObject {
    public static void main(String[] args) {
        String str="added Content";
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file4.txt", true));
            bos.write(str.getBytes());
            System.out.println("Buffered data is added successfully");
            int c;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file4.txt"));
            while((c=bis.read())!=-1){
                bos.write(str.getBytes(),0,c);
                System.out.println((char)c);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
