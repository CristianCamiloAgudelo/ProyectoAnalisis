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
    private String nombre;
    private int peso;

    public Nodo() {
        
    }

    public Nodo(String nombre, int peso) {
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
    public int getPeso() {
        return peso;
    }

}