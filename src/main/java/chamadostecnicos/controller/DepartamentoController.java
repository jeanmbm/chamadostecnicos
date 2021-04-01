package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Departamento;


public class DepartamentoController {

	List<Departamento> departamentos = new ArrayList<Departamento>();
	Departamento departamento;
	DepartamentoController controller;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	// C - create
	public void cadastrarDepartamento() {
		controller = new DepartamentoController();
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
		departamentos = this.departamentos;
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
				System.out.println("!! Id da categoria não localizada !!");
			} else {
				departamentos.removeAll(removerDepartamento);
				departamentos.add(departamentoEditado);
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
				System.out.println("!! Id da categoria não localizada !!");
			} else {
				departamentos.removeAll(removerDepartamento);
				System.out.println("!! Categoria apagada com sucesso !!");
			}
		}
	
	
	// Codigos auxiliares
	
	public Departamento preencherDadosDepartamento() {
		Departamento departamento = new Departamento();
		System.out.println("Digite o nome do departamento:");
		departamento.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descrição do departamento:");
		departamento.setDescricao(String.valueOf(scan.nextLine()));
		departamento.setId(r.nextInt(100));
		
		return departamento;
	}
	
	public void exibirDadosDepartamentos(List<Departamento> departamentos) {
		if (departamentos.isEmpty()) {
			System.out.println("!! Não há departamentos cadastrados !!");
		} else {
			System.out.println("=====================================================================");
			System.out.println("=========================\\ DEPARTAMENTOS //=========================");
			System.out.println("");
			for (Departamento departamento : departamentos) {
				System.out.println("");
				System.out.println("Id: " + departamento.getId());
				System.out.println("Nome: " + departamento.getNome());
				System.out.println("Descrição: " + departamento.getDescricao());
				System.out.println("");
				System.out.println("===============================================================");
			}
		}
	}
	
	public Departamento editarDadosDepartamento(Departamento departamento) {
		Departamento departamentoEditado = new Departamento();
		System.out.println("Digite o nome do departamento:");
		departamentoEditado.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descrição do departamento:");
		departamentoEditado.setDescricao(String.valueOf(scan.nextLine()));
		departamentoEditado.setId(departamento.getId());
		
		return departamentoEditado;

	}
	
	
}
