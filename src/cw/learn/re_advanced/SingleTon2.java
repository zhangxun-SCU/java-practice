package cw.learn.re_advanced;


public class SingleTon2 {
    public static void main(String[] args) {
        Cat instance1 = Cat.getInstance();
        Cat instance2 = Cat.getInstance();
        System.out.println(instance1 == instance2);
    }
}
/**
 *  单例设计模式: 类只能有一个实例
 *  并且只有使用对象时对象才被创建
 */
class Cat{
    /**
     * 1. 构造器私有化
     * 2. static成员
     * 3. 提供一个public的static对象，返回Cat对象
     */
    private String name;
    private static Cat cat;
    private Cat(String name) {
        this.name = name;
    }
    static public Cat getInstance(){
        if(cat == null){
            cat = new Cat("cookie");
        }
        return cat;
    }
}