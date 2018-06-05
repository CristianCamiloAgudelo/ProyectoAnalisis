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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

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
    private Boolean banderaEstacionCombustible;
    private FileLoader fileLoader;

    private int intZero=0;
    private int intIridio=0;
    private int intPlatino=0;
    private int intPaladio=0;

    private String nombrePlanetaInicial;
    private String nombrePlanetaFinal;


    void setData(AnchorPane marco, List<Planeta> planetas) {
        this.marco = marco;
        this.bandera = false;
        this.rutaImagen = "";
        this.tipoPlaneta = 0;
        this.banderaEstacionCombustible = false;
        this.planetas = planetas;
        this.nombrePlanetaFinal = "";
        this.nombrePlanetaInicial = "";
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
        nebulosaController.setControlUniverso(this.controlUniverso);
        nebulosaController.setData(this.marco, this.controlUniverso.ListaSistemasPlanetarios());

        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaNebulosa.getParent());
    }

    private void EntrarPlaneta(String nombrePlaneta) {
        Planeta planeta = this.controlUniverso.EntrarPlaneta(nombrePlaneta);
        this.fileLoader = new FileLoader("src/Vistas/Planeta.fxml");
        VistaGenerica vistaPlaneta = fileLoader.open("planeta");
        PlanetaController PlanetaController = (PlanetaController) vistaPlaneta.getController();
        PlanetaController.setData(this.marco);
        PlanetaController.setControlUniverso(this.controlUniverso);
        this.marco.getChildren().clear();
        this.marco.getChildren().add(vistaPlaneta.getParent());
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
            TextField nombrePlaneta = new TextField("");
            nombrePlaneta.setPromptText("Nombre Planeta");
            grid.addRow(0, nombrePlaneta);

            //imagen
            ImageView imagen = new ImageView(this.rutaImagen);
            grid.addRow(2, imagen);

            //checkboxestacion sercivicio
            
            Label checkboxLabel = new Label("");            
            CheckBox checkBox = new CheckBox("¡Estacion de Servicio?");
            checkBox.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            checkboxLabel.setLabelFor(checkBox);
            grid.add(checkBox, 0, 1);
           
            
           
            // elemento ZERO
            
            TextField zero = new TextField("");
            //zero.setPromptText("Ingrese Cantidad Recurso");
            CheckBox checkZero = new CheckBox("ZERO");
            checkZero.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            grid.add(checkZero, 1, 3);            
            checkZero.setOnMouseClicked(e->{
                if (checkZero.isSelected()) {
                    grid.add(zero, 0, 3);
                    
                }
                               
            }
            );
            
            
            //elemnto IRIDIO
            TextField iridio = new TextField("");
            CheckBox checkIridio = new CheckBox("IRIDIO");
            iridio.setPromptText("Ingrese Cantidad Recurso");
            checkIridio.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            grid.add(checkIridio, 1, 4);
            checkIridio.setOnMouseClicked(e->{
                if (checkIridio.isSelected()) {
                    grid.add(iridio, 0, 4);                  
                }
                
            }
            );
            
            //elemnto PLATINO
            TextField platino = new TextField("");
            CheckBox checkPlatino = new CheckBox("PLATINO");
            platino.setPromptText("Ingrese Cantidad Recurso");
            checkPlatino.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            grid.add(checkPlatino, 1, 5);
            checkPlatino.setOnMouseClicked(e->{
                if (checkPlatino.isSelected()) {
                    grid.add(platino, 0, 5);                  
                }
                
            }
            );
            
            //elemnto paladio
            TextField paladio = new TextField("");
            CheckBox checkPaladio = new CheckBox("PALADIO");
            paladio.setPromptText("Ingrese Cantidad Recurso");
            checkPaladio.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
            grid.add(checkPaladio, 1, 6);
            checkPaladio.setOnMouseClicked(e->{
                if (checkPaladio.isSelected()) {
                    grid.add(paladio, 0, 6);                
                }
                
            }
            );
            
            

            // boton
            Button boton = new Button("Aceptar");
            EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Label label = new Label();

                    label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
                    label.setText(nombrePlaneta.getText());

                    grid.add(label, 0, 1);

                    //enemigos activos
                    if (checkBox.isSelected()) {
                        banderaEstacionCombustible = true;
                    } else {
                        banderaEstacionCombustible = false;
                    }
                    //zero
                    if (zero.getText().equals(""))
                    {
                        zero.setText("0");
                        
                    }
                    else {
                          intZero=Integer.parseInt(zero.getText());
                    }
                    //iridio
                    if (iridio.getText().equals(""))
                    {
                        iridio.setText("0");
                    }
                    else {
                          intIridio=Integer.parseInt(zero.getText());
                    }
                    if (paladio.getText().equals(""))
                    {
                        paladio.setText("0");
                    }
                    else {
                          intPaladio=Integer.parseInt(zero.getText());
                    }
                    if (platino.getText().equals(""))
                    {
                        platino.setText("0");
                    }
                    else {
                          intPlatino=Integer.parseInt(zero.getText());
                    }
                    grid.setVisible(false);
                    CrearPlaneta(label.getText(), banderaEstacionCombustible, grid.getLayoutX(), grid.getLayoutY(), tipoPlaneta,
                                intZero,intIridio,intPaladio,intPlatino);
                                                                                                            
                }
            };
            boton.setOnAction(evento);
            grid.addRow(7, boton);
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
            ImageView imagenPlaneta = new ImageView(planeta.getImagen());

            imagenPlaneta.setOnMouseClicked(e -> {
                if (e.isPopupTrigger()) {
                    Conexion(label.getText());
                } else {
                    EntrarPlaneta(label.getText());
                }
            });
            if (!planeta.getAdyacencias().isEmpty()) {

                for (Nodo nodoPlaneta : planeta.getAdyacencias()) {
                    Planeta planetaFinal = this.controlUniverso.BuscarPlaneta(nodoPlaneta.getNombre());
                    PintarLinea(planeta, planetaFinal);

                }

            }
            grid.addRow(1, imagenPlaneta);
            grid.addRow(0, label);
            this.VistaSistemaPlanetario.getChildren().add(grid);
        }

    }

    private void Conexion(String nombrePlaneta) {
        System.out.println("entreee");
        if (this.nombrePlanetaInicial.equals("")) {
            this.nombrePlanetaInicial = nombrePlaneta;
        } else {
            this.nombrePlanetaFinal = nombrePlaneta;
            Planeta planetaInicial = this.controlUniverso.BuscarPlaneta(this.nombrePlanetaInicial);
            Planeta planetaFinal = this.controlUniverso.BuscarPlaneta(this.nombrePlanetaFinal);
            this.controlUniverso.AgregarAdyasenciaPlaneta(planetaInicial, planetaFinal);
            PintarLinea(planetaInicial, planetaFinal);
            this.nombrePlanetaInicial = "";
            this.nombrePlanetaFinal = "";
        }
    }

    public void PintarLinea(Planeta planetaInicial, Planeta planetaFinal) {
        System.out.println("pinte");
        Line linea = new Line(planetaInicial.getPosicionX() + 80, planetaInicial.getPosicionY() + 80, planetaFinal.getPosicionX() + 80, planetaFinal.getPosicionY() + 80);
        linea.setStroke(Color.CORNFLOWERBLUE);
        linea.setStrokeWidth(3);
        linea.setStrokeDashOffset(5); //separacion
        linea.getStrokeDashArray().addAll(5d);
        this.VistaSistemaPlanetario.getChildren().add(linea);
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
