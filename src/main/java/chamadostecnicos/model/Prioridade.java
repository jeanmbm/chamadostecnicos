package chamadostecnicos.model;

public enum Prioridade {

	VAZIO(""), BAIXA("Baixa"), MEDIA("M�dia"), ALTA("Alta"), URGENTE("Urgente");

	public String descricao;
	
	Prioridade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNivelPrioridade() {
		return descricao;
	}
	
}
