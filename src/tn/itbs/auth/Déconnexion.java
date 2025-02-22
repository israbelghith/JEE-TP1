package tn.itbs.auth;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Déconnexion
 */
@WebServlet("/Déconnexion")
public class Déconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Déconnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la session en cours
        HttpSession session = request.getSession(false);

        // Supprimer la session si elle existe
        if (session != null) {
            session.invalidate();
        }

        // Rediriger vers la page d'accueil (index.jsp)
        response.sendRedirect("index.jsp");
    }
	

}
