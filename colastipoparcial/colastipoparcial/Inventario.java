package colastipoparcial;

import javax.swing.*; // aqui use el JOption
import java.util.*; // Aqui use queue y linkedlist 

class Inventario {
    private Queue<Dispositivo> dispositivos;

    public Inventario() {
        dispositivos = new LinkedList<>();
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
        JOptionPane.showMessageDialog(null, "Dispositivo agregado: " + dispositivo.serial);
    }

    public void mostrarInventario() {
        if (dispositivos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío.");
            return;
        }
        StringBuilder inventarioTexto = new StringBuilder("Inventario:\n");
        for (Dispositivo d : dispositivos) {
            inventarioTexto.append(d.mostrarInfo()).append("\n---------------------\n");
        }
        JOptionPane.showMessageDialog(null, inventarioTexto.toString());
    }

    public void prestarDispositivo() {
        Dispositivo dispositivo = seleccionarDispositivo("Seleccione el dispositivo a prestar:");
        if (dispositivo != null && dispositivo.disponible) {
            String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            dispositivo.prestar(nombreEstudiante);
            JOptionPane.showMessageDialog(null, "Dispositivo prestado.");
        }
    }

    public void devolverDispositivo() {
        Dispositivo dispositivo = seleccionarDispositivo("Seleccione el dispositivo a devolver:");
        if (dispositivo != null && !dispositivo.disponible) {
            dispositivo.devolver();
            JOptionPane.showMessageDialog(null, "Dispositivo devuelto.");
        }
    }

    public void editarDispositivo() {
        Dispositivo dispositivo = seleccionarDispositivo("Seleccione el dispositivo a editar:");
        if (dispositivo != null) {
            dispositivo.editar();
            JOptionPane.showMessageDialog(null, "Dispositivo actualizado.");
        }
    }

    private Dispositivo seleccionarDispositivo(String mensaje) {
        if (dispositivos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay dispositivos disponibles.");
            return null;
        }
        String[] opciones = new String[dispositivos.size()];
        int i = 0;
        for (Dispositivo d : dispositivos) {
            opciones[i++] = d.serial + " - " + d.marca;
        }
        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, "Seleccionar Dispositivo", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (seleccion == null) return null;
        for (Dispositivo d : dispositivos) {
            if (seleccion.startsWith(d.serial)) {
                return d;
            }
        }
        return null;
    }
}
class Menu {
    private Inventario inventario;

    public Menu(Inventario inventario) {
        this.inventario = inventario;
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog("Menú de Inventario:\n1. Agregar PC\n2. Agregar Tablet\n3. Mostrar Inventario\n4. Editar Dispositivo\n5. Prestar Dispositivo\n6. Devolver Dispositivo\n7. Salir\nSeleccione una opción:");
            switch (opcion) {
                case "1":
                    inventario.agregarDispositivo(new PC(JOptionPane.showInputDialog("Serial:"), JOptionPane.showInputDialog("Marca:"), JOptionPane.showInputDialog("RAM:"), JOptionPane.showInputDialog("Disco Duro:"), Double.parseDouble(JOptionPane.showInputDialog("Precio:"))));
                    break;
                case "2":
                    inventario.agregarDispositivo(new Tablet(JOptionPane.showInputDialog("Serial:"), JOptionPane.showInputDialog("Marca:"), JOptionPane.showInputDialog("Tamaño:"), Double.parseDouble(JOptionPane.showInputDialog("Precio:"))));
                    break;
                case "3": inventario.mostrarInventario(); break;
                case "4": inventario.editarDispositivo(); break;
                case "5": inventario.prestarDispositivo(); break;
                case "6": inventario.devolverDispositivo(); break;
                case "7": salir = true; break;
                default: JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}