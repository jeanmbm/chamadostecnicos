package chamadostecnicos.model;


public class Acompanhamento {

	
	private int id;
	private Usuario tecnico;
	private Chamado chamado;
	private boolean solucionadoTecnico;
	private boolean solucionadoUsuario;
	private Avaliacao avaliacao;
	
	
	public Acompanhamento() {
		super();
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


	@Override
	public String toString() {
		return "Acompanhamento [id=" + id + ", tecnico=" + tecnico + ", chamado=" + chamado + ", solucionadoTecnico="
				+ solucionadoTecnico + ", solucionadoUsuario=" + solucionadoUsuario + ", avaliacao=" + avaliacao + "]";
	}
	
	
	
	
}
