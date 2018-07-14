/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vistas.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 *
 * @author USER
 */
public class VistaGenerica {
    private Parent parent;
    private Initializable Controller;

    public VistaGenerica() {
    }
    

    public VistaGenerica(Parent parent, UniversoController Controller) {
        this.parent = parent;
        this.Controller = Controller;
    }
    public VistaGenerica(Parent parent, NebulosaController Controller) {
        this.parent = parent;
        this.Controller = Controller;
    }
    public VistaGenerica(Parent parent, SistemaPlanetarioController Controller) {
        this.parent = parent;
        this.Controller = Controller;
    }
    public VistaGenerica(Parent parent, PlanetaController Controller) {
        this.parent = parent;
        this.Controller = Controller;
    }
    public VistaGenerica(Parent parent, MenuController Controller) {
        this.parent = parent;
        this.Controller = Controller;
    }

    /**
     * @return the parent
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * @return the Controller
     */
    public Initializable getController() {
        return Controller;
    }

    /**
     * @param Controller the Controller to set
     */
    public void setController(Initializable Controller) {
        this.Controller = Controller;
    }
    
    
}
