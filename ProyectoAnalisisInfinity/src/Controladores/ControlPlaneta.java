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
        this.imagenPlanetas.add("Imagenes/PlanetaTipo1Gif.gif");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo2Gif.gif");
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
        Planeta planetaA = new Planeta(this.codigoPlaneta, nombrePlaneta, elementos, false, posicionX, posicionY, this.imagenPlanetas.get(tipoPlaneta));
        return planetaA;
    }

    public double CalcularBeneficio(Planeta planeta) {
        double beneficio = 0;
        if (planeta.isExprorable()) {
            beneficio += planeta.getElementos().getZero() * 4;
            beneficio += planeta.getElementos().getPlatino() * 3;
            beneficio += planeta.getElementos().getPaladio() * 2;
            beneficio += planeta.getElementos().getIridio();
            //System.out.println("nombre planeta: "+ planeta.getNombre()+ "beneficio: "+beneficio);
        }
        return beneficio;
    }

    public double CalcularCosto(Planeta planeta) {
        double costo = 0;
        if (planeta.getElementos().getZero() != 0) {
            costo += 270;
        }
        if (planeta.getElementos().getPlatino() != 0) {
            costo += 270;
        }
        if (planeta.getElementos().getPaladio() != 0) {
            costo += 270;
        }
        if (planeta.getElementos().getIridio() != 0) {
            costo += 270;
        }

        return costo;
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
