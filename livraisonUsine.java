import java.util.Iterator;
import java.util.LinkedList;

public class livraisonUsine {
	private Usine usine;
	private LinkedList<Camion> flotteCamion;
	private Prestataire prestExt;
	private int j;
	//private Probleme pb (jour j);
	private double quantiteALivrer;
	
public livraisonUsine(Usine u,LinkedList<Camion> c, Prestataire prest,double quantite ,int j){
	this.usine=u;
	this.flotteCamion=c;
	this.prestExt=prest;
	this.j=j;//jour j
	this.quantiteALivrer=quantite;
}


public double getMarchandiseALivrer(int j ){
		return this.usine.getStock(j)+usine.getProd(j)-usine.getStock(j+1);
}

public LinkedList<Client> clientsALivrer(){
	return usine.getClients();
}

public void livraisonProdUsine(){
	Iterator<Camion> iter= this.flotteCamion.iterator();
	LinkedList<Client> clients= usine.getClients();//à optimiser
	
	double quantiteALivrer=this.quantiteALivrer;
	while (iter.hasNext()){
		Camion c = iter.next();
		livraisonCam (c,clients);
		quantiteALivrer=quantiteALivrer-c.getCapaUtilisee();//à voir si c'est bien la bonne quantité
		}
	if (quantiteALivrer!=0){// && quantiteLivree>=getMarchandiseALivrer(j) (condition de réalisabilité)
			livraisonPrest(prestExt, clients, quantiteALivrer);
		}
			
			
			
		}
		

public void livraisonCam (Camion c,LinkedList clients){
	Client cust=lePlusProche(c,clients);
	if (c.peutRetourner(cust, this.j)){
		c.delivre(cust,getMarchandises(c,cust),this.j);
		clientDelivre(clients, cust);
		Client customer=lePlusProche(c,clients);
	while (c.getCapaUtilisee()>=0 && c.peutRetourner(lePlusProche(c,clients),this.j)){
		c.delivre(cust,getMarchandises(c,customer),this.j);
		clientDelivre(clients,customer);
		}
	c.retourUsine();
	
	}
}
public void livraisonPrest(Prestataire p, LinkedList clients, double quantite){
	Iterator<Client> iter = clients.iterator();
	while(iter.hasNext() && quantite>=0){
		Client c = iter.next();
		p.prestDelivre(c,usine, c.getMarchandisesPrest(quantite,j),j);
		quantite=quantite-c.getMarchandisesPrest(quantite,j);
	}
	}
	
public void clientDelivre(LinkedList<Client> listeC,Client c){//enlève le client de notre liste à livrer
	Iterator<Client> iter = listeC.iterator();
	int i=0;
	while (iter.hasNext()){
		Client clientLivre = iter.next();
		if (clientLivre == c && c.getDemandeRestante(j)==0){
			listeC.remove(i);
		}
		i=i++;
	}
}

public Client lePlusProche(Camion camion, LinkedList<Client> clients){
	int i=0;
	int j=0;
	Iterator<Client> iter = clients.iterator() ;
	
	while (iter.hasNext()) {
		Client c = iter.next() ;
		double distance= camion.getCoord().distance(c.getCoord());
	
		if (distance < camion.getCoord().distance(c.getCoord())){
			distance=camion.getCoord().distance(c.getCoord());
			j=i;
		}
		i++;
	}
	return clients.get(j);
}
public double getMarchandises(Camion c, Client cust){
	if (c.getCapaUtilisee()<= cust.getDemandeRestante(this.j)){
		return c.getCapaUtilisee();
	}else{
		return cust.getDemandeRestante(this.j);
	}
}

}
