package gps.solver;

import gps.statemanager.graphcolor.GraphColorStateManager;

public class GraphColorSA extends SimulatedAnnealing {
    
	public GraphColorSA(String filename) throws Exception {
		super(new GraphColorStateManager(filename));
	}

	
}
