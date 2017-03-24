
public class Camion {
	
	private String id;
	private String idUsine;
	private double capacite;
	private double vitesse;
	private double coutTransportkm;
	private double heuresJour;
	private double capaciteUtilisee;
	private double heuresUtilisees;
	
	
	public Camion(String id, String usine, double capacite, double vitesse, double coutTransport, double heuresJour){
		this.idUsine=usine;
		this.capacite=capacite;
		this.vitesse=vitesse;
		this.coutTransportkm=coutTransport;
		this.heuresJour=heuresJour;
		this.capaciteUtilisee=0;
		this.heuresUtilisees=0;
	}
}
