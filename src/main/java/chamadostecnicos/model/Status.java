package chamadostecnicos.model;

public enum Status {

	ANALISE("Em an�lise"), ABERTO("Em aberto"), ANDAMENTO("Em andamento"), CONCLUIDO("Concluido"), CANCELADO("Cancelado");
	
	public String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
