package gps.solver;

import gps.statemanager.graphcolor.GraphColorStateManager;
import gps.Range;

public class GraphColorSA extends SimulatedAnnealing {

    public GraphColorSA(int size, Range domain) throws Exception {
        //public GraphColorSA(String filename) throws Exception {
        // TODO !!
        //super(new GraphColorStateManager(filename));
        super(new GraphColorStateManager(size, domain));
    }
}
