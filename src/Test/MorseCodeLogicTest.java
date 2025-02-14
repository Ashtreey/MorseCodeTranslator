package Test;

import logik.MorseCodeLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// Testklass för MorseCodeLogic
class MorseCodeLogicTest {

    // Test för att översätta engelsk text till Morse-kod
    @Test
    void testToMorse() {
        assertEquals(".... . .-.. .-.. ---", MorseCodeLogic.toMorse("HELLO"));
        assertEquals("-- --- .-. ... .", MorseCodeLogic.toMorse("MORSE"));
    }

    // Test för att hantera ogiltiga inmatningar i toMorse
    @Test
    void testToMorseInvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MorseCodeLogic.toMorse("@"));
        assertEquals("Felaktigt tecken: @", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> MorseCodeLogic.toMorse(""));
        assertEquals("Fältet kan ej vara tomt.", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> MorseCodeLogic.toMorse("123"));
        assertEquals("Felaktigt tecken: 1", exception.getMessage());
    }

    // Test för att översätta Morse-kod till engelsk text
    @Test
    void testToEnglish() {
        assertEquals("HELLO", MorseCodeLogic.toEnglish(".... . .-.. .-.. ---"));
        assertEquals("MORSE", MorseCodeLogic.toEnglish("-- --- .-. ... ."));
    }

    // Test för att hantera ogiltiga inmatningar i toEnglish
    @Test
    void testToEnglishInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> MorseCodeLogic.toEnglish("......"));
        assertThrows(IllegalArgumentException.class, () -> MorseCodeLogic.toEnglish(""));
    }

    // Test för extremt långa strängar
    @Test
    void testLongString() {
        String longText = "A".repeat(1000);
        String longMorse = ".- ".repeat(1000).trim();
        assertEquals(longMorse, MorseCodeLogic.toMorse(longText));
        assertEquals(longText, MorseCodeLogic.toEnglish(longMorse));
    }

    // Test för strängar med endast mellanslag
    @Test
    void testWhitespaceString() {
        assertEquals("/", MorseCodeLogic.toMorse(" "));
        assertEquals(" ", MorseCodeLogic.toEnglish("/"));
    }

    // Test för blandning av stora och små bokstäver
    @Test
    void testMixedCaseString() {
        assertEquals(".... . .-.. .-.. ---", MorseCodeLogic.toMorse("HeLLo"));
    }

    // Test för felaktiga Morse-koder med okänd inmatning
    @Test
    void testInvalidMorseCode() {
        assertThrows(IllegalArgumentException.class, () -> MorseCodeLogic.toEnglish(".--..."));
    }

    // Test för påskägget "HELLO WORLD"
    @Test
    void testHelloWorldEasterEgg() {
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", MorseCodeLogic.toMorse("HELLO WORLD"));
    }
    // Test för att se så "/" tolkas som mellanslag
    @Test
    void testToMorseWhitespaceOnly() {
        assertEquals("/ / /", MorseCodeLogic.toMorse("   "));
    }
}

