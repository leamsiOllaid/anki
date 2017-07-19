package anki.cards;

/**
 * Created by leamsiollaid on 12/07/2017.
 */
public class Card {

    private int id;
    private String question;
    private String answer;

    public Card(){

    }

    public Card(int id, String question, String answer){
        this.id=id;
        this.question=question;
        this.answer=answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
