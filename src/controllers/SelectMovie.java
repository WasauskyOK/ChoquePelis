package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.SetContextPropertiesRule;

import com.mysql.fabric.Response;

import Entidades.Pelicula;
import Models.models_BD_Peliculas;
import Models.models_usuario;

/**
 * Servlet implementation class SelectMovie
 */
@WebServlet("/SelectMovie")
public class SelectMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vacio_movies=request.getParameter("vacio_movie");
		switch(vacio_movies) {
		case "search":
			EjecutarPelicula(request,response);
			break;
		case "AgregarxBOTONAZUL":
			Agregarxbotonazul(request,response);
			break;
		case "QuitarxBOTONROJO":
			Quitarxbotonrojo(request,response);
			break;
		case "AddPel":
			AgregarPeliculaVistaActual(request,response);
			break;
		case "QuitPel":
			QuitarPeliculaVistaActual(request,response);
			break;
		case "CargarBloque3Relacion":
			CargarBloquePeliculasRelacionadas(request,response);
			break;
	
		}
		
		
	}
	
	private void Quitarxbotonrojo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String codpeliculas=request.getParameter("codigo");
		
		HttpSession sesion=request.getSession();
		String usuario=(String)sesion.getAttribute("SessionLive");
		new models_BD_Peliculas().DesagregarPeliculaXUsuario(usuario, codpeliculas);
		
		
	
		
		PrintWriter impresion=response.getWriter();
		impresion.write("<button id=\"EnviarInformacion\"  class=\"boton_agregar\" onclick=\"AgregarPelboton(codpelicula='"+codpeliculas+"')\">Click para Añadir<i class=\"fas fa-plus-square\"></button>");
	
		
	}

	private void Agregarxbotonazul(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String codpelicula=request.getParameter("codigo");
		HttpSession sesion=request.getSession();
		String usuario=(String)sesion.getAttribute("SessionLive");
		new models_BD_Peliculas().AgregarPeliculaXUsuario(usuario, codpelicula);
		PrintWriter impresion=response.getWriter();
		impresion.write("<button id=\"EnviarInformacion\" class=\"boton_quitar\" onclick=\"QuitarPelboton(codpelicula='"+codpelicula+"')\">Click para Quitar<i class=\"fas fa-minus-circle\"></button>");
		
	}

	private void CargarBloquePeliculasRelacionadas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String nomcategory=request.getParameter("nombrecategoria");
		List<Pelicula>ObtListPel=new models_BD_Peliculas().ObtenerListaPeliculasRelacionadas(nomcategory);
		
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
														
				
						
"                               <button id=\"EnviarInformacion\" class='boton_quitar' onclick=\"QuitarPeliculaActual(codpel='"+item.getCodpelicula()+"',nomcat='"+item.getNombCategoria()+"')\">Click para desagregar</button>\r\n" + 
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
						                        
					
				"                               <button id=\"EnviarInformacion\" class='boton_agregar' onclick=\"AgregarPeliculaActual(codpel='"+item.getCodpelicula()+"',nomcat='"+item.getNombCategoria()+"')\">Click para Añadir</button>\r\n" + 
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

	private void QuitarPeliculaVistaActual(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String codpelicula=request.getParameter("codigopel");
		HttpSession sesion=request.getSession();
		String usuario=(String)sesion.getAttribute("SessionLive");
		new models_BD_Peliculas().DesagregarPeliculaXUsuario(usuario, codpelicula);
		
		String nombrecategoria=request.getParameter("nomcategor");
		List<Pelicula>ObtListPel=new models_BD_Peliculas().ObtenerListaPeliculasRelacionadas(nombrecategoria);
		PrintWriter imprimir=response.getWriter();
		
for (Pelicula item : ObtListPel) {
			
	if(new models_BD_Peliculas().ValidarEstado(usuario, item.getCodpelicula())==true) {
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
												
		
				
"                               <button id=\"EnviarInformacion\" class='boton_quitar' onclick=\"QuitarPeliculaActual(codpel='"+item.getCodpelicula()+"',nomcat='"+item.getNombCategoria()+"')\">Click para desagregar</button>\r\n" + 
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
				                        
			
		"                               <button id=\"EnviarInformacion\" class='boton_agregar' onclick=\"AgregarPeliculaActual(codpel='"+item.getCodpelicula()+"',nomcat='"+item.getNombCategoria()+"')\">Click para Añadir</button>\r\n" + 
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

	private void AgregarPeliculaVistaActual(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String codpelicula=request.getParameter("codigopel");
		
		HttpSession sesion=request.getSession();
		String usuario=(String)sesion.getAttribute("SessionLive");
		new models_BD_Peliculas().AgregarPeliculaXUsuario(usuario, codpelicula);
		
		String nombrecategoria=request.getParameter("nomcategor");
		List<Pelicula>ObtListPel=new models_BD_Peliculas().ObtenerListaPeliculasRelacionadas(nombrecategoria);
		PrintWriter imprimir=response.getWriter();
		
for (Pelicula item : ObtListPel) {
			
	if(new models_BD_Peliculas().ValidarEstado(usuario, item.getCodpelicula())==true) {
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
												
		
				
"                               <button id=\"EnviarInformacion\" class='boton_quitar' onclick=\"QuitarPeliculaActual(codpel='"+item.getCodpelicula()+"',nomcat='"+item.getNombCategoria()+"')\">Click para desagregar</button>\r\n" + 
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
				                        
			
		"                               <button id=\"EnviarInformacion\" class='boton_agregar' onclick=\"AgregarPeliculaActual(codpel='"+item.getCodpelicula()+"',nomcat='"+item.getNombCategoria()+"')\">Click para Añadir</button>\r\n" + 
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

	private void EjecutarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nompel=request.getParameter("moviename");
		
		Pelicula objpel=new models_usuario().ObtenerListaPeliculaPorNombre(nompel);	
		
		

		request.setAttribute("ObjetoPelicula", objpel);
		
		request.getRequestDispatcher("/watchmovie.jsp").forward(request,response);
		
		
	}

}
