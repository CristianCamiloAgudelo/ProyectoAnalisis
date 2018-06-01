/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControlUniverso;
import Modelo.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class SistemaPlanetarioController implements Initializable {

    @FXML
    private ImageView tipo2;
    @FXML
    private AnchorPane VistaSistemaPlanetario;
    @FXML
    private ImageView tipo1;
    @FXML
    private AnchorPane scroll;
    private ControlUniverso controlUniverso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Planeta CrearPlaneta(ActionEvent event) {
        return null;
    }


    void setData(SistemaPlanetario sistemaPlanetario, AnchorPane marco) {
       
    }


    @FXML
    private void crearTipo1(MouseEvent event) {
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
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
