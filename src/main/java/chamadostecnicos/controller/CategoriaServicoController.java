package chamadostecnicos.controller;

import java.util.List;

import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.dao.CategoriaDao;


public class CategoriaServicoController {
	
	CategoriaDao categoriaDao  = new CategoriaDao();
		
	// C - create
	public boolean cadastrarCategoria(CategoriaServico categoria) {
		boolean salvo = false;
		
		if (categoria.getNome().isEmpty() || categoria.getNome() == null) {
			System.err.println("Erro! Campo nome não pode ser nulo ou vazio !!");
			salvo = false;
		} else {
			salvo = categoriaDao.salvarCategoria(categoria);
		}
		
		return salvo;
	}
	
	// R - read
	public List<CategoriaServico> listarCategorias() {
		List<CategoriaServico> categorias;
		categorias = categoriaDao.listarCategorias();
		return categorias;
	}
	
	// U - update
	public boolean editarCategoria(CategoriaServico categoria) {
		boolean editado = false; 
		
		if (categoria.getNome().isEmpty() || categoria.getNome() == null) {
			System.err.println("Erro! Campo nome não pode ser nulo ou vazio !!");
			editado = false;
		} else {
			editado = categoriaDao.editarCategoria(categoria);
		}
		
		return editado;
	}
	
	// D - delete
	public boolean apagarCategoria (int id) {
		boolean deletado = false;
		
		if (id > 0) {
			deletado = categoriaDao.deletarCategoria(id);
		} else {
			System.err.println("Erro! Id não pode ser menor ou igual a 0 !!");
			System.out.println();
			deletado = false;
		}
		
	return deletado;
	
	}
	
}
