/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vistas.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import Modelo.VistaGenerica;
import javafx.scene.Parent;

/**
 *
 * @author matel
 */
public class FileLoader {

    private String path;

    public FileLoader(String path) {
        this.path = path;
    }

    public VistaGenerica open(String tipoController) {
        URL response = null;
        try {
            File file = new File(this.path);
            if (file.exists()) {
                response = file.toURI().toURL();
            }
            VistaGenerica vistaGenerica = changeStage2(response, tipoController);
            return vistaGenerica;
        } catch (IOException ex) {
            System.out.println("Error al abrir el archivo" + ex);
        }
        return null;
    }

    private VistaGenerica changeStage2(URL url, String tipoController) {
        if (url != null) {
            FXMLLoader loader = new FXMLLoader(url);
            try {
                VistaGenerica vistaGenerica;
                Parent panelEdit = loader.load();
                switch (tipoController) {
                    case "universo":
                        vistaGenerica = new VistaGenerica(panelEdit, (UniversoController) loader.getController());
                        break;
                    case "nebulosa":
                        vistaGenerica = new VistaGenerica(panelEdit, (NebulosaController) loader.getController());
                        break;
                    case "sistemaplanetario":
                        vistaGenerica = new VistaGenerica(panelEdit, (SistemaPlanetarioController) loader.getController());
                        break;
                    case "planeta":
                        vistaGenerica = new VistaGenerica(panelEdit, (PlanetaController) loader.getController());
                        break;
                    case "menu":
                        vistaGenerica = new VistaGenerica(panelEdit, (MenuController) loader.getController());
                        break;
                    default:
                        vistaGenerica = new VistaGenerica();
                        break;
                }
                if (tipoController.equals("universo")) {

                }

                return vistaGenerica;
            } catch (Exception e) {
                System.out.println("No se pudo abrir este" + e);
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
