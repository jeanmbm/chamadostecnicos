package chamadostecnicos.view;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.CategoriaServico;

public class CategoriaView {
	
	Scanner scan = new Scanner(System.in);
	
	
	public CategoriaServico preencherDadosCategoria() {
		CategoriaServico categoria = new CategoriaServico();
		
		System.out.println("");
		System.out.println("===================================");
		System.out.println("||     CADASTRO DE CATEGORIA     ||");
		System.out.println("===================================");
		System.out.println("");
		
		System.out.printf("Digite o nome da categoria: ");
		categoria.setNome(String.valueOf(scan.nextLine()));
		
		System.out.printf("Digite a descrição da categoria: ");
		categoria.setDescricao(String.valueOf(scan.nextLine()));

		return categoria;
	}
	
	
	public void exibirDadosCategoria(List<CategoriaServico> categorias) {
		if (categorias.isEmpty()) {
			System.out.println("");
			System.out.println("!! Não há categorias cadastradas !!");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("=========================================================================================================================================");
			System.out.println("=========================================================\\ CATEGORIAS //=================================================================");
			for (CategoriaServico categoriaServico : categorias) {
				System.out.println("");
				System.out.println("Id: " + categoriaServico.getId());
				System.out.println("Nome: " + categoriaServico.getNome());
				System.out.println("Descrição: " + categoriaServico.getDescricao());
				System.out.println("");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			}
			System.out.println("=========================================================================================================================================");
			System.out.println("");
		}
	}
	
	
	public CategoriaServico atualizarDadosCategoria(int id) {
		CategoriaServico categoriaEditada = new CategoriaServico();
		
		System.out.println("");
		System.out.println("=================================");
		System.out.println("||     EDIÇÃO DE CATEGORIA     ||");
		System.out.println("=================================");
		System.out.println("");
		
		System.out.printf("Digite o nome da categoria: ");
		categoriaEditada.setNome(String.valueOf(scan.nextLine()));
		
		System.out.printf("Digite a descrição da categoria: ");
		categoriaEditada.setDescricao(String.valueOf(scan.nextLine()));
		
		categoriaEditada.setId(id);

		return categoriaEditada;
	}
	

}
