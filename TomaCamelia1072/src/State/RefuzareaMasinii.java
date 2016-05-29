package State;

import Composite.Angajat;
import Factory.Masina;

public class RefuzareaMasinii implements Stare{

	@Override
	public void actiune(Angajat angajat,Masina m) {
		System.out.println("Angajatul "+angajat.nume+" nu a convins clientul sa cumpere masina "+m.nume);
		angajat.setStare(this);	
	}

	@Override
	public String toString() {
		return "Stare de refuzare";
	}

}
