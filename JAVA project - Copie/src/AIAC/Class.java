package AIAC;
import gestiondenotes.Absence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import gestiondenotes.EDT;
import gestiondenotes.Element;
import gestiondenotes.Module;



public class Class  implements Comparable<Class> {
	protected Ecole ecole;
	protected Promo promo;
	protected Filiere filiere;
	public Set <Student> stud =new TreeSet <>();
	public Set <Module> moduleClass=new HashSet<>();
	public Set <Absence> abs=new HashSet <>();
	public Set <EDT> emploi= new HashSet<>();
	Scanner sc=new Scanner(System.in);
	 String Newligne=System.getProperty("line.separator");
	 SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
//-----------------------------------------------------------------------------------------	
	public Class() {
		System.out.println("vous avez creer la classe ind�finit" );
	}
	public Class(Filiere filiere,Promo promo) {
		this.filiere=filiere ;
		this.promo=promo ;
		promo.classPromo.add(this);
		filiere.classFiliere.add(this);
		filiere.ecole.classEcole.add(this);
		this.ecole=this.filiere.ecole;
		
		
		
		System.out.println("vous avez creer la classe " + this.toString() );
	}
//-----------------------------------------------------------------------------------------
	
//-----------------------------------------------------------------------------------------	
	
	 public void addStud(Student s) {
			if (stud.contains(s))
				System.out.println(" l'�tudiant "+ s.lastnamePers+" "+ s.firstnamePers + " existe d�ja dans la classe "+ filiere.nomFili�re+" "+promo.nPromo);
			else
				stud.add(s);
				promo.studPromo.add(s);
				filiere.studFiliere.add(s);
				
				
				
				//Collections.sort(l);
				System.out.println("vous avez ajouter l'�tudiant "+s.lastnamePers+" "+  s.firstnamePers +" "+ " � la classe "+ filiere.nomFili�re+" "+promo.nPromo);

	}
	
	 public String toString() {
		return  filiere.nomFili�re+" "+promo.nPromo ;
	}
	
	 public void affichestudClass() {
		int i=0;
		 Iterator iterator = stud.iterator();
		 System.out.println("les �l�ves de la classe "  + this.toString());	
		 while (iterator.hasNext()){
	         System.out.println(i+"-"+iterator.next());
	         i++;
		
		}
		
	}
	 public void affichermoduleClass() {
		
		System.out.println("les modules de cette class sont : ");
		int i=1;
		 for (Module module: moduleClass) {
			 System.out.println(i+"-"+module.toString());
			 i++;
		 }
		
	}
	 public void afficherProf() {
		 System.out.println("choisir le module");
			this.affichermoduleClass();
			int modulechoisi=sc.nextInt();
			sc.nextLine();
		 int i=1;
		 for (Module m: this.moduleClass) {
			 if (i==modulechoisi) {
				 i=1;
				 System.out.println("choisir l'element:");
				 m.affichEleModule();
				 int elementchoisi=sc.nextInt();
				 sc.nextLine();
				 for(Element e: m.getEleModule()) {
					 if(i==elementchoisi) {
						 e.afficheprof();
						 break;
					 }
					 else i++;
				 }
				 break;
			 }
			 else i++;
		 }
	 }
	
	 public void removeStudClass(Student s) {
		
		
		stud.remove(s);
		System.out.println("vous avez retirer "+ s.toString()+"de la classe "+ this.toString());
	}
	 public void afficherespoClass() {
		filiere.r.toString();
		System.out.println("le responsable de la classe "+ this.toString()+" est "+ filiere.r.toString());
	}
	
