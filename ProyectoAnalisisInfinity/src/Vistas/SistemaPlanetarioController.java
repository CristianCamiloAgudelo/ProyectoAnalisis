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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class SistemaPlanetarioController implements Initializable {

    @FXML
    private ImageView tipo2;
    @FXML
    private AnchorPane VistaSistemaPlanetario;
    @FXML
    private ImageView tipo1;
    @FXML
    private AnchorPane scroll;
    private ControlUniverso controlUniverso;
    @FXML
    private ImageView atrasNebulosa;
    private AnchorPane marco;
    private List<Planeta> planetas;
    private boolean bandera;
    private String rutaImagen;
    private int tipoPlaneta;
    private Boolean banderaEnemigo;
    private FileLoader fileLoader;

    void setData(AnchorPane marco, List<Planeta> planetas) {
        this.marco = marco;
        this.bandera = false;
        this.rutaImagen = "";
        this.tipoPlaneta = 0;
        this.banderaEnemigo = false;
        this.planetas = planetas;
        if (!this.planetas.isEmpty()) {
            PintarPlanetas(this.planetas);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AtrasSistemaPlanetario(MouseEvent event) {
        this.fileLoader = new FileLoader("src/Vistas/Nebulosa.fxml");
        VistaGenerica vistaNebulosa = fileLoader.open("nebulosa");
        NebulosaController nebulosaController = (NebulosaController) vistaNebulosa.getController();
        nebulosaController.setData(this.marco, this.controlUniverso.ListaSistemasPlanetarios());
        nebulosaController.setControlUniverso(this.controlUniverso);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaNebulosa.getParent());
    }

    private void EntrarPlaneta(String text) {

    }

    private void CrearPlaneta(String nombrePlaneta, Boolean enemigo, double PosicionX, double posicionY, int tipoPlaneta, int zero, int iridio, int paladio, int platino) {
        Planeta planeta = this.controlUniverso.AgregarPlaneta(nombrePlaneta, enemigo, PosicionX, posicionY, tipoPlaneta, zero, iridio, paladio, platino);
        this.planetas.add(planeta);
        System.out.println(planeta.getCodigo() + planeta.getNombre());
        PintarPlanetas(this.planetas);
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
            input.setPromptText("Nombre Planeta");
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
                    CrearPlaneta(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY(), tipoPlaneta, 1, 1, 1, 1);

                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            this.VistaSistemaPlanetario.getChildren().add(grid);

        }
    }

    private void PintarPlanetas(List<Planeta> planetas) {

        EliminarElementoVista("GridPane");
        for (Planeta planeta : planetas) {
            GridPane grid = new GridPane();
            grid.setLayoutX(planeta.getPosicionX());
            grid.setLayoutY(planeta.getPosicionY());
            grid.setVgap(10);
            grid.setGridLinesVisible(false);
            System.out.println(planeta.getPosicionX() + " " + planeta.getPosicionY());
            ColumnConstraints leftCol = new ColumnConstraints();
            leftCol.setHalignment(HPos.CENTER);
            leftCol.setHgrow(Priority.ALWAYS);

            ColumnConstraints rightCol = new ColumnConstraints();
            rightCol.setHalignment(HPos.CENTER
            );
            rightCol.setHgrow(Priority.ALWAYS);

            grid.getColumnConstraints().addAll(leftCol, rightCol);
            Label label = new Label(planeta.getNombre());
            label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            ImageView imagenNebulosa = new ImageView(planeta.getImagen());

            imagenNebulosa.setOnMouseClicked(e -> {
                EntrarPlaneta(label.getText());
            });
            grid.addRow(1, imagenNebulosa);
            grid.addRow(0, label);
            this.VistaSistemaPlanetario.getChildren().add(grid);
        }

    }

    private void EliminarElementoVista(String tipoElemento) {
        String rutaElemento = ("javafx.scene.layout." + tipoElemento);
        List<Node> nodos = new LinkedList<>();
        try {
            for (Node node : this.VistaSistemaPlanetario.getChildren()) {
                if (node.getClass().getName().equals(rutaElemento)) {
                    nodos.add(node);

                }
            }
            this.VistaSistemaPlanetario.getChildren().removeAll(nodos);
        } catch (Exception e) {
            System.out.println("Errrorrrrrrrrrrrrrrrrrrrrrrrr: " + e);
        }

    }

    @FXML
    private void crearTipo1(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/PlanetaTipo1.png";
        this.tipoPlaneta = 0;
        System.out.println("tipo1 este");
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/PlanetaTipo2.png";
        this.tipoPlaneta = 1;
        System.out.println("tipo2 este");
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
