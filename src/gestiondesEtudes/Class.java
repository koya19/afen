package gestiondesEtudes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import gestiondeScolarit�.Element;
import gestiondeScolarit�.Module;
import gestiondeScolarit�.Absence;
import gestiondeScolarit�.EDT;
import java.util.*;






public class Class  implements Comparable<Class> {
	protected Ecole ecole;
	protected Promo promo;
	protected Filiere filiere;
	protected Set <Student> stud =new TreeSet <>();
	public Set <Module> moduleClass=new HashSet<>();
	public Set <EDT> emploi= new HashSet<>();
	public Set <Absence> abs=new HashSet <>();
	public Set <Prof> profClass= new HashSet<>();
	SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
	Scanner sc=new Scanner(System.in);
	String Newligne=System.getProperty("line.separator");
	//-----------------------------------------------------------------------------------------	
	public Class() {
	}
	@SuppressWarnings("unused")
	public Class(Filiere filiere,Promo promo) {
		this.filiere=filiere ;
		this.promo=promo ;
		promo.classPromo.add(this);
		filiere.classFiliere.add(this);
		filiere.ecole.classEcole.add(this);
		filiere.ecole.classEcole.add(this);
		this.ecole=this.filiere.ecole;

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String Newligne=System.getProperty("line.separator");
		SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");



		System.out.println("\nVous avez cr�� la classe " + this.toString() );
	}
	//-----------------------------------------------------------------------------------------

	//-----------------------------------------------------------------------------------------	
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

	public void addStud(Student s) {
		if (stud.contains(s))
			System.out.println("\nL'�tudiant "+ s.lastnamePers+" "+ s.firstnamePers + " existe d�ja dans la classe "+ filiere.nomFili�re+" "+promo.nPromo);
		else
			stud.add(s);
		promo.studPromo.add(s);
		filiere.studFiliere.add(s);
		ecole.studEcole.add(s);
		ecole.pwdEcole.put(s, s.pwd);
		s.c=this;
		s.fili�re=this.filiere;

		//Collections.sort(l);
		System.out.println("\nVous avez ajout� l'�tudiant "+s.lastnamePers+" "+  s.firstnamePers +" "+ " � la classe "+ filiere.nomFili�re+" "+promo.nPromo);

	}

	public String toString() {
		return  filiere.nomFili�re+" "+promo.nPromo ;
	}

