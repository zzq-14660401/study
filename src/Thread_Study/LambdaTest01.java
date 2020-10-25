package Thread_Study;

public class LambdaTest01 {
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();
    }
}

interface ILike {
    void lambda();
}

class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("hello wrold");
    }
}
