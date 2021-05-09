package chamadostecnicos.model;

public enum Area {

	SOFTWARE("Software"), HARDWARE("Hardware");
	
	public String descricao;
	
	Area(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
