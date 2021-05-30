package chamadostecnicos.model;

public class Especialidade {

	private int id;
	private String nome;
	private String descricao;
	private Area area;
	
	
	public Especialidade() {
		super();
	}

	public Especialidade(String nome, String descricao, Area area) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.area = area;
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
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	

	@Override
	public String toString() {
		return  "\n   Nome: " + nome + 
				"\n   Descrição: " + descricao +
				"\n   Area: " + area;
	}
	
}
