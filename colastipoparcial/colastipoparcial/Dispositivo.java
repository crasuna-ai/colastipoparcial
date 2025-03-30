package colastipoparcial;

import javax.swing.*;
import java.io.Serializable;


abstract class Dispositivo implements Serializable {
    protected String serial, marca, nombreEstudiante;
    protected double precio;
    protected boolean disponible;

    public Dispositivo(String serial, String marca, double precio) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.disponible = true;
        this.nombreEstudiante = "";
    }

    public void prestar(String nombreEstudiante) {
        if (disponible) {
            this.nombreEstudiante = nombreEstudiante;
            this.disponible = false;
        }
    }

    public void devolver() {
        if (!disponible) {
            this.nombreEstudiante = "";
            this.disponible = true;
        }
    }

    public void editar() {
        this.marca = JOptionPane.showInputDialog("Ingrese la nueva marca:", this.marca);
        this.precio = solicitarPrecio();
    }

    protected double solicitarPrecio() {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio:", this.precio));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        }
    }

    public abstract String mostrarInfo();
}