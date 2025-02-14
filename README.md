Projektet består av tre klasser som tillsammans hanterar översättningar mellan engelsk text och Morse-kod, samt utför testning för att säkerställa korrekt funktionalitet.
1.	MorseCodeMain-klassen:
o	main-metoden: Startpunkten för programmet. Skapar en scanner för användarinmatning och en loop som gör det möjligt för användaren att välja mellan tre alternativ: översätta text till Morse-kod, översätta Morse-kod till text eller avsluta programmet.
o	Användarinteraktion: Beroende på användarens val, läser programmet in text eller Morse-kod och använder metoder från MorseCodeLogic-klassen för översättningen. Programmet hanterar även ogiltiga val.
2.	MorseCodeLogic-klassen:
o	englishToMorse och morseToEnglish: Två HashMaps som lagrar översättningar mellan engelska bokstäver och Morse-kod.
o	toMorse-metoden: Konverterar engelsk text till Morse-kod och hanterar ogiltiga tecken. Innehåller även ett påskägg som aktiveras vid texten "HELLO WORLD".
o	toEnglish-metoden: Konverterar Morse-kod till engelsk text och hanterar ogiltiga Morse-koder.
o	playEasterEgg-metoden: Öppnar en YouTube-video i standardwebbläsaren som en del av påskägget.
3.	MorseCodeLogicTest-klassen:
o	Testmetoder: Innehåller en rad testmetoder som verifierar korrekt funktionalitet i MorseCodeLogic-klassen, inklusive tester för giltiga och ogiltiga inmatningar, långsträngshantering, mellanslag och blandade versaler och gemener.
