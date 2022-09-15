package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.ComandaDao;
import model.entities.Comanda;

public class ComandaDaoJDBC implements ComandaDao {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

	private Connection conn;

	public ComandaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Comanda com) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("INSERT INTO evento_comanda "
					+ "(ID, CD_PERSON, NR_COMANDA, CD_AREA_EVT, TP_PERSON, DH_ATD, CD_USU_ATD, TP_SIT, DH_ATU, CD_USU_ATU) "
					+ "VALUES "
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, com.getID());
			st.setLong(2, com.getCD_PERSON());
			st.setLong(3, com.getNR_COMANDA());
			st.setLong(4, com.getCD_AREA_EVT());
			st.setString(5, com.getTP_PERSON());
			st.setDate(6, new java.sql.Date(com.getDH_ATD().getTime()));
			st.setLong(7, com.getCD_USU_ATD());
			st.setBoolean(8, com.getTP_SIT());
			st.setDate(9, new java.sql.Date(com.getDH_ATU().getTime()));
			st.setLong(10, com.getCD_USU_ATU());
			
			int linhasAfetadas = st.executeUpdate();
			
			if(linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					com.setID(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro, nenhuma linha afetada !");
					
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override //REVISAR CÓDIGO
	public void update(Comanda com) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("UPDATE evento_comanda "
					+ "SET ID = ?, CD_PERSON = ?, NR_COMANDA = ?, CD_AREA_EVT = ?, TP_PERSON = ?, DH_ATD = ?, CD_USU_ATD = ?, TP_SIT = ?, DH_ATU = ?, CD_USU_ATU = ? ) "
					+ "WHERE "
					+ " ID = ?  ",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, com.getID());
			st.setLong(2, com.getCD_PERSON());
			st.setLong(3, com.getNR_COMANDA());
			st.setLong(4, com.getCD_AREA_EVT());
			st.setString(5, com.getTP_PERSON());
			st.setDate(6, new java.sql.Date(com.getDH_ATD().getTime()));
			st.setLong(7, com.getCD_USU_ATD());
			st.setBoolean(8, com.getTP_SIT());
			st.setDate(9, new java.sql.Date(com.getDH_ATU().getTime()));
			st.setLong(10, com.getCD_USU_ATU());
			
			st.executeUpdate();
	
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}


	@Override
	public void deleteById(int ID) {
		
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM evento_comanda "
					+ "WHERE "
					+ "ID = ? "
					);
			st.setInt(1, ID);
			
		    st.executeUpdate();
				
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Comanda findById(int ID) {
		PreparedStatement st = null;
		ResultSet rt = null;
		try {
			st = conn.prepareStatement("SELECT * FROM evento_comanda WHERE ID = ?");
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
		PreparedStatement st = null;
		ResultSet rt = null;
		try {
			st = conn.prepareStatement("SELECT * FROM evento_comanda");
			rt = st.executeQuery();
			
			List<Comanda> list = new ArrayList<>();
			 while(rt.next()) {
				Comanda comm = instatiateComanda(rt);
				list.add(comm);
			 }
			 return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {	
			DB.closeStatement(st);
			DB.closeResultSet(rt);
		}	
	}
}
