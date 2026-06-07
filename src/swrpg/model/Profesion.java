package swrpg.model;

public class Profesion {
    private int id;
    private String nombre;
    private boolean sensibleFuerza;

    public Profesion() {
    }

    public Profesion(int id, String nombre, boolean sensibleFuerza) {
        this.id = id;
        this.nombre = nombre;
        this.sensibleFuerza = sensibleFuerza;
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

    public boolean isSensibleFuerza() {
        return sensibleFuerza;
    }

    public void setSensibleFuerza(boolean sensibleFuerza) {
        this.sensibleFuerza = sensibleFuerza;
    }
}
