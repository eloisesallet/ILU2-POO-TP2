package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois bob;
	private Druide pierre;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	void init() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(bonemine);
		bob = new Gaulois("Bob", 3);
		village.ajouterHabitant(bob);
		pierre = new Druide("Pierre", 3,2,3);
		village.ajouterHabitant(pierre);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		village.partirVendeur(bonemine);
		assertTrue(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(-1,controlPrendreEtal.prendreEtal("Bob","carrottes",10));
		village.partirVendeur(bonemine);
		assertEquals(-1,controlPrendreEtal.prendreEtal("Mimi","carrottes",10));
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
