package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Usuario;


public class UsuarioController {

	List<Usuario> usuarios = new ArrayList<Usuario>();
	Usuario usuario;
	Scanner scan = new Scanner(System.in);
	Random r = new Random(); 
	
	
	// C - create
	public void cadastrarUsuario() {
		UsuarioController controller = new UsuarioController();
		usuario = new Usuario();
		usuario = controller.preencherDadosUsuario();
		usuarios.add(usuario);
		System.out.println("");
		System.out.println("!! Usuário cadastrado com sucesso !!");
		System.out.println("");
	}
	
	// R - read
	public void listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = this.usuarios;
		exibirDadosUsuario(usuarios);
	}
	
	// U - update
	public void alterarDadosUsuario(int id) {
		List<Usuario> removerUsuario = new ArrayList<Usuario>();
		Usuario usuarioEditado = new Usuario();
		usuario = new Usuario();
		for (int i = 0; i < usuarios.size(); i++) {
			usuario = usuarios.get(i);
			if (usuario.getId() == id) {
				removerUsuario.add(usuario);
				usuarioEditado = editarCategoria(usuario);
			}
		}
		if (removerUsuario.isEmpty()) {
			System.out.println("!! Id do usuario não encontrado !!");
		} else {
			usuarios.removeAll(removerUsuario);
			usuarios.add(usuarioEditado);
			System.out.println("!! Usuario editado com sucesso !!");
		}
	}
	
	// D - delete
	public void apagarUsuario(int id) {
		List<Usuario> removerUsuario = new ArrayList<Usuario>();
		for (Usuario usuario : removerUsuario) {
			if (usuario.getId() == id) {
				removerUsuario.add(usuario);
			}
		}
		
		if (removerUsuario.isEmpty()) {
			System.out.println("!! Id do usuario não encontrado !!");
		} else {
			usuarios.removeAll(removerUsuario);
			System.out.println("!! Usuario removido com sucesso !!");
		}
	}

	
	// Codigos auxiliares
	private Usuario preencherDadosUsuario() {
		
	}
	
	private void exibirDadosUsuario(List<Usuario> usuarios) {
		if (usuarios.isEmpty()) {
			System.out.println("!! Não há usuarios cadastrados !!");
		} else {
			System.out.println("================================================================");
			System.out.println("=========================\\ USUÁRIOS //=========================");
			for (Usuario usuario : usuarios) {
				System.out.println("");
				System.out.println("");
				System.out.println("================================================================");
				
			}
		}
	}
	
	private Usuario editarCategoria(Usuario usuario) {
		Usuario usuarioEditado = new Usuario();
				
	}
	
}
