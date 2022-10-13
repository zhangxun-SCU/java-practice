package cw.learn.poker;

public class App {
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shuffle();
        poker.output();
        System.out.println(poker.next());
        System.out.println(poker.next());
        System.out.println(poker.next());
        poker.output();

    }
}
