package Factory;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import Strategy.ModPlata;

public class Opel extends Masina{
	public List<Observer> observatoriOpel=new ArrayList<>();
	public ArrayList<String> anunturiOpel = new ArrayList<>();
	public String ultimulAnuntOpel;
	public Opel(String nume,int an,int pret ){
		super();
		this.nume=nume;
		this.anFabricatie=an;
		this.pretVanzare=pret;
	}

	@Override
	public void afisare() {
		System.out.println("Se afiseaza informatii cu privire la masina "+anFabricatie+" "+pretVanzare+" din "+Opel.class);
	}
	@Override
	public void inregistreaza(Observer observer) {
			observatoriOpel.add(observer);
	}

	@Override
	public String obtineUltimulAnunt(Observer observer) {
		return ultimulAnuntOpel;
	}

	@Override
	public void notifica() {
		for(Observer observator : observatoriOpel){
			 observator.actualizeaza();
		}
	}

	@Override
	public void adaugaAnunt(String anunt) {
		anunturiOpel.add(anunt);	
		ultimulAnuntOpel=anunt;
		notifica();
	}
	
	@Override
	public void plateste(ModPlata modPlata) {
		modPlata.plateste(pretVanzare);		
	}
	
}