package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.ChamadoController;
import chamadostecnicos.model.Chamado;

class ChamadoControllerTest {

	ChamadoController chamadoController = new ChamadoController();

	@Test
	void listarChamado() {
		List<Chamado> chamados = new ArrayList<Chamado>();
		chamados = chamadoController.listarChamado();
		assertTrue(!chamados.isEmpty());
	}

}
