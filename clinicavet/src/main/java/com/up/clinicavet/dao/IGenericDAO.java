package com.up.clinicavet.dao;

import java.util.List;

public interface IGenericDAO<T,U> {
	public List<T> listar() throws Exception;
	public T buscar(U id) throws Exception;
	public void persistir(T objeto) throws Exception;
	public void remover(U id) throws Exception;
	public void atualizar(T objeto) throws Exception;
}