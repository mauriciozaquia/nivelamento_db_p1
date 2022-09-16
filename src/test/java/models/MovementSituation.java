package models;

public enum MovementSituation {

    PAGO("Pago"),
    PENDENTE("Pendente");

    private final String text;

    MovementSituation(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
