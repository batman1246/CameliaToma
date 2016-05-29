package Factory;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import Strategy.ModPlata;

public class Volvo extends Masina{
	public List<Observer> observatoriVolvo=new ArrayList<>();
	public ArrayList<String> anunturiVolvo = new ArrayList<>();
	public String ultimulAnuntVolvo;
	public Volvo(String nume,int an,int pret ){
		super();
		this.nume=nume;
		this.anFabricatie=an;
		this.pretVanzare=pret;
	}

	@Override
	public void afisare() {
		System.out.println("Se afiseaza informatii cu privire la masina "+anFabricatie+" "+pretVanzare+" din "+Volvo.class);
	}
	
	@Override
	public void inregistreaza(Observer observer) {
			observatoriVolvo.add(observer);
	}

	@Override
	public String obtineUltimulAnunt(Observer observer) {
		return ultimulAnuntVolvo;
	}

	@Override
	public void notifica() {
		for(Observer observator : observatoriVolvo){
			 observator.actualizeaza();
		}
	}

	@Override
	public void adaugaAnunt(String anunt) {
		anunturiVolvo.add(anunt);	
		ultimulAnuntVolvo=anunt;
		notifica();
	}
	
	@Override
	public void plateste(ModPlata modPlata) {
		modPlata.plateste(pretVanzare);		
	}
	
}