package com.up.clinicavet.facade;

public interface IFacadeDAO<ID,T> {
	
	public void salvar(T objeto) throws Exception;
	public T buscar(ID id) throws Exception;
	public void update(T objeto) throws Exception;
	public void delete(ID id) throws Exception;
}