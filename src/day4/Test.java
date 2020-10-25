package day4;

public class Test {
    static void AnimalCry(Animal a) {
        a.shot();
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        AnimalCry(d);
        AnimalCry(new Cat());
    }
}
