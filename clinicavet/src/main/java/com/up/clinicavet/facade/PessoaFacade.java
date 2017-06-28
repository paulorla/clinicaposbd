package com.up.clinicavet.facade;

import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.model.Pessoa;

public class PessoaFacade implements IFacadeDAO<Integer, Pessoa>{
	
	private PessoaDAO dao = new PessoaDAO();

	@Override
	public void salvar(Pessoa objeto) {
		try {
			dao.beginTransaction();
			dao.save(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public Pessoa buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pessoa objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}