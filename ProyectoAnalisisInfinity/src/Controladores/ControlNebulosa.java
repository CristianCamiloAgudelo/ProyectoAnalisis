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
import java.util.Stack;
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
    private boolean teletransportador;

    public ControlNebulosa() {
        this.codigoNebulosa = 0;
        this.controlSistemaPlanetario = new ControlSistemaPlanetario();
        this.teletransportador = false;
        this.imagenes = new LinkedList<>();
        this.imagenes.add("Imagenes/nebulosa11.png");
        this.imagenes.add("Imagenes/NebulosaTipo3.png");
        this.imagenes.add("Imagenes/NebulosaTipo4.png");

    }

    public List<SistemaPlanetario> IniciarRecorridoSistemasPlanetarios() {
        SistemaPlanetario nodoPadre = BuscarNodoInicial();
        List<SistemaPlanetario> sistemasPlanetariosVisitados = new LinkedList<>();
        List<String[]> tablaPesos = new LinkedList<>();
        Stack<SistemaPlanetario> pila = new Stack<>();
        pila.push(nodoPadre);
        CalcularRecorrido(nodoPadre, sistemasPlanetariosVisitados, tablaPesos, pila);
        tablaPesos.forEach((tablaPeso) -> {
            System.out.println("padre: " + tablaPeso[0] + " hijo: " + tablaPeso[1] + " heuristica: " + tablaPeso[2]);
        });
        return sistemasPlanetariosVisitados;
    }

    /**
     * heuristica nodosVisitados nodosMarcados lista de pesos [nodoPadre,
     * nodoHijo, heuristica ] lista solucion
     *
     * al costo de recolectar en el sistema planetario se le debe adicionar la
     * cantidad de combustible consumida para ir de un sistema planetario
     * cualquiera a ese nodo
     *
     * este esta medido por: combustible = distancia / rendimientoCombustible
     * costoCombustible = zero: 5*4 + platino: 10*3 + paladio: 15*2 + iridio:20
     * == 100
     *
     * nodo inicial: nodo.adyasencias.size() <>= 1 y de estos el que tenga mayor
     * costo beneficio;
     *
     * termina una vez haya recorrido todos los nodos
     *
     * @param nodoPadre
     * @param sistemasPlanetariosVisitados
     * @param tablaPesos
     */
    private void CalcularRecorrido(SistemaPlanetario nodoPadre, List<SistemaPlanetario> sistemasPlanetariosVisitados, List<String[]> tablaPesos, Stack<SistemaPlanetario> pila) {
        nodoPadre.setVisitado(true);
        sistemasPlanetariosVisitados.add(nodoPadre);
        double mayorHeuristica = -999999999;
        SistemaPlanetario nodoHijo = null;
        for (Nodo nodoAdyacente : nodoPadre.getAdyacencias()) {
            if (!sistemasPlanetariosVisitados.contains(BuscarSistemaPlanetario(nodoAdyacente.getNombre()))) {
                String[] vectorPesos = new String[3];
                vectorPesos[0] = nodoPadre.getNombre();
                vectorPesos[1] = nodoAdyacente.getNombre();
                SistemaPlanetario sistemaAdyacente = BuscarSistemaPlanetario(nodoAdyacente.getNombre());
                double consumoCombustible = (nodoAdyacente.getPeso() / 100);
                double costoCombustible = consumoCombustible * 100;
                double costoBeneficio = this.controlSistemaPlanetario.CalcularBeneficio(sistemaAdyacente) - this.controlSistemaPlanetario.CalcularCosto(sistemaAdyacente);
                vectorPesos[2] = String.valueOf(CalcularHeuristica(costoBeneficio, sistemaAdyacente.getAdyacencias().size() - 1, costoCombustible));
                if (Double.parseDouble(vectorPesos[2]) > mayorHeuristica) {
                    mayorHeuristica = Double.parseDouble(vectorPesos[2]);
                    nodoHijo = BuscarSistemaPlanetario(vectorPesos[1]);
                }
                tablaPesos.add(vectorPesos);
            }
        }
        if (nodoHijo != null) {
            CalcularRecorrido(pila.push(nodoHijo), sistemasPlanetariosVisitados, tablaPesos, pila);

        } else if (verificarVisitados()) {
            if (!pila.isEmpty()) {
                System.out.println("desapile: ->>>>>>>>>>>" + pila.pop().getNombre());
            }
            CalcularRecorrido(pila.lastElement(), sistemasPlanetariosVisitados, tablaPesos, pila);
        }

    }

    private boolean verificarVisitados() {
        boolean faltaVisitar = false;
        for (SistemaPlanetario sistemasPlanetariosVisitado : this.nebulosa.getListaSistemasPlanetarios()) {
            if (!sistemasPlanetariosVisitado.isVisitado()) {
                System.out.println("falta visitar: " + sistemasPlanetariosVisitado.getNombre());
                faltaVisitar = true;
            }
        }

        return faltaVisitar;
    }

    private SistemaPlanetario BuscarNodoInicial() {
        SistemaPlanetario nodoInicial = new SistemaPlanetario();
        for (SistemaPlanetario sistema : this.nebulosa.getListaSistemasPlanetarios()) {
            if (sistema.isTeletransportador()) {
                nodoInicial = sistema;
            }
        }
        return nodoInicial;
    }

    private double CalcularHeuristica(double costoBeneficio, double cantidadAbyasencias, double combustible) {
        costoBeneficio *= 100;
        cantidadAbyasencias *= 10;

//        System.out.println("costoBeneficio: " + costoBeneficio + " cantidadAdyasencias: " + cantidadAbyasencias + " combustible: " + combustible);
        double heuristica = (costoBeneficio + cantidadAbyasencias) + combustible;
        return heuristica;

    }

    public Nebulosa CrearNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        this.codigoNebulosa++;
        Nebulosa nebulosa = (new Nebulosa(this.codigoNebulosa, nombre, enemigo, posicionX, posicionY, this.imagenes.get(tipoNebulosa)));
        return nebulosa;
    }

    public SistemaPlanetario AgregarSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario, boolean teletransportador) {
        if (teletransportador) {
            this.nebulosa.setTeletransportador(true);
        }
        SistemaPlanetario sistemaPlanetario = this.controlSistemaPlanetario.CrearSistamPlanetario(nombre, enemigo, posicionX, posicionY, tipoSistemaPlanetario, teletransportador);
        this.nebulosa.getListaSistemasPlanetarios().add(sistemaPlanetario);
        System.out.println("agregue sistema teletransportador: " + teletransportador);
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

    public List<Planeta> IniciarRecorridoPlaneta() {
        return this.controlSistemaPlanetario.IniciarRecorridoPlanetas();
    }

    /**
     * @return the teletransportador
     */
    public boolean isTeletransportador() {
        return teletransportador;
    }

    /**
     * @param teletransportador the teletransportador to set
     */
    public void setTeletransportador(boolean teletransportador) {
        this.teletransportador = teletransportador;
    }

}
