package swrpg.model;

public class Especie {
    private int id;
    private String nombre;
    private int bonificadorVida;

    public Especie() {
    }


    public Especie(int id, String nombre, int bonificadorVida) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadorVida = bonificadorVida;
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

    public int getBonificadorVida() {
        return bonificadorVida;
    }

    public void setBonificadorVida(int bonificadorVida) {
        this.bonificadorVida = bonificadorVida;
    }
}
