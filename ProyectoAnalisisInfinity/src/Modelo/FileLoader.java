/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author matel
 */
public class FileLoader {

    private String path;

    public FileLoader(String path) {
        this.path = path;
    }

    public Parent open(String path) {
        System.out.println("Entre a " + path);
        URL response = null;
        try {
            File file = new File(path);
            if (file.exists()) {
                response = file.toURI().toURL();
            }
            Parent parent = changeStage2(response);
            return parent;
        } catch (IOException ex) {
            System.out.println("Error al abrir el archivo" + ex);
        }
        return null;
    }

    private void openStage(URL url) {
        if (url != null) {
            FXMLLoader loader = new FXMLLoader(url);
            try {
                Parent panelEdit = loader.load();

                Scene scene = new Scene(panelEdit);//lo de por dentro
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("No se pudo abrir " + e);
            }
        }
    }

    private Parent changeStage2(URL url) {
        if (url != null) {
            FXMLLoader loader = new FXMLLoader(url);
            try {
                Parent panelEdit = loader.load();

                return panelEdit;
            } catch (Exception e) {
                System.out.println("No se pudo abrir " + e);
            }
        }
        return null;
    }
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
}
