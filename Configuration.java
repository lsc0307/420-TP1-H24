public class Configuration {
    private static String description;
    private int prix_max;
    private Composant[] composantes;
    private int nb_compsants;
    private final int MAX_COMPOSANTS = 20;

    


    //Accesseurs et Mutateurs

    public static String getDescription() {
        return description;
    }

    public int getPrix_max() {
        return prix_max;
    }

    public Composant[] getComposantes() {
        return composantes;
    }

    public int getNb_compsants() {
        return nb_compsants;
    }




}
