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
public class ControlNebulosas {

    public SistemaPlanetario crearSistemaPlanetario(int codigoSistemaPlanetario, Nebulosa nebulosa) {
        nebulosa.getListaSistemasPlanetarios().add(new SistemaPlanetario(codigoSistemaPlanetario, ""));
        return null;
    }

    public LinkedList CrearConexion(int codigo, Nodo nodo) {
        return null;
    }

    private Parent Volver() {
        return null;// volver a vista universo
    }

}