	 public void modEdt() {
		System.out.println("choisir l'EDT:");
		this.afficheEdt();
		int emploichoisi=sc.nextInt();
		int i=1;
		for (EDT edt:this.emploi) {
			if(i==emploichoisi) {
				int r=2;
				 while(r==2) {
					 System.out.println("choisir le module :");
					 this.affichermoduleClass();
					 int modulechoisi=sc.nextInt();
					 sc.nextLine();
					  i =1;
					 
					 for (Module m:moduleClass ) {
						 if (i==modulechoisi) {
							 i=1;
							 r=1;
							 while(r==1) {
								 System.out.println("choisir l'element:");
								 m.affichEleModule();
								 int elementchoisi=sc.nextInt();
								 r=3;
								 for (Element e:m.getEleModule()) {
									 if(i==elementchoisi) {
										 System.out.println("entrer le jour de la semaine"+Newligne+"1-Lun"+Newligne+ "2-Mar" +Newligne+"3-Mer"+Newligne+ "4-Jeu" +Newligne+"5-Ven" +Newligne+"6-Sam");
										 int jour=sc.nextInt();
										 System.out.println("entrer la p�riode "+Newligne+"1-Matin"+Newligne+"2-Apr�s-midi");
										 int periode=sc.nextInt();
										 System.out.println("choisir la dicipline"+Newligne+"1-CM"+Newligne+"2-TP"+Newligne+"3-TD"+Newligne+"4-AP");
										 int disciplinechoisie=sc.nextInt();
										 String discipline=new String();
										 if (disciplinechoisie==1) {
												discipline= "CM";
											}
											if (disciplinechoisie==2) {
												discipline= "TP";
											}
											if (disciplinechoisie==3) {
												discipline= "TD";
											}
											if (disciplinechoisie==4) {
												discipline= "AP";
											}
										 edt.addElement(jour, periode, e, discipline);
										 System.out.println("choisir votre prochaine action:"+Newligne+"1-ajouter un autre element du "+m.toString()+Newligne+"2-ajouter un element d'un autre module "+Newligne+"3-retour");
										 r=sc.nextInt();
										 if (r==3) {
											 
											 break;
											 
										 }
										  break;
									 }
									 else i++;
								 }
								 
							 }
							 break;
						 }
						 else i++;
					 }
				 
				 }
				
				
				
				break;
			}
			else i++;
		}
				
	}

	 public int compareTo(Class c) {
		
		 return this.filiere.nomFili�re.compareTo(c.filiere.nomFili�re) ;
	}
	 public void addElement(int a,String nomElement) {

		 int i=1;
		 for (Module m: this.moduleClass) {
			 if (i==a) {
				 Element element=new Element(nomElement,m);
				 
				 element.definirSalle();
				 m.addEleModule(element);
				 
				 System.out.println("total"+element.getTotalheure()+" "+m.getHeureModule() );
				 break;
			 }
			 else i++;
		 }
		
	 }
	 public void addprof(Prof prof) {
		 String Newligne=System.getProperty("line.separator");
			Scanner sc=new Scanner(System.in);
		 	System.out.println("choisir le module");
			this.affichermoduleClass();
			int modulechoisi=sc.nextInt();
			sc.nextLine();
			
		 	int i=1;
			for (Module m: this.moduleClass) {
				if(i==modulechoisi) {
					i=1;
					prof.module=m;
					System.out.println("choisir l'element");
					m.affichEleModule();
					int elementchoisi=sc.nextInt();
					sc.nextLine();
					for(Element e:m.getEleModule()) {
						i=1;
						prof.element=e;
						System.out.println("choisir la discipline"+Newligne+"1-CM"+Newligne+"2-TP"+Newligne+"3-TD"+Newligne+"4-AP");
						int disciplinechoisie=sc.nextInt();
						sc.nextLine();
						if(i==elementchoisi) {
							if (disciplinechoisie==1) {
								e.addprof("CM",prof);
								break;
							}
							else if (disciplinechoisie==2) {
								e.addprof("TP",prof);
								break;
							}
							else if (disciplinechoisie==3) {
								e.addprof("TD",prof);
								break;
							}
							else if (disciplinechoisie==4) {
								e.addprof("AP",prof);
								break;
							}
							break;
						}
						else i++;
					
					}
					break;
				}
				else i++;
			}
		}
	 public void repartiondesheursElement() {
		 
		 	String Newligne=System.getProperty("line.separator");
			Scanner sc=new Scanner(System.in);
			 	System.out.println("choisir le module");
				this.affichermoduleClass();
				int modulechoisi=sc.nextInt();
				sc.nextLine();
				
			 	int i=1;
				for (Module m: this.moduleClass) {
					if(i==modulechoisi) {
						i=1;
						System.out.println("choisir l'element");
						m.affichEleModule();
						int elementchoisi=sc.nextInt();
						sc.nextLine();
						for(Element e:m.getEleModule()) {
							if(i==elementchoisi) {
								e.modhours();
								break;
							}
							else i++;
						}
						break;
					}
					
					else i++;
				}
			
			
	 }
	 
