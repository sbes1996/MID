public Client lePlusProche(Camion camion, List<Client> clients){
		int i=0;
		int j=0;
		Iterator<Client> iter = clients.iterator() ;
		double distance= camion.distance(iter.getFirst().getcoord());
		while (iter.hasNext()) {
		Client c = iter.next() ;
			if (distance < camion.getcoord().distance(iter.getFirst().getcoord())){
				distance=camion.distance(iter.getFirst.getcoord());
				j=i;
			}
			iter.removeFirst();
			i++;
		}
		return clients.get(j);
