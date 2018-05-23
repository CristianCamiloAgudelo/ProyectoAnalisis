
package Modelo;

import java.util.List;

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
    private List<Nodo> adyacencias;

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

    public List<Nodo> getAdyacencias()
    {
        return adyacencias;
    }

    public void setAdyacencias(List<Nodo> adyacencias)
    {
        this.adyacencias = adyacencias;
    }
    
    
}
