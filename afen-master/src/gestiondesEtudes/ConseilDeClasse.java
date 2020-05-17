package gestiondesEtudes;

import java.util.HashSet;
import java.util.Set;

public class ConseilDeClasse {
	protected Set<Respo> equipe;
	protected Respo chef;
	protected Student e;
	
	public ConseilDeClasse(Respo chef, Student e) {
		this.equipe = new HashSet<>();
		this.chef = chef;
		this.e = e;
	}
	
	public String D�cision() {
		if (e.getNbrModuleNV() <= 2) {
			e.setDecision("Passage");
			return "Passage";
		}
		else if (e.getNbrModuleNV() <= 4 && e.getNbrTotalAbsence() <= 8) {
			e.setDecision("Passage");
			return "Passage";
		}
		else {
			e.setDecision("Redoublement");
			return "Redoublement";
		}
	}
}
