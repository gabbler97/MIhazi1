package mi_hazi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		String line =  null;
		line = br.readLine();
		String[] meret = line.split("\t");
		int hossz = Integer.parseInt(meret[0]);
		int szel = Integer.parseInt(meret[1]);
		Parkolo p = new Parkolo(hossz,szel);
		line = br.readLine();
		int kocsiszam = Integer.parseInt(line);
		int i = 0;
		LinkedList<Auto> autosor = new LinkedList<Auto>();
		while (i < kocsiszam ) {
			line = br.readLine();
			String[] automeret = line.split("\t");
			Auto a = new Auto(Integer.parseInt(automeret[0]), Integer.parseInt(automeret[1]));
			autosor.add(a);
			i++;
		}
		Collections.sort(autosor, new AutoCompare());
	     Iterator<Auto> iterator=autosor.descendingIterator();
	     while(iterator.hasNext())
	       p.addAuto(iterator.next());
	     p.printParkolo();
	}
}
