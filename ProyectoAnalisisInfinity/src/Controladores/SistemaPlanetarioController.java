/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
    private Parent EntrarPlaneta(int codigoPlaneta)
    {
        return null;
    }

    @FXML
    private LinkedList CrearConexion(int codigo, Nodo nodo)
    {
        return null;
    }
    
    @FXML
    private void DefinirEstacionServicio(int codigoPlaneta)
    {
    }
    
    private Parent Volver()
    {
        return null;// volver a vista nebulosa
    }

    @FXML
    private void CrearElementos(ActionEvent event)
    {
    }

      
    
}
