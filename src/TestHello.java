import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


import java.io.*;

public class TestHello {

    public static void main(String[] args) {
        testHelloWorld();
    }

    @Test
    public static void testHelloWorld()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Hello.main(null);

        // assertion
        try {
            assertEquals("Hello world!\n", bos.toString());
            System.setOut(originalOut);
            System.out.println("Test passed!");
        }
        catch(AssertionError e) {
            System.setOut(originalOut);
            System.out.println("Test failed. Program did not output \"Hello world!\"");
        }

        // undo the binding in System
    }
}