	 public void addEDT(String date) throws ParseException {

		 
		Scanner sc=new Scanner(System.in);
		 EDT edt=new EDT(date);
		
		 int r=2;
		 while(r==2) {
			 System.out.println("choisir le module :");
			 this.affichermoduleClass();
			 int modulechoisi=sc.nextInt();
			 sc.nextLine();
			 int i =1;
			 
			 for (Module m:moduleClass ) {
				 if (i==modulechoisi) {
					 i=1;
					 r=1;
					 while(r==1) {
						 System.out.println("choisir l'element:");
						 m.affichEleModule();
						 int elementchoisi=sc.nextInt();
						 r=3;
						 for (Element e:m.getEleModule()) {
							 if(i==elementchoisi) {
								 if (e.getTotalheure()==0) {
									System.out.println("les heures de cet �l�ment sont �puis�es"); 
									r=2;
									break;
								 }
								 else {
								 e.setTotalheure(e.getTotalheure()-4);
								 m.setHeureModule();
								 System.out.println("total"+e.getTotalheure()+" "+m.getHeureModule());
								 System.out.println("entrer le jour de la semaine"+Newligne+"1-Lun"+Newligne+ "2-Mar" +Newligne+"3-Mer"+Newligne+ "4-Jeu" +Newligne+"5-Ven" +Newligne+"6-Sam");
								 int jour=sc.nextInt();
								 System.out.println("entrer la p�riode "+Newligne+"1-Matin"+Newligne+"2-Apr�s-midi");
								 int periode=sc.nextInt();
								 System.out.println("choisir la dicipline"+Newligne+"1-CM"+Newligne+"2-TP"+Newligne+"3-TD"+Newligne+"4-AP");
								 int disciplinechoisie=sc.nextInt();
								 String discipline=new String();
								 if (disciplinechoisie==1) {
										discipline= "CM";
									}
									if (disciplinechoisie==2) {
										discipline= "TP";
									}
									if (disciplinechoisie==3) {
										discipline= "TD";
									}
									if (disciplinechoisie==4) {
										discipline= "AP";
									}
								 edt.addElement(jour, periode, e, discipline);
								 System.out.println("choisir votre prochaine action:"+Newligne+"1-ajouter un autre element du "+m.toString()+Newligne+"2-ajouter un element d'un autre module "+Newligne+"3-retour");
								 r=sc.nextInt();
								 if (r==3) {
									 
									 break;
									 
								 }
								  break;
							 }
							 }
							 else i++;
						 }
						 
					 }
					 break;
				 }
				 else i++;
			 }
		 
		 }
		 this.emploi.add(edt); 
		 System.out.println("vous avez ajoutez edt");
				 
	 }
	 public void removeModule(int a ) {
		 int i=1;
		 for (Module m: this.moduleClass) {
			 if (i==a) {
				 this.moduleClass.remove(m);
				 break;
			 }
			 else i++;
		 }
	 }
	 public Student choisirStud(int a) {
		 int i =1;
		 for (Student s: this.stud) {
			 if (i==a) {
				 return s;
				
			 }
			 else i++;
		 }
		 return null;
	 }
	 public void removeElement(int a ) {
		 int i=1;
		 for (Module m: this.moduleClass) {
			 if (i==a) {
				 i=1;
				 System.out.println("choisir l'element � retirer");
				 m.affichEleModule();
				 int elementchoisi=sc.nextInt();
				 sc.nextLine();
				 for (Element e: m.getEleModule()) {
					 if(i==elementchoisi) {
						 m.getEleModule().remove(e);
					 }
					 else i++;
				 }
				 break;
			 }
			 else i++;
		 }
	 }
	 public boolean testheurModule() {
		 int a=0;
			for (Module m: this.moduleClass) {
				if(m.testheuresElem()==true) {
					a++;
				}
			}
			if(a==this.moduleClass.size()) {
				return true;
			}
			else return false;
	 }
	 public void addnoteStud() {
		 System.out.println("choisir le module");
		 this.affichermoduleClass();
		 int modulechoisi=sc.nextInt();
		 sc.nextLine();
		 int i =1;
		 for(Module m:this.moduleClass) {
			 if(i==modulechoisi) {
				 i=1;
				 System.out.println("choisir l'element");
				 m.affichEleModule();
				 int elementchoisi=sc.nextInt();
				 sc.nextLine();
				 for (Element e: m.getEleModule()) {
					 if (i==elementchoisi) {
						 
						 System.out.println("choisir l'etudiant ");
						 this.affichestudClass();
						 int studchoisi=sc.nextInt();
						 sc.nextLine();
						 i=1;
						 for (Student s:this.stud) {
							 if(i==studchoisi) {
								 
								 System.out.println("entrer la note de l'element");
								 int note=sc.nextInt();
								 sc.nextLine();
								 e.modnote(s,note);
								 break;
							 }
							 else i++;
						 }
						 break;
					 }
					 else i++;
				 }
				 break;
			 }
			 else i++;
		 }
		 
	 }
	 public void examEDT(String date) throws ParseException {
		 EDT edt = new EDT (date);
		 System.out.println("Cette semaine sera la semaine des examents");
		 int r=2;
		 while(r==2) {
			 System.out.println("choisir le module :");
			 this.affichermoduleClass();
			 int modulechoisi=sc.nextInt();
			 sc.nextLine();
			 int i =1;
			 
			 for (Module m:moduleClass ) {
				 if (i==modulechoisi) {
					 i=1;
					 r=1;
					 while(r==1) {
						 System.out.println("choisir l'element:");
						 m.affichEleModule();
						 int elementchoisi=sc.nextInt();
						 r=3;
						 for (Element e:m.getEleModule()) {
							 if(i==elementchoisi) {
								 System.out.println("entrer le jour de la semaine"+Newligne+"1-Lun"+Newligne+ "2-Mar" +Newligne+"3-Mer"+Newligne+ "4-Jeu" +Newligne+"5-Ven" +Newligne+"6-Sam");
								 int jour=sc.nextInt();
								 sc.nextLine();
								 System.out.println("entrer la p�riode "+Newligne+"1-Matin"+Newligne+"2-Apr�s-midi");
								 int periode=sc.nextInt();
								 sc.nextLine();
								 System.out.println("entrer la dur�e sous forme h:mm");
								 String duree = sc.nextLine();
								 
								 edt.addElementExam(jour, periode, e, duree);
								 break;
							 }
							 else i++;
						 }
					 }
					 break;
				 }
				 else i++;
			 }
		 }
		 this.emploi.add(edt); 
	 }
	 public Module choisirModule(int a) {
		 int i=1;
		 for (Module m : this.moduleClass) {
			 if(i==a) {
				 return m;		
			 }
			 else i++;
		 }
		 return null;
	 }
	
