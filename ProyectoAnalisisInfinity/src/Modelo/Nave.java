package Modelo;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
import java.awt.Image;
import java.util.List;

public class Nave {

    private String nombre;
    private int cantidadSonda;
    private int cantidadCombustible;
    private List<Arma> armas;
    private List<Escudo> escudos;
    private List<Propulsor> propulsor;
    private Elementos elementos;
    private SistemaNavegacion radar;
    private int vida;
    private int daño;
    private int velocidad;
    private int posicionX;
    private int posicionY;
    private Image imagen;
    private int experiencia;
    private int nivel;

    public Nave() {
    }
}
