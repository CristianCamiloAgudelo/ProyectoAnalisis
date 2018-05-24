package Modelo;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Escudo {

    private int codigo;
    private String descripcion;
    private int vida;
    private List<String> imagenes;
    private int duracionEscudo;
    private boolean activo;

    public Escudo(int codigo, String descripcion, int vida, int duracionEscudo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.vida = vida;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Escudo1.jpg");
        this.duracionEscudo = duracionEscudo;
        this.activo = false;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
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
     * @return the imagenes
     */
    public List<String> getImagenes() {
        return imagenes;
    }

    /**
     * @return the duracionEscudo
     */
    public int getDuracionEscudo() {
        return duracionEscudo;
    }

    /**
     * @param duracionEscudo the duracionEscudo to set
     */
    public void setDuracionEscudo(int duracionEscudo) {
        this.duracionEscudo = duracionEscudo;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
