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

@WebServlet("/Traitement")
public class Traitement extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authDB", "root", "");
        } catch (Exception e) {
            throw new ServletException("Erreur de connexion à la base de données", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("nom") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String idStr = request.getParameter("id");
        String nom = request.getParameter("nom");
        String quantiteStr = request.getParameter("quantite");

        if (idStr == null || nom == null || quantiteStr == null || idStr.isEmpty() || nom.isEmpty() || quantiteStr.isEmpty()) {
            response.sendRedirect("Ajout.jsp?error=1");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int quantite = Integer.parseInt(quantiteStr);

            String sql = "INSERT INTO produits (id, nom, quantite) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nom);
            stmt.setInt(3, quantite);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("menu.jsp?success=1");
            } else {
                response.sendRedirect("Ajout.jsp?error=1");
            }

        } catch (Exception e) {
            response.sendRedirect("Ajout.jsp?error=1");
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("nom") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String idStr = request.getParameter("id");
        String quantiteStr = request.getParameter("quantite");

        if (idStr == null || quantiteStr == null || idStr.isEmpty() || quantiteStr.isEmpty()) {
            response.sendRedirect("Chercher.jsp?error=1");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int quantiteDemandee = Integer.parseInt(quantiteStr);

            String sql = "SELECT nom, quantite FROM produits WHERE id = ? and quantite >= ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2,quantiteDemandee);
            ResultSet rs = stmt.executeQuery();
            System.out.println("request works!!!");

            if (rs.next()) {
                String nomProduit = rs.getString("nom");
                int quantiteDisponible = rs.getInt("quantite");

             //   if (quantiteDisponible >= quantiteDemandee) {
                    session.setAttribute("nomP", nomProduit);
                    session.setAttribute("qte", quantiteDisponible-quantiteDemandee);
                    // Mise à jour de la quantité en base de données
                    String updateSQL = "UPDATE produits SET quantite = quantite - ? WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
                    updateStmt.setInt(1, quantiteDemandee);
                    updateStmt.setInt(2, id);
                    updateStmt.executeUpdate(); 
                    response.sendRedirect("menu.jsp?result=true");
               /* } else {
                    session.removeAttribute("nomP");
                    session.removeAttribute("qte");
                }*/
            } else {
                session.removeAttribute("nomP");
                session.removeAttribute("qte");
                response.sendRedirect("menu.jsp?result=false");
            }

           

        } catch (NumberFormatException e) {
            response.sendRedirect("Chercher.jsp?error=3");
        } catch (Exception e) {
            response.sendRedirect("Chercher.jsp?error=4");
        }
    }

    
    
    
    @Override
    public void destroy() {
        try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
