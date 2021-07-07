package domain.entities.documentos;

import domain.entities.ItemCompra;
import domain.entities.ProveedorProducto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra {
    private int nroCompra;
    private List<ItemCompra> items;
    private double precio;
    private LocalDate fecha;


    public OrdenDeCompra(String[] ordenDeCompra, String[] itemCompra, ProveedorProducto producto) {
        nroCompra = Integer.parseInt(ordenDeCompra[0]);
        items = new ArrayList<ItemCompra>();
        precio = Double.parseDouble(ordenDeCompra[2]);
        fecha = LocalDate.now();

        items.add(new ItemCompra(itemCompra, producto));
    }

    public OrdenDeCompra(int nroCompra, List<ItemCompra> itemsCompra, double precio){
        this.nroCompra = nroCompra;
        this.items = itemsCompra;
        this.precio = precio;
        this.fecha = LocalDate.now();
    }

    public int getNroCompra() {
        return nroCompra;
    }
}
