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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class UniversoController implements Initializable {

    private FileLoader fileLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public UniversoController(AnchorPane marco) {
        try {
            String ruta = "src/Vistas/Universo.fxml";
            this.fileLoader = new FileLoader(ruta);
            marco.getChildren().clear();
            marco.getChildren().add(fileLoader.open(ruta));
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

}
