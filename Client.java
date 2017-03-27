import java.util.List;

public class Client {

	private String id;
	private Point coord;
	private double demande;
	private int[] fenetreLivraison; 
	private double penalite;
	private double[] marchandiseJourLivree; 
	private boolean etat;
	private Usine usine;
	
	public Client( String id, Point coord, double demande, double penalite, int d1, int d2, Usine usine){
		this.id=id;
		this.coord=coord;
		this.demande=demande;
		this.fenetreLivraison=new int[2];
		this.fenetreLivraison[0]= d1;
		this.fenetreLivraison[1]= d2;
		this.marchandiseJourLivree= new double[7];
		this.etat=false;
		this.usine=usine;
	}
	
	
	
	public double getDemandeRestante( int j){
		double demandeRest= this.demande;
		for(int i=0; i<j; i++){
			demandeRest= demandeRest-this.marchandiseJourLivree[j];
		}
		return demandeRest;
		
		
		
	}
	public void setMarchandise(int j, double q){
		this.marchandiseJourLivree[j]+=q;
	}
	
	public String getIdclient() {
		return this.id;
	}

	public Point getCoordonnees() {
		return this.coord;
	}
	
	public double getDemande() {
		return this.demande;
	}
	
	
	public double getPenalite() {
		return this.penalite;
	}
	
	

	public boolean getEtat() {
		return this.etat;
	}
	
	public void changeEtat() {
		if (getEtat()) {
			this.etat=false;
		}
	}
	
	public boolean estPenalite(int jourlivrer) {
		if((jourlivrer < this.fenetreLivraison[0]) || (jourlivrer > this.fenetreLivraison[1])){
			return true;
		} else {
		return false;	
		}
	}

	public double coutPenalite() {
		double qteTotale=0;
		double qtePasFenetre=0;
		for( int i =0; i<this.marchandiseJourLivree.length; i++){
			if (estPenalite(i)){
				qtePasFenetre = qtePasFenetre + this.marchandiseJourLivree[i];
			}
			qteTotale= qteTotale + this.marchandiseJourLivree[i];
		}
		return ( this.penalite*qtePasFenetre/qteTotale);
	}
	

public Point getCoord(){
	return this.coord;
}
public double getMarchandisesPrest(double quantite,int j){
	if (quantite<=this.getDemandeRestante(j)){
		return quantite;
	}else{
		return this.getDemandeRestante(j);
	}
}
	
}