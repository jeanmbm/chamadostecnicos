package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.CategoriaServico;


public class CategoriaServicoController {

	List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
	CategoriaServico categoria;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	

	// C - create
	public void cadastrarCategoria() {
		CategoriaServicoController categoriaServicoController = new CategoriaServicoController();
		categoria = new CategoriaServico();
		categoria = categoriaServicoController.preencherDadosCategoria();
		categorias.add(categoria);
		System.out.println("!! Categoria cadastrada com suscesso !!");
		System.out.println("");
	}
	
	// R - read
	public void listarCategorias() {
		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
		categorias = this.categorias;
		exibirDadosCategoria(categorias);
	}
	
	// U - update
	public void atualizarDadosCategoria(long id) {
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
			System.out.println("!!Categoria editada com sucesso !!");
		}
	}
	
	// D - delete
	public void apagarCategoria (long id) {
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
			System.out.println("!!Categoria apagada com sucesso !!");
		}
	}
	
	
	// Codigos auxiliares
	
	public CategoriaServico preencherDadosCategoria() {
		CategoriaServico categoria = new CategoriaServico();
		System.out.println("Digite o nome da categoria:");
		categoria.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descrição da categoria:");
		categoria.setDescicao(String.valueOf(scan.nextLine()));
		categoria.setId(r.nextInt(100));
		System.out.println(categoria.getId());

		return categoria;
	}
	
	
	public void exibirDadosCategoria(List<CategoriaServico> categorias) {
		if (categorias.isEmpty()) {
			System.out.println("!! Não há categorias cadastradas !!");
		} else {
			for (CategoriaServico categoriaServico : categorias) {
				System.out.println("");
				System.out.println("Id: " + categoriaServico.getId());
				System.out.println("Nome da categoria: " + categoriaServico.getNome());
				System.out.println("Descrição da categoria: " + categoriaServico.getDescicao());
				System.out.println(" ");
				System.out.println("=============================================================================");
			}
		}
	}
	
	public CategoriaServico editarCategoria(CategoriaServico categoria) {
		CategoriaServico categoriaEditada = new CategoriaServico();
		System.out.println("Digite o nome da categoria:");
		categoriaEditada.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descrição da categoria:");
		categoriaEditada.setDescicao(String.valueOf(scan.nextLine()));
		categoriaEditada.setId(categoria.getId());
		
		return categoriaEditada;
	}
	
	
	
	public CategoriaServico pegarCategoriaEspecifica(long id) {
		CategoriaServico aux = null;
		
		for (CategoriaServico categoriaServico : categorias) {
			if (categoriaServico.getId() == id) {
				aux = categoriaServico;
			} else {
				System.out.println("!! Categoria não localizada  !!");
			}
		}
		
		if (aux == null) {
			return null;
		} else {
			return aux;
		}
	}
	
	
}
