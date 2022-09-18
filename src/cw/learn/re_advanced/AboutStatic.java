package cw.learn.re_advanced;

public class AboutStatic {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println("人数：" + Person.count);
        System.out.println("人数：" + p1.howManyPeople());
        System.out.println("人数：" + Person.howManyPeopleStatic());
        Person p2 = new Person();
        System.out.println("人数：" + Person.count);
        System.out.println("人数：" + p2.howManyPeople());
        System.out.println("人数：" + Person.howManyPeopleStatic());
        Person p3 = new Person();
        System.out.println("人数：" + Person.count);
        System.out.println("人数：" + p3.howManyPeople());
        System.out.println("人数：" + Person.howManyPeopleStatic());
    }
}

class Person{
    public static int count = 0;
    public Person(){
        count++;
    }
    public int howManyPeople(){
        return count;
    }

    public static int howManyPeopleStatic(){
        return count;
    }
}
