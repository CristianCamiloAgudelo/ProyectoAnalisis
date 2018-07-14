package Modelo;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Propulsor {

    private int codigo;
    private String nombre;
    private int velocidad;
    private List<String> imagenes;
    private int duracionPropulsor;
    private boolean activo;

    public Propulsor() {
    }

    public Propulsor(int codigo, String nombre, int velocidad, int duracionPropulsor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/propulsor1");
        this.imagenes.add("src/Vistas/propulsor2");
        this.imagenes.add("src/Vistas/propulsor3");
        this.duracionPropulsor = duracionPropulsor;
        this.activo = false;
    }

    public Propulsor(int codigo, String nombre, int velocidad, int duracionPropulsor, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/propulsor1");
        this.imagenes.add("src/Vistas/propulsor2");
        this.imagenes.add("src/Vistas/propulsor3");
        this.duracionPropulsor = duracionPropulsor;
        this.activo = activo;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @return the imagenes
     */
    public List<String> getImagenes() {
        return imagenes;
    }

    /**
     * @return the duracionPropulsor
     */
    public int getDuracionPropulsor() {
        return duracionPropulsor;
    }

    /**
     * @param duracionPropulsor the duracionPropulsor to set
     */
    public void setDuracionPropulsor(int duracionPropulsor) {
        this.duracionPropulsor = duracionPropulsor;
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
