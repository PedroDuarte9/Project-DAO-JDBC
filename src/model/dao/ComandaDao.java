package model.dao;

import java.util.List;

import model.entities.Comanda;

public interface ComandaDao {

	void insert (Comanda comm);
	void update (Comanda com);
	void deleteById(int ID);
	Comanda findById(int ID);
	List<Comanda> findAll();
}
 