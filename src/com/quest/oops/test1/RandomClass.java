package com.quest.oops.test1;

public class RandomClass extends AbstractClass{
    public static void main(String[] args) {
        AbstractClass a = new AbstractClass() {

            @Override
            public void drive() {
                System.out.println("random class ");

            }

            @Override
            public void add() {
                super.add();
                System.out.println("random add object ");

            }
        };
        a.drive();



      RandomClass r = new RandomClass();
//      r.drive();
        r.add();
    }

    @Override
    public void drive() {
        System.out.println("I'm a drive in random class");
    }

    void add(int a){

    }


    public void add()
    {
        System.out.println("I'm a add in random class");
    }

}
