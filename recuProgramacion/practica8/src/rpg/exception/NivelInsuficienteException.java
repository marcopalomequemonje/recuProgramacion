package rpg.exception;

public class NivelInsuficienteException extends Exception{
    public NivelInsuficienteException (){
        super("El personaje no tiene suficiente nivel para entrar a la ciudad");
    }
}
