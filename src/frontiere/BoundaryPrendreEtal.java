package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu){
			System.out
			.println("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out
		.println("C'est parfait, il me reste un étal pour vous!");
		System.out
		.println("Il me faudrait quelques renseignements : ");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out
			.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + numeroEtal+1);
		}
	}
}
