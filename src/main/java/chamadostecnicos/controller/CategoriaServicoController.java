package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.Servico;


public class CategoriaServicoController {
	

	static List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
	CategoriaServico categoria;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	

	// C - create
	public void cadastrarCategoria() {
		CategoriaServicoController controller = new CategoriaServicoController();
		
		CategoriaServico categoria1 = new CategoriaServico(r.nextInt(100), "Categoria teste", "Descrição teste");
		categorias.add(categoria1);
		
		categoria = new CategoriaServico();
		categoria = controller.preencherDadosCategoria();
		categorias.add(categoria);
		System.out.println("");
		System.out.println("!! Categoria cadastrada com suscesso !!");
		System.out.println("");
	}
	
	// R - read
	public void listarCategorias() {
		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
		categorias = CategoriaServicoController.categorias;
		exibirDadosCategoria(categorias);
	}
	
	// U - update
	public void atualizarDadosCategoria(int id) {
		List<CategoriaServico> removerCategoria = new ArrayList<CategoriaServico>();
		CategoriaServico categoriaEditada = new CategoriaServico();
		categoria = new CategoriaServico();
		for (int i = 0; i < categorias.size(); i++) {
			categoria = categorias.get(i);
			if(categoria.getId() == id) {
				removerCategoria.add(categoria);
				categoriaEditada = editarCategoria(categoria);
			}
		}
		
		if(removerCategoria.isEmpty()) {
			System.out.println("!! Id da categoria não localizada !!");
		} else {
			categorias.removeAll(removerCategoria);
			categorias.add(categoriaEditada);
			System.out.println("!! Categoria editada com sucesso !!");
		}
	}
	
	// D - delete
	public void apagarCategoria (int id) {
		List<CategoriaServico> removerCategoria = new ArrayList<CategoriaServico>();
		for (CategoriaServico categoria : categorias) {
			if(categoria.getId() == id) {
				removerCategoria.add(categoria);	
			}
		}

		if(removerCategoria.isEmpty()) {
			System.out.println("!! Id da categoria não localizada !!");
		} else {
			categorias.removeAll(removerCategoria);
			System.out.println("!! Categoria apagada com sucesso !!");
		}
	}
	
	
	// Codigos auxiliares
	public void pegarCategoriaPorId(int id, Servico servico) {
		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
		categorias = CategoriaServicoController.categorias;
		
		if (categorias.size() == 0) {
			System.out.println("!! Não há categorias cadastradas !!");
		} else {
			for (int i = 0; i < categorias.size(); i++) {
				categoria = categorias.get(i);
				if(categoria.getId() == id) {
					servico.setCategoria(categoria);
				} else {
					System.out.println("!! Categoria não encontrada !!");
				}
			}
		}
	}
	
	
	public CategoriaServico preencherDadosCategoria() {
		CategoriaServico categoria = new CategoriaServico();
		
		System.out.printf("Digite o nome da categoria: ");
		categoria.setNome(String.valueOf(scan.nextLine()));
		
		System.out.printf("Digite a descrição da categoria: ");
		categoria.setDescricao(String.valueOf(scan.nextLine()));
		
		categoria.setId(r.nextInt(100));

		return categoria;
	}
	
	
	public void exibirDadosCategoria(List<CategoriaServico> categorias) {
		if (categorias.isEmpty()) {
			System.out.println("!! Não há categorias cadastradas !!");
		} else {
			System.out.println("");
			System.out.println("=================================================================");
			System.out.println("=========================\\ CATEGORIAS //=========================");
			for (CategoriaServico categoriaServico : categorias) {
				System.out.println("");
				System.out.println("Id: " + categoriaServico.getId());
				System.out.println("Nome: " + categoriaServico.getNome());
				System.out.println("Descrição: " + categoriaServico.getDescricao());
				System.out.println(" ");
				System.out.println("==================================================================");
			}
			System.out.println("==================================================================");
			System.out.println("");
		}
	}
	
	
	public CategoriaServico editarCategoria(CategoriaServico categoria) {
		CategoriaServico categoriaEditada = new CategoriaServico();
		
		System.out.println("Digite o nome da categoria:");
		categoriaEditada.setNome(String.valueOf(scan.nextLine()));
		
		System.out.println("Digite a descrição da categoria:");
		categoriaEditada.setDescricao(String.valueOf(scan.nextLine()));
		
		categoriaEditada.setId(categoria.getId());
		
		return categoriaEditada;
	}
	
}
