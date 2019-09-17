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

import Models.models_BD_Peliculas;
import Models.models_Categoria;
import Models.models_usuario;
import Entidades.Categoria;
import Entidades.Pelicula;
import Entidades.Usuario;
/**
 * Servlet implementation class ListadoPeliculas
 */
@WebServlet("/ListadoPeliculas")
public class ListadoPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoPeliculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vacio=request.getParameter("vacioIndex");
		
		
		switch(vacio) {
		case "TraerPeliculas":
			ListarPeliculas(request,response);
			break;
		case "QuitPel":
			DesagregarPelicula(request,response);
			break;
		case "AddPel":
			AgregarPelicula(request,response);
			break;
		case "TraerFiltroCatAño":
			TraerCategorias(request,response);
			break;
		case "TraerBotonesFiltrosCatAño":	
			TrerBotonesFiltroCatFecha(request,response);
			break;
		case "filtercategory":
			FiltrarXCategorias(request,response);
			break;
		case "filterfecha":
			FiltrarXFecha(request,response);
			break;
		case "filterCat":
			SubMenuCategoriaFiltroCategoria(request,response);
			break;
		case "filteryear":
			SubMenuCategoriaFiltroAño(request,response);
			break;
		case "FiltroQuitPel":
			FiltroQuitPel(request,response);
			break;
		case "FiltroAddPel":
			FiltroAddPel(request,response);
			break;
		case "BloqueActualizarUsuario":
			BloqueParaActualizar(request,response);
			break;
		case "BloqueRecuperarPassword":
			BloqueRecuperarPassw(request,response);
			break;
		
		}
		
		
		
		
		
	}
	

	private void BloqueRecuperarPassw(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter imprimir=response.getWriter();
		
		
		imprimir.write("<iframe src=\"LoginCopia.jsp\" width=\"90%\" height=\"auto\"></iframe>");
		
		
	}

	private void BloqueParaActualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter imprimir=response.getWriter();
		
		HttpSession user=request.getSession();
		String usuario=(String) user.getAttribute("SessionLive");
		Usuario userActual=new models_usuario().ObtenerObjetoUsuario(usuario);
		
		
		imprimir.write(" <div class=\"contenedorUsuarioPrincipal\">\r\n" + 
				"                  <div class=\"contenedorRegister2\">\r\n" + 
				"                            \r\n" + 
				"                            \r\n" + 
				"         <!-- REGISTRAR CUENTA  -->                   \r\n" + 
				"                            \r\n" + 
				"     <div class=\"LogTitle\">\r\n" + 
				"    <a href=\"#\">Choque<span>Pelis</span></a>\r\n" + 
				"    </div>                        \r\n" + 
				"    <div class=\"registerusuario\">\r\n" + 
				"        <label for=\"\">Usuario Actual : </label><input type=\"text\" value=\""+usuario+"\" disabled readonly  name=\"regusuario\" id=\"regusuario\" placeholder=\"Usuario o apodo\" onkeyup=\"ValidaCreacionUsuario()\">\r\n" + 
				"  		   <div class=\"validarUserCreate\" id=\"validarUserCreateid\">\r\n" + 
				"     \r\n" + 
				"\r\n" + 
				"     </div>\r\n" + 
				"    </div>\r\n" + 
				"  \r\n" + 
				"    <div class=\"registernombre\">\r\n" + 
				"        <label for=\"\">Nombres : </label>\r\n" + 
				"            <input type=\"text\" name=\"regnombre\" value=\""+userActual.getNomusuario()+"\" id=\"regnombre\" >\r\n" + 
				"    </div>                   <div class=\"registerapellido\">\r\n" + 
				"       <label for=\"\">Apellidos : </label>\r\n" + 
				"        <input type=\"text\" name=\"regapellido\" id=\"regapellido\" value=\""+userActual.getApellido()+"\" >\r\n" + 
				"    </div>\r\n" + 
				"         \r\n" + 
				"    <div class=\"registercod\" id=\"registercodidbloque\">\r\n" + 
				"       <!-- CARGAR SELECT  -->\r\n" + 
				"       <label for=\"\">Pregunta Seguridad : </label>\r\n" + 
				"      <select name=\"codSeguridad\" id=\"codSeguridadid\">\r\n" + 
				"			<option  disabled=\"disabled\" value=\""+userActual.getCodigoSeguridad()+"\" selected=\"selected\" >"+userActual.getDescripSeguridad()+"</option>\r\n" + 
				"       		<option value=\"pre01\">¿Cual es tu plato favorito?</option>\r\n" + 
				"       		<option value=\"pre02\">¿Cual es tu lugar favorito?</option>\r\n" + 
				"       		<option value=\"pre03\">¿Cual es el nombre de tu mascota?</option>\r\n" + 
				"       		<option value=\"pre04\">¿En que lugar haz nacido?</option>\r\n" + 
				"       		<option value=\"pre05\">¿Cual es tu apodo?</option>\r\n" + 
				"    </select>\r\n" + 
				"    </div> \r\n" + 
				"    <div class=\"registerrespuesta\">\r\n" + 
				"        <label for=\"\">Respuesta de seguridad : </label>\r\n" + 
				"        <input type=\"text\" name=\"regrespuesta\" value=\""+userActual.getRespseguridad()+"\" id=\"regrespuesta\" placeholder=\"Respuesta de seguridad\">\r\n" + 
				"    </div>                 \r\n" + 
				"    <div class=\"registerfecha\">\r\n" + 
				"       <label for=\"\">Fecha : </label>\r\n" + 
				"        <input type=\"date\" value=\""+userActual.getFechanac()+"\" name=\"regfecha\" id=\"regfecha\">\r\n" + 
				"    </div>    \r\n" + 
				"      <div class=\"registerregistrar\">\r\n" + 
				"         \r\n" + 
				"          <input type=\"button\" value=\"Actualizar\" class=\"registraruser\" id=\"RegistrarUnaCuenta\" onclick=\"ModificarCuenta()\">\r\n" + 
				"      \r\n" + 
				"      </div>\r\n" + 
				"      \r\n" + 
				"     <!-- TERMINA BLOQUE DE CREACION DE CUENTA -->\r\n" + 
				"      \r\n" + 
				"      <p id=\"msjcuenta\" class=\"mensajeActualizar\">\r\n" + 
				
				"      </p>  \r\n" + 
				"                                     \r\n" + 
				"                            </div>\r\n" + 
				"            \r\n" + 
				"        </div>\r\n" + 
				"        ");
		
		
	}

	private void FiltroAddPel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String fecha=request.getParameter("filtro");
		PrintWriter imprimir=response.getWriter();
		
		String codpelicula=request.getParameter("codigopel");
		HttpSession sessionactual=request.getSession();
		String usuario=(String)sessionactual.getAttribute("SessionLive");
		new models_BD_Peliculas().AgregarPeliculaXUsuario(usuario,codpelicula);
		imprimir.write("<p style='display:flex;justify-content:center;'>Se agrego con exito la pelicula , vuelve a seleccionar tu filtro </p>");		
		//response.sendRedirect("");
		
	}

	private void FiltroQuitPel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String fecha=request.getParameter("filtro");
		PrintWriter imprimir=response.getWriter();
		
		String codpelicula=request.getParameter("codigopel");
		HttpSession sessionactual=request.getSession();
		String usuario=(String)sessionactual.getAttribute("SessionLive");
		new models_BD_Peliculas().DesagregarPeliculaXUsuario(usuario,codpelicula);
		//FiltrarXCategorias(request,response);
		imprimir.write("<p style='display:flex;justify-content:center;'>Se quito con exito la pelicula , vuelve a Seleccionar tu filtro</p>");	
	}

	private void SubMenuCategoriaFiltroAño(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fecha=request.getParameter("filtro");
		
		
		
		request.setAttribute("LinkFiltroAño",fecha);
		request.getRequestDispatcher("Filtroañocat.jsp").forward(request, response);
	}

	private void SubMenuCategoriaFiltroCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String categoriaLink=request.getParameter("filtro");
		
		request.setAttribute("LinkFiltroCategorias",categoriaLink);
		
		
		request.getRequestDispatcher("Filtroañocat.jsp").forward(request, response);
		//System.out.println("waaaaaaa"+categoriaLink);
	}

	private void FiltrarXFecha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/plain");
		int codcategory=Integer.parseInt(request.getParameter("catg"));
		List<Pelicula>ObtListPel=new models_Categoria().FiltroXFecha(codcategory);
		PrintWriter imprimir=response.getWriter();
		HttpSession ses=request.getSession();
		String usuarioactual=(String)ses.getAttribute("SessionLive");
		for (Pelicula item : ObtListPel) {
			
			if(new models_BD_Peliculas().ValidarEstado(usuarioactual, item.getCodpelicula())==true) {
				imprimir.write("    <div class=\"vistapelicula\">\r\n" + 
						"                <div class=\"tarjeta_wrap\">\r\n" + 
						"            <div class=\"tarjeta\">\r\n" + 
						"                <div class=\"adelante\">\r\n" + 
						"                    <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"imagen_adelante\">\r\n" + 
						"<div class=\"recuadroIconoAdd\">\r\n"+
					       
				        "<i class=\"fas fa-eye iconoVisto\"></i>\r\n"+
				        "</div>\r\n "+   
						"                </div>\r\n" + 
						"                <div class=\"atras\">\r\n" + 
						"                    <div class=\"botones\" id=\"botons\">\r\n" + 
						"                        \r\n" + 
														
				
						
						"                               <button id=\"EnviarInformacion\" class='boton_quitar' onclick=\"QuitarPelicula(codpel='"+item.getCodpelicula()+"')\">Click para desagregar</button>\r\n" + 
						"                               \r\n" + 
						
						"                    </div>\r\n" + 
						
      						" <div class=\"descripcion\">"+"Descripcion : "+item.getMinidescripcion()+"<br><a class='linkDirecto' href='SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search'>Ver Pelicula <i class=\"far fa-play-circle iconLinkGoFast\"></i></a></div>\r\n" +  
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            \r\n" + 
						"        </div>\r\n" + 
						"              <div class=\"titulopel\">\r\n" + 
						"               <p>"+item.getNompelicula()+"</p>\r\n" + 
						"                </div>\r\n" + 
						"                </div> ");
			}
			else {
				imprimir.write("    <div class=\"vistapelicula\">\r\n" + 
						"                <div class=\"tarjeta_wrap\">\r\n" + 
						"            <div class=\"tarjeta\">\r\n" + 
						"                <div class=\"adelante\">\r\n" + 
						"                    <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"imagen_adelante\">\r\n" + 
						"<div class=\"recuadroIconoQuit\">\r\n"+
					       
				        "<i class=\"fas fa-eye-slash iconoFalta\"></i>\r\n"+
				        "</div>\r\n "+  
						"                </div>\r\n" + 
						"                <div class=\"atras\">\r\n" + 
						"                    <div class=\"botones\" id=\"botons\">\r\n" + 
						"                        \r\n" + 
						                        
					
						"                               <button id=\"EnviarInformacion\" class='boton_agregar' onclick=\"AgregarPel(codpel='"+item.getCodpelicula()+"')\">Click para Añadir</button>\r\n" + 
						"                               \r\n" + 
						
						"                    </div>\r\n" + 
						" <div class=\"descripcion\">"+"Descripcion : "+item.getMinidescripcion()+"<br><a class='linkDirecto' href='SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search'>Ver Pelicula <i class=\"far fa-play-circle iconLinkGoFast\"></i></a></div>\r\n" +   
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            \r\n" + 
						"        </div>\r\n" + 
						"              <div class=\"titulopel\">\r\n" + 
						"               <p>"+item.getNompelicula()+"</p>\r\n" + 
						"                </div>\r\n" + 
						"                </div> ");
			}
			
			
		}
		
		
		
		
		
	}

	private void FiltrarXCategorias(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String codcategory=request.getParameter("catg");
		List<Pelicula>ObtListPel=new models_Categoria().FiltroXCategorias(codcategory);
		
		PrintWriter imprimir=response.getWriter();
		HttpSession ses=request.getSession();
		String usuarioactual=(String)ses.getAttribute("SessionLive");
		
		for (Pelicula item : ObtListPel) {
			
			if(new models_BD_Peliculas().ValidarEstado(usuarioactual, item.getCodpelicula())==true) {
				imprimir.write("    <div class=\"vistapelicula\">\r\n" + 
						"                <div class=\"tarjeta_wrap\">\r\n" + 
						"            <div class=\"tarjeta\">\r\n" + 
						"                <div class=\"adelante\">\r\n" + 
						"                    <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"imagen_adelante\">\r\n" + 
						"<div class=\"recuadroIconoAdd\">\r\n"+
					       
				        "<i class=\"fas fa-eye iconoVisto\"></i>\r\n"+
				        "</div>\r\n "+   
						"                </div>\r\n" + 
						"                <div class=\"atras\">\r\n" + 
						"                    <div class=\"botones\" id=\"botons\">\r\n" + 
						"                        \r\n" + 
														
				
						
						"                               <button id=\"EnviarInformacion\" class='boton_quitar' onclick=\"QuitarPelicula(codpel='"+item.getCodpelicula()+"')\">Click para desagregar</button>\r\n" + 
						"                               \r\n" + 
						
						"                    </div>\r\n" + 
						
      						" <div class=\"descripcion\">"+"Descripcion : "+item.getMinidescripcion()+"<br><a class='linkDirecto' href='SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search'>Ver Pelicula <i class=\"far fa-play-circle iconLinkGoFast\"></i></a></div>\r\n" +  
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            \r\n" + 
						"        </div>\r\n" + 
						"              <div class=\"titulopel\">\r\n" + 
						"               <p>"+item.getNompelicula()+"</p>\r\n" + 
						"                </div>\r\n" + 
						"                </div> ");
			}
			else {
				imprimir.write("    <div class=\"vistapelicula\">\r\n" + 
						"                <div class=\"tarjeta_wrap\">\r\n" + 
						"            <div class=\"tarjeta\">\r\n" + 
						"                <div class=\"adelante\">\r\n" + 
						"                    <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"imagen_adelante\">\r\n" + 
						"<div class=\"recuadroIconoQuit\">\r\n"+
					       
				        "<i class=\"fas fa-eye-slash iconoFalta\"></i>\r\n"+
				        "</div>\r\n "+  
						"                </div>\r\n" + 
						"                <div class=\"atras\">\r\n" + 
						"                    <div class=\"botones\" id=\"botons\">\r\n" + 
						"                        \r\n" + 
						                        
					
						"                               <button id=\"EnviarInformacion\" class='boton_agregar' onclick=\"AgregarPel(codpel='"+item.getCodpelicula()+"')\">Click para Añadir</button>\r\n" + 
						"                               \r\n" + 
						
						"                    </div>\r\n" + 
						" <div class=\"descripcion\">"+"Descripcion : "+item.getMinidescripcion()+"<br><a class='linkDirecto' href='SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search'>Ver Pelicula <i class=\"far fa-play-circle iconLinkGoFast\"></i></a></div>\r\n" +   
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            \r\n" + 
						"        </div>\r\n" + 
						"              <div class=\"titulopel\">\r\n" + 
						"               <p>"+item.getNompelicula()+"</p>\r\n" + 
						"                </div>\r\n" + 
						"                </div> ");
			}
			
			
		}
		
		
		
		
	}

	private void TrerBotonesFiltroCatFecha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter impresion=response.getWriter();
		
		impresion.write("<div class=\"filtrocategoria\" id=\"vas\">\r\n" + 
				"    <p class=\"pero\">Listado de Categorias</p>"
				+ "<div class=\"grupobotones\">");
		for(Categoria item: new models_Categoria().ListaCategoria()) {
			
	impresion.write(" <button  id='botonesfiltro' onclick=\"BusquedaXCategoria(parameter='"+item.getCodCategoria()+"',nomcateg='"+item.getNomCategoria()+"')\" class=\"EnvioFiltroCat botoncat\">"+item.getNomCategoria()+"</button>");
		}
		impresion.write("</div>       \r\n" + 
				"                </div>\r\n" + 
				"				<div class=\"filtroaño\">\r\n" + 
				"				<p>Año de estrenos</p>\r\n" + 
				"				<div class=\"grupobotones2\">");
			
		for(Pelicula item:new models_Categoria().ListaAñoParaUlCategoria()) {
			impresion.write("<button id='botonesfiltro' onclick=\"BusquedaXFecha(parameter='"+item.getSoloañoestreno()+"')\"  class=\"EnvioFiltroFecha botoncat\">"+item.getSoloañoestreno()+"</button>");
		}
		
			impresion.write("        </div>\r\n" + 
					"				</div>");
		
		
	
	}

	private void TraerCategorias(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		
		PrintWriter impresion=response.getWriter();
		for(Categoria item: new models_Categoria().ListaCategoria()) {
			
			impresion.write("   <li><a href=\"ListadoPeliculas?vacioIndex=filterCat&nomcat="+item.getNomCategoria()+"&filtro="+item.getCodCategoria()+"\">\r\n" + 
					"                       "+item.getNomCategoria()+"\r\n" + 
					"                    </a></li>");
			
		}
		for(Pelicula item:new models_Categoria().ListaAñoParaUlCategoria())
			impresion.write("   <li><a href=\"ListadoPeliculas?vacioIndex=filteryear&filtro="+item.getSoloañoestreno()+"\">\r\n" + 
					"                       "+item.getSoloañoestreno()+"\r\n" + 
					"                    </a></li>");
		
	}

	private void AgregarPelicula(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String codpelicula=request.getParameter("codigopel");
		HttpSession sessionactual=request.getSession();
		String usuario=(String)sessionactual.getAttribute("SessionLive");
		new models_BD_Peliculas().AgregarPeliculaXUsuario(usuario,codpelicula);
		ListarPeliculas(request,response);
		
	}

	private void DesagregarPelicula(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String codpelicula=request.getParameter("codigopel");
		HttpSession sessionactual=request.getSession();
		String usuario=(String)sessionactual.getAttribute("SessionLive");
		new models_BD_Peliculas().DesagregarPeliculaXUsuario(usuario,codpelicula);
		ListarPeliculas(request,response);
		

		
		
	}
