import java.util.Iterator;
import java.util.LinkedList;

public class livraison {
	private LinkedList<Usine> usines;
	private Prestataire p;
	private int j; // jour à voir
	
	



public livraison(LinkedList<Usine> usines, Prestataire p){
	this.usines = usines;
	this.p=p;
	
}
public void livraison(){
	Iterator<Usine> iter= this.usines.iterator();
	while (iter.hasNext()){
		Usine u=iter.next();
		livraisonUsine lu = new livraisonUsine(u,u.getCamions(),p,j);
		lu.livraisonProdUsine();
	}
}
}