package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Gaulois vendeur;
	private Gaulois acheteur;

	@BeforeEach
	void init() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
		acheteur = new Gaulois("Bob", 2);
		village.ajouterHabitant(acheteur);
	}
	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertNotNull(controlAcheterProduit, "Le constructeur ne renvoie pas null");
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertNotNull(controlAcheterProduit.acheterProduit("Bonemine", 2));
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		assertTrue(controlAcheterProduit.verifierIdentite(this.vendeur.getNom()));
		assertTrue(controlAcheterProduit.verifierIdentite(this.acheteur.getNom()));
	}

	@Test
	void testRechercherVendeursProduit() {
		fail("Not yet implemented");
	}

}
