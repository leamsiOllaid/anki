package anki.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leamsiollaid on 18/07/2017.
 */
public class CardTest {

    private Card card;
    @Before
    public void setUp() throws Exception {
        card=new Card(1,"question","reponse");
    }

    @Test
    public void testGetQuestion() throws Exception {
        Assert.assertEquals("question",card.getQuestion());
    }

    @Test
    public void testSetQuestion() throws Exception {
        card.setQuestion("newQuestion");
        Assert.assertEquals("newQuestion",card.getQuestion());
    }

    @Test
    public void testGetAnswer() throws Exception {
     Assert.assertEquals("reponse",card.getAnswer());
    }

    @Test
    public void testSetAnswer() throws Exception {
        card.setAnswer("newReponse");
        Assert.assertEquals("newReponse",card.getAnswer());

    }

    @Test
    public void testGetId() throws Exception {
        Assert.assertEquals(1,card.getId());
    }

    @Test
    public void testSetId() throws Exception {
        card.setId(2);
        Assert.assertEquals(2,card.getId());
    }

}