package Modelo;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Costo {

    private int zero;
    private int iridio;
    private int paladio;
    private int platino;

    public Costo(int zero, int iridio, int paladio, int platino) {
        this.zero = zero;
        this.iridio = iridio;
        this.paladio = paladio;
        this.platino = platino;
    }

    /**
     * @return the zero
     */
    public int getZero() {
        return zero;
    }

    /**
     * @return the iridio
     */
    public int getIridio() {
        return iridio;
    }

    /**
     * @return the paladio
     */
    public int getPaladio() {
        return paladio;
    }

    /**
     * @return the platino
     */
    public int getPlatino() {
        return platino;
    }

   
}
