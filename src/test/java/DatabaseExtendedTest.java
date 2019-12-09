import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedTest {
    private static final String[] NAME = {"A", "B", "C", "D", "E"};
    private static final int ID = 5;

    private Database db;
    private Person[] people;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.people = new Person[5];
        for (int i = 0; i < 5; i++) {
            people[i] = new Person(i + 1, NAME[i]);
        }

        this.db = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void maxCapacityOfDatabase() throws OperationNotSupportedException {
        people = new Person[18];
        Database db = new Database(people);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void addEmptyUser() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifDuplicatedMustThrowException() throws OperationNotSupportedException {
        this.db.add(new Person(3, "V"));
        Assert.assertEquals(db.findById(3).getUsername(), "C");
    }

    @Test
    public void findByName() throws OperationNotSupportedException {
        int id = db.findByUsername("B").getId();
        Assert.assertEquals(id, 2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByEmptyName() throws OperationNotSupportedException {
       db.findByUsername(null);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenThereIsMoreThanOneUsernameWithTheSameNamefindByName() throws OperationNotSupportedException {
       db.add(new Person(15,"A"));
        db.findByUsername("A");

    }


    @Test
    public void findById() throws OperationNotSupportedException {
        String user = db.findById(2).getUsername();
        Assert.assertEquals(user, "B");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeUntilEmpty() throws OperationNotSupportedException {
        this.db.remove();
        this.db.remove();
        this.db.remove();
        this.db.remove();
        this.db.remove();
        this.db.remove();
    }

    @Test
    public void returnCorrectDatabase() {
        Assert.assertArrayEquals(db.getElements(), people);
    }
}
