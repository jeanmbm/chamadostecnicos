package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Acompanhamento;
import chamadostecnicos.model.Usuario;


public class UsuarioController {

	static List<Usuario> usuarios = new ArrayList<Usuario>();
	static List<Usuario> tecnicos = new ArrayList<Usuario>();
	Usuario usuario;
	Scanner scan = new Scanner(System.in);
	Random r = new Random(); 
	
	
	// C - create
	public void cadastrarUsuario() {
		UsuarioController controller = new UsuarioController();
		usuario = new Usuario();
		usuario = controller.preencherDadosUsuario();
		usuarios.add(usuario);
		if (usuario.isTecnico() == true) {
			tecnicos.add(usuario);
		}
		System.out.println("");
		System.out.println("!! Usuário cadastrado com sucesso !!");
		System.out.println("");
	}
	
	// R - read
	public void listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = UsuarioController.usuarios;
		exibirDadosUsuario(usuarios);
	}
	
	// U - update
	public void editarUsuario(String email, String senha) {
		List<Usuario> removerUsuario = new ArrayList<Usuario>();
		Usuario usuarioEditado = new Usuario();
		usuario = new Usuario();
		for (int i = 0; i < usuarios.size(); i++) {
			usuario = usuarios.get(i);
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				removerUsuario.add(usuario);
				usuarioEditado = editarUsuario(usuario);
			}
		}
		
		if (removerUsuario.isEmpty()) {
			System.out.println("");
			System.out.println("!! Usuario não encontrado !!");
		} else {
			usuarios.removeAll(removerUsuario);
			usuarios.add(usuarioEditado);
			System.out.println("");
			System.out.println("!! Usuario editado com sucesso !!");
		}
	}
	
	// D - delete
	public void apagarUsuario(String email, String senha) {
		List<Usuario> removerUsuario = new ArrayList<Usuario>();
		for (int i = 0; i < usuarios.size(); i++) {
			usuario = usuarios.get(i);
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				removerUsuario.add(usuario);
			}
		}
		
		if (removerUsuario.isEmpty()) {
			System.out.println("");
			System.out.println("!! Usuario não encontrado !!");
		} else {
			usuarios.removeAll(removerUsuario);
			System.out.println("");
			System.out.println("!! Usuario removido com sucesso !!");
		}
	}
	
	
	public void abrirChamado() {
		ChamadoController controller = new ChamadoController();
		AcompanhamentoController a = new AcompanhamentoController();
		
		System.out.printf("Digite o email do usuario que irá abrir o chamado: ");
		String email = scan.next();
		System.out.printf("Digite a senha: ");
		String senha = scan.next();
		
		for (int i = 0; i < usuarios.size(); i++) {
			usuario = usuarios.get(i);
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				controller.cadastrarChamado(usuario);
			}
		}
		
	}
	
	
	public void pegarTecnico(Acompanhamento acompanhamento) {
		for (Usuario usuario : tecnicos) {
			if (usuario.getEspecialidade().getArea() == acompanhamento.getChamado().getServico().getArea()) {
				acompanhamento.setTecnico(usuario);
			}
		}
	}
	
	
	// Codigos auxiliares
	public Usuario preencherDadosUsuario() {
		Usuario usuario = new Usuario();
		
		System.out.printf("Digite seu nome: ");
		usuario.setNome(String.valueOf(scan.nextLine()));
		
		System.out.printf("Digite seu telefone: ");
		usuario.setTelefone(scan.nextLine());
		
		boolean a = false;
		while (a == false) {
			System.out.printf("Digite seu cpf: ");
			String aux = scan.next(); 
			if (isCPF(aux)) {
				a = true;
				usuario.setCpf(aux);
			} else {
				System.out.println("!! CPF invalido !!");
			}
		}
		
		System.out.printf("Digite o email para efetuar login: ");
		usuario.setEmail(scan.next());
		
		System.out.printf("Digite a senha: ");
		usuario.setSenha(scan.next());
		
		System.out.print("Digite o id do departamento ao qual pertence: ");
		int id = scan.nextInt();
		DepartamentoController d = new DepartamentoController();
		d.pegarDepartamentoPorId(id, usuario);
		
		System.out.println("Você é um tecnico?");
		
		boolean b = false;
		while (b == false) {
			System.out.print(" Digite S ou N: ");
			String aux2 = scan.next();
			if (aux2.equalsIgnoreCase("S")) {
				b = true;
				usuario.setTecnico(true);
			} else if (aux2.equalsIgnoreCase("N")) {
				b = true;
				usuario.setTecnico(false);
			} else {
				System.out.print("!! Iválido !!");
			}
		}
		
		if (usuario.isTecnico() == true) {
			System.out.print("Digite o id da especialidade ao qual pertence: ");
			int id2 = scan.nextInt();
			EspecialidadeController e = new EspecialidadeController();
			e.pegarEspecialidadePorId(id2, usuario);
		} else {
			usuario.setEspecialidade(null);
		}
		
		usuario.setId(r.nextInt(100));
		
		return usuario;
		
	}
	
	private void exibirDadosUsuario(List<Usuario> usuarios) {
		if (usuarios.isEmpty()) {
			System.out.println("!! Não há usuarios cadastrados !!");
		} else {
			System.out.println("================================================================");
			System.out.println("=========================\\ USUÁRIOS //=========================");
			for (Usuario usuario : usuarios) {
				System.out.println("");
				System.out.println("Id: " + usuario.getId());
				System.out.println("Nome: " + usuario.getNome());
				System.out.println("Telefone: " + usuario.getTelefone());
				System.out.println("CPF: " + imprimeCPF(usuario.getCpf()));
				System.out.println("Email: " + usuario.getEmail());
				System.out.println("Senha: " + usuario.getSenha());
				System.out.println("Departamento: " + usuario.getDepartamento());
				System.out.println("É tecnico: " + usuario.isTecnico());
				if (usuario.isTecnico() == true) {
					System.out.println("Especialidade: " + usuario.getEspecialidade());
				}
				System.out.println("");
				System.out.println("================================================================");
			}
			System.out.println("================================================================");
			System.out.println("");
		}
	}
	
	private Usuario editarUsuario(Usuario usuario) {
		Usuario usuarioEditado = new Usuario();
		
		System.out.printf("Digite o nome: ");
		usuarioEditado.setNome(String.valueOf(scan.nextLine()));
		
		System.out.printf("Digite o telefone: ");
		usuarioEditado.setTelefone(scan.nextLine());
		
		System.out.printf("Digite a senha: ");
		usuarioEditado.setSenha(scan.next());
		
		System.out.printf("Digite o id do departamento ao qual pertence: ");
		int id = scan.nextInt();
		DepartamentoController d = new DepartamentoController();
		d.pegarDepartamentoPorId(id, usuarioEditado);
		
		System.out.print("Você é um tecnico? ");
		boolean b = false;
		while (b == false) {
			System.out.print(" Digite S ou N: ");
			String aux2 = scan.next();
			if (aux2.equalsIgnoreCase("S")) {
				b = true;
				usuarioEditado.setTecnico(true);
			} else if (aux2.equalsIgnoreCase("N")) {
				b = true;
				usuarioEditado.setTecnico(false);
			} else {
				System.out.print("!! Iválido !!");
			}
		}
		
		if (usuarioEditado.isTecnico() == true) {
			System.out.print("Digite o id da especialidade ao qual pertence: ");
			int id2 = scan.nextInt();
			EspecialidadeController e = new EspecialidadeController();
			e.pegarEspecialidadePorId(id2, usuarioEditado);
		} else {
			usuarioEditado.setEspecialidade(null);
		}
		
		usuarioEditado.setCpf(usuario.getCpf());
		usuarioEditado.setEmail(usuario.getEmail());
		usuarioEditado.setId(usuario.getId());
		
		return usuarioEditado;
				
	}
	
	
		// verificar CPF
	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
	    if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || 
	    	CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || 
	        CPF.equals("99999999999") || (CPF.length() != 11)) 
	    	return(false);

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	        try {
	        // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        // converte o i-esimo caractere do CPF em um numero:
	        // por exemplo, transforma o caractere '0' no inteiro 0
	        // (48 eh a posicao de '0' na tabela ASCII)
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	        // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);

	        // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }

	        public static String imprimeCPF(String CPF) {
	            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
	            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	        }
		
}
