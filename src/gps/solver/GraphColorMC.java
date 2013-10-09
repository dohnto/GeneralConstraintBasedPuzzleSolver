package gps.solver;

import java.util.Vector;

import gps.Range;
import gps.statemanager.graphcolor.GraphColorStateManager;
import gps.statemanager.graphcolor.GraphColorVertex;
import java.util.ArrayList;

public class GraphColorMC extends MinConflicts {
    
    /* METHODS */
    public GraphColorMC(Vector<GraphColorVertex> vertices, Range domain) throws Exception {
        super(new GraphColorStateManager(vertices, domain));
    }
}