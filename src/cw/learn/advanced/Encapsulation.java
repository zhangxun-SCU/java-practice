package cw.learn.advanced;

public class Encapsulation {
    public static void main(String[] args) {

    }
}

class Person{
    public String name; // ���ֹ���
    private int age; // ����������
    private double salary; // ����������

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
