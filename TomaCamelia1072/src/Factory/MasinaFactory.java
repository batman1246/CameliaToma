package Factory;



public class MasinaFactory {
	public Masina creazaMasina(int numar,int an, int pret,String nume){
		switch(numar){
		case 1: return new Dacia(nume,an,pret);
		case 2: return new Opel(nume,an,pret);
		case 3: return new Volvo(nume,an,pret);
		}
		return null;
	}
}
