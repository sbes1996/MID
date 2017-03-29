import oplinterface.OplData;
import oplinterface.OplSolver;

public class Affectation {
	
	private Usine[] usines;
	private Client[] clients;

	
	
	public Affectation( Usine[] u,Client[] c ){
		this.usines=u;
		this.clients=c;
	}
	
	public double[] getDemande(){
		double[] demande= new double[this.clients.length];
		for( int i =0; i<this.clients.length; i++){
			demande[i]=this.clients[i].getDemande();
		}
		return demande;
	}
	
	public double[][] getDistance(){
		double[][] distance= new double[this.usines.length][this.clients.length];
		for( int i=0; i<this.usines.length; i++){
			for( int j=0; j<this.clients.length; j++){
				distance[i][j]= this.usines[i].getCoord().distance(this.clients[j].getCoord());
				
			}
		}
		return distance;
	}
	
	public double[] getCapacite(){
		double[] capacite= new double[this.usines.length];
		for( int i=0; i<this.usines.length; i++){
			capacite[i]= this.usines[i].getCapaciteProdTotale();
		}
		return capacite;
	}
	
	
	
		public void plClient(){
		
	
	
                // lecture du modele client
			
                OplSolver solver2 = new OplSolver ("PLclient.mod");
                
                // traduction des correspondances entre les noms dans le modele et les donnees
                OplData data2 = new OplData(solver2.getOplEnv());
                data2.add("demande",getDemande());
                data2.add("nbclients", this.clients.length);
                data2.add("nbusines", this.usines.length);
                data2.add("distance", getDistance());
                data2.add("capaP", getCapacite());
              
                // resolution du probleme
                int status = solver2.solve(data2);
                
                // recuperation de la solution optimale
                if (status == 0) {
                	
                        int [][] solAffectation = solver2.getIntArray("y", "usines", "clients");
                        
                        for (int i=0; i< this.usines.length; i++){
                        	for( int j=0; j<this.clients.length; j++){
                        		if (solAffectation[i][j]==1){
                            		this.usines[i].addClient(clients[j]);
                        	}
                        	
                        }
                }
             
                data2.end();
                solver2.end();  
        
		
	}
	
	
	
	
	
	
}
		
		
}
