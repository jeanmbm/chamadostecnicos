package chamadostecnicos.model;


public class Servico {

	private int id;
	private String nome;
	private String descricao;
	private Prioridade prioridade;
	private int idCategoria;
	private CategoriaServico categoria;
	private Area area;
	
	
	public Servico() {
		id = 0;
		nome = "";
		descricao = "";
		prioridade = Prioridade.VAZIO;
		categoria = new CategoriaServico();
	}
	
	public Servico(String nome, String descricao, Prioridade prioridade, int idCategoria, Area area) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.idCategoria = idCategoria;
		this.area = area;
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
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	@Override
	public String toString() {
		return "\n   Nome: " + nome + 
			   "\n   Descrição: " + descricao + 
			   "\n   Prioridade: " + prioridade + 
			   "\n   Categoria: " + categoria.getNome() +
			   "\n   Area: " + area;
	}

}
