/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author usuario
 */
public class Nodo{

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    private String nombre;
    private double peso;

    public Nodo() {
        
    }

    public Nodo(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * @return the codigo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

}