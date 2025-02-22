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
 * Servlet implementation class D�connexion
 */
@WebServlet("/D�connexion")
public class D�connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D�connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // R�cup�rer la session en cours
        HttpSession session = request.getSession(false);

        // Supprimer la session si elle existe
        if (session != null) {
            session.invalidate();
        }

        // Rediriger vers la page d'accueil (index.jsp)
        response.sendRedirect("index.jsp");
    }
	

}
