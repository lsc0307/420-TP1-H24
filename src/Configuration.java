package src;

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

        for (int i = 0; i < this.getNbComposants(); i++) {
            this.composants[i] = composants[i];
        }
    }

    public Configuration(Configuration config){
        this.description = config.description + " (copie) ";
        this.prix_max = config.prix_max;
        this.composants = new Composant[MAX_COMPOSANTS];
        for (int i = 0; i < config.getNbComposants(); i++) {
            if(config.composants[i] != null)
                this.composants[i] = config.composants[i].copier();
        }
        this.nb_composants = config.nb_composants;
    }

    public double calculerTotal(double taxe){
        double prixTotal=0;
        for(int i=0;i< getNbComposants();i++){
            if(composants[i] != null){
                prixTotal += composants[i].getPrix();
            }

        }
        prixTotal = prixTotal + (prixTotal * taxe);
        return prixTotal;
    }

    public double calculerTotalSansTaxe(Composant[] composants){
        double prixTotal=0;
        for(int i=0;i< getNbComposants();i++){
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

        for(int i=0;i<getNbComposants();i++){
            if(composants[i] != null && composants[i].getCategorie().equalsIgnoreCase(composant.getCategorie()) && (calculerTotalSansTaxe(composants) -composants[i].getPrix() + composant.getPrix()) <= prix_max){
                System.out.println(composants[i].toString() + " retiré de la configuration ");
                composants[i] = composant;
                System.out.println(composant.toString() + " ajouté à la configuration ");

                return true;
            }
        }
        return false;
    }

    public boolean ajouter(Composant composant){

        if(rechercher(composant.getCategorie()) != null){
            System.out.println("Il y a déjà un composant de cette catégorie: " + composant.toString());
            return false;
        }
        else if( nb_composants == MAX_COMPOSANTS){
            System.out.println("Le nombre de composants maximum a deja été atteint");
            return false;
        }
        else if(rechercher(composant.getCategorie()) != null || calculerTotalSansTaxe(composants) + composant.getPrix() > prix_max){
            System.out.println("L'ajout de ce composant ferait dépasser le prix maximum: " + composant.toString());
            return false;
        }
        else{
            composants[getNbComposants()] = composant;
            nb_composants++;
            System.out.println(composant.toString() + " ajouté à la configuration " + "(total=" + calculerTotalSansTaxe(composants)+ ")");
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
                    System.out.println(composant.toString() + " retiré de la configuration " + "(total=" + String.format("%.2f", calculerTotalSansTaxe(composants)) + "$)");

                    return true;
                }
            }
            System.out.println("src.Composant introuvable: " + composant.toString());
           return false;
    }

    public String toString(){
        String affichage = getDescription() + "(max " + String.format("%.2f", getPrix_max()) + "$) :";

        int numeroComposante = 1;
        for(int i=0;i < this.getNbComposants();i++){
            if(this.composants[i] != null){
                affichage += String.format("\n \t%d : [%s] %s %s (%.2f$)",
                        numeroComposante,
                        composants[i].getCategorie(),
                        composants[i].getMarque(),
                        composants[i].getNom(),
                        composants[i].getPrix());
                numeroComposante++;
            }

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
