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
    private Elementos elementos;
    private boolean estacionCombustible;
    private List<Nodo> adyacencias;
    private List<String> imagenes;

    public Planeta(int codigo, String nombre, Elementos elementos, boolean estacionCombustible, List<Nodo> adyacencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = false;
        this.elementos = elementos;
        this.estacionCombustible = estacionCombustible;
        this.adyacencias = adyacencias;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Planeta1");
        this.imagenes.add("src/Vistas/Planeta2");
        this.imagenes.add("src/Vistas/Planeta3");
    }

    public Planeta(int codigo, String nombre, Elementos elementos, boolean estacionCombustible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = false;
        this.elementos = elementos;
        this.estacionCombustible = estacionCombustible;
        this.adyacencias = new LinkedList<>();
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Nebulosa1");
        this.imagenes.add("src/Vistas/Nebulosa2");
        this.imagenes.add("src/Vistas/Nebulosa3");
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
     * @return the imagenes
     */
    public List<String> getImagenes() {
        return imagenes;
    }

}
