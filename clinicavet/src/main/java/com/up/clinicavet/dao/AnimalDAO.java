package com.up.clinicavet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicavet.jdbc.factory.ConnectionFactory;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;

public class AnimalDAO implements IGenericDAO<Animal, Integer>{

	public List<Animal> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Animal buscar(Integer id) throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Exception ex = null;
		try{
			Animal retorno = null;
			
			con = ConnectionFactory.getConnection();
			
			String sql = "SELECT tipo_id,pessoa_id,nome,nascimento FROM ANIMAL WHERE animal_id=?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			
			rs = statement.executeQuery();
			if(rs.next()){
				retorno = new Animal();
				retorno.setId(id);
				
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("pessoa_id"));
				retorno.setDono(p);
				
				retorno.setNome(rs.getString("nome"));
				retorno.setNascimento(rs.getDate("nascimento"));
			}
			
			return retorno;
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

	public void persistir(Animal objeto) throws Exception {
				
	}

	public void remover(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Animal objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
