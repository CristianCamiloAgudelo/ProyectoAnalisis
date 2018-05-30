/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.LinkedList;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private ScrollPane Scrollpane;
    @FXML
    private AnchorPane Vista;
    @FXML
    private AnchorPane Vistapane;
    @FXML
    private ImageView Imagen;
    @FXML
    private Label Texto;
    @FXML
    private Button Btn1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(Universo universo) {
        this.universo = universo;
        this.Texto.setText(universo.getNombre());
    }

//    public UniversoController(Universo universo) {
//
//        this.universo = universo;
//    }
    /**
     * @return the universo
     */
    public Universo getUniverso() {
        return universo;
    }

    /**
     * @param universo the universo to set
     */
    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    @FXML
    private void CambiarTexto(ActionEvent event) {
        this.Texto.setText("una por la de negrito");
    }

}
