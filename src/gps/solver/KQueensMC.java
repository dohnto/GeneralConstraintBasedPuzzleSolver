package gps.solver;

import gps.Range;
import gps.statemanager.kqueens.KQueensStateManager;
import java.util.ArrayList;

public class KQueensMC extends MinConflicts {    
    
    /* METHODS */
    
    /**
     * Constructor
     */
    public KQueensMC(int size, Range r) {
        super(new KQueensStateManager(), size, r);        
    }
    
}
