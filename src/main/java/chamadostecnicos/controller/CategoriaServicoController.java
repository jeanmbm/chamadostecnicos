package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.dao.CategoriaDao;


public class CategoriaServicoController {
	
	
	CategoriaServico categoria;
	CategoriaDao categoriaDao;
	Scanner scan = new Scanner(System.in);
	

	// C - create
	public void cadastrarCategoria() {
		categoriaDao = new CategoriaDao();
		categoria = new CategoriaServico();
		
		categoria = preencherDadosCategoria();
		
		boolean salvo = categoriaDao.salvarCategoria(categoria);
		if (salvo == true) {
			System.out.println("");
			System.out.println("!! Categoria cadastrada com suscesso !!");
			System.out.println("");
		}
	}
	
	
	// R - read
	public void listarCategorias() {
		List<CategoriaServico> categorias;
		categoriaDao = new CategoriaDao();
		
		categorias = categoriaDao.listarCategorias();
		
		exibirDadosCategoria(categorias);
	}
	
	
	// U - update
	public void editarCategoria(int id) {
		CategoriaServico categoriaEdit = new CategoriaServico();
		categoria = new CategoriaServico();
		categoriaDao = new CategoriaDao();
		
		categoriaEdit = categoriaDao.selecionarCategoriaPorId(id);
		categoria = atualizarDadosCategoria(categoriaEdit);
		
		boolean aux = categoriaDao.editarCategoria(categoria);
		if (aux) {
			System.out.println("");
			System.out.println("!! Categoria editada com suscesso !!");
			System.out.println("");
		}
	}
	
	
	// D - delete
	public void apagarCategoria (int id) {
		categoriaDao = new CategoriaDao();
		
		boolean aux = categoriaDao.deletarCategoria(id);
		if (aux == true) {
			System.out.println("");
			System.out.println("!! Categoria apagada com suscesso !!");
			System.out.println("");
		}
	}
	
	
	// Codigos auxiliares
//	public void pegarCategoriaPorId(int id, Servico servico) {
//		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
//		categorias = CategoriaServicoController.categorias;
//		
//		if (categorias.size() == 0) {
//			System.out.println("!! Não há categorias cadastradas !!");
//		} else {
//			for (int i = 0; i < categorias.size(); i++) {
//				categoria = categorias.get(i);
//				if(categoria.getId() == id) {
//					servico.setCategoria(categoria);
//				} 
//			}
//		}
//	}
	
	
	public CategoriaServico preencherDadosCategoria() {
		CategoriaServico categoria = new CategoriaServico();
		
		boolean aux = false;
		while (aux == false) {
			System.out.printf("Digite o nome da categoria: ");
			categoria.setNome(String.valueOf(scan.nextLine()));
			
			if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		System.out.printf("Digite a descrição da categoria: ");
		categoria.setDescricao(String.valueOf(scan.nextLine()));

		return categoria;
	}
	
	
	public void exibirDadosCategoria(List<CategoriaServico> categorias) {
		if (categorias.isEmpty()) {
			System.out.println("");
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
	
	
	public CategoriaServico atualizarDadosCategoria(CategoriaServico categoria) {
		CategoriaServico categoriaEditada = new CategoriaServico();
		
		boolean aux = false;
		while (aux == false) {
			System.out.printf("Digite o nome da categoria: ");
			categoriaEditada.setNome(String.valueOf(scan.nextLine()));
			
			if (categoriaEditada.getNome() == null || categoriaEditada.getNome().equals("")) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}

		System.out.printf("Digite a descrição da categoria: ");
		categoriaEditada.setDescricao(String.valueOf(scan.nextLine()));
		
		categoriaEditada.setId(categoria.getId());

		return categoriaEditada;
	}
	
}
