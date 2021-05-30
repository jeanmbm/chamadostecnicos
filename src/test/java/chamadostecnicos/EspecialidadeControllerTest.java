package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.EspecialidadeController;
import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;

class EspecialidadeControllerTest {

	EspecialidadeController especialidadeController = new EspecialidadeController();

	@Test
	void salvarTest() {
		Especialidade especialidade = new Especialidade("test junit", "Uma descrição qualquer", Area.HARDWARE);
		assertTrue(especialidadeController.cadastrarEspecialidade(especialidade));
	}

	@Test
	void editarTest() {
		Especialidade especialidade = new Especialidade("test junit edit", "Uma descrição qualquer editada", Area.SOFTWARE);
		especialidade.setId(2);
		assertTrue(especialidadeController.editarEspecialidade(especialidade));
		
	}
	
	@Test
	void deletarTest() {
		
		assertTrue(especialidadeController.apagarEspecialidades(2));
		
	}
}
