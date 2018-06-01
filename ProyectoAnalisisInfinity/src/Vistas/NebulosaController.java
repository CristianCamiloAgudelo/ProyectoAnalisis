/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javafx.geometry.Insets;
import Modelo.*;
import java.net.URL;
import Controladores.ControlUniverso;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class NebulosaController implements Initializable {

    private ControlUniverso controlUniverso;
    private Nebulosa nebulosa;
    @FXML
    private AnchorPane VistaNebulosa;
    @FXML
    private GridPane tipo1;
    @FXML
    private ImageView tipo2;
    private Boolean bandera;
    private Boolean banderaEnemigo;
    private String rutaImagen;
    private int contadorImagenSistemaPlanetario;
    private List<SistemaPlanetario> sistemasPlanetarios;
    private AnchorPane marco;
    private FileLoader fileLoader;
    @FXML
    private ImageView atrasNebulosa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void setData(Nebulosa nebulosa, AnchorPane marco, AnchorPane atras) {
        this.nebulosa = nebulosa;
        this.bandera = false;
        this.banderaEnemigo = false;
        this.rutaImagen = "";
        this.contadorImagenSistemaPlanetario = 0;
        this.sistemasPlanetarios = new LinkedList<>();
        this.marco = marco;

        if (!this.sistemasPlanetarios.isEmpty()) {
            PintarSistemaPlanetario(this.sistemasPlanetarios);
        }
    }

    private void EntrarSistemaPlanetario(String nombreSistemaPlanetario) {

        SistemaPlanetario sistemaPlanetario = this.controlUniverso.EntrarSistemaPlanetario(nombreSistemaPlanetario);
        this.fileLoader = new FileLoader("src/Vistas/SistemaPlanetario.fxml");
        VistaGenerica vistaSistemaPlanetario = fileLoader.open("sistemaplanetario");

        SistemaPlanetarioController sistemaPlanetarioController = (SistemaPlanetarioController) vistaSistemaPlanetario.getController();
        sistemaPlanetarioController.setData(sistemaPlanetario, this.marco);
        sistemaPlanetarioController.setControlUniverso(this.controlUniverso);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaSistemaPlanetario.getParent());

    }

    @FXML
    private void AtrasNebulosa(MouseEvent event) {

        this.fileLoader = new FileLoader("src/Vistas/Universo.fxml");
        VistaGenerica vistaUniverso = fileLoader.open("universo");

        UniversoController universoController = (UniversoController) vistaUniverso.getController();
        universoController.setData(this.marco, this.controlUniverso.getUniverso().getListaNebulosas());
        universoController.setControlUniverso(this.controlUniverso);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaUniverso.getParent());

    }

    private void crearSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY) {

        SistemaPlanetario sistemaPlanetario = this.getControlUniverso().AgregarSistemaPlanetario(nombre, enemigo, posicionX, posicionY);
        this.sistemasPlanetarios.add(sistemaPlanetario);
        PintarSistemaPlanetario(this.sistemasPlanetarios);
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
                    crearSistemaPlanetario(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY());

                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            this.VistaNebulosa.getChildren().add(grid);

        }
    }

    private void PintarSistemaPlanetario(List<SistemaPlanetario> sistemasPlanetarios) {

        EliminarElementoVista("GridPane");
        for (SistemaPlanetario sistemaPlanetario : sistemasPlanetarios) {
            GridPane grid = new GridPane();
            grid.setLayoutX(sistemaPlanetario.getPosicionX());
            grid.setLayoutY(sistemaPlanetario.getPosicionY());
            grid.setVgap(10);
            grid.setGridLinesVisible(false);
            System.out.println(sistemaPlanetario.getPosicionX() + " " + sistemaPlanetario.getPosicionY());
            ColumnConstraints leftCol = new ColumnConstraints();
            leftCol.setHalignment(HPos.CENTER);
            leftCol.setHgrow(Priority.ALWAYS);

            ColumnConstraints rightCol = new ColumnConstraints();
            rightCol.setHalignment(HPos.CENTER
            );
            rightCol.setHgrow(Priority.ALWAYS);

            grid.getColumnConstraints().addAll(leftCol, rightCol);
            Label label = new Label(sistemaPlanetario.getNombre());
            label.setTextFill(javafx.scene.paint.Paint.valueOf("ff0000"));
            ImageView imagenNebulosa = new ImageView(this.rutaImagen);

            imagenNebulosa.setOnMouseClicked(e -> {
                EntrarSistemaPlanetario(label.getText());
            });
            grid.addRow(1, imagenNebulosa);
            grid.addRow(0, label);

            if (this.contadorImagenSistemaPlanetario == 2) {
                this.contadorImagenSistemaPlanetario = 0;
            } else {
                this.contadorImagenSistemaPlanetario++;
            }

            this.VistaNebulosa.getChildren().add(grid);
        }

    }

    private void EliminarElementoVista(String tipoElemento) {
        String rutaElemento = ("javafx.scene.layout." + tipoElemento);
        List<Node> nodos = new LinkedList<>();
        try {
            for (Node node : this.VistaNebulosa.getChildren()) {
                if (node.getClass().getName().equals(rutaElemento)) {
                    nodos.add(node);

                }
            }
            this.VistaNebulosa.getChildren().removeAll(nodos);
        } catch (Exception e) {
            System.out.println("Errrorrrrrrrrrrrrrrrrrrrrrrrr: " + e);
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

    @FXML
    private void crearTipo1(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/SistemaPlanetarioTipo1.png";
        System.out.println("tipo1 este");
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/SistemaPlanetarioTipo2.png";
        System.out.println("tipo2 este");
    }

}
