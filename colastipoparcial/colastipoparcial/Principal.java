package colastipoparcial;

public class Principal {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        new Menu(inventario).mostrarMenu();
    }
}
