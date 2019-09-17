package Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entidades.Pelicula;
import JDBC.DirectAccess;

public class models_search_pelicula {

	
	
	public List<Pelicula>ObtenerBusquedas(String pelicula){
		List<Pelicula>lista=new ArrayList<Pelicula>(); 
		
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call BusquedaPelicula(?)");
		call.setString(1,pelicula);
		resultado=call.executeQuery();
		while(resultado.next()) {
			Pelicula pel=new Pelicula();
			//pel.setAutogenerador(resultado.getInt("autogenerador"));
			pel.setCodpelicula(resultado.getString("codpelicula"));
			pel.setNompelicula(resultado.getString("nompelicula"));
			pel.setNombimagen(resultado.getString("nombimagen"));
			//pel.setMinidescripcion(resultado.getString("minidescripcion"));
			//pel.setDescripcion(resultado.getString("descripcion"));
			//pel.setCodcat(resultado.getString("codcat"));
			//pel.setLinkpel(resultado.getString("linkpel"));
			pel.setValoracion(resultado.getString("valoracion"));
			pel.setDuracion(resultado.getString("duracion"));
			pel.setEstreno(resultado.getString("estreno"));
			lista.add(pel);
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return lista;
		
		
	}
	
}
