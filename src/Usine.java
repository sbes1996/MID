
public class Usine {

	
	private String id;
	private double capaciteProd;
	private double capaciteStock;
	private double coutProd;
	private double coutStock;
	private double stock;
	private double production;
	private Point coord;
	
	
	public Usine(String id,double capaProd, double capaStock, double coutStock, double coutProd, Point coord, double stock){
		this.id=id;
		this.capaciteProd=capaProd;
		this.capaciteStock=capaStock;
		this.coutStock=coutStock;
		this.coutProd=coutProd;
		this.coord=coord;
		this.production=0;
		this.stock=stock;
		}
	

	
	
	
	
	
	
}
