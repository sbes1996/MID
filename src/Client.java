import java.util.List;

public class Client {

	private String id;
	private Point coord;
	private double demande;
	private int[] fenetreLivraison; 
	private double penalite;
	private double[] marchandiseJourLivree; 
	private boolean etat;
	
	public Client( String id, Point coord, double demande, double penalite, int d1, int d2){
		this.id=id;
		this.coord=coord;
		this.demande=demande;
		this.fenetreLivraison=new int[2];
		this.fenetreLivraison[0]= d1;
		this.fenetreLivraison[1]= d2;
		this.marchandiseJourLivree= new double[7];
		this.etat=false;
	}
	
	kskdsk


	
}
