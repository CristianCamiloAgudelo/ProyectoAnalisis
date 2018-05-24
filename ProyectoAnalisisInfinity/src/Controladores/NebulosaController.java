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
public class NebulosaController implements Initializable
{
    @FXML
    private Button CrearSistemaPlanetario;
    @FXML
    private Button AtrasNebulosa;
    @FXML
    private Button CrearNebulosa1;
    @FXML
    private Button crearEnemigo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    
    @FXML
    private SistemaPlanetario CrearSistemaPlanetario(ActionEvent event)
    {
        return null;
    }
    
    @FXML
    private Parent EntrarSistemaPlanetario(int codigoSistemaPlanetario)
    {
        return null;
    }
    
    @FXML
    private LinkedList CrearConexion(int codigo, Nodo nodo)
    {
        return null;
    }
    @FXML
    private void CrearEnemigos()
    {
        
    }
    
    private Parent Volver()
    {
        return null;// volver a vista universo
    }

    
    
}
