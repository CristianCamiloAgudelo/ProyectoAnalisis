/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import Modelo.Nodo;
import java.util.LinkedList;

import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class ControlNebulosa {

    private Nebulosa nebulosa;
    private int codigoNebulosa;

    public ControlNebulosa() {
        this.codigoNebulosa = 0;
    }

    public Nebulosa CrearNebulosa(String nombre, Boolean enemigo) {
        this.codigoNebulosa++;
        this.setNebulosa(new Nebulosa(this.codigoNebulosa, nombre, enemigo));
        return this.getNebulosa();
    }

    public SistemaPlanetario AgregarSistemaPlanetario(int codigoSistemaPlanetario, Nebulosa nebulosa) {
        return null;
    }

    public LinkedList CrearConexion(int codigo, Nodo nodo) {
        return null;
    }

    private Parent Volver() {
        return null;// volver a vista universo
    }

    /**
     * @return the nebulosa
     */
    public Nebulosa getNebulosa() {
        return nebulosa;
    }

    /**
     * @param nebulosa the nebulosa to set
     */
    public void setNebulosa(Nebulosa nebulosa) {
        this.nebulosa = nebulosa;
    }

}
