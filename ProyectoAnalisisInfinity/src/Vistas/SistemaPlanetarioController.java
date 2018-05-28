/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class SistemaPlanetarioController implements Initializable
{
    @FXML
    private Button crearPlaneta;
    @FXML
    private Button crearConexion;
    @FXML
    private Button crearElementos;
    @FXML
    private Button crearEstacionCombustible;
    @FXML
    private Button revisarMejoras;
    @FXML
    private Button atrasSistemaPlanetario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private Planeta CrearPlaneta(ActionEvent event)
    {
        return null;
    }
    
  

    @FXML
    private void CrearElementos(ActionEvent event)
    {
    }

    @FXML
    private void CrearConexion(ActionEvent event) {
    }

    @FXML
    private void CrearEstacionServicio(ActionEvent event) {
    }

    @FXML
    private void RevisarMejoras(ActionEvent event) {
    }

    @FXML
    private void AtrasSistemaPlanetario(ActionEvent event) {
    }

      
    
}
