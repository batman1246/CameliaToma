package Factory;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import Strategy.ModPlata;



public class Dacia extends Masina{
	public List<Observer> observatoriDacia=new ArrayList<>();
	public static ArrayList<String> anunturiDacia = new ArrayList<>();
	public String ultimulAnuntDacia;
	public Dacia(String nume,int an,int pret ){
		super();
		this.nume=nume;
		this.anFabricatie=an;
		this.pretVanzare=pret;
	}

	@Override
	public void afisare() {
		System.out.println("Se afiseaza informatii cu privire la masina "+anFabricatie+" "+pretVanzare+" din "+Dacia.class);
	}

	@Override
	public void inregistreaza(Observer observer) {
			observatoriDacia.add(observer);
	}



	@Override
	public String obtineUltimulAnunt(Observer observer) {
		return ultimulAnuntDacia;
	}

	@Override
	public void notifica() {
		for(Observer observator : observatoriDacia){
			 observator.actualizeaza();
		}
	}

	@Override
	public void adaugaAnunt(String anunt) {
		anunturiDacia.add(anunt);
		ultimulAnuntDacia=anunt;
		notifica();
	}

	@Override
	public void plateste(ModPlata modPlata) {
		modPlata.plateste(pretVanzare);		
	}


	
}
