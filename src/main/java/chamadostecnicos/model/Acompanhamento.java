package chamadostecnicos.model;

import java.time.LocalDate;

public class Acompanhamento {

	
	private Usuario tecnico;
	private Chamado chamado;
	private String mensagem;
	private boolean solucionadoTecnico;
	private boolean solucionadoUsuario;
	private LocalDate dataSolucao;
	private Avaliacao avaliacao;
	
	
	public Acompanhamento() {
		super();
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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

	public LocalDate getDataSolucao() {
		return dataSolucao;
	}

	public void setDataSolucao(LocalDate dataSolucao) {
		this.dataSolucao = dataSolucao;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	
	
}
