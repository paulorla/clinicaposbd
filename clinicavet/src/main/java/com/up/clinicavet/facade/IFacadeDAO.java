package com.up.clinicavet.facade;

public interface IFacadeDAO<ID,T> {
	
	public void salvar(T objeto);
	public T buscar(ID id);
	public void update(T objeto);
	public void delete(ID id);
}