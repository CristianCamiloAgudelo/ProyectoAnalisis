/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.*;
import Modelo.*;
import Modelo.VistaGenerica;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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

    @FXML
    private Label labelZero;
    @FXML
    private Label labelIridio;
    @FXML
    private Label labelPaladio;
    @FXML
    private Label labelPlatino;
    @FXML
    private ProgressBar zero;
    @FXML
    private ProgressBar paladio;
    @FXML
    private ProgressBar iridio;
    @FXML
    private ProgressBar platino;

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
        sistemaPlanetarioController.setControlUniverso(this.controlUniverso);
        sistemaPlanetarioController.setData(marco, this.controlUniverso.ListaPlanetas());

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
        Button boton = new Button();
        ImageView imagenTeletrasportador= new ImageView("Imagenes/teleTrasportador.png");
        boton.setGraphic(imagenTeletrasportador);
        boton.setId("btn");
        grid.setLayoutX(1100);
        grid.setLayoutY(400);
        grid.add(imagenTeletrasportador, 0, 1);
        crearElementos();

        this.VistaPlaneta.getChildren().add(grid);
    }

    public void crearElementos() {
        Planeta planeta = this.controlUniverso.getPlaneta();

        try {
            labelZero.setText("Zero: " + Integer.toString(planeta.getElementos().getZero()));
            zero.setVisible(true);
            labelPaladio.setText("Paladio: "+ Integer.toString(planeta.getElementos().getPaladio()));
            paladio.setVisible(true);
            labelIridio.setText("Iridio: " + Integer.toString(planeta.getElementos().getIridio()));
            iridio.setVisible(true);
            labelPlatino.setText("Platino: "+ Integer.toString(planeta.getElementos().getPlatino()));
            platino.setVisible(true);
        } catch (Exception e) {
            System.out.println("error!!!! " + e + e.getMessage());
        }

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
