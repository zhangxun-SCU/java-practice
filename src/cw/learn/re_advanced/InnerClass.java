package cw.learn.re_advanced;

public class InnerClass {
    public static void main(String[] args){
        test(new IA(){
            @Override
            public void show(){
                System.out.println("ʹ�������ڲ��ഫ��ʵ��");
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
