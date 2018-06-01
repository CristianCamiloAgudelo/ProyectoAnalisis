/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Nebulosa;
import Modelo.Universo;

/**
 *
 * @author USER
 */
public class ControlUniverso {

    private Universo universo;
    private final ControlNebulosa controlNebulosa;

    public ControlUniverso() {
        this.controlNebulosa = new ControlNebulosa();

    }

    public Universo CrearUniverso(String nombre) {
        this.setUniverso(new Universo(nombre));
        return this.getUniverso();
    }

    public Nebulosa AgregarNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY) {
        Nebulosa nebulosa = this.controlNebulosa.CrearNebulosa(nombre, enemigo, posicionX, posicionY);
        this.universo.getListaNebulosas().add(nebulosa);
        return nebulosa;

    }

    public Nebulosa BuscarNebulosa(String nombreNebulosa) {

        for (Nebulosa nebulosa : this.universo.getListaNebulosas()) {
            if (nebulosa.getNombre().equals(nombreNebulosa)) {
                return nebulosa;
            }
        }
        return null;
    }

    void ActualizarNebulosa(Nebulosa nebulosa) {
        this.controlNebulosa.setNebulosa(nebulosa);
    }

    /**
     * @return the universo
     */
    public Universo getUniverso() {
        return universo;
    }

    /**
     * @param universo the universo to set
     */
    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

}
