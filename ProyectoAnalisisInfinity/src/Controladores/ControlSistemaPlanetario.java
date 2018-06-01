/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.util.LinkedList;
import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class ControlSistemaPlanetario {

    private int codigoSistemaPlanetario;
    private ControlPlaneta controlPlaneta;
    private SistemaPlanetario sistemaPlanetario;

    public ControlSistemaPlanetario() {
        this.codigoSistemaPlanetario = 0;
        this.controlPlaneta = new ControlPlaneta();
    }

    public SistemaPlanetario CrearSistamPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY) {
        this.codigoSistemaPlanetario++;
        SistemaPlanetario sistemaPlanetario = new SistemaPlanetario(this.codigoSistemaPlanetario, nombre, enemigo, posicionX, posicionY);
        return sistemaPlanetario;
    }

    private Parent EntrarPlaneta(int codigoPlaneta) {
        return null;
    }

    private LinkedList CrearConexion(int codigo, Nodo nodo) {
        return null;
    }

    private Parent Volver() {
        return null;// volver a vista nebulosa
    }

    /**
     * @return the sistemaPlanetario
     */
    public SistemaPlanetario getSistemaPlanetario() {
        return sistemaPlanetario;
    }

    /**
     * @param sistemaPlanetario the sistemaPlanetario to set
     */
    public void setSistemaPlanetario(SistemaPlanetario sistemaPlanetario) {
        this.sistemaPlanetario = sistemaPlanetario;
    }
}
