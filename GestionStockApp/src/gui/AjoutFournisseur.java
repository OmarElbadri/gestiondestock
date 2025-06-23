package gui;

import model.Fournisseur;
import dao.FournisseurDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjoutFournisseur {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ajout de fournisseur");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nomLabel = new JLabel("Nom:");
        JTextField nomField = new JTextField();

        JLabel adresseLabel = new JLabel("Adresse:");
        JTextField adresseField = new JTextField();

        JLabel telLabel = new JLabel("Téléphone:");
        JTextField telField = new JTextField();

        JButton ajouterBtn = new JButton("Ajouter");
        JLabel message = new JLabel("");

        ajouterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String adresse = adresseField.getText();
                String telephone = telField.getText();

                Fournisseur f = new Fournisseur(nom, adresse, telephone);
                boolean success = FournisseurDAO.ajouterFournisseur(f);

                if (success) {
                    message.setText("✅ Fournisseur ajouté !");
                } else {
                    message.setText("❌ Erreur !");
                }
            }
        });

        frame.add(nomLabel); frame.add(nomField);
        frame.add(adresseLabel); frame.add(adresseField);
        frame.add(telLabel); frame.add(telField);
        frame.add(ajouterBtn); frame.add(message);

        frame.setVisible(true);
    }
}
