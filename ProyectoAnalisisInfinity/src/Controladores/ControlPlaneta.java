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
 * @author Cristian Camilo Agudelo - Santiago Granada A.
 * @version 1.0
 *  
 */
public class ControlPlaneta {

    private int codigoPlaneta;
    private List<String> imagenPlanetas;
    private Planeta planeta;
/**
 * creacion del contructor por defecto
 */
    public ControlPlaneta() {
        this.codigoPlaneta = 0;
        this.imagenPlanetas = new LinkedList<>();
        this.imagenPlanetas.add("Imagenes/PlanetaTipo1Gif.gif");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo2Gif.gif");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo3.png");
        this.imagenPlanetas.add("Imagenes/PlanetaTipo4.png");
    }
/**
 * 
 * @param zero: Cantidad asignada del elemento Zero
 * @param iridio:Cantidad asignada del elemento Iridio
 * @param paladio: Cantidad asignada del elemento Paladio
 * @param platino: Cantidad asignada del elemento Platino
 * @return 
 */
    private Elementos crearElementos(int zero, int iridio, int paladio, int platino) {
        Elementos elementos = new Elementos(zero, iridio, paladio, platino);
        return elementos;
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
        
    public Planeta CrearPlaneta(String nombrePlaneta, Boolean enemigo, double posicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Elementos elementos = crearElementos(zero, iridio, paladio, platino);
        this.codigoPlaneta++;
        Planeta planetaA = new Planeta(this.codigoPlaneta, nombrePlaneta, elementos, false, posicionX, posicionY, this.imagenPlanetas.get(tipoPlaneta));
        return planetaA;
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
