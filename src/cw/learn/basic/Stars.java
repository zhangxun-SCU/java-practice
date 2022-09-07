package cw.learn.basic;

public class Stars {
    //    空心金字塔
    public static void main(String[] args) {
        int totalLevel = 10;
        for (int i = 1; i <= totalLevel; i++) {
//            输出完成金子太的空格
            for (int j = i; j <= totalLevel - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
//                每行第一个和最后一个或最后一行位*，其他空格
                if (j == 1 || j == 2 * i - 1 || i == totalLevel) {
                    System.out.print("*");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
