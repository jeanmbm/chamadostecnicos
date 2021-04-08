package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Departamento;
import chamadostecnicos.model.Usuario;

public class DepartamentoController {

	
	static List<Departamento> departamentos = new ArrayList<Departamento>();
	Departamento departamento;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	// C - create
	public void cadastrarDepartamento() {
		DepartamentoController controller = new DepartamentoController();
		
		Departamento departamento1 = new Departamento(r.nextInt(100), "Departamento teste", "Descrição teste");
		departamentos.add(departamento1);
		
		departamento = new Departamento();
		departamento = controller.preencherDadosDepartamento();
		departamentos.add(departamento);
		System.out.println("");
		System.out.println("!! Departamento cadastrado com sucesso!!");
		System.out.println("");
	}
	
	
	// R - read
	public void listarDepartamentos() {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		departamentos = DepartamentoController.departamentos;
		exibirDadosDepartamentos(departamentos);
	}
	
	
	// U - update
	public void atualizarDepartamento(int id) {
		List<Departamento> removerDepartamento = new ArrayList<Departamento>();
		Departamento departamentoEditado = new Departamento();
		departamento = new Departamento();
		for (int i = 0; i < departamentos.size(); i++) {
			departamento = departamentos.get(i);
			if(departamento.getId() == id) {
				removerDepartamento.add(departamento);
				departamentoEditado = editarDadosDepartamento(departamento);
			}
		}
		
		if(removerDepartamento.isEmpty()) {
			System.out.println("");
			System.out.println("!! Id da categoria não localizada !!");
		} else {
			departamentos.removeAll(removerDepartamento);
			departamentos.add(departamentoEditado);
			System.out.println("");
			System.out.println("!!Categoria editada com sucesso !!");
		}
	}
	
	
	// D - delete
	public void apagarDepartamento (int id) {
		List<Departamento> removerDepartamento = new ArrayList<Departamento>();
		for (Departamento departamento : departamentos) {
			if(departamento.getId() == id) {
				removerDepartamento.add(departamento);	
			}
		}

		if(removerDepartamento.isEmpty()) {
			System.out.println("");
			System.out.println("!! Id da categoria não localizada !!");
		} else {
			departamentos.removeAll(removerDepartamento);
			System.out.println("");
			System.out.println("!! Categoria apagada com sucesso !!");
		}
	}
	
	
	// Codigos auxiliares
	
	public void pegarDepartamentoPorId(int id, Usuario usuario) {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		departamentos = DepartamentoController.departamentos;
		
		if (departamentos.size() == 0) {
			System.out.println("");
			System.out.println("!! Não há departamentos cadastrados !!");
		} else {
			for (int i = 0; i < departamentos.size(); i++) {
				departamento = departamentos.get(i);
				if (departamento.getId() == id) {
					usuario.setDepartamento(departamento);
				}
			}
		}
	}
	
	
	public Departamento preencherDadosDepartamento() {
		Departamento departamento = new Departamento();
		
		System.out.print("Digite o nome do departamento: ");
		departamento.setNome(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite a descrição do departamento: ");
		departamento.setDescricao(String.valueOf(scan.nextLine()));
		
		departamento.setId(r.nextInt(100));
		
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
	
	
	public Departamento editarDadosDepartamento(Departamento departamento) {
		Departamento departamentoEditado = new Departamento();
		
		System.out.print("Digite o nome do departamento: ");
		departamentoEditado.setNome(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite a descrição do departamento: ");
		departamentoEditado.setDescricao(String.valueOf(scan.nextLine()));
		
		departamentoEditado.setId(departamento.getId());
		
		return departamentoEditado;

	}
	
}
