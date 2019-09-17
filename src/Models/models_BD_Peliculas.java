package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import Entidades.Pelicula;
import JDBC.DirectAccess;
public class models_BD_Peliculas {
	
	/*OBTENER ABSOLUTAMENTE TODAS LAS PELICULAS*/
	

	public List<Pelicula>ObtenerListaPeliculas(){
		List<Pelicula>lista=new ArrayList<Pelicula>(); 
		
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call ListarPeliculas1er50()");
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
	public static void main(String[]Args) {
		/*
		Pelicula lapel=null;
		for(Pelicula pel:new models_BD_Peliculas().ObtenerListaPeliculas()) {
			if(pel.getCodpelicula().equals("p00003")) {
				lapel=pel;
				break;
			}
		}	
		System.out.println(lapel.getCodpelicula());
		Pelicula asd=new Pelicula();
		*/
		/***************************************************************************************************************/
		/*
		new models_BD_Peliculas().ObtenerListaPeliculas().stream().filter(x->x.getCodpelicula().equals("p00003")).forEach(x->{			 
			 asd.setAutogenerador(x.getAutogenerador());
			 asd.setCodpelicula(x.getCodpelicula());
			 asd.setNompelicula(x.getNompelicula());
			 asd.setNombimagen(x.getNombimagen());
			 asd.setMinidescripcion(x.getMinidescripcion());
			 asd.setDescripcion(x.getDescripcion());
			 asd.setCodcat(x.getCodcat());
			 asd.setLinkpel(x.getLinkpel());
			 asd.setValoracion(x.getValoracion());
			 asd.setDuracion(x.getDuracion());
			 asd.setEstreno(x.getEstreno());
			 asd.setNombCategoria(x.getNombCategoria());
			});
		
		 	System.out.println(asd.getAutogenerador());
		 	System.out.println(asd.getNombimagen());
		 	System.out.println(asd.getNombCategoria());
		
		 	System.out.println("***********************");
		 	System.out.println("\n"+asd.getMinidescripcion());
		
		
		
		*/
		

		/*List<Pelicula>listado=null;
		 new models_BD_Peliculas().ObtenerListaPeliculas().stream().filter(x->x.getCodpelicula().equals("p00003")).forEach(x->{
			//Pelicula xpel=x;
			
			Pelicula pel=new Pelicula(x.getAutogenerador(),x.getCodpelicula(), x.getNompelicula(), x.getNombimagen(),
						x.getMinidescripcion(), x.getDescripcion(), x.getCodcat(),x.getLinkpel(), x.getValoracion(),
						x.getDuracion(), x.getEstreno(),x.getNombCategoria());
			 listado.add(pel);
			 		 });
		 
		 listado.forEach(x->x.getDescripcion());
/*
		 models_BD_Peliculas obj=new models_BD_Peliculas();
		  Optional<Pelicula>pelicula= obj.ObtenerListaPeliculas().stream().filter(x->x.getCodpelicula().equals("p00003")).findFirst();
	*/	 
	//	List<Pelicula>lista= (List<Pelicula>) new models_BD_Peliculas().ObtenerListaPeliculas().stream().filter(x->x.getCodpelicula().equals("p00003"));
		
		//lista.stream().forEach(x->System.out.println(x));
	}
	public Boolean ValidarEstado(String usuario,String codpelicula) {
		Boolean val=false;
		Connection conexion=null;
		PreparedStatement call=null;
		ResultSet resul=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("select peliculas.codpelicula,peliculas.nompelicula,repositorio.estado from peliculas join \r\n" + 
					"repositorio on peliculas.codpelicula=repositorio.codpelicula join \r\n" + 
					"usuario on usuario.usuario=repositorio.usuario where usuario.usuario=? and repositorio.codpelicula=?");
			call.setString(1,usuario);
			call.setString(2, codpelicula);
			resul=call.executeQuery();
			if(resul.next()) {
				val=true;
			}
			conexion.close();
			call.close();
			resul.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return val;
	}

	public void DesagregarPeliculaXUsuario(String usuario, String codpelicula) {
		// TODO Auto-generated method stub
		
		Connection conexion=null;
		PreparedStatement call=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("delete from repositorio where usuario=? and codpelicula=?");
			call.setString(1,usuario);
			call.setString(2,codpelicula);
			call.executeUpdate();
			
			System.out.println(call);
			conexion.close();
			call.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void AgregarPeliculaXUsuario(String usuario, String codpelicula) {
		// TODO Auto-generated method stub
		Connection conexion=null;
		PreparedStatement call=null;
	/*
		Date fecha=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("insert into repositorio values(?,?,?,?)");
			java.util.Date fec=new java.util.Date();
			java.sql.Date fechahoy=new java.sql.Date(fec.getTime());
			
			call.setString(1,usuario);
			call.setString(2,codpelicula);
			call.setDate(3,fechahoy);
			call.setString(4,"Agregado");
			call.executeUpdate();
			
			
			conexion.close();
			call.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	public List<Pelicula>ObtenerListaPeliculasRelacionadas(String nombrecategoria){
		List<Pelicula>lista=new ArrayList<Pelicula>(); 
		
		Connection conexion=null;
		CallableStatement call=null;
		ResultSet resultado=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
		call=conexion.prepareCall("call ListarPorTipoRelacionadas(?)");
		call.setString(1, nombrecategoria);
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
