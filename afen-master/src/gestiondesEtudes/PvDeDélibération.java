package gestiondesEtudes;

public class PvDeD�lib�ration {
	protected Class p;
	
	public PvDeD�lib�ration(Class p) {
		this.p = p;
	}
	
	public void g�n�rerPV() {
		System.out.println("\nPV de d�lib�ration de la promotion " + p.toString() + " :");
		for (Student e : p.stud) {
			System.out.println(e.miniPV());
		}
	}
}
