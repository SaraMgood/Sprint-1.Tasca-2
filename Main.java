/*Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra classe anomenada "Venda". 
Aquesta classe té com a atributs una col·lecció de productes i el preu total de la venda. OK

La classe "Venda", té un mètode anomenat calcularTotal() que llança l’excepció personalitzada 
VendaBuidaException i mostra per pantalla “Per fer una venda primer has d’afegir productes” 
si la col·lecció de productes està buida. OK

Si la col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la suma de tots els preus dels productes 
a l’atribut preu total de la venda.OK?

L’excepció personalitzada VendaBuidaException ha de ser filla de la classe Exception. Al seu constructor li hem de passar el missatge  
“Per fer una venda primer has d’afegir productes” i quan capturem l’excepció, l’hem de mostrar per pantalla amb el mètode getMessage() de l’excepció.

Escriu el codi necessari per a generar i capturar una excepció de tipus ArrayIndexOutOfBoundsException.*/

package n1exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Array per guardar els productes existents
	static ArrayList<Producte> llistaProductes = new ArrayList<Producte>();

	public static void main(String[] args) {

		// INPUT
		String menu = ("1.Crear producte\n" + "2.Veure producte\n" + "3.Total compra\n" + "0.Sortir");

		// OUTPUT

		int accio = 0;
		do {
			accio = funcioInputInt(menu);

			switch (accio) {
			
			case 1:
				crearProducte();

				break;
			case 2:
				veureProducte();

				break;
			case 3:
				 comprarProducte();

				break;
			
			case 0:
				System.out.println("Adéu.");
				
				break;

			default:
				System.out.println("Introdueix una acció de les del menú");

			}

		} while (accio <= 3 && accio > 0);

	}

	// metodes principals
	
	public static void crearProducte() {
		String nom = funcioInputString("Quin nom rep el producte?");
		double preu = funcioInputDouble("Quin preu rep el producte?");
		double preuTotal=0;
		Producte producte = new Producte(nom, preu);
		llistaProductes.add(producte);
		System.out.println("El producte " + producte.getNom() + " amb el preu: " + producte.getPreu()
		+ " s'ha registrar correctament. ");
		
	}

	public static void veureProducte() {

		try {
			if (llistaProductes.size() == 0) {
				throw new ArrayIndexOutOfBoundsException("Array Buida");
			}

			for (int i = 0; i <= llistaProductes.size() - 1; i++) {
				System.out.println(llistaProductes.get(i).getNom() + " | " + llistaProductes.get(i).getPreu() + " | ");
				//trobat = true;
			}
		} catch (ArrayIndexOutOfBoundsException excepcion) {
			System.out.println(excepcion.getMessage());
		}

	}

	public static void comprarProducte() {
		ArrayList<Producte> productesVenda = new ArrayList<Producte>();
		Venda novaVenda = new Venda(productesVenda);
		boolean vendaFinalitzada = false;
		boolean trobat = false;
		
		// comprovar arrayproductes es buida
				
		if (llistaProductes.size() == 0) {
				System.out.println("No hi ha productes registrats");
				novaVenda.calcularTotal();
				vendaFinalitzada = true;
				
		} else {
			
			while (vendaFinalitzada == false) {
				
				String resposta = funcioInputString("Quin producte vols comprar? ");
				
				for(int i = 0;i<llistaProductes.size();i++) {
					if (llistaProductes.get(i).getNom().equalsIgnoreCase(resposta)) {//cerca el producte que volem comprar dins llista de productes
						novaVenda.getLlistaProductes().add(llistaProductes.get(i));  //afegeix producte trobat a la llista de productes dins la llista novaVenda 
						trobat = true;
					}
				i++;
				}
								
				// preguntar si vol seguir compra

				String resposta2 = funcioInputString("Vols seguir comprant");
				if (resposta2.equalsIgnoreCase("no")) {
					vendaFinalitzada = true;
					novaVenda.calcularTotal();
					System.out.println("Total compra: " + novaVenda.getPreuTotal());
				}
				
				if (trobat == false) {
					System.out.println("No s'ha trobat el producte indicat");
					
				}
				
								
			}			
		}
		
}			
		
	// métodes ajuda
	public static String funcioInputString(String missatge) {
		System.out.println(missatge);
		Scanner input = new Scanner(System.in);
		return input.nextLine();

	}

	public static double funcioInputDouble(String missatge) {
		System.out.println(missatge);
		Scanner input = new Scanner(System.in);
		return input.nextDouble();
	}

	public static int funcioInputInt(String missatge) {
		System.out.println(missatge);
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

}
