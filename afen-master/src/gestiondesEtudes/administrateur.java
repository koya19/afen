package gestiondesEtudes;


import java.util.Set;

public class administrateur extends Personne{
	protected Ecole ecole;
	protected String pwd;

 public administrateur () {
	 super();

 }
 public administrateur (String a, String b,String pwd,Ecole ecole) {
		super(a,b);
		this.ecole=ecole;
		this.pwd=pwd;
	
		}
 public administrateur(String lastnamePers, String firstnamePers, String cniPers,String pwd,Ecole ecole)  {
	 super(lastnamePers, firstnamePers,cniPers);
	 this.pwd=pwd;
	 this.ecole=ecole;
	 
	
 
}
 public void addRespo(Respo respo, Filiere filiere) {
	 ecole.respoEcole.add(respo);
	 respo.fili�re=filiere;
 }
 
 public void inscriptionStudent() {
	 
 }
public String toString() {
	return   lastnamePers +" "+ firstnamePers ;
}
public boolean exist(Set<administrateur> list) {
	for (administrateur admin: list) {
		if (admin.equals(this)) {
			return true;
			
		}
		
		
	}
	 return false;
}

public boolean verificationPWD() {
	for (administrateur a :ecole.adminEcole) {
		if (a.equals(this)) {
			if (a.pwd.equals(this.pwd)) {
				return true;
			}
				
			break;
		}
	}
	 return false;
}
/*public boolean dexist(Set<administrateur> list) {
	for (administrateur admin: list) {
		if (admin.equals(this)) {
			return false;
				
		}
		
	}
	return true;

}*/
		
}
 
