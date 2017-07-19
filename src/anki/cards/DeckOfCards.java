package anki.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by leamsiollaid on 12/07/2017.
 */
public class DeckOfCards {

    private int id;
    private ArrayList<Card> cards;

    public DeckOfCards(){
        cards= new ArrayList<>();
    }

    public DeckOfCards(int id){
        this.id=id;
        cards= new ArrayList<>();
    }

    public DeckOfCards(int id,ArrayList<Card> cards){
        this.id=id;
        this.cards=cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Card addCard(Card card){
        cards.add(card);
        return card;
    }

    public Card getCard(int i){
        return cards.get(i);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void sortCards(){
        Collections.sort(this.cards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return card2.getQuestion().compareTo(card1.getQuestion()) ;
            }
        });
    }

}
