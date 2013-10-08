package gps.statemanager.kqueens;

import gps.statemanager.LocalStateManager;
import java.util.ArrayList;
import gps.Range;

public class KQueensStateManager extends LocalStateManager {

    /* METHODS */
    public KQueensStateManager(int size, Range domain) {
        super(size, domain);
    }

    /**
     * Randomly initializes a state of the puzzle.
     *
     * @param state
     * @param size
     * @param values
     * @return
     */
    @Override
    public ArrayList<Integer> getInitialState() {
        ArrayList<Integer> state = new ArrayList<>(size);        
        for (int i = 0; i < size; i++) {
            state.add(rand(domain.begin(), domain.end()));
        }
        return state;
    }

    public ArrayList<Integer> getConflictVars(ArrayList<Integer> vars) {
        ArrayList<Integer> conflVars = new ArrayList<>();

        return conflVars;
    }
    
    @Override
    public void printState(ArrayList<Integer> state) {
        System.out.println("Checkerboard");
    }
}
