package main;

import logik.MorseCodeLogic;
import java.util.Scanner;

// Huvudklass som hanterar användarens inmatning och utdata
public class MorseCodeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Skapar en scanner för att läsa användarens inmatning
        boolean exit = false; // Variabel för att hålla koll på om användaren vill avsluta

        // Huvudloop som kör programmet tills användaren väljer att avsluta
        while (!exit) {
            int choice = getUserChoice(scanner); // Anropar metod för att få användarens val

            // Switch-sats som hanterar användarens val
            switch (choice) {
                case 1:
                    convertTextToMorse(scanner); // Anropar metod för att konvertera text till Morse-kod
                    break;
                case 2:
                    convertMorseToText(scanner); // Anropar metod för att konvertera Morse-kod till text
                    break;
                case 3:
                    exit = true; // Sätter exit till true för att avsluta loopen
                    System.out.println("Avslutar programmet.");
                    break;
                default:
                    System.out.println("Ogiltigt val."); // Hanterar ogiltiga val
                    break;
            }
        }
        scanner.close(); // Stänger scannern när programmet avslutas
    }

    // Metod för att få användarens val
    private static int getUserChoice(Scanner scanner) {
        System.out.println("Välj: 1 för text till Morse, 2 för Morse till text, 3 för att avsluta");
        while (!scanner.hasNextInt()) { // Säkerställer att användaren anger en siffra
            System.out.println("Ogiltigt val. Vänligen ange en siffra.");
            scanner.next(); // Rensar felaktig inmatning
        }
        return scanner.nextInt(); // Returnerar användarens val
    }

    // Metod för att konvertera text till Morse-kod
    private static void convertTextToMorse(Scanner scanner) {
        System.out.println("Skriv in text:");
        scanner.nextLine(); // Rensar scanner
        String text = scanner.nextLine(); // Läser in användarens text
        try {
            String morse = MorseCodeLogic.toMorse(text); // Översätter text till Morse-kod
            System.out.println("Morse kod: " + morse); // Skriver ut Morse-koden
        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage()); // Skriver ut felmeddelande vid ogiltig inmatning
            System.out.println("Försök igen.");
        }
    }

    // Metod för att konvertera Morse-kod till text
    private static void convertMorseToText(Scanner scanner) {
        System.out.println("Skriv in morsekod:");
        scanner.nextLine(); // Rensar scanner
        String morse = scanner.nextLine(); // Läser in användarens Morse-kod
        try {
            String text = MorseCodeLogic.toEnglish(morse); // Översätter Morse-kod till text
            System.out.println("Översatt text: " + text); // Skriver ut den översatta texten
        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage()); // Skriver ut felmeddelande vid ogiltig inmatning
            System.out.println("Försök igen.");
        }
    }
}
