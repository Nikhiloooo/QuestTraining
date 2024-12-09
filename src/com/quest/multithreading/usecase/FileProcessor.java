package com.quest.multithreading.usecase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor extends Thread {

    private final String fileName;

    FileProcessor(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public void run() {
        try(BufferedReader bfr=new BufferedReader(new FileReader(fileName))){
            String read;
            while( (read=bfr.readLine())!=null){
                System.out.println(Thread.currentThread().getName()+ " : content "+ read +" from "+fileName);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileReading{
    public static void main(String[] args) {
        FileProcessor fp1=new FileProcessor("file1.txt");
        FileProcessor fp2=new FileProcessor("file2.txt");
        FileProcessor fp3=new FileProcessor("file4.txt");
        fp1.start();
        fp2.start();
        fp3.start();

    }
}
