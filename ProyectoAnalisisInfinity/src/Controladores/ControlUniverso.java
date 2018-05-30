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

    public ControlUniverso() {
        
    }

    public Universo CrearUniverso(String nombre) {
        this.setUniverso(new Universo(nombre));
        return this.getUniverso();
    }

    public Nebulosa BuscarNebulosa(int codigoNebulosa) {

        for (Nebulosa nebulosa : this.universo.getListaNebulosas()) {
            if (nebulosa.getCodigo() == codigoNebulosa) {
                return nebulosa;
            }
        }
        return null;
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
