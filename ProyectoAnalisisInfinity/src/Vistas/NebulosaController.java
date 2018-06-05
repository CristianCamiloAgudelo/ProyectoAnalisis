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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class NebulosaController implements Initializable {

    private ControlUniverso controlUniverso;
    @FXML
    private AnchorPane VistaNebulosa;
    @FXML
    private GridPane tipo1;
    @FXML
    private ImageView tipo2;
    private Boolean bandera;
    private Boolean banderaEnemigo;
    private String rutaImagen;
    private List<SistemaPlanetario> sistemasPlanetarios;
    private AnchorPane marco;
    private FileLoader fileLoader;
    @FXML
    private ImageView atrasNebulosa;
    private int tipoSistemaPlanetario;
    private String nombreSistemaInicial;
    private String nombreSistemaFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    void setData(AnchorPane marco, List<SistemaPlanetario> sistemasPlanetarios) {
        this.bandera = false;
        this.banderaEnemigo = false;
        this.rutaImagen = "";
        this.sistemasPlanetarios = sistemasPlanetarios;
        this.marco = marco;
        this.nombreSistemaFinal = "";
        this.nombreSistemaInicial = "";
        if (!this.sistemasPlanetarios.isEmpty()) {
            PintarSistemaPlanetario(this.sistemasPlanetarios);
        }
        this.tipoSistemaPlanetario = 0;
    }

    private void EntrarSistemaPlanetario(String nombreSistemaPlanetario) {

        SistemaPlanetario sistemaPlanetario = this.controlUniverso.EntrarSistemaPlanetario(nombreSistemaPlanetario);
        this.fileLoader = new FileLoader("src/Vistas/SistemaPlanetario.fxml");
        VistaGenerica vistaSistemaPlanetario = fileLoader.open("sistemaplanetario");

        SistemaPlanetarioController sistemaPlanetarioController = (SistemaPlanetarioController) vistaSistemaPlanetario.getController();
        sistemaPlanetarioController.setControlUniverso(this.controlUniverso);
        sistemaPlanetarioController.setData(this.marco, sistemaPlanetario.getListaPlanetas());

        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaSistemaPlanetario.getParent());

    }

    @FXML
    private void AtrasNebulosa(MouseEvent event) {

        this.fileLoader = new FileLoader("src/Vistas/Universo.fxml");
        VistaGenerica vistaUniverso = fileLoader.open("universo");
        UniversoController universoController = (UniversoController) vistaUniverso.getController();
        universoController.setControlUniverso(this.controlUniverso);
        universoController.setData(this.marco, this.controlUniverso.ListaNebulosas());

        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaUniverso.getParent());

    }

    private void crearSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario) {
        SistemaPlanetario sistemaPlanetario = this.getControlUniverso().AgregarSistemaPlanetario(nombre, enemigo, posicionX, posicionY, tipoSistemaPlanetario);
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
            
            
            // boton
            Button boton = new Button("Aceptar");
            EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Label label = new Label();
                    label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
                    label.setText(input.getText());
                    grid.add(label, 0, 1);

                   
                    grid.setVisible(false);
                    crearSistemaPlanetario(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY(), tipoSistemaPlanetario);
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
            ColumnConstraints leftCol = new ColumnConstraints();
            leftCol.setHalignment(HPos.CENTER);
            leftCol.setHgrow(Priority.ALWAYS);

            ColumnConstraints rightCol = new ColumnConstraints();
            rightCol.setHalignment(HPos.CENTER
            );
            rightCol.setHgrow(Priority.ALWAYS);

            grid.getColumnConstraints().addAll(leftCol, rightCol);
            Label label = new Label(sistemaPlanetario.getNombre());
            label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            ImageView imagenSistemaPlanetario = new ImageView(sistemaPlanetario.getImagen());

            imagenSistemaPlanetario.setOnMouseClicked(e -> {
                if (e.isPopupTrigger()) {
                    Conexion(label.getText());
                } else {
                    EntrarSistemaPlanetario(label.getText());
                }
            });
            if (!sistemaPlanetario.getAdyacencias().isEmpty()) {

                for (Nodo nodoSistemaPlanetario : sistemaPlanetario.getAdyacencias()) {
                    SistemaPlanetario sistemaPlanetarioFinal = this.controlUniverso.BuscarSistemaPlanetario(nodoSistemaPlanetario.getNombre());
                    PintarLinea(sistemaPlanetario, sistemaPlanetarioFinal);

                }

            }
            grid.addRow(1, imagenSistemaPlanetario);
            grid.addRow(0, label);
            this.VistaNebulosa.getChildren().add(grid);
        }

    }

    private void Conexion(String nombreSistemaPlanetario) {
        System.out.println("entreee");
        if (this.nombreSistemaInicial.equals("")) {
            this.nombreSistemaInicial = nombreSistemaPlanetario;
        } else {
            this.nombreSistemaFinal = nombreSistemaPlanetario;
            SistemaPlanetario sistemaPlanetarioInicial = this.controlUniverso.BuscarSistemaPlanetario(this.nombreSistemaInicial);
            SistemaPlanetario sistemaPlanetarioFinal = this.controlUniverso.BuscarSistemaPlanetario(this.nombreSistemaFinal);
            this.controlUniverso.AgregarAdyasenciaSistemaPlanetario(sistemaPlanetarioInicial, sistemaPlanetarioFinal);
            PintarLinea(sistemaPlanetarioInicial, sistemaPlanetarioFinal);
            this.nombreSistemaInicial = "";
            this.nombreSistemaFinal = "";
        }
    }

    public void PintarLinea(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal) {
        Line linea = new Line(sistemaPlanetarioInicial.getPosicionX() + 80, sistemaPlanetarioInicial.getPosicionY() + 80, sistemaPlanetarioFinal.getPosicionX() + 80, sistemaPlanetarioFinal.getPosicionY() + 80);
        linea.setStroke(Color.CORNFLOWERBLUE);
        linea.setStrokeWidth(3);
        linea.setStrokeDashOffset(5); //separacion
        linea.getStrokeDashArray().addAll(5d);
        this.VistaNebulosa.getChildren().add(linea);
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
        this.tipoSistemaPlanetario = 0;
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/SistemaPlanetarioTipo2.png";
        this.tipoSistemaPlanetario = 1;
    }

}
