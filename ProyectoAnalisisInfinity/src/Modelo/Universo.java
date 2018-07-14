package Modelo;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author Cristian Camilo Agudelo
 */
public class Universo {

    private String Nombre;
    private List<Nebulosa> listaNebulosas;

    public Universo() {
        this.listaNebulosas = new LinkedList<>();
    }

    public Universo(String Nombre) {
        this.Nombre = Nombre;
        this.listaNebulosas = new LinkedList<>();
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the listaNebulosas
     */
    public List<Nebulosa> getListaNebulosas() {
        return listaNebulosas;
    }

    /**
     * @param listaNebulosas the listaNebulosas to set
     */
    public void setListaNebulosas(List<Nebulosa> listaNebulosas) {
        this.listaNebulosas = listaNebulosas;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
