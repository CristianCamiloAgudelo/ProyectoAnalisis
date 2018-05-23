
package Modelo;
import Grafo.*;
import java.awt.Image;
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
    //private Grafo planetas;
    private List<Nodo> adyacencias;
    private List<Planeta> listaPlanetas;
    private List<Image> imagen;
    private int posicionX;
    private int posicionY;

    public SistemaPlanetario()
    {
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public boolean isVisitado()
    {
        return visitado;
    }

    public void setVisitado(boolean visitado)
    {
        this.visitado = visitado;
    }

    public List<Enemigo> getEnemigos()
    {
        return enemigos;
    }

    public void setEnemigos(List<Enemigo> enemigos)
    {
        this.enemigos = enemigos;
    }

//    public Grafo getPlanetas()
//    {
//        return planetas;
//    }
//
//    public void setPlanetas(Grafo planetas)
//    {
//        this.planetas = planetas;
//    }

    public List<Image> getImagen()
    {
        return imagen;
    }

    public void setImagen(List<Image> imagen)
    {
        this.imagen = imagen;
    }

    public int getPosicionX()
    {
        return posicionX;
    }

    public void setPosicionX(int posicionX)
    {
        this.posicionX = posicionX;
    }

    public int getPosicionY()
    {
        return posicionY;
    }

    public void setPosicionY(int posicionY)
    {
        this.posicionY = posicionY;
    }

    public List<Nodo> getAdyacencias()
    {
        return adyacencias;
    }

    public void setAdyacencias(List<Nodo> adyacencias)
    {
        this.adyacencias = adyacencias;
    }

    public List<Planeta> getListaPlanetas()
    {
        return listaPlanetas;
    }

    public void setListaPlanetas(List<Planeta> listaPlanetas)
    {
        this.listaPlanetas = listaPlanetas;
    }
    
    
}
