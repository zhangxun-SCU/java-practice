package cw.learn.re_advanced;

public class enum_learn {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season2.AUTUMN);

    }
}

// ö����ʵ��
class Season{
    private String name;
    private String description;

    // 1. ������˽�л�
    // 2. ȥ���޸ģ�set����ط�������ֹ�޸�
    // 3. ���ڲ������̶��Ķ���ֵ
    // 4. ���Լ�final����
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public final static Season SPRING = new Season("����", "ů��");
    public final static Season SUMMER = new Season("����", "����");
    public final static Season AUTUMN = new Season("����", "��ˬ");
    public final static Season WINTER = new Season("����", "����");
}

enum Season2{
    SPRING("����", "ů��"),
    SUMMER("����", "����"),
    AUTUMN("����", "��ˬ"),
    WINTER("����", "����");

    private String name;
    private String description;
    private Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

enum Week{
    MONDAY("����һ"), TUESDAY(""), WEDNESDAY(""), THURSDAY(""),
    FRIDAY(""), SATURDAY(""), SUNDAY("");
    private String name;

    Week(String name) {
        this.name = name;
    }
}
