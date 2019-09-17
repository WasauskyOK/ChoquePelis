package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CerrarSesion
 */
@WebServlet("/option_all_user")
public class ControlSessionAndUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlSessionAndUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vacioUsuarios=request.getParameter("vacioUsuario");
		switch(vacioUsuarios) {
		case "CloseSesion":
			CerrarLaSesion(request,response);
		break;
		}
		
		
		
	}

	private void CerrarLaSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		sesion.removeAttribute("SessionLive");
		sesion.invalidate();
		response.sendRedirect("Login.jsp");
	}

}
