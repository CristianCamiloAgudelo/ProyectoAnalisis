
package Modelo;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Planeta
{
    private int codigo;
    private String nombre;
    private boolean visitado;
    private Elementos elementos;
    private boolean estacionCombustible;

    public Planeta()
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

    public Elementos getElementos()
    {
        return elementos;
    }

    public void setElementos(Elementos elementos)
    {
        this.elementos = elementos;
    }

    public boolean isEstacionCombustible()
    {
        return estacionCombustible;
    }

    public void setEstacionCombustible(boolean estacionCombustible)
    {
        this.estacionCombustible = estacionCombustible;
    }
    
    
}
