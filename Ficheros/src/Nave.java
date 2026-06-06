public class Nave extends ElementoEstelar{
        private String tipo;
        private int potencia;

    public Nave(int id, String nombre, String tipo, int potencia) {
        super(id, nombre);
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "tipo='" + tipo + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
