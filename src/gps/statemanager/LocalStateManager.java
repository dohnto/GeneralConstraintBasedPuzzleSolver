package gps.statemanager;

import gps.Range;

import java.util.ArrayList;
import java.util.Random;

public abstract class LocalStateManager {

	/* ATRIBUTES */

	protected int size; // number of variables
	protected Range domain = new Range(0, 0); // variables' domain

	/* METHODS */

	public LocalStateManager(int size, Range domain) {
		this.size = size;
		this.domain = domain;
	}

	public abstract ArrayList<Integer> getRandomNeighbour(
			ArrayList<Integer> state);

	public abstract ArrayList<Integer> getInteligentNeighbour(
			ArrayList<Integer> state, int variable);

	public abstract double evaluateState(ArrayList<Integer> state);

	public abstract void printState(ArrayList<Integer> state);

	/**
	 * Randomly initializes a state of the puzzle.
	 * 
	 * @return
	 */
	public ArrayList<Integer> getInitialState() {
		ArrayList<Integer> state = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			state.add(getRandomInt(domain.begin(), domain.end()));
		}

		return state;
	}

	public static int getRandomInt(int min, int max) {
		Random r = new Random();
		return min + (int) r.nextInt(max - min + 1);
	}

	public abstract ArrayList<Integer> getConflicts(ArrayList<Integer> state);
}
