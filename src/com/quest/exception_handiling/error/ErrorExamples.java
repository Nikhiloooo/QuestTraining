package com.quest.exception_handiling.error;

public class ErrorExamples {

    public static void causeStackOverflow(){
        causeStackOverflow();
    }

    public static void causeOutOfMemory(){
        try{
            while(true){

                int[] arr = new int[1000000];
            }
        }

        catch(OutOfMemoryError e){
            System.out.println("stackOverFlow error occoured: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            causeStackOverflow();
        }
        catch(StackOverflowError e){
            System.out.println("stackOverFlow error occoured: "+e.getMessage());
            e.printStackTrace();
        }

        causeOutOfMemory();
    }
}
