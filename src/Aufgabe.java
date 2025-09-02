public class Aufgabe {

    private String beschreibung;
    private boolean erledigt;
    private String prioritaet;  //"hoch", "mittel", "niedrig"

    public Aufgabe(String beschreibung, String prioritaet){
        this.beschreibung = beschreibung;
        this.erledigt = false;
        this.prioritaet = prioritaet;
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

    public String getPrioritaet() {
        return prioritaet;
    }

    public int getPrioritaetsWert(){
        return switch (prioritaet.toLowerCase()){
            case "hoch" -> 3;
            case "mittel" -> 2;
            case "niedrig" -> 1;
            default -> 0;        
        };
    }

    @Override
    public String toString() {
        return "Aufgabebeschreibung: " + beschreibung + " ["+ prioritaet + "] " + ": " + (erledigt ? "[DONE]": "[   ]");
    }
}