	@SuppressWarnings("rawtypes")
	public void affichestudClass() {
		if(this.stud.isEmpty()) {
			System.err.println("Pas d'�tudiant pour le moment");
		}
		else {
			Iterator iterator = stud.iterator();
			int i=1;
			System.out.println("\nLes �l�ves de la classe "  + this.toString());	
			while (iterator.hasNext()){
				System.out.println("    "+i+"-"+iterator.next());
				i++;
			}
		}

	}
	public void affichermoduleClass() {

		System.out.println("\nLes modules de cette classe sont : ");
		int i=1;
		for (Module module: moduleClass) {
			System.out.println(i+"-"+module.toString());
			i++;
		}

	}
	public void afficherProf() {
		int a=0;
		while(a==0) {
			System.out.println("\nChoisissez un module :");
			this.affichermoduleClass();
			try {
				int modulechoisi=sc.nextInt();
				if(0>modulechoisi|| modulechoisi>this.moduleClass.size()) {
					throw new InputMismatchException("Ce choix est invalide.");
				}
				sc.nextLine();
				int i=1;
				for (Module m: this.moduleClass) {
					if (i==modulechoisi) {
						if(m.profClass.isEmpty()) {
							System.err.println("Pas de prof dans ce Module");
							break;
						}
						else {
							i=1;
							System.out.println("\nChoisissez un �l�ment:");
							m.affichEleModule();
							int elementchoisi=sc.nextInt();
							if(0>elementchoisi|| elementchoisi>m.getEleModule().size()) {
								throw new InputMismatchException("Ce choix est invalide.");
							}
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
	}

	public void removeStudClass(Student s) {


		stud.remove(s);
		System.out.println("\nVous avez retir� "+ s.toString()+" de la classe "+ this.toString());
	}
	public void afficherespoClass() {
		filiere.r.toString();
		System.out.println("\nLe responsable de la classe "+ this.toString()+" est "+ filiere.r.toString());
	}

	public void modEdt() {
		System.out.println("\nChoisissez un EDT :");
		this.afficheEdt();
		int emploichoisi=sc.nextInt();
		int i=1;
		for (EDT edt:this.emploi) {
			if(i==emploichoisi) {
				int r=2;
				while(r==2) {
					System.out.println("\nChoisissez un module :");
					this.affichermoduleClass();
					int modulechoisi=sc.nextInt();
					sc.nextLine();
					i =1;

					for (Module m:moduleClass ) {
						if (i==modulechoisi) {
							i=1;
							r=1;
							while(r==1) {
								System.out.println("\nChoisissez un �l�ment :");
								m.affichEleModule();
								int elementchoisi=sc.nextInt();
								r=3;
								for (Element e:m.getEleModule()) {
									if(i==elementchoisi) {
										System.out.println("\nEntrez le jour de la semaine"+Newligne+" 1) Lun"+Newligne+ " 2) Mar" +Newligne+" 3) Mer"+Newligne+ " 4) Jeu" +Newligne+" 5) Ven" +Newligne+" 6) Sam");
										int jour=sc.nextInt();
										System.out.println("\nEntrez la p�riode "+Newligne+" 1) Matin"+Newligne+" 2) Apr�s-midi");
										int periode=sc.nextInt();
										System.out.println("\nChoisissez une dicipline"+Newligne+" 1) CM"+Newligne+" 2) TP"+Newligne+" 3) TD"+Newligne+" 4) AP");
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
										System.out.println("\nChoisissez votre prochaine action :"+Newligne+" 1) Ajouter un autre �l�ment du "+m.toString()+Newligne+" 2) Ajouter un �l�ment d'un autre module "+Newligne+" 3) Retour");
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
				break;
			}
			else i++;
		}

	}
	public void addprof(Prof prof) {
		String Newligne=System.getProperty("line.separator");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nChoisissez un module :");
		this.affichermoduleClass();
		int modulechoisi=sc.nextInt();
		sc.nextLine();

		int i=1;
		for (Module m: this.moduleClass) {
			if(i==modulechoisi) {
				i=1;
				prof.module=m;
				System.out.println("\nChoisissez un �l�ment :");
				m.affichEleModule();
				int elementchoisi=sc.nextInt();
				sc.nextLine();
				for(Element e:m.getEleModule()) {
					i=1;
					prof.element=e;
					System.out.println("\nChoisissez une discipline"+Newligne+" 1) CM"+Newligne+" 2) TP"+Newligne+" 3) TD"+Newligne+" 4) AP");
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
		sc.close();
	}
	public void repartiondesheursElement() {

		Scanner sc=new Scanner(System.in);
		System.out.println("\nChoisissez un module : ");
		this.affichermoduleClass();
		int modulechoisi=sc.nextInt();
		sc.nextLine();

		int i=1;
		for (Module m: this.moduleClass) {
			if(i==modulechoisi) {
				i=1;
				System.out.println("\nChoisissez un �l�ment :");
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
		sc.close();
	}

	public void addEDT(String date) throws ParseException {


		Scanner sc=new Scanner(System.in);
		EDT edt=new EDT(date);

		int r=2;
		while(r==2) {
			System.out.println("\nChoisissez un module :");
			this.affichermoduleClass();
			int modulechoisi=sc.nextInt();
			sc.nextLine();
			int i =1;

			for (Module m:moduleClass ) {
				if (i==modulechoisi) {
					i=1;
					r=1;
					while(r==1) {
						System.out.println("\nChoisissez un �l�ment :");
						m.affichEleModule();
						int elementchoisi=sc.nextInt();
						r=3;
						for (Element e:m.getEleModule()) {
							if(i==elementchoisi) {
								if (e.getTotalheure()==0) {
									System.err.println("\nLes heures de cet �l�ment sont �puis�es"); 
									r=2;
									break;
								}
								else {
									e.setTotalheure(e.getTotalheure()-4);
									m.setHeureModule();

									System.out.println("\n--Entrez le jour de la semaine\n    1) Lun\n    2) Mar\n    3) Mer\n    4) Jeu\n    5) Ven\n    6) Sam");
									int jour=sc.nextInt();
									System.out.println("\n--Entrez la p�riode \n    1) Matin\n    2) Apr�s-midi");
									int periode=sc.nextInt();
									System.out.println("\nChoisissez la dicipline\n    1) CM\n    2) TP\n    3) TD\n    4) AP");
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
									System.out.println("--Choisissez votre prochaine action:\n    1) Ajouter un autre �l�ment du "+m.toString()+"\n    2) Ajouter un �l�ment d'un autre module \n    3) Retour");
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
		System.out.println("\nVous avez ajout� un EDT");
		sc.close();

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
	public void removeElement(int a ) {
		int i=1;
		for (Module m: this.moduleClass) {
			if (i==a) {
				i=1;
				while(i==1) {
					System.out.println("\nChoisissez l'�l�ment � retirer :");
					m.affichEleModule();
					try {
						int elementchoisi=sc.nextInt();
						sc.nextLine();
						for (Element e: m.getEleModule()) {
							if(i==elementchoisi) {
								m.getEleModule().remove(e);
							}
							else i++;
						}
						break;
					}catch(InputMismatchException e) {
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						i=0;

					}
					catch(NullPointerException e) {
						System.out.println();
						System.err.println("Pas de choix actuellement.");
						sc.nextLine();
						i=0;
					}
				}
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
	public void affichernoteStud(Student s) {
		for (Module m: this.moduleClass) {
			System.out.println("Vos notes du module "+m.toString());
			for (Element e: m.getEleModule()) {
				e.affichenoteStud( s);
			}
			System.out.println("\nLa moyenne :"+ m.noteModule.get(s));
		}
	}
	public void addnoteStud() {
		int a=2;
		while(a==2) {
			System.out.println("\nChoisissez le module :");
			this.affichermoduleClass();
			try {
				int modulechoisi=sc.nextInt();
				sc.nextLine();
				if(1>modulechoisi|| modulechoisi>this.moduleClass.size()) {
					throw new InputMismatchException("Ce choix est invalide.");
				}
				a=1;

				int i =1;
				for(Module m:this.moduleClass) {
					if(i==modulechoisi) {
						i=1;
						while(a==1) {
							System.out.println("\nChoisissez l'�l�ment :");
							m.affichEleModule();

							try {
								int elementchoisi=sc.nextInt();
								sc.nextLine();
								if(1>elementchoisi|| elementchoisi>m.getEleModule().size()) {
									throw new InputMismatchException("Ce choix est invalide.");
								}
								a=2;
								for (Element e: m.getEleModule()) {
									if (i==elementchoisi) {


										for (Student s:this.stud) {

											System.out.println("\nEntrer la note de l'�l�ment de l'etudiant "+ s.toString());
											int note=sc.nextInt();
											sc.nextLine();
											e.modnote(s,note);
											System.out.println("    1) Entrez les notes d'un autre �l�ment\n    2) Entrez les notes des �lement d'un autres modules\n    3) Retour");
											a=sc.nextInt();

										}
										break;

									}
									else i++;
								}

							}catch(InputMismatchException e) {
								System.out.println();
								System.err.println("Ce choix est invalide");
								sc.nextLine();
								a=1;

							}
							catch(NullPointerException e) {
								System.out.println();
								System.err.println("Pas de choix actuellement.");
								sc.nextLine();
								a=1;
							}
						}
					}

					else i++;
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Ce choix est invalide");
				sc.nextLine();
				a=2;

			}
			catch(NullPointerException e) {
				System.out.println();
				System.err.println("Pas de choix actuellement.");
				sc.nextLine();
				a=2;
			}
		}

	}
	public void ModnoteStud() {
		int a=0;
		while(a==0) {
			System.out.println("\nChoisissez un module :");
			this.affichermoduleClass();
			try {
				int modulechoisi=sc.nextInt();
				sc.nextLine();
				if(1>modulechoisi|| modulechoisi>this.moduleClass.size()) {
					throw new InputMismatchException("Ce choix est invalide.");
				}
				a=1;

				int i =1;
				for(Module m:this.moduleClass) {
					if(i==modulechoisi) {
						i=1;
						while(a==1) {
							System.out.println("choisir l'element");
							m.affichEleModule();

							try {
								int elementchoisi=sc.nextInt();
								sc.nextLine();
								if(1>elementchoisi|| elementchoisi>m.getEleModule().size()) {
									throw new InputMismatchException("Ce choix est invalide.");
								}
								a=2;
								for (Element e: m.getEleModule()) {
									if (i==elementchoisi) {
										System.out.println("\nChoisissez un �tudiant :");
										this.affichestudClass();
										int studchoisi=sc.nextInt();
										i=1;
										for (Student s:this.stud) {
											if(i==studchoisi) {
												System.out.println("\nEntrez la note de l'�l�ment de l'�tudiant "+ s.toString());
												int note=sc.nextInt();
												sc.nextLine();
												e.modnote(s,note);
												break;
											}
											else	i++ ;


										}
										break;

									}
									else i++;
								}
								break;
							}catch(InputMismatchException e) {
								System.out.println();
								System.err.println("Ce choix est invalide");
								sc.nextLine();
								a=1;

							}
							catch(NullPointerException e) {
								System.out.println();
								System.err.println("Pas de choix actuellement.");
								sc.nextLine();
								a=1;
							}
						}
					}

					else i++;
				}
			}catch(InputMismatchException e) {
				System.out.println();
				System.err.println("Ce choix est invalide");
				sc.nextLine();
				a=0;

			}
			catch(NullPointerException e) {
				System.out.println();
				System.err.println("Pas de choix actuellement.");
				sc.nextLine();
				a=0;
			}
		}

	}
	public void examEDT(String date) throws ParseException {
		EDT edt = new EDT (date);
		System.out.println("Cette semaine sera la semaine des examens");
		int r=2;
		while(r==2) {
			System.out.println("\nChoisissez un module :");
			this.affichermoduleClass();
			int modulechoisi=sc.nextInt();
			sc.nextLine();
			int i =1;

			for (Module m:moduleClass ) {
				if (i==modulechoisi) {
					i=1;
					r=1;
					while(r==1) {
						System.out.println("\nChoisissez un �l�ment :");
						m.affichEleModule();
						int elementchoisi=sc.nextInt();
						r=3;
						for (Element e:m.getEleModule()) {
							if(i==elementchoisi) {
								System.out.println("\n--Entrez le jour de la semaine\n    1) Lun\n    2) Mar\n    3) Mer\n    4) Jeu\n    5) Ven\n    6) Sam");
								int jour=sc.nextInt();
								sc.nextLine();
								System.out.println("\n--Entrez la p�riode \n    1) Matin\n    2) Apr�s-midi");
								int periode=sc.nextInt();
								sc.nextLine();
								System.out.println("\nEntrez la dur�e sous forme h:mm");
								String duree = sc.nextLine();
								edt.addElementExam(jour, periode, e, duree);
								System.out.println("\nChoisissez votre prochaine action :"+Newligne+" 1) Ajouter un autre �l�ment du "+m.toString()+Newligne+" 2) Ajouter un �l�ment d'un autre module "+Newligne+" 3) Retour");
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
		this.emploi.add(edt); 
	}
	public Module choisirModule() {

		Module m=new Module("",this);
		if(this.moduleClass.isEmpty()) {
			System.err.println("Pas de module pour le moment");
		}
		else {
			int i=0;
			while(i==0) {
				System.out.println("\n--Choisissez un module  :");
				this.affichermoduleClass();
				try {
					int modulechoisi=sc.nextInt();
					sc.nextLine();
					if (0>modulechoisi ||  modulechoisi>this.moduleClass.size()) {
						throw new InputMismatchException("Ce choix est invalide.")	;
					}
					i=1;
					for (Module module : this.moduleClass) {
						if(i==modulechoisi) {
							m=module;	
							break;
						}
						else i++;
					}
					break;
				}catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					i=0;


				}
				catch(NullPointerException e) {
					System.out.println();
					System.err.println("Pas de choix actuellement.");
					sc.nextLine();
					i=0;

				}
			}}
		return m;
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

	public void addAbs() throws ParseException {
		System.out.println("\nVeuillez entrer la date du jour sous forme dd mm yyyy");
		String d=sc.next();
		Date date=s.parse(d);
		for(EDT edt:this.emploi) {

			if ((date.compareTo(edt.getBegin())>=0 && date.compareTo(edt.getEnd())<=0)==false) {
				System.out.println("\nCette date est introuvable");
			}
			else {
				int i=0;
				while(i==0) {

					System.out.println("\nChoisissez un module :");
					this.affichermoduleClass();
					try {
						int modulechoisi=sc.nextInt();
						if(1>modulechoisi|| modulechoisi>this.moduleClass.size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						System.out.println("choisir element");
						this.choisirModule(modulechoisi).affichEleModule();
						int elementchoisi=sc.nextInt();
						if(1>elementchoisi|| elementchoisi>this.choisirModule(modulechoisi).getEleModule().size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						System.out.println("\nChoisissez un �tudiant :");
						this.affichestudClass();
						int studchoisi=sc.nextInt();
						if(1>studchoisi|| studchoisi>this.stud.size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						this.addAbsence(d,studchoisi,modulechoisi,elementchoisi);
					}catch(InputMismatchException e) {
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						i=0;


					}
					catch(NullPointerException e) {
						System.out.println();
						System.err.println("Pas de choix actuellement.");
						sc.nextLine();
						i=0;

					}

				}
			}
		}
	}
	public void justifieAbs() throws ParseException {
		System.out.println("\nVeuillez entrez la date du jour sous forme dd MM yyyy");
		String d=sc.next();
		Date date=s.parse(d);
		for(EDT edt:this.emploi) {

			if ((date.compareTo(edt.getBegin())>=0 && date.compareTo(edt.getEnd())<=0)==false) {
				System.out.println("\nCette date est introuvable");
			}
			else {
				int i=0;
				while(i==0) {

					System.out.println("\nChoisissez un module :");
					this.affichermoduleClass();
					try {
						int modulechoisi=sc.nextInt();
						if(1>modulechoisi|| modulechoisi>this.moduleClass.size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						System.out.println("\nChoisissez un �l�ment :");
						this.choisirModule(modulechoisi).affichEleModule();
						int elementchoisi=sc.nextInt();
						if(1>elementchoisi|| elementchoisi>this.choisirModule(modulechoisi).getEleModule().size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						System.out.println("\nChoisissez un �tudiant :");
						this.affichestudClass();
						int studchoisi=sc.nextInt();
						if(1>studchoisi|| studchoisi>this.stud.size()) {
							throw new InputMismatchException("Ce choix est invalide.");
						}
						for(Absence abs: this.abs) {
							if(abs.getElement().getNomElement().equals(this.choisirModule(modulechoisi).choisieElement(elementchoisi).getNomElement()) && abs.getDate().compareTo(date)==0) {
								abs.justifieAbs(this.choisirStud(studchoisi));
								break;
							}
							System.out.println("\nCette fiche d'absence est introuvable");
						}
					}catch(InputMismatchException e) {
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						i=0;


					}
					catch(NullPointerException e) {
						System.out.println();
						System.err.println("Pas de choix actuellement.");
						sc.nextLine();
						i=0;

					}

				}
			}
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
		if (this.emploi.isEmpty()==true) {
			System.err.println("\nPas d'emploi pour le moment\n");
		}
		else{
			int a=0;
			while(a==0) {
				System.out.println("\\n--Choisissez un EDT:");
				this.afficheEdt();
				try {
					int edtchoisi=sc.nextInt();
					if(1>edtchoisi|| edtchoisi>this.emploi.size()) {
						throw new InputMismatchException("Ce choix est invalide.");
					}

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
					break;
				}catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					a=0;

				}
				catch(NullPointerException e) {
					System.out.println();
					System.err.println("Pas de choix actuellement.");
					sc.nextLine();
					a=0;
				}
			}

		}
	}
	public void afficherElementClass() {
		if(this.moduleClass.isEmpty()) {
			System.err.println("Pas de module pour le moment");

		}
		else {
			int a=0;
			while(a==0) {
				System.out.println("\n--Choisissez un module :");
				this.affichermoduleClass();
				try {
					int modulechoisi= sc.nextInt();
					if (0>modulechoisi || modulechoisi>this.moduleClass.size()) {
						throw new InputMismatchException("Ce choix est invalide.")	;
					}

					int i=1;
					for (Module m: this.moduleClass) {
						if (i==modulechoisi) {
							if(m.getEleModule().isEmpty()) {
								System.err.println("Pas d'element dans ce module");
								break;
							}
							else {
								m.affichEleModule();
								break;
							}
						}
						else i++;
					}
					break;
				}catch(InputMismatchException e) {
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					a=0;
				}
				catch(NullPointerException e) {
					System.out.println();
					System.err.println("Pas de choix actuellement.");
					sc.nextLine();
					a=0;
				}
			}
		}
	}
	public void afficherheursModuleClass () {

		if (this.moduleClass.isEmpty()==true) {
			System.out.println("\nPas de module dans cette classe\n");
		}
		else {
			System.out.println("\n--Choisissez un module :");
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
	}
	public void writeProf(){
		File f=new File("ProfEcole.txt");
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(f))) {
			bw.write("Les enseignants de cette classe "+this.ecole.abrEcole+"\n\n");
			for (Module m: this.moduleClass) {
				for(Prof p:m.profClass) {
					bw.write(p.lastnamePers+"  "+p.firstnamePers+"      "+p.cniPers+"      "+p.module+"      "+p.element+"       \n");
				}

			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Impossible");
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	public void affichernoteModuleClass() {
		int r=2;
		while(r==2) {
			System.out.println("choisir le module :");
			this.affichermoduleClass();
			try {
				int modulechoisi=sc.nextInt();
				if(1>modulechoisi|| modulechoisi>this.moduleClass.size()) {
					throw new InputMismatchException("Ce choix est invalide.");
				}
				sc.nextLine();
				int i =1;
				for (Module m:moduleClass ) {
					if (i==modulechoisi) {
						m.affichenoteModuleClass();
						break;
					}
					i++;
				}
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
