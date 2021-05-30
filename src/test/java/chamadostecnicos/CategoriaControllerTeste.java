package chamadostecnicos;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.Test;

import chamadostecnicos.controller.CategoriaServicoController;
import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.dao.CategoriaDao;

class CategoriaControllerTeste {
	
	CategoriaDao categoriaDao = new CategoriaDao();
	CategoriaServicoController categoriaController = new  CategoriaServicoController();
	List<CategoriaServico> categorias = categoriaDao.listarCategorias();
	
	
	@Test
	void test() {
		assertTrue(!categorias.isEmpty());
	}

}
