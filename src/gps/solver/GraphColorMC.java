package gps.solver;

import gps.Range;
import gps.statemanager.GraphColorStateManager;

public class GraphColorMC extends MinConflicts {
    
    /* METHODS */
    public GraphColorMC(int varCount, Range r) {
        super(new GraphColorStateManager(), varCount, r);
    }
}
