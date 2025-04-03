package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois bob;
	private Druide pierre;
	
	@BeforeEach
	void init() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(bonemine);
		bob = new Gaulois("Bob", 3);
		village.ajouterHabitant(bob);
		pierre = new Druide("Pierre", 3,2,3);
		village.ajouterHabitant(pierre);
		village.installerVendeur(bonemine, "fleurs", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertFalse(controlLibererEtal.isVendeur("Bob"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] etatEtal1 = {"true","Bonemine","fleurs","10","0"};
		assertArrayEquals(etatEtal1, controlLibererEtal.libererEtal("Bonemine"));
		
		String[] etatEtal2 = {"false",null,null,null,null};
		village.partirVendeur(bonemine);
		assertArrayEquals(etatEtal2, controlLibererEtal.libererEtal("Bonemine"));
	}

}
