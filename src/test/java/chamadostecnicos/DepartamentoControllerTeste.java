package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.DepartamentoController;
import chamadostecnicos.model.Departamento;

class DepartamentoControllerTeste {
	
	DepartamentoController departamentoController = new DepartamentoController();
	

	
	@Test
	void salvarTeste() {

		// criação de um departamento pra ser usado no teste de delete
		Departamento departamento = new Departamento("Departamento para teste unitario", "Teste unitário");
		assertTrue(departamentoController.cadastrarDepartamento(departamento));
	}
	
	
	@Test
	void deletarDepartamentoTeste() {
		
		// testa o delete de departamento
		assertTrue(departamentoController.apagarDepartamento(3)); 
		
	}

}