	 public void addAbsence(String date,int studchoisi,int modulechoisi,int elementchoisi) throws ParseException{
		 Date d=s.parse(date);
		 int v=0;
		 for (Absence a :this.abs) {
			 if(a.getElement().equals(this.choisirModule(modulechoisi).choisieElement(elementchoisi))&& a.getDate()==d){
				 
				 a.addAbsence(this.choisirStud(studchoisi));
				 v=1;
			 break;
			 }
			 		 
		 }
		 if (v==0) {
			Absence abs=new Absence(this.choisirModule(modulechoisi).choisieElement(elementchoisi),date);
			abs.addAbsence(this.choisirStud(studchoisi));
		 }
		 
	 }
	//----------------------------------AFFICHAGE---------------------------------------------------------------------
	public void afficheEdt() {
		int i=1;
		for (EDT edt:this.emploi) {
			System.out.println(i+"- l'EDT de "+ edt.toString());
			i++;
		}
	}
	public void afficheEdtClass() {
		System.out.println("choisir l'EDT:");
		this.afficheEdt();
		int edtchoisi=sc.nextInt();
		int i=1;
		for (EDT edt:this.emploi) {
			if(i==edtchoisi) {
				if (edt.getExamcheck().equals("exam")) {
					edt.afficheEDTExam();
					break;
				}
				else {
					edt.afficheEDT();
					break;
				}
				
			}
			else i++;
		}
	}
	public void afficherElementClass() {
		System.out.println("choisir le module");
		this.affichermoduleClass();
		int modulechoisi= sc.nextInt();
		 int i=1;
		 for (Module m: this.moduleClass) {
			 if (i==modulechoisi) {
				m.affichEleModule();
				break;
			 }
			 else i++;
		 }
	}
	public void afficherheursModuleClass () {
		System.out.println("choisir le module :");
		this.affichermoduleClass();
		int modulechoisi = sc.nextInt();
		int i=1;
		for (Module m : this.moduleClass) {
			if (i==modulechoisi) {
				m.afficheheuresModule();
				break;
			}
			else i++;
		}
	}

	
	//----------------------------------GETTERS & SETTERS--------------------------------------------------------------
	public Promo getPromo() {
		return promo;
	}
	public void setPromo(Promo promo) {
		this.promo = promo;
		
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Set<Student> getStud() {
		return stud;
	}
	public void setStud(Set<Student> stud) {
		this.stud = stud;
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	
	
	
}
