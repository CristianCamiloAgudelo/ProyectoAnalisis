package Modelo;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Arma {

    private int codigo;
    private String descripcion;
    private int daño;
    private List<String> imagenes;
    private int duracionArma;

    public Arma(int codigo, String descripcion, int daño, int duracionArma) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.daño = daño;
        this.imagenes = new LinkedList<>();
        this.duracionArma = duracionArma;
    }

    /**
     * @return the daño
     */
    public int getDaño() {
        return daño;
    }

    /**
     * @return the imagen
     */
    public List<String> getImagen() {
        return imagenes;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(List<String> imagen) {
        this.imagenes = imagen;
    }

    /**
     * @return the duracionArma
     */
    public int getDuracionArma() {
        return duracionArma;
    }

 
}
