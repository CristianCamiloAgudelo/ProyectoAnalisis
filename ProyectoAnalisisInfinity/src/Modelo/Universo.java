
package Modelo;
import Grafo.*;
import java.awt.Image;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Universo
{
    private String Nombre;
    private Grafo Nebulosa;
    private Image imagen;

    public Universo()
    {
    }

    public String getNombre()
    {
        return Nombre;
    }

    public void setNombre(String Nombre)
    {
        this.Nombre = Nombre;
    }

    public Grafo getNebulosa()
    {
        return Nebulosa;
    }

    public void setNebulosa(Grafo Nebulosa)
    {
        this.Nebulosa = Nebulosa;
    }

    public Image getImagen()
    {
        return imagen;
    }

    public void setImagen(Image imagen)
    {
        this.imagen = imagen;
    }
    
    
   
    
}
