package cw.learn.re_advanced;

public class test {
    public static void main(String[] args){
        test(new IA(){
            @Override
            public void show(){
                System.out.println("使用匿名内部类传递实参");
            }
        });
    }

    public static void test(IA ia){
        ia.show();
    }

    interface IA{
        void show();
    }
}
class Outer{
    public void test(){
         /*
         	此处对象的编译类型为IA(这里IA是一个接口，接口本不可被实例化，但这里相当于一个匿名内部类继承了接口并实现了接口的方法，然后紧接着就创建了对象),运行类型就是匿名内部类(Outer$1)
         */
        IA aaa = new IA(){
            public void test(){
                System.out.println("This is a test.");
            }
        };


    }
}

interface IA{
    void test();
}