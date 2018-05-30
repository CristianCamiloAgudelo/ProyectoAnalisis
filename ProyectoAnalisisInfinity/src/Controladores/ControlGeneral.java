/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import Vistas.*;
import java.util.Stack;

/**
 *
 * @author USER
 */
public class ControlGeneral {

    private Stack<String> pila;
    private ControlUniverso controlUniverso;
    private ControlNebulosa controlNebulosa;
    private ControlSistemaPlanetario controlSistemasPlanetarios;
    private ControlPlaneta controlPlaneta;

    public ControlGeneral() {
        this.pila = new Stack<>();
        this.controlUniverso = new ControlUniverso();
    }

    public Universo CrearUniverso(String nombre) {
        return this.controlUniverso.CrearUniverso(nombre);
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
