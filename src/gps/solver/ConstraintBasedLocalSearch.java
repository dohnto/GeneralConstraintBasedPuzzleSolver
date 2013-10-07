package gps.solver;

import gps.Range;
import gps.statemanager.LocalStateManager;
import java.util.ArrayList;

public abstract class ConstraintBasedLocalSearch {
    
    /* PROPERTIES */
    
    protected LocalStateManager   stateManager;                     // state manager      
    protected ArrayList<Integer>  variables = new ArrayList<>();    // variables
    protected Range               values    = new Range(0, 0);      // values range
    
    
    /* METHODS */
    public abstract ArrayList solve(int maxIterations);                                        
    
    /**
     * Cosntructor
     */
    public ConstraintBasedLocalSearch() {
        
    }
    
    
}
