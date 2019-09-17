package Entidades;

public class Categoria {
	private String codcategoria;
	private String nomcategoria;
	
	public void setcodCategoria(String codcategoria) {
		this.codcategoria=codcategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		this.nomcategoria=nomCategoria;
	}
	public String getCodCategoria() {
		return codcategoria;
	}
	public String getNomCategoria() {
		return nomcategoria;
	}
	public  Categoria(String codcategoria,String nomcategoria) {
		this.codcategoria=codcategoria;
		this.nomcategoria=nomcategoria;
	}
	
	
}
