package domain.entities;

public class Direccion {
    private String calle;
    private int altura;
    private String localidad;
    private int codigoPostal;
    private String provincia;
    private String pais;

    public Direccion(String s, String s1, String s2, String s3, String s4, String s5) {
        calle = s;
        altura = Integer.parseInt(s1);
        localidad = s2;
        codigoPostal = Integer.parseInt(s3);
        provincia = s4;
        pais = s5;
    }

    public Direccion(String calle, int altura, String localidad, int codigoPostal, String provincia, String pais){
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.pais = pais;
    }
}
