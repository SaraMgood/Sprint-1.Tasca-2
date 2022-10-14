package n1exercici1;

public class VendaBuidaException extends Exception{
	// atribut
	private String missatge;
	
	//constructor
	public VendaBuidaException(String missatge) {
		super();
		this.missatge = "Per fer una venda primer has d’afegir productes";
	}
	//getter
	public String getMissatge() {
		return this.missatge; 
	}


	
}
