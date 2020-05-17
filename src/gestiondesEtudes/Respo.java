package gestiondesEtudes;


public class Respo extends Personne {
	protected Filiere fili�re;
	protected String pwd;
	
	public Respo () {
		super();
	}
public Respo(String lastnamePers, String firstnamePers, String cniPers,Filiere fili�re,String pwd) {
		super(lastnamePers, firstnamePers,cniPers);
		this.fili�re=fili�re;
		this.pwd=pwd;
		fili�re.ecole.respoEcole.add(this);
		System.out.println("\nVous avez ajout� " +this.lastnamePers+" "+this.firstnamePers+" comme responsable de la fili�re "+fili�re.toString() );
	}
public Respo(String lastnamePers, String firstnamePers,Filiere fili�re,String pwd) {
	super(lastnamePers, firstnamePers);
	this.fili�re=fili�re;
	this.pwd=pwd;
	//fili�re.ecole.respoEcole.add(this);
	}
	public Respo (String a, String b) {
		super(a,b);

		
	} 
	
	public Filiere getFiliere() {
		return fili�re;
	}
	public boolean equals(Respo respo) {
		return this.firstnamePers.equals(respo.firstnamePers)&& this.lastnamePers.equals(respo.lastnamePers) && (this.fili�re.equals(respo.fili�re));
	}
	 public boolean exist() {
			for (Respo resp: fili�re.ecole.respoEcole) {
				if (resp.equals(this)) {
					return true;	
				}
				
			}
			 return false;
			
		}
	 public Respo choisir(int a) {
		 int i=1;
		 Respo respo= new Respo();
		 for (Respo r: fili�re.ecole.respoEcole) {
			 if (i==a) {
				 respo=r;
				 break;
			 }
			 else i++;
		 }
		 return respo;
	 }
	 public boolean verificationPWD() {
			for (Respo a :this.fili�re.ecole.respoEcole) {
				if (a.equals(this)) {
					if (a.pwd.equals(this.pwd)) {
						return true;
					}
						
					break;
				}
			}
			 return false;
		}
		
	
	

}
