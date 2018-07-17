/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.util.List;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 *
 * @author USER
 */
public class ControlUniverso {

    /**
     * @return the nave
     */
    public Nave getNave() {
        return nave;
    }

    private Universo universo;
    private Nave nave;
    private ControlNebulosa controlNebulosa;

    /**
     * creacion del constructor por defecto
     */
    public ControlUniverso() {
        this.controlNebulosa = new ControlNebulosa();
    }

    /**
     *
     * @param nombre : adquiero el nombre de el universo quien contendra toda la
     * informacion de nebulosas, sistemas olanetarios, planetas
     */
    public void CrearUniverso(String nombre) {
        this.setUniverso(new Universo(nombre));

    }

    /**
     * metodo para lograr guardar el el universo y todos sus componentes,
     * utlizando librerias JSON
     */
    public void GuardarUniverso() {

        try {
            JsonFactory factory = new JsonFactory();

            ObjectMapper objectMapper = new ObjectMapper(factory);
            String nombreArchivo = this.universo.getNombre() + ".json";
            objectMapper.writeValue(new File(nombreArchivo), this.universo);
        } catch (IOException ex) {
            System.out.println("error al cargar el archivo: " + ex);
        }
    }

    /**
     *
     * @param archivo: direccion del arvivo JSON anteriormente guardado y que
     * volveremos a cargar para su ejecucion
     */
    public void CargarUniverso(File archivo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.universo = new Universo();
            this.universo = mapper.readValue(archivo, Universo.class);
        } catch (IOException ex) {
            System.out.println("error al cargar el archivo: " + ex);
        }
    }

    /**
     *
     * @param nombreNave: al momento de relizar la simulacion pedira un nombre
     * de la nave para su posterior creacion
     */
    public void CrearNave(String nombreNave) {
        this.nave = new Nave(nombreNave, this.universo.getListaNebulosas().get(0).getPosicionX(), this.universo.getListaNebulosas().get(0).getPosicionY());
    }

    /**
     *
     * @param nombre: nombre de la nebulosa ue deseamos crear
     * @param enemigo: este parametro llega de la conformacion de enemigos
     * pedida en la Nebulosa
     * @param posicionX: creacion en X de su creacion
     * @param posicionY: creacion en Y de su creacion
     * @param tipoNebulosa : Tipo de nebulosa la cual es escogida deacuerdo a
     * una imagen en el panel
     */
    public void AgregarNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        Nebulosa nebulosa = this.controlNebulosa.CrearNebulosa(nombre, enemigo, posicionX, posicionY, tipoNebulosa);
        this.universo.getListaNebulosas().add(nebulosa);

    }

    /**
     *
     * @param nebulosaInicial : indica de que nodo empezara la arista para
     * trazar un camino
     * @param nebulosaFinal : Indica de que nodo finalizara la arista para
     * trazar un camino
     *
     */
    public void AgregarAdyasenciaNebulosa(Nebulosa nebulosaInicial, Nebulosa nebulosaFinal) {
        nebulosaInicial.getAdyacencias().add(new Nodo(nebulosaFinal.getNombre(), 0));
        nebulosaFinal.getAdyacencias().add(new Nodo(nebulosaInicial.getNombre(), 0));
    }

    /**
     *
     * @param nombreNebulosa: nombre de la nebulosa donde se va a ingresar
     * @return Nebulosa
     */
    public Nebulosa EntrarNebulosa(String nombreNebulosa) {
        Nebulosa nebulosa = BuscarNebulosa(nombreNebulosa);
        this.ActualizarNebulosa(nebulosa);
        return nebulosa;
    }

    /**
     *
     * @param nombreNebulosa: nombre de la nebulosa la cual queremos buscar para entrar en ella
     * @return Nebulosa
     */
    public Nebulosa BuscarNebulosa(String nombreNebulosa) {

        for (Nebulosa nebulosa : this.universo.getListaNebulosas()) {
            if (nebulosa.getNombre().equals(nombreNebulosa)) {
                return nebulosa;
            }
        }
        return null;
    }

    /**
     *
     * @param nebulosa
     */
    private void ActualizarNebulosa(Nebulosa nebulosa) {
        this.controlNebulosa.setNebulosa(nebulosa);
    }

    /**
     *
     * @return signa a una lista de nebulosas, la lista obtenida de nebulosas
     * por universo
     */
    public List<Nebulosa> ListaNebulosas() {
        List<Nebulosa> nebulosas = this.universo.getListaNebulosas();
        return nebulosas;
    }

    /**
     *
     * @param nombreSistemaPlanetario : Nombre del sistema planetario al momento
     * de su creacion
     * @param enemigo: booleano que indicara si habra enemigos en esa nebulosa.
     * @param posicionX: posicion en X donde se crea la Nebulosa
     * @param posicionY: posicion en Y donde se crea la nebulosa
     * @param tipoSistemaPlanetario : Tipo de sistema planetario la cual es
     * escogida deacuerdo a una imagen en el panel
     * @return SistemaPlanetario
     */
    public SistemaPlanetario AgregarSistemaPlanetario(String nombreSistemaPlanetario, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlNebulosa.AgregarSistemaPlanetario(nombreSistemaPlanetario, enemigo, posicionX, posicionY, tipoSistemaPlanetario);
        return sistemaPlanetario;
    }

    /**
     *
     * @param sistemaPlanetarioInicial: indica de que nodo empezara la arista
     * para trazar un camino
     * @param sistemaPlanetarioFinal: Indica de que nodo finalizara la arista
     * para trazar un camino
     * @param peso: indica cuanto sera el peso de ese camino.
     */
    public void AgregarAdyasenciaSistemaPlanetario(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal, int peso) {
        this.controlNebulosa.AgregarAdyasenciaSistemaPlanetario(sistemaPlanetarioInicial, sistemaPlanetarioFinal, peso);
    }
    /**
     * 
     * @param nombreSistemaPlanetario: nombre del sistema planetario al cual deseo ingresar
     * @return SistemaPlanetario
     */

    public SistemaPlanetario EntrarSistemaPlanetario(String nombreSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlNebulosa.EntrarSistemaPlanetario(nombreSistemaPlanetario);
        return sistemaPlanetario;
    }
