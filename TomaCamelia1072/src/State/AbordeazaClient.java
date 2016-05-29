package State;

import Composite.Angajat;
import Factory.Masina;

public class AbordeazaClient implements Stare{

	@Override
	public void actiune(Angajat angajat,Masina m) {
		System.out.println("Angajatul "+angajat.nume+" abordeaza un client ce este interesat de masina "+m.nume);
		angajat.setStare(this);
	}

	@Override
	public String toString() {
		return "Stare de abordare";
	}
	
	

}
