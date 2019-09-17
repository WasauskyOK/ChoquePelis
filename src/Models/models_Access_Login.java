package Models;
import java.sql.*;

import com.mysql.jdbc.CallableStatement;

import JDBC.DirectAccess;
public class models_Access_Login {
	
	
	
	public Boolean ValidarCreacionUsuario(String cadena) {
		
		Boolean val=false;
		Connection conexion=null;
		java.sql.CallableStatement call=null;
		ResultSet resul=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareCall("call ValidarCreacionNuevoUsuario(?)");
			call.setString(1, cadena);
			resul=call.executeQuery();
			if(resul.next()) {
					val=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return val;
	}
	public Boolean ValidarSession(String usuario,String pass) {
		
		Boolean val=false;
		Connection conexion=null;
		PreparedStatement call=null;
		ResultSet resul=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DirectAccess.cadena,DirectAccess.usuario,DirectAccess.contraseña);
			call=conexion.prepareStatement("select * from usuario where usuario=? and contraseña=?");
			call.setString(1,usuario);
			call.setString(2, pass);
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

	
}
