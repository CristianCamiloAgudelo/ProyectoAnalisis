
package Modelo;

import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Escudo
{
    private int codigo;
    private String nombre;
    private int vida;
    private List<Image> imagen;
    private int duracionEscudo;   

    public Escudo()
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
        return duracionEscudo;
    }

    public void setDuracionArma(int duracionArma)
    {
        this.duracionEscudo = duracionArma;
    }
    
    
}
