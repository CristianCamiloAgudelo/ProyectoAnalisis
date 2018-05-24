/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
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
import java.util.Scanner;
import org.json.JSONObject;


/**
 *
 * @author usuario
 */
public class MenuController implements Initializable {

    FileLoader fileloader;
    @FXML
    private Label label;
    @FXML
    private Button btnHola;
    @FXML
    private AnchorPane marco;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String ruta = "src/Vistas/Universo.fxml";
        fileloader = new FileLoader(ruta);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(fileloader.open(ruta));
    }

    private void CambioVista(String ruta) throws MalformedURLException {

        fileloader = new FileLoader(ruta);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(fileloader.open(ruta));

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

    @FXML
    private void PedirRuta(ActionEvent event) throws MalformedURLException {
        Scanner sc = new Scanner(System.in);
        String ruta, palabraB;
        System.out.println("Introduzca la ruta del archivo: ");
        ruta = sc.nextLine();
        CambioVista(ruta);
    }

    @FXML
    private Universo CargarUniverso(JSONObject Universo)
    {
        return null;
    }
    
    @FXML
    private Universo CrearUniverso(ActionEvent event)
    {
        return null;
    }
    
    @FXML
    private void TeletrasportarNebulosa(ActionEvent event)
    {
        
    }
    
    @FXML
    private void IniciarSimulacion(ActionEvent event)
    {
        
    }
}
