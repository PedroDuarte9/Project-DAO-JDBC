package application;

import java.util.Date;

import model.dao.ComandaDao;
import model.dao.DaoFactory;
import model.entities.Comanda;

public class Program {

	public static void main(String[] args) {

		Comanda com = new Comanda(1, 22, 35, 41, "Sócio", new Date(), 12, true, new Date(), 6);
		System.out.println(com);

		ComandaDao comandaDao = DaoFactory.createComandaDao();

		Comanda comm = comandaDao.findById(1);
		Comanda comm1 = comandaDao.findById(2);
		System.out.println(comm);
		System.out.println(comm1);
	}

}
