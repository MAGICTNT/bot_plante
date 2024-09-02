package fr.maxime.enums;

public enum GlobalVariable {

    LINK_CSV_CULTIVE("src/main/java/org/example/src/csv/cultive.csv"),
    LINK_CSV_PLANTES("src/main/java/org/example/src/csv/plantes.csv"),
    LINK_CSV_PERSONNES("src/main/java/org/example/src/csv/personnes.csv");

    private String value;
    GlobalVariable(String s){
        this.value = s;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
