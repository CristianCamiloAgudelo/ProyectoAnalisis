package Modelo;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Nebulosa {

    private int codigo;
    private String nombre;
    private boolean enemigo;
    private boolean visitado;
    private List<Nodo> adyacencias;
    private List<SistemaPlanetario> listaSistemasPlanetarios;
    private List<String> imagenes;
    private double posicionX;
    private double posicionY;

    public Nebulosa(int codigo, String nombre, boolean enemigo, double posicionX, double posicionY) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.enemigo = enemigo;
        this.visitado = false;
        this.adyacencias = new LinkedList<>();
        this.listaSistemasPlanetarios = new LinkedList<>();
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Nebulosa1");
        this.imagenes.add("src/Vistas/Nebulosa2");
        this.imagenes.add("src/Vistas/Nebulosa3");
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Nebulosa(int codigo, String nombre, boolean enemigo, boolean visitado, List<Nodo> adyacencias, List<SistemaPlanetario> listaSistemasPlanetarios, double posicionX, double posicionY) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.enemigo = enemigo;
        this.visitado = visitado;
        this.adyacencias = adyacencias;
        this.listaSistemasPlanetarios = listaSistemasPlanetarios;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Nebulosa1");
        this.imagenes.add("src/Vistas/Nebulosa2");
        this.imagenes.add("src/Vistas/Nebulosa3");
        this.posicionX = posicionX;
        this.posicionY = posicionY;
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
     * @return the enemigo
     */
    public boolean isEnemigo() {
        return enemigo;
    }

    /**
     * @param enemigo the enemigo to set
     */
    public void setEnemigo(boolean enemigo) {
        this.enemigo = enemigo;
    }

    /**
     * @return the visitado
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     * @param visitado the visitado to set
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * @return the adyacencias
     */
    public List<Nodo> getAdyacencias() {
        return adyacencias;
    }

    /**
     * @param adyacencias the adyacencias to set
     */
    public void setAdyacencias(List<Nodo> adyacencias) {
        this.adyacencias = adyacencias;
    }

    /**
     * @return the listaSistemasPlanetarios
     */
    public List<SistemaPlanetario> getListaSistemasPlanetarios() {
        return listaSistemasPlanetarios;
    }

    /**
     * @param listaSistemasPlanetarios the listaSistemasPlanetarios to set
     */
    public void setListaSistemasPlanetarios(List<SistemaPlanetario> listaSistemasPlanetarios) {
        this.listaSistemasPlanetarios = listaSistemasPlanetarios;
    }

    /**
     * @return the imagenes
     */
    public List<String> getImagenes() {
        return imagenes;
    }

    /**
     * @return the posicionX
     */
    public double getPosicionX() {
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
    public double getPosicionY() {
        return posicionY;
    }

    /**
     * @param posicionY the posicionY to set
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

}
