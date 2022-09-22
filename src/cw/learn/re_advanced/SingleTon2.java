package cw.learn.re_advanced;


public class SingleTon2 {
    public static void main(String[] args) {
        Cat instance1 = Cat.getInstance();
        Cat instance2 = Cat.getInstance();
        System.out.println(instance1 == instance2);
    }
}
/**
 *  �������ģʽ: ��ֻ����һ��ʵ��
 *  ����ֻ��ʹ�ö���ʱ����ű�����
 */
class Cat{
    /**
     * 1. ������˽�л�
     * 2. static��Ա
     * 3. �ṩһ��public��static���󣬷���Cat����
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