package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Departamento;
import chamadostecnicos.model.dao.DepartamentoDao;


public class DepartamentoController {

	
	Departamento departamento;
	DepartamentoDao departamentoDao;
	Scanner scan = new Scanner(System.in);
	
	
	// C - create
	public void cadastrarDepartamento() {
		DepartamentoController controller = new DepartamentoController();
		departamentoDao = new DepartamentoDao();
		departamento = new Departamento();
		
		departamento = controller.preencherDadosDepartamento();
		boolean aux = departamentoDao.salvarDepartamento(departamento);
		if (aux == true) {
			System.out.println("");
			System.out.println("!! Departamento cadastrado com sucesso!!");
			System.out.println("");
		}
	}
	
	
	// R - read
	public void listarDepartamentos() {
		List<Departamento> departamentos;
		departamentoDao = new DepartamentoDao();
		departamentos = departamentoDao.listarDepartamentos();
		exibirDadosDepartamentos(departamentos);
	}
	
	
	// U - update
	public void editarDepartamento(int id) {
		departamentoDao = new DepartamentoDao();
		departamento = new Departamento();
		
		departamento = departamentoDao.selecionarDepartamentoPorId(id);
		departamento = atualizarDadosDepartamento(departamento);
		
		boolean aux = departamentoDao.editarDepartamento(departamento);
		if (aux == true) {
			System.out.println("");
			System.out.println("!! Departamento apagado com suscesso !!");
			System.out.println("");
		}
	}
	
	
	// D - delete
	public void apagarDepartamento (int id) {
		departamentoDao = new DepartamentoDao();
		boolean aux = departamentoDao.deletarDepartamento(id);
		if (aux == true) {
			System.out.println("");
			System.out.println("!! Departamento apagado com suscesso !!");
			System.out.println("");
		}
	}
	
	
	// Codigos auxiliares
	
//	public void pegarDepartamentoPorId(int id, Usuario usuario) {
//		List<Departamento> departamentos = new ArrayList<Departamento>();
//		departamentos = DepartamentoController.departamentos;
//		
//		if (departamentos.size() == 0) {
//			System.out.println("");
//			System.out.println("!! Não há departamentos cadastrados !!");
//		} else {
//			for (int i = 0; i < departamentos.size(); i++) {
//				departamento = departamentos.get(i);
//				if (departamento.getId() == id) {
//					usuario.setDepartamento(departamento);
//				}
//			}
//		}
//	}
	
	
	public Departamento preencherDadosDepartamento() {
		Departamento departamento = new Departamento();
		
		boolean aux = false;
		while (aux == false) {
			System.out.print("Digite o nome do departamento: ");
			departamento.setNome(String.valueOf(scan.nextLine()));
			
			if (departamento.getNome() == null || departamento.getNome().equals("")) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		System.out.print("Digite a descrição do departamento: ");
		departamento.setDescricao(String.valueOf(scan.nextLine()));
		
		return departamento;
	}
	
	
	public void exibirDadosDepartamentos(List<Departamento> departamentos) {
		if (departamentos.isEmpty()) {
			System.out.println("");
			System.out.println("!! Não há departamentos cadastrados !!");
		} else {
			System.out.println("");
			System.out.println("===============================================================");
			System.out.println("======================\\ DEPARTAMENTOS //=======================");
			for (Departamento departamento : departamentos) {
				System.out.println("");
				System.out.println("Id: " + departamento.getId());
				System.out.println("Nome: " + departamento.getNome());
				System.out.println("Descrição: " + departamento.getDescricao());
				System.out.println("");
				System.out.println("===============================================================");
			}
			System.out.println("===============================================================");
			System.out.println("");
		}
	}
	
	
	public Departamento atualizarDadosDepartamento(Departamento departamento) {
		
		boolean aux = false;
		while (aux == false) {
			System.out.print("Digite o nome do departamento: ");
			departamento.setNome(String.valueOf(scan.nextLine()));
			
			if (departamento.getNome() == null || departamento.getNome().equals("")) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		System.out.print("Digite a descrição do departamento: ");
		departamento.setDescricao(String.valueOf(scan.nextLine()));
		
		return departamento;

	}
	
}
