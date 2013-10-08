package gps.solver;

import gps.Range;
import gps.statemanager.kqueens.KQueensStateManager;
import java.util.ArrayList;

public class KQueensMC extends MinConflicts {    
    
    /**
     * Constructor
     * @param size
     * @param domain 
     */
    public KQueensMC(int size, Range domain) {
        super(new KQueensStateManager(size, domain));        
    }    
}
