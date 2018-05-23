
package Modelo;
import Grafo.*;
import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Universo
{
    private String Nombre;
    private List<Nebulosa> listaNebulosas;
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
//
//    public List<Nebulosa> getGrafoNebulosa()
//    {
//        return grafoNebulosa;
//    }
//
//    public void setGrafoNebulosa(List<Nebulosa> grafoNebulosa)
//    {
//        this.grafoNebulosa = grafoNebulosa;
//    }

    public Image getImagen()
    {
        return imagen;
    }

    public void setImagen(Image imagen)
    {
        this.imagen = imagen;
    }

    /**
     * @return the listaNebulosas
     */
    public List<Nebulosa> getListaNebulosas()
    {
        return listaNebulosas;
    }

    /**
     * @param listaNebulosas the listaNebulosas to set
     */
    public void setListaNebulosas(List<Nebulosa> listaNebulosas)
    {
        this.listaNebulosas = listaNebulosas;
    }

   
    
    
    
   
    
}
