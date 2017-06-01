package com.up.clinicavet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;
import com.up.clinicavet.model.TipoAnimal;

public class Main {

	public static void main(String[] args) {
		
		try{
			TipoAnimal ta = new TipoAnimal();
			ta.setId(0);
			
			TipoAnimal ta2 = new TipoAnimal();
			ta2.setId(999);
			
			Pessoa p = new Pessoa();
			p.setNome("Jurandir");
			p.setCpf(123490L);
			p.setNascimento(new Date());
			
			List<Animal> animaisP = new ArrayList<Animal>();
			
			Animal a1 = new Animal();
			a1.setNome("Animal 1 Jurandir");
			a1.setTipo(ta);
			animaisP.add(a1);
			
			Animal a2 = new Animal();
			a2.setNome("Animal 2 Jurandir");
			a2.setTipo(ta);
			animaisP.add(a2);
			
			p.setAnimais(animaisP);
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.persistirComAnimais(p);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}