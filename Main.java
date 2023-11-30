
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Nombre del Titular", 1000.0);

        cuenta.depositar(500.0);
        cuenta.retirar(200.0);
        cuenta.depositar(100.0);

        ArrayList<String> historial = cuenta.obtenerHistorial();
        System.out.println("\nHistorial de Transacciones:");
        for (String transaccion : historial) {
            System.out.println(transaccion);
        }

        // Ejemplo de uso de depositarSeguro
        cuenta.depositarSeguro(300.0);
    }
}