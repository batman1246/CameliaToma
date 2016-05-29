package Main;

import Builder.Client;
import Composite.Angajat;
import Factory.Dacia;
import Factory.MasinaFactory;
import Factory.Opel;
import Factory.Volvo;
import Prototype.ArhivaMasini;
import Singletone.Magazin;
import State.AbordeazaClient;
import State.ConvingereaClientului;
import State.RefuzareaMasinii;
import State.Stare;
import Strategy.ModPlata;
import Strategy.PlataNumerar;
import Template.ActualizareActe;

public class Program {
	public static void main(String[] args) throws CloneNotSupportedException{
	
		///////////////////////////////===SINGLETONE===////////////////
		System.out.println("---------------SINGLETONE---------------");
		Magazin m1=Magazin.getInstance();
		Magazin m2=Magazin.getInstance();
		if(m1==m2){
			System.out.println("S-a deschis magazinul! ");
		}
		
		////////////////////////////===COMPOSITE===////////////////////
		System.out.println();
		System.out.println("---------------COMPOSITE---------------");
		Angajat CEO = new Angajat("Camelia","CEO", 30000);		
		Angajat headSales = new Angajat("Marian","Head Sales", 20000);
		Angajat headMarketing = new Angajat("Mihai","Head Marketing", 20000);
		Angajat sales1 = new Angajat("Bob","Sales", 10000);
		Angajat sales2 = new Angajat("Rob","Sales", 10000);		
		CEO.adaugaSubordonat(headSales);
		CEO.adaugaSubordonat(headMarketing);		
		headSales.adaugaSubordonat(sales1);
		headSales.adaugaSubordonat(sales2);		
		for(Angajat sef : headSales.getSubordonati()){
			System.out.println(sef.toString());			
			for(Angajat angajat : sef.getSubordonati())
				System.out.println(angajat.toString());
		}	
		
		////////////////////////////////===FACTORY===//////////////////
		// 1:Dacia
		// 2:Open
		// 3:Volvo
		System.out.println();
		System.out.println("---------------FACTORY---------------");
		Dacia dacia=(Dacia) new MasinaFactory().creazaMasina(1, 1994, 10000,"dacia1");
		Volvo volvo=(Volvo) new MasinaFactory().creazaMasina(3, 2000, 15000,"volvo1");
		Opel opel=(Opel) new MasinaFactory().creazaMasina(2, 2005, 30000,"opel1");
		dacia.afisare();
		volvo.afisare();
		opel.afisare();
		
		m1.adaugareMasina(dacia);
		m1.adaugareMasina(volvo);
		m1.adaugareMasina(opel);
		
		
		//////////////////////===PROTOTYPE===///////////////////////////
		System.out.println();
		System.out.println("---------------PROTOTYPE---------------");
		ArhivaMasini.arhiveazaMasina(dacia);
		ArhivaMasini.arhiveazaMasina(volvo);
		ArhivaMasini.arhiveazaMasina(opel);
		ArhivaMasini.getMasina("dacia1");
		ArhivaMasini.getMasina("volvo1");
		
		///////////////////////===BUILDER===//////////////
		System.out.println();
		System.out.println("---------------BUILDER---------------");
		Client clientDacia=new Client.Builder("Toma Camelia", 22,dacia)
				.adaugaAdresa("Pitesti")
				.adaugaCNP("2940826033333")
				.build();
		System.out.println(clientDacia.toString());
		Client clientVolvo=new Client.Builder("Radulescu Andreea", 27,volvo)
				.adaugaAdresa("Bucuresti")
				.build();
		System.out.println(clientVolvo.toString());
		
		
		//////////////////////////===OBSERVER===/////////////////
		System.out.println();
		System.out.println("---------------OBSERVER---------------");
		Client clientOpel1=new Client.Builder("Radulescu Andrei", 27,opel)
				.adaugaAdresa("Bucuresti")
				.build();
		Client clientOpel2=new Client.Builder("Maria Andreea", 27,opel)
				.adaugaAdresa("Bucuresti")
				.build();
		dacia.adaugaAnunt("am adus alta masina dacia");
		volvo.adaugaAnunt(" am adus alta masina volvo");
		opel.adaugaAnunt("s-a intregistrat o masina noua");
		
		//////////////////////////////===State===////////////////////
		System.out.println();
		System.out.println("---------------STATE---------------");
		Stare abordare=new AbordeazaClient();
		abordare.actiune(sales1,volvo);
		abordare.actiune(sales2,dacia);
		
		Stare convingere= new ConvingereaClientului();
		convingere.actiune(sales1,volvo);

		Stare refuzare=new RefuzareaMasinii();
		refuzare.actiune(sales2,dacia);
		
		
		////////////////////////===STRATEGY===////////////////
		System.out.println();
		System.out.println("---------------STRATEGY---------------");
		ModPlata numerar=new PlataNumerar(clientVolvo);
		volvo.plateste(numerar);
		m1.stergeMasina(volvo);		
		m1.afisareMasini();
		

		//////////////////////////===TEMPLATE===/////////////////////
		System.out.println();
		System.out.println("---------------TEMPLATE---------------");
		ActualizareActe acte=new PlataNumerar(clientVolvo);
		acte.actualizareDocumente();
		
		
	
	}
}
