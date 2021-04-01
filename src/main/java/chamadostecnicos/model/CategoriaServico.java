package chamadostecnicos.model;

import java.util.ArrayList;
import java.util.List;

public class CategoriaServico {

	private int id;
	private String nome;
	private String descricao;
	private List<Servico> servicos;
		
		
	public CategoriaServico() {
		super();
		this.id = 0;
		this.nome  = "";
		this.descricao  = "";
		this.servicos = new ArrayList<Servico>();
	}
		
	public CategoriaServico(int id, String nome, String descicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descicao;
		this.servicos = new ArrayList<Servico>();
	}


	public int getId() {
		return id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
		
	public String getDescricao() {
		return descricao;
	}
		
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public List<Servico> getServicos() {
		return servicos;
	}
	
	//setter servicos
	public void addServico(Servico servico) {
		this.servicos.add(servico);
		servico.setCategoria(this);
	}

	@Override
	public String toString() {
		return "Categoria "
				+ "/n Id: " + id
				+ "/n Nome:" + nome 
				+ "/n Descrição: " + descricao ;
	}
	
}

