package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exemple.exceptions.RegionInconnueException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Recherche et affichage de la population d'une région
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationRegionService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws RegionInconnueException {
		
		System.out.println("Quel est le code de la région recherchée ? ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = rec.getVilles();
		int somme = 0;
		String nom = null;
		boolean regionInconnue = true;
		for (Ville ville: villes){
			if (ville.getCodeRegion().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
				nom=ville.getNomRegion();
				regionInconnue = false;
			}
		}
		if(regionInconnue) {
			throw new RegionInconnueException("La r�gion est inconnue");
		}
		if (somme>0){
			System.out.println("Population de la région "+nom+" : "+ somme);
		}
		else {
			System.out.println("Région "+choix+" non trouvée.");
		}
	}

}
