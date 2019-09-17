package Models;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import Entidades.PreguntaSeguridad;
import Entidades.Usuario;
import JDBC.DirectAccess;
import java.sql.*;
public class models_Pregunta_Seguridad {
		
	
	
	public List<PreguntaSeguridad>ListaPreguntas(){
		List<PreguntaSeguridad>lista=new ArrayList<PreguntaSeguridad>();
		Connection conexion=null;
		PreparedStatement call=null;
		ResultSet resultado=null;
		
		try {
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("select  * from preguntasseguridad");
			resultado=call.executeQuery();
			while(resultado.next()){
				PreguntaSeguridad obj=new PreguntaSeguridad();
				obj.setPreSeg(resultado.getString(1));
				obj.setDescrpSeguridad(resultado.getString(2));
				lista.add(obj);
			}
			conexion.close();
			call.close();
			resultado.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	public String ConsultarUsuarioParaPregSegMetodo(String userid) {
	String cadena="";
		
		PreguntaSeguridad obj=new PreguntaSeguridad();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			CallableStatement call=conexion.prepareCall("call ConsultarUsuarioParaPregSeg(?)");
			call.setString(1,userid);
			ResultSet res=call.executeQuery();
				while(res.next()) {
					//obj.setDescrpSeguridad(res.getString("descrseguridad"));	
				cadena=res.getString("descrseguridad");
				}
			conexion.close();
			call.close();
			res.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cadena;
	}
	public int CambioPassword(String password,String userid,String respuesta) {
		
		int valida=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			CallableStatement call=conexion.prepareCall("call CambioPassword(?,?,?)");
			call.setString(1,password);
			call.setString(2,userid);
			call.setString(3,respuesta);
			valida=call.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return valida;
		
	}
	public String EncodePassUserPregSeg(String respuesta,String userid){
		String cadena="";
			
			PreguntaSeguridad obj=new PreguntaSeguridad();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
				CallableStatement call=conexion.prepareCall("call Encontrarpassdecrypt(?,?)");
				call.setString(1,respuesta);
				call.setString(2,userid);
				ResultSet res=call.executeQuery();
					while(res.next()) {
						//obj.setDescrpSeguridad(res.getString("descrseguridad"));	
					cadena=res.getString(1);
					}
				conexion.close();
				call.close();
				res.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return cadena;
		}
	
	
	
	
	public static void main(String []Args) {
		//System.out.println(new models_Pregunta_Seguridad().ConsultarUsuarioParaPregSegMetodo("dchoque").getDescrpSeguridad());
		
	}
}

