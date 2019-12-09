import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final int OVER_MAX_CAPACITY = 20;
    private static final int CONSTANT_TO_ADD = 33;
    private static final Integer[] INPUT_DATA = {1, 2, 3, 4, 5, 6};

    private Database db;

    public DatabaseTest() throws OperationNotSupportedException {
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfCapacityIs16() throws OperationNotSupportedException {
        Integer[] data = new Integer[OVER_MAX_CAPACITY];
        this.db = new Database(data);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void cantCreateEmptyDatabase() throws OperationNotSupportedException {
        this.db = new Database();
    }


    @Test
    public void addingInNextFreePosition() throws OperationNotSupportedException {
        db = new Database(INPUT_DATA);
        db.add(CONSTANT_TO_ADD);
        Assert.assertEquals(db.getElements().length, INPUT_DATA.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void cantAddEmptyElement() throws OperationNotSupportedException {
        db = new Database(INPUT_DATA);
        db.add(null);
    }

    @Test
    public void removeMustDeleteTheLastElement() throws OperationNotSupportedException {
        db = new Database(INPUT_DATA);
        db.add(CONSTANT_TO_ADD);
        db.remove();
        Assert.assertArrayEquals(INPUT_DATA,db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void cantRemoveFromEmptyArray() throws OperationNotSupportedException {
        db = new Database(CONSTANT_TO_ADD);
        db.remove();
        db.remove();
    }
}
