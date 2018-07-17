
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
    private boolean enemigos;
    private List<Nodo> adyacencias;
    private List<Planeta> listaPlanetas;
    private String imagen;
    private double posicionX;
    private double posicionY;
    private boolean teletransportador;

    public SistemaPlanetario() {
        this.adyacencias = new LinkedList<>();
        this.listaPlanetas = new LinkedList<>();
    }

    public SistemaPlanetario(int codigo, String nombre, Boolean enemigo, double posicionX, double posicionY, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = false;
        this.enemigos = enemigo;
        this.adyacencias = new LinkedList<>();
        this.listaPlanetas = new LinkedList<>();
        this.imagen = imagen;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.teletransportador = false;
    }
    
    

    public SistemaPlanetario(int codigo, String nombre, boolean visitado, Boolean enemigo, List<Nodo> adyacencias, List<Planeta> listaPlanetas, double posicionX, double posicionY, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.visitado = visitado;
        this.enemigos = enemigo;
        this.adyacencias = adyacencias;
        this.listaPlanetas = listaPlanetas;
        this.imagen = imagen;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.teletransportador = false;
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
    public Boolean getEnemigos() {
        return isEnemigos();
    }

    /**
     * @param enemigo   the enemigos to set
     */
    public void setEnemigos(Boolean enemigo) {
        this.setEnemigos((boolean) enemigo);
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

    /**
     * @return the enemigos
     */
    public boolean isEnemigos() {
        return enemigos;
    }

    /**
     * @param enemigos the enemigos to set
     */
    public void setEnemigos(boolean enemigos) {
        this.enemigos = enemigos;
    }

    /**
     * @return the teletransportador
     */
    public boolean isTeletransportador() {
        return teletransportador;
    }

    /**
     * @param teletransportador the teletransportador to set
     */
    public void setTeletransportador(boolean teletransportador) {
        this.teletransportador = teletransportador;
    }

    
}
