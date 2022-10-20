package cw.learn.poker;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Poker poker = new Poker();
        poker.shuffle();
        Player[] players = new Player[2];
        players[1] = new Player("玩家");
        players[0] = new Player("庄家");

        // 各发2张牌
        players[0].getCard(poker.next());
        players[1].getCard(poker.next());
        players[0].getCard(poker.next());
        players[1].getCard(poker.next());
        // 显示排
        System.out.print("庄家: ");
        int count = 0;
        for(Card card:players[0].cards_hand){
            if(count == 0){
                count++;
                continue;
            }
            System.out.print(card + " ");
        }
        System.out.print("\n玩家: ");
        for(Card card:players[1].cards_hand){
            System.out.print(card + " ");
        }
        System.out.println();
        // 循环发牌
        while (true){
            System.out.print("你的点数是:" + players[1].scores() + "是否继续要牌:(Y/N)");
            String answer = scanner.nextLine();
            if(answer.equals("Y")){
                players[1].getCard(poker.next());
            }
            // 电脑
            if(players[0].scores() <= 17){
                players[0].getCard(poker.next());
            }
            if(answer.equals("N")){
                break;
            }
            count = 0;
            System.out.print("庄家: ");
            for(Card card:players[0].cards_hand){
                if(count == 0){
                    count++;
                    continue;
                }
                System.out.print(card + " ");
            }
            System.out.print("\n玩家: ");
            for(Card card:players[1].cards_hand){
                System.out.print(card + " ");
            }
            System.out.println();
        }

        // 结束
        System.out.print("庄家: ");
        for(Card card:players[0].cards_hand){
            System.out.print(card + " ");
        }
        System.out.print("\n玩家: ");
        for(Card card:players[1].cards_hand){
            System.out.print(card + " ");
        }
        System.out.println("\n庄家：" + players[0].scores() + " 玩家：" + players[1].scores());
        int score_play = players[1].scores();
        int score_ai = players[0].scores();
        if(score_play > 21 && score_ai > 21 || score_ai == score_play){
            System.out.println("平局");
        } else if(score_ai > 21 && score_play < 21){
            System.out.println("玩家胜");
        } else if(score_ai < 21 && score_play > 21){
            System.out.println("庄家胜");
        } else if(score_ai > score_play){
            System.out.println("庄家胜");
        } else{
            System.out.println("玩家胜");
        }

    }
}
