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


public double getMarchandiseALivrer(int j ){           //pb!!!
		return this.usine.getStock(j)+usine.getProd(j)-usine.getStock(j+1);
}

public LinkedList<Client> clientsALivrer(){
	return usine.getClients();
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
	} else{
		return cust.getDemandeRestante(this.j);
	}
}








//methode camion modifiee




public void livraisonCam(Camion c, LinkedList<Client> clients){
	Client clientProche= lePlusProche(c, clients);
	while(c.peutRetourner(clientProche, this.j) && c.getCapaUtilisee()>0){
		c.delivre(clientProche,getMarchandises(c,clientProche),this.j);
		clientDelivre(clients,clientProche);
		clientProche=lePlusProche(c, clients);
	}
	c.retourUsine();
}


public void clientDelivre(LinkedList<Client> listeClients,Client c){//enlÃƒÂ¨ve le client de notre liste ÃƒÂ  livrer
	Iterator<Client> iter = listeClients.iterator();
	int i=0;
	while (iter.hasNext()){
		Client clientSuivant = iter.next();
		if (clientSuivant == c && c.getDemandeRestante(j)==0){
			listeClients.remove(i);
		}
		i=i++;
	}
}



public void livraisonprodUsine(){
	
	Iterator<Camion> iter= this.flotteCamion.iterator();
	LinkedList<Client> clients= this.usine.getClients();
	double quantitePrestataire=this.quantiteALivrer;
	
	while(iter.hasNext() && quantitePrestataire>=0){
		Camion c= iter.next();
		c.addCapacite(quantitePrestataire);
		quantitePrestataire= quantitePrestataire - c.getCapaUtilisee();
	}

	Iterator<Camion> iter2= this.flotteCamion.iterator(); //pas sur
	while (iter2.hasNext()){
		Camion c = iter2.next();
		if( c.getCapaUtilisee()>0){
			livraisonCam (c,clients);
			quantitePrestataire=quantitePrestataire+c.getCapaUtilisee();
		}
	}
	
	if (quantitePrestataire!=0){// && quantiteLivree>=getMarchandiseALivrer(j) (condition de rÃƒÂ©alisabilitÃƒÂ©)
			livraisonPrest(prestExt, clients, quantitePrestataire);
		}
			
			
			
	}


}
