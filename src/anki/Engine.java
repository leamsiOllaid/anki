package anki;

import anki.cards.Card;
import anki.factory.CardsFactory;
import anki.factory.StudentFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by leamsiollaid on 12/07/2017.
 */
public class Engine {
    public static anki.utils.Properties questions=new anki.utils.Properties("src/anki/resources/cards.properties");
    public static anki.utils.Properties students=new anki.utils.Properties("src/anki/resources/students.properties");
    public static anki.utils.Properties deckofcards=new anki.utils.Properties("src/anki/resources/deckofcards.properties");
    public static anki.utils.Properties greenbox=new anki.utils.Properties("src/anki/resources/greenbox.properties");
    public static anki.utils.Properties orangebox=new anki.utils.Properties("src/anki/resources/orangebox.properties");
    public static anki.utils.Properties redbox=new anki.utils.Properties("src/anki/resources/redbox.properties");
    public static HashMap<Integer,Card> mapCard=new HashMap<Integer,Card>();
    public static HashMap<String,Student> mapStudent=new HashMap<String,Student>();

    static
    {
        //students upload
        String [] tabStudents=Engine.students.read("STUDENTS",":");
        if(tabStudents.length>0){
            String [] tmpStudent;
            for (int i=0;i<tabStudents.length;i++){
                tmpStudent=tabStudents[i].split("=");
                if(tmpStudent.length>=3){
                    Engine.mapStudent.put(tmpStudent[0],new StudentFactory().getInstance(tmpStudent[0],tmpStudent[1],tmpStudent[2]));
                }
            }
        }

        //cards upload
        String [] tabCards=Engine.questions.read("CARDS",":");
        if(tabCards.length>0){
            String [] tempCard;
            for(int i=0;i<tabCards.length;i++){
                tempCard=tabCards[i].split("=");
                if(tempCard.length>=3) {
                    Engine.mapCard.put(Integer.parseInt(tempCard[0]), new CardsFactory().getInstance(Integer.parseInt(tempCard[0]), tempCard[1], tempCard[2]));
                }
            }
        }

        //deckofcards
        String [] tabDeckOfCards=Engine.deckofcards.read("DECKOFCARDS",":");
        if(tabDeckOfCards.length>0){
            String [] tmpDeckOfCards;
            for(int i=0;i<tabDeckOfCards.length;i++){
                tmpDeckOfCards=tabDeckOfCards[i].split("=");
                if(tmpDeckOfCards.length>=2 && Engine.mapStudent.containsKey(tmpDeckOfCards[0])) {
                    Engine.mapStudent.get(tmpDeckOfCards[0]).getDeckOfCards().getCards().add(Engine.mapCard.get(Integer.parseInt(tmpDeckOfCards[1])));
                }
            }

        }

        //green
        String [] tabGreenBox=Engine.greenbox.read("GREENBOX",":");
        if(tabGreenBox.length>0){
            String [] tmpGreenBox;
            for(int i=0;i<tabGreenBox.length;i++){
                tmpGreenBox=tabGreenBox[i].split("=");
                if(tmpGreenBox.length>=2 && Engine.mapStudent.containsKey(tmpGreenBox[0])){
                    Engine.mapStudent.get(tmpGreenBox[0]).getGreenBox().getCards().add(Engine.mapCard.get(Integer.parseInt(tmpGreenBox[1])));
                }
            }
        }

        //orange
        String [] tabOrangeBox=Engine.orangebox.read("ORANGEBOX",":");
        if(tabOrangeBox.length>0){
            String [] tmpOrangeBox;
            for(int i=0;i<tabOrangeBox.length;i++){
                tmpOrangeBox=tabOrangeBox[i].split("=");
                if(tmpOrangeBox.length>=2 && Engine.mapStudent.containsKey(tmpOrangeBox[0])){
                Engine.mapStudent.get(tmpOrangeBox[0]).getOrangeBox().getCards().add(Engine.mapCard.get(Integer.parseInt(tmpOrangeBox[1])));
                }
            }
        }

        //red
        String [] tabRedBox=Engine.redbox.read("REDBOX",":");
        if(tabRedBox.length>0){
            String [] tmpRedBox;
            for(int i=0;i<tabRedBox.length;i++) {
                tmpRedBox = tabOrangeBox[i].split("=");
                if (tmpRedBox.length >= 2 && Engine.mapStudent.containsKey(tmpRedBox[0])) {
                    Engine.mapStudent.get(tmpRedBox[0]).getRedBox().getCards().add(Engine.mapCard.get(Integer.parseInt(tmpRedBox[1])));
                }
            }
        }

    }

    private Engine(){}
    private static class EngineSingleton
    {
        private static final Engine INSTANCE= new Engine();
    }
    public static Engine getInstance()
    {
        return EngineSingleton.INSTANCE;
    }
    
