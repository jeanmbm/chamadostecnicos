package chamadostecnicos.model;

public class Usuario {

	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	private String senha;
	private int idDepartamento;
	private Departamento departamento;
	private boolean tecnico;
	private int idEspecialidade;
	private Especialidade especialidade;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nome, String telefone, String cpf, String email, String senha, int idDepartamento,
			boolean tecnico, int idEspecialidade) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.idDepartamento = idDepartamento;
		this.tecnico = tecnico;
		this.idEspecialidade = idEspecialidade;
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

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public int getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(int idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}


	@Override
	public String toString() {
		return  "\n   Nome: " + nome + 
				"\n   Telefone: " + telefone + 
				"\n   CPF: " + cpf + 
				"\n   Departamento: " + departamento.getNome() + 
				"\n   Tecnico: " + tecnico +
				"\n   Especialidade: " + especialidade;
	}
	
	
	
	
}
