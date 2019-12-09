import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Person;

public class PersonTest {
    private static final String NAME = "Pesho";
    private static final int ID = 5;

    private Person person;

    @Before
    public void createPerson() {
        this.person = new Person(ID, NAME);
    }

    @Test
    public void tryToGetId() {
        Assert.assertEquals(person.getId(),ID);
    }

    @Test
    public void tryGetUsername(){
        Assert.assertEquals(person.getUsername(),NAME);
    }
}
