package Prototype;

import java.util.HashMap;

import Factory.Masina;
import Factory.Volvo;


public class ArhivaMasini {

	static HashMap<String, Masina> masinaMap = new HashMap<String, Masina>();
	
	static public Masina getMasina(String type) throws CloneNotSupportedException{
		System.out.println("Se pune spre vanzare masina cu numele de "+type);
		return (Masina) masinaMap.get(type).clone();
	}
	
	public static void arhiveazaMasina(Masina m){			
		masinaMap.put(m.nume, m);
		}

	public static void eliminaMasina(Volvo volvo) {
		System.out.println("Se elimina masina");
		masinaMap.remove(volvo.nume);
	}
}
