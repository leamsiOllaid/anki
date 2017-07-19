package anki.factory;

import anki.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.instanceOf;
/**
 * Created by leamsiollaid on 19/07/2017.
 */
public class StudentFactoryTest {

    private StudentFactory studentFactory;

    @Before
    public void setUp() throws Exception {
        studentFactory= new StudentFactory();
    }

    @Test
    public void testGetInstance() throws Exception {
        Assert.assertThat(studentFactory.getInstance("leamsi","momo"),instanceOf(Student.class));
    }

    @Test
    public void testGetInstance1() throws Exception {
        Assert.assertThat(studentFactory.getInstance("leamsi","momo","2/09/2017"),instanceOf(Student.class));
    }

}