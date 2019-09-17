package Models;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import Entidades.Categoria;
import Entidades.Pelicula;
import JDBC.DirectAccess;
public class models_Categoria {
	public List<Categoria>ListaCategoria(){
		
		 List<Categoria>lista=new ArrayList<Categoria>();
			Connection conexion=null;
			CallableStatement call=null;
			ResultSet resultado=null;
		 	try {
		 		Class.forName("com.mysql.jdbc.Driver");
				
				conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
				call=conexion.prepareCall("select  * from categoria");
				resultado=call.executeQuery();
				while(resultado.next()) {
					Categoria cat=new  Categoria(resultado.getString(1),resultado.getString(2));
					lista.add(cat);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		 
		 
		return lista;
	}
	
	public List<Pelicula>ListaAñoParaUlCategoria(){
		
		 List<Pelicula>lista=new ArrayList<Pelicula>();
			Connection conexion=null;
			CallableStatement call=null;
			ResultSet resultado=null;
		 	try {
		 		Class.forName("com.mysql.jdbc.Driver");
				
				conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
				call=conexion.prepareCall("select  distinct(año) from peliculas");
				resultado=call.executeQuery();
				while(resultado.next()) {
					Pelicula pel=new  Pelicula();
					pel.setSoloañoestreno(resultado.getInt(1));
					lista.add(pel);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		 
		 
		return lista;
	}
	
	
	
	
	public List<Pelicula>FiltroXCategorias(String categoria){
		List<Pelicula>lista=new ArrayList<Pelicula>(); 
		
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call VerPeliculasPorCategoria(?)");
		call.setString(1,categoria);
		resultado=call.executeQuery();
		while(resultado.next()) {
			Pelicula pel=new Pelicula();
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
		
		
			
			lista.add(pel);
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return lista;
		
		
	}
	
	
	public List<Pelicula>FiltroXFecha(int fecha){
		List<Pelicula>lista=new ArrayList<Pelicula>(); 
		
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call VerPeliculasPorFecha(?)");
		call.setInt(1,fecha);
		resultado=call.executeQuery();
		while(resultado.next()) {
			Pelicula pel=new Pelicula();
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
		
		
			
			lista.add(pel);
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return lista;
		
		
	}
	
	
	
	
}
