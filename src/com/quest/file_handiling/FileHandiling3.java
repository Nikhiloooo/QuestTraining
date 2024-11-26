package com.quest.file_handiling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandiling3 {
    public static void main(String[] args) {
        File file=new File("file2.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created" + file.getPath());
            } else {
                System.out.println("File already existed ");
            }
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
                }
                sc.close();
            } else {
                System.out.println("File does not exist");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            file.delete();
                System.out.println("File not deleted");
            }
        }

       }


