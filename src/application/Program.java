package application;

import java.util.Date;
import java.util.List;

import model.dao.ComandaDao;
import model.dao.DaoFactory;
import model.entities.Comanda;

public class Program {

	public static void main(String[] args) {

		Comanda com = new Comanda(3, 2300, 1003, 155, "Sócio Proprietário", new Date(), 12, true, new Date(), 6);
		System.out.println(com);

		ComandaDao comandaDao = DaoFactory.createComandaDao();

		Comanda comm0 = comandaDao.findById(1);
		System.out.println(comm0);
		
		
		System.out.println("\n === TESTE 3: Comanda findAll ===");
		List<Comanda> list = comandaDao.findAll();
		for(Comanda comm : list) {
			System.out.println(comm);
		}
	}

}