/*
 * utilizar siguientes fuentes
 * fa5-proxima-nova,"Helvetica Neue",Helvetica,Arial,sans-serif;
 * 
 * */
	
	private void ListarPeliculas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		List<Pelicula>ObtListPel=new models_BD_Peliculas().ObtenerListaPeliculas();
		
		PrintWriter imprimir=response.getWriter();
		HttpSession ses=request.getSession();
		String usuarioactual=(String)ses.getAttribute("SessionLive");
		for (Pelicula item : ObtListPel) {
			
			if(new models_BD_Peliculas().ValidarEstado(usuarioactual, item.getCodpelicula())==true) {
				imprimir.write("    <div class=\"vistapelicula\">\r\n" + 
						"                <div class=\"tarjeta_wrap\">\r\n" + 
						"            <div class=\"tarjeta\">\r\n" + 
						"                <div class=\"adelante\">\r\n" + 
						"                    <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"imagen_adelante\">\r\n" + 
						"<div class=\"recuadroIconoAdd\">\r\n"+
					       
				        "<i class=\"fas fa-eye iconoVisto\"></i>\r\n"+
				        "</div>\r\n "+   
						"                </div>\r\n" + 
						"                <div class=\"atras\">\r\n" + 
						"                    <div class=\"botones\" id=\"botons\">\r\n" + 
						"                        \r\n" + 
														
				
						
						"                               <button id=\"EnviarInformacion\" class='boton_quitar' onclick=\"QuitarPelicula(codpel='"+item.getCodpelicula()+"')\">Click para desagregar</button>\r\n" + 
						"                               \r\n" + 
						
						"                    </div>\r\n" + 
						
      						" <div class=\"descripcion\">"+"Descripcion : "+item.getMinidescripcion()+"<br><a class='linkDirecto' href='SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search'>Ver Pelicula <i class=\"far fa-play-circle iconLinkGoFast\"></i></a></div>\r\n" +  
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            \r\n" + 
						"        </div>\r\n" + 
						"              <div class=\"titulopel\">\r\n" + 
						"               <p>"+item.getNompelicula()+"</p>\r\n" + 
						"                </div>\r\n" + 
						"                </div> ");
			}
			else {
				imprimir.write("    <div class=\"vistapelicula\">\r\n" + 
						"                <div class=\"tarjeta_wrap\">\r\n" + 
						"            <div class=\"tarjeta\">\r\n" + 
						"                <div class=\"adelante\">\r\n" + 
						"                    <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"imagen_adelante\">\r\n" + 
						"<div class=\"recuadroIconoQuit\">\r\n"+
					       
				        "<i class=\"fas fa-eye-slash iconoFalta\"></i>\r\n"+
				        "</div>\r\n "+  
						"                </div>\r\n" + 
						"                <div class=\"atras\">\r\n" + 
						"                    <div class=\"botones\" id=\"botons\">\r\n" + 
						"                        \r\n" + 
						                        
					
						"                               <button id=\"EnviarInformacion\" class='boton_agregar' onclick=\"AgregarPel(codpel='"+item.getCodpelicula()+"')\">Click para Añadir</button>\r\n" + 
						"                               \r\n" + 
						
						"                    </div>\r\n" + 
						" <div class=\"descripcion\">"+"Descripcion : "+item.getMinidescripcion()+"<br><a class='linkDirecto' href='SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search'>Ver Pelicula <i class=\"far fa-play-circle iconLinkGoFast\"></i></a></div>\r\n" +   
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            \r\n" + 
						"        </div>\r\n" + 
						"              <div class=\"titulopel\">\r\n" + 
						"               <p>"+item.getNompelicula()+"</p>\r\n" + 
						"                </div>\r\n" + 
						"                </div> ");
			}
			
			
		}
		
	
	}

}
