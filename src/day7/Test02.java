package day7;

public class Test02 {
    public static void main(String[] args) {
        Man[] mans = {new Man(10, "高小一"),
                new Man(20, "高小二"),
                new Man(30, "高小三"),
                new Man(40, "高小四"),
                new Man(50, "高小五")};
        for (int i = 0; i < mans.length; i++) {
            Man man = mans[i];
            System.out.println(man);

        }
        for (Man man : mans) {
            System.out.println(man);
        }
    }

}

class Man {
    private int id;
    private String name;

    public Man(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toSteing() {
        return "id:" + id + ",name:" + this.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
