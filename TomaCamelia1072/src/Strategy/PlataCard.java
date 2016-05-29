package Strategy;

import Builder.Client;
import Template.ActualizareActe;

public class PlataCard extends ActualizareActe implements ModPlata{
	public String card;
	public String dataExpirare;
	public Client client;
	
	public PlataCard() {}
	
	public PlataCard(String card, String dataExpirare, Client client) {
		super();
		this.card = card;
		this.dataExpirare = dataExpirare;
		this.client = client;
	}

	@Override
	public void plateste(int plata) {
		System.out.println("Clientul "+client.nume+" plateste prin card suma de "+plata);
		
	}

	@Override
	public void inregistreazaFactura(Client client) {
		System.out.println("-----Factura clientului "+client.nume+" se inregistreaza---- ");
		System.out.println("Documentele se intocmesc pentru a fi trimise catre contabilitate");
	}

	@Override
	public void realizeazaCopieClient(Client client) {
		System.out.println("Se realizeaza xeroxuri pentru client");
		
	}

	@Override
	public void finalizare() {
		System.out.println("Actualizare reusita prin plata card");		
	}

}
