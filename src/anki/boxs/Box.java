package anki.boxs;

import anki.cards.Card;

import java.util.ArrayList;

/**
 * Created by leamsiollaid on 12/07/2017.
 */
public class Box {

    private ArrayList<Card> cards;

    public Box(){
        cards=new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }


    public Card addCard(Card card){
        this.cards.add(card);
        return card;
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }

}
