package colastipoparcial;

import javax.swing.*;

class PC extends Dispositivo {
    private String memoriaRAM, discoDuro;

    public PC(String serial, String marca, String memoriaRAM, String discoDuro, double precio) {
        super(serial, marca, precio);
        this.memoriaRAM = memoriaRAM;
        this.discoDuro = discoDuro;
    }

    @Override
    public void editar() {
        super.editar();
        this.memoriaRAM = JOptionPane.showInputDialog("Ingrese la nueva memoria RAM:", this.memoriaRAM);
        this.discoDuro = JOptionPane.showInputDialog("Ingrese el nuevo disco duro:", this.discoDuro);
    }

    @Override
    public String mostrarInfo() {
        return "PC - Serial: " + serial + "\nMarca: " + marca + "\nRAM: " + memoriaRAM + "\nDisco Duro: " + discoDuro + "\nPrecio: " + precio + "\nDisponible: " + (disponible ? "Sí" : "No") + (disponible ? "" : "\nPrestado a: " + nombreEstudiante);
    }
}


class Tablet extends Dispositivo {
    private String tamaño;

    public Tablet(String serial, String marca, String tamaño, double precio) {
        super(serial, marca, precio);
        this.tamaño = tamaño;
    }

    @Override
    public void editar() {
        super.editar();
        this.tamaño = JOptionPane.showInputDialog("Ingrese el nuevo tamaño:", this.tamaño);
    }

    @Override
    public String mostrarInfo() {
        return "Tablet - Serial: " + serial + "\nMarca: " + marca + "\nTamaño: " + tamaño + "\nPrecio: " + precio + "\nDisponible: " + (disponible ? "Sí" : "No") + (disponible ? "" : "\nPrestado a: " + nombreEstudiante);
    }
}