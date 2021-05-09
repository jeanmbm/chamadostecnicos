package chamadostecnicos.controller;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;
import chamadostecnicos.model.dao.EspecialidadeDao;


public class EspecialidadeController {
	

	Especialidade especialidade;
	EspecialidadeDao especialidadeDao;
	Scanner scan = new Scanner(System.in);
	
	
	// C - create
	public void cadastrarEspecialidade() {
		EspecialidadeController controller = new EspecialidadeController();
		especialidadeDao = new EspecialidadeDao();
		especialidade = new Especialidade();
		
		especialidade = controller.preencherDadosEspecialidade();
		boolean salvo = especialidadeDao.salvarEspecialidade(especialidade);
		if (salvo) {
			System.out.println("");
			System.out.println("!! Especialidade cadastrada com sucesso!!");
			System.out.println("");
		}
	}
		
	
	// R - read
	public void listarEspecialidades() {
		List<Especialidade> especialidades;
		especialidadeDao = new EspecialidadeDao();
		especialidades = especialidadeDao.listarEspecialidades();
		exibirDadosEspecialidade(especialidades);
	}
		
	
	// U - update
	public void editarEspecialidade(int id) {
		Especialidade especialidadeEdit = new Especialidade();
		especialidade = new Especialidade();
		especialidadeDao = new EspecialidadeDao();
		
		especialidadeEdit = especialidadeDao.selecionarEspecialidadePorId(id);
		especialidade = atualizarDadosEspecialidade(especialidadeEdit);
		
		boolean aux = especialidadeDao.editarEspecialidade(especialidade);
		if (aux == true) {
			System.out.println("");
			System.out.println("!! Especialidade editada com suscesso !!");
			System.out.println("");
		}
	}
			
	
	// D - delete
	public void apagarEspecialidades (int id) {
		especialidadeDao = new EspecialidadeDao();
		boolean aux = especialidadeDao.deletarEspecialidade(id);
		if (aux == true) {
			System.out.println("");
			System.out.println("!! Especialidade apagada com suscesso !!");
			System.out.println("");
		}
	}
		
		
	// Codigos auxiliares	
	
//	public void pegarEspecialidadePorId(int id, Usuario usuario) {
//		List<Especialidade> especialidades = new ArrayList<Especialidade>();
//		especialidades = EspecialidadeController.especialidades;
//		
//		if (especialidades.size() == 0) {
//			System.out.println("");
//			System.out.println("!! Não há especialidades cadastradas !!");
//		} else {
//			for (int i = 0; i < especialidades.size(); i++) {
//				especialidade = especialidades.get(i);
//				if (especialidade.getId() == id) {
//					usuario.setEspecialidade(especialidade);
//				} 
//			}
//		}
//	}
		
	
	public Especialidade preencherDadosEspecialidade() {
		Especialidade especialidade = new Especialidade();
		boolean aux = false;
		
		while (aux == false) {
			System.out.print("Digite o nome da especialidade: ");
			especialidade.setNome(String.valueOf(scan.nextLine()));
			
			if (especialidade.getNome() == null || especialidade.getNome().equals("")) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		System.out.print("Digite a descrição da especialidade: ");
		especialidade.setDescricao(String.valueOf(scan.nextLine()));
		
		
		aux = false;
		while (aux == false) {
			System.out.printf("Digite a área dessa especialidade (hardware ou software): ");
			String area = scan.next();
			if (area.equalsIgnoreCase("hardware")) {
				especialidade.setArea(Area.HARDWARE);
				aux = true;
			} else if (area.equalsIgnoreCase("software")) {
				especialidade.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				System.out.println("!! Área não correspondente !!");	
				System.out.println("");
			}
		}
			
		return especialidade;
	}
	
		
	public void exibirDadosEspecialidade(List<Especialidade> especialidades) {
		if (especialidades.isEmpty()) {
			System.out.println("");
			System.out.println("!! Não há especialidades cadastrados !!");
		} else {
			System.out.println("");
			System.out.println("===============================================================");
			System.out.println("======================\\ ESPECIALIDADES //======================");
			for (Especialidade especialidade : especialidades) {
				System.out.println("");
				System.out.println("Id: " + especialidade.getId());
				System.out.println("Nome: " + especialidade.getNome());
				System.out.println("Descrição: " + especialidade.getDescricao());
				System.out.println("Área: " + especialidade.getArea().getDescricao());
				System.out.println("");
				System.out.println("===============================================================");
			}
			System.out.println("===============================================================");
			System.out.println("");
		}
	}
		
	
	public Especialidade atualizarDadosEspecialidade(Especialidade especialidade) {
		Especialidade EspecialidadeEditada = new Especialidade();
		boolean aux = false;
		
		while (aux == false) {
			System.out.print("Digite o nome da especialidade: ");
			EspecialidadeEditada.setNome(String.valueOf(scan.nextLine()));
			
			if (EspecialidadeEditada.getNome() == null || EspecialidadeEditada.getNome().equals("")) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}

		System.out.print("Digite a descrição da especialidade: ");
		EspecialidadeEditada.setDescricao(String.valueOf(scan.nextLine()));

		aux = false;
		while (aux == false) {
			System.out.print("Digite a área desse servico (hardware ou software): ");
			String area = scan.next();
			if (area.equalsIgnoreCase("hardware")) {
				EspecialidadeEditada.setArea(Area.HARDWARE);
				aux = true;
			} else if (area.equalsIgnoreCase("software")) {
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
