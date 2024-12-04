package com.quest.practice.multipleinheritance;

public class Child implements Father,Mother {
    @Override
    public void roundFace() {
        System.out.println("Child round face from father");
    }

    @Override
    public void blueEyes() {
        System.out.println("Child blueEyes from mother");
    }
}
