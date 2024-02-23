import java.util.Locale;

public class Configuration {
    private String description;
    private double prix_max;
    private Composant[] composants;
    private int nb_composants;
    public static final int MAX_COMPOSANTS = 20;

    public Configuration(String description,double prix_max,Composant[] composants){
        this.description = description;
        this.prix_max = prix_max;
        this.composants = composants;
        this.nb_composants = composants.length;
    }

    public Configuration(Configuration config){
        this.description = config.description;
        this.prix_max = config.prix_max;
        this.composants = new Composant[config.composants.length];
        for (int i = 0; i < config.composants.length; i++) {
            this.composants[i] = config.composants[i];
        }
        this.nb_composants = config.nb_composants;
    }

    public double calculerTotal(double taxe){
        double prixTotal=0;
        for(int i=0;i< nb_composants;i++){
            prixTotal += composants[i].getPrix();
        }
        return prixTotal;
    }

    public Composant rechercher(String categorie){
        for(int i=0;i< composants.length;i++){
            if(composants[i].getCategorie().equalsIgnoreCase(categorie)){
                return composants[i];
            }
        }
        return null;
    }

    public boolean remplacer(Composant composant){
        if(rechercher(composant.getCategorie()) == null){
            return false;
        }
        for(int i=0;i<composants.length;i++){
            if(composants[i].getCategorie().equals(composant.getCategorie()) && (prix_max-composants[i].getPrix()) + composant.getPrix() <= prix_max){
                composants[i] = composant;
                return true;
            }
        }
        return false;
    }

    public boolean ajouter(Composant composant){
        int prixCompos = 0;
        int i = 0;
        for (; i <= getNbComposants() ; i++) {
            prixCompos += composants[i].getPrix();
        }
        if(rechercher(composant.getCategorie()) != null || nb_composants == MAX_COMPOSANTS || prixCompos + composant.getPrix() > prix_max){
            return false;
        }
        else{
            composants[i] = composant;
            return true;
        }
    }

    public boolean retirer(Composant composant){
            for (int i = 0; i <= getNbComposants(); i++) {
                if(composants[i].equals(composant)){
                    for(int j=i;j < getNbComposants();j++){
                        composants[j] = composants[j+1];
                    }

                    nb_composants--;
                    return true;
                }
            }
           return false;
    }

    public String toString(){
        String affichage = "description(" + getPrix_max() + ") :";
        int numeroComposante = 1;
        for(int i=0;i < getNbComposants();i++){
            affichage = affichage + "\n \t" + numeroComposante + " : " + composants[i].getNom() + " (" + composants[i].getPrix() + ")";
            numeroComposante++;
        }
        return affichage;
    }



    //Accesseurs et Mutateurs

    public String getDescription() {
        return description;
    }

    public double getPrix_max() {
        return prix_max;
    }

    public Composant[] getComposants() {
        return composants;
    }

    public int getNbComposants() {
        return nb_composants;
    }




}
