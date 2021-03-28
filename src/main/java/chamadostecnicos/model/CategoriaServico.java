package chamadostecnicos.model;

//import java.util.List;

public class CategoriaServico {

	private long id;
	private String nome;
	private String descicao;
	//private List<Servico> servicos;
		
		
	public CategoriaServico() {
		super();
	}
		
	public CategoriaServico(long id, String nome, String descicao /*, List<Servico> servicos*/) {
		super();
		this.id = id;
		this.nome = nome;
		this.descicao = descicao;
		//this.servicos = servicos;
	}


	public long getId() {
		return id;
	}
		
	public void setId(long id) {
		this.id = id;
	}
		
	public String getDescicao() {
		return descicao;
	}
		
	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
//	public List<Servico> getServicos() {
//		return servicos;
//	}
//
//	public void setServicos(List<Servico> servicos) {
//		this.servicos = servicos;
//	}

}

