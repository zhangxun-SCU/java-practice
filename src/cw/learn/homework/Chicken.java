package cw.learn.homework;

public class Chicken {
    public static void main(String[] args) {

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 33; j++) {
                if ((i * 5 + j * 3 + (100 - i - j) / 3) == 100 && (100-i-j)%3 == 0){
                    System.out.println("公鸡：" + i + "只" + "  母鸡：" + j + "只" + "  小鸡：" + (100-i-j) + "只");
                }
            }
        }
    }
}
