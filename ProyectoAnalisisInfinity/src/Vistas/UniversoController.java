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
import javafx.scene.input.ScrollEvent;
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
    @FXML
    private Button botonConexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(AnchorPane marco, List<Nebulosa> nebulosas) {
        this.marco = marco;
        this.nebulosas = nebulosas;
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
        nebulosaController.setData(nebulosa, this.marco, this.VistaUniverso);
        nebulosaController.setControlUniverso(this.controlUniverso);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaNebulosa.getParent());
    }

    private void crearNebulosa(String nombre, boolean enemigo, double posicionX, double posicionY, int tipoNebulosa) {

        Nebulosa nebulosa = this.controlUniverso.AgregarNebulosa(nombre, enemigo, posicionX, posicionY, tipoNebulosa);
        this.nebulosas.add(nebulosa);
        PintarNebulosa(this.nebulosas);

    }

    @FXML
    private void Agregar(MouseEvent event) {
        System.out.println("entreee");
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
            CheckBox checkBox = new CheckBox("enemigos");

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
            System.out.println("sali");

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
                    Conexion(e);
                } else {
                    EntrarNebulosa(label.getText());
                }
            });
            grid.addRow(1, imagenNebulosa);
            grid.addRow(0, label);
            this.VistaUniverso.getChildren().add(grid);
        }

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
        System.out.println("tipo1");
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        this.tipoNebulosa = 1;
        System.out.println("tipo2");
    }

    private void crearTipo3(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        this.tipoNebulosa = 2;
        System.out.println("tipo3");
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

    @FXML
    private void Conexion(MouseEvent event) {
        double xInicial = event.getX();
        double yInicial = event.getY();
        
        
        
        
    }

    public Line crearLinea(double XInicial, double YInicial, double XFinal, double YFinal) {
        Line linea = new Line(XInicial, YInicial, XFinal, YFinal);
        linea.setStroke(Color.DODGERBLUE);
        linea.setStrokeWidth(3);
        linea.setStrokeDashOffset(5); //separacion
        linea.getStrokeDashArray().addAll(15d);
        return linea;
    }

}
