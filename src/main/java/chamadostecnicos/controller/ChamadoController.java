package chamadostecnicos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.Usuario;

public class ChamadoController {
	
	
	static List<Chamado> chamados = new ArrayList<Chamado>();
	Chamado chamado;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	// C - create
	public void cadastrarChamado(Usuario usuario) {
		ChamadoController controller = new ChamadoController();
		chamado = new Chamado();
		chamado = controller.preencherChamado();
		chamado.setUsuario(usuario);
		chamados.add(chamado);
		System.out.println("");
		System.out.println("!! Chamado aberto com sucesso. Está em análise !!");
		System.out.println("");
	}
	
	
	public void listarChamado() {
		List<Chamado> chamados = new ArrayList<Chamado>();
		chamados = ChamadoController.chamados;
		exibirChamados(chamados);
	}
	
	public void mudarStatusChamado(int id) {
		boolean aux = false;
		while (aux == false) {
			System.out.println("Digite para qual status deseja mudar: em aberto, em andamento, concluido, cancelado");
			String aux2 = scan.nextLine();
			for (Chamado chamado : chamados) {
				if(chamado.getId() == id) {
					if (aux2.equalsIgnoreCase("Em aberto")) {
						aux = true;
						chamado.setStatus(Status.ABERTO);
					} else if (aux2.equalsIgnoreCase("Em andamento")) {
						aux = true;
						chamado.setStatus(Status.ANDAMENTO);
					} else if (aux2.equalsIgnoreCase("Concluido")) {
						aux = true;
						chamado.setStatus(Status.CONCLUIDO);
					} else if (aux2.equalsIgnoreCase("Cancelado")) {
						aux = true;
						chamado.setStatus(Status.CANCELADO);
					} else {
						System.out.println("!! Status errado !!");
					}	
				}
			}
		}
	}
	
	
	public Chamado preencherChamado() {
		Chamado chamado = new Chamado();
		
		System.out.println("Digite o id do servico que deseja: ");
		int id = scan.nextInt();
		ServicoController c = new ServicoController();
		c.pegarServicoPorId(id, chamado);
		
		chamado.setStatus(Status.ANALISE);
		
		chamado.setDataAbertura(LocalDate.now());
		
		 if (chamado.getServico().getPrioridade() == Prioridade.BAIXA) {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(30));
		} else if (chamado.getServico().getPrioridade() == Prioridade.MEDIA) {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(20));
		} else if (chamado.getServico().getPrioridade() == Prioridade.ALTA) {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(10));
		} else {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(5));
		}
		 
		chamado.setId(r.nextInt(100));
		
		return chamado;
	}
	
	
	public void exibirChamados(List<Chamado> chamados) {
		if (chamados.isEmpty()) {
			System.out.println("!! Não há chamados !!");
		} else {
			System.out.println("");
			System.out.println("=================================================================");
			System.out.println("=========================\\ CHAMADOS //=========================");
			for (Chamado chamado : chamados) {
				System.out.println("");
				System.out.println("Id: " + chamado.getId());
				System.out.println("Usuario: " + chamado.getUsuario().toString());
				System.out.println("Servico: " + chamado.getServico().toString());
				System.out.println("Status: " + chamado.getStatus());
				System.out.println("Data de abertura: " + chamado.getDataAbertura());
				System.out.println("Prazo: " + chamado.getPrazoSolucao());
				System.out.println("=================================================================");
			}
			System.out.println("=================================================================");
			System.out.println("");
		}
	}

}
