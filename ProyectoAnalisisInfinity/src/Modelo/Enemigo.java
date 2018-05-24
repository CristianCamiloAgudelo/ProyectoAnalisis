package Modelo;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Enemigo {

    private int codigo;
    private String descripcion;
    private int vida;
    private int daño;
    private int posicionX;
    private int posicionY;
    private List<String> imagenes;
    private String tipoEnemigo;

    public Enemigo(int codigo, String descripcion, int vida, int daño, String tipoEnemigo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.vida = vida;
        this.daño = daño;
        this.posicionX = 0;
        this.posicionY = 0;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Imagenes/EnemigoClaseA.png");
        this.imagenes.add("src/Imagenes/EnemigoClaseB.png");
        this.imagenes.add("src/Imagenes/EnemigoClaseC.png");
        this.tipoEnemigo = tipoEnemigo;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the daño
     */
    public int getDaño() {
        return daño;
    }

    /**
     * @return the posicionX
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * @param posicionX the posicionX to set
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * @return the posicionY
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * @param posicionY the posicionY to set
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * @return the imagenes
     */
    public List<String> getImagenes() {
        return imagenes;
    }

    /**
     * @return the tipoEnemigo
     */
    public String getTipoEnemigo() {
        return tipoEnemigo;
    }
 
}
