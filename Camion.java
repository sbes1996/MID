import java.util.LinkedList;

public class Usine {

	
	private String id;
	private double[] capaciteProd;
	private double[] capaciteStock;
	private double[] coutProd;
	private double[] coutStock;
	private double[] stock;
	private double[] production;
	private Point coord;
	private LinkedList<Client> clients;
	private LinkedList<Camion> flotteCamion;
	private double[] quantiteALivrer;
	
	
	
	public Usine(String id,double[] capaProd, double[] capaStock, double[] coutStock, double[] coutProd, Point coord, LinkedList<Client> clients){
		this.id=id;
		this.coord=coord;
		this.capaciteProd=new double[7];
		this.capaciteStock=new double[7];
		this.coutStock=new double[7];
		this.coutProd=new double[7];
		this.stock= new double[7];
		this.production=new double[7];
		for (int i=0; i<7; i++){
			this.capaciteProd[i]=capaProd[i];
			this.capaciteStock[i]=capaStock[i];
			this.coutStock[i]= coutStock[i];
			this.coutProd[i]= coutProd[i];
			this.production[i]=0;
			this.stock[i]=0;
		}
		
		this.flotteCamion=new LinkedList<Camion>() ;
		this.clients=clients;
		this.quantiteALivrer= new double[7];
		for( int i=0; i<6; i++){
			this.quantiteALivrer[i]= this.production[i]+this.stock[i]-this.stock[i+1];
		}
		this.quantiteALivrer[6]= this.production[6]+this.stock[6];
	}
		
	
	public LinkedList<Client> getClients(){
		return this.clients;
	}
	
	public LinkedList<Camion> getCamions(){
		return this.flotteCamion;
	}
	
	public double getQuantiteALivrer( int j){
		return this.quantiteALivrer[j];
	}

	
		
	public Point getCoord(){
		return this.coord;
	}
	
	public void setProd(int prod, int jour){
		if( this.capaciteProd[jour]>= prod)
		this.production[jour]= prod;
		
	}
	
	public void setStock(int stock, int jour){
		if( this.capaciteStock[jour]>= stock)
		this.production[jour]= stock;
		
	}
	
	public double getCapaciteProd(int j){
		return this.capaciteProd[j];
	}
	
	 public double getCapaciteProdTotale(){
		 double capa=0;
		 for(int i=0; i<7; i++){
			 capa=capa+ getCapaciteProd(i);
		 }
		 return capa;
	 }
	
	public double getCapaciteStock(int j){
		return this.capaciteStock[j];
	}
		
	public double getCapaciteStockTotale(){
		double capa=0;
		for( int i =0; i<7; i++){
			capa= capa+ getCapaciteStock(i);
		}
		return capa;
	}
		
	
	public void addClient( Client c){
		this.clients.add(c);
	}
	
	public void addCamion( Camion c){
		this.flotteCamion.add(c);
	}
	
	public double getStock (int j){
		return this.stock[j];
	}
	
	public double getProd(int j){
		return this.production[j];
	
}
}
