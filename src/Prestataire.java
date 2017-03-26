
public class Prestataire {

	private double coutFixe;
	private double coutTransport;
	private double distanceUtilise;
	private double couts;
	private boolean etat;
	
	
	
	public Prestataire(double coutFixe,double coutTransport){
		this.coutFixe=coutFixe;
		this.coutTransport=coutTransport;
		this.distanceUtilise=0;
		this.couts=0;
		this.etat=false;
	}
	
	public void addCout(double cout){
		this.couts=this.couts + cout;
	}
	
	public void addDistance(Point usine, Point client ){
		distanceUtilise= distanceUtilise + usine.distance(client);
	}
	
	public double getDistanceUtilise(){
		return this.distanceUtilise;
	}

	public double getCout(){
		return this.couts;
	}

	
