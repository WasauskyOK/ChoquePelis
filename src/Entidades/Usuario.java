package Entidades;
import java.util.Date;

import Models.models_usuario;
public class Usuario {
	private String usuario;
	private String contrase�a;
	private String nomusuario;
	private String apellido;
	private String codigoSeguridad;
	private String descripSeguridad;
	private String respseguridad;
	
	private String fechanac;

	public String getDescripSeguridad() {
		return descripSeguridad;
	}

	public void setDescripSeguridad(String descripSeguridad) {
		this.descripSeguridad = descripSeguridad;
	}
public Usuario () {
	
}

	public Usuario(String nomusuario, String apellido, String codigoSeguridad, String respseguridad, String fechanac) {
	super();
	this.nomusuario = nomusuario;
	this.apellido = apellido;
	this.codigoSeguridad = codigoSeguridad;
	this.respseguridad = respseguridad;
	this.fechanac = fechanac;
}

	public Usuario(String usuario, String contrase�a, String nomusuario, String apellido, String codigoSeguridad,
			String respseguridad, String fechanac) {
		
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.nomusuario = nomusuario;
		this.apellido = apellido;
		this.codigoSeguridad = codigoSeguridad;
		this.respseguridad = respseguridad;
		this.fechanac = fechanac;
	}

	public Usuario(String usuario, String nomusuario, String apellido, String codigoSeguridad, String respseguridad,
			String fechanac) {
		
		this.usuario = usuario;
		this.nomusuario = nomusuario;
		this.apellido = apellido;
		this.codigoSeguridad = codigoSeguridad;
		this.respseguridad = respseguridad;
		this.fechanac = fechanac;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public String getNomusuario() {
		return nomusuario;
	}

	public String getApellido() {
		return apellido;
	}



	public String getRespseguridad() {
		return respseguridad;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public void setRespseguridad(String respseguridad) {
		this.respseguridad = respseguridad;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public static void main() {
		
	}
		
}
