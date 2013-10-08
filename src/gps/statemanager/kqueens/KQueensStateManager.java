package gps.statemanager.kqueens;

import gps.statemanager.LocalStateManager;
import java.util.ArrayList;
import gps.Range;

public class KQueensStateManager extends LocalStateManager {

    /* METHODS */
    /**
     * Randomly initializes a state of the puzzle.
     *
     * @param state
     * @param size
     * @param values
     * @return
     */
    public void getInitialState(ArrayList<Integer> state, int size, Range values) {
        for (int i = 0; i < size; i++) {
            state.set(i, rand(values.begin(), values.end()));
        }
    }

    public ArrayList<Integer> getConflictVars(ArrayList<Integer> vars) {
        ArrayList<Integer> conflVars = new ArrayList<>();

        return conflVars;
    }
    
    public void printState(ArrayList<Integer> state) {
        
    }
}
