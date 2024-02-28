import java.util.Locale;

public class Composant {
    private final String categorie;
    private String marque;
    private String nom;
    private double prix;
    private double rabais;

    public Composant(String categorie,String marque, String nom, double prix){
        rabais = 0;
        this.categorie = categorie.toUpperCase().trim();
        this.marque = marque;
        this.nom = nom;
        this.prix = prix;
    }

    public Composant copier(){
        return new Composant(this.categorie,this.marque,this.nom,this.prix);
    }

    public boolean estIdentique(Composant autreComposant){
        return this.getCategorie().equals(autreComposant.getCategorie()) && this.getMarque().equals(autreComposant.getMarque()) && this.getNom().equals(autreComposant.getNom());

    }

    public String toString(){
        return "[" + getCategorie() + "] " + getCategorie() + " " + getNom();
    }


//Accesseurs et mutateurs
    public double getPrix() {
        return prix - (prix * (getRabais()));
    }

    public String getCategorie() {
        return categorie;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public double getRabais() {
        return rabais;
    }

    public void setPrix(double prix) {
        if(prix > 0){
            this.prix = prix;
        }
        else{
            System.out.println("Erreur le prix entré est négatif");
        }

    }

    public void setRabais(double rabais) {
        if(rabais > 0 && rabais <= 100){
            this.rabais = rabais;
        }
        else{
            System.out.println("Erreur le rabais dot être entre 0 et 100%(inclus)");
        }

    }
}
