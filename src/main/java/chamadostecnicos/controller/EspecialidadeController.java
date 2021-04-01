package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Especialidade;

public class EspecialidadeController {

	List<Especialidade> especialidades = new ArrayList<Especialidade>();
	Especialidade especialidade;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	// C - create
	public void cadastrarEspecialidade() {
		EspecialidadeController controller = new EspecialidadeController();
		especialidade = new Especialidade();
		especialidade = controller.preencherDadosEspecialidade();
		especialidades.add(especialidade);
		System.out.println("");
		System.out.println("!! Especialidade cadastrada com sucesso!!");
		System.out.println("");
	}
		
	// R - read
	public void listarEspecialidades() {
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		especialidades = this.especialidades;
		exibirDadosEspecialidade(especialidades);
	}
		
	// U - update
	public void atualizarEspecialidade(int id) {
		List<Especialidade> removerEspecialidade = new ArrayList<Especialidade>();
		Especialidade especialidadeEditada = new Especialidade();
		especialidade = new Especialidade();
		for (int i = 0; i < especialidades.size(); i++) {
			especialidade = especialidades.get(i);
			if(especialidade.getId() == id) {
				removerEspecialidade.add(especialidade);
				especialidadeEditada = editarDadosEspecialidade(especialidade);
			}
		}
				
		if(removerEspecialidade.isEmpty()) {
			System.out.println("!! Id da especialidade não localizado !!");
		} else {
			especialidades.removeAll(removerEspecialidade);
			especialidades.add(especialidadeEditada);
			System.out.println("!! Especialidade editada com sucesso !!");
		}
	}
			
	// D - delete
	public void apagarEspecialidades (int id) {
		List<Especialidade> removerEspecialidade = new ArrayList<Especialidade>();
		for (Especialidade especialidade : especialidades) {
			if(especialidade.getId() == id) {
				removerEspecialidade.add(especialidade);	
			}
		}

		if(removerEspecialidade.isEmpty()) {
			System.out.println("!! Id da especialidade não localizado !!");
		} else {
			especialidades.removeAll(removerEspecialidade);
			System.out.println("!! Especialidade apagada com sucesso !!");
		}
	}
		
		
	// Codigos auxiliares	
		
	public Especialidade preencherDadosEspecialidade() {
		Especialidade especialidade = new Especialidade();
		System.out.println("Digite o nome da especialidade:");
		especialidade.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descrição da especialidade:");
		especialidade.setDescricao(String.valueOf(scan.nextLine()));
		especialidade.setId(r.nextInt(100));
			
		return especialidade;
	}
		
	public void exibirDadosEspecialidade(List<Especialidade> especialidades) {
		if (especialidades.isEmpty()) {
			System.out.println("!! Não há departamentos cadastrados !!");
		} else {
			System.out.println("=====================================================================");
			System.out.println("=========================\\ ESPECIALIDADES //=========================");
			System.out.println("");
			for (Especialidade especialidade : especialidades) {
				System.out.println("");
				System.out.println("Id: " + especialidade.getId());
				System.out.println("Nome: " + especialidade.getNome());
				System.out.println("Descrição: " + especialidade.getDescricao());
				System.out.println("");
				System.out.println("===============================================================");
			}
		}
	}
		
	public Especialidade editarDadosEspecialidade(Especialidade especialidade) {
		Especialidade EspecialidadeEditada = new Especialidade();
		System.out.println("Digite o nome do departamento:");
		EspecialidadeEditada.setNome(String.valueOf(scan.nextLine()));
		System.out.println("Digite a descrição do departamento:");
		EspecialidadeEditada.setDescricao(String.valueOf(scan.nextLine()));
		EspecialidadeEditada.setId(especialidade.getId());
			
		return EspecialidadeEditada;

	}
	
}
