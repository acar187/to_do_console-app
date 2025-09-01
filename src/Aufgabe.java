public class Aufgabe {

    private String beschreibung;
    private boolean erledigt;

    public Aufgabe(String beschreibung){
        this.beschreibung = beschreibung;
        this.erledigt = false;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    @Override
    public String toString() {
        return "Aufgabebeschreibung: " + beschreibung + ": " + (erledigt ? "[DONE]": "[   ]");
    }
}