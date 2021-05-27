package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Departamento;
import chamadostecnicos.model.dao.DepartamentoDao;


public class DepartamentoController {

	DepartamentoDao departamentoDao;
	
	// C - create
	public boolean cadastrarDepartamento(Departamento departamento) {
		departamentoDao = new DepartamentoDao();
		boolean salvo = departamentoDao.salvarDepartamento(departamento);
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
		departamentoDao = new DepartamentoDao();
		boolean editado = departamentoDao.editarDepartamento(departamento);
		return editado;
	}
	
	
	// D - delete
	public boolean apagarDepartamento (int id) {
		departamentoDao = new DepartamentoDao();
		boolean deletado = departamentoDao.deletarDepartamento(id);
		return deletado;
	}
	
}
