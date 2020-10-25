package com.company;

public class Dog extends AbstrictAnimal {

    public Dog(int age, boolean haveHare, String clour, String name) {
        super(age, haveHare, clour, name);
    }

    @Override
    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    @Override
    public void shot() {
        System.out.println(name + "正在汪汪叫");
    }
}
