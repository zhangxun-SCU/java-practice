package cw.learn.advanced;

public class Encapsulation {
    public static void main(String[] args) {

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
}
