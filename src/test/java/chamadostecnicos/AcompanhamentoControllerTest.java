package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.AcompanhamentoController;
import chamadostecnicos.model.Acompanhamento;

class AcompanhamentoControllerTest {
	
	AcompanhamentoController acompanhamentoController = new AcompanhamentoController();

	@Test
	void listarAcompanhamento() {
		List<Acompanhamento> acompanhamentos = new ArrayList<Acompanhamento>();
		acompanhamentos = acompanhamentoController.listarAcompanhamento();
		assertTrue(!acompanhamentos.isEmpty());
	}

}
