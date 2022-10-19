package n1exercici1;

import java.util.ArrayList;

public class Venda {
	
	//atribut
	private ArrayList<Producte> llistaProductes;
	private double preuTotal;
	
	//constructor
	public Venda(ArrayList<Producte> llistaProductes) {

		this.llistaProductes=llistaProductes;
	}
	//getters i setters

	
	public void setLlistaProductes(ArrayList<Producte> llistaProductes) {
		this.llistaProductes=llistaProductes;
	}

	
	public ArrayList<Producte> getLlistaProductes () {
		return llistaProductes;
	}

	public double getPreuTotal() {
		return preuTotal;
	}


	public void setPreuTotal(double preuTotal) {
		this.preuTotal = preuTotal;
	}
	
	

	//OPCIÓ THROWS
	/*public double calcularTotal() throws VendaBuidaException  {
		double preuTotal =0;
		
		
			if (this.llistaProductes.size()==0){
				throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
			}*/
	
	

	//opció try & catch 
	public void calcularTotal() {
		
		try {	
			
			if (this.llistaProductes.size()==0) {
				throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
			}
			double preuTotal = 0;
			System.out.println(this.llistaProductes.size());
			for (int i = 0; i < this.llistaProductes.size(); i++) {
				preuTotal= preuTotal + this.llistaProductes.get(i).getPreu();
			}	
			
			this.preuTotal=preuTotal;
			
		} catch (VendaBuidaException exception) {
			System.out.println(exception);
		}
		
		
	}	
		
}	