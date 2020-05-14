package gestiondesEtudes;

import java.util.Scanner;

public class Visiteur extends Personne{
	protected Ecole e;
	
	Scanner sc = new Scanner(System.in);
	
	public Visiteur(Ecole e) {
		super();
		this.e = e;
		System.out.println("                        Bienvenu en mode Visiteur ! \n");
	}
	public Visiteur(String a, String b, Ecole e) {
		super(a,b);
		this.e = e;
		System.out.println("                        Bienvenu en mode Visiteur ! \n");
	}
	
	public void afficherEcole() {
		System.out.println(e.toString());
	}
	
	public void afficherFiliere() {
		e.affichefiliereEcole();
	}
	
	public void quitter() {
		sc.close();
	}
	
	public void gestionVisiteur() {
		System.out.println("Choisissez votre prochaine action :\n 1) Afficher des informations sur l'école\n 2) Afficher les filières de l'école\n 3) Quitter");
		switch(sc.next()) {
		case "1" : afficherEcole(); gestionVisiteur(); break;
		case "2" : afficherFiliere(); gestionVisiteur(); break;
		case "3" : quitter(); break;
		}
	}
}