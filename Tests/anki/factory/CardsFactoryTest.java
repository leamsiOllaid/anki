package anki.factory;

import anki.cards.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by leamsiollaid on 19/07/2017.
 */
public class CardsFactoryTest {

    CardsFactory cardsFactory;

    @Before
    public void setUp() throws Exception {
        cardsFactory=new CardsFactory();
    }

    @Test
    public void testGetInstance() throws Exception {
        Assert.assertThat(cardsFactory.getInstance(1,"question","answer"),instanceOf(Card.class));
    }
}