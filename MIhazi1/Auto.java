package mi_hazi;

public class Auto {
	protected int hossz;
	protected int szel;
	protected Integer okosHossz;
	protected  int terulet;
	protected boolean voltforgatva = false;
	protected static int szam = 1;
	protected int sajatszam;
	
	public Auto(int hossz,int szel) {
		this.hossz = hossz;
		this.szel = szel;
		this.terulet = szel*hossz;
		this.okosHossz = hossz;
		this.sajatszam = szam;
		szam++;
	}
	public void  forgatAuto() {
		okosHossz = szel;
		int temp = hossz;
		hossz= szel;
		szel = temp;
	}
}

