package com.quest.file_handiling;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FileHandiling1 {
    public static void main(String[] args)  {
        File file=new File("file1.txt");

        /*try {
            if(file.createNewFile()){
                System.out.println("File created "+file.getAbsolutePath());

            }
            else {
                System.out.println("File already exists "+file.getPath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        try {
            System.out.println("file started");
            if(file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line1 = sc.nextLine();
                    System.out.println(line1);
                }
                sc.close();
                System.out.println("file created successfully");
            }
            else{
                System.out.println("File does not exist");
            }
            System.out.println("file ended");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            file.delete();
            System.out.println("file deleted successfully");
        }
//

    }
}