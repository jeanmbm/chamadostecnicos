package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.ServicoController;
import chamadostecnicos.model.Area;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;

class ServicoControllerTeste {
	
	ServicoController servicoController = new ServicoController();

	
	@Test
	void cadastrarServicoTeste() {
		Servico servico = new Servico("nome teste", "qualquer", Prioridade.BAIXA, 1, Area.HARDWARE);
		assertTrue(servicoController.cadastrarServico(servico));
	}
	
	@Test
	void editarServicoTeste() {
		Servico servico = new Servico("nome teste editado", "qualquer editado", Prioridade.ALTA, 1, Area.SOFTWARE);
		servico.setId(2);
		assertTrue(servicoController.editarServico(servico));
	}
	
	@Test
	void deletarServicoTest() {
		
		// teste de deletar de um usuario
		assertTrue(servicoController.apagarServico(2));
	}

}
