/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Planeta;
import Modelo.Elementos;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class ControlPlaneta {

    private int codigoPlaneta;
    private List<String> imagenPlanetas;
    private Planeta planeta;

    public ControlPlaneta() {
        this.codigoPlaneta = 0;
        this.imagenPlanetas = new LinkedList<>();
        this.imagenPlanetas.add("Imagenes/PlanetaTipo1.png");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo2.png");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo3.png");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo4.png");
    }

    private Elementos crearElementos(int zero, int iridio, int paladio, int plaino) {
        Elementos elementos = new Elementos(zero, iridio, paladio, plaino);
        return elementos;
    }

    public Planeta CrearPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Elementos elementos = crearElementos(zero, iridio, paladio, platino);
        this.codigoPlaneta++;
        Planeta planeta = new Planeta(this.codigoPlaneta, nombrePlaneta, elementos, false, posicionX, posicionY, this.imagenPlanetas.get(tipoPlaneta));
        return planeta;
    }

    private void EntrarEstacionCombustible() {

    }

    /**
     * @return the planeta
     */
    public Planeta getPlaneta() {
        return planeta;
    }

    /**
     * @param planeta the planeta to set
     */
    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

}
