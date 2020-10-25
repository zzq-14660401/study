package day3;

class Dog {
    int size;
    String name;

    void bark() {
        if (size > 60) {
            System.out.println("Wooof!Wooof!");
        } else if (size > 14) {
            System.out.println("Ruff!Ruff!");
        } else {
            System.out.println("Yip!Yip!");
        }
    }
}

class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog();
        one.size = 60;
        Dog two = new Dog();
        two.size = 8;
        Dog three = new Dog();
        three.size = 30;
        one.bark();
        two.bark();
        three.bark();
    }
}
