package main;

import logik.MorseCodeLogic;
import java.util.Scanner;

// Huvudklass som hanterar användarens inmatning och utdata
public class MorseCodeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Skapar en scanner för att läsa användarens inmatning
        boolean exit = false; // Variabel för att hålla koll på om användaren vill avsluta

        while (!exit) {
            // Användaren kan välja mellan tre alternativ
            System.out.println("Välj: 1 för text till Morse, 2 för Morse till text, 3 för att avsluta");
            int choice = scanner.nextInt(); // Läser användarens val
            scanner.nextLine(); // Rensar scanner

            if (choice == 1) {
                // Hanterar översättning från text till Morse-kod
                System.out.println("Skriv in text:");
                String text = scanner.nextLine(); // Läser användarens text
                String morse = MorseCodeLogic.toMorse(text); // Översätter texten till Morse-kod
                System.out.println("Morse kod: " + morse); // Skriver ut Morse-koden
            } else if (choice == 2) {
                // Hanterar översättning från Morse-kod till text
                System.out.println("Skriv in morsekod:");
                String morse = scanner.nextLine(); // Läser användarens Morse-kod
                String text = MorseCodeLogic.toEnglish(morse); // Översätter Morse-koden till text
                System.out.println("Översatt text: " + text); // Skriver ut översättningen
            } else if (choice == 3) {
                // Avslutar programmet
                exit = true; // Ändrar exit-variabeln till true för att avsluta loopen
                System.out.println("Avslutar programmet.");
            } else {
                // Hanterar ogiltiga val
                System.out.println("Ogiltigt val."); // Skriver ut felmeddelande
            }
        }
        scanner.close(); // Stänger scannern när programmet avslutas
    }
}
