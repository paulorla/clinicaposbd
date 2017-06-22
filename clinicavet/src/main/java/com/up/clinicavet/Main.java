package com.up.clinicavet;

import java.util.List;

import com.up.clinicavet.dao.GenericDAO;
import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;

public class Main {
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			pessoaDAO.beginTransaction();
			Pessoa p = pessoaDAO.findByCPF(111L);
			System.out.println(p.getNome());
			
			pessoaDAO.commitAndCloseTransaction();
		} catch (Exception e) {
			pessoaDAO.rollbackAndCloseTransaction();
			e.printStackTrace();
		} finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!!!");
	}
}