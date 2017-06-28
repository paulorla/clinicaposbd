package com.up.clinicavet.facade;

import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.model.Pessoa;

public class PessoaFacade implements IFacadeDAO<Integer, Pessoa> {

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
	public Pessoa buscar(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Pessoa pessoa = dao.find(id);
			dao.commitAndCloseTransaction();
			return pessoa;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public Pessoa buscarEager(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Pessoa pessoa = dao.findEager(id);
			dao.commitAndCloseTransaction();
			return pessoa;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void update(Pessoa objeto) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			dao.beginTransaction();
			Pessoa p = dao.findReferenceOnly(id);
			dao.delete(p);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
}