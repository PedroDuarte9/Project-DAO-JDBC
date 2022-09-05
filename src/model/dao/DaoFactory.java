package model.dao;

import model.dao.impl.ComandaDaoJDBC;

public class DaoFactory {

		public static ComandaDao createComandaDao() {
			return new ComandaDaoJDBC();
		}
}
