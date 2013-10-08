package gps.statemanager.graphcolor;

import gps.statemanager.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import sun.awt.VerticalBagLayout;

import gps.Range;

public class GraphColorStateManager extends LocalStateManager {

	private int COLORS = 4;

	// vertices
	Vector<GraphColorVertex> vertices = new Vector<GraphColorVertex>();

        // TODO !!!
        String filename;
        
	//public GraphColorStateManager(String filename) throws Exception {
	public GraphColorStateManager(int size, Range domain) throws Exception {
		//super(); // TODO poslat do super() size a domain
                super(size, domain);
		if (!GraphColorParser.parse(filename, vertices)) {
			throw new Exception("Graph color parser cannot parse input file.");
		}

	}

        @Override
	public ArrayList<Integer> getInitialState() {
		ArrayList<Integer> state = new ArrayList<Integer>(size);
//		for (int i = 0; i < vertices.size(); i++) {
		for (int i = 0; i < size; i++) {
			state.add(getRandomColor());
		}
		return state;
	}

	public ArrayList<Integer> getRandomNeighbour(ArrayList<Integer> state) {
		ArrayList<Integer> neighbour = new ArrayList<Integer>(state);
		int index = getRandomInt(0, state.size() - 1);
		neighbour.set(index, getRandomColor());
		return neighbour;
	}

	public void getInteligentNeighbour(ArrayList<Integer> state) {

	}

	public double evaluateState(ArrayList<Integer> state) {
		double sum = 0;
		for (int i = 0; i < vertices.size(); ++i) {
			GraphColorVertex v = vertices.get(i);
			int color = state.get(i);
			for (int neighbourIndex : v.getNeighbours()) {
				if (color == state.get(neighbourIndex)) {
					sum += 0.5;
				}
			}
		}

		return sum;
	}

	public void displayState(ArrayList<Integer> state) {

	}

	public void printState() {
		System.out.println("----------------------------------");
		if (vertices != null) {
			for (GraphColorVertex v : vertices) {
				v.print();
			}
		}
	}

	public void printStateX(ArrayList<Integer> variables) {
		System.out.println("----------------------------------");

		if (vertices != null) {
			if (vertices.size() != variables.size()) {
				System.err
						.println("GraphColorStateManager::printState: variables size ("
								+ variables.size()
								+ ") != vertices size ("
								+ vertices.size() + ")");
				return;
			}
			for (int i = 0; i < vertices.size(); i++) {
				GraphColorVertex v = vertices.get(i);
				v.print(variables.get(i));
			}
		}
		System.out.println("Objective function of this state is "
				+ evaluateState(variables));
	}

	public int getRandomColor() {
		return getRandomInt(0, COLORS - 1);
	}

	public void printState(ArrayList<Integer> state) {
		final String[] colors = { "#0066B3", "#FFE500", "#00CC00", "#CCCC00" };

		System.out.println("graph {");
		System.out.println("rankdir = LR;");
		for (int i = 0; i < state.size(); i++) {
			System.out.println("\t\"" + i + " [" + state.get(i) + "]\""
					+ " [style = \"filled\",fillcolor = \""
					+ colors[state.get(i)] + "\"]");
		}
		for (int i = 0; i < state.size(); i++) {
			GraphColorVertex v = vertices.get(i);
			for (int neigh : v.getNeighbours()) {
				if (neigh > i) {
					System.out.println("\t\"" + i + " [" + state.get(i)
							+ "]\" -- \"" + neigh + " [" + state.get(neigh)
							+ "]\"");
				}
			}
		}
		System.out.println("}");
	}
}
