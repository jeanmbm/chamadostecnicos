package chamadostecnicos.controller;

import java.util.InputMismatchException;
import java.util.List;

import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Usuario;
import chamadostecnicos.model.dao.UsuarioDao;


public class UsuarioController {

	UsuarioDao usuarioDao = new UsuarioDao();
	
	// C - create
	public boolean cadastrarUsuario(Usuario usuario) {
		boolean salvo = false;
		
		boolean validado = validarUsuario(usuario);
		if (validado) {
			salvo = usuarioDao.salvarUsusario(usuario);
		}
		
		return salvo;
	}
	
	
	// R - read
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios;
		usuarios = usuarioDao.listarUsuarios();
		
		if (usuarios.isEmpty()) {
			System.out.println("");
			System.out.println("!! Não há usuários cadastrados !!");
			System.out.println("");
		}
		
		return usuarios;
	}
	
	
	// U - update
	public boolean editarUsuario(Usuario usuario, String email, String senha) {
		boolean editado = false;
		boolean deletado = false;
		
		if (email.equals("") || email == null || email.isEmpty()) {
			System.out.println("");
			System.err.println("Erro! Campo email não pode ser nulo ou vazio !!");
			System.out.println("");
			editado = false;
			
		} else if (senha.equals("") || senha == null || senha.isEmpty()) {
			System.out.println("");
			System.err.println("Erro! Campo senha não pode ser nulo ou vazio !!");
			System.out.println("");
			editado = false;
			
		} else {
			boolean validado = validarUsuario(usuario);
			if (validado) {
				deletado = usuarioDao.deletarUsuario(email, senha);
				if (deletado) {
					editado = usuarioDao.salvarUsusario(usuario);
				}
			}
		}
		
		return editado;
	}
	
	
	// D - delete
	public boolean apagarUsuario(String email, String senha) {
		boolean deletado = false;
				
		if (email.equals("") || email == null || email.isEmpty()) {
			System.out.println("");
			System.err.println("Erro! Campo email não pode ser nulo ou vazio !!");
			System.out.println("");
			deletado = false;
			
		} else if (senha.equals("") || senha == null || senha.isEmpty()) {
			System.out.println("");
			System.err.println("Erro! Campo senha não pode ser nulo ou vazio !!");
			System.out.println("");
			deletado = false;
			
		} else {
			deletado = usuarioDao.deletarUsuario(email, senha);
		}
		
		return deletado;
	}
	
	
	// Abrir chamado é feito pelo usuario
	public boolean abrirChamado(String email, String senha, Chamado chamado) {
		Usuario usuario = new Usuario();
		ChamadoController chamadoController = new ChamadoController(); 
		boolean aberto = false;
		
		if (email.equals("") || email == null || email.isEmpty()) {
			System.out.println("");
			System.err.println("Erro! Campo email não pode ser nulo ou vazio !!");
			System.out.println("");
			aberto = false;
			
		} else if (senha.equals("") || senha == null || senha.isEmpty()) {
			System.out.println("");
			System.err.println("Erro! Campo senha não pode ser nulo ou vazio !!");
			System.out.println("");
			aberto = false;
			
		} else {
			usuario = usuarioDao.selecionarUsuarioPorEmailESenha(email, senha);
			chamado.setIdUsuario(usuario.getId());
		
			aberto = chamadoController.cadastrarChamado(chamado);
		}
		
		return aberto;
	}
	

	private boolean validarUsuario(Usuario usuario) {
		boolean validado = false;
		
		if ( !(usuario.getNome().isEmpty()) || !(usuario.getNome() != null) || !(usuario.getNome().equalsIgnoreCase("")) ) {
			
			if ( !(usuario.getTelefone().isEmpty()) || !(usuario.getTelefone() != null) || !(usuario.getTelefone().equalsIgnoreCase("")) ) {
				
				if (isCPF(usuario.getCpf())) {
					
					if ( !(usuario.getEmail().isEmpty()) || !(usuario.getEmail() != null) || !(usuario.getEmail().equalsIgnoreCase(""))) {
						
						if ( !(usuario.getSenha().isEmpty()) || !(usuario.getSenha() != null) || !(usuario.getSenha().equalsIgnoreCase(""))){
							
							if (usuario.getIdDepartamento() > 0) {
								
								if (usuario.isTecnico()) {
									
									if (usuario.getIdEspecialidade() > 0) {
										validado = true;
										
									} else {
										System.out.println("");
										System.err.println("Erro! Campo id especialidade não pode ser menor ou igual a 0 !!");
										System.out.println("");
									}

								} else {
									validado = true;
								}
								
							} else {
								System.out.println("");
								System.err.println("Erro! Campo id departamento não pode ser menor ou igual a 0 !!");
								System.out.println("");
							}
							
						} else {
							System.out.println("");
							System.err.println("Erro! Campo senha não pode ser nulo ou vazio !!");
							System.out.println("");
						}
						
					} else {
						System.out.println("");
						System.err.println("Erro! Campo email não pode ser nulo ou vazio !!");
						System.out.println("");
					}
					
				} else {
					System.out.println("");
					System.err.println("Erro! CPF inválido !!");
					System.out.println("");
				}
				
			} else {
				System.out.println("");
				System.err.println("Erro! Campo telefone não pode ser nulo ou vazio !!");
				System.out.println("");
			}
			
		} else {
			System.out.println("");
			System.err.println("Erro! Nome não pode ser nulo ou vazio !!");
			System.out.println("");
		}
		
		return validado;
	}
	
	
	// verificar CPF
	private static boolean isCPF(String CPF) {
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
		
}
