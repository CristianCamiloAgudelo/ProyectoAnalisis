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
import Controladores.ControlNebulosa;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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
    private boolean bandera;
    private boolean banderaEnemigo;
    private boolean teletransportador;
    private String rutaImagen;
    private List<SistemaPlanetario> sistemasPlanetarios;
    private AnchorPane marco;
    private FileLoader fileLoader;
    @FXML
    private ImageView atrasNebulosa;
    private int tipoSistemaPlanetario;
    private String nombreSistemaInicial;
    private String nombreSistemaFinal;
    @FXML
    private Button calcularRecorrido;

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

    private void crearSistemaPlanetario(String nombre, Boolean enemigo, double posicionX, double posicionY, int tipoSistemaPlanetario, boolean teletransportador) {
        SistemaPlanetario sistemaPlanetario = this.getControlUniverso().AgregarSistemaPlanetario(nombre, enemigo, posicionX, posicionY, tipoSistemaPlanetario, teletransportador);
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
            input.setPromptText("Nombre Sistema");
            grid.addRow(0, input);
            //checkbox teletransportador
            CheckBox checkBox = new CheckBox("teletransportador?");
            checkBox.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            grid.addRow(1, checkBox);
            if (this.controlUniverso.isTeletransportador()) {
                checkBox.setVisible(false);
            }
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
                    CheckBox nodo = (CheckBox) getNodeByRowColumnIndex(1, 0, grid);
                    crearSistemaPlanetario(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY(), tipoSistemaPlanetario, nodo.isSelected());
                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            this.VistaNebulosa.getChildren().add(grid);

        }
    }

    /**
     * metodo sacado de internet ("https://stackoverflow.com/questions/20825935/javafx-get-node-by-row-and-column")
     *
     * @param row
     * @param column
     * @param gridPane
     * @return
     */
    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
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
                    PintarLinea(sistemaPlanetario, sistemaPlanetarioFinal, nodoSistemaPlanetario.getPeso());

                }

            }
            grid.addRow(1, imagenSistemaPlanetario);
            grid.addRow(0, label);
            this.VistaNebulosa.getChildren().add(grid);
        }

    }

    private void Conexion(String nombreSistemaPlanetario) {
        if (this.nombreSistemaInicial.equals("")) {
            this.nombreSistemaInicial = nombreSistemaPlanetario;
        } else {

            this.nombreSistemaFinal = nombreSistemaPlanetario;
            SistemaPlanetario sistemaPlanetarioInicial = this.controlUniverso.BuscarSistemaPlanetario(this.nombreSistemaInicial);
            SistemaPlanetario sistemaPlanetarioFinal = this.controlUniverso.BuscarSistemaPlanetario(this.nombreSistemaFinal);
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
            input.setPromptText("¿Distancia?");
            grid.addRow(0, input);
            // boton
            Button boton = new Button("Aceptar");
            EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int peso = Integer.parseInt(input.getText());
                    controlUniverso.AgregarAdyasenciaSistemaPlanetario(sistemaPlanetarioInicial, sistemaPlanetarioFinal, peso);
                    PintarLinea(sistemaPlanetarioInicial, sistemaPlanetarioFinal, peso);
                    nombreSistemaInicial = "";
                    nombreSistemaFinal = "";
                    grid.setVisible(false);
                }
            };
            boton.setOnAction(evento);
            grid.addRow(3, boton);
            this.marco.getChildren().add(grid);

        }
    }

    public void PintarLinea(SistemaPlanetario sistemaPlanetarioInicial, SistemaPlanetario sistemaPlanetarioFinal, double peso) {
        double posicionPesoX = (sistemaPlanetarioFinal.getPosicionX() + 80 + sistemaPlanetarioInicial.getPosicionX() + 80) / 2;
        double posicionPesoY = (sistemaPlanetarioFinal.getPosicionY() + 80 + sistemaPlanetarioInicial.getPosicionY() + 80) / 2;
        Label label = new Label(String.valueOf(peso));
        label.setFont(Font.font("Rockwell Extra Bold", 20));
        label.setTextFill(Color.WHITE);
        label.setLayoutX(posicionPesoX);
        label.setLayoutY(posicionPesoY);
        label.setTextAlignment(TextAlignment.CENTER);
        this.VistaNebulosa.getChildren().add(label);
        label.setVisible(true);
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

    @FXML
    private void CalcularRecorrido(ActionEvent event) {

        List<SistemaPlanetario> recorrido = this.controlUniverso.IniciarRecorrido();
        mostrarRecorridos(recorrido);

    }

    public void mostrarRecorridos(List<SistemaPlanetario> recorrido) {
        for (SistemaPlanetario sistemaPlanetario : recorrido) {
            System.out.println(sistemaPlanetario.getNombre() + " -> ");
        }
    }
}
