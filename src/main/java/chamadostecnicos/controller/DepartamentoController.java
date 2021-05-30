package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Departamento;
import chamadostecnicos.model.dao.DepartamentoDao;


public class DepartamentoController {

	DepartamentoDao departamentoDao;
	
	// C - create
	public boolean cadastrarDepartamento(Departamento departamento) {
		boolean salvo = false;
		
		if (departamento.getNome().isEmpty() || departamento.getNome()  == null) {
			System.out.println("");
			System.err.println("Erro! Campo nome não pode ser nulo ou vazio !!");
			System.out.println("");
		} else {
			departamentoDao = new DepartamentoDao();
			salvo = departamentoDao.salvarDepartamento(departamento);
		}
		
		return salvo;
	}
	
	
	// R - read
	public List<Departamento> listarDepartamentos() {
		List<Departamento> departamentos;
		departamentoDao = new DepartamentoDao();
		departamentos = departamentoDao.listarDepartamentos();
		return departamentos;
	}
	
	
	// U - update
	public boolean editarDepartamento(Departamento departamento) {
		boolean editado = false;
		
		if (departamento.getNome().isEmpty() || departamento.getNome()  == null) {
			System.out.println("");
			System.err.println("Erro! Campo nome não pode ser nulo ou vazio !!");
			System.out.println("");
		} else {
			departamentoDao = new DepartamentoDao();
			editado = departamentoDao.editarDepartamento(departamento);
		}
		
		return editado;
	}
	
	
	// D - delete
	public boolean apagarDepartamento (int id) {
		boolean deletado = false;
		departamentoDao = new DepartamentoDao();
		
		if (id <= 0) {
			System.out.println("");
			System.err.println("Erro! ID não pode ser menor ou igual a 0 !!");
			System.out.println("");
			deletado = false;
			
		} else {
			deletado = departamentoDao.deletarDepartamento(id);
		}
		
		return deletado;
	}
	
}
