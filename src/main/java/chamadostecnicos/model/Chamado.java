package chamadostecnicos.model;

import java.time.LocalDate;

public class Chamado {
	
	private int id;
	private Usuario usuario;
	private Servico servico;
	private Status status;
	private String mensagem;
	private LocalDate dataAbertura;
	private LocalDate prazoSolucao;
	private LocalDate dataSolucao;
	
	
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
	
	public LocalDate getDataSolucao() {
		return dataSolucao;
	}

	public void setDataSolucao(LocalDate dataSolucao) {
		this.dataSolucao = dataSolucao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	@Override
	public String toString() {
		return  "\n Id: " + id + 
				"\n Usuario: " + usuario + 
				"\n Servico: " + servico + 
				"\n Mensagem: " + mensagem +
				"\n Status: " + status + 
				"\n Data de abertura: " + dataAbertura + 
				"\n Prazo para solução: " + prazoSolucao +
				"\n Data da solução: " + dataSolucao;
	}

}
