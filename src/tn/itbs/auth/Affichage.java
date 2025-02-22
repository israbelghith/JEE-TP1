package tn.itbs.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.itbs.Models.Produit;

/**
 * Servlet implementation class Affiche
 */
@WebServlet("/Affichage")
public class Affichage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Affichage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		  try {
	            // Charger le driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Connexion à la base de données (modifie les infos selon ton setup)
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authDB", "root", "");

	        } catch (Exception e) {
	        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String sql = "SELECT * FROM produits ";
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
        System.out.println("request works!!!");
        List<Produit> listprod=new ArrayList<Produit>();
        
        //mapping relational = orienté objet object relaitonal mapping(ORM)
        while (rs.next()) {
            listprod.add(new Produit(rs.getInt("id"),rs.getString("nom"),rs.getInt("quantite")));
              
        } 
        request.setAttribute("liste", listprod);
        request.getRequestDispatcher("affiche.jsp").forward(request, response);
         // response.sendRedirect("menu.jsp?result=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
