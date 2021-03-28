package chamadostecnicos.model;


public class Servico {

	private long id;
	private String nome;
	private CategoriaServico categoria;
	private String descricao;
	private Prioridade prioridade;
	
	
	public Servico() {
		super();
	}

	public Servico(long id, String nome, CategoriaServico categoria, String descricao, Prioridade prioridade) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public CategoriaServico getCategoria() {
		return categoria;
	}
	
	public void setCategoria(CategoriaServico categoria) {
		this.categoria = categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Prioridade getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
