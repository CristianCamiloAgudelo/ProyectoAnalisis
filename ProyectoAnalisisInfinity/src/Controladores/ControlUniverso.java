/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Universo;

/**
 *
 * @author USER
 */
public class ControlUniverso {

    public ControlUniverso() {

    }

    public Universo CrearUniverso(String nombre) {
        Universo universo = new Universo(nombre);
        return universo;
    }

}
