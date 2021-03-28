package chamadostecnicos.model;

public enum Prioridade {

	BAIXA("Baixa"), MEDIA("M�dia"), ALTA("Alta"), URGENTE("Urgente");

	public String descricao;
	
	Prioridade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNivelPrioridade() {
		return descricao;
	}
	
}