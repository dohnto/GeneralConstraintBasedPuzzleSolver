package gps.solver;

import gps.Range;
import gps.statemanager.kqueens.KQueensStateManager;
import java.util.ArrayList;

public class KQueensMC extends MinConflicts {    
    
    /* METHODS */
    
    /**
     * Constructor
     */
    public KQueensMC(int size, Range domain) {
        super(new KQueensStateManager(size, domain));        
    }
    
}
