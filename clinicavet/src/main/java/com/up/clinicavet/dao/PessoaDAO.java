package com.up.clinicavet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicavet.jdbc.factory.ConnectionFactory;
import com.up.clinicavet.model.Pessoa;

public class PessoaDAO implements IGenericDAO<Pessoa, Integer>{

	public List<Pessoa> listar() throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Exception ex = null;
		try{
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			con = ConnectionFactory.getConnection();
			
			String sql = "SELECT pessoa_id,cpf,nome,nascimento FROM PESSOA";
			statement = con.prepareStatement(sql);
			
			rs = statement.executeQuery();
			while(rs.next()){
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("pessoa_id"));
				p.setCpf(rs.getLong("cpf"));
				p.setNome(rs.getString("nome"));
				p.setNascimento(rs.getDate("nascimento"));
				
				pessoas.add(p);
			}
			
			return pessoas;
		}catch(Exception e){
			ex = e;
		}finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					ex = e;
				}
			}
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					ex = e;
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					ex = e;
				}
			}
		}
		throw ex;
	}

	public Pessoa buscar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void persistir(Pessoa objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void remover(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Pessoa objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}