package gps.statemanager.kqueens;

import gps.statemanager.LocalStateManager;
import java.util.ArrayList;
import gps.Range;
import java.util.HashSet;

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
        
        System.out.print(state + "\n");
        
        return state;
    }
    
    @Override
    public ArrayList<Integer> getConflicts(ArrayList<Integer> state) {
        HashSet conflicts = new HashSet();
        
        for(int qi = 0; qi < size; qi++) {            
            for(int qj = qi + 1; qj < size; qj++) {                
                // check conflicts - 2 queens in the same column or diagonal
                if((state.get(qi) ==  state.get(qj)) || 
                   (state.get(qi) == (state.get(qj) + Math.abs(qi - qj))) ||
                   (state.get(qi) == (state.get(qj) - Math.abs(qi - qj)))) {
                    
                    conflicts.add(qi);
                    conflicts.add(qj);
                }
            }
        }
        
        return new ArrayList(conflicts);
    }
        
    @Override
    public ArrayList<Integer> getInteligentNeighbour(ArrayList<Integer> state, 
                                                     int variable) {
        ArrayList<Integer> newState = new ArrayList(state);
        
        
        
        return state;
    }
    
    @Override
    public void printState(ArrayList<Integer> state) {
        // 1st line:
        // + - - - - - - - - - +
        System.out.format("+ ");
        for (int i = 0; i < size; i++) {
            System.out.format("- ");
        }
        System.out.format("+%n");

        // 2nd - "size+1"th line
        for (int i = 0; i < size; i++) {
            System.out.format("| ");
            for (int j = 0; j < size; j++) {
                System.out.format((state.get(i) == j) ? "X " : ". ");
            }
            System.out.format("|%n");
        }

        // last line
        // + - - - - - - - - - +
        System.out.format("+ ");
        for (int i = 0; i < size; i++) {
            System.out.format("- ");
        }
        System.out.format("+%n");
    }
}
