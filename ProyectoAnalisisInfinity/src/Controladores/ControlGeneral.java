/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Modelo.*;
import Vistas.*;
/**
 *
 * @author USER
 */
public class ControlGeneral {
    private ControlNebulosas controlNebulosas;
    private UniversoController universoController;
    private Universo universo;
    
    public void CrearUniverso(){}
    public SistemaPlanetario CrearSistemaPlanetario(String nombre, int posicionX, int posicionY ){
        this.controlNebulosas.crearSistemaPlanetario(0, universo.getListaNebulosas());
    return null;
    }
    
}
