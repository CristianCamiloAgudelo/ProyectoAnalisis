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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class FXMLDocumentController implements Initializable {

    FileLoader fileloader ;
    @FXML
    private Label label;
    @FXML
    private Button btnHola;
    @FXML
    private AnchorPane marco;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void CambioVista(ActionEvent event) throws MalformedURLException {
        
        String path = "src/Vistas/Universo.fxml";
        fileloader  = new FileLoader(path);
       
        this.marco.getChildren().clear();
        this.marco.getChildren().add(fileloader.open(path));
        
//        this.fileloader.open(path);

    }

    private URL checkFile(String path) throws MalformedURLException {
        URL response = null;
        File file = new File(path);
        if (file.exists()) {
            response = file.toURI().toURL();
        }
        return response;
    }

}
