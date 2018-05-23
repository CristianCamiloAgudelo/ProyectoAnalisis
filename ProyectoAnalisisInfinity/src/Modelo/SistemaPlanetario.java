
package Modelo;
import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class SistemaPlanetario
{
    private int codigo;
    private String nombre;
    private boolean visitado;
    private List<Enemigo> enemigos;
    //private Grafo planetas;
    private List<Nodo> adyacencias;
    private List<Planeta> listaPlanetas;
    private List<Image> imagen;
    private int posicionX;
    private int posicionY;

    public SistemaPlanetario()
    {
    }
}
