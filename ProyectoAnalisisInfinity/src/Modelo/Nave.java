
package Modelo;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */

import java.awt.Image;
import java.util.List;


public class Nave
{
    private String nombre;
    private int cantidadSonda ;
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

    public Nave()
    {
    }

    
    //Set and Get

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCantidadSonda()
    {
        return cantidadSonda;
    }

    public void setCantidadSonda(int cantidadSonda)
    {
        this.cantidadSonda = cantidadSonda;
    }

    public int getCantidadCombustible()
    {
        return cantidadCombustible;
    }

    public void setCantidadCombustible(int cantidadCombustible)
    {
        this.cantidadCombustible = cantidadCombustible;
    }

    public List<Arma> getArmas()
    {
        return armas;
    }

    public void setArmas(List<Arma> armas)
    {
        this.armas = armas;
    }

    public List<Escudo> getEscudos()
    {
        return escudos;
    }

    public void setEscudos(List<Escudo> escudos)
    {
        this.escudos = escudos;
    }

    public List<Propulsor> getPropulsor()
    {
        return propulsor;
    }

    public void setPropulsor(List<Propulsor> propulsor)
    {
        this.propulsor = propulsor;
    }

    public Elementos getElementos()
    {
        return elementos;
    }

    public void setElementos(Elementos elementos)
    {
        this.elementos = elementos;
    }

    public SistemaNavegacion getRadar()
    {
        return radar;
    }

    public void setRadar(SistemaNavegacion radar)
    {
        this.radar = radar;
    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getDaño()
    {
        return daño;
    }

    public void setDaño(int daño)
    {
        this.daño = daño;
    }

    public int getVelocidad()
    {
        return velocidad;
    }

    public void setVelocidad(int velocidad)
    {
        this.velocidad = velocidad;
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

    public int getExperiencia()
    {
        return experiencia;
    }

    public void setExperiencia(int experiencia)
    {
        this.experiencia = experiencia;
    }

    public int getNivel()
    {
        return nivel;
    }

    public void setNivel(int nivel)
    {
        this.nivel = nivel;
    }
   
          
    
    
}
