package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;
import chamadostecnicos.model.Usuario;

public class EspecialidadeController {
	

	static List<Especialidade> especialidades = new ArrayList<Especialidade>();
	Especialidade especialidade;
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	// C - create
	public void cadastrarEspecialidade() {
		EspecialidadeController controller = new EspecialidadeController();
		
		Especialidade especialidade1 = new Especialidade(r.nextInt(100), "Especialidade teste", "Descrição teste", Area.HARDWARE);
		especialidades.add(especialidade1);
		
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
		especialidades = EspecialidadeController.especialidades;
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
			System.out.println("");
			System.out.println("!! Id da especialidade não localizado !!");
		} else {
			especialidades.removeAll(removerEspecialidade);
			especialidades.add(especialidadeEditada);
			System.out.println("");
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
			System.out.println("");
			System.out.println("!! Id da especialidade não localizado !!");
		} else {
			especialidades.removeAll(removerEspecialidade);
			System.out.println("");
			System.out.println("!! Especialidade apagada com sucesso !!");
		}
	}
		
		
	// Codigos auxiliares	
	
	public void pegarEspecialidadePorId(int id, Usuario usuario) {
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		especialidades = EspecialidadeController.especialidades;
		
		if (especialidades.size() == 0) {
			System.out.println("");
			System.out.println("!! Não há especialidades cadastradas !!");
		} else {
			for (int i = 0; i < especialidades.size(); i++) {
				especialidade = especialidades.get(i);
				if (especialidade.getId() == id) {
					usuario.setEspecialidade(especialidade);
				} 
			}
		}
	}
		
	
	public Especialidade preencherDadosEspecialidade() {
		Especialidade especialidade = new Especialidade();
		
		System.out.print("Digite o nome da especialidade: ");
		especialidade.setNome(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite a descrição da especialidade: ");
		especialidade.setDescricao(String.valueOf(scan.nextLine()));
		
		boolean aux = false;
		while (aux == false) {
			System.out.println("Digite a área desse servico (hardware ou software): ");
			String aux2 = scan.next();
			if (aux2.equalsIgnoreCase("hardware")) {
				especialidade.setArea(Area.HARDWARE);
				aux = true;
			} else if (aux2.equalsIgnoreCase("software")) {
				especialidade.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				System.out.println("!! Área não correspondente !!");	
				System.out.println("");
			}
		}
		
		especialidade.setId(r.nextInt(100));
			
		return especialidade;
	}
	
		
	public void exibirDadosEspecialidade(List<Especialidade> especialidades) {
		if (especialidades.isEmpty()) {
			System.out.println("");
			System.out.println("!! Não há departamentos cadastrados !!");
		} else {
			System.out.println("");
			System.out.println("===============================================================");
			System.out.println("======================\\ ESPECIALIDADES //======================");
			for (Especialidade especialidade : especialidades) {
				System.out.println("");
				System.out.println("Id: " + especialidade.getId());
				System.out.println("Nome: " + especialidade.getNome());
				System.out.println("Descrição: " + especialidade.getDescricao());
				System.out.println("Área: " + especialidade.getArea());
				System.out.println("");
				System.out.println("===============================================================");
			}
			System.out.println("===============================================================");
			System.out.println("");
		}
	}
		
	
	public Especialidade editarDadosEspecialidade(Especialidade especialidade) {
		Especialidade EspecialidadeEditada = new Especialidade();
		
		System.out.println("Digite o nome da especialidade:");
		EspecialidadeEditada.setNome(String.valueOf(scan.nextLine()));
		
		System.out.println("Digite a descrição da especialidade:");
		EspecialidadeEditada.setDescricao(String.valueOf(scan.nextLine()));
		
		boolean aux = false;
		while (aux == false) {
			System.out.println("Digite a área desse servico (hardware ou software): ");
			String aux2 = scan.next();
			if (aux2.equalsIgnoreCase("hardware")) {
				EspecialidadeEditada.setArea(Area.HARDWARE);
				aux = true;
			} else if (aux2.equalsIgnoreCase("software")) {
				EspecialidadeEditada.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				System.out.println("!! Área não correspondente !!");	
				System.out.println("");
			}
		}
		
		EspecialidadeEditada.setId(especialidade.getId());
			
		return EspecialidadeEditada;
	}
	
}
