package fr.maxime.enums;

public enum Color {
    NOIR("\u001B[30m"),
    ROUGE("\u001B[31m"),
    VERT("\u001B[32m"),
    JAUNE("\u001B[33m"),
    BLEU("\u001B[34m"),
    MAGENTA("\u001B[35m"), // Corrigé de MAGENTO à MAGENTA
    CYAN("\u001B[36m"),
    BLANC("\u001B[37m"),
    GRIS("\u001B[90m"),
    ROUGE_CLAIR("\u001B[91m"),
    VERT_CLAIR("\u001B[92m"),
    JAUNE_CLAIR("\u001B[93m"),
    BLEU_CLAIR("\u001B[94m"),
    MAGENTA_CLAIR("\u001B[95m"),
    CYAN_CLAIR("\u001B[96m"),
    BLANC_CLAIR("\u001B[97m"),
    REBOOTCOLOR("\u001B[0m");

    private String color;

    Color(String s) {
        this.color = s;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
