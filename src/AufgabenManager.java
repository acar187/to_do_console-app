import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class AufgabenManager {
    private List<Benutzer> benutzerListe = new ArrayList<>();

    public void benutzerHinzufuegen(String name){
        int id = benutzerListe.size()+1;
        Benutzer b = new Benutzer(name, id);
        benutzerListe.add(b);
        System.out.println("Benutzer " + b.getName() + " hinzugefügt");
    }

    public void aufgabeHinzufuegenFuerBenutzer(int benutzerId, String aufgabeBeschreibung){
        Benutzer b = findeBenutzerNachId(benutzerId);
        if (b != null) {
            b.aufgabeHinzufügen(aufgabeBeschreibung);            
        }
        else{
            System.out.println("Benutzer nicht gefunden.");
        }

    }

    public void aufgabeAlsErledigtMarkierenFuerBenutzer(int benutzerId, int aufgabeIndex){
        Benutzer b = findeBenutzerNachId(benutzerId);
        if (b != null) {
            b.aufgabeAlsErledigtMarkieren(aufgabeIndex);
        }
        else{
            System.out.println("Benutzer nicht gefunden");
        }   
    }

    public void benutzerListeAnzeigen(){
        for (int i = 0; i < benutzerListe.size(); i++) {
            System.out.println(" - " + benutzerListe.get(i).getName() + ", ID: " + benutzerListe.get(i).getId());   
            benutzerListe.get(i).aufagbenListeAnzeige();         
        }
    }

    private Benutzer findeBenutzerNachId(int Id){
        for (Benutzer benutzer : benutzerListe) {
            if (benutzer.getId()==Id) { 
                return benutzer;
            }
        }
        return null;
    }

    public void speichernAlsText(String dateiname){
        try (PrintWriter pw = new PrintWriter(new FileWriter(dateiname))){
            for (Benutzer benutzer : benutzerListe) {
                pw.println("Benutzer;" + benutzer.getId() + ";" + benutzer.getName());
                for (Aufgabe a : benutzer.getAufagbenListe()) {
                    pw.println("Aufgabe;" + a.getBeschreibung() + ";" + a.isErledigt());
                }
            }
            System.out.println("Gespeichert in " + dateiname);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }



    //// TO IMPLEMENT
    public void ladenAusTextDatei(String dateiname){
        benutzerListe.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
            String zeile;
            Benutzer aktuellerBenutzer = null;

            while ((zeile = reader.readLine()) != null) {
                String[] teile =  zeile.split(";");
                if (teile[0].equals("Benutzer")) {
                    String name = teile[2];
                    int Id = Integer.valueOf(teile[1]);
                    aktuellerBenutzer = new Benutzer(name, Id);
                    benutzerListe.add(aktuellerBenutzer);                
                }else{
                    if (teile[0].equals("Aufgabe") && aktuellerBenutzer !=null) {
                        String beschreibung = teile[1];
                        boolean isErledigt = Boolean.valueOf(teile[2]);
                        Aufgabe a = new Aufgabe(beschreibung);
                        a.setErledigt(isErledigt);
                        aktuellerBenutzer.getAufagbenListe().add(a);
                    }
                }
            }
            System.out.println("Daten aus " + dateiname + " geladen");
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Fehler beim Laden: " + e.getMessage());
        }
    }


}
