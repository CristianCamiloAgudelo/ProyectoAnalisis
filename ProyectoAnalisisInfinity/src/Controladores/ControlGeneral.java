/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.util.Stack;

/**
 *
 * @author USER
 */
public class ControlGeneral {

    private Stack<String> pila;
    private final ControlUniverso controlUniverso;
    private ControlNebulosa controlNebulosa;

    private ControlSistemaPlanetario controlSistemasPlanetarios;
    private ControlPlaneta controlPlaneta;

    public ControlGeneral() {
        this.pila = new Stack<>();
        this.controlUniverso = new ControlUniverso();
        this.controlNebulosa = new ControlNebulosa();
    }

    public Universo CrearUniverso(String nombre) {
        return this.controlUniverso.CrearUniverso(nombre);
    }

    public Nebulosa AgregarNebulosa(String nombre, Boolean enemigo) {
        Nebulosa nebulosa =  this.controlUniverso.AgregarNebulosa(nombre, enemigo);
        return nebulosa;
    }

    public SistemaPlanetario CrearSistemaPlanetario(String nombre, int posicionX, int posicionY) {

        return null;
    }

    /**
     * @return the pila
     */
    public Stack<String> getPila() {
        return pila;
    }

}
