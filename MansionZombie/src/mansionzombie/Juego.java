package mansionzombie;

public class Juego {

    //Atributos
    private Superviviente superviviente;
    private int habitacionActual;
    private int numMaxHabitaciones;
    private int intentosBusqueda;
    private int zombiesHabitacion;
    private boolean salioDeLaMansion;

    private final Menu menu = new Menu();

    //Metodos
    public void iniciarPartida() {
        Dificultad dificultad = menu.elegirDificultad();
        numMaxHabitaciones = dificultad.getNumHabitaciones();
        superviviente = new Superviviente();
        habitacionActual = 1;
        intentosBusqueda = 3;
        zombiesHabitacion = 1;
        salioDeLaMansion = false;
    }

    //Bucle principal: un turno por vuelta hasta victoria o derrota
    public void jugar() {
        while (!comprobarVictoria() && !comprobarDerrota()) {
            int accion = menu.pedirAccion(superviviente, habitacionActual, numMaxHabitaciones,
                    zombiesHabitacion, intentosBusqueda);
            switch (accion) {
                case 1:
                    combatir();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    pasarHabitacion();
                    break;
                case 4:
                    curarse();
                    break;
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");
        if (comprobarVictoria()) {
            System.out.println("¡VICTORIA! Has salido con vida de la mansión zombie.");
        } else {
            System.out.println("GAMER OVER. Los zombies han acabado contigo.");
        }
    }

    //Genera un zombie: cada atributo = aleatorio(0-1) + 2 + (habitacion-1)
    private Zombie crearZombie() {
        int vida = (Personaje.tirarDado(2) - 1) + 2 + (habitacionActual - 1);
        int ataque = (Personaje.tirarDado(2) - 1) + 2 + (habitacionActual - 1);
        return new Zombie(vida, ataque);
    }

    //Combate contra un solo zombie hasta que muera uno de los dos
    public void combatir() {
        Zombie zombie = crearZombie();
        System.out.println("El zombie tiene " + zombie.getAtaque() + " puntos de ataque.");
        System.out.println("El zombie tiene " + zombie.getVida() + " puntos de vida.");

        int ronda = 1;
        while (superviviente.comprobarVivo() && zombie.comprobarVivo()) {
            System.out.println(">> RONDA: " + ronda);

            int ataqueSuperviviente = superviviente.atacar();
            System.out.println("> El superviviente ataca con valor " + ataqueSuperviviente);
            zombie.recibirDaño(ataqueSuperviviente);

            if (zombie.comprobarVivo()) {
                int ataqueZombie = zombie.atacar();
                System.out.println("> El zombie ataca con valor " + ataqueZombie);
                superviviente.recibirDaño(ataqueZombie);
            }
            ronda++;
        }

        if (!zombie.comprobarVivo()) {
            zombiesHabitacion--;
            System.out.println("Has eliminado al zombie.");
        }
    }

    //Busqueda: siempre gasta un intento
    public void buscar() {
        intentosBusqueda--;
        int tirada = Personaje.tirarDado(100);

        if (tirada <= 75) {
            hacerRuido();
        } else if (tirada <= 90) {
            if (superviviente.isTieneBotiquin()) {
                System.out.println("Has encontrado un botiquín, pero ya llevas uno y no puedes coger otro.");
            } else {
                superviviente.obtenerBotiquin();
                System.out.println("¡Has encontrado un botiquín!");
            }
        } else if (tirada <= 95) {
            superviviente.añadirProteccion();
            System.out.println("¡Has encontrado una protección! (+1)");
        } else {
            superviviente.añadirArma();
            System.out.println("¡Has encontrado un arma! (+1)");
        }
    }

    private void hacerRuido() {
        System.out.println("¡Has hecho ruido!, ¡cuidado!...");
        int tirada = Personaje.tirarDado(100);

        if (tirada <= 40) {
            System.out.println("... por suerte nadie te escucha al otro lado esta vez.");
        } else if (tirada <= 80) {
            zombiesHabitacion += 1;
            System.out.println("... ¡un zombie ha oído el ruido y entra en la habitación!");
        } else {
            zombiesHabitacion += 2;
            System.out.println("... ¡dos zombies han oído el ruido y entran en la habitación!");
        }
    }

    //Avanza de habitacion (la prepara desde cero) o sale de la mansion si era la ultima
    public void pasarHabitacion() {
        if (habitacionActual == numMaxHabitaciones) {
            salioDeLaMansion = true;
        } else {
            habitacionActual++;
            zombiesHabitacion = 1;
            intentosBusqueda = 3;
        }
    }

    public void curarse() {
        if (superviviente.curarse()) {
            System.out.println("Te has curado. Ahora tienes " + superviviente.getVida() + " puntos de vida.");
        }
    }

    public boolean comprobarVictoria() {
        return salioDeLaMansion;
    }

    public boolean comprobarDerrota() {
        return !superviviente.comprobarVivo();
    }
}
