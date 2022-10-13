package cw.learn.re_advanced;

public class test {
    public static void main(String[] args) {
        StringBuffer ss = new StringBuffer("123");
        System.out.println(ss.hashCode());
        ss.append("456");
        System.out.println(ss.hashCode());
        System.out.println("你好");
    }
}
