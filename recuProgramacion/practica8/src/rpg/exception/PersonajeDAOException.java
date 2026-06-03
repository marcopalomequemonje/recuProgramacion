package rpg.exception;

public class PersonajeDAOException extends Exception{
    public PersonajeDAOException(){
        super("ERROR en la conexión con la base de datos y la tabla personajes");
    }
}
