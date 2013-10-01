package gps.solver;

import gps.Range;
import gps.statemanager.LocalStateManager;
import java.util.ArrayList;

public class MinConflicts extends ConstraintBasedLocalSearch {        
    
    /* METHODS */   
    
    /**
     * Constructor
     */
    public MinConflicts(LocalStateManager _stateManager, int varCount, Range _values) {
        stateManager = _stateManager;
        values       = _values;                
        for(int i = 0; i < varCount; i++) {
            variables.add(0);
        }                
    }   
    
    /**     
     * @param varCount  Number of variables
     * @param range     Allowed range of variables' values
     * @return List of variables with assigned values representing the solution.
     */
    public ArrayList solve(int maxIterations) {                                        
        
        // Initial puzzle state - randomly initializaes the variables
        stateManager.Initialize(variables, values);        
        
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
