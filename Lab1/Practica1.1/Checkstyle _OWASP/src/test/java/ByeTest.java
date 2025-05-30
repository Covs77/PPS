import org.junit.Test;
import static org.junit.Assert.*;

public class ByeTest {
    @Test
    public void testGetMessage() {
        Bye bye = new Bye();
        assertEquals("Bye, Bye!", bye.getMessage());
    }
}