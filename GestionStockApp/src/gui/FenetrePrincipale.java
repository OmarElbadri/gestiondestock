package gui;

import model.Produit;
import dao.ProduitDAO;
import model.Fournisseur;
import dao.FournisseurDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePrincipale {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ajout de produit");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nomLabel = new JLabel("Nom du produit:");
        JTextField nomField = new JTextField();

        JLabel prixLabel = new JLabel("Prix:");
        JTextField prixField = new JTextField();

        JLabel quantiteLabel = new JLabel("Quantité:");
        JTextField quantiteField = new JTextField();

        JButton ajouterBtn = new JButton("Ajouter");
        JLabel message = new JLabel("");
        
        JLabel fournisseurLabel = new JLabel("Fournisseur:");
        JComboBox<Fournisseur> fournisseurBox = new JComboBox<>();

        // Charger les fournisseurs
        for (Fournisseur f : FournisseurDAO.getAllFournisseurs()) {
            fournisseurBox.addItem(f); // Redéfinir toString() pour afficher le nom
        }

        
        ajouterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                double prix = Double.parseDouble(prixField.getText());
                int quantite = Integer.parseInt(quantiteField.getText());

                Produit produit = new Produit(nom, prix, quantite);
                boolean success = ProduitDAO.ajouterProduit(produit);

                if (success) {
                    message.setText("✅ Produit ajouté !");
                } else {
                    message.setText("❌ Échec !");
                }
            }
        });

        frame.add(nomLabel); frame.add(nomField);
        frame.add(prixLabel); frame.add(prixField);
        frame.add(quantiteLabel); frame.add(quantiteField);
        frame.add(ajouterBtn); frame.add(message);

        frame.setVisible(true);
    }
    
}
