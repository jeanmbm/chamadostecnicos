package chamadostecnicos.model;

import java.time.LocalDate;

public class Chamado {
	
	private int id;
	private int idUsuario;
	private Usuario usuario;
	private int IdServico;
	private Servico servico;
	private Status status;
	private String mensagem;
	private LocalDate dataAbertura;
	private LocalDate prazoSolucao;
	private LocalDate dataSolucao;
	
	
	public Chamado() {
		super();
	}
	
	public Chamado(int idUsuario, int idServico, Status status, String mensagem, LocalDate dataAbertura,
			LocalDate prazoSolucao, LocalDate dataSolucao) {
		super();
		this.idUsuario = idUsuario;
		this.IdServico = idServico;
		this.status = status;
		this.mensagem = mensagem;
		this.dataAbertura = dataAbertura;
		this.prazoSolucao = prazoSolucao;
		this.dataSolucao = dataSolucao;
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
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdServico() {
		return IdServico;
	}

	public void setIdServico(int idServico) {
		IdServico = idServico;
	}


	@Override
	public String toString() {
		return  "\n   Id: " + id + 
				"\n   Usuario: " + usuario.toString() + 
				"\n   Servico: " + servico + 
				"\n   Mensagem: " + mensagem +
				"\n   Status: " + status + 
				"\n   Data de abertura: " + dataAbertura + 
				"\n   Prazo para solução: " + prazoSolucao +
				"\n   Data da solução: " + dataSolucao;
	}

}
