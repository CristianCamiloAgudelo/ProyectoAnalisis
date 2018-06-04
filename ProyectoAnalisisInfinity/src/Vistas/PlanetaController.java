/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControlUniverso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class PlanetaController implements Initializable {

    private ControlUniverso controlUniverso;
    @FXML
    private AnchorPane VistaPlaneta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(AnchorPane marco) {

    }

    /**
     * @return the controlUniverso
     */
    public ControlUniverso getControlUniverso() {
        return controlUniverso;
    }

    /**
     * @param controlUniverso the controlUniverso to set
     */
    public void setControlUniverso(ControlUniverso controlUniverso) {
        this.controlUniverso = controlUniverso;
    }

}
