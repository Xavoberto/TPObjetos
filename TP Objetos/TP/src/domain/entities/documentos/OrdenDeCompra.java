package domain.entities.documentos;

import domain.entities.ItemCompra;

import java.time.LocalDate;
import java.util.List;

public class OrdenDeCompra {
    private int nroCompra;
    private List<ItemCompra> items;
    private double precio;
    private LocalDate fecha;
}
