package cw.learn.advanced;

public class ExtendsList {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.name);
//        son.age.
        System.out.println(son.hobby);
    }
}

class Grandpa{
    String name = "Grandpa";
    String hobby = "play chess";
    int age;
}

class Farther extends Grandpa{
    String name = "Father";
    private int age = 30;
}

class Son extends Farther{
    String name = "Son";
}


