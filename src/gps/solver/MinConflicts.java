package gps.solver;

import gps.Range;
import gps.statemanager.LocalStateManager;
import java.util.ArrayList;

public class MinConflicts extends ConstraintBasedLocalSearch {        
    
    /* METHODS */   
    
    /**
     * Constructor
     * @param stateManager
     * @param size number of variables
     * @param values range of allowable values for state varibles
     */     
    public MinConflicts(LocalStateManager stateManager) {
        super(stateManager);
    }	
    
    /**     
     * @param varCount  Number of variables
     * @param range     Allowed range of variables' values
     * @return List of variables with assigned values representing the solution.
     */
    @Override
    public ArrayList solve(int maxIterations) {                                                
        // Initial puzzle state - randomly initializaes the variables
        state = stateManager.getInitialState();
        
        // Main loop
//        while()
        
        stateManager.printState(state);
        
        return state;
    }    
}
