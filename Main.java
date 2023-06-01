import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu();

    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("1) Ingresar venta");
            System.out.println("2) Listar piletas vendidas");
            System.out.println("3) Mostrar el total dinero recaudado en pesos");
            System.out.println("0) Salir");

            System.out.println("\nOpcion: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                Venta venta = new Venta();
                venta.ingresarVenta();
            } else if (opcion == 2) {
                Venta venta = new Venta();
                venta.listarPiletasVendidas();
            } else if (opcion == 3) {
                Venta venta = new Venta();
                venta.totalVendidoEnPesos();
            } else if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("No existe esa opcion!!");
            }
        }
    }
}