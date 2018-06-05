/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import Modelo.Nodo;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class ControlNebulosa {

    private Nebulosa nebulosa;
    private int codigoNebulosa;
    private int codigoImagen;
    private List<String> imagenes;
    private final ControlSistemaPlanetario controlSistemaPlanetario;

    public ControlNebulosa() {
        this.codigoNebulosa = 0;
        this.controlSistemaPlanetario = new ControlSistemaPlanetario();
        this.imagenes = new LinkedList<>();
        this.imagenes.add("Imagenes/nebulosa11.png");
        this.imagenes.add("Imagenes/NebulosaTipo3.png");
        this.imagenes.add("Imagenes/NebulosaTipo4.png");

    }

    public Nebulosa CrearNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        this.codigoNebulosa++;
        Nebulosa nebulosa = (new Nebulosa(this.codigoNebulosa, nombre, enemigo, posicionX, posicionY, this.imagenes.get(tipoNebulosa)));
        return nebulosa;
    }

    public SistemaPlanetario AgregarSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlSistemaPlanetario.CrearSistamPlanetario(nombre, enemigo, posicionX, posicionY, tipoSistemaPlanetario);
        this.nebulosa.getListaSistemasPlanetarios().add(sistemaPlanetario);
        return sistemaPlanetario;
    }

    void AgregarAdyasenciaSistemaPlanetario(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal) {
        sistemaPlanetarioInicial.getAdyacencias().add(new Nodo(sistemaPlanetarioFinal.getNombre(), 0));
    }

    public SistemaPlanetario EntrarSistemaPlanetario(String nombreSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = BuscarSistemaPlanetario(nombreSistemaPlanetario);
        this.ActualizarSistemaPlanetario(sistemaPlanetario);
        return sistemaPlanetario;
    }

    public SistemaPlanetario BuscarSistemaPlanetario(String nombreSistemaPlanetario) {
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

    public List<SistemaPlanetario> ListaSistemasPlanetarios() {
        List<SistemaPlanetario> sistemasPlanetarios = this.nebulosa.getListaSistemasPlanetarios();
        return sistemasPlanetarios;
    }

    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlSistemaPlanetario.AgregarPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        return planeta;
    }

    public Planeta BuscarPlaneta(String nombrePlaneta) {
        return this.controlSistemaPlanetario.BuscarPlaneta(nombrePlaneta);
    }

    void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
       this.controlSistemaPlanetario.AgregarAdyasenciaPlaneta(planetaInicial,planetaFinal);
    }

    public Planeta EntrarPlaneta(String nombrePlaneta) {
        return this.controlSistemaPlanetario.EntrarPlaneta(nombrePlaneta);
    }

    public List<Planeta> ListaPlanetas() {
        List<Planeta> planetas = this.controlSistemaPlanetario.ListaPlanetas();
        return planetas;
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
