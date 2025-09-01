import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AufgabenManager manager = new AufgabenManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n===== Aufgaben-Manager =====");
            System.out.println("1. Benutzer hinzufügen");
            System.out.println("2. Aufgabe für Benutzer hinzufügen");
            System.out.println("3. Aufgabe als erledigt markieren");
            System.out.println("4. Alle Benutzer und Aufgaben anzeigen");
            System.out.println("5. Speichern in Datei");
            System.out.println("6. Laden aus Datei");
            System.out.println("0. Beenden");
            System.out.print("Wahl: ");

            int wahl = scanner.nextInt();
            scanner.nextLine(); // Eingabe-Puffer leeren

            switch (wahl) {
                case 1 -> {
                    System.out.print("Name des Benutzers: ");
                    String name = scanner.nextLine();
                    manager.benutzerHinzufuegen(name);
                }
                case 2 -> {
                    System.out.print("Benutzer-ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Aufgabenbeschreibung: ");
                    String beschreibung = scanner.nextLine();
                    manager.aufgabeHinzufuegenFuerBenutzer(id, beschreibung);
                }
                case 3 -> {
                    System.out.print("Benutzer-ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Aufgabe-Index (1..n): ");
                    int index = scanner.nextInt() - 1; // -1 da Liste bei 0 startet
                    manager.aufgabeAlsErledigtMarkierenFuerBenutzer(id, index);
                }
                case 4 -> manager.benutzerListeAnzeigen();
                case 5 -> {
                    manager.speichernAlsText("toDoList.txt");
                }
                case 6 -> {
                    manager.ladenAusTextDatei("toDoList.txt");
                }
                case 0 -> {
                    running = false;
                    System.out.println("Programm beendet.");
                }
                default -> System.out.println("Ungültige Eingabe!");
            }
        }

        scanner.close();
    }
}