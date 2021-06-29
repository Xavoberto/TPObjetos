package domain.entities;

public class DeudaProveedor {
    private int cuitProveedor;
    private double deudaTotal;


    public DeudaProveedor(int cuit, double deuda) {
        cuitProveedor = cuit;
        deudaTotal = deuda;
    }

    public String Print() {
        return "Cuit Proveedor: " + cuitProveedor + ", Deuda Total: " + deudaTotal + ".   ";
    }
}
