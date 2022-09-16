package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.ComandaDao;
import model.dao.DaoFactory;
import model.entities.Comanda;

public class Program {

	/*Classe principal que está responsável pelos métodos do crud
	 * Precisa ser migrada para classes específicas
	 * 
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Comanda com = new Comanda(7, 2300, 1003, 155, "Sócio Proprietário", new Date(), 12, true, new Date(), 6);
//		System.out.println(com);

		ComandaDao comandaDao = DaoFactory.createComandaDao();
		
		System.out.println("====== Teste 1:  findById =====" );
//		Comanda comm0 = comandaDao.findById(1);
//		System.out.println(comm0);
		
		
		System.out.println("====== Teste 3:  Insert =====" );
		Comanda newComanda = new Comanda(8, 2300, 1003, 155, "Sócio Proprietário", new Date(), 12, true, new Date(), 6060 );
		comandaDao.insert(newComanda);
		System.out.println("Inserted! New id: " + newComanda.getID());
		
		
//		System.out.println("\n === Teste 4 Comanda DELETE ===");
//		System.out.println("Digite o id para ser deletado");
//		int id = sc.nextInt();
//		comandaDao.deleteById(id);
//		System.out.println("Delete completo");
		
		
		System.out.println("\n === Teste 5 Comanda Update ===");
		Comanda novaComanda = comandaDao.findById(3);
		novaComanda.setCD_PERSON(2131);
		System.out.println(novaComanda);
		System.out.println(novaComanda.getID());
		System.out.println("Update feito !");
		
		
		System.out.println("\n === TESTE 2: Comanda findAll ===");
		List<Comanda> list = comandaDao.findAll();
		for(Comanda comm : list) {
			System.out.println(comm);
			
			
			
			sc.close();
		}
		
		
		
	}

}
