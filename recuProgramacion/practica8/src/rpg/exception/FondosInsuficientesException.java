package rpg.exception;

public class FondosInsuficientesException extends Exception{
    public FondosInsuficientesException(){
        super("No tiene oro suficiente");
    }
}
