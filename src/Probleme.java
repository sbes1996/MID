
public class Probleme {
	
	
	private String nomfichier;
	private Usine[] tabUsines;
	private Client[] tabClients;
	private Camion[] tabCamion;
	private Prestataire prestataire;
	private int duree;


	public Probleme (String nomfichier){
		LireDonnees(nomfichier);	
	}
	

	private void LireDonnees(String nomfichier) {
		Donnees donnees = new Donnees(nomfichier);
		donnees.lire();
		tabUsines=donnees.getUsines();
		tabClients=donnees.getClients();
		prestataire = donnees.getPrestataire();
		tabCamion = donnees.getCamions();
		duree=donnees.getDuree();
	}

	Affectation affectation = new Affectation(this.tabUsines, this.tabClients);
	Production production = new Production(this.tabUsines,this.tabClients,this.duree);
	livraison livraison =new livraison(this.tabUsines,this.prestataire);
	
	public double getCout(){
		double coutProd= production.getCoutProdStock();
		double coutLog = livraison.getCoutLogistique();
		return coutProd+coutLog;
	}
	
	
	
	

	
	                                

}
