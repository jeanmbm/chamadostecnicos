import java.util.Scanner;

import chamadostecnicos.controller.CategoriaServicoController;
import chamadostecnicos.controller.ServicoController;

public class Teste {
	
	static Scanner scan = new Scanner(System.in);
	
	static CategoriaServicoController csc = new CategoriaServicoController();
	
	public static void main(String[] args) {
		
		testarCRUDCategoria();
		
		
		
		ServicoController sc = new ServicoController();
		sc.preencherDadosServico();
		sc.listarServicos();
		
	}
	
	public static void testarCRUDCategoria() {
		
		
		csc.cadastrarCategoria();
		csc.cadastrarCategoria();
		
		csc.listarCategorias();
//		
//		System.out.println("Informe o id da categoriaa ser editada: ");
//		long id = scan.nextLong();
//		csc.atualizarDadosCategoria(id);
//		
//		csc.listarCategorias();
//		
//		System.out.println("Informe o id da categoria a ser apagada: ");
//		long id2 = scan.nextLong();
//		csc.apagarCategoria(id2);
//		
//		csc.listarCategorias();
	}
	
	
	public void testarCrudServico() {
		
	}
}
