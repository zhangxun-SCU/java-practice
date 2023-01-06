package cw.learn.re_advanced;

public class InnerClass {
    public static void main(String[] args){
        test(new IA(){
            @Override
            public void show(){
                System.out.println("使用匿名内部类传递实参");
            }
        });
        System.out.println(animal2.getClass());

    }

    public static void test(IA ia){
        ia.show();
    }

    interface IA{
        void show();
    }

    static Animal2 animal2 = new Animal2(){
        void eat(){
        }
    };
}

class Animal2{
    void eat(){

    }
}
