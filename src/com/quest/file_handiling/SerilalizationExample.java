package com.quest.file_handiling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerilalizationExample {
    public static void main(String[] args) {
        Employee emp = new Employee(101,"Nikhil");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            oos=new ObjectOutputStream(new FileOutputStream("file5.txt"));
            oos.writeObject(emp);
            oos.flush();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      finally{
            try{
                oos.close();
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
