package Factory;

import Observer.Observer;
import Strategy.ModPlata;

public abstract class Masina implements Cloneable{
	public String nume;
	public int anFabricatie;
	public int pretVanzare;
	public abstract void afisare();
	
	//metode pentru observer
	public abstract void adaugaAnunt(String anunt);

	public abstract void inregistreaza(Observer observer) ;

	public abstract String obtineUltimulAnunt(Observer observer) ;

	public abstract void notifica();
	
	public abstract void plateste(ModPlata modPlata);

	@Override
	public String toString() {
		return "Masina [nume=" + nume + ", anFabricatie=" + anFabricatie + ", pretVanzare=" + pretVanzare + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
