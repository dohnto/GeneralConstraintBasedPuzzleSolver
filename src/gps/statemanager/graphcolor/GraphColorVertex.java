package gps.statemanager.graphcolor;

import java.util.ArrayList;

public class GraphColorVertex {
	static private int POS_X = 0;
	static private int POS_Y = 1;
	
	private int id;
	private double[] pos = new double[2];
	private ArrayList<Integer> neighbours = new ArrayList<Integer>();

	public GraphColorVertex(int id, Double posX, Double posY) {
		this.id = id;
		pos[POS_X] = posX;
		pos[POS_Y] = posY;
	}
	
	public double getPosX() {
		return pos[POS_X];
	}
	
	public double getPosY() {
		return pos[POS_Y];
	}

	public int getId() {
		return id;
	}
	
	public void addNeighbour(int neighbour) {
		neighbours.add(neighbour);
	}
	
	public void print() {
		System.out.println("Vertex: " + id + " = ["
				+ getPosX() + " " + getPosY() + "]");
		System.out.print("\t neighbours: ");
		for (Integer n: neighbours) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	public void print(Integer integer) {
		System.out.println("Vertex: " + id + " = " + integer);
		System.out.print("\t neighbours: ");
		for (Integer n: neighbours) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> getNeighbours() {
		return neighbours;
	}

}
