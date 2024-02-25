import java.util.Locale;

public class Configuration {
    private String description;
    private double prix_max;
    private Composant[] composants;
    private int nb_composants;
    public static final int MAX_COMPOSANTS = 20;
    private double taxes = 0.15;

    public Configuration(String description,double prix_max,Composant[] composants){
        this.description = description;
        this.prix_max = prix_max;
        this.composants = new Composant[MAX_COMPOSANTS];
        this.nb_composants = composants.length;

        for (int i = 0; i < this.nb_composants; i++) {
            this.composants[i] = composants[i];
        }
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
        prixTotal = prixTotal + (prixTotal * taxe);
        return prixTotal;
    }

    public double calculerTotalSansTaxe(Composant[] composants){
        double prixTotal=0;
        for(int i=0;i< nb_composants;i++){
            prixTotal += composants[i].getPrix();
        }
        return prixTotal;
    }

    public Composant rechercher(String categorie){
        for(int i=0;i< getNbComposants();i++){
            if(composants[i] != null && composants[i].getCategorie().equalsIgnoreCase(categorie) ){
                return composants[i];
            }
        }
        return null;
    }

    public boolean remplacer(Composant composant){

        for(int i=0;i<composants.length;i++){
            if(composants[i] != null && composants[i].getCategorie().equals(composant.getCategorie()) && (calculerTotalSansTaxe(composants) -composants[i].getPrix() + composant.getPrix()) <= prix_max){
                composants[i] = composant;
                return true;
            }
        }
        return false;
    }

    public boolean ajouter(Composant composant){

        if(rechercher(composant.getCategorie()) != null || nb_composants == MAX_COMPOSANTS){
            System.out.println("Il y a déjà un composant de cette catégorie: " + composant.toString());
            return false;
        }
        else if(rechercher(composant.getCategorie()) != null || calculerTotalSansTaxe(composants) + composant.getPrix() > prix_max){
            System.out.println("L'ajout de ce composant ferait dépasser le prix maximum: " + composant.toString());
            return false;
        }
        else{
            composants[getNbComposants()] = composant;
            nb_composants++;
            return true;
        }
    }

    public boolean retirer(Composant composant){
            for (int i = 0; i <= getNbComposants(); i++) {
                if(composants[i] != null && composants[i].equals(composant)){
                    for(int j=i;j < getNbComposants();j++){
                        composants[j] = composants[j+1];
                    }

                    nb_composants--;
                    return true;
                }
            }
            System.out.println("Composant introuvable: " + composant.toString());
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
