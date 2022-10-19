package n1exercici1;

public class VendaBuidaException extends Exception{
	// atribut
	private String missatge;
	
	//constructor
	public VendaBuidaException(String missatge) {
		super(missatge);		
	}
	
}
