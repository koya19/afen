package gestiondeScolarit�;
import gestiondesEtudes.Class;
import gestiondesEtudes.Student;
import gestiondesEtudes.administrateur;
import gestiondesEtudes.Prof;


import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class Element {
	protected String duree =new String();
	protected int totalheure;
	protected int salle;
	protected String nomElement;
	protected Module module;
	//protected Prof prof ;
	public Map<Student,Integer> noteElement= new TreeMap<>();
	protected Map<Student,Double> notefinalElement= new TreeMap<>();
	protected Map<String,Integer> repartheureElement= new HashMap<>();
	protected Map<String, Prof> enseignantElement= new HashMap<>();
	protected Map<Student,Integer> absStud=new TreeMap<>();
	Scanner sc=new Scanner(System.in);
	String Newligne=System.getProperty("line.separator");
	
//-------------------CONSTRUCTEUR--------------------------------------------------	
	public Element () {
		nomElement="Vide ";
		 
	}

	public Element (String nomElement, Module module) {
		this.salle=0;
		this.totalheure=0;
		this.nomElement=nomElement;
		this.module=module;
		module.eleModule.add(this);

		this.duree="";
		
		 Iterator iterator = module.cl.getStud().iterator();
		 while (iterator.hasNext()){
	         noteElement.put((Student)iterator.next(),-1);
		 }
		 
		 this.repartheureElement.put("CM",0);
		 this.repartheureElement.put("TD",0);
		 this.repartheureElement.put("TP",0);
		 this.repartheureElement.put("AP",0);
		 
		 
		 
		 for (Map.Entry mapentry : repartheureElement.entrySet()) {
				System.out.println("\n----Creation de la discipline " +mapentry.getKey()+" de l'element "+this.toString()+" :\n");
				System.out.println("--Determiner l'enseignant de la discipline :\n");
				System.out.println("    ->Entez le nom :");
				String lastnamePers=sc.next();
				System.out.println("    ->Entez le pr�nom :");
				String firstnamePers=sc.next();
				System.out.println("    ->Entrez le CNI :");
				String cniPers=sc.next();
				System.out.println("    ->Entrez le mot de passe :");
				String pwd=sc.next();	
				Prof a= new Prof (lastnamePers,firstnamePers,cniPers,pwd,this);
				this.enseignantElement.put((String) mapentry.getKey(),a);
				module.cl.profClass.add(a);
				module.cl.getEcole().profEcole.add(a);
				module.cl.getEcole().pwdEcole.put(a, pwd);
				module.cl.getFiliere().profFiliere.add(a);
				
				int i=0;
				while(i==0) {
					System.out.println("    ->Entrez le nombre d'heure pour cette discipline :");
					try {
						Integer hour=sc.nextInt();
						totalheure+=hour;
						 repartheureElement.put((String)mapentry.getKey(),hour);
						 i=1;
					}catch(InputMismatchException e) {
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						i=0;
				}
					
			 }
				
				}
		 this.module.cl.writeProf();
	
	}
	
//--------------------NOTES---------------------------------------------------------
	public void modnote(Student student,int note) {
		int v=0;
		for(Map.Entry mapentry : noteElement.entrySet()) {
			if(mapentry.getKey().equals(student)) {
				noteElement.put(student,note);
				v=1;
				break;
			}
			
		}
		if(v==0) {
			System.out.println("l'etudiant "+ student.toString() +" n'appartient pas � " + module.cl.toString());
		}
		}
	
	public void affichenoteElement() {
		if(this.noteElement.isEmpty()) {
			System.err.println("\nPas de notes pour le moment\n");
		}
		System.out.println("les notes de l'element " + this.nomElement+" du "+this.module);
		for (Map.Entry mapentry : noteElement.entrySet()) {
	           System.out.println(mapentry.getKey()+ "   " + mapentry.getValue());
	        }
	}
	public void affichenoteStud(Student s) {
		System.out.println(s.toString()+" "+noteElement.get(s));
	}
	public int contAbsence(Student s) {
		int c=0;
		for(Absence abs: module.cl.abs) {
			if (abs.getElement().equals(this)) {
				if(abs.absStud.get(s)==true) {
					c+=1;
				}
			}
		}
		return c;
	}
//--------------------REPARTION D'ELEMENT----------------------------------------------------
	
	public void modhours(){
		Scanner sc= new Scanner(System.in);
			
		System.out.println("Entrer les heures selon la discipline");
		for (Map.Entry mapentry : repartheureElement.entrySet()) {
			System.out.println(mapentry.getKey()+"  :");
			Integer hour=sc.nextInt();
			totalheure+=hour;
			 repartheureElement.put((String)mapentry.getKey(),hour);
		}
		
		
	}
	
	public void afficherhours() {
	
		System.out.println("la r�partition de l'element "+ this.nomElement +" :");
		for (Map.Entry mapentry : repartheureElement.entrySet()) {
			System.out.println(mapentry.getKey()+"  :  " + mapentry.getValue()+" h");
		}
		
	}
	
	public void addprof(String rep,Prof prof) {
		enseignantElement.put(rep, prof);
		System.out.println("vous avez determiner " +prof.toString()+"comme prof de l'element "+prof.getElement()+" dans le "+prof.getModule());
			
	}
	
	
	public void afficheprof() {
		System.out.println("les profs  de cet element sont : ");
		
		for (Map.Entry mapentry : enseignantElement.entrySet()) {
			System.out.println(mapentry.getKey()+"  :  " + mapentry.getValue());
		}
	}
	public void definirSalle() {
		int a=0;
		while(a==0) {
			System.out.println("    ->Entrer le num�ro de salle");
			int n=sc.nextInt();
			sc.nextLine();
			if (this.module.cl.getEcole().Salle.containsKey(n)) {
				System.out.println("Salle Occup�e");
				
				
			}
			else {
				this.module.cl.getEcole().Salle.put(n,this);
				this.salle=n;
				a=1;
			}
				
		
		}
	}
	
	
//--------------------GETTER&SETTER&toString-------------------------------------------------
	
	public String getNomElement() {
		return nomElement;
	}
	public void setNomElement(String nomElement) {
		this.nomElement = nomElement;
	}
	public Map<String, Prof> getEnseignantElement() {
		return enseignantElement;
	}
	public void setEnseignantElement(Map<String, Prof> enseignantElement) {
		this.enseignantElement = enseignantElement;
	}
	
	public String toString () {
		return this.nomElement;
	}
	public int getTotalheure() {
		return totalheure;
	}
	public void setTotalheure(int totalheure) {
		this.totalheure = totalheure;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	

	

	
	
	
	
	

}
