package test.com.zachdean;

import main.com.zachdean.EncryptionMachine;
import org.junit.experimental.theories.*;
import org.junit.jupiter.api.*;
import org.junit.runner.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Theories.class)
public class EncryptionMachineTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DataPoints
    public static String[][] data() {
        return new String[][]{
                {"play", "sodb"},
                {"csci", "fvfl"},
                {"hello", "khoor"},
                {"world", "zruog"},
        };
    }

    @Theory
    public void encryptStringSimpleInput(String[] dataSet) {
        var encryptedString = EncryptionMachine.encryptWord(dataSet[0]);
        assertEquals(dataSet[1], encryptedString);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}