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

    /**
     * heuristica nodosVisitados nodosMarcados lista de pesos [nodoPadre,
     * nodoHijo, heuristica ] lista solucion
     *
     * al costo de recolectar en el sistema planetario se le debe adicionar la
     * cantidad de combustible consumida  para ir de un sistema planetario cualquiera a ese nodo
     * 
     * este esta medido por: 
     * combustible = distancia / rendimientoCombustible 
     * costoCombustible = zero: 5*4 + platino: 10*3 + paladio: 15*2 + iridio:20 == 100
     *
     * nodo inicial: nodo.adyasencias.size() <>= 1 y de estos el que tenga mayor
     * costo beneficio;
     *
     * termina una vez haya recorrido todos los nodos
     *
     * @return recorrido mas corto y con mejores beneficios
     */
    public List<SistemaPlanetario> CalcularRecorrido() {

        return null;
    }

    private double CalcularHeuristica(double costoBeneficio, double cantidadAbyasencias, double combustible) {
        costoBeneficio *= 100;
        cantidadAbyasencias *= 10;
        combustible *= 5;
        double heuristica = (costoBeneficio + cantidadAbyasencias) - combustible;
        return heuristica;

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

    void AgregarAdyasenciaSistemaPlanetario(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal, int peso) {
        sistemaPlanetarioInicial.getAdyacencias().add(new Nodo(sistemaPlanetarioFinal.getNombre(), peso));
        sistemaPlanetarioFinal.getAdyacencias().add(new Nodo(sistemaPlanetarioInicial.getNombre(), peso));
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
        this.controlSistemaPlanetario.AgregarAdyasenciaPlaneta(planetaInicial, planetaFinal);
    }

    public Planeta EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = this.controlSistemaPlanetario.EntrarPlaneta(nombrePlaneta);
        return planeta;
    }

    public List<Planeta> ListaPlanetas() {
        List<Planeta> planetas = this.controlSistemaPlanetario.ListaPlanetas();
        return planetas;
    }

    public Planeta getPlaneta() {
        return this.controlSistemaPlanetario.getPlaneta();
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
