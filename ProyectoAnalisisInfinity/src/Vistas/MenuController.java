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
import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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
            input.setPromptText("Nombre Universo");
            grid.addRow(0, input);
            // boton
            Button boton = new Button("Iniciar Creacion");
            EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controlUniverso.CrearUniverso(input.getText());
                    fileloader = new FileLoader("src/Vistas/Universo.fxml");
                    VistaGenerica vistaUniverso = fileloader.open("universo");
                    UniversoController universoController = (UniversoController) vistaUniverso.getController();
                    universoController.setData(marco, controlUniverso.ListaNebulosas());
                    universoController.setControlUniverso(controlUniverso);
                    marco.getChildren().clear();
                    marco.getChildren().add(vistaUniverso.getParent());
                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            this.marco.getChildren().add(grid);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void CargarMapa(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar");
        File file = new File("C:\\Users\\USER\\Documents\\GitHub\\ProyectoAnalisis\\ProyectoAnalisisInfinity");
        fileChooser.setInitialDirectory(file);
        fileChooser.setSelectedExtensionFilter(new ExtensionFilter("JSON files", "*.json*"));
        fileChooser.setTitle("Open Resource File");
        File archivo = fileChooser.showOpenDialog(this.MenuPane.getScene().getWindow());
        System.out.println(archivo.getName());
        this.controlUniverso.CargarUniverso(archivo);
        this.fileloader = new FileLoader("src/Vistas/Universo.fxml");
        VistaGenerica vistaUniverso = fileloader.open("universo");
        UniversoController universoController = (UniversoController) vistaUniverso.getController();
        universoController.setControlUniverso(this.controlUniverso);
        universoController.setData(this.marco, this.controlUniverso.ListaNebulosas());
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaUniverso.getParent());
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
        imagen.setId("infinityShip");
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
                universoController.PintarNave();
                universoController.iniciarSimulacion();
                marco.getChildren().clear();
                marco.getChildren().add(vistaUniverso.getParent());
            }
        };
        boton.setOnAction(evento);
        grid.addRow(3, boton);
        this.marco.getChildren().add(grid);
//        this.controlUniverso.CrearNave()
    }

    @FXML
    private void GuardarMapa(ActionEvent event) {
        this.controlUniverso.GuardarUniverso();
        this.fileloader = new FileLoader("src/Vistas/Menu.fxml");
        VistaGenerica vistaMenu = fileloader.open("menu");
        MenuController menuController = (MenuController) vistaMenu.getController();
        this.MenuPane.getChildren().clear();
        this.MenuPane.getChildren().add(vistaMenu.getParent());

    }
}
