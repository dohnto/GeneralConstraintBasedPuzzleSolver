package gps.solver;

import gps.Range;
import gps.statemanager.graphcolor.GraphColorStateManager;

public class GraphColorMC extends MinConflicts {
    
    /* METHODS */
    public GraphColorMC(int size, Range domain) throws Exception {
        super(new GraphColorStateManager(size, domain));
    }
}