/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControlUniverso;
import Modelo.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class UniversoController implements Initializable {

    private FileLoader fileLoader;
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private SplitPane Splitpane;
    @FXML
    private AnchorPane Scroll;
    private ScrollPane Scrollpane;

    @FXML
    private GridPane tipo1;
    @FXML
    private ImageView tipo2;
    private AnchorPane marco;
    private boolean bandera = false;
    private String rutaImagen = "";
    private ControlUniverso controlUniverso;
    private List<Nebulosa> nebulosas;
    private boolean banderaEnemigo = false;
    private double posicionX;
    private double posicionY;
    @FXML
    private AnchorPane VistaUniverso;
    private int tipoNebulosa;
    private String nombreNebulosaInicial;
    private String nombreNebulosaFinal;
    private ImageView nave;
    private Boolean simulacion;
    @FXML
    private ImageView tipo3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setData(AnchorPane marco, List<Nebulosa> nebulosas) {
        this.marco = marco;
        this.nebulosas = nebulosas;
        this.nombreNebulosaInicial = "";
        this.nombreNebulosaFinal = "";
        this.setSimulacion((Boolean) false);
        if (!this.nebulosas.isEmpty()) {
            PintarNebulosa(this.nebulosas);
        }
        this.tipoNebulosa = 0;

    }

    private void EntrarNebulosa(String nombreNebulosa) {
        Nebulosa nebulosa = this.controlUniverso.EntrarNebulosa(nombreNebulosa);
        this.fileLoader = new FileLoader("src/Vistas/Nebulosa.fxml");
        VistaGenerica vistaNebulosa = fileLoader.open("nebulosa");
        NebulosaController nebulosaController = (NebulosaController) vistaNebulosa.getController();
        nebulosaController.setControlUniverso(this.controlUniverso);
        nebulosaController.setData(this.marco, nebulosa.getListaSistemasPlanetarios());
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaNebulosa.getParent());
    }

    private void crearNebulosa(String nombre, boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {
        this.controlUniverso.AgregarNebulosa(nombre, enemigo, posicionX, posicionY, tipoNebulosa);
        PintarNebulosa(this.nebulosas);
    }

    @FXML
    private void Agregar(MouseEvent event) throws InterruptedException{
        if (getSimulacion()) {
            double destinoNaveX = event.getX();
            double destinoNaveY = event.getY();
            while (this.controlUniverso.getNave().getPosicionX() != destinoNaveX && this.controlUniverso.getNave().getPosicionY() != destinoNaveY) {
                if (this.controlUniverso.getNave().getPosicionX() < destinoNaveX) {
                    this.controlUniverso.getNave().setPosicionX(this.controlUniverso.getNave().getPosicionX() + 1);
                }
                if (this.controlUniverso.getNave().getPosicionY() < destinoNaveY) {
                    this.controlUniverso.getNave().setPosicionY(this.controlUniverso.getNave().getPosicionY() + 1);
                }
                
                this.VistaUniverso.getChildren().remove(this.VistaUniverso.getChildren().size()-1);
                PintarNave();
                Thread.sleep(100);
            }
        }
        if (this.bandera) {
            this.bandera = false;
            final GridPane grid = new GridPane();
            grid.setLayoutX(event.getX());
            grid.setLayoutY(event.getY());
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
            input.setPromptText("Nombre Nebulosa");
            grid.addRow(0, input);

            //imagen
            ImageView imagen = new ImageView(this.rutaImagen);
            grid.addRow(2, imagen);

            //checkbox
            Label checkboxLabel = new Label("¿Enemigos? ");
            checkboxLabel.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            CheckBox checkBox = new CheckBox("");

            checkboxLabel.setLabelFor(checkBox);
            grid.addRow(1, checkboxLabel, checkBox);

            // boton
            Button boton = new Button("Aceptar");
            EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Label label = new Label();
                    label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
                    label.setText(input.getText());

                    grid.add(label, 0, 1);

                    //enemigos activos
                    if (checkBox.isSelected()) {
                        banderaEnemigo = true;
                    } else {
                        banderaEnemigo = false;
                    }
                    grid.setVisible(false);
                    crearNebulosa(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY(), tipoNebulosa);

                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            VistaUniverso.getChildren().add(grid);

        }
    }

    private void PintarNebulosa(List<Nebulosa> nebulosas) {
        EliminarElementoVista("GridPane");
        for (Nebulosa nebulosa : nebulosas) {
            GridPane grid = new GridPane();
            grid.setLayoutX(nebulosa.getPosicionX());
            grid.setLayoutY(nebulosa.getPosicionY());
            grid.setVgap(10);
            grid.setGridLinesVisible(false);

            ColumnConstraints leftCol = new ColumnConstraints();
            leftCol.setHalignment(HPos.CENTER);
            leftCol.setHgrow(Priority.ALWAYS);

            ColumnConstraints rightCol = new ColumnConstraints();
            rightCol.setHalignment(HPos.CENTER
            );
            rightCol.setHgrow(Priority.ALWAYS);

            grid.getColumnConstraints().addAll(leftCol, rightCol);
            Label label = new Label(nebulosa.getNombre());
            label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            ImageView imagenNebulosa = new ImageView(nebulosa.getImagen());

            imagenNebulosa.setOnMouseClicked(e -> {
                if (e.isPopupTrigger()) {
                    Conexion(label.getText());
                } else {
                    EntrarNebulosa(label.getText());
                }
            });
            if (!nebulosa.getAdyacencias().isEmpty()) {

                for (Nodo nodoNebulosa : nebulosa.getAdyacencias()) {
                    Nebulosa nebulosaFinal = this.controlUniverso.BuscarNebulosa(nodoNebulosa.getNombre());
                    PintarLinea(nebulosa, nebulosaFinal);

                }

            }

            grid.addRow(1, imagenNebulosa);
            grid.addRow(0, label);
            this.VistaUniverso.getChildren().add(grid);
        }

    }

    public void PintarNave() {
        this.nave = new ImageView(this.controlUniverso.getNave().getImagen());
        this.nave.setLayoutX(this.controlUniverso.getNave().getPosicionX());
        this.nave.setLayoutY(this.controlUniverso.getNave().getPosicionY());
        this.VistaUniverso.getChildren().add(nave);
    }

    private void Conexion(String nombreNebulosa) {
        if (this.nombreNebulosaInicial.equals("")) {
            this.nombreNebulosaInicial = nombreNebulosa;
        } else {
            this.nombreNebulosaFinal = nombreNebulosa;
            Nebulosa nebulosaInicial = this.controlUniverso.BuscarNebulosa(this.nombreNebulosaInicial);
            Nebulosa nebulosaFinal = this.controlUniverso.BuscarNebulosa(this.nombreNebulosaFinal);
            this.controlUniverso.AgregarAdyasenciaNebulosa(nebulosaInicial, nebulosaFinal);
            PintarLinea(nebulosaInicial, nebulosaFinal);
            this.nombreNebulosaInicial = "";
            this.nombreNebulosaFinal = "";
        }
    }

    public void PintarLinea(Nebulosa nebulosaInicial, Nebulosa nebulosaFinal) {
        Line linea = new Line(nebulosaInicial.getPosicionX() + 80, nebulosaInicial.getPosicionY() + 80, nebulosaFinal.getPosicionX() + 80, nebulosaFinal.getPosicionY() + 80);
        linea.setStroke(Color.CORNFLOWERBLUE);
        linea.setStrokeWidth(3);
        linea.setStrokeDashOffset(5); //separacion
        linea.getStrokeDashArray().addAll(5d);
        this.VistaUniverso.getChildren().add(linea);
    }

    private void EliminarElementoVista(String tipoElemento) {
        String rutaElemento = ("javafx.scene.layout." + tipoElemento);
        List<Node> nodos = new LinkedList<>();
        try {
            for (Node node : this.VistaUniverso.getChildren()) {
                if (node.getClass().getName().equals(rutaElemento)) {
                    nodos.add(node);

                }
            }
            this.VistaUniverso.getChildren().removeAll(nodos);
        } catch (Exception e) {
            System.out.println("Errrorrrrrrrrrrrrrrrrrrrrrrrr: " + e);
        }

    }

    @FXML
    private void crearTipo1(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        this.tipoNebulosa = 0;
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/NebulosaTipo3.png";
        this.tipoNebulosa = 1;
    }

    @FXML
    private void crearTipo3(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/NebulosaTipo4.png";
        this.tipoNebulosa = 2;
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

    /**
     * @return the simulacion
     */
    public Boolean getSimulacion() {
        return simulacion;
    }

    /**
     * @param simulacion the simulacion to set
     */
    public void setSimulacion(Boolean simulacion) {
        this.simulacion = simulacion;
    }
}
