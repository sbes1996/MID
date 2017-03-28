import java.util.Iterator;
import java.util.LinkedList;

public class livraison {
	private LinkedList<Usine> usines;
	private Prestataire p;
	private LinkedList<Camion> listeDeCamions;
	private double cout;
	

public livraison(LinkedList<Usine> usines, Prestataire p){
	this.usines = usines;
	this.p=p;
	this.cout=0;
	
}
public void affectationCamions(){
	
}


public void resolutionLivraison(){
	for (int j=0; j<7;j++){
		Iterator<Usine> iter= this.usines.iterator();
		while (iter.hasNext()){
			Usine u=iter.next();
			livraisonUsine lu = new livraisonUsine(u,p,j);
			lu.livraisonprodUsine();
			cout+=lu.getCout();
			Iterator<Camion> iter1= u.getCamions().iterator();
			while(iter1.hasNext()){
				Camion c = iter1.next();
				c.jourSuivant();
			}
			
			
		}
		cout+=p.getCoutFinal(j);
		p.jourSuivant();
	}
	cout +=this.coutPenalite();

	}

public double getCoutLogistique(){
	return this.cout;
}

public double coutPenalite() {
	Iterator<Usine> iter = this.usines.iterator();
	Usine usine = iter.next();
	double coutPenalite=0;
	while(iter.hasNext()){
		Iterator<Client> iter1= usine.getClients().iterator();
		Client client = iter1.next();
		coutPenalite+=client.coutPenalite();

	}
	return coutPenalite;
	
}
}
