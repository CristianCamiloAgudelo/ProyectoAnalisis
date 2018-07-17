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
 * @author Cristian Camilo Agudelo - Santiago Granada A.
 * @version 1.0
 *  
 */
public class ControlNebulosa {

    private Nebulosa nebulosa;
    private int codigoNebulosa;
    private int codigoImagen;
    private List<String> imagenes;
    private final ControlSistemaPlanetario controlSistemaPlanetario;
/**
 * Creacion del Constructor por defecto
 */
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
/**
 * 
 * @param costoBeneficio: 
 * @param cantidadAbyasencias: 
 * @param combustible: 
 * @return 
 */
    private double CalcularHeuristica(double costoBeneficio, double cantidadAbyasencias, double combustible) {
        costoBeneficio *= 100;
        cantidadAbyasencias *= 10;
        combustible *= 5;
        double heuristica = (costoBeneficio + cantidadAbyasencias) - combustible;
        return heuristica;

    }
/**
 * 
 * @param nombre: Nombre de la nebulosa al momento de su creacion   
 * @param enemigo: booleano que indicara si habra enemigos en esa nebulosa.
 * @param posicionX: posicion en X donde se crea la Nebulosa
 * @param posicionY: posicion en Y donde se crea la nebulosa
 * @param tipoNebulosa: Tipo de nebulosa la cual es escogida deacuerdo a una imagen en el panel
 * @return Nebulosa
 */
    public Nebulosa CrearNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        this.codigoNebulosa++;
        Nebulosa nebulosa = (new Nebulosa(this.codigoNebulosa, nombre, enemigo, posicionX, posicionY, this.imagenes.get(tipoNebulosa)));
        return nebulosa;
    }
/**
 * 
 * @param nombre: Nombre de la nebulosa al momento de su creacion   
 * @param enemigo: booleano que indicara si habra enemigos en esa nebulosa.
 * @param posicionX: posicion en X donde se crea la Nebulosa
 * @param posicionY: posicion en Y donde se crea la nebulosa
 * @param tipoSistemaPlanetario : Tipo de nebulosa la cual es escogida deacuerdo a una imagen en el panel
 * @return SistemaPlanetario
 */
    public SistemaPlanetario AgregarSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlSistemaPlanetario.CrearSistamPlanetario(nombre, enemigo, posicionX, posicionY, tipoSistemaPlanetario);
        this.nebulosa.getListaSistemasPlanetarios().add(sistemaPlanetario);
        return sistemaPlanetario;
    }
/**
 * 
 * @param sistemaPlanetarioInicial: indica de que nodo empezara la arista para trazar un camino
 * @param sistemaPlanetarioFinal: Indica de que nodo finalizara la arista para trazar un camino
 * @param peso: indica cuanto sera el peso de ese camino.
 */
    void AgregarAdyasenciaSistemaPlanetario(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal, int peso) {
        sistemaPlanetarioInicial.getAdyacencias().add(new Nodo(sistemaPlanetarioFinal.getNombre(), peso));
        sistemaPlanetarioFinal.getAdyacencias().add(new Nodo(sistemaPlanetarioInicial.getNombre(), peso));
    }
/**
 * 
 * @param nombreSistemaPlanetario: obtiene el nombre del sistema planetario en el cual desea ingresar
 * @return 
 */
    public SistemaPlanetario EntrarSistemaPlanetario(String nombreSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = BuscarSistemaPlanetario(nombreSistemaPlanetario);
        this.ActualizarSistemaPlanetario(sistemaPlanetario);
        return sistemaPlanetario;
    }
/**
 * 
 * @param nombreSistemaPlanetario: realiza la busqueda si existe en la lista de sistemas planetarios 
 * @return 
 */
    public SistemaPlanetario BuscarSistemaPlanetario(String nombreSistemaPlanetario) {
        for (SistemaPlanetario sistemasPlanetario : this.nebulosa.getListaSistemasPlanetarios()) {
            if (sistemasPlanetario.getNombre().equals(nombreSistemaPlanetario)) {
                return sistemasPlanetario;

            }
        }
        return null;
    }
    /**
     * 
     * @param sistemaPlanetario 
     */

    private void ActualizarSistemaPlanetario(SistemaPlanetario sistemaPlanetario) {
        this.controlSistemaPlanetario.setSistemaPlanetario(sistemaPlanetario);
    }
/**
 * asigna a una lista de sistemas planetarios la lista obtenida de sistemas planetrios por Nebulosa
 * @return 
 */
    public List<SistemaPlanetario> ListaSistemasPlanetarios() {
        List<SistemaPlanetario> sistemasPlanetarios = this.nebulosa.getListaSistemasPlanetarios();
        return sistemasPlanetarios;
    }
    /**
     * 
     * @param nombrePlaneta: nombre del planeta que sea crear
     * @param enemigo: este parametro llega de la conformacion de enemigos pedida en la Nebulosa
     * @param posicionX: creacion en X de su creacion
     * @param posicionY: creacion en Y de su creacion
     * @param tipoPlaneta: Tipo de planeta la cual es escogida deacuerdo a una imagen en el panel
     * @param zero: cantidad deseada a crear del elemnto Zero
     * @param iridio: cantidad deseada a crear del elemnto Iridio
     * @param paladio:cantidad deseada a crear del elemnto Paladio
     * @param platino: cantidad deseada a crear del elemnto Platino
     * @return 
     */

    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlSistemaPlanetario.AgregarPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        return planeta;
    }
/**
 * 
 * @param nombrePlaneta: realiza la busqueda si existe en la lista de planetas
 * @return 
 */
    public Planeta BuscarPlaneta(String nombrePlaneta) {
        return this.controlSistemaPlanetario.BuscarPlaneta(nombrePlaneta);
    }
/**
 * 
 * @param planetaFinal : indica de que nodo empezara la arista para trazar un camino
 * @param planetaInicial : Indica de que nodo finalizara la arista para trazar un camino
 * 
 */
    void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
        this.controlSistemaPlanetario.AgregarAdyasenciaPlaneta(planetaInicial, planetaFinal);
    }
/**
 * 
 * @param nombrePlaneta: Ingresa al planeta deseado dando click sobre el
 * @return 
 */
    public Planeta EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = this.controlSistemaPlanetario.EntrarPlaneta(nombrePlaneta);
        return planeta;
    }
    /**
     * 
     * @return signa a una lista de planetas, la lista obtenida de planetas por sistemaplanetario
     */

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
