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
    private final ControlSistemaPlanetario controlSistemaPlanetario;
    
    public ControlNebulosa() {
        this.codigoNebulosa = 0;
        this.controlSistemaPlanetario = new ControlSistemaPlanetario();
    }
    
    public Nebulosa CrearNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY) {
        this.codigoNebulosa++;
        this.setNebulosa(new Nebulosa(this.codigoNebulosa, nombre, enemigo, posicionX, posicionY));
        return this.getNebulosa();
    }
    
    public SistemaPlanetario AgregarSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY) {
        SistemaPlanetario sistemaPlanetario = this.controlSistemaPlanetario.CrearSistamPlanetario(nombre, enemigo, posicionX, posicionY);
        this.nebulosa.getListaSistemasPlanetarios().add(sistemaPlanetario);
        return sistemaPlanetario;
    }
    
    public SistemaPlanetario EntrarSistemaPlanetario(String nombreSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = BuscarSistemaPlanetario(nombreSistemaPlanetario);
        this.ActualizarSistemaPlanetario(sistemaPlanetario);
        return sistemaPlanetario;
    }
    
    private SistemaPlanetario BuscarSistemaPlanetario(String nombreSistemaPlanetario) {
        for (SistemaPlanetario sistemasPlanetario : this.nebulosa.getListaSistemasPlanetarios()) {
            if (sistemasPlanetario.getNombre().equals(nombreSistemaPlanetario)) {
                return sistemasPlanetario;
                
            }
        }
        return null;
    }
    
    private void ActualizarSistemaPlanetario(SistemaPlanetario sistemaPlanetario) {
        this.controlSistemaPlanetario.setSistemaPlanetario(sistemaPlanetario);
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
