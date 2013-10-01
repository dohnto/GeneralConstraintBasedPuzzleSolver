package gps.statemanager;

import gps.Range;
import java.util.ArrayList;

public abstract class LocalStateManager {

	// TODO return type not void
    
        /**
         * Randomly initializes the state of the puzzle.
         */
	public void Initialize(ArrayList<Integer> variables, Range range) {
            for(int i = 0; i < variables.size(); i++) {                
                variables.set(i, rand(range.begin(), range.end()));
            }
        }             
        
	//public abstract void getRandomNeighbour(state);
	//public abstract void getRandomNeighbour(state, count);
	//public abstract void getInteligentNeighbour(state);
	//public abstract int  evaluateState(state);
	//public abstract void displayState(state);
        
        /**
         * Returns integer value in the range <min, max>
         * @param min
         * @param max
         * @return 
         */
        private int rand(int min, int max) {
            return (int)(min + Math.random() * (max - min + 1));
        }
}
