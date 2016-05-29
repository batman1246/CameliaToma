package Builder;

import Factory.Masina;
import Observer.Observer;

public class Client {
	public String nume;
	public int varsta;
	public String cnp;
	public String adresa;	
	
	public Client(){}
	
	
	public static class Builder implements Observer{
		Client client = new Client();
		public Masina masina;
		
		public Builder(String nume,int varsta, Masina masina){
			client.nume = nume;
			client.varsta=varsta;
			this.masina=masina;
			this.masina.inregistreaza(this);
		}
		
		public Builder adaugaCNP(String cnp){
			client.cnp=cnp;
			return this;
		}
		
		public Builder adaugaAdresa(String adresa){
			client.adresa=adresa;
			return this;
		}		
		
		@Override
		public void actualizeaza() {
			System.out.println(client.nume+" a aparut un anunt");
			System.out.println("anuntul este "+masina.obtineUltimulAnunt(this));
			
		}
		
		public Client build(){
			return client;
		}
		
	}
	@Override
	public String toString() {
		return "Client [nume=" + nume + ", varsta=" + varsta + ", cnp=" + cnp + ", adresa=" + adresa + "]";
	}
	
	

	
}
