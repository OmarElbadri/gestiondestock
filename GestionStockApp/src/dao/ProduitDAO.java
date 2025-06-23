package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Produit;

public class ProduitDAO {
    public static boolean ajouterProduit(Produit p) {
        Connection conn = Connexion.getConnection();
        if (conn == null) return false;

        try {
            String sql = "INSERT INTO produit (nom, prix, quantite) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());

            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
