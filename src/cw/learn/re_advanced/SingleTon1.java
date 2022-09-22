package cw.learn.re_advanced;

public class SingleTon1 {
    public static void main(String[] args) {
        GirlFriend instance1 = GirlFriend.getInstance();
        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance1 == instance2);
    }
}

// 单例设计模式: 类只能有一个实例
// 饿汉式

/**
 * - 只能有一个实例
 * - 构造器私有，防止直接new一个对象
 * - 在类的内部创建对象
 * - 暴露一个静态方法getintance来创建一个实例并返回
 */

// 饿汉式可能创建了对象但没有使用，
class GirlFriend{
    private String name;
    private static GirlFriend gf = new GirlFriend("lucy");
    private GirlFriend(String name){
        this.name = name;
    }

    public static GirlFriend getInstance(){
        return gf;
    }
}
