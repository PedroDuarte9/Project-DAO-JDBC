package model.dao;

import db.DB;
import model.dao.impl.ComandaDaoJDBC;

public class DaoFactory {

		public static ComandaDao createComandaDao() {
			return new ComandaDaoJDBC(DB.getConnection());
		}
}
