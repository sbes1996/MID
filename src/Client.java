import java.util.List;

public class Client {

	private String id;
	private Point coord;
	private double demande;
	private double[] fenetreLivraison; //Tableau? Double?
	private double penalite;
	private List<int[]> marchandiseJourLivree; // Liste de tableaux avec la marchandise livree et le jour
	
	
	public Client( String id, Point coord, double demande, double penalite, double[] fenetre){
		this.id=id;
		this.coord=coord;
		this.demande=demande;

		// marchandiseJourLivree?
	}
	
	
}
