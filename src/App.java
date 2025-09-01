public class App {
    public static void main(String[] args) throws Exception {
        // Aufgabe a = new Aufgabe("dog walking");
        // a.setErledigt(true);
        // System.out.println(a);

        // Benutzer b = new Benutzer("Tony", 1);
        // b.aufgabeHinzufügen("walking");
        // b.aufagbenListeAnzeige();

        // b.aufgabeAlsErledigtMarkieren(0);
        // b.aufagbenListeAnzeige();

        AufgabenManager manager = new AufgabenManager();
        manager.benutzerHinzufuegen("Bingoman");
        manager.benutzerListeAnzeigen();
        manager.aufgabeHinzufuegenFuerBenutzer(0, "Eat Pizza");
        manager.aufgabeAlsErledigtMarkierenFuerBenutzer(0, 0);

        
    }
}
