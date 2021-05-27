package chamadostecnicos.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.dao.ServicoDao;

public class ChamadoView {
	
	Scanner scan = new Scanner(System.in);
	
	public Chamado preencherChamado() {
		Chamado chamado = new Chamado();
		ServicoDao servicoDao = new ServicoDao();
		Servico servico = new Servico();
		
		System.out.print("Digite o id do servico que deseja: ");
		chamado.setIdServico(scan.nextInt());
		scan.nextLine();
		
		servico = servicoDao.selecionarServicoPorId(chamado.getIdServico());
		
		System.out.print("Informe o problema: ");
		chamado.setMensagem(String.valueOf(scan.nextLine()));
		
		chamado.setStatus(Status.ANALISE);
		
		chamado.setDataAbertura(LocalDate.now());

		if (servico.getPrioridade() == Prioridade.BAIXA) {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(30));
		} else if (servico.getPrioridade() == Prioridade.MEDIA) {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(20));
		} else if (servico.getPrioridade() == Prioridade.ALTA) {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(10));
		} else {
			chamado.setPrazoSolucao(chamado.getDataAbertura().plusDays(5));
		}
		
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
				System.out.println("");
				System.out.println("Servico: " + chamado.getServico().toString());
				System.out.println("");
				System.out.println("Problema: " + chamado.getMensagem());
				System.out.println("Status: " + chamado.getStatus().getDescricao());
				System.out.println("Data de abertura: " + chamado.getDataAbertura());
				System.out.println("Prazo: " + chamado.getPrazoSolucao());
				System.out.println("Data da solução: " + chamado.getDataSolucao());
				System.out.println("");
				System.out.println("=================================================================");
			}
			System.out.println("=================================================================");
			System.out.println("");
		}
	}

}
