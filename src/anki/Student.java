package anki;

import anki.boxs.GreenBox;
import anki.boxs.OrangeBox;
import anki.boxs.RedBox;
import anki.cards.DeckOfCards;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leamsiollaid on 12/07/2017.
 */
public class Student {
    private String pseudo;
    private String pass;
    private Date beginDate;
    private SimpleDateFormat simpleDateFormat;

    private DeckOfCards deckOfCards;
    private GreenBox greenBox;
    private OrangeBox orangeBox;
    private RedBox redBox;

    public Student(String pseudo, String pass) {
        this.simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
        this.pseudo = pseudo;
        this.pass = pass;
        this.deckOfCards=new DeckOfCards();
        this.greenBox= new GreenBox();
        this.orangeBox= new OrangeBox();
        this.redBox= new RedBox();
    }

    public Student(String pseudo,String pass, String beginDate) {
        this.simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

        this.pass = pass;
        this.pseudo = pseudo;
        try {
            this.beginDate = this.simpleDateFormat.parse(beginDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.deckOfCards=new DeckOfCards();
        this.greenBox= new GreenBox();
        this.orangeBox= new OrangeBox();
        this.redBox= new RedBox();


    }

    public Student(String pseudo,String pass, Date beginDate) {
        this.simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

        this.pass = pass;
        this.pseudo = pseudo;
        this.beginDate =beginDate;
        this.deckOfCards=new DeckOfCards();
        this.greenBox= new GreenBox();
        this.orangeBox= new OrangeBox();
        this.redBox= new RedBox();
    }


    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public DeckOfCards getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public GreenBox getGreenBox() {
        return greenBox;
    }

    public void setGreenBox(GreenBox greenBox) {
        this.greenBox = greenBox;
    }

    public RedBox getRedBox() {
        return redBox;
    }

    public void setRedBox(RedBox redBox) {
        this.redBox = redBox;
    }

    public OrangeBox getOrangeBox() {
        return orangeBox;
    }

    public void setOrangeBox(OrangeBox orangeBox) {
        this.orangeBox = orangeBox;
    }

    public Date getBeginDate() {

        return beginDate;
    }

    public String getBeginDateString() {
        return this.simpleDateFormat.format(this.beginDate);
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setBeginDate(String beginDate) {
        try {
            this.beginDate = this.simpleDateFormat.parse(beginDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }
}
