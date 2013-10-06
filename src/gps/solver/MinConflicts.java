package gps.solver;

import gps.Range;
import gps.statemanager.LocalStateManager;
import java.util.ArrayList;

public class MinConflicts extends ConstraintBasedLocalSearch {        
    
    /* METHODS */   
    
    /**
     * Constructor
     */
    /*public MinConflicts(LocalStateManager stateManager, int varCount, Range values) {
        super(stateManager, varCount, values);
    } */
	public MinConflicts(LocalStateManager stateManager, int varCount, Range values) {
        super(stateManager);
	}
    
    /**     
     * @param varCount  Number of variables
     * @param range     Allowed range of variables' values
     * @return List of variables with assigned values representing the solution.
     */
    public ArrayList solve(int maxIterations) {                                        
        
        // Initial puzzle state - randomly initializaes the variables
        stateManager.initialize(variables, values);        
        
        // Main loop
//        while()
        
        return variables;
    }
    
    // TODO debug
    public void printVariables() {
        for(int v: variables) {
            System.out.print(v);
            System.out.print(" ");
        }
    }
}
