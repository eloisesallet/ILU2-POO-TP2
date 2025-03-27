package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if(!nomAcheteurConnu){
			System.out
			.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			choisirVendeur(nomAcheteur);
			}
		}
	
		public void choisirVendeur(String nomAcheteur) {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String [] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
			if(vendeurs.length==0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
				int i=0;
				int j=1;
				while(i<vendeurs.length) {
					System.out.println(j+" - " + vendeurs[i]);
				}
				int vendeurChoisi;
				do {
					vendeurChoisi = Clavier.entrerEntier("");
				} while (vendeurChoisi > vendeurs.length || vendeurChoisi <= 0);
				
				String nomVendeur = vendeurs[vendeurChoisi - 1];
				if (!controlAcheterProduit.verifierIdentite(nomVendeur)) {
					System.out.println("Je suis désolé " + nomVendeur
							+ " mais il faut être un habitant de notre village pour commercer ici.");
				}
				System.out.println(nomAcheteur + " se déplace jusqu'à  l'étal du vendeur " + nomVendeur);
				System.out.println("Bonjour " + nomAcheteur);
				int quantiteAchat;
				do {
					quantiteAchat = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				} while (quantiteAchat <= 0);

				int quantiteVendue = controlAcheterProduit.acheterProduit(nomVendeur, quantiteAchat);
				if (quantiteVendue == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAchat + " " + produit
							+ ", malheureusement il n'y en a plus !");
				} else if (quantiteVendue == quantiteAchat) {
					System.out
							.println(nomAcheteur + " achète " + quantiteAchat + " " + produit + " à " + nomVendeur + ".");
				} else {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAchat + " " + produit
							+ ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteVendue + ". " + nomAcheteur
							+ " achète tout le stock de " + nomVendeur + ".");
				}
			}
		}
	}
