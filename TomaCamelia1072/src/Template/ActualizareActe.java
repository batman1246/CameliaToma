package Template;

import Builder.Client;

public abstract  class ActualizareActe {
	public Client client;
	
	public ActualizareActe(){}
	
	public ActualizareActe(Client client) {
		this.client=client;
	}
	
	public void actualizareDocumente(){
		inregistreazaFactura(client);
		realizeazaCopieClient(client);
		finalizare();
	}
	
	public abstract void inregistreazaFactura(Client client);
	
	public abstract void realizeazaCopieClient(Client client);
	
	public abstract void finalizare();
}
