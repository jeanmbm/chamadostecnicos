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
		servicoDao = new ServicoDao();
		boolean salvo = servicoDao.salvarServico(servico);
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
		servicoDao = new ServicoDao();
		boolean editado = servicoDao.editarServico(servico);
		return editado;
	}
	
	// D - delete
	public boolean apagarServico(int id) {
		servicoDao = new ServicoDao();
		boolean deletado = servicoDao.deletarServico(id);
		return deletado;
	}

}
