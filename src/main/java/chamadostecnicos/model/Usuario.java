package chamadostecnicos.model;

public class Usuario {

	private int id;
	private String email;
	private String senha;
	private String nome;
	private String telefone;
	private String cpf;
	private Departamento departamento;
	private boolean tecnico;
	private Especialidade especialidade;
	
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String email, String senha, String nome, String telefone, String cpf,
			Departamento departamento, boolean tecnico, Especialidade especialidade) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.departamento = departamento;
		this.tecnico = tecnico;
		this.especialidade = especialidade;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public boolean isTecnico() {
		return tecnico;
	}

	public void setTecnico(boolean tecnico) {
		this.tecnico = tecnico;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return  "\n Id: " + id + 
				"\n Email: " + email + 
				"\n Senha: " + senha + 
				"\n Nome: " + nome + 
				"\n Telefone: " + telefone + 
				"\n CPF: " + cpf + 
				"\n Departamento: " + departamento + 
				"\n Tecnico: " + tecnico + 
				"\n Especialidade: " + especialidade;
	}
	
	
	
	
}
