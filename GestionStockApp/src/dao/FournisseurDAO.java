import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Fournisseur;

public class FournisseurDAO {

    // méthode existante pour ajouter un fournisseur
    public static boolean ajouterFournisseur(Fournisseur f) {
        try {
            Connection conn = Connexion.getConnection();
            String sql = "INSERT INTO fournisseur (nom, adresse, telephone) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, f.getNom());
            ps.setString(2, f.getAdresse());
            ps.setString(3, f.getTelephone());

            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ méthode pour récupérer tous les fournisseurs
    public static List<Fournisseur> getAllFournisseurs() {
        List<Fournisseur> list = new ArrayList<>();

        try {
            Connection conn = Connexion.getConnection();
            String sql = "SELECT * FROM fournisseur";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fournisseur f = new Fournisseur(
                    rs.getString("nom"),
                    rs.getString("adresse"),
                    rs.getString("telephone")
                );
                f.setId(rs.getInt("id")); // méthode à ajouter dans Fournisseur.java
                list.add(f);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
