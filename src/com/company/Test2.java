package com.company;

public class Test2 {
    public static void main(String[] args) {
        Pig peiQi = new Pig(1, true, "白色", "PeiQi");
        Dog 二哈 = new Dog(1, true, "黑色", "二哈");
        animalOneDay(二哈);
    }

    public static void animalOneDay(AbstrictAnimal animal) {
        System.out.println("太阳升起");
        animal.shot();
        animal.eat("草");
        System.out.println("太阳下山了");
        animal.sleep();
    }
}
