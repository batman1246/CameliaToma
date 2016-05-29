package State;

import Composite.Angajat;
import Factory.Masina;

public class ConvingereaClientului implements Stare{

	@Override
	public void actiune(Angajat angajat,Masina m) {
		System.out.println("Angajatul "+angajat.nume+" a convins un client sa cumpere masina "+m.nume);
		angajat.setStare(this);	
	}

	@Override
	public String toString() {
		return "Stare vanzarea masinii";
	}

	
	
}
