/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControlGeneral;
import Modelo.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
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
    private ImageView Imagen;

    @FXML
    private Label Texto;
    @FXML
    private GridPane tipo1;
    @FXML
    private ImageView tipo2;
    @FXML
    private ImageView tipo3;

    private boolean bandera = false;
    private String rutaImagen = "";
    private ControlGeneral controlGeneral;
    private int contadorNebulosa;
    private List<Nebulosa> nebulosas;
    private boolean banderaEnemigo = false;
    private double posicionX;
    private double posicionY;

    /* UniversoController(Universo universo) {
        this.universo = universo;
        this.Texto.setText(this.universo.getNombre()); 
        
    }*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(Universo universo) {
        this.universo = universo;
        this.Texto.setText(universo.getNombre());
    }

    private Nebulosa crearNebulosa(String nombre, boolean enemigo, double posicionX, double posicionY) {

        Nebulosa nebulosa = this.getControlGeneral().AgregarNebulosa(nombre, enemigo, posicionX, posicionY);
        PintarNebulosa(nebulosa);
        return nebulosa;
    }
    
    private Nebulosa EntrarNebulosa(double posicionX, double posicionY, double anchoPane, double largoPane){
    
    return null;
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
            final TextField input = new TextField("");
            input.setPromptText("Nombre Nebulosa");
            grid.addRow(0, input);

            //imagen
            ImageView imagen = new ImageView(this.rutaImagen);
            grid.addRow(2, imagen);

            //checkbox
            final Label checkboxLabel = new Label("Enemigos?: ");
            checkboxLabel.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            final CheckBox checkBox = new CheckBox("enemigos");

            checkboxLabel.setLabelFor(checkBox);
            grid.addRow(1, checkboxLabel, checkBox);

            // boton
            final Button boton = new Button("Aceptar");
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

                    //informacion creacion, retorna una nebulosa 
                    Nebulosa nebulosa = crearNebulosa(label.getText(), banderaEnemigo, grid.getLayoutX(), grid.getLayoutY());
                    boton.setDisable(true);
                    boton.setVisible(false);
                    input.setVisible(false);
                    checkboxLabel.setVisible(false);
                    checkBox.setVisible(false);

                    grid.getChildren().addAll(label);
                    
                    
                    grid.setOnMouseClicked(e -> {
                        posicionX = e.getX();
                        posicionY = e.getY();
                    });
                    System.out.println("posX: " + posicionX);
                    System.out.println("posY: " + posicionY);

                }
            };
            boton.setOnAction(evento);

            grid.addRow(3, boton);

            Vista.getChildren().add(grid);

        }
    }

    @FXML
    private void entrar(MouseEvent event) {

        System.out.println("posX:" + posicionX);
        System.out.println("posY:" + posicionY);
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

    private void PintarNebulosa(Nebulosa nebulosa) {
        GridPane grid = new GridPane();
        
        nebulosa.getImagenes().get(1);
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
