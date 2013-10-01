package gps;

import gps.solver.*;
import gps.statemanager.*;

public class GeneralPuzzleSolver {

	public static void main(String[] args) {
		// TODO Automaticky generovaný stub metody
		System.out.println("hello");
                
                // TODO zpracovani parametru                
                
                // TODO mozna textove/graficke UI pro ovladani programu 
                // - vyber uloh?
                
                // TODO - delete - just test
                KQueensMC kqMC = new KQueensMC(10, new Range(5, 12));
                kqMC.solve(1000);
                kqMC.printVariables();
	}
}
