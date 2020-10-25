package Thread_Study02;

import java.lang.Thread.State;

public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(".....");
        });
        State state = t.getState();

    }
}

