package cw.learn.homework;

public class Pingpong {
    public static void main(String[] args) {
        char[] team = {'x', 'y', 'z'};
        for(char a:team){
            for(char b:team){
                for(char c:team){
                    if(a != b && a != c && b != c && a != 'x' && c != 'x' && c != 'z'){
                        System.out.println("a于" + a + "比赛，b与" + b + "比赛，c与" + c + "比赛。");
                    }
                }
            }
        }
    }
}
