package Strategy;

import Builder.Client;
import Template.ActualizareActe;

public class PlataNumerar extends ActualizareActe implements ModPlata{
	public Client client;
	
	public PlataNumerar() {}
	
	public PlataNumerar(Client client){
		super(client);
		this.client=client;
	}
	
	@Override
	public void plateste(int plata) {
		System.out.println("Clientul "+client.nume+" plateste prin numerar suma de "+plata);
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
		System.out.println("Actualizare reusita prin plata numerar");		
	}
}
