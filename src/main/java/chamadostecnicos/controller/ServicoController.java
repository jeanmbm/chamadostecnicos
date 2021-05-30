package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;
import chamadostecnicos.model.dao.ServicoDao;


public class ServicoController {
	
	ServicoDao servicoDao;
	
	// C - create
	public boolean cadastrarServico(Servico servico) {
		boolean salvo = false;
		
		if (servico.getNome().isEmpty() || servico.getNome() == null) {
			System.err.println("Erro! Campo 'Nome' não pode ser nulo ou vazio !!");
		} else if (servico.getPrioridade() == null) {
			System.err.println("Erro! Campo 'Prioridade' não pode ser nulo ou vazio !!");
		} else if (servico.getArea() == null) {
			System.err.println("Erro! Campo 'Area' não pode ser nulo ou vazio !!");
		} else if (servico.getIdCategoria() <= 0) {
			System.err.println("Erro! Campo 'IdCategoria' não pode ser menor ou igual !!");
		} else {
			servicoDao = new ServicoDao();
			salvo = servicoDao.salvarServico(servico);
		}
		
		return salvo;
	}
	
	// R - read
	public List<Servico> listarServicos() {
		List<Servico> servicos;
		servicoDao = new ServicoDao();
		servicos = servicoDao.listarServico();
		return servicos;
	}
	
	// U - update
	public boolean editarServico(Servico servico) {
		boolean editado = false;
		
		if (servico.getNome().isEmpty() || servico.getNome() == null) {
			System.err.println("Erro! Campo 'Nome' não pode ser nulo ou vazio !!");
		} else if (servico.getPrioridade() == null) {
			System.err.println("Erro! Campo 'Prioridade' não pode ser nulo ou vazio !!");
		} else if (servico.getArea() == null) {
			System.err.println("Erro! Campo 'Area' não pode ser nulo ou vazio !!");
		} else if (servico.getIdCategoria() <= 0) {
			System.err.println("Erro! Campo 'IdCategoria' não pode ser menor ou igual !!");
		} else {
			servicoDao = new ServicoDao();
			editado = servicoDao.editarServico(servico);
		}
		
		return editado;
	}
	
	// D - delete
	public boolean apagarServico(int id) {
		boolean deletado = false;
		
		if (id > 0) {
			servicoDao = new ServicoDao();
			deletado = servicoDao.deletarServico(id);
		} else {
			System.err.println("Erro! ID não pode ser menor ou igual a 0 !!");
			System.out.println();
			deletado = false;
		}
		
		return deletado;
	}

}
