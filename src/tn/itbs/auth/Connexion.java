package tn.itbs.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn; // Attribut privé pour la connexion BD

    @Override
    public void init() throws ServletException {
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données (modifie les infos selon ton setup)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authDB", "root", "");

        } catch (Exception e) {
        }
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Vérifie si une session existe déjà

        //  Vérification si l'utilisateur est déjà connecté
        if (session != null && session.getAttribute("nom") != null) {
            response.sendRedirect("menu.jsp"); // Redirection si déjà authentifié
            return;
        }

        //  Récupération des identifiants du formulaire
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            response.sendRedirect("index.jsp?error=1");
            return;
        }

        try {
            //  Vérification des identifiants dans la base de données
            String sql = "SELECT nom FROM utilisateurs WHERE login = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);//compilation de req
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { 
                // L'utilisateur existe
                String nom = rs.getString("nom");

                // 4 Création de session et stockage du nom
                session = request.getSession();
                session.setAttribute("nom", nom);

                // Redirection vers menu.jsp
                response.sendRedirect("menu.jsp");

            } else {
                // L'utilisateur n'existe pas → Retour à index.jsp avec un message d'erreur
                response.sendRedirect("index.jsp?error=1");
            }

        } catch (Exception e) {
            throw new ServletException("Erreur lors de l'authentification", e);
        }
    }
       /* String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("admin".equals(login) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("nom", login);

            response.sendRedirect("menu.jsp");
        } else {
            response.sendRedirect("index.jsp?error=1");
        }*/
    

}
