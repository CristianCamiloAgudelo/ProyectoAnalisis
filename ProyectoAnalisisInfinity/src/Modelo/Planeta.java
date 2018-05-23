package Modelo;

import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Planeta {

    private int codigo;
    private String nombre;
    private boolean visitado;
    private Elementos elementos;
    private boolean estacionCombustible;
    private List<Nodo> adyacencias;

    public Planeta() {
    }
}
