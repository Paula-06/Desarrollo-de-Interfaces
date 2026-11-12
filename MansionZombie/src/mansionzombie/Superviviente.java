package mansionzombie;

public class Superviviente extends Personaje {

    //Atributos
    public static final int vidaMaxima = 20;
    public static final int curacionBotiquin = 4;
    private boolean tieneBotiquin = false;
    private int armas = 0;
    private int protecciones = 0;

    //Constructor
    public Superviviente() {
        super(vidaMaxima, 4);
    }

    //Metodos especificos
    //Las armas se suman al resultado de la tirada, no al dado
    @Override
    public int atacar() {
        return super.atacar() + armas;
    }

    //Cada proteccion reduce el daño recibido en 1 (nunca por debajo de 0)
    @Override
    public void recibirDaño(int daño) {
        int dañoReducido = daño - protecciones;
        if (dañoReducido < 0) {
            dañoReducido = 0;
        }
        super.recibirDaño(dañoReducido);
    }

    //Curarse con botiquin. Devuelve true si se ha curado
    public boolean curarse() {
        if (!tieneBotiquin) {
            return false;
        }
        setVida(getVida() + curacionBotiquin);
        if (getVida() > vidaMaxima) {
            setVida(vidaMaxima);
        }
        tieneBotiquin = false;
        return true;
    }

    public void añadirArma() {
        armas++;
    }

    public void añadirProteccion() {
        protecciones++;
    }

    public void obtenerBotiquin() {
        tieneBotiquin = true;
    }

    //Getters
    public int getArmas() {
        return armas;
    }

    public int getProtecciones() {
        return protecciones;
    }

    public boolean isTieneBotiquin() {
        return tieneBotiquin;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
}
