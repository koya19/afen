package AIAC;


import java.util.Date;

import gestiondenotes.Element;
import gestiondenotes.Module;
public class Prof extends Personne{
	protected final String profession ="Professeur";
	protected Element element;
	protected Module module;
	
	
	public Prof () {
		super();
	}
	public Prof (String a, String b) {
		super(a,b);
		}
	public Prof(String nom) {
		this.lastnamePers=nom;
		System.out.println("cretion du prof "+ this.toString());
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	/*public Prof (String lastnamePers, String firstnamePers, String cniPers, char gender,
			Date date, String lieu) {
		super (lastnamePers, firstnamePers,cniPers,gender,date,lieu);
		System.out.println(this.lastnamePers+" "+ this.firstnamePers);
	}
	*/
	

}
