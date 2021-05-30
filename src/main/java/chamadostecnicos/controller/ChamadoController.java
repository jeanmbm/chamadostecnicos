package chamadostecnicos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.dao.ChamadoDao;
import chamadostecnicos.model.dao.ServicoDao;

public class ChamadoController {
	
	Chamado chamado;
	ChamadoDao chamadoDao;
	
	
	// C - create
	public boolean cadastrarChamado(Chamado chamado) {
		chamadoDao = new ChamadoDao();
		boolean salvo = chamadoDao.salvarChamado(chamado);
		return salvo;
	}
	
	// L - list
	public List<Chamado> listarChamado() {
		List<Chamado> chamados = new ArrayList<Chamado>();
		chamadoDao = new ChamadoDao();
		chamados = chamadoDao.listarChamados();
		return chamados;
	}

}
