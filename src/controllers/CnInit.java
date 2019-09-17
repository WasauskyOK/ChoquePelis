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
					"<p>Punto 2. USOS PERMITIDOS Y LIMITACIONES DE LA INFORMACIÓN</p>\r\n" + 
					"<p>Todo el material gráfico que aparece en este web (gráficos, imágenes, botones, etc) es propiedad de ChoquePelis, y su uso en esta web es meramente informativo, para consulta. En ningún momento se permite el uso divulgativo, copia o conservar el material de forma alguna. Todas las Imágenes están protegidas por las leyes de copyright internacionales.</p>\r\n" + 
					"\r\n" + 
					"<p>Punto 3. PROTECCIÓN DE DERECHOS</p>\r\n" + 
					"<p>Queda completamente prohibido guardar, conservar o copiar de forma alguna, ya sea digital o físicamente, las imágenes expuestas en el web. Se prohíbe cualquier uso de esta imágenes que no sea la mera consulta y visualización desde nuestro web. En ningún caso se permite utilizar las imágenes con fines comerciales.<p>\r\n" + 
					"\r\n" + 
					"ChoquePelis se reserva el derecho de cancelar los permisos otorgados y/o licencias al usuario si este no acepta las clausulas de uso de este sitio web. ChoquePelis podrá limitar o eliminar la posibilidad de acceso al web y el usuario estará obligado a borrar de su equipo cualquier gráfico o material perteneciente a ChoquePelis</p>.\r\n" + 
					"\r\n" + 
					"<p>Punto 4. FIDELIDAD DE LA INFORMACIÓN</p>\r\n" + 
					"<p>A pesar del esfuerzo que ponemos en la realización del web, este puede contener errores tipográficos, por lo que recomendamos al usuario cerciorarse o consultar los datos que le parezcan en el servicio de atención al cliente al efecto.\r\n" + 
					"\r\n" + 
					"En ningún caso la información ofrecida en esta web es contractual. Esta información puede contener errores o inexactitudes. Por favor, contacte con nosotros para confirmar que la información obtenida en esta web está vigente y es correcta.</p>");
			break;
		case "GoMapa":
			impresionado.write("  <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3902.912545485149!2d-77.00761298536553!3d-11.980553091511394!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c5639b5e5631%3A0x92e4873e7f233e35!2sCibertec!5e0!3m2!1ses-419!2spe!4v1561622024367!5m2!1ses-419!2spe\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\r\n" + 
					"               ");
			break;
		case "GoPrivacidad":
				impresionado.write("<p>Recopilación de la información</p>\r\n" + 
						"<p>Recibimos y almacenamos información sobre usted, incluida:</p>\r\n" + 
						"\r\n" + 
						"<p>La información que usted nos proporciona: Recopilamos la información que usted nos brinda, que incluye:</p>\r\n" + 
						"<p>su nombre, email, dirección o código postal, formas de pago y número de teléfono. En algunos países, solicitamos un número de identificación gubernamental para la facturación y el cumplimiento de normas impositivas. Esta información se recopila de diferentes maneras, entre ellas, cuando usted la introduce en nuestro servicio, al interactuar con nuestro servicio al cliente, o al participar en encuestas o promociones de marketing;\r\n" + 
						"la información recopilada cuando usted elige proporcionar calificaciones o preferencias, configura las preferencias (en la sección \"Cuenta\" de nuestro sitio web) o nos brinda información mediante nuestro servicio o de otros medios.</p>\r\n" + 
						"<p>La información que recopilamos automáticamente: Recopilamos información con relación a usted, el uso de nuestro servicio, sus interacciones con nosotros y nuestra publicidad, además de aquella información relacionada con su computadora o cualquier dispositivo que utilice para acceder a nuestro servicio (como los sistemas de videojuegos, Smart TV, dispositivos móviles, decodificadores y otros dispositivos multimedia). Esta información incluye:</p>\r\n" + 
						"<p>detalles sobre sus interacciones con el servicio al cliente, como la fecha, hora, razón de la consulta.</p>");
			break;
		case "GoContacto":
			impresionado.write("<p>Contacto Soporte : </p>");
			impresionado.write("<p>choquepelis@gmail.com\r\n" + 
					"</p>");
			impresionado.write("<p>Si tiene preguntas generales sobre su cuenta o cómo ponerse en contacto con nuestro servicio al cliente para obtener asistencia.</p>");
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
				
				impresionado.write(" <label for=\"\">Contraseña cifrada : </label><input type=\"text\" class=\"inputrenew\" readonly=\"readonly\" value=\""+encodePass+"\"  disabled=\"disabled\">\r\n" + 
						"        <label for=\"\">Nueva Contraseña : </label>\r\n" + 
						"           \r\n" + 
						"           <div class=\"cajapass\">\r\n" + 
						"         <input type=\"password\" class=\"inputrenew nueva\" onkeyup=\"TextoNuevaContra()\" id=\"passwordnuevo\">\r\n" + 
						"        <div class=\"verificacionkey\">\r\n" + 
						"        <i class=\"fas fa-check okey\"></i>\r\n" + 
						"        </div>\r\n" + 
						"        </div>\r\n" + 
						"        \r\n" + 
						"        <label for=\"\">Repite Contraseña : </label>\r\n" + 
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
