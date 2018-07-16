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

    public ControlUniverso() {
        this.controlNebulosa = new ControlNebulosa();
    }

    public void CrearUniverso(String nombre) {
        this.setUniverso(new Universo(nombre));

    }

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

    public void CargarUniverso(File archivo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.universo = new Universo();
            this.universo = mapper.readValue(archivo, Universo.class);
        } catch (IOException ex) {
            System.out.println("error al cargar el archivo: " + ex);
        }
    }

    public void CrearNave(String nombreNave) {
        this.nave = new Nave(nombreNave, this.universo.getListaNebulosas().get(0).getPosicionX(), this.universo.getListaNebulosas().get(0).getPosicionY());
    }

    public void AgregarNebulosa(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        Nebulosa nebulosa = this.controlNebulosa.CrearNebulosa(nombre, enemigo, posicionX, posicionY, tipoNebulosa);
        System.out.println("agregue nebulosa");
        this.universo.getListaNebulosas().add(nebulosa);

    }

    public void AgregarAdyasenciaNebulosa(Nebulosa nebulosaInicial, Nebulosa nebulosaFinal) {
        nebulosaInicial.getAdyacencias().add(new Nodo(nebulosaFinal.getNombre(), 0));
        nebulosaFinal.getAdyacencias().add(new Nodo(nebulosaInicial.getNombre(), 0));
    }

    public Nebulosa EntrarNebulosa(String nombreNebulosa) {
        Nebulosa nebulosa = BuscarNebulosa(nombreNebulosa);
        this.ActualizarNebulosa(nebulosa);
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

    private void ActualizarNebulosa(Nebulosa nebulosa) {
        this.controlNebulosa.setNebulosa(nebulosa);
    }

    public List<Nebulosa> ListaNebulosas() {
        List<Nebulosa> nebulosas = this.universo.getListaNebulosas();
        return nebulosas;
    }

    public SistemaPlanetario AgregarSistemaPlanetario(String nombreSistemaPlanetario, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlNebulosa.AgregarSistemaPlanetario(nombreSistemaPlanetario, enemigo, posicionX, posicionY, tipoSistemaPlanetario);
        return sistemaPlanetario;
    }

    public void AgregarAdyasenciaSistemaPlanetario(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal, int peso) {
        this.controlNebulosa.AgregarAdyasenciaSistemaPlanetario(sistemaPlanetarioInicial, sistemaPlanetarioFinal, peso);
    }

    public SistemaPlanetario EntrarSistemaPlanetario(String nombreSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.controlNebulosa.EntrarSistemaPlanetario(nombreSistemaPlanetario);
        return sistemaPlanetario;
    }

    public SistemaPlanetario BuscarSistemaPlanetario(String nombreSistemaPlanetario) {
        return this.controlNebulosa.BuscarSistemaPlanetario(nombreSistemaPlanetario);

    }

    public List<SistemaPlanetario> ListaSistemasPlanetarios() {
        List<SistemaPlanetario> sistemasPlanetarios = this.controlNebulosa.ListaSistemasPlanetarios();
        return sistemasPlanetarios;
    }

    public Planeta AgregarPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlNebulosa.AgregarPlaneta(nombrePlaneta, enemigo, posicionX, posicionY, tipoPlaneta, zero, iridio, platino, paladio);
        return planeta;
    }

    public Planeta BuscarPlaneta(String nombrePlaneta) {
        return this.controlNebulosa.BuscarPlaneta(nombrePlaneta);
    }

    public void AgregarAdyasenciaPlaneta(Planeta planetaInicial, Planeta planetaFinal) {
        this.controlNebulosa.AgregarAdyasenciaPlaneta(planetaInicial, planetaFinal);
    }

    public Planeta EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = this.controlNebulosa.EntrarPlaneta(nombrePlaneta);
        return planeta;
    }

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

    public List<SistemaPlanetario> IniciarRecorrido() {
        return this.controlNebulosa.IniciarRecorrido();
    }

}
