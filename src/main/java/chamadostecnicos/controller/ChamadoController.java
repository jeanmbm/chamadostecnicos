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
	
	
	public List<Chamado> listarChamado() {
		List<Chamado> chamados = new ArrayList<Chamado>();
		chamadoDao = new ChamadoDao();
		chamados = chamadoDao.listarChamados();
		return chamados;
	}
	
//	public void mudarStatusChamado(int id) {
//		chamadoDao = new ChamadoDao();
//		Status status = null;
//		boolean aux = false;
//		
//		while (aux == false) {
//			System.out.println("Digite para qual status deseja mudar: em aberto, cancelado");
//			String aux2 = scan.nextLine();
//			
//			if (aux2.equalsIgnoreCase("Em aberto")) {
//				aux = true;
//				status = Status.ABERTO;
//			} else if (aux2.equalsIgnoreCase("Cancelado")) {
//				aux = true;
//				status = Status.CANCELADO;
//			} else {
//				System.out.println("!! Status inválido !!");
//				aux = false;
//			}
//		}
//		
//		boolean editado = chamadoDao.editarStatusDoChamado(status, id);
//		if (editado) {
//			System.out.println("");
//			System.out.println("!! Status editado com sucesso !!");
//			System.out.println("");
//		}
//		
//	}

}
