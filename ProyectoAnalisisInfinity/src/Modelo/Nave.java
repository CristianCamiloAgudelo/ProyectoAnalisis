package Modelo;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
import Controladores.ControlSistemaNavegacion;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

public class Nave {

    private String nombre;
    private int cantidadSonda;
    private int cantidadCombustible;
    private List<Arma> armas;
    private List<Escudo> escudos;
    private List<Propulsor> propulsores;
    private Elementos elementos;
    private ControlSistemaNavegacion radar;
    private int vida;
    private int daño;
    private int velocidad;
    private double posicionX;
    private double posicionY;
    private String imagen;
    private int experiencia;
    private int nivel;

    public Nave(String nombre, double posicionX, double posicionY) {
        this.nombre = nombre;
        this.cantidadSonda = 10;
        this.cantidadCombustible = 100;
        this.armas = new LinkedList<>();
        this.escudos =  new LinkedList<>();
        this.propulsores =  new LinkedList<>();
        this.elementos = new Elementos(0, 0, 0, 0);
        this.radar = new ControlSistemaNavegacion();
        this.vida = 100;
        this.daño = 10;
        this.velocidad = 10;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.imagen = "Imagenes/Nave1.png";
        this.experiencia = 10;
        this.nivel = 1;
    }

    public Nave(String nombre, int cantidadSonda, int cantidadCombustible, List<Arma> armas, List<Escudo> escudos, List<Propulsor> propulsores, Elementos elementos, ControlSistemaNavegacion radar, int vida, int daño, int velocidad, double posicionX, double posicionY, int experiencia, int nivel) {
        this.nombre = nombre;
        this.cantidadSonda = cantidadSonda;
        this.cantidadCombustible = cantidadCombustible;
        this.armas = armas;
        this.escudos = escudos;
        this.propulsores = propulsores;
        this.elementos = elementos;
        this.radar = radar;
        this.vida = vida;
        this.daño = daño;
        this.velocidad = velocidad;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.imagen = "src/Imagenes/Nave.gif";
        this.experiencia = experiencia;
        this.nivel = nivel;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the cantidadSonda
     */
    public int getCantidadSonda() {
        return cantidadSonda;
    }

    /**
     * @param cantidadSonda the cantidadSonda to set
     */
    public void setCantidadSonda(int cantidadSonda) {
        this.cantidadSonda = cantidadSonda;
    }

    /**
     * @return the cantidadCombustible
     */
    public int getCantidadCombustible() {
        return cantidadCombustible;
    }

    /**
     * @param cantidadCombustible the cantidadCombustible to set
     */
    public void setCantidadCombustible(int cantidadCombustible) {
        this.cantidadCombustible = cantidadCombustible;
    }

    /**
     * @return the armas
     */
    public List<Arma> getArmas() {
        return armas;
    }

    /**
     * @param armas the armas to set
     */
    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    /**
     * @return the escudos
     */
    public List<Escudo> getEscudos() {
        return escudos;
    }

    /**
     * @param escudos the escudos to set
     */
    public void setEscudos(List<Escudo> escudos) {
        this.escudos = escudos;
    }

    /**
     * @return the propulsores
     */
    public List<Propulsor> getPropulsores() {
        return propulsores;
    }

    /**
     * @param propulsores the propulsores to set
     */
    public void setPropulsores(List<Propulsor> propulsores) {
        this.propulsores = propulsores;
    }

    /**
     * @return the elementos
     */
    public Elementos getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(Elementos elementos) {
        this.elementos = elementos;
    }

    /**
     * @return the radar
     */
    public ControlSistemaNavegacion getRadar() {
        return radar;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the daño
     */
    public int getDaño() {
        return daño;
    }

    /**
     * @param daño the daño to set
     */
    public void setDaño(int daño) {
        this.daño = daño;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the posicionX
     */
    public double getPosicionX() {
        return posicionX;
    }

    /**
     * @param posicionX the posicionX to set
     */
    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * @return the posicionY
     */
    public double getPosicionY() {
        return posicionY;
    }

    /**
     * @param posicionY the posicionY to set
     */
    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

}
