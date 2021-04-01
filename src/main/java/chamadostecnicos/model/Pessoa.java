package chamadostecnicos.model;

public class Pessoa {
	
	private int id;
	private String nome;
	private String cfp;
	private String telefone;
	
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(int id, String nome, String cfp, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cfp = cfp;
		this.telefone = telefone;
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
	
	public String getCfp() {
		return cfp;
	}
	
	public void setCfp(String cfp) {
		this.cfp = cfp;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
