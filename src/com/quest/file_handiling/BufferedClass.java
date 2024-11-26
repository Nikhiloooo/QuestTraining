package com.quest.file_handiling;

import java.io.*;

public class BufferedClass {
    public static void main(String[] args) {

        String str="Hello World";
        try{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("file2.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("file1.txt"));
        byte[] buf=new byte[1024];
        int c;
        while((c= bis.read(buf))!=-1){
            System.out.println((char)c);
            bos.write(buf,0,(char)c);

      }
        bos.flush();
        bis.close();
        bos.close();
        }
    catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
