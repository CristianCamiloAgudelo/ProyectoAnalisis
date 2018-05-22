
package Modelo;

import Grafo.*;
import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Nebulosa
{
    private int codigo;
    private String nombre;
    private boolean enemigo;
    private boolean visitado;
    private Grafo sistemaPlanetario;
    private List<Image> imagen;
    private int posicionX;
    private int posicionY;

    public Nebulosa()
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

    public boolean isEnemigo()
    {
        return enemigo;
    }

    public void setEnemigo(boolean enemigo)
    {
        this.enemigo = enemigo;
    }

    public boolean isVisitado()
    {
        return visitado;
    }

    public void setVisitado(boolean visitado)
    {
        this.visitado = visitado;
    }

    public Grafo getSistemaPlanetario()
    {
        return sistemaPlanetario;
    }

    public void setSistemaPlanetario(Grafo sistemaPlanetario)
    {
        this.sistemaPlanetario = sistemaPlanetario;
    }

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
    
    
    
}
