package gps.statemanager;

import gps.Range;

import java.util.ArrayList;
import java.util.Random;

public abstract class LocalStateManager {

	// TODO return type not void

	/**
	 * Randomly initializes the state of the puzzle.
	 */
	public void initialize(ArrayList<Integer> variables, Range range) { // TODO
																		// DELETE
		for (int i = 0; i < variables.size(); i++) {
			variables.set(i, rand(range.begin(), range.end()));
		}
	}

	/**
	 * Generates random neighbour
	 * 
	 * @param state
	 *            as a template
	 * @return randomly changed given state
	 */
	public ArrayList<Integer> /* abstract */getRandomNeighbour(
			ArrayList<Integer> state) { // TODO abstract
		return new ArrayList<Integer>();
	}

	public ArrayList<ArrayList<Integer>> getRandomNeighbour(
			ArrayList<Integer> state, int count) {
		ArrayList<ArrayList<Integer>> neighbours = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < count; i++) {
			neighbours.add(getRandomNeighbour(state));
		}
		return neighbours;
	}

	// TODO abstract
	public void getInteligentNeighbour(ArrayList<Integer> state) {

	}

	public double evaluateState(ArrayList<Integer> state) { // TODO abstract
		return 0;
	}

	public void displayState(ArrayList<Integer> state) { // TODO abstract

	}

	/**
	 * Returns integer value in the range <min, max)
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private int rand(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	public void printState() {// TODO abstract

	}

	public void printState(ArrayList<Integer> variables) { // TODO abstract
	}

	public ArrayList<Integer> getInitialState() { // TODO abstract
		return new ArrayList<Integer>();
	}

	public static int getRandomInt(int min, int max) {
		Random r = new Random();
		return min + (int) r.nextInt(max - min + 1);
	}
}
