package mi_hazi;

public class Parkolo {
	public int hossz;
	public int szel;
	public int szelfoglalt = 0;
	public int[][] hely;
	
	public Parkolo(int hossz,int szel) {
		this.szel = szel;
		this.hossz = hossz;
		this.szelfoglalt = 0;
		this.hely = new int [hossz][szel];
		for (int i = 0; i < hossz; i++) {
			for (int j = 0; j < szel; j++) {
				hely[i][j] = 0;
			}
		}
	}
	
	public void addLinearis(Auto a) {
		if(a.szel > a.hossz) a.forgatAuto();
		if (szelfoglalt + a.szel <= szel & a.hossz <= hossz) {
			for (int i = 0; i < a.hossz; i++) {
				for (int j = szelfoglalt; j < szelfoglalt + a.szel; j++) {
					hely[i][j] = a.sajatszam;
				}
			}
			szelfoglalt += a.szel;
		} else if ( szelfoglalt + a.hossz <= szel & a.szel <= hossz) {
			a.forgatAuto();
			for (int i = 0; i < a.hossz; i++) {
				for (int j = szelfoglalt; j < szel + a.szel; j++) {
					hely[i][j] = a.sajatszam;
				}
			}
			szelfoglalt += a.szel;
		} else
			System.out.println("Tul nagy az auto,nem fer el a parkoloban!");
		
		
	}
	
	public void addKeresve(Auto a) {
		int offsetSzel = 0;
		int offsetHossz = hossz -1;
		int szamlalo = 0;
		boolean kereses = true;
		while (kereses) {
			if (offsetHossz - a.hossz + 1 >= 0 & offsetSzel + a.szel <= szel ) {
				for (int i = offsetHossz; i > offsetHossz - a.hossz; i-- ) {
					for (int j = offsetSzel; j < offsetSzel + a.szel; j++) {
						if(hely[i][j] == 0 ) szamlalo++;
					}
				}
				int szaml = szamlalo;
				szamlalo = 0;
				
				if (szaml == a.terulet) {
					for (int i = offsetHossz; i > offsetHossz - a.hossz; i-- ) {
						for(int j = offsetSzel; j < offsetSzel + a.szel; j++) {
							hely[i][j] = a.sajatszam;
						}
					}
					kereses = false;
				}
			}
			if (kereses) {
			 if (offsetSzel < szel -1 & offsetHossz > 0)
				offsetSzel++;
			 else if (offsetSzel == szel - 1  & offsetHossz > 0) {
				offsetSzel = 0;
				offsetHossz--;
			} else if (offsetHossz == 0 & a.voltforgatva == false ) {
				a.forgatAuto();
				a.voltforgatva = true;
				offsetHossz = hossz - 1;
				offsetSzel = 0;
				
			} else kereses = false;
			}
		}
	}
	

	public void addAuto(Auto a) {
		if (szelfoglalt + a.szel <= szel | szelfoglalt + a.hossz <= szel )
			addLinearis(a);
		else
			addKeresve(a);
		
	}

	
	public void printParkolo() {
		for (int i = 0; i < hossz; i++) {
			for (int j = 0; j < szel; j++) {
				if (j < szel - 1) {
					System.out.print(hely[i][j]);
					System.out.print('\t');
				}
				else
				System.out.println(hely[i][j]);
			}
			if (i < hossz - 1)
			System.out.println();
		}

	}
}


