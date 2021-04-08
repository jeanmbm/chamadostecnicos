package chamadostecnicos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Acompanhamento;
import chamadostecnicos.model.Area;
import chamadostecnicos.model.Avaliacao;
import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.Usuario;


public class AcompanhamentoController {
	
	static List<Acompanhamento> acompanhamentos = new ArrayList<Acompanhamento>();
	Acompanhamento acompanhamento;
	Avaliacao avaliacao;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();

	
	public void gerarAcompanhamento() {
		AcompanhamentoController controller = new AcompanhamentoController();
		acompanhamento = new Acompanhamento();
		controller.pegarChamado(acompanhamento);
		controller.pegarTecnico(acompanhamento);
		acompanhamento.setId(r.nextInt(100));
		acompanhamentos.add(acompanhamento);
	}

	public void pegarChamado(Acompanhamento acompanhamento) {
		ChamadoController c = new ChamadoController();
		System.out.println("Digite o id do chamado para abrir um acompanhamento: ");
		int id = scan.nextInt();
		c.pegarChamado(id, acompanhamento);
	}
	
	public void pegarTecnico(Acompanhamento acompanhamento) {
		UsuarioController u = new UsuarioController();
		u.pegarTecnico(acompanhamento);
	}
	
	
	public void finalizarAcompanhamentoUsuario(Acompanhamento acompanhamento) {
		System.out.println("Usuario, deseja finalizar o acompanhamento? (S ou N)");
		String aux = scan.next();
		if (aux.equalsIgnoreCase("S")) {
			acompanhamento.setSolucionadoUsuario(true);
		} else {
			acompanhamento.setSolucionadoUsuario(false);
		}
	}
	
	
	public void finalizarAcompanhamentoTecnico(Acompanhamento acompanhamento) {
		System.out.println("Técnico, deseja finalizar o acompanhamento? (S ou N)");
		String aux2 = scan.next();
		if (aux2.equalsIgnoreCase("S")) {
			acompanhamento.setSolucionadoTecnico(true);
		} else {
			acompanhamento.setSolucionadoTecnico(false);
		}
	}
	
	public void exibirAcompanhamento() {
		for (Acompanhamento acompanhamento : acompanhamentos) {
			System.out.println(acompanhamento.toString());
		}
	}
	
	
	public void finalizarAcompanhamento(Chamado chamado, Acompanhamento acompanhamento) {
		ChamadoController c = new ChamadoController();
		AvaliacaoController a = new AvaliacaoController();
		avaliacao = new Avaliacao();
		
		System.out.println("Digite o id do acompanhamento");
		
		if (acompanhamento.isSolucionadoUsuario() == true && acompanhamento.isSolucionadoTecnico() == true) {
			chamado.setStatus(Status.CONCLUIDO);
			chamado.setPrazoSolucao(LocalDate.now());
			acompanhamento.setAvaliacao(avaliacao = a.realizarAvaliacao()); 
		} else {
			System.out.println("Um dos usuarios não finalizou o acompanhamento");
		}
	}
	
}
