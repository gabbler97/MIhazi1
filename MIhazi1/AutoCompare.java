package mi_hazi;

import java.util.Comparator;

public class AutoCompare implements Comparator<Auto> {
		    @Override
		    public int compare(Auto a1, Auto a2) {
		        if(a1.szel > a1.hossz) a1.forgatAuto();
		        if(a2.szel > a2.hossz) a2.forgatAuto();
		    	return a1.okosHossz.compareTo(a2.okosHossz);
		    }
	}