/**
 * 
 * @param nombreSistemaPlanetario
 * @return SistemaPlanetario
 */
    public SistemaPlanetario BuscarSistemaPlanetario(String nombreSistemaPlanetario) {
        return this.controlNebulosa.BuscarSistemaPlanetario(nombreSistemaPlanetario);

    }
    /**
     * asigna a una lista de sistemas planetarios, la lista obtenida de planetas por sistemaplanetario
     * @return 
     */
    public List<SistemaPlanetario> ListaSistemasPlanetarios() {
        List<SistemaPlanetario> sistemasPlanetarios = this.controlNebulosa.ListaSistemasPlanetarios();
        return sistemasPlanetarios;
    }
/**
 * 
 * @param nombrePlaneta: realiza la busqueda si existe en la lista de planetas
 * @return Planeta
 */
    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlNebulosa.AgregarPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, platino, paladio);
        return planeta;
    }
/**
 * 
 * @param nombrePlaneta: nomre del plneta que se busca para poder agregarlo
 * @return Planeta
 */
    public Planeta BuscarPlaneta(String nombrePlaneta) {
        return this.controlNebulosa.BuscarPlaneta(nombrePlaneta);
    }

    public void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
        this.controlNebulosa.AgregarAdyasenciaPlaneta(planetaInicial, planetaFinal);
    }
/**
 * 
 * @param nombrePlaneta: nombre del planeta para poder ingresar a el
 * @return Planeta
 */
    public Planeta EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = this.controlNebulosa.EntrarPlaneta(nombrePlaneta);
        return planeta;
    }
/**
 * 
 * @return List<>planetas
 */
    public List<Planeta> ListaPlanetas() {
        List<Planeta> planetas = this.controlNebulosa.ListaPlanetas();
        return planetas;
    }

    public Planeta getPlaneta() {
        return this.controlNebulosa.getPlaneta();
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
