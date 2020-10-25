package IO_study;

public class DecorateTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();
        Amplifier amp = new Amplifier(p);
        amp.say();
    }
}

interface Say {
    void say();
}

class Person implements Say {
    private int voice = 10;

    public void say() {
        System.out.println("人的声音为:" + this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say {
    private Person p;

    Amplifier(Person p) {
        this.p = p;
    }

    public void say() {
        System.out.println("人的声音为:" + p.getVoice() * 10);
        System.out.println("噪音");
    }
}