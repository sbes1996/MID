


import iofiles.InputFile;
import iofiles.OutputFile;

	public class Donnees {

	        public static void main(String[] args) {
	               
	        	InputFile f = new InputFile();
	        	f.open("instanceJardin1.txt");
	        	
	        	

	        	
	        	
	        	// Definition des donnees
	                int n = f.readInt();
	                int m = f.readInt();
	                double [] s = new double [m];
	                for (int i=0;i<3;i++){
	                	s[i]=f.readDouble();
	                }

	                double [] r = new double [n];
	                for (int i=0; i<2; i++){
	                	r[i]=f.readDouble();
	                }
	                

	                double [][] co = new double [m][n];
	                for (int i =0;i<3;i++){
	                	for(int j=0;j<2;j++){
	                		co[i][j]=f.readDouble();
	                	}
	                }
	                f.close();
	                
	                
	                
	              
	                // lecture du modele
	                OplSolver solver = new OplSolver("modelisation_jardin.mod");
	                // traduction des correspondances entre les noms dans le modele et les donnees
	                OplData data = new OplData(solver.getOplEnv());
	                data.add("nbLegumes", n);
	                data.add("nbRessources", m);
	                data.add("rendement", r);
	                data.add("consommation", co);
	                data.add("stock", s);
	                // resolution du probleme
	                int status = solver.solve(data);
	                // recuperation de la solution optimale
	                OutputFile o = new OutputFile();
	                o.open("instanceJardin1_sol.txt");
	                if (status == 0) {
	                        double valeurOptimale = solver.getOptValue();
	                        o.writeString("La valeur de l'objectif est ");
	                        o.writeDouble(valeurOptimale);
	                        double [] solution = solver.getDoubleArray("surface","legumes");
	                        o.writeString("La solution est ");
	                        for (int i = 0; i < n; i++){
	                               	o.writeString("- surface[");
	                               	o.writeln();
	                                o.writeInt(i);
	                                o.writeString( "]=");
	                                o.writeDouble(solution[i]);
	                                }
	                        
	    	             
	    	                o.writeString("La solution est");
	    	                //o.writeln pour passer à la ligne
	    	                o.close();
	                }
	                else {
	                        System.out.println("Aucune solution disponible");
	                        System.out.println("Enregistrement des donnees dans donneesErreur.dat pour debuguer sur OPL IDE");
	                        solver.printData("donneesErreur.dat");
	                        System.exit(0);
	                }
	                data.end();
	                solver.end();
	        }

	}




}
