import java.util.Scanner;

import chamadostecnicos.controller.AcompanhamentoController;
import chamadostecnicos.controller.CategoriaServicoController;
import chamadostecnicos.controller.ChamadoController;
import chamadostecnicos.controller.DepartamentoController;
import chamadostecnicos.controller.EspecialidadeController;
import chamadostecnicos.controller.ServicoController;
import chamadostecnicos.controller.UsuarioController;

// finalizar acompanhamento incompleto
public class Teste {
	
	static Scanner scan = new Scanner(System.in);
	static int id;
	static String email, senha;
	
	
	public static void main(String[] args) {
		
		System.out.println("~~~~~~~~ TESTE CATEGORIA ~~~~~~~~");
		System.out.println("");
		
		testarCatgoria();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~ TESTE SERVICO ~~~~~~~~");
		System.out.println("");
		
		testarServico();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~ TESTE DEPARTAMENTO ~~~~~~~~");
		System.out.println("");
		
		testarDepartamento();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~ TESTE ESPECIALIDADE ~~~~~~~~");
		System.out.println("");
		
		testarEspecialidade();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~ TESTE USUARIO ~~~~~~~~");
		System.out.println("");
		
		testarUsuario();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~ TESTE CHAMADO ~~~~~~~~");
		System.out.println("");
		
		testarChamado();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~ TESTE ACOMPANHAMENTO ~~~~~~~~");
		System.out.println("");
		
		testarAcompanhameto();
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
	
	public static void testarCatgoria() {
		CategoriaServicoController csc = new CategoriaServicoController();
		csc.cadastrarCategoria();
		csc.listarCategorias();
		System.out.printf("Informe o id da categoria a ser editada: ");
		id = scan.nextInt();
		csc.atualizarDadosCategoria(id);
		csc.listarCategorias();
		System.out.printf("Informe o id da categoria a ser apagada: ");
		id = scan.nextInt();
		csc.apagarCategoria(id);
		csc.listarCategorias();
	}
	
	public static void testarServico() {
		ServicoController sc = new ServicoController();
		sc.cadastrarServico();
		sc.listarServicos();
		System.out.printf("Informe o id do servico a ser editado: ");
		id = scan.nextInt();
		sc.atualizarDadosCategoria(id);
		sc.listarServicos();
		System.out.printf("Informe o id do servico a ser removido: ");
		id = scan.nextInt();
		sc.apagarServico(id);
		sc.listarServicos();
	}
	
	public static void testarDepartamento() {
		DepartamentoController d = new DepartamentoController();
		d.cadastrarDepartamento();
		d.listarDepartamentos();
		System.out.printf("Informe o id da departamento a ser editada: ");
		id = scan.nextInt();
		d.atualizarDepartamento(id);
		d.listarDepartamentos();
		System.out.printf("Informe o id da departamento a ser apagada: ");
		id = scan.nextInt();
		d.apagarDepartamento(id);
		d.listarDepartamentos();
	}
	
	public static void testarEspecialidade() {
		EspecialidadeController e = new EspecialidadeController();
		e.cadastrarEspecialidade();
		e.listarEspecialidades();
		System.out.printf("Informe o id da especialidade a ser editada: ");
		id = scan.nextInt();
		e.atualizarEspecialidade(id);
		e.listarEspecialidades();
		System.out.printf("Informe o id da especialidade a ser apagada: ");
		id = scan.nextInt();
		e.apagarEspecialidades(id);
		e.listarEspecialidades();
	}
	
	public static void testarUsuario() {
		UsuarioController u = new UsuarioController();
		u.cadastrarUsuario();
		u.listarUsuarios();
		System.out.printf("Digite o email do usuario a ser editado: ");
		email = scan.next();
		System.out.printf("Digite a senha: ");
		senha = scan.next();
		u.editarUsuario(email, senha);
		u.listarUsuarios();
		System.out.printf("Digite o email do usuario a ser apagado: ");
		email = scan.next();
		System.out.printf("Digite a senha: ");
		senha = scan.next();
		u.apagarUsuario(email, senha);
		u.listarUsuarios();
	}
	
	
	public static void testarChamado() {
	    UsuarioController u = new UsuarioController();
	    ChamadoController c = new ChamadoController();
	    u.abrirChamado();
	    c.listarChamado();
	    System.out.printf("Informe o id do chamado a ser editado o status: ");
		id = scan.nextInt();
	    c.mudarStatusChamado(id);
	    c.listarChamado();
	}
	
	
	// finalizar acompanhamento imcompleto
	public static void testarAcompanhameto() {
		AcompanhamentoController a = new AcompanhamentoController();
		a.gerarAcompanhamento();
		a.exibirAcompanhamento();
		//a.finalizarAcompanhamento();
	}
	
}
