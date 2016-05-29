package Junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Builder.Client;
import Composite.Angajat;
import Factory.Dacia;
import Factory.MasinaFactory;
import Prototype.ArhivaMasini;
import Singletone.Magazin;
import State.AbordeazaClient;
import State.ConvingereaClientului;
import State.Stare;
import Strategy.ModPlata;
import Strategy.PlataNumerar;

public class Testare {
	public Dacia masina;
	
	@Test
	public void testAngajati(){
		Angajat CEO = new Angajat("Mihaela","Management",5000);		
		Angajat manager1 = new Angajat("Mirela","Manager Vanzari",3500);
		Angajat manager2 = new Angajat("Maria", "Manager Departament",2000);
		Angajat vanzator = new Angajat("Mircea","Vanzator",788);
		CEO.adaugaSubordonat(manager1);
		CEO.adaugaSubordonat(manager2);		
		manager2.adaugaSubordonat(vanzator);
		Assert.assertEquals(1, manager2.subordonati.size());
	}
	
	@Before
	public void testCreareMasina(){
		masina=(Dacia) new MasinaFactory().creazaMasina(1, 1994, 10000,"dacia1");
		Assert.assertNotEquals(19999, 1994);

	}
	
	@Test
	public void testClient(){		
		Client client=new Client.Builder("Popescu", 22, masina).adaugaCNP("2990929095900").build();
		Assert.assertEquals(13, client.cnp.length());
	}
	
	@Test
	public void testStareAbordareClient(){
		Angajat vanzator = new Angajat("Mircea","Vanzator",788);
		Stare abordare=new AbordeazaClient();
		abordare.actiune(vanzator,masina);
		Assert.assertEquals("Stare de abordare",abordare.toString());		
	}
	
	@Test
	public void testConvingereClient(){
		Angajat vanzator = new Angajat("Mircea","Vanzator",788);
		Stare convingere= new ConvingereaClientului();
		convingere.actiune(vanzator,masina);
		Assert.assertEquals("Stare vanzarea masinii", convingere.toString());
	}
	
	@Test
	public void testPlatireMasina(){
		Client client=new Client.Builder("Popescu", 22, masina).adaugaCNP("2990929095900").build();
		ModPlata numerar=new PlataNumerar(client);
		masina.plateste(numerar);
		Assert.assertEquals(10000, masina.pretVanzare);
	}
	
	@Test
	public void testSubalterni(){
		Angajat CEO = new Angajat("Mihaela","Management",5000);		
		Angajat manager1 = new Angajat("Mirela","Manager Vanzari",3500);
		CEO.adaugaSubordonat(manager1);		
		Assert.assertEquals("Mirela", CEO.subordonati.get(0).nume);		
	}
	
	@Test
	public void testPrototype() throws CloneNotSupportedException{
		ArhivaMasini.arhiveazaMasina(masina);
		Assert.assertEquals(masina.getClass(),ArhivaMasini.getMasina("dacia1").getClass());
	}
	
	@Test
	public void testSingletone(){
		Magazin m1=Magazin.getInstance();
		Magazin m2=Magazin.getInstance();
		boolean check=false;
		if(m1==m2){
			check=true;
		}
		Assert.assertEquals(true, check);
	}
	
	@Test
	public void testAfisareAnuntPentruOMasina(){
		masina.adaugaAnunt("anuntul se adauga");
		boolean check=false;
		check=Dacia.anunturiDacia.contains("anuntul se adauga");
		Assert.assertEquals(true, check);
	}

}
