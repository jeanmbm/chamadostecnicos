package chamadostecnicos.view;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Usuario;

public class UsuarioView {
	
	Scanner scan = new Scanner(System.in);
	
	public Usuario preencherDadosUsuario(boolean cadastro) {
		Usuario usuario = new Usuario();
		boolean aux = false;
		
		if (cadastro) {
			System.out.println("");
			System.out.println("===============================");
			System.out.println("||    CADASTRO DE USUARIO    ||");
			System.out.println("===============================");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("===============================");
			System.out.println("||     EDIÇÃO DE USUARIO     ||");
			System.out.println("===============================");
			System.out.println("");
		}
		
		
		System.out.printf("Digite seu nome: ");
		usuario.setNome(String.valueOf(scan.nextLine()));

		System.out.printf("Digite seu telefone (somente os números): ");
		usuario.setTelefone(String.valueOf(scan.nextLine()));

		System.out.printf("Digite seu cpf (somente os números): ");
		usuario.setCpf(String.valueOf(scan.nextLine())); 
		
		System.out.printf("Digite seu email: ");
		usuario.setEmail(String.valueOf(scan.nextLine()));

		System.out.printf("Crie sua senha: ");
		usuario.setSenha(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite o id do departamento ao qual pertence: ");
		usuario.setIdDepartamento(scan.nextInt());
		
		System.out.println("Você é um tecnico?");
		
		aux = false;
		while (aux == false) {
			System.out.print(" Digite S ou N: ");
			String isTecnico = scan.next();
			
			if (isTecnico.equalsIgnoreCase("S")) {
				aux = true;
				usuario.setTecnico(true);
			} else if (isTecnico.equalsIgnoreCase("N")) {
				aux = true;
				usuario.setTecnico(false);
			} else {
				System.out.print("!! Iválido !!");
				aux = false;
			}
		}
		
		if (usuario.isTecnico() == true) {
			System.out.print("Digite o id da especialidade ao qual pertence: ");
			usuario.setIdEspecialidade(scan.nextInt());
		} else {
			usuario.setIdEspecialidade(0);
		}
		
		return usuario;
		
	}
	
	public void exibirDadosUsuarios(List<Usuario> usuarios) {
//		String telefone = "62999999999";
//		System.out.println(imprimeTelefone(telefone));
		
		if (!usuarios.isEmpty()) {
			System.out.println("");
			System.out.println("=========================================================================================================================================");
			System.out.println("==========================================================\\ USUÁRIOS //==================================================================");
			for (Usuario usuario : usuarios) {
				System.out.println("");
				System.out.println("Id: " + usuario.getId());
				System.out.println("Nome: " + usuario.getNome());
				System.out.println("Telefone: " + usuario.getTelefone());
				System.out.println("CPF: " + imprimeCPF(usuario.getCpf()));
				System.out.println("Email: " + usuario.getEmail());
				System.out.println("Senha: " + usuario.getSenha());
				System.out.println("Departamento: " + usuario.getDepartamento().toString());
				System.out.println("É tecnico: " + usuario.isTecnico());
				if (usuario.isTecnico() == true) {
					System.out.println("Especialidade: " + usuario.getEspecialidade().toString());
				}
				System.out.println("");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			}
			System.out.println("=========================================================================================================================================");
			System.out.println("");
		}
		
	}
		
	public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
        CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
	
//	public static String imprimeTelefone(String telefone) {
//        return("(" + telefone.substring(0, 2) + ") " + telefone.substring(3, 7) + "-" +
//        		telefone.substring(8, 11));
//    }
}
