package anki.boxs;

import anki.cards.Card;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

/**
 * Created by leamsiollaid on 19/07/2017.
 */
public class BoxTest {

    private Box box;

    @Before
    public void setUp() throws Exception {
        box=new Box();
    }

    @Test
    public void testGetCards() throws Exception {
        ArrayList<Card> cards= new ArrayList<>();
        cards.add(new Card());
        cards.add(new Card());
        box.setCards(cards);
        Assert.assertSame(cards,box.getCards());
    }

    @Test
    public void testSetCards() throws Exception {
        ArrayList<Card> cards= new ArrayList<>();
        cards.add(new Card());
        cards.add(new Card());
        box.setCards(cards);
        Assert.assertSame(cards,box.getCards());
    }

    @Test
    public void testAddCard() throws Exception {
        Card card =new Card();
        box.addCard(card);
        Assert.assertTrue(box.getCards().contains(card));
    }

    @Test
    public void testRemoveCard() throws Exception {
        Card card =new Card();
        box.addCard(card);
        box.removeCard(card);
        Assert.assertFalse(box.getCards().contains(card));
    }
}