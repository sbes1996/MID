public class Prestataire {

	private double coutFixe;
	private double coutTransport;
	private double distanceUtilise;
	private double distance;
	private double couts;
	
	
	
	
	public Prestataire(double coutFixe,double coutTransport){
		this.coutFixe=coutFixe;
		this.coutTransport=coutTransport;
		this.distanceUtilise=0;
		this.couts=0;
		
	}
	
	
	public double getCout(){
		return this.couts;
	}
	public void addCout(double cout){
		this.couts=this.couts + cout;
	}
	public double getCoutFinal(){
		if (this.couts!=0){
			this.couts=this.couts+this.coutFixe;
		}
		return this.couts;
	}
	
	public void addDistance(Point usine, Point client ){
		distanceUtilise= distanceUtilise + usine.distance(client);
	}
	
	public double getDistanceUtilise(){
		return this.distanceUtilise;
	}

	public void prestDelivre(Client client, Usine u,double quantite,int j){
		this.addDistance(u.getCoord(), client.getCoord());
		double cout=coutTransport*u.getCoord().distance(client.getCoord());
		this.addCout(cout);
		client.setMarchandise(j, quantite);
		
	}
	
	
	public void jourSuivant(){
		this.couts=0;
		this.distanceUtilise=0;
	}
	
}


	
