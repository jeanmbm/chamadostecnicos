package chamadostecnicos.model;


public class Servico {

	private int id;
	private String nome;
	private String descricao;
	private Prioridade prioridade;
	private CategoriaServico categoria;
	
	
	public Servico() {
		super();
		id = 0;
		nome = "";
		descricao = "";
		prioridade = Prioridade.VAZIO;
		//categoria = new CategoriaServico();
	}


	public Servico(int id, String nome, CategoriaServico categoria, String descricao, Prioridade prioridade) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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


	@Override
	public String toString() {
		return "Servico "
				+ "/n Id: " + id
				+ "/n Nome:" + nome 
				+ "/n Descri��o: " + descricao 
				+ "/n Prioridade: " + prioridade 
				+ "/n Categoria:" + categoria.toString();
	}
	
	
	
}
