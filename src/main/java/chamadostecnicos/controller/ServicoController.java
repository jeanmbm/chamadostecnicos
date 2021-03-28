package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;

public class ServicoController {
	
	List<Servico> servicos = new ArrayList<Servico>();
	Servico servico;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	// C - create
	public void cadastrarServico() {
		ServicoController servicoController = new ServicoController();
		servico = new Servico();
		servico = servicoController.preencherDadosServico();
		servicos.add(servico);
		System.out.println("!! Categoria cadastrada com sucesso !!");
		
	}
	
	// R - read
	public void listarServicos() {
		List<Servico> servicos = new ArrayList<Servico>();
		servicos = this.servicos;
		exibirDadosCategoria(servicos);
	}
	
	// U - update
	public void atualizarDadosCategoria(long id) {
		List<Servico> removerServico = new ArrayList<Servico>();
		Servico servicoEditado = new Servico();
		servico = new Servico();
		for (int i = 0; i < servicos.size(); i++) {
			servico = servicos.get(i);
			if(servico.getId() == id) {
				removerServico.add(servico);
				servicoEditado = editarServico(servico);
			}
		}
		
		if(removerServico.isEmpty()) {
			System.out.println("!! Id da categoria não localizada !!");
		} else {
			servicos.removeAll(removerServico);
			servicos.add(servicoEditado);
			System.out.println("!!Categoria editada com sucesso !!");
		}
	}
	// D - delete

	
	// Codigos auxiliares
	
	public Servico preencherDadosServico() {
		Servico servico = new Servico();
		CategoriaServicoController controller = new CategoriaServicoController(); 
		servico.setId(r.nextInt(100));
		System.out.println("Digite o nome do servico: ");
		servico.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descicao do servico");
		servico.setDescricao(String.valueOf(scan.nextLine()));
		
		servico.setCategoria(selecionarCategoria());
		
		System.out.println("Digite a prioridade deste servico: baixa, media, alta ou urgente");
		String aux = scan.next();
		if (aux.equalsIgnoreCase("baixa")) {
			servico.setPrioridade(Prioridade.BAIXA);
		} else if (aux.equalsIgnoreCase("media")) {
			servico.setPrioridade(Prioridade.MEDIA);
		} else if (aux.equalsIgnoreCase("alta")) {
			servico.setPrioridade(Prioridade.ALTA);
		} else if (aux.equalsIgnoreCase("urgente")) {
			servico.setPrioridade(Prioridade.URGENTE);
		} else {
			System.out.println("!! Prioridade indefinida !!");
		}
		
		return servico;
	}
	
	
	public CategoriaServico selecionarCategoria() {
		CategoriaServicoController controller = new CategoriaServicoController();
		controller.listarCategorias();
		System.out.println("Digite o id da categoria a que esse servico deverá pertencer: ");
		long id = scan.nextLong();
		return controller.pegarCategoriaEspecifica(id);
	}
	
	
	public void exibirDadosCategoria(List<Servico> servicos) {
		if (servicos.isEmpty()) {
			System.out.println("!! Não há servicos cadastrados !!");
		} else {
			for (Servico servico : servicos) {
				System.out.println("");
				System.out.println("Id: " + servico.getId());
				System.out.println("Nome do servico: " + servico.getNome());
				System.out.println("Descricao: " + servico.getDescricao());
				System.out.println("Categoria: " + servico.getCategoria());
				System.out.println("Prioridade: " + servico.getPrioridade());
				System.out.println("");
				System.out.println("=============================================================================");
			}
			
		}
		
	}
	
	
	public Servico editarServico(Servico servico) {
		Servico servicoEditado = new Servico();
		servicoEditado.setId(servico.getId());
		System.out.println("Digite o nome do servico: ");
		servicoEditado.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descicao do servico");
		servicoEditado.setDescricao(String.valueOf(scan.nextLine()));
		
		servicoEditado.setCategoria(selecionarCategoria());
		
		System.out.println("Digite a prioridade deste servico: baixa, media, alta ou urgente");
		String aux = scan.next();
		if (aux.equalsIgnoreCase("baixa")) {
			servico.setPrioridade(Prioridade.BAIXA);
		} else if (aux.equalsIgnoreCase("media")) {
			servico.setPrioridade(Prioridade.MEDIA);
		} else if (aux.equalsIgnoreCase("alta")) {
			servico.setPrioridade(Prioridade.ALTA);
		} else if (aux.equalsIgnoreCase("urgente")) {
			servico.setPrioridade(Prioridade.URGENTE);
		} else {
			System.out.println("!! Prioridade indefinida !!");
		}
		
		return servicoEditado;
	}
	
}
