import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testMain() {
        // No es común probar el método main directamente, pero puedes probar la lógica subyacente
        Greeting greeting = new Greeting();
        Farewell farewell = new Farewell();
        Bye bye = new Bye();

        assertEquals("Hello, World!", greeting.getMessage());
        assertEquals("Goodbye, World!", farewell.getMessage());
        assertEquals("Bye, Bye!", bye.getMessage());
    }
}