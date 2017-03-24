import java.util.List;

public class Client {

	private String id;
	private Point coordonnees;
	private double demande;
	private int[] fenetreLivraison; 
	private double penalite;
	private double[] marchandiseJourLivree; 
	private boolean etat;
	
	public Client( String id, Point coord, double demande, double penalite, int d1, int d2){
		this.id=id;
		this.coordonnees=coord;
		this.demande=demande;
		this.penalite=penalite;
		this.fenetreLivraison=new int[2];
		this.fenetreLivraison[0]= d1;
		this.fenetreLivraison[1]= d2;
		this.marchandiseJourLivree= new double[7];
		this.etat=false;
	}
	
	public String getIdclient() {
		return this.id;
	}

	public Point getCoordonnées() {
		return this.coordonnees;
	}
	
	public double getDemande() {
		return this.demande;
	}
	
	public int[] getFenetreLivraison() {
		return this.fenetreLivraison;
	}
	
	public double getPenalite() {
		return this.penalite;
	}
	
	public double[] getMarchandiseJourLivree() {
		return this.marchandiseJourLivree;
	}

	public boolean getEtat() {
		return this.etat;
	}
	
	public void ChangeEtat() {
		if (getEtat()) {
			this.etat=false;
		} else {
			this.etat=true;
		}	
	}
	
	public boolean EstPenalite(int jourlivrer) {
		if((jourlivrer<getFenetreLivraison()[0]) || (jourlivrer>getFenetreLivraison()[1])){
			return true;
		} else {
		return false;	
		}
	}

	public double CoutPenalite(int jourlivrer) {
		int nbjourpenalite = jourlivrer - this.fenetreLivraison[1];
		if(EstPenalite(jourlivrer)) {			
			return (nbjourpenalite*this.penalite);
		} else{
			return (0);
		}
	}

}
