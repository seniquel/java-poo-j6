package fr.diginamic.recensement;

import java.util.Scanner;

import fr.diginamic.exemple.exceptions.DptInconnuException;
import fr.diginamic.exemple.exceptions.MinSupMaxException;
import fr.diginamic.exemple.exceptions.NombreNegatifException;
import fr.diginamic.exemple.exceptions.RegionInconnueException;
import fr.diginamic.exemple.exceptions.VilleInconnueException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.services.RecherchePopulationBorneService;
import fr.diginamic.recensement.services.RecherchePopulationDepartementService;
import fr.diginamic.recensement.services.RecherchePopulationRegionService;
import fr.diginamic.recensement.services.RecherchePopulationVilleService;
import fr.diginamic.recensement.utils.RecensementUtils;

/**
 * Application de traitement des données de recensement de population
 * 
 * @param args
 */
public class Application {

	/**
	 * Point d'entrée
	 * 
	 * @param args arguments (non utilisés ici)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//String filePath = ClassLoader.getSystemClassLoader().getResource("D:\\Formation 2020\\Java\\java-poo-j6\\src\\main\\resources\\recensement.csv").getFile();
		Recensement recensement = RecensementUtils.lire("D:\\Formation 2020\\Java\\java-poo-j6\\src\\main\\resources\\recensement.csv");

		if (recensement == null) {
			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}

		// Menu
		int choix = 0;
		do {

			// Affichage du menu
			afficherMenu();

			// Poser une question à l'utilisateur
			String choixMenu = scanner.nextLine();

			// Conversion du choix utilisateur en int
			choix = Integer.parseInt(choixMenu);

			// On exécute l'option correspondant au choix de l'utilisateur
			switch (choix) {
			case 1:
				RecherchePopulationVilleService rechercheVille = new RecherchePopulationVilleService();
				try {
					rechercheVille.traiter(recensement, scanner);
				} catch (VilleInconnueException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				RecherchePopulationDepartementService rechercheDept = new RecherchePopulationDepartementService();
				try {
					rechercheDept.traiter(recensement, scanner);
				} catch (DptInconnuException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				RecherchePopulationRegionService rechercheRegion = new RecherchePopulationRegionService();
				try {
					rechercheRegion.traiter(recensement, scanner);
				} catch (RegionInconnueException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				RecherchePopulationBorneService recherchePopBorne = new RecherchePopulationBorneService();
				try {
					recherchePopBorne.traiter(recensement, scanner);
				} catch (NumberFormatException | DptInconnuException | NombreNegatifException | MinSupMaxException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		} while (choix != 99);

		scanner.close();

	}

	/**
	 * Affichage du menu
	 */
	private static void afficherMenu() {
		System.out.println("***** Recensement population *****");
		System.out.println("1. Rechercher la population d'une ville");
		System.out.println("2. Rechercher la population d'un département");
		System.out.println("3. Rechercher la population d'une région");
		System.out.println("4. Rechercher la population des villes d'un dept entre min et max");
		System.out.println("99. Sortir");
	}
}
