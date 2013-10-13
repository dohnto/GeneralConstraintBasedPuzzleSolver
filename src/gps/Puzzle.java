package gps;

public enum Puzzle {
	KQueens("KQ"), 
	GraphColoring("GC"),
	MS("MS");

	private String puzzle;

	private Puzzle(String puzzle) {
		this.puzzle = puzzle;
	}

	public String getKey() {
		return puzzle;
	}

}
