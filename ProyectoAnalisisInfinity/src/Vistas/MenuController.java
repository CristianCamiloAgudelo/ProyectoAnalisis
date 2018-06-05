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
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
    
    private ControlUniverso controlUniverso;
    
    @FXML
    private Button BotonCrearMapa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controlUniverso = new ControlUniverso();
    }
    
    @FXML
    private void CrearMapa(ActionEvent event) throws MalformedURLException {
        try {
            this.controlUniverso.CrearUniverso("Universo1");
            this.fileloader = new FileLoader("src/Vistas/Universo.fxml");
            VistaGenerica vistaUniverso = fileloader.open("universo");
            UniversoController universoController = (UniversoController) vistaUniverso.getController();
            universoController.setData(marco, this.controlUniverso.ListaNebulosas());
            universoController.setControlUniverso(this.controlUniverso);
            this.marco.getChildren().clear();
            this.marco.getChildren().add(vistaUniverso.getParent());
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    @FXML
    private void CargarMapa(ActionEvent event) {
    }
    
    @FXML
    private void IniciarSimulacion(ActionEvent event) {
        GridPane grid = new GridPane();
        grid.setLayoutX(600);
        grid.setLayoutY(300);
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.CENTER);
        leftCol.setHgrow(Priority.ALWAYS);
        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHalignment(HPos.CENTER);
        rightCol.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(leftCol, rightCol);
        //input
        TextField input = new TextField("");
        input.setPromptText("¿Que nombre tendra tu nave?");
        grid.addRow(0, input);
        //imagen
        ImageView imagen = new ImageView("Imagenes/Nave1.png");
        grid.addRow(2, imagen);

        // boton
        Button boton = new Button("Iniciar Simulacion");
        EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controlUniverso.CrearNave(input.getText());
                fileloader = new FileLoader("src/Vistas/Universo.fxml");
                VistaGenerica vistaUniverso = fileloader.open("universo");
                UniversoController universoController = (UniversoController) vistaUniverso.getController();
                universoController.setControlUniverso(controlUniverso);
                universoController.setData(marco, controlUniverso.ListaNebulosas());
                universoController.setSimulacion(true);
                universoController.PintarNave();
                marco.getChildren().clear();
                marco.getChildren().add(vistaUniverso.getParent());
            }
        };
        boton.setOnAction(evento);
        grid.addRow(3, boton);
        this.marco.getChildren().add(grid);
//        this.controlUniverso.CrearNave()
    }
}
