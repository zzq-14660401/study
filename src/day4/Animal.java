package day4;

public class Animal {
    public void shot() {
        System.out.println("叫了一声!");
    }
}

class Dog extends Animal {
    public void shot() {
        System.out.println("汪汪汪!");
    }
}

class Cat extends Animal {
    public void shot() {
        System.out.println("喵喵喵!");
    }
}