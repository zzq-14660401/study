package com.company;

public abstract class AbstrictAnimal implements Animal {
    public int age = 0;
    public boolean haveHare = true;
    public String clour = "";
    public String name = "";

    public void sleep() {
        System.out.println(name + "在睡觉");
    }

    public AbstrictAnimal(int age, boolean haveHare, String clour, String name) {
        this.age=age;
        this.haveHare=haveHare;
        this.clour=clour;
        this.name=name;
    }
}
