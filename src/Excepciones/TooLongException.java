package Excepciones;

public class TooLongException extends InvalidNameException{
	
	public TooLongException(){
		super("Name too long");
	}
}
