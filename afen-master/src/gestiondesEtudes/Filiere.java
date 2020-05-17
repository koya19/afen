package gestiondesEtudes;
import java.util.*;

public class Filiere implements Comparable<Filiere>{

protected String  nomFili�re;
protected Set <Promo> promoFiliere =new HashSet<>();
protected Set <Class> classFiliere= new HashSet<>();
protected Set <Student> studFiliere= new TreeSet<>();
public Set <Prof> profFiliere =new HashSet<>();
protected Ecole ecole;
protected Respo r= new Respo ();
Scanner sc=new Scanner(System.in);
	
	public Filiere() {
		
	}
	
	public Filiere(String a,Ecole ecole) {
		nomFili�re= a;
		this.ecole=ecole;
		ecole.filiereEcole.add(this);
		System.out.println("\nVous avez cr�� la fili�re "+this.nomFili�re);
	}
//-----------------------------------------------------------------------------
	

	public String toString() {
		return  nomFili�re ;
	}
//-------------------------------------------------------------------------------
	public void removePromoFiliere (Promo p) {
		 promoFiliere.remove(p);
	 }
	public void respoFiliere (Respo a) {
		r=a;
		System.out.println("\nVous avez d�sign� "+ r +" comme responsable de fili�re "+this.toString());
	}
	public void addpromoFiliere(Promo p) {
	
		promoFiliere.add(p);
	}
	@SuppressWarnings("rawtypes")
	public void afficheClassFiliere() {
			try {
		if (this.classFiliere.isEmpty()) {
			throw new NullPointerException("Pas de classe dans cette fili�re\n");
		}
		System.out.println("\nLes classes de la fili�re "  + this.toString());	
		 int i=1;
		 Iterator iterator = classFiliere.iterator();
		 while (iterator.hasNext()){
	         System.out.println(" "+i+"-"+iterator.next());
	         i++;
		}}catch(NullPointerException e) {
			System.out.println();
			System.err.println("Pas de classe dans cette fili�re\n");
		}
	}
 
	@SuppressWarnings("rawtypes")
	public void afficheStudFiliere() {
		 System.out.println("\nLes �tudiants de la fili�re "  + this.toString());	
		 int i=1;
		 Iterator iterator = studFiliere.iterator();
		 while (iterator.hasNext()){
	         System.out.println(" "+i+"-"+iterator.next());
		 }
		}
	@SuppressWarnings("rawtypes")
	public void affichePromoFiliere() {
		System.out.println("\nLes promotions de la fili�re "+ this.toString() );
		int i=1;
		Iterator iterator = promoFiliere.iterator();
		while(iterator.hasNext()) {
			System.out.println(" "+i+"-"+iterator.next());
			i++;
		}
		
	}
	public Class choisirClassFilere() {
		Class cl = new Class ();
		int a=0;
		while (a==0) {
		System.out.println("\nChoisissez une classe :");
		this.afficheClassFiliere();
		try {
			int classchoisie=sc.nextInt();
		//	sc.nextLine();
			if (0>classchoisie ||  classchoisie>this.classFiliere.size()) {
				throw new InputMismatchException("Ce choix est invalide.")	;
			}
			int i=1;
			for (Class c:this.classFiliere ) {
				if (i==classchoisie) {
					cl=c;
					break;
				}
				else i++;
			}
			break;
		
	}catch(InputMismatchException e) {
		System.out.println();
		System.err.println("Ce choix est invalide");
		sc.nextLine();
		
		
	}
	catch(NullPointerException e) {
		System.out.println();
		System.err.println("Pas de choix actuellement.");
		sc.nextLine();
		 
	}
		}
		return cl;
		}
		
		
		 
	
	public int compareTo(Filiere f) {
		
		 return this.nomFili�re.compareTo(f.nomFili�re) ;
	}
	public boolean equals(Filiere f) {
		return this.nomFili�re.equals(f.nomFili�re);
	}

	
	
	
	
	

}
