public class ProductoServicio {
    private String nombre;
    private TipoDeUnidad tipoDeUnidad;
    private double precio;
    private String descripcion;
    private Iva iva;

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeUnidad getTipoDeUnidad() {
        return tipoDeUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Iva getIva() {
        return iva;
    }
}
