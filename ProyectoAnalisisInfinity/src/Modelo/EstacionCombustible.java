
package Modelo;

import java.awt.Image;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class EstacionCombustible
{
    private int codigo;
    private String nombre;
    private Costo costoCombustible;
    private Costo costoSonda;
    private int posicionX;
    private int posicionY;
    private Image imagen;

    public EstacionCombustible()
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

    public Costo getCostoCombustible()
    {
        return costoCombustible;
    }

    public void setCostoCombustible(Costo costoCombustible)
    {
        this.costoCombustible = costoCombustible;
    }

    public Costo getCostoSonda()
    {
        return costoSonda;
    }

    public void setCostoSonda(Costo costoSonda)
    {
        this.costoSonda = costoSonda;
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

    public Image getImagen()
    {
        return imagen;
    }

    public void setImagen(Image imagen)
    {
        this.imagen = imagen;
    }
    
    
}
