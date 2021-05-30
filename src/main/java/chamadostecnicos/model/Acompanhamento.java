package chamadostecnicos.model;


public class Acompanhamento {
	
	
	private int id;
	private int idTecnico;
	private Usuario tecnico;
	private int idChamado;
	private Chamado chamado;
	private boolean solucionadoTecnico;
	private boolean solucionadoUsuario;
	private int idAvaliacao;
	private Avaliacao avaliacao;
	
	
	public Acompanhamento() {
		super();
	}

	public Acompanhamento(int idTecnico, int idChamado, boolean solucionadoTecnico, boolean solucionadoUsuario,
			int idAvaliacao) {
		super();
		this.idTecnico = idTecnico;
		this.idChamado = idChamado;
		this.solucionadoTecnico = solucionadoTecnico;
		this.solucionadoUsuario = solucionadoUsuario;
		this.idAvaliacao = idAvaliacao;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public boolean isSolucionadoTecnico() {
		return solucionadoTecnico;
	}

	public void setSolucionadoTecnico(boolean solucionadoTecnico) {
		this.solucionadoTecnico = solucionadoTecnico;
	}

	public boolean isSolucionadoUsuario() {
		return solucionadoUsuario;
	}

	public void setSolucionadoUsuario(boolean solucionadoUsuario) {
		this.solucionadoUsuario = solucionadoUsuario;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	
}
