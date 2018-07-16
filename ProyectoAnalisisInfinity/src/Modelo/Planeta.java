package Modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Planeta {

    private int codigo;
    private String nombre;
    private boolean visitado;
    private boolean exprorable;
    private Elementos elementos;
    private boolean estacionCombustible;
    private List<Nodo> adyacencias;
    private String imagen;
    private double posicionX;
    private double posicionY;

    public Planeta() {
    this.adyacencias = new LinkedList<>();
    }

    public Planeta(int codigo, String nombre, Elementos elementos, boolean estacionCombustible, double posicionX, double posicionY, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = false;
        this.elementos = elementos;
        this.estacionCombustible = estacionCombustible;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.adyacencias = new LinkedList<>();
        this.imagen = imagen;
        this.exprorable = true;
    }

    public Planeta(int codigo, String nombre, Elementos elementos, boolean estacionCombustible, List<Nodo> adyacencias, double posicionX, double posicionY, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = false;
        this.elementos = elementos;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estacionCombustible = estacionCombustible;
        this.adyacencias = adyacencias;
        this.imagen = imagen;
        this.exprorable = true;
        
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
     * @return the elementos
     */
    public Elementos getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(Elementos elementos) {
        this.elementos = elementos;
    }

    /**
     * @return the estacionCombustible
     */
    public boolean isEstacionCombustible() {
        return estacionCombustible;
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
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
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
    public void setPosicionX(double posicionX) {
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
    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * @return the exprorable
     */
    public boolean isExprorable() {
        return exprorable;
    }

    /**
     * @param exprorable the exprorable to set
     */
    public void setExprorable(boolean exprorable) {
        this.exprorable = exprorable;
    }

}
