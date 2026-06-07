package swrpg.model;

public class Inventario {
    private Personaje idPersonaje;
    private int idEquipo;
    private int cantidad;


    public Inventario() {
    }


    public Inventario(Personaje idPersonaje, int idEquipo, int cantidad) {
        this.idPersonaje = idPersonaje;
        this.idEquipo = idEquipo;
        this.cantidad = cantidad;
    }

    public Personaje getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Personaje idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
