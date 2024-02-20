public class Configuration {
    private static String description;
    private double prix_max;
    private Composant[] composants;
    private int nb_composants;
    private final int MAX_COMPOSANTS = 20;

    public Configuration(String description,double prix_max,Composant[] composants){
        this.description = description;
        this.prix_max = prix_max;
        this.composants = composants;
    }

    public Configuration(Configuration config){
        this.description = config.description;
        this.prix_max = config.prix_max;
        this.composants = new Composant[config.composants.length];
        for (int i = 0; i < config.composants.length; i++) {
            this.composants[i] = config.composants[i];
        }
    }

    public double calculerTotal(double taxe){
        double prixTotal=0;
        for(int i=0;i< composants.length;i++){
            prixTotal += composants[i].getPrix();
        }
        return prixTotal;
    }

    public Composant rechercher(String categorie){
        for(int i=0;i< composants.length;i++){
            if(composants[i].getCategorie().equals(categorie)){
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




    //Accesseurs et Mutateurs

    public static String getDescription() {
        return description;
    }

    public double getPrix_max() {
        return prix_max;
    }

    public Composant[] getComposants() {
        return composants;
    }

    public int getNb_composants() {
        return nb_composants;
    }




}
