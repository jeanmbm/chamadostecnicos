package chamadostecnicos.model;

public class Departamento {
	
	private int id;
	private String nome;
	private String descricao;
	
	
	public Departamento() {
	}

	public Departamento(String nome, String descricao) {
		super();
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
		return  "\n   Nome: " + nome + 
				"\n   Descrição: " + descricao;
	}
	
}
