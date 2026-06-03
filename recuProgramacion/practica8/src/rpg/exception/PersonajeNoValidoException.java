package rpg.exception;

public class PersonajeNoValidoException extends Exception{
    public PersonajeNoValidoException(){
        super("Personaje no válido");
    }
}
