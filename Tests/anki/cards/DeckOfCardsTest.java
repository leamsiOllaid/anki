package anki.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by leamsiollaid on 18/07/2017.
 */
public class DeckOfCardsTest {

    private DeckOfCards deckOfCards;
    private ArrayList<Card> cards;


    @Before
    public void setUp() throws Exception{
        deckOfCards= new DeckOfCards(1);
    }

    @Test
    public void testGetCardsNotNull() throws Exception {
        Assert.assertNotNull(deckOfCards.getCards());
    }

    @Test
    public void testSetCards() throws Exception {
        ArrayList<Card> cards= new ArrayList<>();
        cards.add(new Card());
        cards.add(new Card());
        cards.add(new Card());
        deckOfCards.setCards(cards);
        Assert.assertSame(cards,deckOfCards.getCards());
    }

    @Test
    public void testAddCard() throws Exception {
        Card card = new Card();
        deckOfCards.addCard(card);
        Assert.assertTrue(deckOfCards.getCards().contains(card));
    }

    @Test
    public void testGetCard() throws Exception {
        Card card = new Card();
        deckOfCards.addCard(card);
        Assert.assertThat(deckOfCards.getCard(0),instanceOf(Card.class));
    }

    @Test
    public void testRemoveCard() throws Exception {
        Card card = new Card();
        deckOfCards.addCard(card);
        deckOfCards.removeCard(card);
        Assert.assertFalse(deckOfCards.getCards().contains(card));
    }

    @Test
    public void testGetId() throws Exception {
        Assert.assertEquals(1,deckOfCards.getId());
    }

    @Test
    public void testSetId() throws Exception {
        deckOfCards.setId(2);
        Assert.assertEquals(2, deckOfCards.getId());
    }

    @Test
    public void testSortCards() throws Exception {

    }
}