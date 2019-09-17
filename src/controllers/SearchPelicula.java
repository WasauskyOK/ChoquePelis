package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Pelicula;
import Models.models_search_pelicula;

/**
 * Servlet implementation class SearchPelicula
 */
@WebServlet("/SearchPelicula")
public class SearchPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				String vacioSearch=request.getParameter("vacioSearch");
				
				switch(vacioSearch) {
				case "busqueda":
					TrearOpcionesSearch(request,response);
					break;
				}
				
	}

	private void TrearOpcionesSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String nombrepelicula=request.getParameter("parametroPelicula");
		PrintWriter impresion=response.getWriter();
		
		for(Pelicula item:new models_search_pelicula().ObtenerBusquedas(nombrepelicula)) {
			impresion.print(" <a href=\"SelectMovie?moviename="+item.getNompelicula()+"&vacio_movie=search\" id=\"alink\">\r\n" + 
					"                  <div class=\"opcionescuadrobloque\">\r\n" + 
					"                   \r\n" + 
					"                    <div class=\"opcioncontenido1\">\r\n" + 
					"                        <img src=\"imagenes/"+item.getNombimagen()+".jpg\" alt=\"\" class=\"opcionimagen\">\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"opcioncontenido2\">\r\n" + 
					"                        \r\n" + 
					"                        <p class=\"opcioncontenido2titulo\">"+item.getNompelicula()+"</p>\r\n" + 
					"                        <span class=\"opcioncontenido2estreno\">"+item.getEstreno()+"</span>\r\n" + 
					"                        <p class=\"opcioncontenido2texto\">Dura <span class=\"opcioncontenido2duracion\">"+item.getDuracion()+"</span> .Puntuación: <span class=\"opcioncontenido2puntuacion\">"+item.getValoracion()+"</span></p>\r\n" + 
					"                    </div>\r\n" + 
					"                </div>\r\n" + 
					"                </a>");
		}
		
	}

}
