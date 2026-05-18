package rpg.model;

public class Habilidad {
    private int id;
    private String nombre;
    private int danio_base;
    private int usos_maximos;
    private int id_clase;

    public Habilidad(int id, String nombre, int danio_base, int usos_maximos, int id_clase) {
        this.id = id;
        this.nombre = nombre;
        this.danio_base = danio_base;
        this.usos_maximos = usos_maximos;
        this.id_clase = id_clase;
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

    public int getDanio_base() {
        return danio_base;
    }

    public void setDanio_base(int danio_base) {
        this.danio_base = danio_base;
    }

    public int getUsos_maximos() {
        return usos_maximos;
    }

    public void setUsos_maximos(int usos_maximos) {
        this.usos_maximos = usos_maximos;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }
}
