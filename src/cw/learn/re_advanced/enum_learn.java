package cw.learn.re_advanced;

public class enum_learn {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season2.AUTUMN);

    }
}

// 枚举类实现
class Season{
    private String name;
    private String description;

    // 1. 构造器私有化
    // 2. 去掉修改（set）相关方法，防止修改
    // 3. 在内部创建固定的对象值
    // 4. 可以加final修饰
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public final static Season SPRING = new Season("春天", "暖阳");
    public final static Season SUMMER = new Season("夏天", "烈日");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season WINTER = new Season("冬天", "寒冷");
}

enum Season2{
    SPRING("春天", "暖阳"),
    SUMMER("夏天", "烈日"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    private String name;
    private String description;
    private Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

enum Week{
    MONDAY("星期一"), TUESDAY(""), WEDNESDAY(""), THURSDAY(""),
    FRIDAY(""), SATURDAY(""), SUNDAY("");
    private String name;

    Week(String name) {
        this.name = name;
    }
}
