package chamadostecnicos.model;

import java.time.LocalDate;

public class Avaliacao {
	
	private int id;
	private int quantEstrelas;
	private String comentario;
	private LocalDate dataAvalicacao;
	
	
	public Avaliacao() {
		super();
	}

	public Avaliacao(int quantEstrelas, String comentario, LocalDate dataAvalicacao) {
		super();
		this.quantEstrelas = quantEstrelas;
		this.comentario = comentario;
		this.dataAvalicacao = dataAvalicacao;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantEstrelas() {
		return quantEstrelas;
	}
	
	public void setQuantEstrelas(int quantEstrelas) {
		this.quantEstrelas = quantEstrelas;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public LocalDate getDataAvalicacao() {
		return dataAvalicacao;
	}
	
	public void setDataAvalicacao(LocalDate dataAvalicacao) {
		this.dataAvalicacao = dataAvalicacao;
	}

	@Override
	public String toString() {
		return  "\n Quantidade de estrelas: " + quantEstrelas + 
				"\n Comentário: " + comentario + 
				"\n Data da avalicação: " + dataAvalicacao;
	}
	
	
	

}
