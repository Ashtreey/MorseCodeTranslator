package logik;

import java.util.HashMap;
import java.util.Map;


public class MorseCodeLogic {
    // Skapa mappar för att lagra översättningar mellan engelska och morsekod
    private static final Map<Character, String> englishToMorse = new HashMap<>();
    private static final Map<String, Character> morseToEnglish = new HashMap<>();

    static {

        
        // Initialisera mappen med engelska bokstäver och deras motsvarande morsekoder
        englishToMorse.put('A', ".-");
        englishToMorse.put('B', "-...");
        englishToMorse.put('C', "-.-.");
        englishToMorse.put('D', "-..");
        englishToMorse.put('E', ".");
        englishToMorse.put('F', "..-.");
        englishToMorse.put('G', "--.");
        englishToMorse.put('H', "....");
        englishToMorse.put('I', "..");
        englishToMorse.put('J', ".---");
        englishToMorse.put('K', "-.-");
        englishToMorse.put('L', ".-..");
        englishToMorse.put('M', "--");
        englishToMorse.put('N', "-.");
        englishToMorse.put('O', "---");
        englishToMorse.put('P', ".--.");
        englishToMorse.put('Q', "--.-");
        englishToMorse.put('R', ".-.");
        englishToMorse.put('S', "...");
        englishToMorse.put('T', "-");
        englishToMorse.put('U', "..-");
        englishToMorse.put('V', "...-");
        englishToMorse.put('W', ".--");
        englishToMorse.put('X', "-..-");
        englishToMorse.put('Y', "-.--");
        englishToMorse.put('Z', "--..");
        englishToMorse.put(' ', "/");

        // Skapa översättningar från morsekod till engelska
        for (Map.Entry<Character, String> entry : englishToMorse.entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }
    }

    // Metod för att konvertera engelska till morsekod
    public static String toMorse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Fältet kan ej vara tomt.");
        }
        text = text.toUpperCase();
        if (text.equals("HELLO WORLD")) {
            playEasterEgg(); // Om texten är "HELLO WORLD", spelas ett påskägg upp
        }
        StringBuilder morse = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (!englishToMorse.containsKey(c)) {
                throw new IllegalArgumentException("Felaktigt tecken: " + c);
            }
            morse.append(englishToMorse.get(c)).append(" ");
        }
        return morse.toString().trim();
    }

    // Metod för att konvertera morsekod till engelska
    public static String toEnglish(String morseCode) {
        if (morseCode == null || morseCode.isEmpty()) {
            throw new IllegalArgumentException("Fältet kan ej vara tomt.");
        }
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split(" ");
        for (String morse : words) {
            if (morse.equals("/")) {
                text.append(" ");
            } else if (!morseToEnglish.containsKey(morse)) {
                throw new IllegalArgumentException("Felaktig morsekod: " + morse);
            } else {
                text.append(morseToEnglish.get(morse));
            }
        }
        return text.toString();
    }

    // Metod för påskägg
    private static void playEasterEgg() {
        try {
            // Öppnar videon i standardwebbläsaren
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.youtube.com/watch?v=2O1YipmOwH8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
