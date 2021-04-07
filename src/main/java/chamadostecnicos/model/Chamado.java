package chamadostecnicos.model;

import java.time.LocalDate;

public class Chamado {
	
	private int id;
	private Usuario usuario;
	private Servico servico;
	private Status status;
	private LocalDate dataAbertura;
	private LocalDate prazoSolucao;
	
	
	public Chamado() {
		super();
	}

	public Chamado(int id, Usuario usuario, Servico servico, Status status, LocalDate dataAbertura,
			LocalDate prazoSolucao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.servico = servico;
		this.status = status;
		this.dataAbertura = dataAbertura;
		this.prazoSolucao = prazoSolucao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getPrazoSolucao() {
		return prazoSolucao;
	}

	public void setPrazoSolucao(LocalDate prazoSolucao) {
		this.prazoSolucao = prazoSolucao;
	}

	
	@Override
	public String toString() {
		return  "\n Id: " + id + 
				"\n Usuario: " + usuario + 
				"\n Servico: " + servico + 
				"\n Status: " + status + 
				"\n Data de abertura: " + dataAbertura + 
				"\n Prazo para solução: " + prazoSolucao;
	}

}
