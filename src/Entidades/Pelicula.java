package Entidades;

public class Pelicula {
	
	private int autogenerador;
	private String codpelicula;
	private String nompelicula;
	private String nombimagen;
	private String minidescripcion;
	private String descripcion;
	private String codcat;
	private String linkpel;
	private String LinkServer;
	private String valoracion;
	private String duracion;
	private String estreno;
	private String nombCategoria;
	private int soloañoestreno;
	
	
	public int getSoloañoestreno() {
		return soloañoestreno;
	}
	public void setSoloañoestreno(int soloañoestreno) {
		this.soloañoestreno = soloañoestreno;
	}
	public String getNombCategoria(){
		return nombCategoria;
	}
	public void setNombCategoria(String nombCategoria) {
		this.nombCategoria = nombCategoria;
	}
	public int getAutogenerador() {
		return autogenerador;
	}
	public String getCodpelicula() {
		return codpelicula;
	}
	public String getNompelicula() {
		return nompelicula;
	}
	public String getNombimagen() {
		return nombimagen;
	}
	public String getMinidescripcion() {
		return minidescripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getCodcat() {
		return codcat;
	}
	public String getLinkpel() {
		return linkpel;
	}
	public String getValoracion() {
		return valoracion;
	}
	public String getDuracion() {
		return duracion;
	}
	public String getEstreno() {
		return estreno;
	}
	public void setAutogenerador(int autogenerador) {
		this.autogenerador = autogenerador;
	}
	public void setCodpelicula(String codpelicula) {
		this.codpelicula = codpelicula;
	}
	public void setNompelicula(String nompelicula) {
		this.nompelicula = nompelicula;
	}
	public void setNombimagen(String nombimagen) {
		this.nombimagen = nombimagen;
	}
	public void setMinidescripcion(String minidescripcion) {
		this.minidescripcion = minidescripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCodcat(String codcat) {
		this.codcat = codcat;
	}
	public void setLinkpel(String linkpel) {
		this.linkpel = linkpel;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public void setEstreno(String estreno) {
		this.estreno = estreno;
	}
	public Pelicula() {
		
	}
	
	public String getLinkServer() {
		return LinkServer;
	}
	public void setLinkServer(String linkServer) {
		LinkServer = linkServer;
	}
	public Pelicula(int autogenerador, String codpelicula, String nompelicula, String nombimagen,
			String minidescripcion, String descripcion, String codcat, String linkpel, String valoracion,
			String duracion, String estreno, String nombCategoria) {
		
		this.autogenerador = autogenerador;
		this.codpelicula = codpelicula;
		this.nompelicula = nompelicula;
		this.nombimagen = nombimagen;
		this.minidescripcion = minidescripcion;
		this.descripcion = descripcion;
		this.codcat = codcat;
		this.linkpel = linkpel;
		this.valoracion = valoracion;
		this.duracion = duracion;
		this.estreno = estreno;
		this.nombCategoria = nombCategoria;
	}
	
	

}
