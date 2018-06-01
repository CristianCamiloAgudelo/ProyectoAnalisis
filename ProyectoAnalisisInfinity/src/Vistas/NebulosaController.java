/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import java.net.URL;
import Controladores.ControlGeneral;
import Controladores.ControlNebulosa;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class NebulosaController implements Initializable {

    private ControlGeneral controlGeneral;
    private Nebulosa nebulosa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private SistemaPlanetario CrearSistemaPlanetario(ActionEvent event) {
        //  this.controlGeneral.CrearSistemaPlanetario(String nombre, 0,0);
        return null;
    }

    void setData(Nebulosa nebulosa) {
        this.nebulosa = nebulosa;
        System.out.println(this.nebulosa.getNombre());
    }

    /**
     * @return the controlGeneral
     */
    public ControlGeneral getControlGeneral() {
        return controlGeneral;
    }

    /**
     * @param controlGeneral the controlGeneral to set
     */
    public void setControlGeneral(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
    }

}
