package day7;

public class Test05 {
    public static void main(String[] args) {
        Emp emp0 = new Emp(1001, "高小一", 18, "程序员", "2019-9-9");
        Emp emp1 = new Emp(1002, "高小二", 19, "程序员", "2019-10-9");
        Emp emp2 = new Emp(1003, "高小三", 20, "程序员", "2019-11-9");
        Emp[] emps={emp0,emp1,emp2};
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
        }
    }
}

class Emp {
    private int id;
    private String name;
    private int age;
    private String job;
    private String hiredata;

    public Emp() {
    }

    public Emp(int id, String name, int age, String job, String hiredata) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.hiredata = hiredata;
    }
    public String toString(){
        return getId()+"\t"+getName()+"\t"+getAge()+"\t"+getJob()+"\t"+getHiredata();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getHiredata() {
        return hiredata;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setHiredata(String hiredata) {
        this.hiredata = hiredata;
    }
}