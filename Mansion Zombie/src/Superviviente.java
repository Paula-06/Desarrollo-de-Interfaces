public class Superviviente extends Personaje {

    //Atributos
    public static final int vidaMaxima = 20; //Constante para que todos puedan ver que es maximo de 20 y final porque debe ser maximo de 20, fijo
    private boolean tieneBotiquin = true;
    private int armas = 0;
    private int protecciones = 0;

    //Constructor
    public Superviviente() {
        super(20, 4); //Maximo de vida y daño
    }

    //Curarse con botiquin
    boolean curarse() {
        if (!tieneBotiquin) {
            return false;
        }

        setVida(getVida() + 4);

        if (getVida() > vidaMaxima) {
            setVida(vidaMaxima);
        }

        tieneBotiquin = false;
        return false;
    }

    void añadirArma() {
        armas++;
    }

    void añadirProteccion() {
        protecciones++;
    }

    void obtenerBotiquin() {
        tieneBotiquin = true;
    }


    //Getters
    int getArmas() {
        return armas;
    }

    int getProtecciones() {
        return protecciones;
    }

    boolean isTieneBotiquin() {
        return tieneBotiquin;
    }

    int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setTieneBotiquin(boolean tieneBotiquin) {
        this.tieneBotiquin = tieneBotiquin;
    }

}
