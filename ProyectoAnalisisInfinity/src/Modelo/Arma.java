
package Modelo;

import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Arma
{
    private int codigo;
    private String nombre;
    private int daño;
    private List<Image> imagen;
    private int duracionArma;

    public Arma()
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

    public int getDaño()
    {
        return daño;
    }

    public void setDaño(int daño)
    {
        this.daño = daño;
    }

    public List<Image> getImagen()
    {
        return imagen;
    }

    public void setImagen(List<Image> imagen)
    {
        this.imagen = imagen;
    }

    public int getDuracionArma()
    {
        return duracionArma;
    }

    public void setDuracionArma(int duracionArma)
    {
        this.duracionArma = duracionArma;
    }

    
    
    
}
