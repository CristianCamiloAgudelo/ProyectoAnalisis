/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisisinfinity;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author usuario
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private Label label;
    @FXML
    private Button btnHola;
    
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    private void detectame(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void hola(ActionEvent event)
    {
         System.out.println("You clicked me!");
        label.setText("Hello World!");    }

    
}
