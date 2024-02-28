import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Tests {


        @Test
        public void testAjouterAvecSucces() {
            Composant cpu = new Composant("CPU", "Intel", "Core i7", 300);
            Configuration config = new Configuration("Configuration de test", 1000, new Composant[]{});
            assertTrue(config.ajouter(cpu));
            assertEquals(1, config.getNbComposants());
        }

        @Test
        public void testAjouterMemeCategorie() {
            Composant cpu1 = new Composant("CPU", "Intel", "Core i7", 300);
            Composant cpu2 = new Composant("CPU", "AMD", "Ryzen 5", 200);
            Configuration config = new Configuration("Configuration de test", 1000, new Composant[]{cpu1});
            assertFalse(config.ajouter(cpu2));
            assertEquals(1, config.getNbComposants());
        }

        @Test
        public void testAjouterDepassePrixMaximal() {
            Composant gpu = new Composant("GPU", "Nvidia", "RTX 3080", 900);
            Configuration config = new Configuration("Configuration de test", 800, new Composant[]{});
            assertFalse(config.ajouter(gpu));
            assertEquals(0, config.getNbComposants());
        }

    @Test
    public void testAjouterDepasseNbMaxComposants() {
        Configuration config = new Configuration("Configuration de test", 10000, new Composant[]{});
        Composant c1 = new Composant("C1", "Intel", "Core i7", 300);
        Composant c2 = new Composant("C2", "AMD", "Ryzen 5", 200);
        Composant c3 = new Composant("C3", "Intel", "Core i7", 300);
        Composant c4 = new Composant("C4", "AMD", "Ryzen 5", 200);
        Composant c5 = new Composant("C5", "Intel", "Core i7", 300);
        Composant c6 = new Composant("C6", "AMD", "Ryzen 5", 200);
        Composant c7 = new Composant("C7", "Intel", "Core i7", 300);
        Composant c8 = new Composant("C8", "AMD", "Ryzen 5", 200);
        Composant c9 = new Composant("C9", "Intel", "Core i7", 300);
        Composant c10 = new Composant("C10", "AMD", "Ryzen 5", 200);
        Composant c11 = new Composant("C11", "Intel", "Core i7", 300);
        Composant c12 = new Composant("C12", "AMD", "Ryzen 5", 200);
        Composant c13 = new Composant("C13", "Intel", "Core i7", 300);
        Composant c14 = new Composant("C14", "AMD", "Ryzen 5", 200);
        Composant c15 = new Composant("C15", "Intel", "Core i7", 300);
        Composant c16 = new Composant("C16", "AMD", "Ryzen 5", 200);
        Composant c17 = new Composant("C17", "Intel", "Core i7", 300);
        Composant c18 = new Composant("C18", "AMD", "Ryzen 5", 200);
        Composant c19 = new Composant("C19", "Intel", "Core i7", 300);
        Composant c20 = new Composant("C20", "AMD", "Ryzen 5", 200);
        config.ajouter(c1);
        config.ajouter(c2);
        config.ajouter(c3);
        config.ajouter(c4);
        config.ajouter(c5);
        config.ajouter(c6);
        config.ajouter(c7);
        config.ajouter(c8);
        config.ajouter(c9);
        config.ajouter(c10);
        config.ajouter(c11);
        config.ajouter(c12);
        config.ajouter(c13);
        config.ajouter(c14);
        config.ajouter(c15);
        config.ajouter(c16);
        config.ajouter(c17);
        config.ajouter(c18);
        config.ajouter(c19);
        config.ajouter(c20);

        assertFalse(config.ajouter(new Composant("Composant", "Marque", "Nom", 100)));
        assertEquals(Configuration.MAX_COMPOSANTS, config.getNbComposants());
    }
    }
