package n1exercici1;

public class Producte {

	//atributs
	private String nom;
	private double preu;
	
	//constructor
	public Producte(String nom, double preu) {
		this.nom=nom;
		this.preu=preu;
	}
	
	//getters
	public String getNom() {
		return nom;
	}
	public double getPreu() {
		return preu;
	}
	// setters
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setPreu(double preu) {
		this.preu=preu;
	}
	
	
}
