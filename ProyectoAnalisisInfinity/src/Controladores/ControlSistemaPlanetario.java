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
 * @author Cristian Camilo Agudelo - Santiago Granada A.
 * @version 1.0
 *  
 */
public class ControlSistemaPlanetario {

    private int codigoSistemaPlanetario;
    private final ControlPlaneta controlPlaneta;
    private SistemaPlanetario sistemaPlanetario;
    private final List<String> imagenesSistemasPlanetarios;
/**
 * Creacion del Constructor por defecto
 */
    public ControlSistemaPlanetario() {
        this.codigoSistemaPlanetario = 0;
        this.controlPlaneta = new ControlPlaneta();
        this.imagenesSistemasPlanetarios = new LinkedList<>();
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo1.png");
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo2.png");
        this.imagenesSistemasPlanetarios.add("Imagenes/SistemaPlanetarioTipo3.png");
    }
/**
 * 
 * @param nombre: nombre que se dara al sustema planetario creado
 * @param enemigo: booleano que indicara si habra enemigos en esa nebulosa.
 * @param posicionX: posicion en X donde se crea del sistema planetario
 * @param posicionY: posicion en Y donde se crea del sistema planetario
 * @param tipoSistemaPlanetario
 * @return SistemaPlanetario
 */
    public SistemaPlanetario CrearSistamPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        this.codigoSistemaPlanetario++;
        SistemaPlanetario sistemaPlanetario = new SistemaPlanetario(this.codigoSistemaPlanetario, nombre, enemigo, posicionX, posicionY, this.imagenesSistemasPlanetarios.get(tipoSistemaPlanetario));
        return sistemaPlanetario;
    }
/**
 * 
 * @param nombrePlaneta:Nombre del planeta al momento de su creacion  
 * @param enemigo: booleano que indicara si habra enemigos en esa nebulosa.
 * @param posicionX: posicion en X donde se crea la Nebulosa
 * @param posicionY: posicion en Y donde se crea la nebulosa
 * @param tipoPlaneta : Tipo de nebulosa la cual es escogida deacuerdo a una imagen en el panel
 * @param zero : cantidad del elemento Zero en ese Planeta
 * @param iridio: cantidad del elemento Iridio en ese Planeta
 * @param paladio: cantidad del elemento paladio en ese Planeta
 * @param platino: cantidad del elemento platino en ese Planeta
 * @return Planeta
 */
    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlPlaneta.CrearPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        this.sistemaPlanetario.getListaPlanetas().add(planeta);
        return planeta;
    }
/**
 * 
 * @param planetaInicial  : indica de que nodo empezara la arista para trazar un camino
 * @param planetaFinal : Indica de que nodo finalizara la arista para trazar un camino
 */
    public void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
        planetaInicial.getAdyacencias().add(new Nodo(planetaFinal.getNombre(), 0));
        planetaFinal.getAdyacencias().add(new Nodo(planetaInicial.getNombre(), 0));
    }
    /**
     * 
     * @param nombrePlaneta: nombre del planeta donde voy a ingresar
     * @return Planeta
     */

    public Planeta EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = BuscarPlaneta(nombrePlaneta);
        System.out.println("planeta:    " + planeta.getNombre() + planeta.getElementos().getZero());
        this.ActualizarPlaneta(planeta);
        return planeta;
    }
/**
 * 
 * @param nombrePlaneta: Busca el planeta para ser llamado el momento de ingresar
 * @return Planeta
 */
    public Planeta BuscarPlaneta(String nombrePlaneta) {
        for (Planeta planeta : this.sistemaPlanetario.getListaPlanetas()) {
            if (planeta.getNombre().equals(nombrePlaneta)) {
                return planeta;
            }
        }
        return null;
    }
/**
 * 
 * @return double
 */
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
     * @return double
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
/**
 * 
 * @param planeta 
 */
    private void ActualizarPlaneta(Planeta planeta) {
        this.controlPlaneta.setPlaneta(planeta);
    }
/**
 * asigna a una lista de planetas la lista obtenida de planetas por sistema planetario
 * @return List<>planetas
 * 
 */
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
