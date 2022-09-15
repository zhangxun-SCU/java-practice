package cw.learn.advanced;

public class Encapsulation {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1==p2);
//        System.out.println(p1.equals(p2));
        p1.setName("cw");
        p1.setAge(18);
        p1.setSalary(1000);
//        p2.setName("zx");
//        p2.setAge(19);
//        p2.setSalary(1000);
        p2.setName("cw");
        p2.setAge(18);
        p2.setSalary(1000);
        System.out.println(p1.equals(p2));
    }
}

class Person{
    public String name; // 名字公开
    private int age; // 年龄是秘密
    private double salary; // 工资是秘密

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean equals(Object obj){
//        如果是同一个对象直接返回true
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person tmp = (Person) obj;
            return this.name.equals(tmp.name) && this.age == tmp.age && this.salary == tmp.salary;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
