/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class ControlSistemaPlanetario {

    private int codigoSistemaPlanetario;
    private final ControlPlaneta controlPlaneta;
    private SistemaPlanetario sistemaPlanetario;
    private final List<String> imagenesSistemasPlanetarios;

    public ControlSistemaPlanetario() {
        this.codigoSistemaPlanetario = 0;
        this.controlPlaneta = new ControlPlaneta();
        this.imagenesSistemasPlanetarios = new LinkedList<>();
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo1.png");
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo2.png");
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo3.png");
    }

    public List<Planeta> IniciarRecorridoPlanetas() {
        Planeta nodoPadre = BuscarNodoInicial();
        List<Planeta> planetasVisitados = new LinkedList<>();
        List<String[]> tablaPesos = new LinkedList<>();
        Stack<Planeta> pila = new Stack<>();
        pila.push(nodoPadre);
        CalcularRecorrido(nodoPadre, planetasVisitados, tablaPesos, pila);
        tablaPesos.forEach((tablaPeso) -> {
            System.out.println("padre: " + tablaPeso[0] + " hijo: " + tablaPeso[1] + " heuristica: " + tablaPeso[2]);
        });
        return planetasVisitados;
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
    private void CalcularRecorrido(Planeta nodoPadre, List<Planeta> planetasVisitados, List<String[]> tablaPesos, Stack<Planeta> pila) {
        nodoPadre.setVisitado(true);
        planetasVisitados.add(nodoPadre);
        double mayorHeuristica = -999999999;
        Planeta nodoHijo = null;
        for (Nodo nodoAdyacente : nodoPadre.getAdyacencias()) {
            if (!planetasVisitados.contains(BuscarPlaneta(nodoAdyacente.getNombre()))) {
                String[] vectorPesos = new String[3];
                vectorPesos[0] = nodoPadre.getNombre();
                vectorPesos[1] = nodoAdyacente.getNombre();
                Planeta planetaAdyacente = BuscarPlaneta(nodoAdyacente.getNombre());
                double costoBeneficio = this.controlPlaneta.CalcularBeneficio(planetaAdyacente) - this.controlPlaneta.CalcularCosto(planetaAdyacente);
                vectorPesos[2] = String.valueOf(CalcularHeuristica(costoBeneficio, planetaAdyacente.getAdyacencias().size() - 1));
                if (Double.parseDouble(vectorPesos[2]) > mayorHeuristica) {
                    mayorHeuristica = Double.parseDouble(vectorPesos[2]);
                    nodoHijo = BuscarPlaneta(vectorPesos[1]);
                }
                tablaPesos.add(vectorPesos);
            }
        }
        if (nodoHijo != null) {
            CalcularRecorrido(pila.push(nodoHijo), planetasVisitados, tablaPesos, pila);

        } else if (verificarVisitados()) {
            if (!pila.isEmpty()) {
                System.out.println("desapile: ->>>>>>>>>>>" + pila.pop().getNombre());
            }
            CalcularRecorrido(pila.lastElement(), planetasVisitados, tablaPesos, pila);
        }

    }

    private boolean verificarVisitados() {
        boolean faltaVisitar = false;
        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
            if (!planeta.isVisitado()) {
                System.out.println("falta visitar: " + planeta.getNombre());
                faltaVisitar = true;
            }
        }

        return faltaVisitar;
    }

    private Planeta BuscarNodoInicial() {
        Planeta nodoInicial = new Planeta();
        int menorAdyasencia = 1000000;

        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
            if (planeta.getAdyacencias().size() < menorAdyasencia) {
                menorAdyasencia = planeta.getAdyacencias().size();
                nodoInicial = planeta;
            }
        }
        return nodoInicial;
    }

    private double CalcularHeuristica(double costoBeneficio, double cantidadAbyasencias) {
        costoBeneficio *= 100;
        cantidadAbyasencias *= 10;

//        System.out.println("costoBeneficio: " + costoBeneficio + " cantidadAdyasencias: " + cantidadAbyasencias + " combustible: " + combustible);
        double heuristica = (costoBeneficio + cantidadAbyasencias);
        return heuristica;

    }

    public SistemaPlanetario CrearSistamPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario, boolean teletransportador) {
        this.codigoSistemaPlanetario++;
        SistemaPlanetario sistemaPlanetario = new SistemaPlanetario(this.codigoSistemaPlanetario, nombre, enemigo, posicionX, posicionY, this.imagenesSistemasPlanetarios.get(tipoSistemaPlanetario));
        sistemaPlanetario.setTeletransportador(teletransportador);
        return sistemaPlanetario;
    }

    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlPlaneta.CrearPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        this.sistemaPlanetario.getListaPlanetas().add(planeta);
        System.out.println("agregue Planeta");
        return planeta;
    }

    public void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
        planetaInicial.getAdyacencias().add(new Nodo(planetaFinal.getNombre(), 0));
        planetaFinal.getAdyacencias().add(new Nodo(planetaInicial.getNombre(), 0));
    }

    public Planeta EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = BuscarPlaneta(nombrePlaneta);
        System.out.println("planeta:    " + planeta.getNombre() + planeta.getElementos().getZero());
        this.ActualizarPlaneta(planeta);
        return planeta;
    }

    public Planeta BuscarPlaneta(String nombrePlaneta) {
        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
            if (planeta.getNombre().equals(nombrePlaneta)) {
                return planeta;
            }
        }
        return null;
    }

    public double CalcularBeneficio(SistemaPlanetario sistemaPlanetario) {
        double beneficio = 0;
        //System.out.println("nombre sistema: "+ sistemaPlanetario.getNombre()+" cantidadPlanetas: "+ sistemaPlanetario.getListaPlanetas().size());
        for (Planeta planeta : sistemaPlanetario.getListaPlanetas()) {
            //System.out.println("es explorable: "+ planeta.isExprorable());
            if (planeta.isExprorable()) {
                beneficio += planeta.getElementos().getZero() * 4;
                beneficio += planeta.getElementos().getPlatino() * 3;
                beneficio += planeta.getElementos().getPaladio() * 2;
                beneficio += planeta.getElementos().getIridio();
                //System.out.println("nombre planeta: "+ planeta.getNombre()+ "beneficio: "+beneficio);
            }
        }
        return beneficio;
    }

    /**
     * en esta funcion se adiciona al costo el valor de las sondas * (cantidad
     * de sondas que deba gastarse la nave para recolectar alli) una sonda cubre
     * 2 elementos, por planeta como maximo se usan 2 sondas valor sonda =
     * zero:20*4 + platino:25*4 + paladio:40*4 + iridio:50*4 = 540;
     *
     * @return costo
     */
    public double CalcularCosto(SistemaPlanetario sistemaPlanetario) {
        double costo = 0;
        int contador = 0;
        for (Planeta planeta : sistemaPlanetario.getListaPlanetas()) {
            if (planeta.getElementos().getZero() != 0) {
                contador++;
            }
            if (planeta.getElementos().getPlatino() != 0) {
                contador++;
            }
            if (planeta.getElementos().getPaladio() != 0) {
                contador++;
            }
            if (planeta.getElementos().getIridio() != 0) {
                contador++;
            }
            if (contador > 2) {
                costo += 540 * 2;
            } else {
                costo += 540 * 1;
            }
            contador = 0;
        }
        return costo;
    }

    private void ActualizarPlaneta(Planeta planeta) {
        this.controlPlaneta.setPlaneta(planeta);
    }

    public List<Planeta> ListaPlanetas() {
        List<Planeta> planetas = this.sistemaPlanetario.getListaPlanetas();
        return planetas;
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

    public Planeta getPlaneta() {
        return this.controlPlaneta.getPlaneta();
    }

}
