import java.util.Scanner;

import chamadostecnicos.controller.AcompanhamentoController;
import chamadostecnicos.controller.CategoriaServicoController;
import chamadostecnicos.controller.ChamadoController;
import chamadostecnicos.controller.DepartamentoController;
import chamadostecnicos.controller.EspecialidadeController;
import chamadostecnicos.controller.ServicoController;
import chamadostecnicos.controller.UsuarioController;
import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Departamento;
import chamadostecnicos.model.Especialidade;
import chamadostecnicos.model.Servico;
import chamadostecnicos.model.Usuario;
import chamadostecnicos.model.dao.ChamadoDao;
import chamadostecnicos.view.CategoriaView;
import chamadostecnicos.view.ChamadoView;
import chamadostecnicos.view.DepartamentoView;
import chamadostecnicos.view.EspecialidadeView;
import chamadostecnicos.view.ServicoView;
import chamadostecnicos.view.UsuarioView;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static int id;
	static String email, senha;
	static boolean finalizado;
	static ChamadoDao chamadoDao = new ChamadoDao();
	static UsuarioController usuarioController = new UsuarioController();
	static UsuarioView usuarioView = new UsuarioView();
	static Usuario usuario = new Usuario();
	static ChamadoController chamadoController = new ChamadoController();
	static ChamadoView chamadoView = new ChamadoView();
	static Chamado chamado = new Chamado();
	static AcompanhamentoController acompanhamentoController = new AcompanhamentoController();
	
	
	public static void main(String[] args) {
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!  Neste programa será testado as funções 'principais', que são de usuario, chamado e acompanhamento  !!!");
		System.out.println("!!!                 Primeiramente, insira as informações no banco atravez do script sql                 !!!");
		System.out.println("!!!             Quando for pedido algum id, utilize o numero 1, que é o inserido pelo banco             !!!");
		System.out.println("!!!                                    Teste as funções que desejar                                     !!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("");
		
		
		boolean aux1 = true;
		while (aux1) {
			System.out.println("");
			System.out.println("==================================");
			System.out.println("||             MENU             ||");
			System.out.println("==================================");
			System.out.println("");
			System.out.println("Informe qual ação que deseja realizar:");
//			System.out.println("1 - Cadastrar usuario");
//			System.out.println("2 - Listar usuarios");
//			System.out.println("4 - Deletar usuario");ntln("3 - Editar usuario");
//			System.out.pri
//			System.out.println("5 - Abrir chamado");
//			System.out.println("6 - Listar chamados");
			System.out.println("7 - Abrir acompanhamento");
//			System.out.println("8 - Finalizar acompanhamento (tecnico)");
//			System.out.println("9 - Finalizar acompanhamento (usuario)");
			System.out.println("10 - Fechar acompanhamento por completo");
			System.out.println("0 - Sair");
			System.out.println("");
			
			System.out.print("Digite: ");
			int aux2 = scan.nextInt();
			System.out.println("");
			
			
			switch (aux2) {
				case 1:
					scan.nextLine();
					usuario = usuarioView.preencherDadosUsuario(true);
					boolean salvoUsuario = usuarioController.cadastrarUsuario(usuario);
					if(salvoUsuario == true) {
						System.out.println("");
						System.out.println("\n !! Usuário cadastrado com sucesso !! \n");
						System.out.println("");
					}
					break;
				
					
				case 2:
					usuarioView.exibirDadosUsuarios(usuarioController.listarUsuarios());
					break;
				
					
				case 3: 
					System.out.println("");
					System.out.printf("Digite o email do usuario a ser editado: ");
					email = scan.next();
					System.out.printf("Digite a senha: ");
					senha = scan.next();
					
					usuario = usuarioView.preencherDadosUsuario(false);
					boolean editadoUsuario = usuarioController.editarUsuario(usuario, email, senha);
					if (editadoUsuario) {
						System.out.println("");
						System.out.println("!! Usuario editado com sucesso !!");
						System.out.println("");
					}
					break;
				
					
				case 4: 
					System.out.println("");
					System.out.printf("Digite o email do usuario a ser apagado: ");
					email = scan.next();
					System.out.printf("Digite a senha: ");
					senha = scan.next();
					boolean deletadoUsuario = usuarioController.apagarUsuario(email, senha);
					if (deletadoUsuario) {
						System.out.println("");
						System.out.println("!! Usuario deletado com sucesso !!");
						System.out.println("");
					}
					break;
			
					
				case 5:
				    System.out.printf("Digite o email do usuario que irá abrir o chamado: ");
					String email = scan.next();
					System.out.printf("Digite a senha: ");
					String senha = scan.next();
					System.out.println("");
					
					chamado = chamadoView.preencherChamado();
					
				    boolean salvoChamado = usuarioController.abrirChamado(email, senha, chamado);
				    if(salvoChamado) {
						System.out.println("");
						System.out.println("!! Chamado aberto com sucesso. Está em análise !!");
						System.out.println("");
					}
					break;
			
					
				case 6:
					 chamadoView.exibirChamados(chamadoController.listarChamado());
					break;
			
					
				case 7:
					System.out.println("Digite o id do chamado para abrir um acompanhamento: ");
					id = scan.nextInt();
					acompanhamentoController.gerarAcompanhamento(id);
					break;
			
					
				case 8:
					finalizado = false;
					System.out.print("Técnico, deseja finalizar o acompanhamento? (S ou N): ");
					String opcao = scan.next();
					if (opcao.equalsIgnoreCase("S")) {
						System.out.print("Digite o id do chamado a ser finalizado: ");
						finalizado = acompanhamentoController.finalizarAcompanhamentoTecnico(id = scan.nextInt());
					} 
					
					if (finalizado) {
						System.out.println("");
						System.out.println("!! Acompanhametno finalizado por parte do técnico !!");
						System.out.println("");
					}
					
					break;
			
					
				case 9:
					finalizado = false;
					System.out.print("Usuario, deseja finalizar o acompanhamento? (S ou N): ");
					String aux = scan.next();
					if (aux.equalsIgnoreCase("S")) {
						System.out.println("Digite o id do chamado a ser finalizado: ");
						finalizado = acompanhamentoController.finalizarAcompanhamentoUsuario(id = scan.nextInt());
					} 
					
					if (finalizado) {
						System.out.println("");
						System.out.print("!! Acompanhametno finalizado por parte do usuario !!");
						System.out.println("");
					}
					
					break;
			
				case 10:
					
					break;
			
			
			
				default:
					System.out.println("");
					System.out.println("Obrigado por testar!! \n"
									 + "Encerrando ações...");
					aux1 = false;
					break;
			}
		}
		
	}
	
	
	public static void testarCatgoria() {
		CategoriaServicoController csc = new CategoriaServicoController();
		CategoriaView view = new CategoriaView();
		CategoriaServico categoria = new CategoriaServico();
		
		
		categoria = view.preencherDadosCategoria();
		boolean salvo = csc.cadastrarCategoria(categoria);
		if (salvo) {
			System.out.println("");
			System.out.println("!! Categoria cadastrada com suscesso !!");
			System.out.println("");
		} 
		
		
		view.exibirDadosCategoria(csc.listarCategorias());
		
		
		System.out.printf("Informe o id da categoria a ser editada: ");
		id = scan.nextInt();
		categoria = view.atualizarDadosCategoria(id);
		boolean editada = csc.editarCategoria(categoria);
		if (editada) {
			System.out.println("");
			System.out.println("!! Categoria editada com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosCategoria(csc.listarCategorias());
		
		
		System.out.println("");
		System.out.printf("Informe o id da categoria a ser apagada: ");
		id = scan.nextInt();
		boolean deletada = csc.apagarCategoria(id);
		if (deletada) {
			System.out.println("");
			System.out.println("!! Categoria apagada com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosCategoria(csc.listarCategorias());

	}
	
	
	
	public static void testarServico() {
		ServicoController sc = new ServicoController();
		ServicoView view = new ServicoView();
		Servico servico = new Servico();
		
		
		servico = view.preencherDadosServico();
		boolean salvo = sc.cadastrarServico(servico);
		if (salvo) {
			System.out.println("");
			System.out.println("!! Servico cadastrado com sucesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosCategoria(sc.listarServicos());
		
		
		System.out.printf("Informe o id do servico a ser editado: ");
		id = scan.nextInt();
		servico = view.atualizarDadosCategoria(id);
		boolean editado = sc.editarServico(servico);
		if (editado) {
			System.out.println("");
			System.out.println("!! Servico editado com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosCategoria(sc.listarServicos());

		
		System.out.printf("Informe o id do servico a ser removido: ");
		id = scan.nextInt();
		boolean deletado = sc.apagarServico(id);
		if (deletado) {
			System.out.println("");
			System.out.println("!! Servico deletado com suscesso !!");
			System.out.println("");
		}
		
		view.exibirDadosCategoria(sc.listarServicos());

	}
	
	
	
	public static void testarDepartamento() {
		DepartamentoController d = new DepartamentoController();
		DepartamentoView view = new DepartamentoView();
		Departamento departamento = new Departamento();
		
		
		departamento = view.preencherDadosDepartamento();
		boolean salvo = d.cadastrarDepartamento(departamento);
		if (salvo) {
			System.out.println("");
			System.out.println("!! Departamento cadastrado com sucesso!!");
			System.out.println("");
		}
		
		
		view.exibirDadosDepartamentos(d.listarDepartamentos());
		
		
		System.out.printf("Informe o id do departamento a ser editado: ");
		id = scan.nextInt();
		departamento = view.atualizarDadosDepartamento(id);
		boolean editado = d.editarDepartamento(departamento);
		if (editado) {
			System.out.println("");
			System.out.println("!! Departamento apagado com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosDepartamentos(d.listarDepartamentos());
		
		
		System.out.printf("Informe o id da departamento a ser apagada: ");
		id = scan.nextInt();
		boolean deletado = d.apagarDepartamento(id);
		if (deletado) {
			System.out.println("");
			System.out.println("!! Departamento apagado com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosDepartamentos(d.listarDepartamentos());
	}
	
	
	
	public static void testarEspecialidade() {
		EspecialidadeController controller = new EspecialidadeController();
		EspecialidadeView view = new EspecialidadeView();
		Especialidade especialidade = new Especialidade();
		
		especialidade = view.preencherDadosEspecialidade();
		boolean salvo =  controller.cadastrarEspecialidade(especialidade);
		if (salvo) {
			System.out.println("");
			System.out.println("!! Especialidade cadastrada com sucesso!!");
			System.out.println("");
		}
		
		
		view.exibirDadosEspecialidade(controller.listarEspecialidades());
		
		
		System.out.printf("Informe o id da especialidade a ser editada: ");
		id = scan.nextInt();
		especialidade = view.atualizarDadosEspecialidade(id);
		boolean editado = controller.editarEspecialidade(especialidade);
		if (editado) {
			System.out.println("");
			System.out.println("!! Especialidade editada com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosEspecialidade(controller.listarEspecialidades());
		
		
		System.out.printf("Informe o id da especialidade a ser apagada: ");
		id = scan.nextInt();
		boolean deletado = controller.apagarEspecialidades(id);
		if (deletado) {
			System.out.println("");
			System.out.println("!! Especialidade apagada com suscesso !!");
			System.out.println("");
		}
		
		
		view.exibirDadosEspecialidade(controller.listarEspecialidades());

	}
		
	// finalizar acompanhamento imcompleto
	public static void testarAcompanhameto() {
		
		
		acompanhamentoController.exibirAcompanhamento();
		//a.finalizarAcompanhamento();
	}
	
}
