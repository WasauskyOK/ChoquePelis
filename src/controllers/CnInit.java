package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import Entidades.PreguntaSeguridad;
import Entidades.Usuario;
import Models.models_Access_Login;
import Models.models_Pregunta_Seguridad;
import Models.models_usuario;
/**
 * Servlet implementation class LoginGo
 */
@WebServlet("/CnInit")
public class CnInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CnInit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vacio=request.getParameter("vacioIn");
		
		switch(vacio) {
		case "GoSession":
			IniciarSessionGo(request,response);
			break;
		case "valUserNew":
			ValidarEstadoNuevoUsuario(request,response);
			break;
		case "RegistrarCuenta":
			CrearNuevaCuenta(request,response);
			break;
		
		case "SearchPregSeguridad":
			EncontrarPreguntaSeguridad(request,response);
			break;
		case "encodpassresseg":
			TraerPassSeguridad(request,response);
			break;
		case "updatePassw":
			ActualizarPassword(request,response);
			break;
		case "pieOpciones":
			OpcionesPie(request,response);
			break;
		case "UpdateUserActual":
			UpdateUserActual(request,response);
			break;	
		}
		
		
		
		
		
	}

	private void UpdateUserActual(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter impresion=response.getWriter();
		HttpSession user=request.getSession();
		String usuario=(String) user.getAttribute("SessionLive");
		Usuario objuser=new Usuario
		(
		usuario,
		request.getParameter("nombre").toString(),
		request.getParameter("apellido").toString(),
		request.getParameter("codpregunta").toString(),
		request.getParameter("respuesta").toString(),
		request.getParameter("fecha").toString()
		
				);
		if(new models_usuario().ActualizarDatosUsuarioExceptoPassword(objuser)==1) {
			impresion.write("<span style='color:royalblue'>Actualizacion Exitosa</span>");
		}
		
		if(new models_usuario().ActualizarDatosUsuarioExceptoPassword(objuser)==0) {
			impresion.write("<span style='color:red'>Actualizacion Fallida</span>");
			}
	}


	private void OpcionesPie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		
		response.setContentType("text/plain");
		PrintWriter impresionado=response.getWriter();
		
		switch(request.getParameter("parameter")) {
		case "GoTerminos":
			impresionado.write("<p>Punto 1. PROPIEDAD</p>\r\n" + 
					"<p>Esta web y su contenido es propiedad de ChoquePelis.</p>\r\n" + 
					"\r\n" + 
					"<p>Punto 2. USOS PERMITIDOS Y LIMITACIONES DE LA INFORMACI�N</p>\r\n" + 
					"<p>Todo el material gr�fico que aparece en este web (gr�ficos, im�genes, botones, etc) es propiedad de ChoquePelis, y su uso en esta web es meramente informativo, para consulta. En ning�n momento se permite el uso divulgativo, copia o conservar el material de forma alguna. Todas las Im�genes est�n protegidas por las leyes de copyright internacionales.</p>\r\n" + 
					"\r\n" + 
					"<p>Punto 3. PROTECCI�N DE DERECHOS</p>\r\n" + 
					"<p>Queda completamente prohibido guardar, conservar o copiar de forma alguna, ya sea digital o f�sicamente, las im�genes expuestas en el web. Se proh�be cualquier uso de esta im�genes que no sea la mera consulta y visualizaci�n desde nuestro web. En ning�n caso se permite utilizar las im�genes con fines comerciales.<p>\r\n" + 
					"\r\n" + 
					"ChoquePelis se reserva el derecho de cancelar los permisos otorgados y/o licencias al usuario si este no acepta las clausulas de uso de este sitio web. ChoquePelis podr� limitar o eliminar la posibilidad de acceso al web y el usuario estar� obligado a borrar de su equipo cualquier gr�fico o material perteneciente a ChoquePelis</p>.\r\n" + 
					"\r\n" + 
					"<p>Punto 4. FIDELIDAD DE LA INFORMACI�N</p>\r\n" + 
					"<p>A pesar del esfuerzo que ponemos en la realizaci�n del web, este puede contener errores tipogr�ficos, por lo que recomendamos al usuario cerciorarse o consultar los datos que le parezcan en el servicio de atenci�n al cliente al efecto.\r\n" + 
					"\r\n" + 
					"En ning�n caso la informaci�n ofrecida en esta web es contractual. Esta informaci�n puede contener errores o inexactitudes. Por favor, contacte con nosotros para confirmar que la informaci�n obtenida en esta web est� vigente y es correcta.</p>");
			break;
		case "GoMapa":
			impresionado.write("  <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3902.912545485149!2d-77.00761298536553!3d-11.980553091511394!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c5639b5e5631%3A0x92e4873e7f233e35!2sCibertec!5e0!3m2!1ses-419!2spe!4v1561622024367!5m2!1ses-419!2spe\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\r\n" + 
					"               ");
			break;
		case "GoPrivacidad":
				impresionado.write("<p>Recopilaci�n de la informaci�n</p>\r\n" + 
						"<p>Recibimos y almacenamos informaci�n sobre usted, incluida:</p>\r\n" + 
						"\r\n" + 
						"<p>La informaci�n que usted nos proporciona: Recopilamos la informaci�n que usted nos brinda, que incluye:</p>\r\n" + 
						"<p>su nombre, email, direcci�n o c�digo postal, formas de pago y n�mero de tel�fono. En algunos pa�ses, solicitamos un n�mero de identificaci�n gubernamental para la facturaci�n y el cumplimiento de normas impositivas. Esta informaci�n se recopila de diferentes maneras, entre ellas, cuando usted la introduce en nuestro servicio, al interactuar con nuestro servicio al cliente, o al participar en encuestas o promociones de marketing;\r\n" + 
						"la informaci�n recopilada cuando usted elige proporcionar calificaciones o preferencias, configura las preferencias (en la secci�n \"Cuenta\" de nuestro sitio web) o nos brinda informaci�n mediante nuestro servicio o de otros medios.</p>\r\n" + 
						"<p>La informaci�n que recopilamos autom�ticamente: Recopilamos informaci�n con relaci�n a usted, el uso de nuestro servicio, sus interacciones con nosotros y nuestra publicidad, adem�s de aquella informaci�n relacionada con su computadora o cualquier dispositivo que utilice para acceder a nuestro servicio (como los sistemas de videojuegos, Smart TV, dispositivos m�viles, decodificadores y otros dispositivos multimedia). Esta informaci�n incluye:</p>\r\n" + 
						"<p>detalles sobre sus interacciones con el servicio al cliente, como la fecha, hora, raz�n de la consulta.</p>");
			break;
		case "GoContacto":
			impresionado.write("<p>Contacto Soporte : </p>");
			impresionado.write("<p>choquepelis@gmail.com\r\n" + 
					"</p>");
			impresionado.write("<p>Si tiene preguntas generales sobre su cuenta o c�mo ponerse en contacto con nuestro servicio al cliente para obtener asistencia.</p>");
		break;	
		}
		
	
	}

	private void ActualizarPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter impresionado=response.getWriter();
	
		int validador=new models_Pregunta_Seguridad().CambioPassword(request.getParameter("pass"),
				request.getParameter("userid"),request.getParameter("resp"));
		if(validador==1) {
			impresionado.write("<p style='color:royalblue'>Cambio exitoso</p>");
		}
		if(validador==0) {
			impresionado.write("<p style='color:red'>Cambio fallido</p>");
		}
		
	}

	private void TraerPassSeguridad(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter impresionado=response.getWriter();
		
		String encodePass=new models_Pregunta_Seguridad().EncodePassUserPregSeg(request.getParameter("resp"),request.getParameter("userid"));
		
		if(encodePass.length()>0) {
				
				impresionado.write(" <label for=\"\">Contrase�a cifrada : </label><input type=\"text\" class=\"inputrenew\" readonly=\"readonly\" value=\""+encodePass+"\"  disabled=\"disabled\">\r\n" + 
						"        <label for=\"\">Nueva Contrase�a : </label>\r\n" + 
						"           \r\n" + 
						"           <div class=\"cajapass\">\r\n" + 
						"         <input type=\"password\" class=\"inputrenew nueva\" onkeyup=\"TextoNuevaContra()\" id=\"passwordnuevo\">\r\n" + 
						"        <div class=\"verificacionkey\">\r\n" + 
						"        <i class=\"fas fa-check okey\"></i>\r\n" + 
						"        </div>\r\n" + 
						"        </div>\r\n" + 
						"        \r\n" + 
						"        <label for=\"\">Repite Contrase�a : </label>\r\n" + 
						"        <div class=\"cajapass\">\r\n" + 
						"          <input type=\"password\" class=\"inputrenew repiten\" onkeyup=\"TextoRepiteContra()\" id=\"passwordrepite\" placeholder=\"Campo Obligatorio\">\r\n" + 
						"           <div class=\"verificacioncancel\">\r\n" + 
						"         \r\n" + 
						"       <i class=\"fas fa-times cancela\"></i>\r\n" + 
						"        </div>    \r\n" + 
						"        </div>\r\n" + 
						"        <div class=\"botonGC\">\r\n" + 
						"         <input type=\"button\" onclick=\"releasePassword()\" value=\"Guardar Cambios\" class=\"guardarcambios\" title=\"Importante validar datos\">\r\n" + 
						"        </div>");
			
		}
		else {
			impresionado.write("<p>La respuesta no es correcta , Intenta de nuevo</p>");
		}

	
	}

	private void EncontrarPreguntaSeguridad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String user=request.getParameter("userid");
		response.setContentType("text/plain");
		PrintWriter impresionado=response.getWriter();
		
		String pregunta=new models_Pregunta_Seguridad().ConsultarUsuarioParaPregSegMetodo(user);
		
		
		if(pregunta.length()>0) {
			impresionado.write("     <input type=\"text\" readonly=\"readonly\" disabled value=\""+pregunta+"\" class=\"recpregunta\">\r\n" + 
					"            <input type=\"text\" class=\"recprespuesta\" name=\"respuestapregunta\" id=\"respuestapregunta\" placeholder=\"Responde\">\r\n" + 
					"            \r\n" + 
					"            <button onclick=\"ValidarPregunta()\" class=\"botonvalidarpregunta\">Validar Pregunta</button>\r\n" + 
					"        \r\n" + 
					"        \r\n" + 
					"        ");
		}
		if(new models_Pregunta_Seguridad().ConsultarUsuarioParaPregSegMetodo(user).equals("")) {
			
		impresionado.write("<p>No existe tal usuario , Intenta de nuevo<p>");
		}
		/*
		impresionado.write("<ul>");
		impresionado.write("<li>"+new models_Pregunta_Seguridad().ConsultarUsuarioParaPregSegMetodo(user).getDescrpSeguridad()+"</li>");
		impresionado.write("</ul>");
		*/
		
		
		
	}


	
	private void CrearNuevaCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter impresion=response.getWriter();		
		Usuario objuser=new Usuario
		(
		request.getParameter("use").toString(),
		request.getParameter("passw").toString(),
		request.getParameter("nomb").toString(),
		request.getParameter("apelli").toString(),
		request.getParameter("pregu").toString(),
		request.getParameter("resp").toString(),
		request.getParameter("fech").toString()
		);
		new models_usuario().AgregarUsuario(objuser);
		
		if(new models_usuario().valEstadoUser(request.getParameter("use"))==true) {
			impresion.write("Usuario Creado con exito");
		}
		if(new models_usuario().valEstadoUser(request.getParameter("use"))==false) {
			impresion.write("No se creo el usuario,valida por favor");
		}
		
		
	}

	private void ValidarEstadoNuevoUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/plain");
		PrintWriter impresion=response.getWriter();
		String parametro=request.getParameter("parameter");
		
		if(new models_Access_Login().ValidarCreacionUsuario(parametro)==true){
			impresion.write("<span class=\"RepeatUserCreate\" id=\"valorspanval\">Usuario,ya existe</span>");
		}	
		if(new models_Access_Login().ValidarCreacionUsuario(parametro)==false) {
			impresion.write("<span class=\"OkeyUserCreate\" id=\"valorspanval\">Usuario Correcto</span>");
				
		}
	
		
		
	}

	private void IniciarSessionGo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usuario=request.getParameter("user");
		String pass=request.getParameter("passw");
		
		if(new models_Access_Login().ValidarSession(usuario,pass)==true ) {
			System.out.println("usuario log");
			
			HttpSession ses=request.getSession();
			ses.setAttribute("SessionLive", usuario);
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
			
		}
		else {
			
			String mensaje="Tus credenciales no son las correctas , corrigelas .";
			request.setAttribute("msjerror",mensaje);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			/*
			
			PrintWriter escribir=response.getWriter();
			escribir.write("<html><head><script>alert('Usuario Incorrecto Intenta de nuevo');window.location.href='Login.jsp';</script></head><body>/body></html>");
			//response.sendRedirect("https://www.youtube.com/watch?v=J-gYJBsln-w");
		*/
		}
	}
}
