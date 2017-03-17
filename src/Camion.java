
public class Camion {
	
	private String id;
	private String idUsine;
	private double capacite;
	private double vitesse;
	private double coutTransport;
	private double heuresJour;
	private double capaciteUtilisee;
	private double heuresUtilisees;
	
	
	public Camion(String id, String usine, double capacite, double vitesse, double coutTransport, double heuresJour, double capaciteUtilisee, double heuresUtilisees){
		this.id=id;
		this.idUsine=usine;
		this.capacite=capacite;
		this.vitesse=vitesse;
		this.coutTransport=coutTransport;
		this.heuresJour=heuresJour;
		this.capaciteUtilisee=0;
		this.heuresUtilisees=0;
	}
}
