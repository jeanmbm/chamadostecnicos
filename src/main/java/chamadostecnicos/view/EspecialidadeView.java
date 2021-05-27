package chamadostecnicos.view;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;

public class EspecialidadeView {
	
	Scanner scan = new Scanner(System.in);
	
	public Especialidade preencherDadosEspecialidade() {
		Especialidade especialidade = new Especialidade();
		boolean aux = false;
		
		while (aux == false) {
			System.out.print("Digite o nome da especialidade: ");
			especialidade.setNome(String.valueOf(scan.nextLine()));
			
			if (especialidade.getNome() == null || especialidade.getNome().equals("")) {
				System.out.println("!! Nome n�o pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		System.out.print("Digite a descri��o da especialidade: ");
		especialidade.setDescricao(String.valueOf(scan.nextLine()));
		
		
		aux = false;
		while (aux == false) {
			System.out.printf("Digite a �rea dessa especialidade (hardware ou software): ");
			String area = scan.next();
			if (area.equalsIgnoreCase("hardware")) {
				especialidade.setArea(Area.HARDWARE);
				aux = true;
			} else if (area.equalsIgnoreCase("software")) {
				especialidade.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				System.out.println("!! �rea n�o correspondente !!");	
				System.out.println("");
			}
		}
			
		return especialidade;
	}
	
		
	public void exibirDadosEspecialidade(List<Especialidade> especialidades) {
		if (especialidades.isEmpty()) {
			System.out.println("");
			System.out.println("!! N�o h� especialidades cadastrados !!");
		} else {
			System.out.println("");
			System.out.println("===============================================================");
			System.out.println("======================\\ ESPECIALIDADES //======================");
			for (Especialidade especialidade : especialidades) {
				System.out.println("");
				System.out.println("Id: " + especialidade.getId());
				System.out.println("Nome: " + especialidade.getNome());
				System.out.println("Descri��o: " + especialidade.getDescricao());
				System.out.println("�rea: " + especialidade.getArea().getDescricao());
				System.out.println("");
				System.out.println("===============================================================");
			}
			System.out.println("===============================================================");
			System.out.println("");
		}
	}
		
	
	public Especialidade atualizarDadosEspecialidade(int id) {
		Especialidade EspecialidadeEditada = new Especialidade();
		boolean aux = false;
		
		while (aux == false) {
			System.out.print("Digite o nome da especialidade: ");
			EspecialidadeEditada.setNome(String.valueOf(scan.nextLine()));
			
			if (EspecialidadeEditada.getNome() == null || EspecialidadeEditada.getNome().equals("")) {
				System.out.println("!! Nome n�o pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}

		System.out.print("Digite a descri��o da especialidade: ");
		EspecialidadeEditada.setDescricao(String.valueOf(scan.nextLine()));

		aux = false;
		while (aux == false) {
			System.out.print("Digite a �rea desse servico (hardware ou software): ");
			String area = scan.next();
			if (area.equalsIgnoreCase("hardware")) {
				EspecialidadeEditada.setArea(Area.HARDWARE);
				aux = true;
			} else if (area.equalsIgnoreCase("software")) {
				EspecialidadeEditada.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				System.out.println("!! �rea n�o correspondente !!");	
				System.out.println("");
			}
		}
		
		EspecialidadeEditada.setId(id);
			
		return EspecialidadeEditada;
	}
	

}
