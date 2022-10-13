package cw.learn.poker;
import java.util.ArrayList;
import java.util.Random;

public class Poker {
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String[] suits = {"c", "d", "h", "s"};
    private ArrayList<Card> cards = new ArrayList<>();
    private static Random rand = new Random();

    public Poker(){
        int count = 0;
        for (String rank : ranks) {
            for (String suit : suits) {
                Card tmpCard = new Card(suit, rank);
                cards.add(tmpCard) ;
            }
        }
    }

    public void swap(ArrayList<Card> cards, int i, int j){
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }
    public void shuffle() {
        int length = cards.size();
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(cards, randInd, i - 1);
        }
    }

    public Card next(){
        if(cards.size() > 0){
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public void output(){
        for(Card tmp:cards){
            System.out.println(tmp);
        }
    }
}
