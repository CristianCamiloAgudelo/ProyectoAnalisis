/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import java.net.URL;
import Controladores.ControlNebulosas;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class NebulosaController implements Initializable {

    @FXML
    private Button CrearSistemaPlanetario;
    @FXML
    private Button AtrasNebulosa;
    @FXML
    private Button CrearNebulosa1;
    @FXML
    private Button crearEnemigo;
    
    private ControlNebulosas controlNebulosa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private SistemaPlanetario CrearSistemaPlanetario(ActionEvent event) {
        controlNebulosa.
        return null;
    }

    @FXML
    private void CrearNebulosa(ActionEvent event) {
    }

    @FXML
    private void CrearEnemigo(ActionEvent event) {
    }

}
