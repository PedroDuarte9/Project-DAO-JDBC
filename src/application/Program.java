package application;

import java.util.Date;

import model.entities.Comanda;


public class Program {

	public static void main(String[] args) {
		
		
			
		Comanda com = new Comanda (1, 22, 35, 41, "Sócio", new Date(), 12, true, new Date(), 6);
		System.out.println(com);
	}

}
