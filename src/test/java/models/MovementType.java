package models;

public enum MovementType {

    DESPESA("Despesa"),
    RECEITA("Receita");

    private final String text;

    MovementType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
