package gps.solver;

import gps.Range;
import gps.statemanager.graphcolor.GraphColorStateManager;

public class GraphColorMC extends MinConflicts {
    
    /* METHODS */
    public GraphColorMC(int varCount, Range r) throws Exception {
        super(new GraphColorStateManager("pes"), varCount, r);
    }
}