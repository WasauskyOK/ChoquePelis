package Models;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entidades.Pelicula;
import Entidades.Usuario;
import JDBC.DirectAccess;
public class models_usuario {
	public Boolean valEstadoUser(String user) {
		Boolean agregar=false;
		
		try {
			Connection conexion2=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			PreparedStatement pre=conexion2.prepareStatement("select  * from usuario where usuario=?");
			pre.setString(1,user);
			ResultSet resultado=pre.executeQuery();
			if(resultado.next()) {
				agregar=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return agregar;
	}
	public void AgregarUsuario(Usuario us) {
		
		Connection conexion=null;
		PreparedStatement call=null;
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
			
			call.setString(1,us.getUsuario());
			call.setString(2,us.getContraseña());
			call.setString(3,us.getNomusuario());
			call.setString(4,us.getApellido());
			call.setString(5,us.getCodigoSeguridad());
			call.setString(6, us.getRespseguridad());
			call.setString(7,us.getFechanac());
			call.executeUpdate();
			
			conexion.close();
			call.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public Usuario  ObtenerObjetoUsuario(String userid) {
		Usuario user=new Usuario();
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call ObtenerDatosUsuario(?)");
		call.setString(1, userid);
		resultado=call.executeQuery();
		while(resultado.next()) {
			
			user.setNomusuario(resultado.getString(1));
			user.setApellido(resultado.getString(2));
			user.setCodigoSeguridad(resultado.getString(3));
			user.setDescripSeguridad(resultado.getString(4));
			user.setRespseguridad(resultado.getString(5));
			user.setFechanac(resultado.getString(6));
			
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return user;
		
		
		
		
	}
	public int ActualizarDatosUsuarioExceptoPassword(Usuario us){
		Connection conexion=null;
		PreparedStatement call=null;
		
		int validador=0;
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("update usuario set nomusuario=?,apellido=?,codseg=?,respseguridad=?,fechanac=? where usuario=?");
			
			
			
			call.setString(1,us.getNomusuario());
			call.setString(2,us.getApellido());
			call.setString(3,us.getCodigoSeguridad());
			call.setString(4, us.getRespseguridad());
			call.setString(5,us.getFechanac());
			call.setString(6,us.getUsuario());
			validador=call.executeUpdate();
			conexion.close();
			call.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return validador;
	}
	public Usuario VerDatosUsuarioActual(String usuario) {
		
		Connection conexion=null;
		PreparedStatement call=null;
		ResultSet resultado=null;
		Usuario user=null;
		try {
			
			//java.sql.Date convfecha=new java.sql.Date(fecha.getTime());
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("select *from usuario where usuario=?");
			call.setString(1,usuario);
			resultado=call.executeQuery();
			while(resultado.next()) {
				user=new Usuario(resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6));
			}
			
			conexion.close();
			call.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		
	}
	/*OBTIENE UN OBJETO DE LA PELICULA BUSCADA  QUE ES CARGADA EN LA PAGINA PELICULA SELECCIONADA*/
	public Pelicula ObtenerListaPeliculaPorNombre(String nompel){

		Pelicula pel=new Pelicula();
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call ListarTodasLasPeliculas(?)");
		call.setString(1, nompel);
		resultado=call.executeQuery();
		while(resultado.next()) {
			
			pel.setAutogenerador(resultado.getInt("autogenerador"));
			pel.setCodpelicula(resultado.getString("codpelicula"));
			pel.setNompelicula(resultado.getString("nompelicula"));
			pel.setNombimagen(resultado.getString("nombimagen"));
			pel.setMinidescripcion(resultado.getString("minidescripcion"));
			pel.setDescripcion(resultado.getString("descripcion"));
			pel.setCodcat(resultado.getString("codcat"));
			pel.setLinkpel(resultado.getString("linkpel"));
			pel.setValoracion(resultado.getString("valoracion"));
			pel.setDuracion(resultado.getString("duracion"));
			pel.setEstreno(resultado.getString("estreno"));
			pel.setNombCategoria(resultado.getString("nomcat"));
			pel.setLinkServer(resultado.getString("linkServer"));
			
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return pel;
		
		
	}
	
	public String ValidacionEstadoPelicula(String user,String nompel) {
		String vali="";
			
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call ValidarEstadoPelicula(?,?)");
		call.setString(1, user);
		call.setString(2, nompel);
		resultado=call.executeQuery();
		
		if(resultado.next()) {
			vali=resultado.getString(1);
		}
		conexion.close();
		call.close();
		resultado.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return vali;
	}
	public static void main() {
		Usuario userid=new Usuario("dchoque","Carlos","Figueroa","pre01","Arroz con pollo","1998-05-05");
		System.out.println(new models_usuario().ActualizarDatosUsuarioExceptoPassword(userid));
	
	}
}
