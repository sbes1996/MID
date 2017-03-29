import iofiles.InputFile;

import iofiles.OutputFile;
import oplinterface.*;

public class Production {
	
	private Usine[] usines;
	private Client[] clients;
	private int nbJours;
	private double cout;
	
	
	public Production(Usine[] usines, Client[] clients, int nbJours) {
		this.usines=usines;
		this.clients=clients;
		this.nbJours=nbJours;
		this.cout=0;
	}

	public double[][] getCapa(){
		double[][] capa= new double[this.usines.length][this.nbJours];
		for( int i=0; i<this.usines.length; i++){
			for( int j=0; j<this.nbJours; j++){
				capa[i][j]= this.usines[i].getCapaciteProd(j);
			}
		}
		return capa;
	}
	
	
	public double[][] getCapaStock(){
		double[][] capa= new double[this.usines.length][this.nbJours];
		for( int i=0; i<this.usines.length; i++){
			for( int j=0; j<this.nbJours; j++){
				capa[i][j]= this.usines[i].getCapaciteStock(j);
			}
		}
		return capa;
	}
	
	public double[][] getCoutProd(){
		double[][] prod= new double[this.usines.length][this.nbJours];
		for( int i=0; i<this.usines.length; i++){
			for( int j=0; j<this.nbJours; j++){
				prod[i][j]= this.usines[i].getcoutProd(j);
			}
		}
		return prod;
	}
	
	public double[][] getCoutStock(){
		double[][] stock= new double[this.usines.length][this.nbJours];
		for( int i=0; i<this.usines.length; i++){
			for( int j=0; j<this.nbJours; j++){
				stock[i][j]= this.usines[i].getcoutStock(j);
			}
		}
		return stock;
	}
	
	
	public double[][] getDemande(){
		double[][] demande= new double[this.usines.length][this.nbJours];
		for( int i=0; i<this.usines.length; i++){
			for( int j=0; j< this.nbJours; j++ ){
				demande[i][j]= this.usines[i].demandeJour(j);
			}
		}
		return demande;
		
	}
	
	

   
	/*
	 * Pl 2 Recherche du coût minimum de production et stockage
	 */
		
	public void plProduction(){
               
		for (int i=0; i< usines.length; i++){
			
            	// lecture du modele prod
                OplSolver solver1 = new OplSolver("PL.mod");
                
                // traduction des correspondances entre les noms dans le modele et les donnees
                OplData data1 = new OplData(solver1.getOplEnv());
                data1.add("capaP", getCapa());
                data1.add("capaS", getCapaStock());
                data1.add("coutP", getCoutProd());
                data1.add("coutS", getCoutStock());
                data1.add("demandeSemaine", getDemande());
                data1.add("nbJours",this.nbJours);

                
                // resolution du probleme
                
                int status1 = solver1.solve(data1);
                
                // recuperation de la solution optimale
                
                if (status1 == 0) {
                        double coutUsine = solver1.getOptValue();
                        this.cout= this.cout+ coutUsine;
                        double [] solProd = solver1.getDoubleArray("p","Jour");
                        double [] solStock = solver1.getDoubleArray("s","Jour");
                        for (int j=0; j<this.nbJours; j++){
                        	this.usines[i].setProd(solProd[j],j);
                        	this.usines[i].setStock(solStock[j],j);
                        }
                 }
     
                
                data1.end();
                solver1.end();  
		}
}
	public double getCoutProdStock(){
		return this.cout;
	}
	
}
        


     	
            