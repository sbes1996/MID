 public static void main(String[] args) {
        	
        	
        	InputFile f = new InputFile();
        	f.open("Exemple.txt");
        	
        		
        	int nbjours= f.readInt();
        	int nbusines=f.readInt();
        	int nbclients= f.readInt();
        	int nbcamions= f.readInt();
        		
        		
        	
        	double[][][] usine= new double [nbusines][4][nbjours];
        	double[][] coordusines= new double [nbusines][2];
        	double[][] clients= new double[nbclients][6];
        	double[][] camions= new double [nbcamions][10];
        	double[][] prestataire= new double[2][7];  		
        	String [] usinescamions= new String[nbcamions];
        		
        	
        	
        	for(int i=0; i<nbusines; i++ ){
        	String idUsine= f.readString();
        	coordusines[i][0]= f.readDouble();
        	coordusines[i][1]= f.readDouble();
        	for( int j =0; j<4;j++){
        		for(int k=0; k<nbjours; k++){
        			usine[i][j][k]= f.readDouble();
        			
        			
        		}
        	}
        	}
        	
        	for(int i=0; i<nbclients; i++){
        		String idClient= f.readString();
        		for (int j=0; j<6;j++){
        			clients[i][j]=f.readDouble();
        		}
        	}
        	
        	for( int i=0; i<nbcamions; i++){
        		String idCamion=f.readString();
        		usinescamions[i]=f.readString();
        		for(int j=0; j<10; j++){
        			camions[i][j]= f.readDouble();
        			}
        		}
        	
        	for (int i=0; i<2;i++){
        		for(int j=0; j<7;j++){
        			prestataire[i][j]=f.readDouble();
        		}
        	
        	}
        	
        	
        	
        	
        	
        	f.close();
        	
        	
        }
