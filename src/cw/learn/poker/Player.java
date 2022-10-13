package cw.learn.poker;

import java.util.ArrayList;

public class Player {
    private String name;
    ArrayList<Card> cards_hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void getCard(Card card){
        cards_hand.add(card);
    }

    public int scores(){
        int sum = 0;
        for(Card tmp: cards_hand){
            if(Integer.parseInt(tmp.getRank()) <= 10 || Integer.parseInt(tmp.getRank()) >= 2){
                sum += Integer.parseInt(tmp.getRank());
            } else if(tmp.getRank().equals("K") || tmp.getRank().equals("J") || tmp.getRank().equals("Q")){
                sum += 10;
            } else if (tmp.getRank().equals("A")) {
                if(sum <= 10){
                    sum += 10;
                } else{
                    sum += 1;
                }
            }
        }
        return sum;
    }
}
