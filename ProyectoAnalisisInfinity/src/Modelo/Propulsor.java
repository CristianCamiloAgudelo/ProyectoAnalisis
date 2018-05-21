
package Modelo;

import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Propulsor
{
    private int codigo;
    private String nombre;
    private int velocidad;
    private List<Image> imagen;
    private int duracionPropulsor;  

    public Propulsor()
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

    public int getVelocidad()
    {
        return velocidad;
    }

    public void setVelocidad(int velocidad)
    {
        this.velocidad = velocidad;
    }

    public List<Image> getImagen()
    {
        return imagen;
    }

    public void setImagen(List<Image> imagen)
    {
        this.imagen = imagen;
    }

    public int getDuracionPropulsor()
    {
        return duracionPropulsor;
    }

    public void setDuracionPropulsor(int duracionPropulsor)
    {
        this.duracionPropulsor = duracionPropulsor;
    }
    
    
}
