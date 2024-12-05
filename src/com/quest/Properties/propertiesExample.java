package com.quest.Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesExample {
    public static void main(String[] args) {
        //create properties object
        Properties prop = new Properties();

        //set some key value  pairs

        prop.setProperty("database.url", "jdbc:oracle:thin:@localhost:1521:xe");
        prop.setProperty("database.username", "scott");
        prop.setProperty("database.password", "tiger");

        //save  properties to a file
        try(FileOutputStream out=new FileOutputStream("config.properties")){
            prop.store(out,"Database configuration");
            System.out.println("Database configuration loaded");

        }
        catch(IOException e){
            e.printStackTrace();
        }

        //Load  properties from a file
        Properties prop2 = new Properties();
        try(FileInputStream in =new FileInputStream("config.properties")){
            prop2.load(in);
            System.out.println("Database configuration loaded");
            System.out.println("Database url "+prop2.getProperty("database.url"));
            System.out.println("database user "+prop2.getProperty("database.username"));
            System.out.println(" database pasword "+prop2.getProperty("database.password"));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
