package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ComandaDao;
import model.entities.Comanda;

public class ComandaDaoJDBC implements ComandaDao {

	private Connection conn;

	public ComandaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Comanda com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Comanda com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comanda findById(int ID) {
		PreparedStatement st = null;
		ResultSet rt = null;
		try {
			st = conn.prepareStatement("SELECT * FROM  evento_comanda WHERE ID = ?");
			st.setInt(1, ID);
			rt = st.executeQuery();
			if(rt.next()) {
				
				Comanda comm = instatiateComanda(rt);
				return comm;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rt);
		}
	}

	public Comanda instatiateComanda(ResultSet rt) throws SQLException {
		Comanda comm = new Comanda();
		comm.setID(rt.getInt("ID"));
		comm.setCD_PERSON(rt.getInt("CD_PERSON"));
		comm.setNR_COMANDA(rt.getInt("NR_COMANDA"));
		comm.setCD_AREA_EVT(rt.getInt("CD_AREA_EVT"));
		comm.setTP_PERSON(rt.getString("TP_PERSON"));
		comm.setDH_ATD(rt.getDate("DH_ATD"));
		comm.setCD_USU_ATD(rt.getInt("CD_USU_ATD"));
		comm.setTP_SIT(rt.getBoolean("TP_SIT"));
		comm.setDH_ATU(rt.getDate("DH_ATU"));
		comm.setCD_USU_ATU(rt.getInt("CD_USU_ATU"));
		return comm;
	}

	@Override
	public List<Comanda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
