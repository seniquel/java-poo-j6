package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.exemple.exceptions.DptInconnuException;
import fr.diginamic.exemple.exceptions.MinSupMaxException;
import fr.diginamic.exemple.exceptions.NombreNegatifException;
import fr.diginamic.exemple.exceptions.RegionInconnueException;
import fr.diginamic.exemple.exceptions.VilleInconnueException;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de services
	 * 
	 * @param lignes lignes du fichier
	 * @param scanner scanner
	 * @throws NombreOutOfBoundsException 
	 * @throws LettrePlutotQueNombreException 
	 * @throws DptInconnuException 
	 * @throws NumberFormatException 
	 * @throws MinSupMaxException 
	 * @throws NombreNegatifException 
	 * @throws RegionInconnueException 
	 * @throws VilleInconnueException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws DptInconnuException, MinSupMaxException, NumberFormatException, NombreNegatifException, RegionInconnueException, VilleInconnueException;
}
