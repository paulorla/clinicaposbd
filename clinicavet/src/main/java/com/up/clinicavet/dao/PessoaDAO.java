package com.up.clinicavet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.up.clinicavet.jdbc.factory.ConnectionFactory;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;
import com.up.clinicavet.model.TipoAnimal;

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
	
	public Pessoa buscarEager(Integer id) throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Exception ex = null;
		try{
			Pessoa retorno = null;
			con = ConnectionFactory.getConnection();
			
			String sql = "SELECT p.PESSOA_ID,p.CPF,p.NOME as nomePessoa,p.NASCIMENTO as nascimentoPessoa, "
					+ "a.animal_id, a.nome as nomeAnimal,a.nascimento as nascimentoAnimal "
					+ "FROM PESSOA p "
					+ "LEFT JOIN ANIMAL a on (a.pessoa_id = p.pessoa_id) "
					+ "WHERE p.pessoa_id=?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			
			rs = statement.executeQuery();
			if(rs.next()){
				retorno = new Pessoa();
				retorno.setId(rs.getInt("PESSOA_ID"));
				retorno.setCpf(rs.getLong("CPF"));
				retorno.setNome(rs.getString("nomePessoa"));
				retorno.setNascimento(rs.getDate("nascimentoPessoa"));
				List<Animal> animais = new ArrayList<Animal>();
				
				rs.getInt("animal_id");
				if(!rs.wasNull()){
					do{
						Animal a = new Animal();
						a.setId(rs.getInt("animal_id"));
						a.setNome(rs.getString("nomeAnimal"));
						a.setNascimento(rs.getDate("nascimentoAnimal"));
						animais.add(a);
					}while(rs.next());
				}
				retorno.setAnimais(animais);
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
	
	public void persistirComAnimais(Pessoa objeto) throws Exception {
		Connection con = null;
		PreparedStatement statementDono = null;
		PreparedStatement statementAnimal = null;
		ResultSet keys = null;
		Exception ex = null;
		try{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO PESSOA "
					+ "(cpf,nome,nascimento) VALUES (?,?,?)";
			statementDono = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statementDono.setLong(1, objeto.getCpf());
			statementDono.setString(2, objeto.getNome());
			if(objeto.getNascimento() != null)
				statementDono.setDate(3, new java.sql.Date(objeto.getNascimento().getTime()));
			else
				statementDono.setDate(3, null);
			
			statementDono.executeUpdate();
			keys = statementDono.getGeneratedKeys();
			if(keys.next())
				objeto.setId(keys.getInt(1));
			else
				throw new Exception("Falha ao inserir o item");
			
			sql = "INSERT INTO ANIMAL (TIPO_ID, PESSOA_ID, NOME, NASCIMENTO) "
					+ "VALUES (?,?,?,?)";
			statementAnimal = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for(Animal a : objeto.getAnimais()){
				statementAnimal.setInt(1, a.getTipo().getId());
				statementAnimal.setInt(2, objeto.getId());
				statementAnimal.setString(3, a.getNome());
				if(a.getNascimento() != null)
					statementAnimal.setDate(4, new java.sql.Date(a.getNascimento().getTime()));
				else
					statementAnimal.setDate(4, null);
				statementAnimal.executeUpdate();
				keys.close();
				keys = statementAnimal.getGeneratedKeys();
				if(keys.next())
					a.setId(keys.getInt(1));
				else
					throw new Exception("Falha ao inserir o animal do dono");
				
			}
			con.commit();
			return;
		}catch(Exception e){
			con.rollback();
			ex = e;
		}finally{
			if(statementAnimal!=null){
				try {
					statementAnimal.close();
				} catch (SQLException e) {
					ex = e;
				}
			}
			if(statementDono!=null){
				try {
					statementDono.close();
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

	public void persistir(Pessoa objeto) throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet keys = null;
		Exception ex = null;
		try{
			con = ConnectionFactory.getConnection();
			
			String sql = "INSERT INTO PESSOA "
					+ "(cpf,nome,nascimento) VALUES (?,?,?)";
			statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, objeto.getCpf());
			statement.setString(2, objeto.getNome());
			if(objeto.getNascimento() != null)
				statement.setDate(3, new java.sql.Date(objeto.getNascimento().getTime()));
			else
				statement.setDate(3, null);
			
			statement.executeUpdate();
			keys = statement.getGeneratedKeys();
			if(keys.next())
				objeto.setId(keys.getInt(1));
			else
				throw new Exception("Falha ao inserir o item");
			return;
		}catch(Exception e){
			ex = e;
		}finally{
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

	public void remover(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Pessoa objeto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}