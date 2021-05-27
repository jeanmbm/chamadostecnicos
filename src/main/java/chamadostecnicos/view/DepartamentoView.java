package chamadostecnicos.view;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Departamento;

public class DepartamentoView {
	
	Scanner scan = new Scanner(System.in);
	
	
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
	
	
	public Departamento atualizarDadosDepartamento(int id) {
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
		
		departamento.setId(id);
		
		return departamento;

	}

}
