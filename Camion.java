
public class Camion {
	private String id;
	private String idUsine;
	private double capacite;
	private double vitesse;
	private double coutTransportkm;
	private double[] heuresJour;
	private double capaciteUtilisee;
	private double heuresUtilisees;
	private double cout;
	private Usine usine; // pas sur
	private Point coord; // pas sur
	
	public Camion(String id, String idusine, double capacite, double vitesse, double coutTransport, double[] heuresJour, Usine usine){
		this.idUsine=idusine;
		this.capacite=capacite;
		this.vitesse=vitesse;
		this.coutTransportkm=coutTransport;
		this.capaciteUtilisee=0;
		this.heuresUtilisees=0;
		this.cout=0;
		this.usine=usine;
		this.coord= this.usine.getCoord();
		this.heuresJour= new double[7];
		this.heuresJour=heuresJour;
		for( int i=0; i<7; i++){
			this.heuresJour[i]=heuresJour[i];
		}
	}
	
	
	
	public void addHeures( double heures){
		//if(this.heuresUtilisees + heures <= this.heuresJour){
			this.heuresUtilisees= this.heuresUtilisees + heures;
		
	}
	

	public void addCapacite( double capa){
		if( this.capaciteUtilisee + capa< this.capacite){
			this.capaciteUtilisee= this.capaciteUtilisee + capa;
		} elsif( this.capaciteUtilisee+capa>= this.capacite){
			this.capaciteUtilisee=this.capacite;
		}
	}
	
	
	public double getCapaUtilisee(){
		return this.capaciteUtilisee;
	}
	
	public void setCoord( Point p){
		this.coord= p;
	}
	public Point getCoord(){
		return this.coord;
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
	
	
	
	public void jourSuivant(){
		this.cout=0;
		this.heuresUtilisees=0;
	}
	
	
	public void delivre(Client c, double quantite,int j){
		this.cout= this.cout + getCoutTraject(this.coord, c.getCoordonnees());
		setCoord(c.getCoordonnees());
		this.capaciteUtilisee=this.capaciteUtilisee-quantite;
		c.setMarchandise(j,quantite);
		
	}
	
	
	
	public boolean peutRetourner(Client c, int jour){
		if (getTempsTraject(this.coord, c.getCoordonnees()) + getTempsTraject(c.getCoordonnees(), this.usine.getCoord()) + this.heuresUtilisees   < this.heuresJour[jour]){
			return true;
		}
		return false;
		
	}
	// on veut savoir si une fois s'etre déplacé au point p on aura le temps de revenir
	public void retourUsine() {
		this.coord = this.usine.getCoord();
		this.cout = this.cout + getCoutTraject(this.coord, this.usine.getCoord());
		this.heuresUtilisees=this.heuresUtilisees+getCoutTraject(this.coord, this.usine.getCoord());
		 
		
	}
	
	
	
	

}
