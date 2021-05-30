package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.UsuarioController;
import chamadostecnicos.model.Usuario;

class UsuarioControllerTest {

	UsuarioController conttroller = new UsuarioController();

	@Test
	void cadastrarUsuarioTest() {
		
		// teste de cadastro de um novo usuario
		Usuario usuario = new Usuario("teste junit", "62999999999", "31221873024", "emailJunitTest@test.com", "junitTest", 1, false, 0);
		assertTrue(conttroller.cadastrarUsuario(usuario));
	}
	
	@Test
	void deletarUsuarioTest() {
		
		// teste de deletar de um usuario
		assertTrue(conttroller.apagarUsuario("emailJunitTest@test.com", "junitTest"));
	}

}
