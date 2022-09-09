package cw.learn.advanced;
/**
 * ��̬����
 */

public class PloyArray {
    public static void main(String[] args) {
        NormalPerson[] persons = new NormalPerson[5];
        persons[0] = new NormalPerson("zx", 19);
        persons[1] = new NormalStudent("zx", 19, 60);
        persons[2] = new NormalTeacher("cw", 30, 2000);
        persons[3] = new NormalStudent("red", 18, 100);
        persons[4] = new NormalPerson("glob", 500);

        for (NormalPerson person : persons) {
            person.say();
        }
    }
}

class NormalPerson {
    private String name;
    private int age;

    public NormalPerson(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void say() {
        System.out.println("����" + this.name + "����" + this.age + "��, ����һ����ͨ����");
    }
}

class NormalStudent extends NormalPerson {
    private double score;

    public NormalStudent(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void say() {
        System.out.println("����" + getName() + "����" + getAge() + "��, ����һ����ͨ��ѧ��, �ɼ�" + score + "�֡�");
    }
}

class NormalTeacher extends NormalPerson {
    private double salary;

    public NormalTeacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void say() {
        System.out.println("����" + getName() + "����" + getAge() + "��, ����һ����ͨ�Ľ�ʦ, ����" + salary);
    }
}