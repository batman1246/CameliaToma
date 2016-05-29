package Composite;

import java.util.ArrayList;
import java.util.List;

import State.Stare;

public class Angajat {
	private Stare stare;
	public String nume;
	public String departament;
	public int salariu;
	public List<Angajat> subordonati;
	
	public Angajat(String nume, String departament, int salariu){
		this.nume = nume;
		this.departament = departament;
		this.salariu = salariu;
		subordonati = new ArrayList<Angajat>();
	}
	
	public void adaugaSubordonat(Angajat a){
		this.subordonati.add(a);
	}
	
	public void scoateSubordonat(Angajat a){
		this.subordonati.remove(a);
	}
	
	public List<Angajat> getSubordonati(){
		return subordonati;
	}

	public String toString(){
	      return ("Angajat : [Nume : " + nume + ", departament : " + departament + ", salariu :" + salariu +"]");
	  }

	public Stare getStare() {
		return stare;
	}

	public void setStare(Stare stare) {
		this.stare = stare;
	}  
	
	
	
}
