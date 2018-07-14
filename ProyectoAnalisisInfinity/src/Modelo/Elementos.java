package Modelo;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Elementos {

    private int zero;
    private int iridio;
    private int paladio;
    private int platino;

    public Elementos() {
    }

    public Elementos(int zero, int iridio, int paladio, int platino) {
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

    /**
     * @param zero the zero to set
     */
    public void setZero(int zero) {
        this.zero = zero;
    }

    /**
     * @param iridio the iridio to set
     */
    public void setIridio(int iridio) {
        this.iridio = iridio;
    }

    /**
     * @param paladio the paladio to set
     */
    public void setPaladio(int paladio) {
        this.paladio = paladio;
    }

    /**
     * @param platino the platino to set
     */
    public void setPlatino(int platino) {
        this.platino = platino;
    }

}
