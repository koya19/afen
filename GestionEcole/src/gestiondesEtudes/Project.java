package gestiondesEtudes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Project {

	public static void main(String[] args) throws ParseException   {
		Scanner sc= new Scanner(System.in);
		String Newligne=System.getProperty("line.separator");
		
		System.out.println("************************** BIENVENUE DANS LE SYSTEM ****************************" );
		System.out.println("**************************       Mr.directeur         ****************************\n\n" );
		System.out.println("-Entrez le nom de l'�cole");
		String nomEcole=sc.nextLine();
		System.out.println("-Entrez l'abreveation de l'�cole");
		String abrEcole=sc.nextLine();
		System.out.println("-Entrez le fondateur de l'�cole");
		String fondateur=sc.nextLine();
		System.out.println("-Entrez le type de l'�cole");
		String type=sc.nextLine();
		System.out.println("-Entrez l'adresse de l'�cole");
		String adressEcole=sc.nextLine();
		Ecole ecole=new Ecole(nomEcole, abrEcole,fondateur,type,adressEcole);
		System.out.println("--Veuillez entrer vos donn�es personelles");
		ecole.inscription();
		ecole.addfili�re();
		ecole.addclass();
		System.out.println("\n la phase de la cr�ation l'�cole est termin�e avec succ�s\n ");
		System.out.println("**************************BIENVENUE DANS LE SYSTEM "+ecole.abrEcole+"****************************\n\n" );
		int id=0;
		while (id==0) {//connection while(id==0)
			int e=0;
			while(e==0) {
				System.out.println("--Se connecter comme �tant:\n  1-Administrateur\n  2-Responsable de fili�re\n  3-Enseignant\n  4-Etudiant\n  5-Visiteur");
		 		try {//try 1
					id=sc.nextInt();	
					if (id!=1 && id!=2 && id!=3 && id!=4 && id!=5) {
						throw new InputMismatchException("Ce choix est invalide");
						}
					sc.nextLine();
					break;
				}//try 1
				catch(InputMismatchException er) {//catch 1
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					e=0;
				}//catch 1
		 		
			}
			
			System.out.println(" ->Entrez votre Nom ");
			String nom =sc.nextLine();
			System.out.println(" ->Entrez votre  Pr�nom");
			String prenom =sc.nextLine();
	 		
			
	 	
			if(id==1) {//connection admin
				System.out.println(" ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				administrateur admin=new administrateur(nom,prenom,pwd,ecole);
				if (admin.exist(ecole.adminEcole)==false) {//check l'existence du admin
					System.out.println("vous n'�tes pas membre de l'administration\n");
					id=0;
				}//check l'existence du admin
				else if (admin.verificationPWD()==false) {//check pwd
					System.out.println("le mot de passe est incorrecte.");
					id=0;
				}//check pwd
				else {// passwd et l'existence verifi� admin
					int ad1=0;
					while (ad1==0) {//menu d'administrateur
						System.out.println("--Choisir votre prochaine action:\n\n    1-G�stion des �tudes\n        2-Les statistiques et rapports\n    3-Retour\n");
						try {//try 1
							ad1=sc.nextInt();	
							if (ad1!=1 && ad1!=2 && ad1!=3 ) {
								throw new InputMismatchException("Ce choix est invalide");
								}
						}//try 1
						catch(InputMismatchException er) {//catch 1
							System.out.println();
							System.err.println("Ce choix est invalide");
							sc.nextLine();
							ad1=0;
						}//catch 1
						if(ad1==1) {//gestion des etudes
							int ad2=0;
							while (ad2==0) {//menu gestion des etudes
								System.out.println("--Choisir votre prochaine action:\n    1-Ajouter un Administrateur\n    2-Ajouter une fili�re\n    3-Ajouter une classe\n    4-Retirer une fili�re\n    5-Retirer une classe\n    6-Retirer un administrateur\n    7-Changer le responsable d'une fili�re\n    8-Retour\n");
								try {//try 2
									ad2=sc.nextInt();	
									if (ad2!=1 && ad2!=2 && ad2!=3 && ad2!=4 && ad2!=5 && ad2!=6 && ad2!=7 && ad2!=8) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 2
								catch(InputMismatchException er) {//catch 2
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									ad2=0;
								}//catch2
								if(ad2==1) {//ajouter un admin
									ecole.inscription();
									ad2=0;
								}//ajouter un admin
								if(ad2==2) {//ajouter une fili�re
									ecole.addfili�re();
									ad2=0;
								}//ajouter une fili�re
								if(ad2==3) {//ajout d'une class
									ecole.addclass();
									ad2=0;
								}//ajout d'une class
								if(ad2==4) {//retirer une fili�re
									ecole.removeFili�re();
									ad2=0;
								}//retirer une fili�re
								if(ad2==5) {//retirer une classe
									ecole.removeClass();
									ad2=0;
								}//retirer une classe
								if(ad2==6) {//retirer un admin
									ecole.removeAdmin();
									ad2=0;
								}//retirer un admin
								if(ad2==7) {//changer un respp
									ecole.modResp();
									ad2=0;
								}//changer un respp
								if (ad2==8) {//retour2
									ad1=0;	
									
								}//retour2	
							}//menu gestion des etudes
						}//gestion des etudes
						
				
						if(ad1==2) {//les statistique et rapports
							int ad2=0;
							while (ad2==0) {//menu les statistique et rapports
								System.out.println("--Choisir votre prochaine action:\n\n    1-Statistiques et rapport sur les �tudes\n    2-Statistiques et rapport sur la scolarit�\n    3-Statistiques et rapport sur les exams\n    4-Retour\n");
								try {//try 2
									ad2=sc.nextInt();	
									if (ad2!=1 && ad2!=2 && ad2!=3 && ad2!=4) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 2
								catch(InputMismatchException er) {//catch 2
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									ad2=0;
									
								}//catch2
								if (ad2==1) {//stat sur les etudes
									while(ad2==1){//menu statist d'etudes
										System.out.println("Choisir votre prochaine action:\n    1-Afficher les fili�res de l'�cole\n    2-Afficher les classes d'une fili�re\n    3-Afficher les heures des modules pour chaque filli�re\n    4-Afficher les emploies du temps\n    5-Retour\n");
										try {//try 2
											ad2=sc.nextInt();	
											if (ad2!=1 && ad2!=2 && ad2!=3 && ad2!=4 && ad2!=5) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 2
										catch(InputMismatchException er) {//catch 2
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											ad2=0;
											
										}//catch2
										if(ad2==1) {//aficher les filli�re
											ecole.affichefiliereEcole();
											ad2=1;
										}//aficher les filli�re
										if(ad2==2) {//afficher les classes
											ecole.afficheclassFiliere();
											ad2=1;
										}//afficher les classes
										if(ad2==3) {//afficher les heures du modules
											ecole.afficherheurModule();
											ad2=1;
										}//afficher les heures du modules
										if(ad2==4) {//afficher les EDT
											ecole.afficherEDT();
											ad2=1;
										}//afficher les EDT
										if(ad2==5) {
											ad2=0;
										}
									}//menu statist d'etudes
								}//stat sur les etudes
								if(ad2==2) {//stat sur la scolarit�
									
								}//stat sur la scolarit�
								if(ad2==3) {//stat sur les examen
									
								}//stat sur les examen
								if(ad2==4) {//retour2
									ad1=0;
								}//retour2
							}//menu les statistique et rapports
						}//les statistique et rapports
						if(ad1==3) {//retour1
							System.out.println("Merci pour votre visite.");
							id=0;
						}//retour1
					
					}//menu d'administrateur
					
				}// passwd et l'existence verifi� admin
			
				
				
				
				
			}////connection admin
	////---------------------------------------------Responsable de fili�re----------------------------------------
			if(id==2) {//connection responsable de fili�re
				System.out.println(" ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				if (ecole.respoEcole.isEmpty()==true) {//existence des responsable
					System.out.println("Pas de responsable pour le moment.");
					id=0;
				}//existence des responsable
				else {//le SET n'est p vide
					
					Respo resp =ecole.connectionRespo(nom, prenom, pwd);
					if(resp.exist()==false) {//existences du respo connecte
						System.out.println("Vous n'�tes pas inscrit comme un responsable.");
						id=0;
					}//existences du respo connecte
					else if(resp.verificationPWD()==false) {//verifi pwd
						System.out.println("le mot de passe est incorrecte");
						id=0;
					}//verifi pwd
					else {//pwd o existence verifi�
						int r1=0;
						while (r1==0) {//menu respo
							System.out.println("--Choisir votre prochaine action:\n\n    1-G�stion des �tudes\n    2-G�stion de scolarit�\n    3-Retour\n");
							try {//try 1
								r1=sc.nextInt();	
								if (r1!=1 && r1!=2 && r1!=3 ) {
									throw new InputMismatchException("Ce choix est invalide");
									}
							}//try 1
							catch(InputMismatchException er) {//catch 1
								System.out.println();
								System.err.println("Ce choix est invalide");
								sc.nextLine();
								r1=0;
							}//catch 1
							
							if(r1==1) {//gestion des etudes
								r1=0;
								while (r1==0) {//MENU GESTION DES ETUDES
									System.out.println("\nChoisir votre prochaine action:\n\n    1-Ajout des modules pour une classe\n    2-ajout d'element\n    3-Retirer un module\n    4-Retirer un �l�ment\n    5-Gestion d'emploi\n    6-Afficher les donn�es de la fili�re\n    7-Retour\n");
									try {//try 1
										r1=sc.nextInt();	
										if (r1!=1 && r1!=2 && r1!=3 && r1!=4&& r1!=5 && r1!=6 && r1!=7 && r1!=8) {
											throw new InputMismatchException("Ce choix est invalide");
											}
									}//try 1
									catch(InputMismatchException er) {//catch 1
										System.out.println();
										System.err.println("Ce choix est invalide");
										sc.nextLine();
										r1=0;
										
									}//catch 1
									
									if (r1==1) {//Ajout des modules pour une classe
										ecole.addModule(resp.fili�re);
										
										r1=0;
									}//Ajout des modules pour une classe
									
									if(r1==2) {//2-ajout d'element
										ecole.addElement(resp.fili�re);
										r1=0;
									}//2-ajout d'element
									
									if(r1==3) {//Retirer un module
										ecole.removeModule(resp.fili�re);
										r1=0;
									}//Retirer un module
									if(r1==4) {//Retirer un �l�ment
										ecole. removeElement(resp.fili�re);
										r1=0;
									}//Retirer un �l�ment
									
									if(r1==5) {//Gestion d'emploi
										
										
										Class cl= resp.fili�re.choisirClassFilere();
										
										SimpleDateFormat s= new SimpleDateFormat("dd MM yyyy");
										int r2=0;
										while(r2==0) {
											System.out.println("choisir votre prochaine action \n    1-creer un nouveau EDT\n    2-modifier un edt\n    3-retour");
											r2=sc.nextInt();
											sc.nextLine();
											
											if (r2==1) {//creer un new EDT
												while(r2==1) {
												System.out.println("veuillez entrer la date de d�but de l'emploi sous forme 'dd mm yyyy' \n");
												String date=sc.nextLine();
												if(s.parse(date).getDay()==1) {
													if (cl.testheurModule()==false) {//semaine normale
														cl.addEDT( date);
														r2=0;
														break;
													}//semaine normale
													
													else {//semaine exam
														cl.examEDT( date);
														r2=0;
													}//semaine exam
													
												}
												else {
													System.err.println("veullez saisir la date du debut de la semaine\n");
													r2=1;
												}
												}
											}//creer un new EDT
											if(r2==2) {//modifier EDT
											}//modifier EDT
											
											 if (r2==2) {//modifier l'edt
												
												cl.modEdt();
												r2=0;
											}//modifier l'edt
											
											 if(r2==3) {//retour
												 r1=0;
											 }
										}
										
											
									
													
										
											
										
									}//Gestion d'emploi
									
									if(r1==6) {//Afficher les donn�es
										int r2=0;
										while(r2==0) {//menu d'affichage
											System.out.println("choisir votre prochaine action:\n    1-afficher les classes de la fili�re"+resp.fili�re.nomFili�re+"\n    2-afficher les �tudiants de la fili�re"+resp.fili�re.nomFili�re+"\n    3-afficher les profs de la fili�re"+resp.fili�re.nomFili�re+"\n    4-afficher les emploies d'une classe"+resp.fili�re.nomFili�re+"\n    5-afficher les modules d'une classes"+resp.fili�re.nomFili�re+"\n    6-afficher les element d'un module"+resp.fili�re.nomFili�re+"\n    7-Retour\n");										
											try {//try 1
											r2=sc.nextInt();
											if (r2!=1 && r2!=2 && r2!=3 && r2!=4&& r2!=5 && r2!=6 && r2!=7 ) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 1
										catch(InputMismatchException er) {//catch 1
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											r2=0;
											
										}//catch 1
											
								
											if (r2==1) {//AFFICHAGE classe
												
												resp.fili�re.afficheClassFiliere();
												r2=0;
											}//AFFICHAGE classe
											if(r2==2) {//affichage etudiant
												
												Class cl= resp.fili�re.choisirClassFilere();
												cl.affichestudClass();
												r2=0;
											}//affichage etudiant
											if (r2==3) {//afficher les profs
												
												Class cl= resp.fili�re.choisirClassFilere();
												
												cl.afficherProf();
												r2=0;
												
											}//afficher les profs
											if(r2==4) {// affichage les emploi
												
												Class cl= resp.fili�re.choisirClassFilere();
												cl.afficheEdtClass();
												r2=0;
											}//affichage les emploi
											if (r2==5) {// affichage module
												Class cl= resp.fili�re.choisirClassFilere();
												cl.affichermoduleClass();
												r2=0;
											}// affichage module
											if(r2==6) {//affichage element 
												Class cl= resp.fili�re.choisirClassFilere();
												cl.afficherElementClass();
												r2=0;
												
											}//affichage element 
											
											if (r2==7) {//retour
												r1=0	;
											}//retour
										
										
										}//menu d'affichage
										
									}//Afficher les donn�es
								
									if(r1==7) {//retour 1
										r1=0;
										break;
									}//retour 1
								}//MENU GESTION DES ETUDES
						
							}//gestion des etudes
						
							if(r1==2) {//gestion de scolarit�  
								int r2=0;
								while(r2==0) {//MENU GESTION SCOLARIT2
									System.out.println("choisir votre prochaine action:\n    1-Gestion des abscences\n    2-Gestion des notes\n    3-Retour\n");
									try {
									r2=sc.nextInt();
									if (r2!=1 && r2!=2  && r2!=3) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 1
								catch(InputMismatchException er) {//catch 1
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									r2=0;
									
								}//catch 1
									
									
						
									if (r2==1) {//gestion des notes
										int r3=0;
										while(r3==0) {
											System.out.println("choisir votre prochaine action:\n    1-Entrer les notes\n    2-Modifier les notes\n    3-Afficher les notes\n   4-Retour");
											try {
											r3=sc.nextInt();
											if (r2!=1 && r2!=2  && r2!=3 && r1!=4) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 1
										catch(InputMismatchException er) {//catch 1
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											r2=0;
											
										}//catch 1		
											if(r3==1) {//entrer les notes 
												Class cl=resp.fili�re.choisirClassFilere();
												cl.addnoteStud();
											}//entrer les notes
											if(r3==2) {//modifier les notes
												Class cl=resp.fili�re.choisirClassFilere();
												cl.ModnoteStud();
											}//modifier les notes
											if(r3==3) {//afficher les notes
												Class cl=resp.fili�re.choisirClassFilere();
												cl.affichernoteModuleClass();
											}//afficher les notes
											if(r3==4) {//retour
												r2=0;
											}//retour
										}
									}//gestion des notes
									if(r2==2) {//gestion des abscences
										r2=1;
										while(r2==1) {//menu de l'abs
											System.out.println("choisir votre prochaine action:\n    1-Ajouter l'absence\n    2-justifi� l'absence\n    3-Retour");
											try {
											r2=sc.nextInt();
											if (r2!=1 && r2!=2  && r2!=3) {
												throw new InputMismatchException("Ce choix est invalide");
												}
										}//try 1
										catch(InputMismatchException er) {//catch 1
											System.out.println();
											System.err.println("Ce choix est invalide");
											sc.nextLine();
											r2=0;
											
										}//catch 1	
											if(r2==1) {//ajout de l'abs
												Class cl = resp.fili�re.choisirClassFilere();
												cl.addAbs();
												r2=1;
											}//ajout de l'abs
											if(r2==2) {//justif
												Class cl = resp.fili�re.choisirClassFilere();
												cl.justifieAbs();
												r2=1;
											}//justif
											if(r2==3) {//retour
												r2=0;
											}//retour
										}//menu de l'abs
										
									}//gestion des abscences
									if(r2==3) {//retour
										r1=0;
										break;
									}//retour
									
								}//MENU GESTION SCOLARIT2
							}//gestion de scolarit�
							
							if(r1==3) {//retour1
								id=0;
							}//retour1
							
						}//menu respo
					}//pwd o existence verifi�
					
				}//le SET n'est p vide
				
		
			}//connection responsable de fili�re
			
//-----------------------------------------------------Prof---------------------------------------------
			
			if(id==3) {//connection enseignant
				System.out.println(" ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				if (ecole.profEcole.isEmpty()==true) {//existence des prof
					System.out.println("Pas d'enseignant pour le moment.");
					id=0;
				}//existence des prof
				else {//le SET n'est p vide
					Prof prof =new Prof (nom, prenom,pwd);
					if(prof.exist(ecole.profEcole)==false) {//existences du prof connecte
						System.out.println("Vous n'�tes pas inscrit comme un enseignant.");
						id=0;
					}//existences du prof connecte
					else if(ecole.profverificationPWD(prof)==false) {//verifi pwd
						System.out.println("le mot de passe est incorrecte");
						id=0;
					}//verifi pwd
					else {//pwd o existence verifi�
						for(Prof p:ecole.profEcole) {//affectation des donn�es
							if(p.equals(prof)) {//affectation des donn�es
								prof=p;
								break;
							}//affectation des donn�es
						}//affectation des donn�es
							int r1=0;
							while (r1==0) {//menu Prof
								System.out.println("--Choisir votre prochaine action:\n\n    1-Afficher les notes \n    2-afficher Emploi du temps\n    3-Retour\n");
								try {//try 1
									r1=sc.nextInt();	
									if (r1!=1 && r1!=2 && r1!=3 ) {
										throw new InputMismatchException("Ce choix est invalide");
										}
								}//try 1
								catch(InputMismatchException er) {//catch 1
									System.out.println();
									System.err.println("Ce choix est invalide");
									sc.nextLine();
									r1=0;
								}//catch 1
								if(r1==1) {//afficher les notes
									prof.element.affichenoteElement();
									r1=0;
								}
								if(r1==2) {//afficher l'emploi
									prof.module.cl.afficheEdtClass();
									r1=0;
								}
								if(r1==3) {//retour
									id=0;
								}
							}//menu Prof
						
						
					}//pwd o existence verifi�
				}
			}//connection enseignant
//---------------------------------------------STUD------------------------------------
			if(id==4) {//connection etudiant
				System.out.println(" ->Entrez votre mot de passe");
		 		String pwd =sc.nextLine();
				int s1=0;
				Student s= new Student(nom, prenom,pwd);
				while(s1==0) {//menu
				if(ecole.studEcole.isEmpty()) {//ecole vide
					System.out.println("Aucun Etudiant dans cette �cole\n s'inscrire?\n 1-oui\n 2-non\n");
					try {
					s1=sc.nextInt();
					
					if(s1!=1 && s1!=2) {
						throw new InputMismatchException("Ce choix est invalide");
					}
					if(s1==2) {
						s1=4;
					}
				}catch(InputMismatchException er) {//catch 1
					System.out.println();
					System.err.println("Ce choix est invalide");
					sc.nextLine();
					s1=0;
				}
				}//ecole vide
				else if(s.exist(ecole.studEcole)==false) {//n'existe pas
						
						System.out.println("Vous n'�tes pas un �tudiant de cette �cole :\n 1-s'inscrire\n 2-quitter");
						try {
						
						if(s1!=1 && s1!=2) {
							throw new InputMismatchException("Ce choix est invalide");
						}
						s1=sc.nextInt();
						if(s1==2) {
							s1=4;
						}
					}catch(InputMismatchException er) {//catch 1
						System.out.println();
						System.err.println("Ce choix est invalide");
						sc.nextLine();
						s1=0;
					}//catch 1
						}//n'existe pas
				else {//etudiant existant
					for(Student st:ecole.studEcole) {//affectation des fili�re
						if(st.equals(s)) {//affectation de fili�re
							s.fili�re=st.fili�re;
							break;
						}//affectation de fili�re
					}//affectation de fili�re
					
					 if (s.verificationPWD()==false) {   //pwd incorrecte
					System.out.println("Mot de passe incorrecte");
					id=0;
					break;
				}//pwd incorrecte
				else {//verification des pwd et existence
					
				
					for(Student st:ecole.studEcole) {//affectation des donn�es
						if(st.equals(s)) {//affectation des donn�es
							s=st;
							break;
						}//affectation des donn�es
					}//affectation des donn�es
					
					System.out.println("Choisir votre prochaine action :\n    1-s'inscrire pour l'ann�e prochaine\n    2-Afficher les notes\n    3-Afficher l'EDT\n    4-Retour\n" );
					try {
						s1=sc.nextInt();
						if(s1!=1 && s1!=2 && s1!=3 && s1!=4) {
							throw new InputMismatchException("Ce choix est invalide\n");
						}
					}catch(InputMismatchException er) {//catch 1
						System.out.println();
						System.err.println("Ce choix est invalide\n");
						sc.nextLine();
						s1=0;
					}//catch 1
				}//verification des pwd et existence
				}//etudiant existant
				if (s1==1) {//inscription
					InscriptionP�dagogique ip=new InscriptionP�dagogique(ecole);
					s=ip.et;
					
					s1=0;
					
				}//inscription
				if(s1==2) {//afficher les notes
					s.c.affichernoteStud( s);
					s1=0;
				}//afficher les notes
				if(s1==3) {//afficher les EDT
					s.c.afficheEdtClass();
					s1=0;
				}//afficher les EDT
				if(s1==4) {//retour
					id=0;
				}//retour
				}//menu
				
			}//connection etudiant
//----------------------------VISITEUR--------------------------------------------------------
			if(id==5) {//connection visiteur
				Visiteur v=new Visiteur(nom,prenom,ecole);
				id=0;
			}//connection visiteur
	 		
	 		
	 		
	 		
		}//connection while(id==0)

	}//main

}//class