    public void play(Student student) {
        Scanner scanner=new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (Map.Entry<Integer, Card> cardEntry : Engine.mapCard.entrySet()) {
            student.getDeckOfCards().addCard(cardEntry.getValue());
        }

        //sort Deck of Cards
        student.getDeckOfCards().sortCards();
        System.out.println("\n°  card question | card answer  °\n");
        for (Card card : student.getDeckOfCards().getCards()) {
            System.out.println(card.getQuestion() + " | " + card.getAnswer());
        }

        System.out.println("\nCommencer la partie ? \n (1) OUI \n (2) NON");

        switch (scanner.nextInt()){
            case 1:
                do {
                    if ( (sdf.format(student.getBeginDate()).equals(sdf.format(new Date()))
                        //|| student.getBeginDate().before(new Date())
                        )
                            && !student.getRedBox().getCards().isEmpty()) {
                        System.out.println("\nJEU\n");
                        student.getDeckOfCards().sortCards();
                        System.out.println("\n°  card question | card answer  °\n");

                        for (Iterator<Card> cardIterator = student.getRedBox().getCards().iterator(); cardIterator.hasNext(); ) {
                            Card card = cardIterator.next();
                            System.out.println(card.getQuestion() + " | " + card.getAnswer());
                            student.getDeckOfCards().addCard(card);
                            cardIterator.remove();
                        }


                    }else if( (addNbrofDay(student.getBeginDate(),1).equals(new Date())
                                || addNbrofDay(student.getBeginDate(),1).before(new Date())
                                )

                            )
                    {
                        System.out.println("\nJEU\n");
                        student.getDeckOfCards().sortCards();
                        System.out.println("\n°  card question | card answer  °\n");

                        if(!student.getRedBox().getCards().isEmpty())
                        {
                            for (Iterator<Card> cardIterator = student.getRedBox().getCards().iterator(); cardIterator.hasNext(); ) {
                                Card card = cardIterator.next();
                                System.out.println(card.getQuestion() + " | " + card.getAnswer());
                                student.getDeckOfCards().addCard(card);
                                cardIterator.remove();
                            }
                        }else if(!student.getOrangeBox().getCards().isEmpty()){
                            for (Iterator<Card> cardIterator = student.getOrangeBox().getCards().iterator(); cardIterator.hasNext(); ) {
                                Card card = cardIterator.next();
                                System.out.println(card.getQuestion() + " | " + card.getAnswer());
                                student.getDeckOfCards().addCard(card);
                                cardIterator.remove();
                            }
                        }


                    } else if( (addNbrofDay(student.getBeginDate(),2).equals(new Date())
                                || addNbrofDay(student.getBeginDate(),2).before(new Date())
                                )
                            )
                    {
                        System.out.println("\nJEU\n");
                        student.getDeckOfCards().sortCards();
                        System.out.println("\n°  card question | card answer  °\n");

                        if(!student.getRedBox().getCards().isEmpty())
                        {
                            for (Iterator<Card> cardIterator = student.getRedBox().getCards().iterator(); cardIterator.hasNext(); ) {
                                Card card = cardIterator.next();
                                System.out.println(card.getQuestion() + " | " + card.getAnswer());
                                student.getDeckOfCards().addCard(card);
                                cardIterator.remove();
                            }
                        }else if(!student.getOrangeBox().getCards().isEmpty()){
                            for (Iterator<Card> cardIterator = student.getOrangeBox().getCards().iterator(); cardIterator.hasNext(); ) {
                                Card card = cardIterator.next();
                                System.out.println(card.getQuestion() + " | " + card.getAnswer());
                                student.getDeckOfCards().addCard(card);
                                cardIterator.remove();
                            }
                        }else if(!student.getGreenBox().getCards().isEmpty()){
                            for (Iterator<Card> cardIterator = student.getGreenBox().getCards().iterator(); cardIterator.hasNext(); ) {
                                Card card = cardIterator.next();
                                System.out.println(card.getQuestion() + " | " + card.getAnswer());
                                student.getDeckOfCards().addCard(card);
                                cardIterator.remove();
                            }
                        }
                    }


                    while (!student.getDeckOfCards().getCards().isEmpty()) {

                        System.out.println(
                                "Deck of cards = " + student.getDeckOfCards().getCards().size()
                                        + " | Green Box = " + student.getGreenBox().getCards().size()
                                        + " | Orange Box= " + student.getOrangeBox().getCards().size()
                                        + " | Red Box=" + student.getRedBox().getCards().size()
                                        + "\n");
                        System.out.println("\n ACTION \n (1) Green \n (2) Orange \n (3) Red \n (4) Quitter");
                        System.out.println("Question : " + student.getDeckOfCards().getCards().get(0).getQuestion());

                        switch (scanner.nextInt()) {
                            case 1:
                                //System.out.print("->green");
                                student.getGreenBox().addCard(student.getDeckOfCards().getCards().get(0));
                                student.getDeckOfCards().getCards().remove(0);
                                break;
                            case 2:
                                student.getOrangeBox().addCard(student.getDeckOfCards().getCards().get(0));
                                student.getDeckOfCards().getCards().remove(0);
                                break;
                            case 3:
                                student.getRedBox().addCard(student.getDeckOfCards().getCards().get(0));
                                student.getDeckOfCards().getCards().remove(0);
                                break;
                        }
                    }

                    if (sdf.format(student.getBeginDate()).equals(sdf.format(new Date()))
                            && student.getDeckOfCards().getCards().isEmpty()
                            && student.getRedBox().getCards().isEmpty()
                            && sdf.format(student.getBeginDate()).equals(sdf.format(new Date()))
                            ) {

                        for (Card card : student.getGreenBox().getCards()) {
                            Engine.greenbox.write("GREENBOX", student.getPseudo() + "=" + card.getId());
                        }

                        for (Card card : student.getOrangeBox().getCards()) {
                            Engine.orangebox.write("ORANGEBOX", student.getPseudo() + "=" + card.getId());
                        }

                        System.out.println(">>>>>>>>>>Partie sauvegardée<<<<<<<<<<");
                        break;
                    }
                } while (true);
                break;
            case 2:
                break;
        }
    }

    public Date addNbrofDay(Date date,int nbrDay){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, nbrDay);
        return calendar.getTime() ;
    }
}
