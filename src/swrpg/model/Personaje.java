package swrpg.model;

public class Personaje {
    private int id;
    private String nombre;
    private int nivel;
    private int creditos;
    private int vida_actual;
    private int lado_oscuro;
    private Especie idEspecie;
    private Profesion idProfesion;
    private Planeta idPlanetaActual;


    public Personaje() {
    }

    public Personaje(int id, String nombre, int nivel, int creditos, int vida_actual, int lado_oscuro, Especie idEspecie, Profesion idProfesion, Planeta idPlanetaActual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.creditos = creditos;
        this.vida_actual = vida_actual;
        this.lado_oscuro = lado_oscuro;
        this.idEspecie = idEspecie;
        this.idProfesion = idProfesion;
        this.idPlanetaActual = idPlanetaActual;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public int getLado_oscuro() {
        return lado_oscuro;
    }

    public void setLado_oscuro(int lado_oscuro) {
        this.lado_oscuro = lado_oscuro;
    }

    public Especie getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Especie idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Profesion getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Profesion idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Planeta getIdPlanetaActual() {
        return idPlanetaActual;
    }

    public void setIdPlanetaActual(Planeta idPlanetaActual) {
        this.idPlanetaActual = idPlanetaActual;
    }
}
