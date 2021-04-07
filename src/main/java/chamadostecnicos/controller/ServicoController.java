package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;


public class ServicoController {
	
	
	static List<Servico> servicos = new ArrayList<Servico>();
	Servico servico;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	// C - create
	public void cadastrarServico() {
		ServicoController servicoController = new ServicoController();
		
		Servico servico1 = new Servico(r.nextInt(100), "Servico teste", "Descri��o teste", Prioridade.MEDIA);
		servicos.add(servico1);
		
		servico = new Servico();
		servico = servicoController.preencherDadosServico();
		selecionarCategoria(servico);
		servicos.add(servico);
		System.out.println("!! Servico cadastrado com sucesso !!");
		System.out.println("");
	}
	
	
	// R - read
	public void listarServicos() {
		List<Servico> servicos = new ArrayList<Servico>();
		servicos = ServicoController.servicos;
		exibirDadosCategoria(servicos);
	}
	
	
	// U - update
	public void atualizarDadosCategoria(int id) {
		List<Servico> removerServico = new ArrayList<Servico>();
		Servico servicoEditado = new Servico();
		servico = new Servico();
		for (int i = 0; i < servicos.size(); i++) {
			servico = servicos.get(i);
			if(servico.getId() == id) {
				removerServico.add(servico);
				servicoEditado = editarServico(servico);
				selecionarCategoria(servicoEditado);
			}
		}
		
		if(removerServico.isEmpty()) {
			System.out.println("!! Id do servico n�o localizado !!");
		} else {
			servicos.removeAll(removerServico);
			servicos.add(servicoEditado);
			System.out.println("!! Servico editado com sucesso !!");
		}
	}
	
	
	// D - delete
	public void apagarServico(int id) {
		List<Servico> removerServico = new ArrayList<Servico>();
		for (Servico servico : servicos) {
			if (servico.getId() == id) {
				removerServico.add(servico);
			}
		}
		
		if(removerServico.isEmpty()) {
			System.out.println("!! Id do servico n�o localizado !!");
		} else {
			servicos.removeAll(removerServico);
			System.out.println("!! Servico apagado com sucesso !!");
		}
	}
	
	
	// Codigos auxiliares
	
	public void selecionarCategoria(Servico servico) {
		CategoriaServicoController controller = new CategoriaServicoController();
		System.out.println("Digite o id da categoria a que esse servico dever� pertencer: ");
		int id = scan.nextInt();
		controller.pegarCategoriaPorId(id, servico);
	}
	
	
	public void pegarServicoPorId(int id, Chamado chamado) {
		List<Servico> servicos = new ArrayList<Servico>();
		servicos = ServicoController.servicos;
		
		if (servicos.size() == 0) {
			System.out.println("!! N�o h� servicos cadastrados !!");
		} else {
			for (int i = 0; i < servicos.size(); i++) {
				servico = servicos.get(i);
				if (servico.getId() == id) {
					chamado.setServico(servico);
				} else {
					System.out.println("!! Servico n�o encontrado !!");
				}
			}
		}
	}
	
	
	public Servico preencherDadosServico() {
		Servico servico = new Servico();
		
		System.out.print("Digite o nome do servico: ");
		servico.setNome(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite a descri��o do servico: ");
		servico.setDescricao(String.valueOf(scan.nextLine()));
		
		boolean aux2 = false;
		while (aux2 == false) {
			System.out.println("Digite o nivel de prioridade deste servico: baixa, media, alta ou urgente");
			String aux = scan.next();
			if (aux.equalsIgnoreCase("baixa")) {
				servico.setPrioridade(Prioridade.BAIXA);
				aux2 = true;
			} else if (aux.equalsIgnoreCase("media")) {
				servico.setPrioridade(Prioridade.MEDIA);
				aux2 = true;
			} else if (aux.equalsIgnoreCase("alta")) {
				servico.setPrioridade(Prioridade.ALTA);
				aux2 = true;
			} else if (aux.equalsIgnoreCase("urgente")) {
				servico.setPrioridade(Prioridade.URGENTE);
				aux2 = true;
			} else {
				aux2 = false;
				System.out.println("!! N�vel de prioridade n�o correspondente !!");	
				System.out.println("");
			}
		}
		
		servico.setId(r.nextInt(100));
		
		return servico;
	}
	
	
	public void exibirDadosCategoria(List<Servico> servicos) {
		if (servicos.isEmpty()) {
			System.out.println("!! N�o h� servicos cadastrados !!");
		} else {
			System.out.println("");
			System.out.println("===============================================================");
			System.out.println("=========================\\ SERVICOS //=========================");
			for (Servico servico : servicos) {
				System.out.println("");
				System.out.println("Id: " + servico.getId());
				System.out.println("Nome do servico: " + servico.getNome());
				System.out.println("Descricao: " + servico.getDescricao());
				System.out.println("Prioridade: " + servico.getPrioridade());
				System.out.println("Categoria: " + servico.getCategoria().toString());
				System.out.println("");
				System.out.println("================================================================");
			}
			System.out.println("================================================================");
			System.out.println("");
		}
		
	}
	
	
	public Servico editarServico(Servico servico) {
		Servico servicoEditado = new Servico();
		
		System.out.print("Digite o nome do servico: ");
		servicoEditado.setNome(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite a descri��o do servico: ");
		servicoEditado.setDescricao(String.valueOf(scan.nextLine()));
		
		boolean aux2 = false;
		while (aux2 == false) {
			System.out.print("Digite o nivel de prioridade deste servico (baixa, media, alta ou urgente): ");
			String aux = scan.next();
			if (aux.equalsIgnoreCase("baixa")) {
				servicoEditado.setPrioridade(Prioridade.BAIXA);
				aux2 = true;
			} else if (aux.equalsIgnoreCase("media")) {
				servicoEditado.setPrioridade(Prioridade.MEDIA);
				aux2 = true;
			} else if (aux.equalsIgnoreCase("alta")) {
				servicoEditado.setPrioridade(Prioridade.ALTA);
				aux2 = true;
			} else if (aux.equalsIgnoreCase("urgente")) {
				servicoEditado.setPrioridade(Prioridade.URGENTE);
				aux2 = true;
			} else {
				aux2 = false;
				System.out.println("!! N�vel de prioridade n�o correspondente !!");	
				System.out.println("");
			}
		}
		
		servicoEditado.setId(servico.getId());
		
		return servicoEditado;
	}

}
