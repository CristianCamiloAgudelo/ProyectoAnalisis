/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.VistaGenerica;
import Modelo.Universo;
import Controladores.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import Modelo.FileLoader;
import java.net.MalformedURLException;
import javafx.scene.control.Button;
//import org.json.JSONObject;

/**
 *
 * @author usuario
 */
public class MenuController implements Initializable {

    FileLoader fileloader;
    @FXML
    private AnchorPane marco;
    @FXML
    private AnchorPane MenuPane;

    private ControlGeneral controlGeneral;

    @FXML
    private Button BotonCrearMapa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controlGeneral = new ControlGeneral();
    }

    @FXML
    private void CrearMapa(ActionEvent event) throws MalformedURLException {
        Universo universo = this.controlGeneral.CrearUniverso("Universo1");
        this.controlGeneral.getPila().add(universo.getNombre());
        
        this.fileloader = new FileLoader("src/Vistas/Universo.fxml");
        VistaGenerica vistaUniverso = fileloader.open("universo");
        UniversoController universoController = (UniversoController) vistaUniverso.getController();
        universoController.setData(universo);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaUniverso.getParent());

    }

    @FXML
    private void CargarMapa(ActionEvent event) {
    }
}
