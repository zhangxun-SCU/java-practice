package cw.learn.re_advanced;

public class SingleTon1 {
    public static void main(String[] args) {
        GirlFriend instance1 = GirlFriend.getInstance();
        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance1 == instance2);
    }
}

// �������ģʽ: ��ֻ����һ��ʵ��
// ����ʽ

/**
 * - ֻ����һ��ʵ��
 * - ������˽�У���ֱֹ��newһ������
 * - ������ڲ���������
 * - ��¶һ����̬����getintance������һ��ʵ��������
 */

// ����ʽ���ܴ����˶���û��ʹ�ã�
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
