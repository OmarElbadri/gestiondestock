package model;

public class Fournisseur {
    private int id;
    private String nom;
    private String adresse;
    private String telephone;

    public Fournisseur(String nom, String adresse, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    // Getters
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public String getTelephone() { return telephone; }
}
