package com.up.clinicavet.dao;

import java.util.List;

import javax.persistence.Query;

import com.up.clinicavet.model.Pessoa;

public class PessoaDAO extends GenericDAO<Integer, Pessoa>{
	public PessoaDAO() {
		super(Pessoa.class);
	}
	
	public List<Pessoa> listar(){
		String sql = "select p from Pessoa p";
		Query query = super.getEntityManager().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}
}