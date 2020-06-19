package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exemple.exceptions.DptInconnuException;
import fr.diginamic.exemple.exceptions.MinSupMaxException;
import fr.diginamic.exemple.exceptions.NombreNegatifException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un d√©partement dont la population est comprise
 * entre une valeur min et une valeur max renseign√©es par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws DptInconnuException,NombreNegatifException,MinSupMaxException,NumberFormatException {

		System.out.println("Quel est le code du d√©partement recherch√© ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		if(Integer.parseInt(saisieMin) < 0) {
			throw new NombreNegatifException("Veuillez saisir un minimum positif");
		}

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		if(Integer.parseInt(saisieMax) < 0) {
			throw new NombreNegatifException("Veuillez saisir un maximum positif");
		}
		if(Integer.parseInt(saisieMax) < Integer.parseInt(saisieMin)) {
			throw new MinSupMaxException("Le maximum doit Ítre supÈrieur au minimum");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		boolean dptInconnu = true;
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
				dptInconnu = false;
			}
		}
		if(dptInconnu) {
			throw new DptInconnuException("Le dÈpartement est inconnu");
		}
	}

}
