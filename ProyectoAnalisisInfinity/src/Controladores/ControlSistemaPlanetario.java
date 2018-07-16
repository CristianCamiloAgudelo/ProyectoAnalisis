/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.util.LinkedList;
import java.util.List;
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

    public SistemaPlanetario CrearSistamPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        this.codigoSistemaPlanetario++;
        SistemaPlanetario sistemaPlanetario = new SistemaPlanetario(this.codigoSistemaPlanetario, nombre, enemigo, posicionX, posicionY, this.imagenesSistemasPlanetarios.get(tipoSistemaPlanetario));
        return sistemaPlanetario;
    }

    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlPlaneta.CrearPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        this.sistemaPlanetario.getListaPlanetas().add(planeta);
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

    private double CalcularBeneficio() {
        double beneficio = 0;
        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
            if (planeta.isExprorable()) {
                beneficio += planeta.getElementos().getZero() * 4;
                beneficio += planeta.getElementos().getPlatino() * 3;
                beneficio += planeta.getElementos().getPaladio() * 2;
                beneficio += planeta.getElementos().getIridio();
            }
        }
        return beneficio;
    }

    /**
     * en esta funcion se adiciona al costo el valor de las sondas * (cantidad
     * de sondas que deba gastarse la nave para recolectar alli) una sonda cubre
     * 2 elementos, por planeta como maximo se usan 2 sondas valor sonda =
     * zero:150*4 + platino:200*4 + paladio:210*4 + iridio:230*4 = 3160;
     *
     * @return
     */
    private double CalcularCosto() {
        double costo = 0;
        int contador = 0;
        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
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
                costo += 3160 * 2;
            } else {
                costo += 3160 * 1;
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
