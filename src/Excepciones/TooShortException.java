package Excepciones;

public class TooShortException extends InvalidNameException{
public TooShortException(){
	super("Name too short");
}
}
