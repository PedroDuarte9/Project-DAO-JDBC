package model.dao;

import java.util.List;

import model.entities.Comanda;

public interface ComandaDao {

	void insert (Comanda com);
	void update (Comanda com);
	void deleteById(int id);
	Comanda findById(int Id);
	List<Comanda> findAll();
}
 