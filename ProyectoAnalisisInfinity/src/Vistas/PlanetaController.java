/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControlUniverso;
import Modelo.FileLoader;
import Modelo.VistaGenerica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class PlanetaController implements Initializable {

    private ControlUniverso controlUniverso;
    @FXML
    private AnchorPane VistaPlaneta;
    private AnchorPane marco;
    @FXML
    private ImageView atrasPlaneta;
    private FileLoader fileLoader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AtrasPlaneta(MouseEvent event) {
        this.fileLoader = new FileLoader("src/Vistas/SistemaPlanetario.fxml");
        VistaGenerica vistaSistemaPlanetario = fileLoader.open("sistemaplanetario");

        SistemaPlanetarioController sistemaPlanetarioController = (SistemaPlanetarioController) vistaSistemaPlanetario.getController();
        sistemaPlanetarioController.setData(marco, this.controlUniverso.ListaPlanetas());
        sistemaPlanetarioController.setControlUniverso(this.controlUniverso);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaSistemaPlanetario.getParent());
    }

    public void setData(AnchorPane marco) {
        this.marco = marco;
        final GridPane grid = new GridPane();
        grid.setLayoutX(160);
        grid.setLayoutY(550);
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
        Button boton = new Button("Estacion de servicio");
        boton.setId("btn");
        grid.add(boton, 0, 1);
        this.VistaPlaneta.getChildren().add(grid);
    }

    /**
     * @return the controlUniverso
     */
    public ControlUniverso getControlUniverso() {
        return controlUniverso;
    }

    /**
     * @param controlUniverso the controlUniverso to set
     */
    public void setControlUniverso(ControlUniverso controlUniverso) {
        this.controlUniverso = controlUniverso;
    }

}
