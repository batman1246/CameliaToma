package Singletone;

import java.util.ArrayList;
import java.util.List;

import Factory.Masina;

public class Magazin {
	private static Magazin instance;
	public static List<Masina> listaMasini=null;
	private Magazin(){
		listaMasini=new ArrayList<Masina>();
	}
	public static Magazin getInstance(){
		if(instance==null){
			instance=new Magazin();			
		}
		return instance;
	}
	
	public void adaugareMasina(Masina m){
		System.out.println("O noua masina te asteapta in magazinul nostru, pe nume "+m.nume);
		listaMasini.add(m);
	}
	
	public void stergeMasina(Masina m){
		System.out.println("Masina "+m.nume+" s-a vandut");
		listaMasini.remove(m);
	}
	public void afisareMasini() {
		System.out.println("Masinile ce au mai ramas in vanzare sunt :");
		for(Masina m:listaMasini){
			System.out.println("-> "+m.toString());
		}
	}
}