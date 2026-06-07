package swrpg.exception;

public class CreditosInsuficientesException extends Exception{
    public CreditosInsuficientesException(){
        super("El personaje no tiene creditos suficientes para esta compra");
    }
}
