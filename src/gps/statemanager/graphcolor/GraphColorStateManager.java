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
import java.lang.reflect.Array;

public class GraphColorStateManager extends LocalStateManager {
	Range domain;
	// vertices
	Vector<GraphColorVertex> vertices;

	// public GraphColorStateManager(String filename) throws Exception {
	public GraphColorStateManager(Vector<GraphColorVertex> vertices,
			Range domain) throws Exception {
		super(vertices.size(), domain);
		this.vertices = vertices;
		this.domain = domain;
	}

	public ArrayList<Integer> getRandomNeighbour(ArrayList<Integer> state) {
		ArrayList<Integer> neighbour = new ArrayList<Integer>(state);
		int index = getRandomInt(0, state.size() - 1);
		neighbour.set(index, getRandomInt(domain.begin(), domain.end()));
		return neighbour;
	}

        @Override
	public ArrayList<Integer> getInteligentNeighbour(ArrayList<Integer> state, 
                                                         int conflictVertex) {
            return null;
	}

	public double evaluateState(ArrayList<Integer> state) {
		double sum = 0;
		for (int i = 0; i < size; ++i) {
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

//	public int getRandomColor() {
//		return getRandomInt(domain.begin(), domain.end());
//	}

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

    @Override
    public ArrayList<Integer> getConflicts(ArrayList<Integer> state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
