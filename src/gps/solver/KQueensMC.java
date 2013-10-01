package gps.solver;

import gps.Range;
import gps.statemanager.KQueensStateManager;
import java.util.ArrayList;

public class KQueensMC extends MinConflicts {    
    
    /* METHODS */
    
    /**
     * Constructor
     */
    public KQueensMC(int varCount, Range r) {
        super(new KQueensStateManager(), varCount, r);        
    }
    
}
