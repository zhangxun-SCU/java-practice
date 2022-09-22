package cw.learn.re_advanced;

public class CodeBlock {
    public static void main(String[] args) {
        A a = new A();
    }
}

class A{
    A(){
        System.out.println("我是构造器");
    }
    {
      System.out.println("我是普通代码块");
    };
    static {
        System.out.println("我是静态代码块");
    };

}