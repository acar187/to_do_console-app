import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Benutzer {
    private String name;
    private int id;
    private List<Aufgabe> aufagbenListe = new ArrayList<>();

    public Benutzer(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Aufgabe> getAufagbenListe() {
        return aufagbenListe;
    }

    public void aufgabeHinzufügen(String beschreibung, String prioritaet){
        Aufgabe a = new Aufgabe(beschreibung, prioritaet);
        aufagbenListe.add(a);
        System.out.println("Aufgabe hinzugefügt: " + beschreibung);
    }

    public void aufgabeAlsErledigtMarkieren(int index){
        if (index >= 0 && index < aufagbenListe.size()) {
           aufagbenListe.get(index).setErledigt(true); 
           System.out.println("Aufgabe erledigt: " + aufagbenListe.get(index).getBeschreibung());
        }
        else{
            System.out.println("Ungüliger Aufgaben-Index.");
        } 
    }

    public void aufagbenListeAnzeige(){
        for (int i = 0 ; i < aufagbenListe.size(); i++) {
            System.out.println(i+1 + ". " + aufagbenListe.get(i));
        }
    }

    public Aufgabe aufgabeAnzeigen(int indexAufg){
        return aufagbenListe.get(indexAufg);
    }

    public void zeigeAufgabenInPrio(){
        if (aufagbenListe.isEmpty()) {
            System.out.println("Keine Aufagbe vorhanden.");            
        }else{
            aufagbenListe.stream()
                         .sorted(Comparator.comparing(Aufgabe::isErledigt))
                         .sorted(Comparator.comparingInt(Aufgabe::getPrioritaetsWert).reversed())
                         .forEach(a -> System.out.println("  - " + a));
        }
    }
}
