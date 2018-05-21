
package Modelo;

import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */

public class Enemigo
{
    private int codigo;
    private String nombre;
    private int vida;
    private int daño;
    private int posicionX;
    private int posicionY;
    private List<Image> imagen;
    private String tipoEnemigo;

    public Enemigo()
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

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getDaño()
    {
        return daño;
    }

    public void setDaño(int daño)
    {
        this.daño = daño;
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

    public List<Image> getImagen()
    {
        return imagen;
    }

    public void setImagen(List<Image> imagen)
    {
        this.imagen = imagen;
    }

    public String getTipoEnemigo()
    {
        return tipoEnemigo;
    }

    public void setTipoEnemigo(String tipoEnemigo)
    {
        this.tipoEnemigo = tipoEnemigo;
    }

    
    
}
