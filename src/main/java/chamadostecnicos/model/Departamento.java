package chamadostecnicos.model;

public class Departamento {
	
	private int id;
	private String nome;
	private String descricao;
	
	
	public Departamento() {
		super();
	}

	public Departamento(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	@Override
	public String toString() {
		return  "\n   Id: " + id + 
				"\n   Nome: " + nome + 
				"\n   Descrição: " + descricao;
	}
	
}
