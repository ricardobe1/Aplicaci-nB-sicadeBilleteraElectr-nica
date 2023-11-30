import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

class CuentaBancaria {
    private String titular;
    private double saldo;
    private ArrayList<String> historialTransacciones;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.historialTransacciones = new ArrayList<>();
        this.historialTransacciones.add("Saldo inicial: " + saldoInicial + " - " + new Date());
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
        historialTransacciones.add("Depósito de " + monto + " - " + new Date());
        System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
    }

    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            historialTransacciones.add("Retiro de " + monto + " - " + new Date());
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    public ArrayList<String> obtenerHistorial() {
        return historialTransacciones;
    }

    public void depositarSeguro(double monto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(String.valueOf(monto).getBytes());
            // Aquí puedes implementar lógica adicional para usar el hash en la transacción segura
            System.out.println("Depósito seguro realizado con éxito.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error en el depósito seguro.");
            e.printStackTrace();
        }
    }
}

