package cw.learn.homework;

import java.util.Scanner;

public class APerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.next();
        Person[] persons = new Person[n];
        for(int i = 0; i < n; i++){
            String[] tmp = scanner.nextLine().split(" ");
            persons[i] = new Person(tmp[0], Integer.parseInt(tmp[1]), Boolean.parseBoolean(tmp[2]));
        }
        for(int i = n - 1; i >= 0; i--){
            System.out.println(persons[i]);
        }
        System.out.println(new Person());
    }
}

class Person{
    private String name=null;
    private int age=0;
    private boolean gender=false;
    private int id=0;

    Person(){
        System.out.println("This is constructor");
        System.out.println(null + "," + age + "," + false + "," + id);
    }

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person [" + "name=" + name + ", age=" + age + ", gender=" + gender + ", id=" + id + "]";
    }
}