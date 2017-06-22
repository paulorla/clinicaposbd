package com.up.clinicavet.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.up.clinicavet.model.Pessoa;

public class PessoaDAO extends GenericDAO<Integer, Pessoa> {
	public PessoaDAO() {
		super(Pessoa.class);
	}

	public List<Pessoa> listar() {
		String sql = "select p from Pessoa p";
		Query query = super.getEntityManager().createQuery(sql);

		@SuppressWarnings("unchecked")
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}

	public List<Pessoa> listarPessoasQuePossuemTipoAnimal(Integer idTipoAnimal) {
		String sql = "select p from Pessoa p" 
				+ " inner join fetch p.animais a"
				+ " where a.tipo.id = :idTipoAnimal"
				+ " group by p,a";

		TypedQuery<Pessoa> query = super.getEntityManager().createQuery(sql, Pessoa.class);
		query.setParameter("idTipoAnimal", idTipoAnimal);

		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}

	public Pessoa findEager(Integer id) {
		String sql = "select p from Pessoa p "
				+ " inner join fetch p.animais"
				+ " where p.id = :idPessoa";
		TypedQuery<Pessoa> query = super.getEntityManager().createQuery(sql, Pessoa.class);
		query.setParameter("idPessoa", id);

		try {
			Pessoa retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Pessoa findByCPF(Long cpf) {
		Query query = super.getEntityManager().createNamedQuery("Pessoa.findBycpf");
		query.setParameter("cpf", cpf);

		try {
			Pessoa retorno = (Pessoa) query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public List<Pessoa> listar(Boolean ordenacaoAscendente) {
		String strOrderBy;
		if (ordenacaoAscendente == true)
			strOrderBy = " order by p.nome asc";
		else
			strOrderBy = " order by p.nome desc";
		
		String sql = "select p from Pessoa p" + strOrderBy;
		Query query = super.getEntityManager().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Pessoa> retorno = query.getResultList();
		return retorno;
	}
}