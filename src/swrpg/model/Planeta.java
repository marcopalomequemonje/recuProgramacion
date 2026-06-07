package swrpg.model;

public class Planeta {
    private int id;
    private String nombre;
    private int nivelAmenaza;


    public Planeta() {
    }

    public Planeta(int id, String nombre, int nivelAmenaza) {
        this.id = id;
        this.nombre = nombre;
        this.nivelAmenaza = nivelAmenaza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelAmenaza() {
        return nivelAmenaza;
    }

    public void setNivelAmenaza(int nivelAmenaza) {
        this.nivelAmenaza = nivelAmenaza;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivelAmenaza=" + nivelAmenaza +
                '}';
    }
}
