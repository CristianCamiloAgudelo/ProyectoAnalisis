/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControlGeneral;
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

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class UniversoController implements Initializable {

    private FileLoader fileLoader;
    private Universo universo;
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private SplitPane Splitpane;
    @FXML
    private AnchorPane Scroll;
    private ScrollPane Scrollpane;
    @FXML
    private AnchorPane Vista;
    @FXML
    private GridPane tipo1;
    @FXML
    private ImageView tipo2;
    @FXML
    private ImageView tipo3;
    private AnchorPane marco;
    private boolean bandera = false;
    private String rutaImagen = "";
    private ControlGeneral controlGeneral;
    private int contadorImagenNebulosa;
    private List<Nebulosa> nebulosas;
    private boolean banderaEnemigo = false;
    private double posicionX;
    private double posicionY;

    @FXML
    private ImageView imagenVista;


    /* UniversoController(Universo universo) {
        this.universo = universo;
        this.Texto.setText(this.universo.getNombre()); 
        
    }*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(Universo universo, AnchorPane marco) {
        this.marco = marco;
        this.universo = universo;
        this.contadorImagenNebulosa = 0;
        this.nebulosas = new LinkedList<>();

    }

    private void crearNebulosa(String nombre, boolean enemigo, double posicionX, double posicionY) {

        Nebulosa nebulosa = this.getControlGeneral().AgregarNebulosa(nombre, enemigo, posicionX, posicionY);
        this.nebulosas.add(nebulosa);
        PintarNebulosa(this.nebulosas);

    }

    private void EntrarNebulosa(String nombreNebulosa) {
        Nebulosa nebulosa = this.controlGeneral.EntrarNebulosa(nombreNebulosa);
        this.controlGeneral.getPila().add(nebulosa.getNombre());

        this.fileLoader = new FileLoader("src/Vistas/Nebulosa.fxml");
        VistaGenerica vistaNebulosa = fileLoader.open("nebulosa");
        NebulosaController nebulosaController = (NebulosaController) vistaNebulosa.getController();
        nebulosaController.setData(nebulosa);
        nebulosaController.setControlGeneral(this.controlGeneral);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaNebulosa.getParent());
    }

    @FXML
    private void Agregar(MouseEvent event) {

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
                    crearNebulosa(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY());

                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            Vista.getChildren().add(grid);

        }
    }

    @FXML
    private void crearTipo1(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        System.out.println("tipo1");
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        System.out.println("tipo2");
    }

    @FXML
    private void crearTipo3(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        System.out.println("tipo3");
    }

    private void PintarNebulosa(List<Nebulosa> nebulosas) {

        EliminarElementoVista("GridPane");
        for (Nebulosa nebulosa : nebulosas) {
            GridPane grid = new GridPane();
            grid.setLayoutX(nebulosa.getPosicionX());
            grid.setLayoutY(nebulosa.getPosicionY());
            grid.setVgap(10);
            grid.setGridLinesVisible(false);
            System.out.println(nebulosa.getPosicionX() + " " + nebulosa.getPosicionY());
            ColumnConstraints leftCol = new ColumnConstraints();
            leftCol.setHalignment(HPos.CENTER);
            leftCol.setHgrow(Priority.ALWAYS);

            ColumnConstraints rightCol = new ColumnConstraints();
            rightCol.setHalignment(HPos.CENTER
            );
            rightCol.setHgrow(Priority.ALWAYS);

            grid.getColumnConstraints().addAll(leftCol, rightCol);
            Label label = new Label(nebulosa.getNombre());
            label.setTextFill(javafx.scene.paint.Paint.valueOf("ff0000"));
            ImageView imagenNebulosa = new ImageView(rutaImagen);

            imagenNebulosa.setOnMouseClicked(e -> {
                EntrarNebulosa(label.getText());
            });
            grid.addRow(1, imagenNebulosa);
            grid.addRow(0, label);

            if (this.contadorImagenNebulosa == 2) {
                this.contadorImagenNebulosa = 0;
            } else {
                this.contadorImagenNebulosa++;
            }
            Vista.setOnMouseClicked(e -> {
                posicionX = e.getX();
                posicionY = e.getY();
            });
            this.Vista.getChildren().add(grid);
        }

    }

    private void EliminarElementoVista(String tipoElemento) {
        String rutaElemento = ("javafx.scene.layout." + tipoElemento);
        List<Node> nodos = new LinkedList<>();
        try {
            for (Node node : this.Vista.getChildren()) {
                if (node.getClass().getName().equals(rutaElemento)) {
                    nodos.add(node);

                }
            }
            this.Vista.getChildren().removeAll(nodos);
        } catch (Exception e) {
            System.out.println("Errrorrrrrrrrrrrrrrrrrrrrrrrr: " + e);
        }

    }

    /**
     * @return the controlGeneral
     */
    public ControlGeneral getControlGeneral() {
        return controlGeneral;
    }

    /**
     * @param controlGeneral the controlGeneral to set
     */
    public void setControlGeneral(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
    }

}
