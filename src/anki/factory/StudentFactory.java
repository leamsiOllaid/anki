package anki.factory;

import anki.Student;

/**
 * Created by leamsiollaid on 13/07/2017.
 */
public class StudentFactory {

    public Student getInstance(String speudo,String pass){
        return new Student(speudo,pass);
    }

    public Student getInstance( String speudo,String pass, String beginDate){
        return new Student( speudo, pass, beginDate);
    }
}
