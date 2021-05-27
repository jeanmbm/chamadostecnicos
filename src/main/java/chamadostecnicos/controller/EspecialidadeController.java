package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;
import chamadostecnicos.model.dao.EspecialidadeDao;


public class EspecialidadeController {
	
	EspecialidadeDao especialidadeDao;

	// C - create
	public boolean cadastrarEspecialidade(Especialidade especialidade) {
		especialidadeDao = new EspecialidadeDao();
		boolean salvo = especialidadeDao.salvarEspecialidade(especialidade);
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
		especialidadeDao = new EspecialidadeDao();
		boolean editado = especialidadeDao.editarEspecialidade(especialidade);
		return editado;
	}
			
	// D - delete
	public boolean apagarEspecialidades (int id) {
		especialidadeDao = new EspecialidadeDao();
		boolean deletado = especialidadeDao.deletarEspecialidade(id);
		return deletado;
	}	

}
