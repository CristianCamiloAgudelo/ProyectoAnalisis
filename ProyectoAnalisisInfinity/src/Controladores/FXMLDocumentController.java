/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import Modelo.FileLoader;
import java.io.File;
import java.net.MalformedURLException;

/**
 *
 * @author usuario
 */
public class FXMLDocumentController implements Initializable
{
    FileLoader fileloader;
    @FXML
    private Label label;
    @FXML
    private Button btnHola;
    
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    private void detectame(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    private void hola(ActionEvent event)
    {
         System.out.println("You clicked me!");
        label.setText("Hello World!");    }

    private void CambioVista(ActionEvent event) throws MalformedURLException {
        String path = "src/Vistas/Universo.fxml";
        URL url = checkFile(path);
        if (url != null){
            this.fileloader.setPath(path);
            this.fileloader.open(path);
        }
        
       
    }
private URL checkFile(String path) throws MalformedURLException
    {
        URL response = null;
        File file = new File(path);
        if (file.exists())
            response = file.toURI().toURL();
        return response;
    }

    @FXML
    private void CambiarVista(ActionEvent event) {
    }
    
}
