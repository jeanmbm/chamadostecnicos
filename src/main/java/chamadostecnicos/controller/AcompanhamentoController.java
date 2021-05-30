package chamadostecnicos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Acompanhamento;
import chamadostecnicos.model.Avaliacao;
import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.Usuario;
import chamadostecnicos.model.dao.AcompanhamentoDao;
import chamadostecnicos.model.dao.ChamadoDao;
import chamadostecnicos.model.dao.UsuarioDao;


public class AcompanhamentoController {
	
	Acompanhamento acompanhamento;
	Avaliacao avaliacao;
	ChamadoDao chamadoDao;
	UsuarioDao usuarioDao;
	Usuario usuario;
	Chamado chamado;
	AcompanhamentoDao acompanhamentoDao;
	Scanner scan = new Scanner(System.in);

	
	public boolean gerarAcompanhamento(int id) {
		chamadoDao = new ChamadoDao();
		usuarioDao = new UsuarioDao();
		acompanhamentoDao = new AcompanhamentoDao();
		usuario = new Usuario();
		chamado = new Chamado();
		boolean gerado = false;
		
		if (id > 0) {
			chamadoDao = new ChamadoDao(); 
			
			chamado = chamadoDao.selecionarChamadoPorId(id);
			
			if (chamado == null) {
				System.out.println("");
				System.err.println("!! Chamado não encontrado !!");
				System.out.println("");
				
			} else {
				String area = chamado.getServico().getArea().getDescricao();
				usuario = usuarioDao.selecioanarUsuarioTecnico(area);
				gerado = acompanhamentoDao.salvarAcompanhamento(chamado.getId(), usuario.getId());
			}
			
		} else {
			System.out.println("");
			System.err.println("!! Id não pode ser menor ou igual a 0 !!");
			System.out.println("");
		}
		
		return gerado;
		
	}
	
	
	public boolean finalizarAcompanhamentoUsuario(int id) {
		acompanhamentoDao = new AcompanhamentoDao();
		boolean finalizado = false;
		
		if (id > 0) {
			finalizado = acompanhamentoDao.finalizarAcompanhamentoUsuario(id);
		} else {
			System.out.println("");
			System.err.println("!! Id não pode ser menor ou igual a 0 !!");
			System.out.println("");
		}
		
		return finalizado;	
	}
	
	public boolean finalizarAcompanhamentoTecnico(int id) {
		acompanhamentoDao = new AcompanhamentoDao();
		boolean finalizado = false;
		
		if (id > 0) {
			finalizado = acompanhamentoDao.finalizarAcompanhamentoTecnico(id);
		} else {
			System.out.println("");
			System.err.println("!! Id não pode ser menor ou igual a 0 !!");
			System.out.println("");
		}
		
		return finalizado;
	}
	
	
	public List<Acompanhamento> listarAcompanhamento() {
		acompanhamentoDao = new AcompanhamentoDao();
		List<Acompanhamento> acompanhamentos = new ArrayList<Acompanhamento>();
		acompanhamentos = acompanhamentoDao.lisatrAcompanhamentos();
		return acompanhamentos;
	}
	
	
	public boolean finalizarAcompanhamento(int id) {
		AvaliacaoController avaliacaoController = new AvaliacaoController();
		avaliacao = new Avaliacao();
		acompanhamentoDao = new AcompanhamentoDao();
		boolean finalizado = false;
		
		boolean verificar = acompanhamentoDao.verificarFinalizado(id);
		
		if (verificar) {
			avaliacao = avaliacaoController.realizarAvaliacao(); 
			finalizado = acompanhamentoDao.finalizarAcompanhamento(id, avaliacao);
		} else {
			System.out.println("");
			System.err.println("!! Um dos usuarios não finalizou o chamado !!");
			System.out.println("");
		}
			
		return finalizado;

	}
	
}
