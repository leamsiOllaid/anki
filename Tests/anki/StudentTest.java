package anki;

import anki.boxs.GreenBox;
import anki.boxs.OrangeBox;
import anki.boxs.RedBox;
import anki.cards.Card;
import anki.cards.DeckOfCards;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * Created by leamsiollaid on 18/07/2017.
 */
public class StudentTest {

    private Student student;

    @Before
    public void setUp() throws Exception {
        student=new Student("leamsi","pass");
    }

    @Test
    public void testgetPseudo() throws Exception {
        Assert.assertEquals("leamsi",student.getPseudo());
    }

    @Test
    public void testsetPseudo() throws Exception {
        student.setPseudo("ollaid");
        Assert.assertEquals("ollaid", student.getPseudo());
    }

    @Test
    public void testGetPass() throws Exception {
        Assert.assertEquals("pass", student.getPass());
    }

    @Test
    public void testSetPass() throws Exception {
        student.setPass("newPass");
        Assert.assertEquals("newPass", student.getPass());
    }

    @Test
    public void testGetDeckOfCardsNotNull() throws Exception {
        Assert.assertNotNull(student.getDeckOfCards());
    }

    @Test
    public void testGetDeckOfCardsIofDeckOfCards() throws Exception {
        Assert.assertThat(student.getDeckOfCards(), instanceOf(DeckOfCards.class));
    }

    @Test
    public void testSetDeckOfCards() throws Exception {
        DeckOfCards deckOfCards= new DeckOfCards();
        deckOfCards.addCard(new Card(1,"Question","answer"));
        deckOfCards.addCard(new Card(2,"Question","answer"));
        deckOfCards.addCard(new Card(3,"Question","answer"));
        student.setDeckOfCards(deckOfCards);
        Assert.assertSame(deckOfCards, student.getDeckOfCards());
    }

    @Test
    public void testGetGreenBoxNotNull() throws Exception {
        Assert.assertNotNull(student.getGreenBox());
    }

    @Test
    public void testGetGreenBox() throws Exception {
        Assert.assertThat(student.getGreenBox(), instanceOf(GreenBox.class));
    }

    @Test
    public void testSetGreenBox() throws Exception {
        GreenBox greenBox=new GreenBox();
        student.setGreenBox(greenBox);
        Assert.assertSame(greenBox, student.getGreenBox());
    }
    
    @Test
    public void testGetOrangeBoxNotNull() throws Exception {
        Assert.assertNotNull(student.getOrangeBox());
    }    
    
    @Test
    public void testGetOrangeBox() throws Exception {
        Assert.assertThat(student.getOrangeBox(), instanceOf(OrangeBox.class));
    }
    
    @Test
    public void testSetOrangeBox() throws Exception {
        OrangeBox orangeBox=new OrangeBox();
        student.setOrangeBox(orangeBox);
        Assert.assertSame(orangeBox, student.getOrangeBox());
    }

    @Test
    public void testGetRedBoxNotNull() throws Exception {
        Assert.assertNotNull(student.getRedBox());
    }

    @Test
    public void testGetRedBox() throws Exception {
        Assert.assertThat(student.getRedBox(), instanceOf(RedBox.class));
    }

    @Test
    public void testSetRedBox() throws Exception {
        RedBox RedBox=new RedBox();
        student.setRedBox(RedBox);
        Assert.assertSame(RedBox, student.getRedBox());
    }

    @Test
    public void testSetBeginDateNotNull() throws Exception {
        Date date= new Date();
        student.setBeginDate(date);
        Assert.assertNotNull(student.getBeginDate());
    }

    @Test
    public void testSetBeginDate() throws Exception {
        Date date= new Date();
        student.setBeginDate(date);
        Assert.assertSame(date, student.getBeginDate());
    }

    @Test
    public void testSetBeginDateString() throws Exception {
        student.setBeginDate("22/07/2019");
        Assert.assertEquals(student.getSimpleDateFormat().parse("22/07/2019"),student.getBeginDate());
    }

    @Test
    public void testGetBeginDateIofDate() throws Exception {
        student.setBeginDate(new Date());
        Assert.assertThat(student.getBeginDate(), instanceOf(Date.class));
    }

    @Test
    public void testGetBeginDate() throws Exception {
        student.setBeginDate(new Date());
        Assert.assertEquals(new Date(), student.getBeginDate());
    }

    @Test
    public void testGetBeginDateString() throws Exception {
        student.setBeginDate(new Date());
        Assert.assertEquals(student.getBeginDate(), new Date());
    }


}