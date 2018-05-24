
package Modelo;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class SistemaPlanetario
{
    private int codigo;
    private String nombre;
    private boolean visitado;
    private List<Enemigo> enemigos;
    private List<Nodo> adyacencias;
    private List<Planeta> listaPlanetas;
    private List<String> imagenes;
    private int posicionX;
    private int posicionY;

    public SistemaPlanetario(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = false;
        this.enemigos = new LinkedList<>();
        this.adyacencias = new LinkedList<>();
        this.listaPlanetas = new LinkedList<>();
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Sistema1");
        this.imagenes.add("src/Vistas/Sistema2");
        this.imagenes.add("src/Vistas/Sistema3");
        this.posicionX = 0;
        this.posicionY = 0;
    }
    
    

    public SistemaPlanetario(int codigo, String nombre, boolean visitado, List<Enemigo> enemigos, List<Nodo> adyacencias, List<Planeta> listaPlanetas, int posicionX, int posicionY) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = visitado;
        this.enemigos = enemigos;
        this.adyacencias = adyacencias;
        this.listaPlanetas = listaPlanetas;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("src/Vistas/Sistema1");
        this.imagenes.add("src/Vistas/Sistema2");
        this.imagenes.add("src/Vistas/Sistema3");
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
     * @return the enemigos
     */
    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    /**
     * @param enemigos the enemigos to set
     */
    public void setEnemigos(List<Enemigo> enemigos) {
        this.enemigos = enemigos;
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
     * @return the listaPlanetas
     */
    public List<Planeta> getListaPlanetas() {
        return listaPlanetas;
    }

    /**
     * @param listaPlanetas the listaPlanetas to set
     */
    public void setListaPlanetas(List<Planeta> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
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

    
}
