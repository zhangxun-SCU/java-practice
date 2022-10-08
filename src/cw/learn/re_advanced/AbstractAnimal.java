package cw.learn.re_advanced;

public class AbstractAnimal {
    public static void main(String[] args) {
        Zhenghao zhenghao = new Zhenghao();
        zhenghao.eat();
    }
}

abstract class Animal{
    String name;
    abstract void eat();
}

class Zhenghao extends  Animal{
    String name;

    @Override
    public void eat(){
        System.out.println("我吃饭");
    }
}