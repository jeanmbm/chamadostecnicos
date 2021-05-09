package chamadostecnicos.model;

public class CategoriaServico {

	private int id;
	private String nome;
	private String descricao;

		
	public CategoriaServico() {
		super();
		this.id = 0;
		this.nome  = "";
		this.descricao  = "";
	}
		
	public CategoriaServico(String nome, String descicao) {
		super();
		this.nome = nome;
		this.descricao = descicao;
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

	
	@Override
	public String toString() {
		return "\n  Id: " + id + 
				"\n  Nome: " + nome + 
				"\n  Descrição: " + descricao;
	}

}

