package anki.factory;

import anki.cards.Card;

/**
 * Created by leamsiollaid on 13/07/2017.
 */
public class CardsFactory {

    public Card getInstance(int id, String question, String answer){
        return new Card(id,question,answer);
    }
}
