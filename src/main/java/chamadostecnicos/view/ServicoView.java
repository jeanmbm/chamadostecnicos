package chamadostecnicos.view;

import java.util.List;
import java.util.Scanner;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;

public class ServicoView {
	
	Scanner scan = new Scanner(System.in);
	

	public Servico preencherDadosServico() {
		Servico servico = new Servico();
		boolean aux = false;
		
		System.out.print("Digite o nome do servico: ");
		servico.setNome(String.valueOf(scan.nextLine()));
		
		System.out.print("Digite a descrição do servico: ");
		servico.setDescricao(String.valueOf(scan.nextLine()));
		
		aux = false;
		while (aux == false) {
			System.out.print("Digite o nivel de prioridade deste servico (baixa, media, alta ou urgente): ");
			String prioridade = scan.next();
			if (prioridade.equalsIgnoreCase("baixa")) {
				servico.setPrioridade(Prioridade.BAIXA);
				aux = true;
			} else if (prioridade.equalsIgnoreCase("media")) {
				servico.setPrioridade(Prioridade.MEDIA);
				aux = true;
			} else if (prioridade.equalsIgnoreCase("alta")) {
				servico.setPrioridade(Prioridade.ALTA);
				aux = true;
			} else if (prioridade.equalsIgnoreCase("urgente")) {
				servico.setPrioridade(Prioridade.URGENTE);
				aux = true;
			} else {
				aux = false;
				System.out.println("!! Nível de prioridade não correspondente !!");	
				System.out.println("");
			}
		}
		
		aux = false;
		while (aux == false) {
			System.out.print("Digite a área desse servico (hardware ou software): ");
			String area = scan.next();
			if (area.equalsIgnoreCase("hardware")) {
				servico.setArea(Area.HARDWARE);
				aux = true;
			} else if (area.equalsIgnoreCase("software")) {
				servico.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				System.out.println("!! Área não correspondente !!");	
				System.out.println("");
			}
		}
		
		aux = false;
		while (aux == false) {
			System.out.print("Digite o id da categoria a que esse servico deverá pertencer: ");
			servico.setIdCategoria(scan.nextInt());
			
			if (servico.getIdCategoria() == 0) {
				System.out.println("!! Id da categoria não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		return servico;
	}
	
	
	public void exibirDadosCategoria(List<Servico> servicos) {
		if (servicos.isEmpty()) {
			System.out.println("");
			System.out.println("!! Não há servicos cadastrados !!");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("=========================================================================================================================================");
			System.out.println("==========================================================\\ SERVICOS //==================================================================");
			for (Servico servico : servicos) {
				System.out.println("");
				System.out.println("Id: " + servico.getId());
				System.out.println("Nome do servico: " + servico.getNome());
				System.out.println("Descricao: " + servico.getDescricao());
				System.out.println("Prioridade: " + servico.getPrioridade().getDescricao());
				System.out.println("Área: " + servico.getArea().getDescricao());
				System.out.println("Categoria: " + servico.getCategoria().toString());
				System.out.println("");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			}
			System.out.println("=========================================================================================================================================");
			System.out.println("");
		}
		
	}
	
	
	public Servico atualizarDadosCategoria(int id) {
		Servico servicoEditado = new Servico();
		boolean aux = false;
		
		while (aux == false) {
			System.out.print("Digite o nome do servico: ");
			servicoEditado.setNome(String.valueOf(scan.nextLine()));
			
			if (servicoEditado.getNome() == null || servicoEditado.getNome().isEmpty()) {
				System.out.println("!! Nome não pode ser nulo ou vazio !!");
				System.out.println("");
				aux = false;
			} else {
				aux = true;
			}
		}
		
		System.out.print("Digite a descrição do servico: ");
		servicoEditado.setDescricao(String.valueOf(scan.nextLine()));
		
		aux = false;
		while (aux == false) {
			System.out.print("Digite o nivel de prioridade deste servico (baixa, media, alta ou urgente): ");
			String prioridade = scan.next();
			if (prioridade.equalsIgnoreCase("baixa")) {
				servicoEditado.setPrioridade(Prioridade.BAIXA);
				aux = true;
			} else if (prioridade.equalsIgnoreCase("media")) {
				servicoEditado.setPrioridade(Prioridade.MEDIA);
				aux = true;
			} else if (prioridade.equalsIgnoreCase("alta")) {
				servicoEditado.setPrioridade(Prioridade.ALTA);
				aux = true;
			} else if (prioridade.equalsIgnoreCase("urgente")) {
				servicoEditado.setPrioridade(Prioridade.URGENTE);
				aux = true;
			} else {
				aux = false;
				System.out.println("!! Nível de prioridade não correspondente !!");	
				System.out.println("");
			}
		}
		
		aux = false;
		while (aux == false) {
			System.out.print("Digite a área desse servico (hardware ou software): ");
			String area = scan.next();
			if (area.equalsIgnoreCase("hardware")) {
				servicoEditado.setArea(Area.HARDWARE);
				aux = true;
			} else if (area.equalsIgnoreCase("software")) {
				servicoEditado.setArea(Area.SOFTWARE);
				aux = true;
			} else {
				aux = false;
				System.out.println("!! Área não correspondente !!");	
				System.out.println("");
			}
		}
		
		servicoEditado.setId(id);
		
		return servicoEditado;
	}
	
}
