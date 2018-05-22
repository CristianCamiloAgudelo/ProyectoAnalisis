package Grafo;

/**
 * clase arista, recibe la posicion inicial y final de la arista, ademas del
 * costo de la misma, el cual puede ser por distancia (para recorrer planetas) o
 * peligrosidad (para recorrer sistemas planetarios)
 *
 * @author Cristian Camilo Agudelo Santiago Granada Aguirre
 */
public class Arista
{
    private int posicionXInicial;
    private int posicionYInicial;
    private int posicionXFinal;
    private int posicionYFinal;
    private int costo;
    private Object objeto1;
    private Object objeto2;

    /**
     * Constructor parametrizable
     *
     * @param posicionXInicial
     * @param posicionYInicial
     * @param posicionXFinal
     * @param posicionYFinal
     * @param costo
     */
    public Arista(Object objeto1,Object objeto2,int posicionXInicial, int posicionYInicial, int posicionXFinal, int posicionYFinal, int costo)
    {
        this.posicionXInicial = posicionXInicial;
        this.posicionYInicial = posicionYInicial;
        this.posicionXFinal = posicionXFinal;
        this.posicionYFinal = posicionYFinal;
        this.costo = costo;
    }

    public int getPosicionXInicial()
    {
        return posicionXInicial;
    }

    public void setPosicionXInicial(int posicionXInicial)
    {
        this.posicionXInicial = posicionXInicial;
    }

    public int getPosicionYInicial()
    {
        return posicionYInicial;
    }

    public void setPosicionYInicial(int posicionYInicial)
    {
        this.posicionYInicial = posicionYInicial;
    }

    public int getPosicionXFinal()
    {
        return posicionXFinal;
    }

    public void setPosicionXFinal(int posicionXFinal)
    {
        this.posicionXFinal = posicionXFinal;
    }

    public int getPosicionYFinal()
    {
        return posicionYFinal;
    }

    public void setPosicionYFinal(int posicionYFinal)
    {
        this.posicionYFinal = posicionYFinal;
    }

    public int getCosto()
    {
        return costo;
    }

    public void setCosto(int costo)
    {
        this.costo = costo;
    }

    public Object getObjeto1()
    {
        return objeto1;
    }

    public void setObjeto1(Object objeto1)
    {
        this.objeto1 = objeto1;
    }

    public Object getObjeto2()
    {
        return objeto2;
    }

    public void setObjeto2(Object objeto2)
    {
        this.objeto2 = objeto2;
    }
    
    

}
