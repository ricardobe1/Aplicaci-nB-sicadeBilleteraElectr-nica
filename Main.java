
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del titular: ");
        String nombreTitular = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer después de leer el número

        CuentaBancaria02 cuenta = new CuentaBancaria02(nombreTitular, saldoInicial);

        System.out.println("\n¡Bienvenido, " + cuenta.getTitular() + "!");
        System.out.println("Su saldo inicial es: " + cuenta.getSaldo());

        // Realizar transacciones manualmente
        while (true) {
            System.out.println("\n¿Qué acción desea realizar?");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Ver Historial de Transacciones");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de leer la opción

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer después de leer el número
                    cuenta.depositar(montoDeposito);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer después de leer el número
                    cuenta.retirar(montoRetiro);
                    break;
                case 3:
                    ArrayList<String> historial = cuenta.obtenerHistorial();
                    System.out.println("\nHistorial de Transacciones:");
                    for (String transaccion : historial) {
                        System.out.println(transaccion);
                    }
                    break;
                case 4:
                    System.out.println("¡Gracias por utilizar nuestros servicios!");
                    scanner.close(); // Cerrar el Scanner antes de salir del programa
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }
}