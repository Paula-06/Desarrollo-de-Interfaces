package mansionzombie;

public enum Dificultad {
    FACIL(5),
    DIFICIL(10);

    private final int numHabitaciones;

    Dificultad(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }
}
