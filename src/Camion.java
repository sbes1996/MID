
public class Camion {
	
	private String id;
	private String idUsine;
	private double capacite;
	private double vitesse;
	private double coutTransportkm;
	private double heuresJour;
	private double capaciteUtilisee;
	private double heuresUtilisees;
	private double cout;
	private Usine usine; // pas sur
	private Point coord; // pas sur
	
	public Camion(String id, String idusine, double capacite, double vitesse, double coutTransport, double heuresJour, Usine usine){
		this.idUsine=idusine;
		this.capacite=capacite;
		this.vitesse=vitesse;
		this.coutTransportkm=coutTransport;
		this.heuresJour=heuresJour;
		this.capaciteUtilisee=0;
		this.heuresUtilisees=0;
		this.cout=0;
		this.usine=usine;
		this.coord= this.usine.getCoord();
	}
	
	
	
	public void addHeures( double heures){
		if(this.heuresUtilisees + heures <= this.heuresJour){
			this.heuresUtilisees= this.heuresUtilisees + heures;
		}
	}
	
	
	public void addCapacite( double capa){
		if( this.capaciteUtilisee + capa< this.capacite){
			this.capaciteUtilisee= this.capaciteUtilisee + capa;
		}
	}
	
	public void setCoord( Point p){
		this.coord= p;
	}
	
	public void setCout( double cout) {
		this.cout= this.cout + cout;
	}
	
	public double getTempsTraject(Point depart, Point arrivee){
		return( depart.distance(arrivee)/vitesse);
	}
	
	
	public double getCoutTraject( Point depart, Point arrivee){
		return getTempsTraject(depart, arrivee)*this.coutTransportkm;
	}
	
	
	public double distUsine(){
		return this.coord.distance(this.usine.getCoord());
	}
	// je crois que cette methode est inutile
	
	
	public boolean peutDelivrer(Point p, double demande){
		if( this.heuresUtilisees + getTempsTraject(this.coord, p)< this.heuresJour && this.capaciteUtilisee >=  demande && demande <= this.capacite){
			return true;
		}
		return false;
	}
	// pas sur de cette methode
	
	
	public boolean peutRetourner(Point p){
		if (getTempsTraject(this.coord, p) + getTempsTraject(p, this.usine.getCoord()) + this.heuresUtilisees   < this.heuresJour){
			return true;
		}
		return false;
		
	}
	// on veut savoir si une fois s'avoir déplacé au point p on aura le temps de revenir
	
	
	
	
	
}


