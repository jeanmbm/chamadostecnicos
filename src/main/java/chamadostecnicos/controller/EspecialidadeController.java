package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;
import chamadostecnicos.model.dao.EspecialidadeDao;
import chamadostecnicos.model.dao.ServicoDao;


public class EspecialidadeController {
	
	EspecialidadeDao especialidadeDao;

	// C - create
	public boolean cadastrarEspecialidade(Especialidade especialidade) {
		boolean salvo = false;
		
		if (especialidade.getNome().isEmpty() || especialidade.getNome() == null) {
			System.err.println("Erro! Campo 'Nome' não pode ser nulo ou vazio !!");
			salvo = false;
		} else if (especialidade.getArea() == null) {
			System.err.println("Erro! Campo 'Area' não pode ser nulo ou vazio !!");
			salvo = false;
		} else {
			especialidadeDao = new EspecialidadeDao();
			salvo = especialidadeDao.salvarEspecialidade(especialidade);
		}
		
		return salvo;
	}
		
	// R - read
	public List<Especialidade> listarEspecialidades() {
		List<Especialidade> especialidades;
		especialidadeDao = new EspecialidadeDao();
		especialidades = especialidadeDao.listarEspecialidades();
		return especialidades;
	}
		
	// U - update
	public boolean editarEspecialidade(Especialidade especialidade) {
		
		boolean editado = false;
		
		if (especialidade.getNome().isEmpty() || especialidade.getNome() == null) {
			System.err.println("Erro! Campo 'Nome' não pode ser nulo ou vazio !!");
			editado = false;
		} else if (especialidade.getArea() == null) {
			System.err.println("Erro! Campo 'Area' não pode ser nulo ou vazio !!");
			editado = false;
		} else {
			especialidadeDao = new EspecialidadeDao();
			editado = especialidadeDao.editarEspecialidade(especialidade);
		}
		
		return editado;
	}
			
	// D - delete
	public boolean apagarEspecialidades (int id) {
		boolean deletado = false;
		
		if (id > 0) {
			especialidadeDao = new EspecialidadeDao();
			deletado = especialidadeDao.deletarEspecialidade(id);
		} else {
			System.err.println("Erro! ID não pode ser menor ou igual a 0 !!");
			System.out.println("");
			deletado = false;
		}
		
		return deletado;
	}	

}
