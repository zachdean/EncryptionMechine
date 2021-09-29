package test.com.zachdean;

import main.com.zachdean.EncryptionMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionMachineTest {
    @Test
    void encryptStringSimpleInput(){
        var encryptedString = EncryptionMachine.encryptWord("play");
        assertEquals("sodb", encryptedString);
    }


}