public class Tripulante extends ElementoEstelar{
    private String rango;
    private static final String [] rangos = {"CADETE", "CAPITAN", "ALMIRANTE"};
    public Tripulante(int id, String nombre, String rango) throws RangoNoValidoException{
        super(id, nombre);
        if (comprobarRango(rango)){
            this.rango = rango;
        }
        else {
            throw new RangoNoValidoException();
        }
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) throws RangoNoValidoException {
        if (comprobarRango(rango)){
            this.rango = rango;
        }
        else {
            throw new RangoNoValidoException();
        }
    }
    //EJ 2
    private boolean comprobarRango (String rango){
        for (String r : rangos){
            if (r.equalsIgnoreCase(rango)){
                return true;
            }
        }
        return false;
    }
}
