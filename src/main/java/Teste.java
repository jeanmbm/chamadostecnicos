import java.util.Scanner;

import chamadostecnicos.controller.AvaliacaoController;
import chamadostecnicos.controller.CategoriaServicoController;
import chamadostecnicos.controller.DepartamentoController;
import chamadostecnicos.controller.EspecialidadeController;
import chamadostecnicos.controller.ServicoController;


public class Teste {
	
	static Scanner scan = new Scanner(System.in);
	
	static CategoriaServicoController csc = new CategoriaServicoController();
	static int id;
	
	public static void main(String[] args) {
		
	
		csc.cadastrarCategoria();
		csc.listarCategorias();
		System.out.println("Informe o id da categoria a ser editada: ");
		id = scan.nextInt();
		csc.atualizarDadosCategoria(id);
		csc.listarCategorias();
		System.out.println("Informe o id da categoria a ser apagada: ");
		id = scan.nextInt();
		csc.apagarCategoria(id);
		csc.listarCategorias();
		
	
		ServicoController sc = new ServicoController();
		sc.cadastrarServico();
		sc.listarServicos();
		System.out.println("Informe o id do servico a ser editado: ");
		id = scan.nextInt();
		sc.atualizarDadosCategoria(id);
		sc.listarServicos();
		System.out.println("Informe o id do servico a ser removido: ");
		id = scan.nextInt();
		sc.apagarServico(id);
		sc.listarServicos();

		
		DepartamentoController d = new DepartamentoController();
		d.cadastrarDepartamento();
		d.listarDepartamentos();
		System.out.println("Informe o id da departamento a ser editada: ");
		id = scan.nextInt();
		d.atualizarDepartamento(id);
		d.listarDepartamentos();
		System.out.println("Informe o id da departamento a ser apagada: ");
		id = scan.nextInt();
		d.apagarDepartamento(id);
		d.listarDepartamentos();
		
		
		EspecialidadeController e = new EspecialidadeController();
		e.cadastrarEspecialidade();
		e.listarEspecialidades();
		System.out.println("Informe o id da especialidade a ser editada: ");
		id = scan.nextInt();
		e.atualizarEspecialidade(id);
		e.listarEspecialidades();
		System.out.println("Informe o id da especialidade a ser apagada: ");
		id = scan.nextInt();
		e.apagarEspecialidades(id);
		e.listarEspecialidades();
		
		
		AvaliacaoController a = new AvaliacaoController();
		a.realizarAvaliacao();
		
	}
	
}
