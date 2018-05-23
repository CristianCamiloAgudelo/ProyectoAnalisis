package Modelo;

import java.awt.Image;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Nebulosa {

    private int codigo;
    private String nombre;
    private boolean enemigo;
    private boolean visitado;
    //private Grafo sistemaPlanetario;
    private List<Nodo> adyacencias;
    private List<SistemaPlanetario> listaSistemasPlanetarios;
    private List<Image> imagen;
    private int posicionX;
    private int posicionY;

    public Nebulosa() {
    }
}
